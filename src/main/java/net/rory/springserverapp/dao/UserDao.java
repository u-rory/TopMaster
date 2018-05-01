package net.rory.springserverapp.dao;


import net.rory.springserverapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserDao extends JpaRepository<User, Long> {
    @Query("SELECT COUNT(u) FROM User u" +
            " WHERE u.surname = :surname AND u.name = :name AND u.email = :email")
    Long checkUser(@Param("surname") String surname, @Param("name") String name,
                  @Param("email") String email);

    @Query("SELECT u FROM User u WHERE u.email = :email")
    User findUserByEmail(@Param("email") String email);
}
