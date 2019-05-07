package model;

/*
* 在Spring中，对象实例化有三种方法：
    * - 无参实例化
    * - 静态工厂创建
    * - 实例工厂创建
* */
public class User {
    String name;
    int age;
    String sex;

    public User(){

    }

    public User(String name){
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
