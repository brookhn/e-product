package com.pp.server.Dao;

import com.pp.server.entity.UserDo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface UserDao {
    UserDo getUser(@Param("userAccount") String userAccount);
}
