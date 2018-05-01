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
    @JsonIgnore
    private Long idReviewsParameters;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "idReview")
    @JsonIgnore
    private Review review;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "idParameter")
    private Parameter parameter;

    @Column(name = "value")
    private Integer value;

    public ReviewsParameter() {
    }

    public ReviewsParameter(Review review, Parameter parameter, Integer value) {
        this.review = review;
        this.parameter = parameter;
        this.value = value;
    }

    public Long getIdReviewParameter() {
        return idReviewsParameters;
    }

    public void setIdReviewParameter(Long idReviewsParameters) {
        this.idReviewsParameters = idReviewsParameters;
    }

    public Review getReview() {
        return review;
    }

    public void setReview(Review review) {
        this.review = review;
    }

    public Parameter getParameter() {
        return parameter;
    }

    public void setParameter(Parameter parameter) {
        this.parameter = parameter;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
