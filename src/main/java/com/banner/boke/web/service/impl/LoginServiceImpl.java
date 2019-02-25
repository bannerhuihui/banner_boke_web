package com.banner.boke.web.service.impl;

import com.banner.boke.web.mapper.UserMapper;
import com.banner.boke.web.model.User;
import com.banner.boke.web.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginServiceImpl.class);

    @Autowired
    private UserMapper userMapper;

    @Override
    public User finduser(User user) {
        List<User> list = userMapper.login(user);
        if(list!=null && list.size()>0){
            LOGGER.info("登录成功！");
            return list.get(0);
        }
        return null;
    }
}
