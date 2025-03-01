package com.kmuniz.storeapi.store_api.service;

import com.kmuniz.storeapi.store_api.domain.Parts;
import com.kmuniz.storeapi.store_api.model.PartsDTO;
import com.kmuniz.storeapi.store_api.repos.PartsRepository;
import com.kmuniz.storeapi.store_api.util.NotFoundException;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class PartsService {

    private final PartsRepository partsRepository;

    public PartsService(final PartsRepository partsRepository) {
        this.partsRepository = partsRepository;
    }

    public List<PartsDTO> findAll() {
        final List<Parts> partses = partsRepository.findAll(Sort.by("id"));
        return partses.stream()
                .map(parts -> mapToDTO(parts, new PartsDTO()))
                .toList();
    }

    public PartsDTO get(final Long id) {
        return partsRepository.findById(id)
                .map(parts -> mapToDTO(parts, new PartsDTO()))
                .orElseThrow(NotFoundException::new);
    }

    public Long create(final PartsDTO partsDTO) {
        final Parts parts = new Parts();
        mapToEntity(partsDTO, parts);
        return partsRepository.save(parts).getId();
    }

    public void update(final Long id, final PartsDTO partsDTO) {
        final Parts parts = partsRepository.findById(id)
                .orElseThrow(NotFoundException::new);
        mapToEntity(partsDTO, parts);
        partsRepository.save(parts);
    }

    public void delete(final Long id) {
        partsRepository.deleteById(id);
    }

    private PartsDTO mapToDTO(final Parts parts, final PartsDTO partsDTO) {
        partsDTO.setId(parts.getId());
        partsDTO.setName(parts.getName());
        partsDTO.setDescription(parts.getDescription());
        partsDTO.setPrice(parts.getPrice());
        partsDTO.setCategory(parts.getCategory());
        partsDTO.setBrand(parts.getBrand());
        partsDTO.setModel(parts.getModel());
        partsDTO.setImageUrl(parts.getImageUrl());
        return partsDTO;
    }

    private Parts mapToEntity(final PartsDTO partsDTO, final Parts parts) {
        parts.setName(partsDTO.getName());
        parts.setDescription(partsDTO.getDescription());
        parts.setPrice(partsDTO.getPrice());
        parts.setCategory(partsDTO.getCategory());
        parts.setBrand(partsDTO.getBrand());
        parts.setModel(partsDTO.getModel());
        parts.setImageUrl(partsDTO.getImageUrl());
        return parts;
    }

}
