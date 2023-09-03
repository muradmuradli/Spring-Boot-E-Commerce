package com.demo.furnishhub.web;

import com.demo.furnishhub.entity.User;
import com.demo.furnishhub.service.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
@RequestMapping("/user")
public class UserController {

    UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<String> findById(@PathVariable Long id) {
        return new ResponseEntity<>(userService.getUser(id).getEmail(), HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping("/lmao")
    public ResponseEntity<String> fuck() {
        System.out.println("Hitting the endpoint");
        return new ResponseEntity<>("Dick", HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping("/register")
    public ResponseEntity<HttpStatus> createUser(@Valid @RequestBody User user) {
        userService.saveUser(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) {
        // Invalidate the user's session if you're using sessions
        request.getSession().invalidate();

        // Remove the JWT cookie
        Cookie jwtCookie = new Cookie("FURNISH_HUB", null);
        jwtCookie.setMaxAge(0); // Set the cookie's max age to 0 to delete it
        jwtCookie.setPath("/");
        jwtCookie.setHttpOnly(true);
        response.addCookie(jwtCookie);
    }

}