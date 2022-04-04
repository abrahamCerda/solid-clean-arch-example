package com.abraham.solidexample.infrastructure.controller.v1.vo.builder;

import com.abraham.solidexample.domain.entity.LocationEntity;
import com.abraham.solidexample.infrastructure.controller.v1.vo.LocationVO;

public class LocationVOBuilder {
    private LocationEntity locationEntity;

    public LocationVOBuilder withLocationDTO(LocationEntity locationEntity){
        this.locationEntity = locationEntity;
        return this;
    }

    public LocationVO build(){
        if(locationEntity == null){
            return null;
        }
        LocationVO locationVO = new LocationVO();
        locationVO.setName(this.locationEntity.getName());
        locationVO.setUrl(this.locationEntity.getUrl());
        locationVO.setDimension(this.locationEntity.getDimension());
        locationVO.setResidents(this.locationEntity.getResidents());
        return locationVO;
    }
}
