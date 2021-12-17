package com.ciclo4.reto5.interfaces;

import com.ciclo4.reto5.modelo.User;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface InterfaceUser extends MongoRepository <User, Integer> {
    public Optional<User> findByEmail(String email);
    public Optional<User> findByEmailAndPassword(String email,String password);
    Optional<User> findTopByOrderByIdDesc();
    List<User> findByMonthBirthtDay(String monthBirthtDay);
}
