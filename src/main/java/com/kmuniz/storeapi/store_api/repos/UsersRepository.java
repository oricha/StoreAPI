package com.kmuniz.storeapi.store_api.repos;

import com.kmuniz.storeapi.store_api.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsersRepository extends JpaRepository<Users, Integer> {
}
