package com.sd.service;

import com.sd.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
