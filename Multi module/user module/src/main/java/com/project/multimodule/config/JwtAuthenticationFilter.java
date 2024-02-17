package com.project.multimodule.config;

import com.project.multimodule.service.JwtService;
import com.project.multimodule.service.UserService;
import io.micrometer.common.util.StringUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static org.springframework.util.StringUtils.hasText;

/**
 * @author: Abd-alrhman Alkraien.
 * @Date: 2/10/2024
 * @Time: 9:06 PM
 */
@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final UserService userService;
    private final JwtConfig jwtConfig;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain chain
    ) throws ServletException, IOException {

        // Get authorization header and validate
        var authToken = getJwtAccessToken(request.getHeader(HttpHeaders.AUTHORIZATION));

        String jwtToken;

        if (authToken.isEmpty()) {
            chain.doFilter(request, response);
            return;
        } else jwtToken = authToken.get();

        // Get user identity and set it on the spring security context
        var userDetails = this.userService
                .findByUsernameIgnoreCase(jwtService.getEmailFromToken(jwtToken));

        var authentication = new UsernamePasswordAuthenticationToken(
                userDetails, null,
                userDetails == null ? List.of() : userDetails.getAuthorities());

        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        chain.doFilter(request, response);

    }

    private Optional<String> getJwtAccessToken(String header) {
        //check header value is exists
        if (hasText(header) && header.startsWith(jwtConfig.getTokenPrefix())) {
            // Get jwt token and validate
            var token = header.split(" ")[1].trim();
            if (jwtService.validate(token))
                return Optional.of(token);
        }
        return Optional.empty();
    }
}
