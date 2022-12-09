package com.havya.practice.service;

import com.havya.practice.models.Order;
import com.havya.practice.models.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDao {
    private static UserDao userDaoInstance = null;
    Map<String, User> currentUsers = new HashMap<>();
    User loggedInUser = null;

    public static UserDao getUserDaoInstance() {
        if (userDaoInstance == null) {
            userDaoInstance = new UserDao();
        }
        return userDaoInstance;
    }

    public static void setUserDaoInstance(UserDao userDaoInstance) {
        UserDao.userDaoInstance = userDaoInstance;
    }

    public void registerUser(User user) {
        currentUsers.put(user.getPhoneNo(), user);
    }

    public User getUser(String phoneNo) throws Exception {
        if (!currentUsers.containsKey(phoneNo)) {
            throw new Exception("User not present!!");
        }
        return currentUsers.get(phoneNo);
    }

    public User getLoggedInUser() {
        return loggedInUser;
    }

    public void setLoggedInUser(User loggedInUser) {
        this.loggedInUser = loggedInUser;
    }

    public List<Order> getOrderHistory() {
        User user = getLoggedInUser();
        return user.getOrders();
    }

    public Map<String, User> getCurrentUsers() {
        return currentUsers;
    }

    public void setCurrentUsers(Map<String, User> currentUsers) {
        this.currentUsers = currentUsers;
    }
}
