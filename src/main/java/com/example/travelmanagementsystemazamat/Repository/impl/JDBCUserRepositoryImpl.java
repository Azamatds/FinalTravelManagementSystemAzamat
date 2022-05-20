package com.example.travelmanagementsystemazamat.Repository.impl;

import com.example.travelmanagementsystemazamat.Entities.Person;
import com.example.travelmanagementsystemazamat.Entities.User;
import com.example.travelmanagementsystemazamat.Repository.GenerallRepository;
import com.example.travelmanagementsystemazamat.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class JDBCUserRepositoryImpl implements UserRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JDBCUserRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<User> getAll() {
//        return jdbcTemplate.query("SELECT * FROM user",new PersonMapper());

        return jdbcTemplate.query("select * from user",(rs,rowNum) ->
                new User(
                        rs.getInt("user_id"),
                        rs.getString("name"),
                        rs.getString("phone"),
                        rs.getInt("age")
                ));
    }

    @Override
    public Optional<User> getById(int id) {
//        return jdbcTemplate.query("select * from user where id = ?",new Optional[]{id},new PersonMapper());

        return jdbcTemplate.queryForObject("select * from user where user_id = ?",
                (rs, rowNum) -> Optional.of(
                        new User(
                                rs.getInt("id"),
                                rs.getString("name"),
                                rs.getString("phone"),
                                rs.getInt("age")
                        )
                ),
                id);

    }


    @Override
    public void deleteById(int id) {
        jdbcTemplate.update("delete from user where id = ?", id);
    }

    @Override
    public Optional<User> getByName(String name) {
        return jdbcTemplate.queryForObject("select * from user where name  = ?",(rs,rowNum)->
                Optional.of(
                        new User(
                                rs.getInt("id"),
                                rs.getString("name"),
                                rs.getString("phone"),
                                rs.getInt("age")
                        )
                ),name);
    }

    @Override
    public void save(Object object) {
        User user = (User)object;
//        jdbcTemplate.update("insert into values(1,?,?,?)",user.getName(),user.getPhone(),user.getAge());
        jdbcTemplate.update("insert into user (name,phone,age) values(?,?,?)",
                user.getName(),user.getPhone(),
                user.getAge());
    }

    @Override
    public void update(Object object) {
        User user = (User) object;
//        jdbcTemplate.update("update user set name = ? ,phone = ?, age = ? =  where id = ?",
//                user.getName(),user.getPhone(),user.getAge(),user.getId());
        jdbcTemplate.update("update user set name = ? where age < 18",user.getName());
    }


    //////////////////////
    // Тестируем производительность
    //////////////////////
    @Override
    public void testBatchUpdate() {
        List<Person> people = create1000People();

        long before = System.currentTimeMillis();

        jdbcTemplate.batchUpdate("INSERT INTO person VALUES(?, ?, ?, ?)",
                new BatchPreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement ps, int i) throws SQLException {
                        ps.setInt(1, Integer.parseInt(String.valueOf(people.get(i).getId())));
                        ps.setString(2, people.get(i).getName());
                        ps.setInt(3, Integer.parseInt(String.valueOf(people.get(i).getAge())));
                        ps.setString(4, people.get(i).getEmail());
                    }

                    @Override
                    public int getBatchSize() {
                        return people.size();
                    }
                });

        long after = System.currentTimeMillis();
        System.out.println("Time: " + (after - before));
    }

    private List<Person> create1000People() {
        List<Person> people = new ArrayList<>();

        for (int i = 1; i < 1000; i++)
            people.add(new Person(i, "Name" + i, 30, "test" + i + "@mail.ru"));

        return people;
    }



}
