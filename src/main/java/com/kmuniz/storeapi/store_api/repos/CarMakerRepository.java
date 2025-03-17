package com.kmuniz.storeapi.store_api.repos;

import com.kmuniz.storeapi.store_api.domain.CarMaker;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface CarMakerRepository extends JpaRepository<CarMaker, Long> {
    Optional<CarMaker> findByNameContainingIgnoreCase(String name);
}
