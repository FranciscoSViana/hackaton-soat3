package com.soat3.hackaton.atendmed.infrastructure.repository.consulta;

import com.soat3.hackaton.atendmed.domain.model.consulta.ConsultaModel;
import com.soat3.hackaton.atendmed.domain.model.medico.MedicoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface ConsultaRepository extends JpaRepository<ConsultaModel, String> {
    List<ConsultaModel> findAllByMedico(MedicoModel medico);

}
