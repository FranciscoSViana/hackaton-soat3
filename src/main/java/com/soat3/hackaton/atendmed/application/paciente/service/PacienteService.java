package com.soat3.hackaton.atendmed.application.paciente.service;

import com.soat3.hackaton.atendmed.adapter.paciente.model.PacienteRequest;
import com.soat3.hackaton.atendmed.adapter.paciente.model.PacienteResponse;

import java.util.List;
import java.util.UUID;

public interface PacienteService {
    PacienteResponse salvar(PacienteRequest paciente);
    PacienteResponse atualizar(UUID id, PacienteRequest pacienteRequest);
    PacienteResponse buscarPorId(UUID id);
    void deletar(UUID id);
    boolean validarCredenciais(String cpf, String senha);

    List<PacienteResponse> buscarTodos();

}