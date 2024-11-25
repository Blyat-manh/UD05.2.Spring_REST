package com.example.empresa2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.empresa2.model.Empleado;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, String> {
    Empleado findByDni(String dni);
}
