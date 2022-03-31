package com.abraham.solidexample.domain.vo.builder;

import com.abraham.solidexample.domain.entity.Location;
import com.abraham.solidexample.domain.vo.LocationVO;

public class LocationVOBuilder {
    private Location location;

    public LocationVOBuilder withLocationDTO(Location location){
        this.location = location;
        return this;
    }

    public LocationVO build(){
        if(location == null){
            return null;
        }
        LocationVO locationVO = new LocationVO();
        locationVO.setName(this.location.getName());
        locationVO.setUrl(this.location.getUrl());
        locationVO.setDimension(this.location.getDimension());
        locationVO.setResidents(this.location.getResidents());
        return locationVO;
    }
}
