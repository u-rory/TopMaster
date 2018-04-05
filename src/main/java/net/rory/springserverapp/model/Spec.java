package net.rory.springserverapp.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "spec")
public class Spec {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idSpec;

    @Column(name = "nameSpec")
    private String nameSpec;

    @OneToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "spec")
    @JsonIgnore
    private List<Review> reviews = new ArrayList<>();
    
    

    public Spec() {
    }

    public Spec(String nameSpec, List<Review> reviews) {
        this.nameSpec = nameSpec;
        this.reviews = reviews;
    }

    public Long getIdSpec() {
        return idSpec;
    }

    public void setIdSpec(Long idSpec) {
        this.idSpec = idSpec;
    }

    public String getNameSpec() {
        return nameSpec;
    }

    public void setNameSpec(String nameSpec) {
        this.nameSpec = nameSpec;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

}
