package com.tfssoft.qinling.user.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tfssoft.qinling.base.controller.BaseController;
import com.tfssoft.qinling.user.domain.BindingPhoneVO;
import com.tfssoft.qinling.user.domain.Manager;
import com.tfssoft.qinling.user.domain.ManagerLoginVO;
import com.tfssoft.qinling.user.domain.ManagerPostVO;
import com.tfssoft.qinling.user.domain.NewPasswordVO;
import com.tfssoft.qinling.user.domain.ResetPasswordVO;
import com.tfssoft.qinling.user.domain.Role;
import com.tfssoft.qinling.user.domain.RolePostVO;
import com.tfssoft.qinling.user.domain.ThirdPartyBindingVO;
import com.tfssoft.qinling.user.domain.TopicCollectVO;
import com.tfssoft.qinling.user.domain.User;
import com.tfssoft.qinling.user.domain.UserActionPostVO;
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
				error("手机号或密码错误", response);
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

	@ApiOperation(value = "绑定第三方账号", httpMethod = "POST")
	@RequestMapping(value = "/binding/thirdparty/account", method = RequestMethod.POST)
	public void postThirdPartyAccount(@RequestBody ThirdPartyBindingVO tpbVO, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			User instance = userService.bindingThirdParty(tpbVO.getUserId(), tpbVO.getOpenId(), tpbVO.getOpenType());
			writeJson(instance, response);
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
				userService.resetPassword(rPVO.getPhone(), rPVO.getPassword());
				success("修改成功", response);
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
			String code = String.valueOf((int) ((Math.random() * 9 + 1) * 1000));
			cacheManager.set("phone_" + phone, code, 300);

			// invoke thirdParty service to send the code

			writeJson(code, response);
		} catch (Exception e) {
			e.printStackTrace();
			error("发送失败！", response);
		}
	}

	@ApiOperation(value = "用户收藏列表", httpMethod = "GET")
	@RequestMapping(value = "/collect/list", method = RequestMethod.GET)
	public void getUserCollectList(@RequestParam(value = "userId", required = true) String userId,
			HttpServletRequest request, HttpServletResponse response) {
		try {
			List<TopicCollectVO> actions = userService.getUserCollectList(userId);
			writeJson(actions, response);
		} catch (Exception e) {
			e.printStackTrace();
			error("查询失败！", response);
		}
	}

	@ApiOperation(value = "用户添加收藏", httpMethod = "POST")
	@RequestMapping(value = "/collect", method = RequestMethod.POST)
	public void postUserCollect(@RequestBody UserActionPostVO uapVO, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String errorMsg = userService.addUserCollect(uapVO);
			if (null != errorMsg) {
				error(errorMsg, response);
			} else {
				success("收藏成功", response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			error("收藏失败！", response);
		}
	}

	@ApiOperation(value = "用户删除收藏", httpMethod = "DELETE")
	@RequestMapping(value = "/collect", method = RequestMethod.DELETE)
	public void deleteUserCollect(@RequestBody List<UserActionPostVO> uapVOs, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			userService.deleteUserCollect(uapVOs);
			success("删除成功", response);
		} catch (Exception e) {
			e.printStackTrace();
			error("删除失败！", response);
		}
	}

	@ApiOperation(value = "修改密码", httpMethod = "PUT")
	@RequestMapping(value = "/change/password", method = RequestMethod.PUT)
	public void putChangePassword(@RequestBody NewPasswordVO npVO, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String errorMsg = userService.updatePassword(npVO.getUserId(), npVO.getOldPassword(), npVO.getPassword());
			if (null != errorMsg) {
				error(errorMsg, response);
			} else {
				success("修改成功", response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			error("修改失败！", response);
		}
	}
	
	@ApiOperation(value = "获取操作员列表", httpMethod = "GET")
	@RequestMapping(value = "/manager/list", method = RequestMethod.GET)
	public void getManagerList(@RequestParam(value = "skip", required = false) Integer skip,
			@RequestParam(value = "limit", required = false) Integer limit,
			@RequestParam(value = "name", required = false) String name, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			List<Manager> list = userService.getManagerList(skip, limit, name);
			writeJson(list, response);
		} catch (Exception e) {
			e.printStackTrace();
			error("查询失败！", response);
		}
	}

	@ApiOperation(value = "获取操作员总数", httpMethod = "GET")
	@RequestMapping(value = "/manager/total", method = RequestMethod.GET)
	public void getManagerCount(@RequestParam(value = "name", required = false) String name, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			long count = userService.getManagerCount(name);
			writeJson(count, response);
		} catch (Exception e) {
			e.printStackTrace();
			error("查询失败！", response);
		}
	}
	
	@ApiOperation(value = "新增操作员", httpMethod = "POST")
	@RequestMapping(value = "/manager", method = RequestMethod.POST)
	public void postManager(@RequestBody ManagerPostVO instance, HttpServletRequest request, HttpServletResponse response) {
		try {
			userService.addManager(instance);
			success("保存成功", response);
		} catch (Exception e) {
			e.printStackTrace();
			error("保存出错！", response);
		}
	}
	
	@ApiOperation(value = "修改操作员", httpMethod = "PUT")
	@RequestMapping(value = "/manager", method = RequestMethod.PUT)
	public void putManager(@RequestBody ManagerPostVO instance, HttpServletRequest request, HttpServletResponse response) {
		try {
			userService.updateManager(instance);
			success("更新成功", response);
		} catch (Exception e) {
			e.printStackTrace();
			error("更新出错！", response);
		}
	}
	
	@ApiOperation(value = "删除操作员", httpMethod = "DELETE")
	@RequestMapping(value = "/manager", method = RequestMethod.DELETE)
	public void deleteManager(@RequestParam(required = true) Integer id, HttpServletRequest request, HttpServletResponse response) {
		try {
			userService.deleteManager(id.intValue());
			success("删除成功", response);
		} catch (Exception e) {
			e.printStackTrace();
			error("删除出错！", response);
		}
	}
	
	@ApiOperation(value = "获取角色列表", httpMethod = "GET")
	@RequestMapping(value = "/role/list", method = RequestMethod.GET)
	public void getRoleList(@RequestParam(value = "skip", required = false) Integer skip,
			@RequestParam(value = "limit", required = false) Integer limit,
			@RequestParam(value = "name", required = false) String name, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			List<Role> list = userService.getRoleList(skip, limit, name);
			writeJson(list, response);
		} catch (Exception e) {
			e.printStackTrace();
			error("查询失败！", response);
		}
	}

	@ApiOperation(value = "获取角色总数", httpMethod = "GET")
	@RequestMapping(value = "/role/total", method = RequestMethod.GET)
	public void getRoleCount(@RequestParam(value = "name", required = false) String name, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			long count = userService.getRoleCount(name);
			writeJson(count, response);
		} catch (Exception e) {
			e.printStackTrace();
			error("查询失败！", response);
		}
	}
	
	@ApiOperation(value = "新增角色", httpMethod = "POST")
	@RequestMapping(value = "/role", method = RequestMethod.POST)
	public void postRole(@RequestBody RolePostVO instance, HttpServletRequest request, HttpServletResponse response) {
		try {
			userService.addRole(instance);
			success("保存成功", response);
		} catch (Exception e) {
			e.printStackTrace();
			error("保存出错！", response);
		}
	}
	
	@ApiOperation(value = "修改角色", httpMethod = "PUT")
	@RequestMapping(value = "/role", method = RequestMethod.PUT)
	public void putRole(@RequestBody RolePostVO instance, HttpServletRequest request, HttpServletResponse response) {
		try {
			userService.updateRole(instance);
			success("更新成功", response);
		} catch (Exception e) {
			e.printStackTrace();
			error("更新出错！", response);
		}
	}
	
	@ApiOperation(value = "删除角色", httpMethod = "DELETE")
	@RequestMapping(value = "/role", method = RequestMethod.DELETE)
	public void deleteRole(@RequestParam(required = true) Integer id, HttpServletRequest request, HttpServletResponse response) {
		try {
			userService.deleteRole(id.intValue());
			success("删除成功", response);
		} catch (Exception e) {
			e.printStackTrace();
			error("删除出错！", response);
		}
	}
	
	@ApiOperation(value = "操作员登录", httpMethod = "POST")
	@RequestMapping(value = "/manager/login", method = RequestMethod.POST)
	public void postManagerLogin(@RequestBody ManagerLoginVO user, HttpServletRequest request, HttpServletResponse response) {
		try {
			Manager instance = userService.managerLogin(user.getEmail(), user.getPassword());
			if (null != instance) {
				writeJson(instance, response);
			} else {
				error("邮箱或密码错误", response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			error("登录失败！", response);
		}
	}
}
