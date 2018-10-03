package com.tfssoft.qinling.base.controller;
//package com.tfssoft.qinling.base.controller;
//
//import java.util.Date;
//
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import com.tfssoft.qinling.util.EncryptionByMD5;
//import com.tfssoft.qinling.util.RandomUtil;
//import com.tfssoft.qinling.web.Constants;
//import com.tfssoft.qinling.web.MemcacheUtil;
//
//@Controller
//@RequestMapping("oauth")
//public class OAuthCodeController extends BaseController {
//
//	@RequestMapping(value = "", method = RequestMethod.GET)
//	public void getRandomCode(String account, HttpServletResponse response) {
//		try {
//			String randomCode = RandomUtil.getRandom(16);
//
//			// 根据account获取privateKey
//			String privateKey = Constants.PRIVATE_KEY;
//
//			// 存入MemeryCache
//			String accessToken = EncryptionByMD5.getMD5((privateKey + randomCode)
//					.getBytes());
//			MemcacheUtil.addCache(accessToken, randomCode, new Date(2 * 60 * 1000));
//
//			writeJson(randomCode, response);
//			System.out.println(accessToken + "===" + MemcacheUtil.getCache(accessToken));
//
//		} catch (Exception e) {
//			error("授权失败！", response);
//			e.printStackTrace();
//		}
//		
//	}
//
//}
