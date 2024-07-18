package com.soat3.hackaton.atendmed.application.consulta.usecase;

import com.soat3.hackaton.atendmed.adapter.consulta.model.ConsultaRequest;
import com.soat3.hackaton.atendmed.adapter.consulta.model.ConsultaResponse;

public interface ConsultaUseCase {

    ConsultaResponse salvar(ConsultaRequest consulta);
}
