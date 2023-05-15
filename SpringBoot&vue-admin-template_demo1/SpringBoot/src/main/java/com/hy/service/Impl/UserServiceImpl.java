package com.hy.service.Impl;

import com.alibaba.fastjson.JSONObject;
import com.hy.mapper.UserMapper;
import com.hy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public String login(String username) {


        return userMapper.login(username);
    }

    @Override
    public Integer update(JSONObject param) {

        return userMapper.update(param);
    }
}
