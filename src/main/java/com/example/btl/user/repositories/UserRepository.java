package com.example.btl.user.repositories;

import com.example.btl.user.domains.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

  Optional<User> findUserByUsername(String username);

  boolean existsByUsername(String username);
}
