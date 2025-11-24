package com.api.pilares.pilares_inteligencia.service.impl;

import com.api.pilares.pilares_inteligencia.dto.ActualizarPosicionDTO;
import com.api.pilares.pilares_inteligencia.entity.Pilar;
import com.api.pilares.pilares_inteligencia.repository.PilarRepository;
import com.api.pilares.pilares_inteligencia.service.PilarService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PilarServiceImpl implements PilarService {

    private final PilarRepository pilarRepository;

    @Override
    public Pilar crearPilar(Pilar pilar) {
        return pilarRepository.save(pilar);
    }

    public PilarServiceImpl(PilarRepository pilarRepository) {
        this.pilarRepository = pilarRepository;
    }

    @Override
    public Pilar obtenerPilarPorId(Long id) {
        return pilarRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pilar no encontrado con ID: " + id));
    }

   @Override
    public Pilar actualizarPosicion(ActualizarPosicionDTO dto) {
        Pilar pilar = obtenerPilarPorId(dto.getPilarId());
        pilar.setPosX(dto.getPosX());
        pilar.setPosY(dto.getPosY());
        pilar.setEstado(dto.getEstado());
        return pilarRepository.save(pilar);
    }

    @Override
    public List<Pilar> obtenerTodosLosPilares() {
        return pilarRepository.findAll();
    }
}
