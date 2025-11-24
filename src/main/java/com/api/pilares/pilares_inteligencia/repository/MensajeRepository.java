package com.api.pilares.pilares_inteligencia.repository;

import com.api.pilares.pilares_inteligencia.entity.Mensaje;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MensajeRepository extends JpaRepository<Mensaje, Long> {

    List<Mensaje> findByPilarIdOrderByFragmentoAsc(Long pilarId);
    List<Mensaje> findByPilarIdAndFragmentoGreaterThanOrderByFragmentoAsc(Long pilarId, Integer fragmento);

}
