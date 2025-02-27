package com.kmuniz.storeapi.store_api.domain.user_entity;

import org.springframework.data.jpa.repository.JpaRepository;


public interface UserEntityRepository extends JpaRepository<UserEntity, Long> {
}
