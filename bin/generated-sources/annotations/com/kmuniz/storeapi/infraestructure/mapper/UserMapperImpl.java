package com.kmuniz.storeapi.infraestructure.mapper;

import com.kmuniz.storeapi.domain.User;
import com.kmuniz.storeapi.domain.entity.UserEntity;
import java.util.ArrayList;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-25T13:19:48+0100",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.41.0.z20250115-2156, environment: Java 21.0.5 (Eclipse Adoptium)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserEntity toEntity(User user) {
        if ( user == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setId( user.getId() );
        userEntity.setUsername( user.getUsername() );
        userEntity.setPassword( user.getPassword() );
        userEntity.setName( user.getName() );
        userEntity.setSurname( user.getSurname() );
        userEntity.setEmail( user.getEmail() );
        userEntity.setUserType( user.getUserType() );
        userEntity.setDateCreated( user.getDateCreated() );

        return userEntity;
    }

    @Override
    public User toDomain(UserEntity userEntity) {
        if ( userEntity == null ) {
            return null;
        }

        User user = new User();

        user.setDateCreated( userEntity.getDateCreated() );
        user.setEmail( userEntity.getEmail() );
        user.setId( userEntity.getId() );
        user.setName( userEntity.getName() );
        user.setPassword( userEntity.getPassword() );
        user.setSurname( userEntity.getSurname() );
        user.setUserType( userEntity.getUserType() );
        user.setUsername( userEntity.getUsername() );

        return user;
    }

    @Override
    public Iterable<User> toDomainIterable(Iterable<UserEntity> userEntities) {
        if ( userEntities == null ) {
            return null;
        }

        ArrayList<User> iterable = new ArrayList<User>();
        for ( UserEntity userEntity : userEntities ) {
            iterable.add( toDomain( userEntity ) );
        }

        return iterable;
    }

    @Override
    public UserEntity toEntity(UserEntity userEntity) {
        if ( userEntity == null ) {
            return null;
        }

        UserEntity userEntity1 = new UserEntity();

        userEntity1.setDateCreated( userEntity.getDateCreated() );
        userEntity1.setEmail( userEntity.getEmail() );
        userEntity1.setId( userEntity.getId() );
        userEntity1.setName( userEntity.getName() );
        userEntity1.setPassword( userEntity.getPassword() );
        userEntity1.setSurname( userEntity.getSurname() );
        userEntity1.setUserType( userEntity.getUserType() );
        userEntity1.setUsername( userEntity.getUsername() );

        return userEntity1;
    }
}
