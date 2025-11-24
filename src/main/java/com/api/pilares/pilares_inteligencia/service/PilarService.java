package com.api.pilares.pilares_inteligencia.service;

import com.api.pilares.pilares_inteligencia.dto.ActualizarPosicionDTO;
import com.api.pilares.pilares_inteligencia.entity.Pilar;
import java.util.List;

public interface PilarService {

    Pilar crearPilar(Pilar pilar);

    Pilar obtenerPilarPorId(Long id);

    Pilar actualizarPosicion(ActualizarPosicionDTO dto);

    List<Pilar> obtenerTodosLosPilares();
}
