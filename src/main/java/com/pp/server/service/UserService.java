package com.pp.server.service;

import com.pp.server.entity.UserDo;

public interface UserService {
    UserDo getUser(String userAccount);
}
