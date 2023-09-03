package com.demo.furnishhub.repository;

import com.demo.furnishhub.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByEmail(String email);
    // boolean existsByUsername(String username);
}
