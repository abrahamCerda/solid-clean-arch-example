package com.abraham.solidexample.repository;

import com.abraham.solidexample.domain.dto.LocationDTO;

public interface LocationRepository {
    LocationDTO findById(Integer id);
}
