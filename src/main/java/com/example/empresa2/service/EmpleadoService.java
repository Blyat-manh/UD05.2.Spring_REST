package com.example.empresa2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.empresa2.model.Empleado;
import com.example.empresa2.repository.EmpleadoRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Service
public class EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    public List<Empleado> obtenerTodosLosEmpleados() {
        return empleadoRepository.findAll();
    }

    public Empleado obtenerEmpleadoPorDni(String dni) {
        return empleadoRepository.findByDni(dni);
    }

    public Empleado guardarEmpleado(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    public void eliminarEmpleado(String dni) {
        empleadoRepository.deleteById(dni);
    }
    
    
    @PersistenceContext
    private EntityManager entityManager;
    
    public int calcularSalario(Empleado empleado) {
        String query = "SELECT n.sueldo FROM Nomina n WHERE n.categoria = :categoria";

        TypedQuery<Integer> salarioBaseQuery = entityManager.createQuery(query, Integer.class);
        salarioBaseQuery.setParameter("categoria", empleado.getCategoria());

        Integer sueldoBase = salarioBaseQuery.getSingleResult();

        if (sueldoBase == null) {
            throw new IllegalArgumentException("No se encontró salario base para la categoría: " + empleado.getCategoria());
        }

        int salarioFinal = sueldoBase + (5000 * empleado.getAniosTrabajados());
        return salarioFinal;
    }
}
