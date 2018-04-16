package net.rory.springserverapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "parameters")
public class Parameter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idParameter;

    @Column(name = "nameParameter")
    private String nameParameter;

    @OneToMany(mappedBy = "parameter", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<ReviewsParameter> reviewsParameters = new ArrayList<>();

    public Parameter() {
    }

    public Parameter(String nameParameter, List<ReviewsParameter> reviewsParameters) {
        this.nameParameter = nameParameter;
        this.reviewsParameters = reviewsParameters;
    }

    public Long getIdParameter() {
        return idParameter;
    }

    public void setIdParameter(Long idParameter) {
        this.idParameter = idParameter;
    }

    public String getNameParameter() {
        return nameParameter;
    }

    public void setNameParameter(String nameParameter) {
        this.nameParameter = nameParameter;
    }

    public List<ReviewsParameter> getReviewsParameters() {
        return reviewsParameters;
    }

    public void setReviewsParameters(List<ReviewsParameter> reviewsParameters) {
        this.reviewsParameters = reviewsParameters;
    }
}
