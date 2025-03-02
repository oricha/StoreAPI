package com.kmuniz.storeapi.store_api.repos;

import com.kmuniz.storeapi.store_api.domain.Parts;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface PartsRepository extends JpaRepository<Parts, Long> {


        List<Parts> findByCriteria(Long brandId, Long modelId, Long engineId, String partName);

}
