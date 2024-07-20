package com.soat3.hackaton.atendmed.application.medico.usecase;

import com.soat3.hackaton.atendmed.adapter.medico.model.MedicoRequest;
import com.soat3.hackaton.atendmed.adapter.medico.model.MedicoResponse;

import java.util.List;
import java.util.UUID;

public interface MedicoUseCase {
    MedicoResponse salvar(MedicoRequest medico);
    MedicoResponse atualizar(UUID id, MedicoRequest medico);
    MedicoResponse buscarPorId(UUID id);
    List<MedicoResponse> buscarTodos();
    void deletar(UUID id);
}
