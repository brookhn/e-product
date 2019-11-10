package com.pp.server.controller;

import com.pp.server.Dao.UserDao;
import com.pp.server.common.JsonPrinter;
import com.pp.server.common.exception.ErrorCode;
import com.pp.server.common.exception.ErrorMethod;
import com.pp.server.common.exception.GeneralException;
import com.pp.server.common.exception.ParamErrorCode;
import com.pp.server.entity.UserDo;
import com.pp.server.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/userInfo")
    public void getReportByCityId(@RequestParam(value = "user_account", required = true) String user_account,
                                  @RequestParam(value = "format", required = false, defaultValue = "json") String format,
                                  @RequestParam(value = "cb", required = false, defaultValue = "") String cb,
                                  HttpServletResponse response)
    {
        if (StringUtils.isBlank(user_account)){
            throw new GeneralException(ParamErrorCode.COMMON_PARAMETER_ILLEGAL.setParam("user_account"));
        }
        ErrorMethod errorCode = ErrorCode.SUCCESS;
        UserDo userDo = userService.getUser(user_account);
        JsonPrinter.printObjectSuccess(response, errorCode, userDo, format, cb);
    }


}
