package com.ejemplo.SpringBoot.security.repository;

import com.ejemplo.SpringBoot.security.enums.RolNombre;
import com.ejemplo.SpringBoot.security.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
