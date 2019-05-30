package com.cs.yml.manager;

import com.cs.yml.entity.User;
import com.cs.yml.utils.Result;

import java.util.List;

/**
 * @author:CaoShuai
 * @dateTime:5/28/2019 2:36 PM
 * @description:
 */
public interface UserManager {
    /**
     *
     * @param user
     * @return
     */
    Result<Integer> insertUser(User user);

    /**
     *
     * @return
     */
   Result<List<User>> listUser();
}
