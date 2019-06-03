package com.john.showmecode.service;

import com.john.showmecode.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Component
public class UserServiceFallback implements UserService {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    public User get(Long id) {
        return new User(-1L, "default", "1234567");
    }

    @GetMapping("user")
    public List<User> get(){
        return null;
    }
}
