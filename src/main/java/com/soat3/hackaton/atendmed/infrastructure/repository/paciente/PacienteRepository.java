package com.soat3.hackaton.atendmed.infrastructure.repository.paciente;

import com.soat3.hackaton.atendmed.domain.model.paciente.PacienteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
public interface PacienteRepository extends JpaRepository<PacienteModel, UUID> {
}
