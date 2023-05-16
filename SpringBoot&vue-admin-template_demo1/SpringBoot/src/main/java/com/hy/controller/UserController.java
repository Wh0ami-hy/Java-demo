package com.hy.controller;

import com.alibaba.fastjson.JSONObject;
import com.hy.entity.User;
import com.hy.service.UserService;
import com.hy.util.JwtUtils;
import com.hy.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Result login(@RequestBody User user){
        String password = userService.login(user.getUsername());
        if (password.equals(user.getPassword())){
            String token = JwtUtils.generateToken(user.getUsername());
            System.out.println("name-->" + user.getUsername() + "\npassword-->" + user.getPassword());
            return Result.ok().data("token",token);
        }else {
            return Result.error();
        }
    }
    @GetMapping("/info")
    public Result info(String token){
        String username = JwtUtils.getClaimsByToken(token).getSubject();
        String url = "https://ts1.cn.mm.bing.net/th/id/R-C.41fea3e6b89ad55df3055ac064de1d55?rik=nOcY%2fPZmgN%2fKsQ&riu=http%3a%2f%2fww1.sinaimg.cn%2flarge%2f005NWMakgy1go4ey87o1wj30b40b4q4e.jpg&ehk=1EscN6fvijWBCmwYVk8FSiLvqoZpt4vzOllJFkIINE8%3d&risl=&pid=ImgRaw&r=0";
        return Result.ok().data("name",username).data("avatar",url);
    }
    @PostMapping("/logout")
    public Result logout(){return Result.ok();}

    @PostMapping("/update")
    public Result update(@RequestBody JSONObject param){

        userService.update(param);
        return Result.ok();
    }
}
