package com.tfssoft.qinling.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tfssoft.qinling.base.controller.BaseController;
import com.tfssoft.qinling.user.domain.User;
import com.tfssoft.qinling.user.domain.UserThirdPartyVO;
import com.tfssoft.qinling.user.domain.UserVO;
import com.tfssoft.qinling.user.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = { "User" }, description = "Api list")
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

	@Autowired
	private UserService userService;

	@ApiOperation(value = "用户登录", httpMethod = "POST")
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
	public void postThirdPartyUserLogin(@RequestBody UserThirdPartyVO user, HttpServletRequest request, HttpServletResponse response) {
		try {
			User instance = userService.userThirdPartyLogin(user);
			writeJson(instance, response);
		} catch (Exception e) {
			e.printStackTrace();
			error("登录失败！", response);
		}
	}

}
