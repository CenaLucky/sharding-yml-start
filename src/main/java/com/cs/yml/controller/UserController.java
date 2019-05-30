package com.cs.yml.controller;

import com.cs.yml.entity.User;
import com.cs.yml.manager.UserManager;
import com.cs.yml.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author:CaoShuai
 * @dateTime:5/28/2019 2:40 PM
 * @description:
 */
@RestController
@Api(tags = "分片测试")
public class UserController {
    @Autowired
    UserManager userManager;

    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    @ApiOperation("添加用户")
    public Result<Integer> insertUser( @RequestBody User user){
        Result result = userManager.insertUser(user);
        return result;
    }

    @RequestMapping(value = "/findUser",method = RequestMethod.POST)
    @ApiOperation("查询用户")
    public Result<Integer> findUser(){
        Result result = userManager.listUser();
        return result;
    }
}
