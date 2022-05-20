package com.example.travelmanagementsystemazamat.Service.impl;

import com.example.travelmanagementsystemazamat.Entities.User;
import com.example.travelmanagementsystemazamat.Repository.impl.JDBCUserRepositoryImpl;
import com.example.travelmanagementsystemazamat.Service.JDBCUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class JDBCUserServiceImpl implements JDBCUserService {

    private static List<User> myUser = new ArrayList<>();
    private static int my_def_id = 1;

    static {
        myUser.add(new User(my_def_id++, "Azamat","777777",20));
        myUser.add(new User(my_def_id++, "Bakbergen","777777",20));
        myUser.add(new User(my_def_id++, "Nurdaulet","777777",20));
    }

    private final JDBCUserRepositoryImpl jdbcUserRepository;

    @Autowired
    public JDBCUserServiceImpl(JDBCUserRepositoryImpl jdbcUserRepository) {
        this.jdbcUserRepository = jdbcUserRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return jdbcUserRepository.getAll();
    }

    @Override
    public Optional<User> getUser(int id) {
        if(id < 0){
            throw new IllegalStateException("id should be greater than 0");
        }
        return jdbcUserRepository.getById(id);
    }

    @Override
    public void deleteUser(int id) {
        jdbcUserRepository.deleteById(id);
    }

    @Override
    public Optional<User> getUserByName(String name) {
        return jdbcUserRepository.getByName(name);
    }

    @Override
    public void save(Object user) {
        jdbcUserRepository.save(user);
    }

    @Override
    public void update(Object user) {
        jdbcUserRepository.update(user);
    }

    @Scheduled(initialDelay=1000, fixedRate=3000)
    public void testScheduling() throws InterruptedException {
        boolean flag = true;
        int size = myUser.size();
        try {
            for (int i = 0; i <size; i++) {
                System.out.println("Started : "+  myUser.get(i).getAge());
                int updateAge =  myUser.get(i).getAge();
                updateAge = updateAge + 1;
                Thread.sleep(3000);
                log.info("Finished : " + updateAge);

            }
        }catch (Exception e){
            System.out.println(e);
        }
        System.out.println("end");
    }

}
