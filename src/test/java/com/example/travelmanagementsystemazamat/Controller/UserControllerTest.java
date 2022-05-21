package com.example.travelmanagementsystemazamat.Controller;

import com.example.travelmanagementsystemazamat.Entities.Flight;
import com.example.travelmanagementsystemazamat.Entities.User;
import com.example.travelmanagementsystemazamat.Repository.FlightRepository;
import com.example.travelmanagementsystemazamat.Repository.UserRepository;
import com.example.travelmanagementsystemazamat.Service.impl.JDBCUserServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;


    @MockBean
    private JDBCUserServiceImpl service;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }


//    @Test
//    public void givenEmployeeObject_whenCreateEmployee_thenReturnSavedEmployee() throws Exception{
//        User user = new User(1,"Azamat","9888888",21);
//        given(service.save2(User.class))
//                .willAnswer((invocation)-> invocation.getArgument(0));
//
//        // when - action or behaviour that we are going test
//        ResultActions response = mockMvc.perform(post("/users/all")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(objectMapper.writeValueAsString(user)));
//
//        // then - verify the result or output using assert statements
//        response.andDo(print()).
//                andExpect(status().isCreated())
//                .andExpect(jsonPath("$.id",
//                        is(user.getId())))
//                .andExpect(jsonPath("$.name",
//                        is(user.getName())))
//                .andExpect(jsonPath("$.phone",
//                        is(user.getPhone())))
//                .andExpect(jsonPath("$.age",
//                        is(user.getAge())));
//
//    }

    @Test
    public void givenListOfEmployees_whenGetAllEmployees_thenReturnEmployeesList() throws Exception {
        // given - precondition or setup
        List<User> listOfEmployees = new ArrayList<>();
        listOfEmployees.add(new User(1, "Aza", "7777", 21));
        listOfEmployees.add(new User(2, "Bakha", "7777", 22));
        given(service.getAllUsers()).willReturn(listOfEmployees);

        // when -  action or the behaviour that we are going test
        ResultActions response = mockMvc.perform(get("/users/all"));

        // then - verify the output
        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.size()",
                        is(listOfEmployees.size())));


//    @Test
//    void testGetAllUFlights() {
//        when(repository.getAll()).thenReturn(List.of(new T()));
//
//        ResponseEntity<List<Flight>> result = userController.getAllUFlights();
//        Assertions.assertEquals(null, result);
//    }
//
//    @Test
//    void testAddTicket() {
//        ResponseEntity<Void> result = userController.addTicket(new User(0, "name", "phone", 0));
//        Assertions.assertEquals(null, result);
//    }
//
//    @Test
//    void testGetById() {
//        when(jdbcUserService.getUser(anyInt())).thenReturn(null);
//
//        Optional<User> result = userController.getById(0);
//        Assertions.assertEquals(null, result);
//    }
//
//    @Test
//    void testDeleteUser() {
//        ResponseEntity<Void> result = userController.deleteUser(0);
//        Assertions.assertEquals(null, result);
//    }
    }
}
//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme