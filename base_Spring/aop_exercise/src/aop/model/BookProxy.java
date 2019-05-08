package aop.model;

public class BookProxy {

    public void  before1(){
        System.out.println("前置增强...");
    }

    public void after1(){
        System.out.println("后置增强...");
    }

    public void round1(){

    }

}
