package springTxDemo.service;

import springTxDemo.dao.UserDao;

public class UserService {

    UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void addUser(String name){
        userDao.add(name);
    }
}
