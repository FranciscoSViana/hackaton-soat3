package com.soat3.hackaton.atendmed.infrastructure.repository.medico;

import com.soat3.hackaton.atendmed.domain.model.medico.MedicoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface MedicoRepository extends JpaRepository<MedicoModel, UUID> {
}