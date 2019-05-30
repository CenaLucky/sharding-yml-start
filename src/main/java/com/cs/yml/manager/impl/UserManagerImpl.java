package com.cs.yml.manager.impl;

import com.cs.yml.dao.UserDAO;
import com.cs.yml.entity.User;
import com.cs.yml.manager.UserManager;
import com.cs.yml.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author:CaoShuai
 * @dateTime:5/28/2019 2:37 PM
 * @description:
 */
@Service
public class UserManagerImpl implements UserManager {
    @Autowired
    UserDAO userDAO;

    @Override
    public Result<Integer> insertUser(User user) {
        Result result = new Result();
        Integer row = userDAO.insertUser(user);
        result.setModel(row);
        result.setSuccess(true);
        return result;
    }

    @Override
    public Result<List<User>> listUser() {
        List<User> list = userDAO.listUser();
        Result result = new Result();
        result.setModel(list);
        result.setSuccess(true);
        return result;
    }
}
