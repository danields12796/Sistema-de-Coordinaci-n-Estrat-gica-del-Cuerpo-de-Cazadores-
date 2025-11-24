package com.api.pilares.pilares_inteligencia.dto;

public class MensajeRequestDTO {
    private Long pilarId;
    private String contenidoFragmentado;
    private Integer fragmento;

    // getters y setters

    public Long getPilarId() {
        return pilarId;
    }

    public void setPilarId(Long pilarId) {
        this.pilarId = pilarId;
    }

    public String getContenidoFragmentado() {
        return contenidoFragmentado;
    }

    public void setContenidoFragmentado(String contenidoFragmentado) {
        this.contenidoFragmentado = contenidoFragmentado;
    }

    public Integer getFragmento() {
        return fragmento;
    }

    public void setFragmento(Integer fragmento) {
        this.fragmento = fragmento;
    }
}   