package com.kmuniz.storeapi.store_api.rest;

import com.kmuniz.storeapi.store_api.model.CarVersionDTO;
import com.kmuniz.storeapi.store_api.service.CarVersionService;
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
@RequestMapping(value = "/api/carVersions", produces = MediaType.APPLICATION_JSON_VALUE)
public class CarVersionResource {

    private final CarVersionService carVersionService;

    public CarVersionResource(final CarVersionService carVersionService) {
        this.carVersionService = carVersionService;
    }

    @GetMapping
    public ResponseEntity<List<CarVersionDTO>> getAllCarVersions() {
        return ResponseEntity.ok(carVersionService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarVersionDTO> getCarVersion(@PathVariable(name = "id") final Long id) {
        return ResponseEntity.ok(carVersionService.get(id));
    }

    @PostMapping
    @ApiResponse(responseCode = "201")
    public ResponseEntity<Long> createCarVersion(
            @RequestBody @Valid final CarVersionDTO carVersionDTO) {
        final Long createdId = carVersionService.create(carVersionDTO);
        return new ResponseEntity<>(createdId, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Long> updateCarVersion(@PathVariable(name = "id") final Long id,
            @RequestBody @Valid final CarVersionDTO carVersionDTO) {
        carVersionService.update(id, carVersionDTO);
        return ResponseEntity.ok(id);
    }

    @DeleteMapping("/{id}")
    @ApiResponse(responseCode = "204")
    public ResponseEntity<Void> deleteCarVersion(@PathVariable(name = "id") final Long id) {
        carVersionService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
