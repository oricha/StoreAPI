package com.kmuniz.storeapi.domain;

import com.kmuniz.storeapi.domain.entity.CarMaker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarMakerRepository extends JpaRepository<CarMaker, Integer> {

    ThreadLocal<Object> findByName(String name);
}
