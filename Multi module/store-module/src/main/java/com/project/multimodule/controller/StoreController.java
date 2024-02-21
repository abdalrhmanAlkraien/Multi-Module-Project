package com.project.multimodule.controller;

import com.project.multimodule.dto.StoreResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * @author: Abd-alrhman Alkraien.
 * @Date: 2/11/2024
 * @Time: 2:41 PM
 */
public interface StoreController {

    ResponseEntity getAllStore();
    ResponseEntity getStoreById(final Long id) throws Exception;
}
