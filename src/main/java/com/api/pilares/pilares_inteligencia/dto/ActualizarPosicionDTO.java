package com.api.pilares.pilares_inteligencia.dto;

public class ActualizarPosicionDTO {
    private Long pilarId;
    private Double posX;
    private Double posY;
    private String estado;

    public Long getPilarId() { return pilarId; }
    public void setPilarId(Long pilarId) { this.pilarId = pilarId; }

    public Double getPosX() { return posX; }
    public void setPosX(Double posX) { this.posX = posX; }

    public Double getPosY() { return posY; }
    public void setPosY(Double posY) { this.posY = posY; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}
