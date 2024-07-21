package com.soat3.hackaton.atendmed.adapter.medico.model;

import com.soat3.hackaton.atendmed.domain.enumerate.TipoEspecialidade;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicoResponse {
    private UUID id;
    private String nome;
    private String crm;
    private TipoEspecialidade especialidade;
    private BigDecimal valorConsulta;
}