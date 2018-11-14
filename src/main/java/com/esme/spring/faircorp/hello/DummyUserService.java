package com.esme.spring.faircorp.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DummyUserService implements UserService{


    @Autowired
    GreetingService gs;

    @Override
    public void greetAll() {
        String[] users = {"Elodie", "Charles"};
        gs.greet(users[0]);
        gs.greet(users[1]);
    }
}
