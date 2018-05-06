package net.rory.springserverapp.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "review_generator")
    @SequenceGenerator(name="review_generator", sequenceName = "review_id_seq",
            allocationSize = 1)
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

    @Column(name = "specName")
    private String specName;

    @Column(name = "city")
    private String city;

    @Column(name = "address")
    private String address;

    @Column(name = "onCall")
    private Integer onCall;

    @Column(name = "datetime")
    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy",
            timezone = "Asia/Tomsk")
    private Date datetime;

    @Column(name = "content")
    private String content;

    @OneToMany(mappedBy = "review", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ReviewsParameter> reviewsParameters = new ArrayList<>();

    @Column(name = "status")
    private Integer status;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "specsReviews", joinColumns = @JoinColumn(name = "idReview"),
            inverseJoinColumns = @JoinColumn(name = "idSpecUser"))
    @JsonIgnore
    private SpecUser specUser;

    public Review() {
    }

    public Review(User user, String surname, String name, String otchestvo, String specName, String city, String address, Integer onCall, Date datetime, String content, List<ReviewsParameter> reviewsParameters, Integer status, SpecUser specUser) {
        this.user = user;
        this.surname = surname;
        this.name = name;
        this.otchestvo = otchestvo;
        this.specName = specName;
        this.city = city;
        this.address = address;
        this.onCall = onCall;
        this.datetime = datetime;
        this.content = content;
        this.reviewsParameters = reviewsParameters;
        this.status = status;
        this.specUser = specUser;
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

    public Integer getOnCall() {
        return onCall;
    }

    public void setOnCall(Integer onCall) {
        this.onCall = onCall;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<ReviewsParameter> getReviewsParameters() {
        return reviewsParameters;
    }

    public void setReviewsParameters(List<ReviewsParameter> reviewsParameters) {
        this.reviewsParameters = reviewsParameters;
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
}
