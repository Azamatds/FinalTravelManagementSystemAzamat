package com.example.travelmanagementsystemazamat.configuration;

import com.example.travelmanagementsystemazamat.Entities.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

@Configuration
public class Config1 {


    @Lazy
//    @Scope("singleton")
    public User user1(){
        User user = new User();
        user.setId(3);
        user.setName("Zamanbek");
        user.setAge(20);
        user.setPhone("xxxxxxxxx");
        return user;
    }


    @Lazy
    @Scope("prototype")
    public User user2(){
        User user = new User();
        user.setName("tick");
        return user;
    }


}
