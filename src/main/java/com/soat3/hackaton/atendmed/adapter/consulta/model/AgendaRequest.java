package com.soat3.hackaton.atendmed.adapter.consulta.model;

import com.soat3.hackaton.atendmed.domain.model.medico.MedicoModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AgendaRequest {

    private MedicoModel medico;
    private LocalDateTime dataHoraInicio;
    private LocalDateTime dataHoraFim;
    private boolean situacao;

}
