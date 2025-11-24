package com.api.pilares.pilares_inteligencia.controller;

import com.api.pilares.pilares_inteligencia.dto.MensajeRequestDTO;
import com.api.pilares.pilares_inteligencia.dto.ReconstruirMensajeDTO;
import com.api.pilares.pilares_inteligencia.entity.Mensaje;
import com.api.pilares.pilares_inteligencia.service.MensajeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mensajes")
public class MensajeController {

    private final MensajeService mensajeService;

    public MensajeController(MensajeService mensajeService) {
        this.mensajeService = mensajeService;
    }

    // Registrar fragmento de mensaje (POST)
    @PostMapping
    public ResponseEntity<Mensaje> guardarFragmento(@RequestBody MensajeRequestDTO dto) {
        Mensaje mensajeGuardado = mensajeService.guardarFragmento(dto);
        return new ResponseEntity<>(mensajeGuardado, HttpStatus.CREATED);
    }

    // Reconstruir mensaje (PUT)
   @PutMapping("/{pilarId}/reconstruir")
    public ResponseEntity<Mensaje> reconstruirMensaje(
            @PathVariable Long pilarId,
            @RequestBody ReconstruirMensajeDTO dto) {

        Mensaje mensajeReconstruido = mensajeService.reconstruirMensaje(pilarId, dto);
        return ResponseEntity.ok(mensajeReconstruido);
    }

    // Listar todos los mensajes
    @GetMapping
    public ResponseEntity<List<Mensaje>> obtenerTodos() {
        return ResponseEntity.ok(mensajeService.obtenerTodos());
    }
}
