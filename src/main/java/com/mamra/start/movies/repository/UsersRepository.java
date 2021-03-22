package com.mamra.start.movies.repository;

import com.mamra.start.movies.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, Long> {
    Optional<Users> findByName(String userName);
}
