package com.pp.server.service.impl;

import com.pp.server.Dao.UserDao;
import com.pp.server.entity.UserDo;
import com.pp.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserDo getUser(String userAccount) {
        return userDao.getUser(userAccount);
    }
}
