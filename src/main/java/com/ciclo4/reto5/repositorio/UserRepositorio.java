package com.ciclo4.reto5.repositorio;


import com.ciclo4.reto5.interfaces.InterfaceUser;
import com.ciclo4.reto5.modelo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepositorio {

    @Autowired
    private InterfaceUser interfaceUser;

    public Optional<User> getUser(int id) {
        return interfaceUser.findById(id);
    }

    public List<User> listAll() {
        return interfaceUser.findAll();
    }

    public boolean emailExists(String email) {
        Optional<User> usuario = interfaceUser.findByEmail(email);

        return !usuario.isEmpty();
    }

    public Optional<User> autenticateUser(String email, String password) {
        return interfaceUser.findByEmailAndPassword(email, password);
    }

    public User create(User user) {
        return interfaceUser.save(user);
    }
    
    public User update(User user) {
        return interfaceUser.save(user);
    }
    
    
    public void delete(User user) {
        interfaceUser.delete(user);
    }
    
     public Optional<User> lastUserId(){
        return interfaceUser.findTopByOrderByIdDesc();
    }
     
    public List<User> birthtDayList(String monthBirthtDay) {
        return interfaceUser.findByMonthBirthtDay(monthBirthtDay);
    }
}
