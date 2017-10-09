package com.love.service;

import com.love.dao.UserDao;
import com.love.model.User;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



/**
 * Created by bhagi on 10/2/2017.
 */
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userRepository;

    @Override
    public Pair<Boolean, String> verify(String userName, String passWord) {
        Iterable<User> userIterable = userRepository.findAll();
        for (Object userObject : userIterable) {
            User user = (User) userObject;
            if (passWord.equals(user.getPassWord()) && userName.equals(user.getUserName()))
                return Pair.of(true, user.getFirstName());
        }
        return Pair.of(false, null);
    }

}
