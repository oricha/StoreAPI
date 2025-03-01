package com.kmuniz.storeapi.store_api.rest;

import com.kmuniz.storeapi.store_api.model.CarMakerDTO;
import com.kmuniz.storeapi.store_api.service.CarMakerService;
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
@RequestMapping(value = "/api/carMakers", produces = MediaType.APPLICATION_JSON_VALUE)
public class CarMakerResource {

    private final CarMakerService carMakerService;

    public CarMakerResource(final CarMakerService carMakerService) {
        this.carMakerService = carMakerService;
    }

    @GetMapping
    public ResponseEntity<List<CarMakerDTO>> getAllCarMakers() {
        return ResponseEntity.ok(carMakerService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarMakerDTO> getCarMaker(@PathVariable(name = "id") final Long id) {
        return ResponseEntity.ok(carMakerService.get(id));
    }

    @PostMapping
    @ApiResponse(responseCode = "201")
    public ResponseEntity<Long> createCarMaker(@RequestBody @Valid final CarMakerDTO carMakerDTO) {
        final Long createdId = carMakerService.create(carMakerDTO);
        return new ResponseEntity<>(createdId, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Long> updateCarMaker(@PathVariable(name = "id") final Long id,
            @RequestBody @Valid final CarMakerDTO carMakerDTO) {
        carMakerService.update(id, carMakerDTO);
        return ResponseEntity.ok(id);
    }

    @DeleteMapping("/{id}")
    @ApiResponse(responseCode = "204")
    public ResponseEntity<Void> deleteCarMaker(@PathVariable(name = "id") final Long id) {
        final ReferencedWarning referencedWarning = carMakerService.getReferencedWarning(id);
        if (referencedWarning != null) {
            throw new ReferencedException(referencedWarning);
        }
        carMakerService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
