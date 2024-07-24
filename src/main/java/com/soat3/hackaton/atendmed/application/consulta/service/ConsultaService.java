package com.soat3.hackaton.atendmed.application.consulta.service;

import com.soat3.hackaton.atendmed.adapter.consulta.model.ConsultaRequest;
import com.soat3.hackaton.atendmed.adapter.consulta.model.ConsultaResponse;

import java.util.List;
import java.util.UUID;

public interface ConsultaService {

    ConsultaResponse salvar(ConsultaRequest consulta);
    ConsultaResponse atualizar(String id, ConsultaRequest consulta);
    ConsultaResponse buscarPorId(String id);
    List<ConsultaResponse> buscarTodos();
    void deletar(String id);
    List<ConsultaResponse> obterConsultas(String crm);
    ConsultaResponse aprovarOuRejeitarConsulta(boolean aprovar, String idConsulta);
    List<ConsultaResponse> consultasConfirmadas(String cpf);


}
