package com.project.multimodule.service;

import com.project.multimodule.model.UserEntity;
import org.hibernate.sql.results.internal.StandardEntityGraphTraversalStateImpl;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author: Abd-alrhman Alkraien.
 * @Date: 2/10/2024
 * @Time: 6:17 PM
 */
public interface UserService {

    UserDetailsService userDetailsService();
    UserEntity findByUsernameIgnoreCase(final String email);

}
