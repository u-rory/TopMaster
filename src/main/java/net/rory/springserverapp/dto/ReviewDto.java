package net.rory.springserverapp.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import net.rory.springserverapp.model.ReviewsParameter;
import net.rory.springserverapp.model.User;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class ReviewDto {

    private Long idReview;

    private User user;

    private String surname;

    private String name;

    private String otchestvo;

    private String specName;

    private String city;

    private String address;

    private Integer onCall;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy",
            timezone = "Asia/Tomsk")
    private Date datetime;

    private String content;

    private List<ReviewsParameter> reviewsParameters = new ArrayList<>();

    private Integer status;

    private Long idSpecUser;

    public ReviewDto() {
    }

    public ReviewDto(Long idReview, User user, String surname, String name, String otchestvo, String specName, String city, String address, Integer onCall, Date datetime, String content, List<ReviewsParameter> reviewsParameters, Integer status, Long idSpecUser) {
        this.idReview = idReview;
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
        this.idSpecUser = idSpecUser;
    }

    public ReviewDto(Long idReview, User user, String surname, String name, String otchestvo, String specName, String city, String address, Integer onCall, Date datetime, String content, List<ReviewsParameter> reviewsParameters, Integer status) {
        this.idReview = idReview;
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

    public Long getIdSpecUser() {
        return idSpecUser;
    }

    public void setIdSpecUser(Long idSpecUser) {
        this.idSpecUser = idSpecUser;
    }
}
