package com.havya.practice.service;

import com.havya.practice.enums.Gender;
import com.havya.practice.models.User;

public class UserService {
    UserDao userDao;

    public UserService() {
        userDao = UserDao.getUserDaoInstance();
    }

    public void registerUser(String name, Gender gender, String phoneNo, String pinCode) throws Exception {
        if (userDao.getCurrentUsers().containsKey(phoneNo)) {
            throw new Exception("User already present!!");
        }
        User user = new User(name, pinCode, gender, phoneNo);
        userDao.registerUser(user);
    }

    public void loginUser(String phoneNo) throws Exception {
        User user = userDao.getUser(phoneNo);
        if (user != null) {
            userDao.setLoggedInUser(user);
        }
    }

    public User getLoggedInUser() {
        return userDao.getLoggedInUser();
    }
}
