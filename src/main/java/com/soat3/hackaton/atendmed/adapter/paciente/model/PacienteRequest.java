package com.soat3.hackaton.atendmed.adapter.paciente.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PacienteRequest {
    private String nome;
    private String cpf;
    private String senha;
    private String email;
}