package com.soat3.hackaton.atendmed.adapter.consulta.model;

import com.soat3.hackaton.atendmed.adapter.medico.model.MedicoResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AgendaResponse {

    public MedicoResponse medico;
    private LocalDateTime dataHoraInicio;
    private LocalDateTime dataHoraFim;
}
