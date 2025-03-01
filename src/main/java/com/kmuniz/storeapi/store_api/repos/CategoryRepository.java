package com.kmuniz.storeapi.store_api.repos;

import com.kmuniz.storeapi.store_api.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
