package com.api.pilares.pilares_inteligencia.controller;

import com.api.pilares.pilares_inteligencia.service.InteligenciaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/inteligencia")
public class InteligenciaController {

    private final InteligenciaService inteligenciaService;

    public InteligenciaController(InteligenciaService inteligenciaService) {
        this.inteligenciaService = inteligenciaService;
    }

  @GetMapping("/triangulacion")
    public ResponseEntity<Map<String, Object>> triangulacionEstimacion() {
        return ResponseEntity.ok(inteligenciaService.calcularTriangulacion());
    }

}
