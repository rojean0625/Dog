package com.rojean.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AopLog {

	@Pointcut("execution(* com.rojean.aop.DoService.*(..))")
	private void ini() {};
	
	
	//@Around(value = "ini()")
	public void aroundM(ProceedingJoinPoint joinPoint) throws Throwable {
//		System.out.println("log ini");
//		Object object = joinPoint.proceed();//执行该方法
//		Object[] args = joinPoint.getArgs();
//		DataBag d = (DataBag)args[0];
//		System.out.println("log - >:" + d.getCustomerNo() + "  "+d.getAmt());
	}
	
	@AfterReturning(returning="v",value="ini()")
	public void doCloseConn(JoinPoint joinPoint,String v){
		System.out.println("## 执行完成" +v);
	}

	@After("ini()")
	public void doCommit(JoinPoint joinPoint) throws InterruptedException{
		System.out.println("log ini");
		//Object object = joinPoint.proceed();//执行该方法
		Object[] args = joinPoint.getArgs();
		DataBag d = (DataBag)args[0];
		System.out.println("log - >:" + d.getCustomerNo() + "  "+d.getAmt());
	}
	
}
