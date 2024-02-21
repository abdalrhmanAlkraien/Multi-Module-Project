package com.project.multimodule.service.impl;

import com.project.multimodule.dto.StoreRequest;
import com.project.multimodule.dto.StoreResponse;
import com.project.multimodule.mapper.StoreMapper;
import com.project.multimodule.model.Store;
import com.project.multimodule.repository.StoreRepository;
import com.project.multimodule.service.StoreService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: Abd-alrhman Alkraien.
 * @Date: 2/11/2024
 * @Time: 2:48 PM
 */
@Service
@Log4j2
@RequiredArgsConstructor
public class StoreServiceImpl implements StoreService {

    private final StoreMapper storeMapper;
    private final StoreRepository storeRepository;

    @Override
    public void createStore(StoreRequest storeRequest) {

        storeRepository.save(storeMapper.toEntity(storeRequest));
    }

    @Override
    public void updateStore(Long storeId,StoreRequest storeRequest) throws Exception {

        storeRepository.findById(storeId).orElseThrow(()-> new Exception("Cannot find it"));
        Store store = storeMapper.toEntity(storeRequest);

        store.setId(storeId);
        storeRepository.save(store);
    }

    @Override
    public void deleteById(final Long storeId) throws Exception {

        storeRepository.findById(storeId).orElseThrow(()-> new Exception("Cannot find it"));
        storeRepository.deleteById(storeId);
    }

    @Override
    public List<StoreResponse> getAllStore() {

        return storeMapper.toDto(storeRepository.findAll());
    }

    @Override
    public StoreResponse getStoreById(final Long storeId) throws Exception {


        return storeMapper
                .toDto(storeRepository.findById(storeId)
                        .orElseThrow(()-> new Exception("Cannot find it")));
    }
}
