package com.soat3.hackaton.atendmed.application.medico.usecase;

import com.soat3.hackaton.atendmed.adapter.consulta.model.AgendaRequest;
import com.soat3.hackaton.atendmed.adapter.medico.model.MedicoRequest;
import com.soat3.hackaton.atendmed.adapter.medico.model.MedicoResponse;
import com.soat3.hackaton.atendmed.domain.model.medico.AgendaModel;

import java.util.List;
import java.util.UUID;

public interface MedicoUseCase {
    MedicoResponse salvar(MedicoRequest medico);
    MedicoResponse atualizar(String id, MedicoRequest medico);
    MedicoResponse buscarPorId(String id);
    List<MedicoResponse> buscarTodos();
    void deletar(String id);
    void cadastrarAgenda(String crm, List<AgendaRequest> agendas);

}
