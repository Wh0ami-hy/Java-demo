package com.hy.mapper;

import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    public String login(String username);

    public Integer update(JSONObject param);
}
