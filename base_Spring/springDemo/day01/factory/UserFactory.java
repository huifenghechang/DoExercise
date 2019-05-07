package factory;

import model.User;

public class UserFactory {
    // 静态工厂方法
    public static User getUser(){
        return new User();
    }

    // 实例工厂方法
    public User getUser2(){
        return new User();
    }
}
