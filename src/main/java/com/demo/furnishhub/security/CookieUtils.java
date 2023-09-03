package com.demo.furnishhub.security;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;

public class CookieUtils {

    public static void setTokenCookie(HttpServletResponse response, String name, String value, int maxAge) {
        System.out.println(value);
        ResponseCookie resCookie = ResponseCookie.from(name, value)
                .httpOnly(true)
                .sameSite("None")
                .path("/")
                .maxAge(Math.toIntExact(maxAge))
                .build();
        response.addHeader("Set-Cookie", resCookie.toString());
    }

    public static String getTokenFromCookie(HttpServletRequest request, String name) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(name)) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }
}
