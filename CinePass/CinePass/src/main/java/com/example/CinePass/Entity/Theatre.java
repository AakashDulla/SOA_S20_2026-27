package com.example.CinePass.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Theatre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String theatreName;
    private String theatreLocation;
    private Integer theatreCapacity;
    private String theatreScreenType;

    @OneToMany(mappedBy = "theatre", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Show> show;

    public Theatre() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTheatreName() {
        return theatreName;
    }

    public void setTheatreName(String theatreName) {
        this.theatreName = theatreName;
    }

    public String getTheatreLocation() {
        return theatreLocation;
    }

    public void setTheatreLocation(String theatreLocation) {
        this.theatreLocation = theatreLocation;
    }

    public Integer getTheatreCapacity() {
        return theatreCapacity;
    }

    public void setTheatreCapacity(Integer theatreCapacity) {
        this.theatreCapacity = theatreCapacity;
    }

    public String getTheatreScreenType() {
        return theatreScreenType;
    }

    public void setTheatreScreenType(String theatreScreenType) {
        this.theatreScreenType = theatreScreenType;
    }

    public List<Show> getShow() {
        return show;
    }

    public void setShow(List<Show> show) {
        this.show = show;
    }
}