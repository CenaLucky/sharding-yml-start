package com.cs.yml.dao;

import com.cs.yml.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author:CaoShuai
 * @dateTime:5/28/2019 11:30 AM
 * @description:
 */
@Mapper
public interface UserDAO {
    /**
     *
     * @param user
     * @return
     */
    Integer insertUser(User user);

    /**
     *
     * @return
     */
    List<User> listUser();
}
