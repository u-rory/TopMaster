package net.rory.springserverapp.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idReview;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idUser", nullable = false)
    private User user;

    @Column(name = "surname")
    private String surname;

    @Column(name = "name")
    private String name;

    @Column(name = "otchestvo")
    private String otchestvo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idSpec", nullable = false)
    private Spec spec;

    @Column(name = "city")
    private String city;

    @Column(name = "address")
    private String address;

    @Column(name = "datetime")
    private String datetime;

    @Column(name = "content")
    private String content;

    @OneToMany(mappedBy = "review", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ReviewsParameter> reviewsParameters = new ArrayList<>();

    @Column(name = "status")
    private Integer status;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "specsReviews", joinColumns = @JoinColumn(name = "idReview"),
            inverseJoinColumns = @JoinColumn(name = "idUser"))
    @JsonIgnore
    private SpecUser specUser;

    public Review() {
    }

    public Review(User user, String surname, String name, String otchestvo, Spec spec, String city, String address, String datetime, String content, Integer status, SpecUser specUser, List<ReviewsParameter> reviewsParameters) {
        this.user = user;
        this.surname = surname;
        this.name = name;
        this.otchestvo = otchestvo;
        this.spec = spec;
        this.city = city;
        this.address = address;
        this.datetime = datetime;
        this.content = content;
        this.status = status;
        this.specUser = specUser;
        this.reviewsParameters = reviewsParameters;
    }

    public Long getIdReview() {
        return idReview;
    }

    public void setIdReview(Long idReview) {
        this.idReview = idReview;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public Spec getSpec() {
        return spec;
    }

    public void setSpec(Spec spec) {
        this.spec = spec;
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

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public SpecUser getSpecUser() {
        return specUser;
    }

    public void setSpecUser(SpecUser specUser) {
        this.specUser = specUser;
    }

    public List<ReviewsParameter> getReviewsParameters() {
        return reviewsParameters;
    }

    public void setReviewsParameters(List<ReviewsParameter> reviewsParameters) {
        this.reviewsParameters = reviewsParameters;
    }
}
