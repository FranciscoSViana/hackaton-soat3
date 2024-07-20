package com.soat3.hackaton.atendmed.infrastructure.repository.paciente;

import com.soat3.hackaton.atendmed.domain.model.paciente.PacienteModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;
public interface PacienteRepository extends JpaRepository<PacienteModel, String> {
    Optional<PacienteModel> findByCpf(String cpf);

}
