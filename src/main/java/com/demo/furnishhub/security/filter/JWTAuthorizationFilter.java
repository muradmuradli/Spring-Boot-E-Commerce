package com.demo.furnishhub.security.filter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.demo.furnishhub.security.CookieUtils;
import com.demo.furnishhub.security.SecurityConstants;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Arrays;

public class JWTAuthorizationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = CookieUtils.getTokenFromCookie(request, "FURNISH_HUB");

        if (token != null) {
            try {
                String user = JWT.require(Algorithm.HMAC512(SecurityConstants.SECRET_KEY))
                        .build()
                        .verify(token)
                        .getSubject();

                if (user != null) {
                    Authentication authentication = new UsernamePasswordAuthenticationToken(user, null, Arrays.asList());
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            } catch (Exception e) {
                // Token verification failed, you can handle this as needed
                SecurityContextHolder.clearContext();
            }
        }

        filterChain.doFilter(request, response);
    }
}
