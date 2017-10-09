package com.love.controller;

import com.love.service.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;

/**
 * Created by bhagi on 10/2/2017.
 */
@RestController
@RequestMapping(path = "/demo")
@AllArgsConstructor
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping(value = "/auth/{value}")
    public String validate(@PathVariable("value") String auth) {
        if (StringUtils.isNoneBlank(auth)) {
            String decodedAuth = new String(Base64.getDecoder().decode(auth));
            String parts[] = decodedAuth.split(";");
            Pair<Boolean, String> result = userService.verify(parts[0], parts[1]);
            if (result.getKey()) return String.format("Welcome {} .Login is successful", result.getValue());
            else return "Login was a Failure, Invalid Credentials";
        }
        return  "Need Credentials";
    }
}