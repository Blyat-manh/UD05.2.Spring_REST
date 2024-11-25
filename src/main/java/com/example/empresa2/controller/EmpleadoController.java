package com.example.empresa2.controller;

import com.example.empresa2.model.Empleado;
import com.example.empresa2.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empresa")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    
    @GetMapping("/empleados")
    public ResponseEntity<List<Empleado>> listarEmpleados() {
        List<Empleado> empleados = empleadoService.obtenerTodosLosEmpleados();
        if (empleados.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); 
        }
        return new ResponseEntity<>(empleados, HttpStatus.OK); 
    }

    
    @GetMapping("/empleados/{dni}") //por dni
    public ResponseEntity<Empleado> obtenerEmpleadoPorDni(@PathVariable String dni) {
        Empleado empleado = empleadoService.obtenerEmpleadoPorDni(dni);
        if (empleado == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
        }
        return new ResponseEntity<>(empleado, HttpStatus.OK); 
    }

  
    @PostMapping("/empleados")
    public ResponseEntity<Empleado> crearEmpleado(@RequestBody Empleado empleado) {
        Empleado empleadoGuardado = empleadoService.guardarEmpleado(empleado);
        return new ResponseEntity<>(empleadoGuardado, HttpStatus.CREATED); 
    }

   
    @PutMapping("/empleados/{dni}")
    public ResponseEntity<Empleado> modificarEmpleado(@PathVariable String dni, @RequestBody Empleado empleado) {
        Empleado empleadoExistente = empleadoService.obtenerEmpleadoPorDni(dni);
        if (empleadoExistente == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
        }
        empleado.setDni(dni); 
        Empleado empleadoActualizado = empleadoService.guardarEmpleado(empleado);
        return new ResponseEntity<>(empleadoActualizado, HttpStatus.OK); 
    }

    @DeleteMapping("/empleados/{dni}")
    public ResponseEntity<Void> eliminarEmpleado(@PathVariable String dni) {
        Empleado empleado = empleadoService.obtenerEmpleadoPorDni(dni);
        if (empleado == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
        }
        empleadoService.eliminarEmpleado(dni);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
