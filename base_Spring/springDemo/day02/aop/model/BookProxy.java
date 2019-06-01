package aop.model;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class BookProxy {

   /* @Before(value = "execution(* aop.model..Book.*(..))")
    public void  before1(){
        System.out.println("前置增强...");
    }

    @After(value = "execution(* aop.model..Book.*(..))")
    public void after1(){
        System.out.println("后置增强...");
    }*/

   @Around(value = "execution(* aop.model..Book.*(..))")
    public void around1(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        System.out.println("方法调用之前");
        // 执行被增强的方法
        proceedingJoinPoint.proceed(); //-->切入点的方法
        // 方法之后
        System.out.println("方法之后...");

    }

}
