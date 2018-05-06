package net.rory.springserverapp.model;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "specUsers")
@DynamicInsert
@DynamicUpdate
public class SpecUser {

    @Id
    private Long idUser;

    @Column(name = "surname")
    private String surname;

    @Column(name = "name")
    private String name;

    @Column(name = "otchestvo")
    private String otchestvo;

    @Column(name = "email")
    private String email;

    @Column(name = "onCall")
    private Integer onCall;

    @Column(name = "specName")
    private String specName;

    @Column(name = "city")
    private String city;

    @Column(name = "address")
    private String address;

    @Column(name = "info")
    private String info;

    @OneToMany(mappedBy = "specUser", cascade = CascadeType.ALL)
    private List<Review> reviews;

    public SpecUser() {
    }

    public SpecUser(Long idUser, String surname, String name, String otchestvo, String email, Integer onCall, String specName, String city, String address, String info, List<Review> reviews) {
        this.idUser = idUser;
        this.surname = surname;
        this.name = name;
        this.otchestvo = otchestvo;
        this.email = email;
        this.onCall = onCall;
        this.specName = specName;
        this.city = city;
        this.address = address;
        this.info = info;
        this.reviews = reviews;
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

    public String getOtchestvo() {
        return otchestvo;
    }

    public void setOtchestvo(String otchestvo) {
        this.otchestvo = otchestvo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getOnCall() {
        return onCall;
    }

    public void setOnCall(Integer onCall) {
        this.onCall = onCall;
    }

    public String getSpecName() {
        return specName;
    }

    public void setSpecName(String specName) {
        this.specName = specName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
}
