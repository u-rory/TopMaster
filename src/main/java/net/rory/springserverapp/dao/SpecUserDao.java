package net.rory.springserverapp.dao;

import net.rory.springserverapp.model.SpecUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecUserDao extends JpaRepository<SpecUser, Long> {
}
