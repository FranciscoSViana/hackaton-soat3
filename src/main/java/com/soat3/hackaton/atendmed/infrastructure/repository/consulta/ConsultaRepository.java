package com.soat3.hackaton.atendmed.infrastructure.repository.consulta;

import com.soat3.hackaton.atendmed.domain.model.consulta.ConsultaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

public interface ConsultaRepository extends JpaRepository<ConsultaModel, UUID> {
}
