package com.soat3.hackaton.atendmed.adapter.medico.model;

import com.soat3.hackaton.atendmed.domain.enumerate.TipoEspecialidade;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicoRequest {
    private String nome;
    private String crm;
    private String senha;
    private TipoEspecialidade especialidade;
}