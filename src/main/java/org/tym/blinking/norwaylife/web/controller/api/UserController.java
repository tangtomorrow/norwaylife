package org.tym.blinking.norwaylife.web.controller.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tym.blinking.norwaylife.web.vo.UserVO;

/**
 * Created by tangtomorrow on 2017/2/22.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/info")
    public UserVO info() {
        ///*
        UserVO userVO = new UserVO();

        userVO.setId(1);
        userVO.setUserId("tym");
        userVO.setUserName("Blinking");

        return userVO;

        //return "Hello";
    }
}
