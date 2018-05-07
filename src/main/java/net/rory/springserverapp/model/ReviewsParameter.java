package net.rory.springserverapp.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "reviewsParameters")
public class ReviewsParameter {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "reviewsParameters_generator")
    @SequenceGenerator(name = "reviewsParameters_generator",
            sequenceName = "reviewsParameters_id_seq",
            allocationSize = 1)
    private Long idReviewsParameters;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "idReview")
    @JsonIgnore
    private Review review;

    @Column(name = "parameterName")
    private String parameterName;

    @Column(name = "value")
    private Float value;

    public ReviewsParameter() {
    }

    public ReviewsParameter(Review review, String parameterName, Float value) {
        this.review = review;
        this.parameterName = parameterName;
        this.value = value;
    }

    public Long getIdReviewsParameters() {
        return idReviewsParameters;
    }

    public void setIdReviewsParameters(Long idReviewsParameters) {
        this.idReviewsParameters = idReviewsParameters;
    }

    public Review getReview() {
        return review;
    }

    public void setReview(Review review) {
        this.review = review;
    }

    public String getParameterName() {
        return parameterName;
    }

    public void setParameterName(String parameterName) {
        this.parameterName = parameterName;
    }

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }
}
