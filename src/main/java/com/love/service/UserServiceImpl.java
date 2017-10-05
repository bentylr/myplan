package com.love.service;

import lombok.AllArgsConstructor;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.stereotype.Service;

/**
 * Created by bhagi on 10/2/2017.
 */
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    //@Autowired
    //private UserRepository userRepository;

    @Override
    public Pair<Boolean, String> verify(String userName, String passWord) {
       // User user = userRepository.findOne(userName);
        if (passWord.equals("NaniKavya") && userName.equals("bhagi009")) return Pair.of(true,"Bhagirath");
        return Pair.of(false, null);
    }

}
