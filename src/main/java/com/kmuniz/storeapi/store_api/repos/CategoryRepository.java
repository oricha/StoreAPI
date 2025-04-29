package com.kmuniz.storeapi.store_api.repos;

import com.kmuniz.storeapi.store_api.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Optional<Category> findByName(String name);
}
