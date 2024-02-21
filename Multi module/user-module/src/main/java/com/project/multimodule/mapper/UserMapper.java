package com.project.multimodule.mapper;

import com.project.multimodule.dto.SignupRequest;
import com.project.multimodule.model.UserEntity;
import org.mapstruct.Mapper;

/**
 * @author: Abd-alrhman Alkraien.
 * @Date: 2/10/2024
 * @Time: 8:40 PM
 */
@Mapper(componentModel = "spring")
public interface UserMapper {


    UserEntity signUpMapper(SignupRequest signupRequest);
}
