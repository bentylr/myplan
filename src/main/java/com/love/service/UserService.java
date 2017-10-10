package com.love.service;

import org.apache.commons.lang3.tuple.Pair;

/**
 * Created by bhagi on 10/2/2017.
 */
public interface UserService {
    Pair<Boolean, String> verify(String userName, String passWord);
}
