package com.banner.boke.web.service;

import com.banner.boke.web.model.User;

import java.util.List;

public interface UserService {

    List<User> findAllUser(int pageNum, int pageSize);
}
