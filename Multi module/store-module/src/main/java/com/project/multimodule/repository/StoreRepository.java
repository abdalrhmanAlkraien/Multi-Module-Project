package com.project.multimodule.repository;

import com.project.multimodule.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author: Abd-alrhman Alkraien.
 * @Date: 2/11/2024
 * @Time: 2:48 PM
 */
@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {
}
