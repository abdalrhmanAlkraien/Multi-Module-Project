package com.project.multimodule.service;

import com.project.multimodule.dto.StoreRequest;
import com.project.multimodule.dto.StoreResponse;

import java.util.List;

/**
 * @author: Abd-alrhman Alkraien.
 * @Date: 2/11/2024
 * @Time: 2:48 PM
 */
public interface StoreService {

    void createStore(final StoreRequest storeRequest);
    void updateStore(Long storeId, final StoreRequest storeRequest) throws Exception;

    void deleteById(final Long id) throws Exception;

    List<StoreResponse> getAllStore();

    StoreResponse getStoreById(final Long id) throws Exception;
}
