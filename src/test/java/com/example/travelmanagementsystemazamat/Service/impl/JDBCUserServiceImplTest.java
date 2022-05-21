package com.example.travelmanagementsystemazamat.Service.impl;

import com.example.travelmanagementsystemazamat.Entities.User;
import com.example.travelmanagementsystemazamat.Repository.impl.JDBCUserRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class JDBCUserServiceImplTest {
//    @Mock
//    List<User> myUser;
    @Mock
    JDBCUserRepositoryImpl jdbcUserRepository;
    @Mock
    Logger log;
    @InjectMocks
    JDBCUserServiceImpl jDBCUserServiceImpl;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllUsers() {
        when(jdbcUserRepository.getAll()).thenReturn(
                Stream.of(new User(1,"a","b",10),new User(2,"v","s",16)).collect(
                        Collectors.toList()));
        assertEquals(2,jDBCUserServiceImpl.getAllUsers().size());
    }

    @Test
    void testGetUser() {
        User user = new User(1,"a","b",10);
        int id = 1;
        when(jdbcUserRepository.getById(user.getId()))
                .thenReturn(Optional.of(user));

        Optional<User> optionalUser = jDBCUserServiceImpl.getUser(id);

        Assertions.assertEquals(Optional.of(user), optionalUser);

    }

    @Test
    void testDeleteUser() {
        int id = 1;
        jDBCUserServiceImpl.deleteUser(id);
        verify(jdbcUserRepository,times(1)).deleteById(id);
    }

    @Test
    void testGetUserByName() {
        when(jdbcUserRepository.getByName(anyString())).thenReturn(null);

        Optional<User> result = jDBCUserServiceImpl.getUserByName("name");
        Assertions.assertEquals(null, result);
    }

    @Test
    void testSave() {
        jDBCUserServiceImpl.save("user");
    }

    @Test
    void testUpdate() {
        jDBCUserServiceImpl.update("user");
    }


}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme