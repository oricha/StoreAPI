package com.kmuniz.storeapi.store_api.domain.part;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PartRepository extends JpaRepository<Part, Long> {
    List<Part> findByNameContainingIgnoreCaseOrDescriptionContainingIgnoreCase(String name, String description);
    List<Part> findByNameContainingIgnoreCase(String name);
}
