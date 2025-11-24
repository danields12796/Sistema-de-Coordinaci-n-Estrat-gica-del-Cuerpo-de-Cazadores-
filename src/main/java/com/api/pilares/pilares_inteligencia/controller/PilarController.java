package com.api.pilares.pilares_inteligencia.controller;

import com.api.pilares.pilares_inteligencia.dto.ActualizarPosicionDTO;
import com.api.pilares.pilares_inteligencia.entity.Pilar;
import com.api.pilares.pilares_inteligencia.service.PilarService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pilares")
public class PilarController {

    private final PilarService pilarService;


    public PilarController(PilarService pilarService) {
        this.pilarService = pilarService;
    }

    @PostMapping
    public ResponseEntity<Pilar> crearPilar(@RequestBody Pilar pilar) {
        return ResponseEntity.ok(pilarService.crearPilar(pilar));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pilar> obtenerPilarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(pilarService.obtenerPilarPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<Pilar>> obtenerTodos() {
        return ResponseEntity.ok(pilarService.obtenerTodosLosPilares());
    }

   @PostMapping("/{id}/actualizar-posicion")
    public ResponseEntity<Pilar> actualizarPosicion(@RequestBody ActualizarPosicionDTO dto) {
    Pilar actualizado = pilarService.actualizarPosicion(dto);
    return ResponseEntity.ok(actualizado);
}

}
