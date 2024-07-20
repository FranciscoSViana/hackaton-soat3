package com.soat3.hackaton.atendmed.application.consulta.usecase;

import com.soat3.hackaton.atendmed.adapter.consulta.model.ConsultaRequest;
import com.soat3.hackaton.atendmed.adapter.consulta.model.ConsultaResponse;

import java.util.List;

public interface ConsultaUseCase {
    ConsultaResponse salvar(ConsultaRequest consulta);
    List<ConsultaResponse> obterConsultas(String crm);
    ConsultaResponse aprovarOuRejeitarConsulta(boolean aprovar, String idConsulta);
}
