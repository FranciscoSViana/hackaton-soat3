package com.soat3.hackaton.atendmed.application.paciente.usecase;


import com.soat3.hackaton.atendmed.adapter.paciente.model.PacienteRequest;
import com.soat3.hackaton.atendmed.adapter.paciente.model.PacienteResponse;

import java.util.List;
import java.util.UUID;

public interface PacienteUseCase {
    PacienteResponse salvar(PacienteRequest paciente);
    PacienteResponse atualizar(UUID id, PacienteRequest paciente);
    PacienteResponse buscarPorId(UUID id);
    List<PacienteResponse> buscarTodos();
    void deletar(UUID id);
}
