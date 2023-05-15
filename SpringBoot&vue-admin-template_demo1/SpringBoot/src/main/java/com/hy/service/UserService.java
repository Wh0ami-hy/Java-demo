package com.hy.service;

import com.alibaba.fastjson.JSONObject;


public interface UserService {

    public String login(String username);

    public Integer update(JSONObject param);
}
