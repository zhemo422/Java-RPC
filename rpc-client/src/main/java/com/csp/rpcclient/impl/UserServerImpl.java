package com.csp.rpcclient.impl;

import com.csp.rpcapi.User;
import com.csp.rpcapi.UserService;

public class UserServerImpl implements UserService {
    @Override
    public User getUser(String name, long id) {
        return User.builder()
                .name(name)
                .id(id)
                .build();
    }
}
