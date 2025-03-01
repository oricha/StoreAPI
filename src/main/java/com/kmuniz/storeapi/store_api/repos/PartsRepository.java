package com.kmuniz.storeapi.store_api.repos;

import com.kmuniz.storeapi.store_api.domain.Parts;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PartsRepository extends JpaRepository<Parts, Long> {
}
