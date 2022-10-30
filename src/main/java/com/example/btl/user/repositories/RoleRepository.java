package com.example.btl.user.repositories;

import com.example.btl.user.domains.Role;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {

  Optional<Role> findRoleByName(String name);
}
