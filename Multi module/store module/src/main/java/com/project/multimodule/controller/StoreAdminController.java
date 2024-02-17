package com.project.multimodule.controller;

import com.project.multimodule.dto.StoreRequest;
import org.springframework.http.ResponseEntity;

/**
 * @author: Abd-alrhman Alkraien.
 * @Date: 2/11/2024
 * @Time: 2:42 PM
 */
public interface StoreAdminController {

    ResponseEntity createStore(final StoreRequest storeRequest);

    ResponseEntity  updateStore(final Long storeId, final StoreRequest storeRequest) throws Exception;

    ResponseEntity  deleteStoreById(final Long storeId) throws Exception;
}
