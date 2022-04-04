package com.abraham.solidexample.infrastructure.gateway;

import com.abraham.solidexample.infrastructure.gateway.dto.LocationDTO;

public interface LocationRepository {
    LocationDTO findById(Integer id);
}
