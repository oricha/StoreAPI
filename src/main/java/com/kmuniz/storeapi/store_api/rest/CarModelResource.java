package com.kmuniz.storeapi.store_api.rest;

import com.kmuniz.storeapi.store_api.model.CarModelDTO;
import com.kmuniz.storeapi.store_api.service.CarModelService;
import com.kmuniz.storeapi.store_api.util.ReferencedException;
import com.kmuniz.storeapi.store_api.util.ReferencedWarning;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/carModels", produces = MediaType.APPLICATION_JSON_VALUE)
public class CarModelResource {

    private final CarModelService carModelService;

    public CarModelResource(final CarModelService carModelService) {
        this.carModelService = carModelService;
    }

    @GetMapping
    public ResponseEntity<List<CarModelDTO>> getAllCarModels() {
        return ResponseEntity.ok(carModelService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarModelDTO> getCarModel(@PathVariable(name = "id") final Long id) {
        return ResponseEntity.ok(carModelService.get(id));
    }

    @PostMapping
    @ApiResponse(responseCode = "201")
    public ResponseEntity<Long> createCarModel(@RequestBody @Valid final CarModelDTO carModelDTO) {
        final Long createdId = carModelService.create(carModelDTO);
        return new ResponseEntity<>(createdId, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Long> updateCarModel(@PathVariable(name = "id") final Long id,
            @RequestBody @Valid final CarModelDTO carModelDTO) {
        carModelService.update(id, carModelDTO);
        return ResponseEntity.ok(id);
    }

    @DeleteMapping("/{id}")
    @ApiResponse(responseCode = "204")
    public ResponseEntity<Void> deleteCarModel(@PathVariable(name = "id") final Long id) {
        final ReferencedWarning referencedWarning = carModelService.getReferencedWarning(id);
        if (referencedWarning != null) {
            throw new ReferencedException(referencedWarning);
        }
        carModelService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
