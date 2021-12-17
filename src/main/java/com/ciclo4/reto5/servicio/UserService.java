package com.ciclo4.reto5.servicio;

/*
*Importaciones
*/
import com.ciclo4.reto5.modelo.User;
import com.ciclo4.reto5.repositorio.UserRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
/*
*Anotacion SpringBoot para servicios
*/
@Service
/*
*Clase publica de servicio de usuario
*/
public class UserService {
    /*
    *Anotacion que permite inyectar unas dependencias con otras dentro de Spring
     */
    @Autowired
    /*
    *Clase privada para el llaado al repositorio de usuario
    */
    private UserRepositorio userRepository;
    /*
    *Lista para la obtencion de usuarios
    */
    public List<User> listAll() {
        return userRepository.listAll();
    }

    public Optional<User> getUser(int id) {
        return userRepository.getUser(id);
    }
    /*
    *Para crear nuevo usuario
    */
    public User create(User user) {
        if (user.getId() == null) {
            return user;
        }else {
            Optional<User> e = userRepository.getUser(user.getId());
            if (e.isEmpty()) {
                if (emailExists(user.getEmail())==false){
                    return userRepository.create(user);
                }else{
                    return user;
                }
            }else{
                return user;
            }
        }
    }
    /*
    *Para actualizar usuario
    */
    public User update(User user) {

        if (user.getId() != null) {
            Optional<User> userDb = userRepository.getUser(user.getId());
            if (!userDb.isEmpty()) {
                if (user.getIdentification() != null) {
                    userDb.get().setIdentification(user.getIdentification());
                }
                if (user.getName() != null) {
                    userDb.get().setName(user.getName());
                }
                if (user.getAddress() != null) {
                    userDb.get().setAddress(user.getAddress());
                }
                if (user.getCellPhone() != null) {
                    userDb.get().setCellPhone(user.getCellPhone());
                }
                if (user.getEmail() != null) {
                    userDb.get().setEmail(user.getEmail());
                }
                if (user.getPassword() != null) {
                    userDb.get().setPassword(user.getPassword());
                }
                if (user.getZone() != null) {
                    userDb.get().setZone(user.getZone());
                }

                userRepository.update(userDb.get());
                return userDb.get();
            } else {
                return user;
            }
        } else {
            return user;
        }
    }
    /*
    *Para borrar usuario
    */
    public boolean delete(int userId) {
        Boolean aBoolean = getUser(userId).map(user -> {
            userRepository.delete(user);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    /*
    *Para verificar si existe el email
    */
    public boolean emailExists(String email) {
        return userRepository.emailExists(email);
    }
    /*
    *Para autenticar usuario
    */
    public User autenticateUser(String email, String password) {
        Optional<User> usuario = userRepository.autenticateUser(email, password);

        if (usuario.isEmpty()) {
            return new User();
        } else {
            return usuario.get();
        }
    }
    public List<User> birthtDayList(String monthBirthtDay) {
        return userRepository.birthtDayList(monthBirthtDay);
    }
}
