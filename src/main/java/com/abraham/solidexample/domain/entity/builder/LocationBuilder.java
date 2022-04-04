package com.abraham.solidexample.domain.entity.builder;

import com.abraham.solidexample.infrastructure.gateway.dto.LocationDTO;
import com.abraham.solidexample.domain.entity.Location;

public class LocationBuilder {

    private LocationDTO locationDTO;

    public LocationBuilder withLocationDTO(LocationDTO locationDTO){
        this.locationDTO = locationDTO;
        return this;
    }

    public Location build(){
        if(locationDTO == null){
            return null;
        }
        Location location = new Location();
        location.setId(this.locationDTO.getId());
        location.setName(this.locationDTO.getName());
        location.setDimension(this.locationDTO.getDimension());
        location.setResidents(this.locationDTO.getResidents());
        location.setCreated(this.locationDTO.getCreated());
        location.setUrl(this.locationDTO.getUrl());
        location.setType(this.locationDTO.getType());
        return location;
    }
}
