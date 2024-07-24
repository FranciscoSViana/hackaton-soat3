package com.soat3.hackaton.atendmed.application.medico.service;

import com.soat3.hackaton.atendmed.adapter.consulta.model.AgendaRequest;
import com.soat3.hackaton.atendmed.adapter.consulta.model.AgendaResponse;
import com.soat3.hackaton.atendmed.adapter.medico.model.MedicoRequest;
import com.soat3.hackaton.atendmed.adapter.medico.model.MedicoResponse;
import com.soat3.hackaton.atendmed.domain.enumerate.TipoEspecialidade;
import com.soat3.hackaton.atendmed.domain.model.medico.AgendaModel;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface MedicoService {
    MedicoResponse salvar(MedicoRequest medico);
    MedicoResponse atualizar(String id, MedicoRequest medicoRequest);
    MedicoResponse buscarPorId(String id);
    List<MedicoResponse> buscarTodos();
    void deletar(String id);
    boolean validarCredenciais(String crm, String senha);
    List<AgendaResponse> findAvailableAgendasByEspecialidadeAndPeriodo(TipoEspecialidade especialidade, LocalDateTime dataHoraInicio, LocalDateTime dataHoraFim, String cpf);
    void cadastrarAgenda(String medicoId, List<AgendaRequest> agendas);

}