package com.example.empresa2.model;

import jakarta.persistence.*;

@Entity
@Table(name="nomina")
public class Nomina {

    @Id
    private int categoria;

    private int sueldo;

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }
}
