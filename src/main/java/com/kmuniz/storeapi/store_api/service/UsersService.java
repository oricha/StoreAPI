package com.kmuniz.storeapi.store_api.service;

import com.kmuniz.storeapi.store_api.domain.Users;
import com.kmuniz.storeapi.store_api.model.UsersDTO;
import com.kmuniz.storeapi.store_api.repos.UsersRepository;
import com.kmuniz.storeapi.store_api.util.NotFoundException;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class UsersService {

    private final UsersRepository usersRepository;

    public UsersService(final UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public List<UsersDTO> findAll() {
        final List<Users> userses = usersRepository.findAll(Sort.by("id"));
        return userses.stream()
                .map(users -> mapToDTO(users, new UsersDTO()))
                .toList();
    }

    public UsersDTO get(final Integer id) {
        return usersRepository.findById(id)
                .map(users -> mapToDTO(users, new UsersDTO()))
                .orElseThrow(NotFoundException::new);
    }

    public Integer create(final UsersDTO usersDTO) {
        final Users users = new Users();
        mapToEntity(usersDTO, users);
        return usersRepository.save(users).getId();
    }

    public void update(final Integer id, final UsersDTO usersDTO) {
        final Users users = usersRepository.findById(id)
                .orElseThrow(NotFoundException::new);
        mapToEntity(usersDTO, users);
        usersRepository.save(users);
    }

    public void delete(final Integer id) {
        usersRepository.deleteById(id);
    }

    private UsersDTO mapToDTO(final Users users, final UsersDTO usersDTO) {
        usersDTO.setId(users.getId());
        usersDTO.setUsername(users.getUsername());
        usersDTO.setPassword(users.getPassword());
        usersDTO.setName(users.getName());
        usersDTO.setSurname(users.getSurname());
        usersDTO.setEmail(users.getEmail());
        usersDTO.setUserType(users.getUserType());
        usersDTO.setDateCreated(users.getDateCreated());
        return usersDTO;
    }

    private Users mapToEntity(final UsersDTO usersDTO, final Users users) {
        users.setUsername(usersDTO.getUsername());
        users.setPassword(usersDTO.getPassword());
        users.setName(usersDTO.getName());
        users.setSurname(usersDTO.getSurname());
        users.setEmail(usersDTO.getEmail());
        users.setUserType(usersDTO.getUserType());
        users.setDateCreated(usersDTO.getDateCreated());
        return users;
    }

}
