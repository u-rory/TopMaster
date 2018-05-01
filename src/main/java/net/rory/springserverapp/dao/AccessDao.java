package net.rory.springserverapp.dao;


import net.rory.springserverapp.model.Access;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccessDao extends JpaRepository<Access, Long> {
}
