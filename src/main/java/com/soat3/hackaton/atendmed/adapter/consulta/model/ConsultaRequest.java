package com.soat3.hackaton.atendmed.adapter.consulta.model;

import com.soat3.hackaton.atendmed.domain.enumerate.SituacaoConsulta;
import com.soat3.hackaton.atendmed.domain.model.medico.AgendaModel;
import com.soat3.hackaton.atendmed.domain.model.medico.MedicoModel;
import com.soat3.hackaton.atendmed.domain.model.paciente.PacienteModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ConsultaRequest {
    private MedicoModel medico;
    private PacienteModel paciente;
    private SituacaoConsulta situacaoConsulta;
    private AgendaModel agenda;

}
