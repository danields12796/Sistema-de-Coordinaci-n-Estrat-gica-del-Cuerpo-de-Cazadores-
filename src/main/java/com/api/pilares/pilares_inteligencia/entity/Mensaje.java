package com.api.pilares.pilares_inteligencia.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "mensaje")
public class Mensaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "contenido_fragmentado") 
    private String contenidoFragmentado;

    @Column(name = "contenido_reconstruido") 
    private String contenidoReconstruido;

    @Column(name = "fragmento")
    private Integer fragmento;

    @Column(name = "fecha_registro")
    private LocalDateTime fechaRegistro = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "pilar_id", nullable = false) 
    private Pilar pilar;

    public Mensaje() {}

    public Mensaje(String contenidoFragmentado, Integer fragmento, Pilar pilar) {
        this.contenidoFragmentado = contenidoFragmentado;
        this.fragmento = fragmento;
        this.pilar = pilar;
    }

    // Getters y Setters...

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getContenidoFragmentado() { return contenidoFragmentado; }
    public void setContenidoFragmentado(String contenidoFragmentado) { this.contenidoFragmentado = contenidoFragmentado; }

    public String getContenidoReconstruido() { return contenidoReconstruido; }
    public void setContenidoReconstruido(String contenidoReconstruido) { this.contenidoReconstruido = contenidoReconstruido; }

    public Integer getFragmento() { return fragmento; }
    public void setFragmento(Integer fragmento) { this.fragmento = fragmento; }

    public LocalDateTime getFechaRegistro() { return fechaRegistro; }
    public void setFechaRegistro(LocalDateTime fechaRegistro) { this.fechaRegistro = fechaRegistro; }

    public Pilar getPilar() { return pilar; }
    public void setPilar(Pilar pilar) { this.pilar = pilar; }
}
