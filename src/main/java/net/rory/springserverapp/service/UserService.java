package net.rory.springserverapp.service;


import net.rory.springserverapp.model.User;

public interface UserService {
    void saveUser(User user);

    Long getUser(String surname, String name, String email);

    User loadUserByEmail(String email);

    User loadUserById(Long id);
}
