package com.project.multimodule.mapper;

import com.project.multimodule.dto.StoreRequest;
import com.project.multimodule.dto.StoreResponse;
import com.project.multimodule.model.Store;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author: Abd-alrhman Alkraien.
 * @Date: 2/11/2024
 * @Time: 2:50 PM
 */
@Mapper(componentModel = "spring")
public interface StoreMapper {

    StoreResponse toDto(Store store);

    List<StoreResponse> toDto(List<Store> stores);

    Store toEntity(StoreRequest storeRequest);
}
