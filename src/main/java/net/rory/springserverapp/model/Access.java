package net.rory.springserverapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "access")
public class Access {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idAccess;

    @Column(name = "nameAccess")
    private String nameAccess;

    @OneToMany(mappedBy = "access")
    @JsonIgnore
    private List<User> users;

    public Access() {
    }

    public Access(String nameAccess, List<User> users) {
        this.nameAccess = nameAccess;
        this.users = users;
    }

    public Long getIdAccess() {
        return idAccess;
    }

    public void setIdAccess(Long idAccess) {
        this.idAccess = idAccess;
    }

    public String getNameAccess() {
        return nameAccess;
    }

    public void setNameAccess(String nameAccess) {
        this.nameAccess = nameAccess;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
