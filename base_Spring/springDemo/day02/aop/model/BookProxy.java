package aop.model;

import org.aspectj.lang.ProceedingJoinPoint;

public class BookProxy {

    public void  before1(){
        System.out.println("前置增强...");
    }

    public void after1(){
        System.out.println("后置增强...");
    }

    public void around1(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        System.out.println("方法调用之前");
        // 执行被增强的方法
        proceedingJoinPoint.proceed(); //-->切入点的方法
        // 方法之后
        System.out.println("方法之后...");

    }

}
