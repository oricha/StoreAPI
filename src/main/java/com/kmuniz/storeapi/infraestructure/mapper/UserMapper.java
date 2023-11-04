package com.kmuniz.storeapi.infraestructure.mapper;

import com.kmuniz.storeapi.domain.User;
import com.kmuniz.storeapi.domain.entity.UserEntity;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mappings({
            @Mapping(source = "id",target = "id"),
            @Mapping(source = "username",target = "username"),
            @Mapping(source = "password",target = "password"),
            @Mapping(source = "name",target = "name"),
            @Mapping(source = "surname",target = "surname"),
            @Mapping(source = "email",target = "email"),
            @Mapping(source = "userType",target = "userType"),
            @Mapping(source = "dateCreated",target = "dateCreated")
    })
    UserEntity toEntity(User user);
    User toDomain(UserEntity userEntity);
    Iterable<User> toDomainIterable(Iterable<UserEntity> userEntities);
    @InheritConfiguration
    UserEntity toEntity(UserEntity userEntity);
}
