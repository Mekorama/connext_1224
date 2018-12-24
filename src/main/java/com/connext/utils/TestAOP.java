package com.connext.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Component
@Aspect
public class TestAOP {
	private static Logger LOG = LoggerFactory.getLogger(TestAOP.class);

	@Pointcut("execution(* com.connext.service.MessageService.queryAll(..))")
	public void queryAll() {

	}

	@Pointcut("execution(* com.connext.controller.MessageController.updateById(..))")
	public void modifyById() {

	}

	@Pointcut("execution(* com.connext.controller.MessageController.delete(..))")
	public void delete() {

	}

	@Before("queryAll()")
	public void beforequeryAll(JoinPoint joinPoint) {
		LOG.info("查询开始---");
		String className = joinPoint.getTarget().getClass().getName();
		String methodName = joinPoint.getSignature().getName();

		System.out.println("前置通知:" + className + "." + methodName + "方法执行---");
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		HttpSession session = request.getSession();
		System.out.println("用户是:" + session.getAttribute("phone"));
	}

	@After("queryAll()")
	public void afterqueryAll(JoinPoint joinPoint) {
		LOG.info("查询结束");
	}

	@Before("modifyById()")
	public void beforeupdateById(JoinPoint joinPoint) {
		LOG.info("开始修改");
		String className = joinPoint.getTarget().getClass().getName();
		String methodName = joinPoint.getSignature().getName();

		System.out.println("前置通知:" + className + "." + methodName + "方法执行---");
	}

	@After("modifyById()")
	public void afterupdateById() {
		LOG.info("修改结束");
	}

	@Before("delete()")
	public void beforedelete() {
		LOG.info("删除开始");
	}

	@After("delete()")
	public void afterdelete() {
		LOG.info("删除结束");
	}
}
