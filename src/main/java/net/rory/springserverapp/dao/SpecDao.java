package net.rory.springserverapp.dao;


import net.rory.springserverapp.model.Spec;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SpecDao extends JpaRepository<Spec, Long> {
    @Query("SELECT s FROM Spec s WHERE s.nameSpec = :nameSpec")
    Spec findSpecByName(@Param("nameSpec") String nameSpec);
}
