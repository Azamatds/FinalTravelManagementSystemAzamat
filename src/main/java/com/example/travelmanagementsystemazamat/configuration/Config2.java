package com.example.travelmanagementsystemazamat.configuration;

import com.example.travelmanagementsystemazamat.Repository.GenerallRepository;
import com.example.travelmanagementsystemazamat.Repository.impl.JDBCUserRepositoryImpl;
import com.example.travelmanagementsystemazamat.Service.impl.JDBCUserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

@Configuration
public class Config2 {
    @Bean("firstBean")
    @DependsOn(value = {
            "secondBean",
            "thirdBean"
    })
    public FirstBean firstBean() {
        return new FirstBean();
    }

    @Bean("secondBean")
    public SecondBean secondBean() {
        return new SecondBean();
    }

    @Bean("thirdBean")
    public ThirdBean thirdBean() {
        return new ThirdBean();
    }
}