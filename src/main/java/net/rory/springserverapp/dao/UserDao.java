package net.rory.springserverapp.dao;


import net.rory.springserverapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {
}
