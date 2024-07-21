package com.soat3.hackaton.atendmed.application.medico.usecase;

import com.soat3.hackaton.atendmed.adapter.consulta.model.AgendaRequest;
import com.soat3.hackaton.atendmed.adapter.medico.model.MedicoRequest;
import com.soat3.hackaton.atendmed.adapter.medico.model.MedicoResponse;
import com.soat3.hackaton.atendmed.application.medico.service.MedicoService;
import com.soat3.hackaton.atendmed.domain.model.medico.AgendaModel;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class MedicoUseCaseImpl implements MedicoUseCase {

    private final MedicoService service;

    @Override
    public MedicoResponse salvar(MedicoRequest medico) {
        return service.salvar(medico);
    }

    @Override
    public MedicoResponse atualizar(String id, MedicoRequest medico) {
        return service.atualizar(id, medico);
    }

    @Override
    public MedicoResponse buscarPorId(String id) {
        return service.buscarPorId(id);
    }

    @Override
    public List<MedicoResponse> buscarTodos() {
        return service.buscarTodos();
    }

    @Override
    public void deletar(String id) {
        service.deletar(id);
    }

    @Override
    public void cadastrarAgenda(String crm, List<AgendaRequest> agendas) {
         service.cadastrarAgenda(crm,agendas);
    }
}