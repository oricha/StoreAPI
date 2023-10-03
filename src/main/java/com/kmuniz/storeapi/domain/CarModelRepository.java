package com.kmuniz.storeapi.domain;

import com.kmuniz.storeapi.domain.entity.CarModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarModelRepository extends JpaRepository<CarModel, Integer> {
    Iterable<CarModel> findByBrandName(String brandName);
}
