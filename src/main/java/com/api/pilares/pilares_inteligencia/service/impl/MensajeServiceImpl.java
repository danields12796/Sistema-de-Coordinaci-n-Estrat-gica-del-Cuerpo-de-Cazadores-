package com.api.pilares.pilares_inteligencia.service.impl;

import com.api.pilares.pilares_inteligencia.dto.MensajeRequestDTO;
import com.api.pilares.pilares_inteligencia.dto.ReconstruirMensajeDTO;
import com.api.pilares.pilares_inteligencia.entity.Mensaje;
import com.api.pilares.pilares_inteligencia.entity.Pilar;
import com.api.pilares.pilares_inteligencia.repository.MensajeRepository;
import com.api.pilares.pilares_inteligencia.repository.PilarRepository;
import com.api.pilares.pilares_inteligencia.service.MensajeService;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;
import java.time.LocalDateTime;

@Service
public class MensajeServiceImpl implements MensajeService {

    private final MensajeRepository mensajeRepository;
    private final PilarRepository pilarRepository;

    public MensajeServiceImpl(MensajeRepository mensajeRepository, PilarRepository pilarRepository) {
        this.mensajeRepository = mensajeRepository;
        this.pilarRepository = pilarRepository;
    }

    @Override
    public Mensaje guardarFragmento(MensajeRequestDTO dto) {
        Pilar pilar = pilarRepository.findById(dto.getPilarId())
                .orElseThrow(() -> new RuntimeException("Pilar no encontrado"));

        Mensaje mensaje = new Mensaje();
        mensaje.setContenidoFragmentado(dto.getContenidoFragmentado());
        mensaje.setFragmento(dto.getFragmento());
        mensaje.setFechaRegistro(LocalDateTime.now()); // ← Añadido
        mensaje.setPilar(pilar);

        return mensajeRepository.save(mensaje);
    }


    @Override

    public Mensaje reconstruirMensaje(Long mensajeId, ReconstruirMensajeDTO dto) {

        Mensaje mensajeExistente = mensajeRepository.findById(mensajeId)
                .orElseThrow(() -> new RuntimeException("Mensaje no encontrado"));

        if (dto == null || dto.getContenidoReconstruido() == null || dto.getContenidoReconstruido().isBlank()) {
            throw new RuntimeException("El contenido reconstruido no puede estar vacío");
        }

        mensajeExistente.setContenidoReconstruido(dto.getContenidoReconstruido());
        mensajeExistente.setFechaRegistro(LocalDateTime.now());

        return mensajeRepository.save(mensajeExistente);
    }


    @Override
    public List<Mensaje> obtenerTodos() {
        return mensajeRepository.findAll();
    }
}
