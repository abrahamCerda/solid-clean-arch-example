package com.abraham.solidexample.domain.entity;

import java.util.Date;
import java.util.List;

public class CharacterEntity {
    private Integer id;
    private String name;
    private String status;
    private String species;
    private String type;
    private String gender;
    private LocationEntity origin;
    private LocationEntity locationEntity;
    private String imageUrl;
    private List<String> episodes;
    private String url;
    private Date created;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocationEntity getOrigin() {
        return origin;
    }

    public void setOrigin(LocationEntity origin) {
        this.origin = origin;
    }

    public LocationEntity getLocation() {
        return locationEntity;
    }

    public void setLocation(LocationEntity locationEntity) {
        this.locationEntity = locationEntity;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<String> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(List<String> episodes) {
        this.episodes = episodes;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
