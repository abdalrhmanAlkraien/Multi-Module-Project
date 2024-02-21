package com.project.multimodule.controller.module.store;

import com.project.multimodule.controller.StoreAdminController;
import com.project.multimodule.dto.StoreRequest;
import com.project.multimodule.service.StoreService;
import com.project.multimodule.util.GenericResponse;
import com.project.multimodule.util.PathConstant;
import jakarta.annotation.security.RolesAllowed;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author: Abd-alrhman Alkraien.
 * @Date: 2/11/2024
 * @Time: 2:58 PM
 */
@RestController
@RequestMapping(PathConstant.API_V1 + PathConstant.ADMIN_PATH + PathConstant.STORE_PATH)
@RequiredArgsConstructor
public class StoreAdminControllerImpl implements StoreAdminController {

    private final StoreService storeService;

    @PostMapping
    @Override
    public ResponseEntity<GenericResponse<Void>> createStore(@RequestBody StoreRequest storeRequest) {

        storeService.createStore(storeRequest);

        return ResponseEntity.ok(
                GenericResponse.success());
    }

    @Override
    @PutMapping("/{storeId}")
    public ResponseEntity<GenericResponse<Void>>  updateStore(@PathVariable("storeId") Long storeId,@RequestBody StoreRequest storeRequest) throws Exception {

        storeService.updateStore(storeId,storeRequest);
        return ResponseEntity.ok(
                GenericResponse.success());
    }

    @Override
    @DeleteMapping("/{storeId}")
    public ResponseEntity<GenericResponse<Void>>  deleteStoreById(@PathVariable Long storeId) throws Exception {

        storeService.deleteById(storeId);
        return ResponseEntity.ok(GenericResponse.success());
    }
}
