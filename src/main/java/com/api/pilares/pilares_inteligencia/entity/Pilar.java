package com.api.pilares.pilares_inteligencia.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "pilar")
public class Pilar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @Column(name = "latitud")
    private Double posX;

    @Column(name = "longitud")
    private Double posY;
    
    private String estado; 
    
    public Pilar() {}

    public Pilar(String nombre, Double posX, Double posY, String estado) {
        this.nombre = nombre;
        this.posX = posX;
        this.posY = posY;
        this.estado = estado;
    }

    // Getters y Setters
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }

    public void setNombre(String nombre) { this.nombre = nombre; }

    public Double getPosX() { return posX; }

    public void setPosX(Double posX) { this.posX = posX; }

    public Double getPosY() { return posY; }

    public void setPosY(Double posY) { this.posY = posY; }

    public String getEstado() { return estado; }

    public void setEstado(String estado) { this.estado = estado; }
}
