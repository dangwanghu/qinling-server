package com.tfssoft.qinling.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tfssoft.qinling.base.controller.BaseController;
import com.tfssoft.qinling.user.domain.BindingPhoneVO;
import com.tfssoft.qinling.user.domain.ResetPasswordVO;
import com.tfssoft.qinling.user.domain.User;
import com.tfssoft.qinling.user.domain.UserPhoneVO;
import com.tfssoft.qinling.user.domain.UserThirdPartyVO;
import com.tfssoft.qinling.user.domain.UserVO;
import com.tfssoft.qinling.user.service.UserService;
import com.tfssoft.qinling.web.CacheManager;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = { "User" }, description = "Api list")
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private CacheManager cacheManager;

	@ApiOperation(value = "手机号密码登录", httpMethod = "POST")
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public void postUserLogin(@RequestBody UserVO user, HttpServletRequest request, HttpServletResponse response) {
		try {
			User instance = userService.userLogin(user.getPhone(), user.getPassword());
			if (null != instance) {
				writeJson(instance, response);
			} else {
				error("用户名或密码错误", response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			error("登录失败！", response);
		}
	}

	@ApiOperation(value = "第三方登录", httpMethod = "POST")
	@RequestMapping(value = "/thirdparty/login", method = RequestMethod.POST)
	public void postThirdPartyUserLogin(@RequestBody UserThirdPartyVO user, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			User instance = userService.userThirdPartyLogin(user);
			writeJson(instance, response);
		} catch (Exception e) {
			e.printStackTrace();
			error("登录失败！", response);
		}
	}

	@ApiOperation(value = "手机验证码登录", httpMethod = "POST")
	@RequestMapping(value = "/phone/login", method = RequestMethod.POST)
	public void postPhoneUserLogin(@RequestBody UserPhoneVO uPVO, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			// validate code
			Object val = cacheManager.get("phone_" + uPVO.getPhone());
			if (null == val || !uPVO.getCode().equals(val.toString())) {
				writeJson("验证码错误", response);
			} else {
				User instance = userService.phoneUserLogin(uPVO.getPhone());
				writeJson(instance, response);
			}
			cacheManager.del("phone_" + uPVO.getPhone());
		} catch (Exception e) {
			e.printStackTrace();
			error("登录失败！", response);
		}
	}

	@ApiOperation(value = "绑定手机号", httpMethod = "POST")
	@RequestMapping(value = "/binding/phone", method = RequestMethod.POST)
	public void postBindingPhone(@RequestBody BindingPhoneVO bPVo, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			// validate code
			Object val = cacheManager.get("phone_" + bPVo.getPhone());
			if (null == val || !bPVo.getCode().equals(val.toString())) {
				error("验证码错误", response);
			} else {
				String responseMsg = userService.bindingPhone(bPVo.getUserId(), bPVo.getPhone());
				if (null != responseMsg) {
					error(responseMsg, response);
				} else {
					success("绑定成功", response);
				}
			}
			cacheManager.del("phone_" + bPVo.getPhone());
		} catch (Exception e) {
			e.printStackTrace();
			error("绑定失败！", response);
		}
	}
	
	@ApiOperation(value = "重置密码", httpMethod = "POST")
	@RequestMapping(value = "/reset/password", method = RequestMethod.POST)
	public void postResetPassword(@RequestBody ResetPasswordVO rPVO, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			// validate code
			Object val = cacheManager.get("phone_" + rPVO.getPhone());
			if (null == val || !rPVO.getCode().equals(val.toString())) {
				error("验证码错误", response);
			} else {
				userService.resetPassword(rPVO.getUserId(), rPVO.getPassword());
			}
			cacheManager.del("phone_" + rPVO.getPhone());
		} catch (Exception e) {
			e.printStackTrace();
			error("修改失败！", response);
		}
	}


	@ApiOperation(value = "发送手机验证码", httpMethod = "POST")
	@RequestMapping(value = "/phone/code", method = RequestMethod.POST)
	public void postPhoneCode(@RequestBody @ApiParam(value = "phone", required = true) String phone,
			HttpServletRequest request, HttpServletResponse response) {
		try {
			String code = String.valueOf((int)((Math.random()*9+1)*1000));
			cacheManager.set("phone_" + phone, code, 300);
			
			// invoke thirdParty service to send the code

			writeJson(code, response);
		} catch (Exception e) {
			e.printStackTrace();
			error("发送失败！", response);
		}
	}

}
