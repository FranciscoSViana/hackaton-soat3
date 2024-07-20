package com.soat3.hackaton.atendmed.application.consulta.service;

import com.soat3.hackaton.atendmed.adapter.consulta.model.ConsultaRequest;
import com.soat3.hackaton.atendmed.adapter.consulta.model.ConsultaResponse;

import java.util.List;
import java.util.UUID;

public interface ConsultaService {

    ConsultaResponse salvar(ConsultaRequest consulta);
    ConsultaResponse atualizar(UUID id, ConsultaRequest consulta);
    ConsultaResponse buscarPorId(UUID id);
    List<ConsultaResponse> buscarTodos();
    void deletar(UUID id);
}
