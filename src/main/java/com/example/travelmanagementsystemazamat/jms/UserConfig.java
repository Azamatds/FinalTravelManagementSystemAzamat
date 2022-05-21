//package com.example.travelmanagementsystemazamat.jms;
//
//import com.example.travelmanagementsystemazamat.Entities.User;
//import lombok.val;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
//
//import java.util.Collections;
//@Configuration
//public class UserConfig {
//
//    @Bean
//    public MappingJackson2MessageConverter messageConverter() {
//        val messageConveror = new MappingJackson2MessageConverter();
//        messageConveror.setTypeIdPropertyName("context-type");
//        messageConveror.setTypeIdMappings(Collections.singletonMap("ticket", User.class));
//        return messageConveror;
//    }
