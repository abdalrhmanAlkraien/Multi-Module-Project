package com.project.multimodule.service.impl;

import com.project.multimodule.dto.SignInRequest;
import com.project.multimodule.dto.SignupRequest;
import com.project.multimodule.dto.response.SignInResponse;
import com.project.multimodule.mapper.UserMapper;
import com.project.multimodule.model.UserEntity;
import com.project.multimodule.model.enumeration.Role;
import com.project.multimodule.repository.UserRepository;
import com.project.multimodule.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author: Abd-alrhman Alkraien.
 * @Date: 2/10/2024
 * @Time: 6:29 PM
 */
@Service
@RequiredArgsConstructor
@Log4j2
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;
    private final JwtServiceImpl jwtService;
    private final AuthenticationManager authenticationManager;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;


    @Override
    public void signUp(SignupRequest request) {


        UserEntity userEntity = userMapper.signUpMapper(request);
        userEntity.setPassword(passwordEncoder.encode(request.getPassword()));
        userEntity.setRole(Role.USER);
        userRepository.save(userEntity);
    }

    @Override
    public SignInResponse signIn(SignInRequest request) throws Exception {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

        var user = userRepository
                .findByEmail(request.getEmail())
                .orElseThrow(() -> new Exception("cannot find user"));

        var jwt = jwtService.generateToken(user);
        return new SignInResponse(jwt);
    }

    @Override
    public void createAdminUser(final SignupRequest request) {

        UserEntity userEntity = userMapper.signUpMapper(request);
        userEntity.setPassword(passwordEncoder.encode(request.getPassword()));
        userEntity.setRole(Role.ADMIN);
        userRepository.save(userEntity);
    }
}
