package com.kmuniz.storeapi.store_api.repos;

import com.kmuniz.storeapi.store_api.domain.Parts;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface PartsRepository extends JpaRepository<Parts, Long> {


        List<Parts> findByBrandIdAndModelIdAndEngineIdAndPartName(Long categoryId, Long brandId, Long price, String condition);

}
