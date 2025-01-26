package com.kmuniz.storeapi.domain;

import com.kmuniz.storeapi.domain.entity.Part;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PartRepository extends JpaRepository<Part, Long> {
    List<Part> findByNameContainingIgnoreCaseOrDescriptionContainingIgnoreCase(String name, String description);

}