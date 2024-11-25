package com.example.empresa2.model;

import jakarta.persistence.*;
import java.util.Optional;

@Entity
@Table(name="empleado")
public class Empleado {

    @Id
    private String dni;
    private String nombre;
    private String sexo;
    private int categoria;
    private int aniosTrabajados;
    private double salario;

    @ManyToOne
    @JoinColumn(name = "categoria", referencedColumnName = "categoria", insertable = false, updatable = false)
    private Nomina nomina;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public int getAniosTrabajados() {
        return aniosTrabajados;
    }

    public void setAniosTrabajados(int aniosTrabajados) {
        this.aniosTrabajados = aniosTrabajados;
    }

}
