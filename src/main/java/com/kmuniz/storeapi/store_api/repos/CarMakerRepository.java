package com.kmuniz.storeapi.store_api.repos;

import com.kmuniz.storeapi.store_api.domain.CarMaker;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CarMakerRepository extends JpaRepository<CarMaker, Long> {
}
