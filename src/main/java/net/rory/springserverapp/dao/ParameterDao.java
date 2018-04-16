package net.rory.springserverapp.dao;


import net.rory.springserverapp.model.Parameter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParameterDao extends JpaRepository<Parameter, Long> {
}
