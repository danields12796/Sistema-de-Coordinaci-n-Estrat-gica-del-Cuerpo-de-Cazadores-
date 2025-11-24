package com.api.pilares.pilares_inteligencia.service;

import com.api.pilares.pilares_inteligencia.dto.MensajeRequestDTO;
import com.api.pilares.pilares_inteligencia.dto.ReconstruirMensajeDTO;
import com.api.pilares.pilares_inteligencia.entity.Mensaje;

import java.util.List;

public interface MensajeService {

    Mensaje guardarFragmento(MensajeRequestDTO dto);

    Mensaje reconstruirMensaje(Long pilarId, ReconstruirMensajeDTO dto);
    
    List<Mensaje> obtenerTodos();
}
