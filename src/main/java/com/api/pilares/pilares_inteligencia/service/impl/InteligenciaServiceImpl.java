package com.api.pilares.pilares_inteligencia.service.impl;

import com.api.pilares.pilares_inteligencia.entity.Pilar;
import com.api.pilares.pilares_inteligencia.repository.PilarRepository;
import com.api.pilares.pilares_inteligencia.service.InteligenciaService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class InteligenciaServiceImpl implements InteligenciaService {

    private final PilarRepository pilarRepository;

    public InteligenciaServiceImpl(PilarRepository pilarRepository) {
        this.pilarRepository = pilarRepository;
    }

  
    @Override
    public Map<String, Object> calcularTriangulacion() {
        List<Pilar> pilares = pilarRepository.findAll();

        if (pilares.size() < 3) {
            throw new RuntimeException("Se requieren mínimo 3 pilares para triangulación.");
        }

        double posXPromedio = pilares.stream()
                .mapToDouble(Pilar::getPosX)
                .average()
                .orElse(0);

        double posYPromedio = pilares.stream()
                .mapToDouble(Pilar::getPosY)
                .average()
                .orElse(0);

        // Creamos respuesta con el formato solicitado
        Map<String, Object> resultado = new HashMap<>();

        Map<String, Double> posiblePosicionMuzan = new HashMap<>();
        posiblePosicionMuzan.put("x", posXPromedio);
        posiblePosicionMuzan.put("y", posYPromedio);

        resultado.put("posiblePosicionMuzan", posiblePosicionMuzan);
        resultado.put("nivelConfianza", 0.78); // valor estimado (puede ser aleatorio o calculado)
        resultado.put("descripcion", "Probabilidad alta de presencia demoníaca en las coordenadas dadas.");

        return resultado;
    }

}
