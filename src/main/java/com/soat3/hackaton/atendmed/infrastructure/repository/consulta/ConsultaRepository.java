package com.soat3.hackaton.atendmed.infrastructure.repository.consulta;

import com.soat3.hackaton.atendmed.domain.model.consulta.ConsultaModel;
import com.soat3.hackaton.atendmed.domain.model.medico.MedicoModel;
import com.soat3.hackaton.atendmed.domain.model.paciente.PacienteModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ConsultaRepository extends JpaRepository<ConsultaModel, String> {
    List<ConsultaModel> findAllByMedico(MedicoModel medico);

    List<ConsultaModel> findAllByPaciente(PacienteModel paciente);

}
