package com.kmuniz.storeapi.store_api.rest;

import com.kmuniz.storeapi.store_api.model.PartsDTO;
import com.kmuniz.storeapi.store_api.service.PartsService;
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
@RequestMapping(value = "/api/partss", produces = MediaType.APPLICATION_JSON_VALUE)
public class PartsResource {

    private final PartsService partsService;

    public PartsResource(final PartsService partsService) {
        this.partsService = partsService;
    }

    @GetMapping
    public ResponseEntity<List<PartsDTO>> getAllPartss() {
        return ResponseEntity.ok(partsService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PartsDTO> getParts(@PathVariable(name = "id") final Long id) {
        return ResponseEntity.ok(partsService.get(id));
    }

    @PostMapping
    @ApiResponse(responseCode = "201")
    public ResponseEntity<Long> createParts(@RequestBody @Valid final PartsDTO partsDTO) {
        final Long createdId = partsService.create(partsDTO);
        return new ResponseEntity<>(createdId, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Long> updateParts(@PathVariable(name = "id") final Long id,
            @RequestBody @Valid final PartsDTO partsDTO) {
        partsService.update(id, partsDTO);
        return ResponseEntity.ok(id);
    }

    @DeleteMapping("/{id}")
    @ApiResponse(responseCode = "204")
    public ResponseEntity<Void> deleteParts(@PathVariable(name = "id") final Long id) {
        partsService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
