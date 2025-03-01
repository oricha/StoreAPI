package com.kmuniz.storeapi.store_api.service;

import com.kmuniz.storeapi.store_api.domain.CarMaker;
import com.kmuniz.storeapi.store_api.domain.CarModel;
import com.kmuniz.storeapi.store_api.domain.CarVersion;
import com.kmuniz.storeapi.store_api.model.CarMakerDTO;
import com.kmuniz.storeapi.store_api.repos.CarMakerRepository;
import com.kmuniz.storeapi.store_api.repos.CarModelRepository;
import com.kmuniz.storeapi.store_api.repos.CarVersionRepository;
import com.kmuniz.storeapi.store_api.util.NotFoundException;
import com.kmuniz.storeapi.store_api.util.ReferencedWarning;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class CarMakerService {

    private final CarMakerRepository carMakerRepository;
    private final CarModelRepository carModelRepository;
    private final CarVersionRepository carVersionRepository;

    public CarMakerService(final CarMakerRepository carMakerRepository,
            final CarModelRepository carModelRepository,
            final CarVersionRepository carVersionRepository) {
        this.carMakerRepository = carMakerRepository;
        this.carModelRepository = carModelRepository;
        this.carVersionRepository = carVersionRepository;
    }

    public List<CarMakerDTO> findAll() {
        final List<CarMaker> carMakers = carMakerRepository.findAll(Sort.by("id"));
        return carMakers.stream()
                .map(carMaker -> mapToDTO(carMaker, new CarMakerDTO()))
                .toList();
    }

    public CarMakerDTO get(final Long id) {
        return carMakerRepository.findById(id)
                .map(carMaker -> mapToDTO(carMaker, new CarMakerDTO()))
                .orElseThrow(NotFoundException::new);
    }

    public Long create(final CarMakerDTO carMakerDTO) {
        final CarMaker carMaker = new CarMaker();
        mapToEntity(carMakerDTO, carMaker);
        return carMakerRepository.save(carMaker).getId();
    }

    public void update(final Long id, final CarMakerDTO carMakerDTO) {
        final CarMaker carMaker = carMakerRepository.findById(id)
                .orElseThrow(NotFoundException::new);
        mapToEntity(carMakerDTO, carMaker);
        carMakerRepository.save(carMaker);
    }

    public void delete(final Long id) {
        carMakerRepository.deleteById(id);
    }

    private CarMakerDTO mapToDTO(final CarMaker carMaker, final CarMakerDTO carMakerDTO) {
        carMakerDTO.setId(carMaker.getId());
        carMakerDTO.setName(carMaker.getName());
        return carMakerDTO;
    }

    private CarMaker mapToEntity(final CarMakerDTO carMakerDTO, final CarMaker carMaker) {
        carMaker.setName(carMakerDTO.getName());
        return carMaker;
    }

    public ReferencedWarning getReferencedWarning(final Long id) {
        final ReferencedWarning referencedWarning = new ReferencedWarning();
        final CarMaker carMaker = carMakerRepository.findById(id)
                .orElseThrow(NotFoundException::new);
        final CarModel carMakerCarModel = carModelRepository.findFirstByCarMaker(carMaker);
        if (carMakerCarModel != null) {
            referencedWarning.setKey("carMaker.carModel.carMaker.referenced");
            referencedWarning.addParam(carMakerCarModel.getId());
            return referencedWarning;
        }
        final CarVersion carMakerCarVersion = carVersionRepository.findFirstByCarMaker(carMaker);
        if (carMakerCarVersion != null) {
            referencedWarning.setKey("carMaker.carVersion.carMaker.referenced");
            referencedWarning.addParam(carMakerCarVersion.getId());
            return referencedWarning;
        }
        return null;
    }

}
