package com.soat3.hackaton.atendmed.application.medico.service;

import com.soat3.hackaton.atendmed.adapter.medico.model.MedicoRequest;
import com.soat3.hackaton.atendmed.adapter.medico.model.MedicoResponse;

import java.util.List;
import java.util.UUID;

public interface MedicoService {
    MedicoResponse salvar(MedicoRequest medico);
    MedicoResponse atualizar(String id, MedicoRequest medicoRequest);
    MedicoResponse buscarPorId(String id);
    List<MedicoResponse> buscarTodos();
    void deletar(String id);
    boolean validarCredenciais(String crm, String senha);

}