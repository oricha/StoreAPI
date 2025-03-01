package com.kmuniz.storeapi.store_api.service;

import com.kmuniz.storeapi.store_api.domain.CarMaker;
import com.kmuniz.storeapi.store_api.domain.CarModel;
import com.kmuniz.storeapi.store_api.domain.CarVersion;
import com.kmuniz.storeapi.store_api.model.CarVersionDTO;
import com.kmuniz.storeapi.store_api.repos.CarMakerRepository;
import com.kmuniz.storeapi.store_api.repos.CarModelRepository;
import com.kmuniz.storeapi.store_api.repos.CarVersionRepository;
import com.kmuniz.storeapi.store_api.util.NotFoundException;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class CarVersionService {

    private final CarVersionRepository carVersionRepository;
    private final CarMakerRepository carMakerRepository;
    private final CarModelRepository carModelRepository;

    public CarVersionService(final CarVersionRepository carVersionRepository,
            final CarMakerRepository carMakerRepository,
            final CarModelRepository carModelRepository) {
        this.carVersionRepository = carVersionRepository;
        this.carMakerRepository = carMakerRepository;
        this.carModelRepository = carModelRepository;
    }

    public List<CarVersionDTO> findAll() {
        final List<CarVersion> carVersions = carVersionRepository.findAll(Sort.by("id"));
        return carVersions.stream()
                .map(carVersion -> mapToDTO(carVersion, new CarVersionDTO()))
                .toList();
    }

    public CarVersionDTO get(final Long id) {
        return carVersionRepository.findById(id)
                .map(carVersion -> mapToDTO(carVersion, new CarVersionDTO()))
                .orElseThrow(NotFoundException::new);
    }

    public Long create(final CarVersionDTO carVersionDTO) {
        final CarVersion carVersion = new CarVersion();
        mapToEntity(carVersionDTO, carVersion);
        return carVersionRepository.save(carVersion).getId();
    }

    public void update(final Long id, final CarVersionDTO carVersionDTO) {
        final CarVersion carVersion = carVersionRepository.findById(id)
                .orElseThrow(NotFoundException::new);
        mapToEntity(carVersionDTO, carVersion);
        carVersionRepository.save(carVersion);
    }

    public void delete(final Long id) {
        carVersionRepository.deleteById(id);
    }

    private CarVersionDTO mapToDTO(final CarVersion carVersion, final CarVersionDTO carVersionDTO) {
        carVersionDTO.setId(carVersion.getId());
        carVersionDTO.setName(carVersion.getName());
        carVersionDTO.setVersion(carVersion.getVersion());
        carVersionDTO.setCarMaker(carVersion.getCarMaker() == null ? null : carVersion.getCarMaker().getId());
        carVersionDTO.setCarModel(carVersion.getCarModel() == null ? null : carVersion.getCarModel().getId());
        return carVersionDTO;
    }

    private CarVersion mapToEntity(final CarVersionDTO carVersionDTO, final CarVersion carVersion) {
        carVersion.setName(carVersionDTO.getName());
        carVersion.setVersion(carVersionDTO.getVersion());
        final CarMaker carMaker = carVersionDTO.getCarMaker() == null ? null : carMakerRepository.findById(carVersionDTO.getCarMaker())
                .orElseThrow(() -> new NotFoundException("carMaker not found"));
        carVersion.setCarMaker(carMaker);
        final CarModel carModel = carVersionDTO.getCarModel() == null ? null : carModelRepository.findById(carVersionDTO.getCarModel())
                .orElseThrow(() -> new NotFoundException("carModel not found"));
        carVersion.setCarModel(carModel);
        return carVersion;
    }

}
