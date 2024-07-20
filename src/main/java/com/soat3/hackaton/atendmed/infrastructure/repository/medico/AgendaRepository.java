package com.soat3.hackaton.atendmed.infrastructure.repository.medico;

import com.soat3.hackaton.atendmed.domain.model.medico.AgendaModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AgendaRepository extends JpaRepository<AgendaModel, String> {
}