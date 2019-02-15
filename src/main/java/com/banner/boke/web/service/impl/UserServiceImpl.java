package com.banner.boke.web.service.impl;

import com.banner.boke.web.mapper.UserMapper;
import com.banner.boke.web.model.User;
import com.banner.boke.web.service.UserService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;//这里会报错，但是并不会影响

    @Override
    public List<User> findAllUser(int pageNum, int pageSize) {
        PageHelper.offsetPage(pageNum,pageSize);
        return userMapper.selectAllUser();
    }
}
