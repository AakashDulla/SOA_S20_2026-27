package com.example.CinePass.DTO;

public class TheatreDTO {
    private String theatreName;
    private String theatreLocation;
    private Integer theatreCapacity;
    private String theatreScreenType;

    public TheatreDTO() {}

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
}