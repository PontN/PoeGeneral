package fr.epsi.poe.mobile.projetjava.restaurant.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nicolas on 13/07/2016.
 */
public class Restaurant implements Serializable {

    private Geometry geometry;
    private String id;
    private String name;
    private List<Photos>Photos = new ArrayList<Photos>();
    private String place_id;
    private Float rating;
    private String vicinity;
    private OpeningHours opening_hours;
    private Double price_level;



    public Geometry getGeometry() {
        return geometry;
    }
    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public List<Photos> getPhotos() {
        return Photos;
    }
    public void setPhotos(List<Photos> photos) {
        Photos = photos;
    }

    public String getPlace_id() {
        return place_id;
    }
    public void setPlace_id(String place_id) {
        this.place_id = place_id;
    }

    public Float getRating() {
        return rating;
    }
    public void setRating(Float rating) {
        this.rating = rating;
    }

    public String getVicinity() {
        return vicinity;
    }
    public void setVicinity(String vicinity) {
        this.vicinity = vicinity;
    }

    public OpeningHours getOpening_hours() {
        return opening_hours;
    }
    public void setOpening_hours(OpeningHours opening_hours) {
        this.opening_hours = opening_hours;
    }

    public Double getPrice_level() {
        return price_level;
    }
    public void setPrice_level(Double price_level) {
        this.price_level = price_level;
    }

}
