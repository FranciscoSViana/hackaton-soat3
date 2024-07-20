package com.soat3.hackaton.atendmed.adapter.consulta.model;

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
    private LocalDateTime dataHoraInicio;
    private LocalDateTime dataHoraFim;
}
