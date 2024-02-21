package com.project.multimodule.controller.module.store;

import com.project.multimodule.controller.StoreController;
import com.project.multimodule.dto.StoreResponse;
import com.project.multimodule.service.StoreService;
import com.project.multimodule.util.GenericResponse;
import com.project.multimodule.util.PathConstant;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: Abd-alrhman Alkraien.
 * @Date: 2/11/2024
 * @Time: 3:01 PM
 */

@RestController
@RequestMapping(PathConstant.API_V1 + PathConstant.STORE_PATH)
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class StoreControllerImpl implements StoreController {

    StoreService storeService;

    @Override
    @GetMapping
    public ResponseEntity<GenericResponse<List<StoreResponse>>> getAllStore() {

        return ResponseEntity
                .ok(GenericResponse.success(storeService.getAllStore()));
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<GenericResponse<StoreResponse>> getStoreById(@PathVariable("id") final Long id) throws Exception {

        return ResponseEntity.ok(
                GenericResponse.success(storeService.getStoreById(id)));
    }
}
