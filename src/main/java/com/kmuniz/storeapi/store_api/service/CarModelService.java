package com.kmuniz.storeapi.store_api.service;

import com.kmuniz.storeapi.store_api.domain.CarMaker;
import com.kmuniz.storeapi.store_api.domain.CarModel;
import com.kmuniz.storeapi.store_api.domain.CarVersion;
import com.kmuniz.storeapi.store_api.model.CarModelDTO;
import com.kmuniz.storeapi.store_api.repos.CarMakerRepository;
import com.kmuniz.storeapi.store_api.repos.CarModelRepository;
import com.kmuniz.storeapi.store_api.repos.CarVersionRepository;
import com.kmuniz.storeapi.store_api.util.NotFoundException;
import com.kmuniz.storeapi.store_api.util.ReferencedWarning;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class CarModelService {

    private final CarModelRepository carModelRepository;
    private final CarMakerRepository carMakerRepository;
    private final CarVersionRepository carVersionRepository;

    public CarModelService(final CarModelRepository carModelRepository,
            final CarMakerRepository carMakerRepository,
            final CarVersionRepository carVersionRepository) {
        this.carModelRepository = carModelRepository;
        this.carMakerRepository = carMakerRepository;
        this.carVersionRepository = carVersionRepository;
    }

    public List<CarModelDTO> findAll() {
        final List<CarModel> carModels = carModelRepository.findAll(Sort.by("id"));
        return carModels.stream()
                .map(carModel -> mapToDTO(carModel, new CarModelDTO()))
                .toList();
    }

    public CarModelDTO get(final Long id) {
        return carModelRepository.findById(id)
                .map(carModel -> mapToDTO(carModel, new CarModelDTO()))
                .orElseThrow(NotFoundException::new);
    }

    public Long create(final CarModelDTO carModelDTO) {
        final CarModel carModel = new CarModel();
        mapToEntity(carModelDTO, carModel);
        return carModelRepository.save(carModel).getId();
    }

    public void update(final Long id, final CarModelDTO carModelDTO) {
        final CarModel carModel = carModelRepository.findById(id)
                .orElseThrow(NotFoundException::new);
        mapToEntity(carModelDTO, carModel);
        carModelRepository.save(carModel);
    }

    public void delete(final Long id) {
        carModelRepository.deleteById(id);
    }

    private CarModelDTO mapToDTO(final CarModel carModel, final CarModelDTO carModelDTO) {
        carModelDTO.setId(carModel.getId());
        carModelDTO.setName(carModel.getName());
        carModelDTO.setCarMaker(carModel.getCarMaker() == null ? null : carModel.getCarMaker().getId());
        return carModelDTO;
    }

    private CarModel mapToEntity(final CarModelDTO carModelDTO, final CarModel carModel) {
        carModel.setName(carModelDTO.getName());
        final CarMaker carMaker = carModelDTO.getCarMaker() == null ? null : carMakerRepository.findById(carModelDTO.getCarMaker())
                .orElseThrow(() -> new NotFoundException("carMaker not found"));
        carModel.setCarMaker(carMaker);
        return carModel;
    }

    public ReferencedWarning getReferencedWarning(final Long id) {
        final ReferencedWarning referencedWarning = new ReferencedWarning();
        final CarModel carModel = carModelRepository.findById(id)
                .orElseThrow(NotFoundException::new);
        final CarVersion carModelCarVersion = carVersionRepository.findFirstByCarModel(carModel);
        if (carModelCarVersion != null) {
            referencedWarning.setKey("carModel.carVersion.carModel.referenced");
            referencedWarning.addParam(carModelCarVersion.getId());
            return referencedWarning;
        }
        return null;
    }

    public List<CarModelDTO> findByCarMakerId(Long carMakerId) {
        return null;
    }
}
