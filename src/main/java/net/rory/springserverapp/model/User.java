package net.rory.springserverapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idUser;

    @Column(name = "surname")
    private String surname;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @OneToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
        mappedBy = "user")
    @JsonIgnore
    private List<Review> reviews = new ArrayList<>();

    @ManyToOne()
    @JoinTable(name = "usersAccess", joinColumns = @JoinColumn(name = "idUser"),
            inverseJoinColumns = @JoinColumn(name = "idAccess"))
    private Access access;

    public User() {
    }

    public User(String surname, String name, String email, List<Review> reviews, Access access) {
        this.surname = surname;
        this.name = name;
        this.email = email;
        this.reviews = reviews;
        this.access = access;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public Access getAccess() {
        return access;
    }

    public void setAccess(Access access) {
        this.access = access;
    }
}
