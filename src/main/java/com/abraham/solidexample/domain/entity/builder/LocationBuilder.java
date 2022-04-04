package com.abraham.solidexample.domain.entity.builder;

import com.abraham.solidexample.infrastructure.gateway.dto.LocationDTO;
import com.abraham.solidexample.domain.entity.LocationEntity;

public class LocationBuilder {

    private LocationDTO locationDTO;

    public LocationBuilder withLocationDTO(LocationDTO locationDTO){
        this.locationDTO = locationDTO;
        return this;
    }

    public LocationEntity build(){
        if(locationDTO == null){
            return null;
        }
        LocationEntity locationEntity = new LocationEntity();
        locationEntity.setId(this.locationDTO.getId());
        locationEntity.setName(this.locationDTO.getName());
        locationEntity.setDimension(this.locationDTO.getDimension());
        locationEntity.setResidents(this.locationDTO.getResidents());
        locationEntity.setCreated(this.locationDTO.getCreated());
        locationEntity.setUrl(this.locationDTO.getUrl());
        locationEntity.setType(this.locationDTO.getType());
        return locationEntity;
    }
}
