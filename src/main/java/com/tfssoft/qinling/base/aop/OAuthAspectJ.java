//package com.tfssoft.qinling.base.aop;
//
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Pointcut;
//
//import com.tfssoft.qinling.base.controller.BaseController;
//import com.tfssoft.qinling.base.filter.util.SysContent;
//import com.tfssoft.qinling.web.MemcacheUtil;
//
///**
// * 
// * 权限切面 - 织入级别：方法
// * 
// * @author DWH
// * @version 1.0
// * @param <T>
// */
//@Aspect
//public class OAuthAspectJ extends BaseController {
//
//	/**
//	 * 
//	 * 描述 定义切点
//	 */
//	@Pointcut("@annotation(com.tfssoft.qinling.base.annotation.OAuth)")
//	public void oAuthPointcut() {
//	}
//
//	/**
//	 * 
//	 * 描述 环绕通知
//	 * 
//	 * @param joinPoint
//	 * @return
//	 */
//	@Around(value = "oAuthPointcut()")
//	public void aroundHandle(ProceedingJoinPoint joinPoint)
//			throws Throwable {
//		// 获取授权码
//		String accessToken = SysContent.getRequest().getParameter("accessToken");
//		
//		if(!validate(accessToken)){
//			error("无权限访问！", SysContent.getResponse());
//		} else {
//			MemcacheUtil.deleteCache(accessToken);
//			joinPoint.proceed();
//		}
//	}
//	
//	/**
//	 * 验证是否有权限
//	 * @return
//	 */
//	private boolean validate(String accessToken) {
//		if(null != accessToken && null != MemcacheUtil.getCache(accessToken))
//			return true;
//		return false;
//	}
//
//}
