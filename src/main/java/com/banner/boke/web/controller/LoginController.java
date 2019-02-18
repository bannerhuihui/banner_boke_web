package com.banner.boke.web.controller;

import com.banner.boke.web.model.User;
import com.banner.boke.web.service.LoginService;
import com.banner.boke.web.service.impl.LoginServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/login")
public class LoginController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginServiceImpl.class);

    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "login.do")
    public Map<String,String> login(User user){
        Map<String,String> map = new HashMap<>();
        if(user!=null){
            if(user.getUsername()!=null && user.getPassword()!=null && !StringUtils.pathEquals("",user.getUsername()) && !StringUtils.pathEquals("",user.getPassword())){
                user = loginService.login(user);
                if(user!=null){
                    LOGGER.info("登录成功！"+user.getUsername());
                    map.put("success","登录成功！");
                }else{
                    LOGGER.info("登录失败！登录参数为"+user.getUsername()+user.getPassword());
                    map.put("error","登录失败，用户名或密码错误");
                }
                //TODO 将user对象放入缓存
            }else{
                map.put("error","用户名密码为空！");
            }
        }else{
            map.put("error","用户名或密码为空");
        }
        return map;
    }
}
