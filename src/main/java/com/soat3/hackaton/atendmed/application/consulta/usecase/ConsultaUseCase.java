package com.soat3.hackaton.atendmed.application.consulta.usecase;

import com.soat3.hackaton.atendmed.adapter.consulta.model.AgendaResponse;
import com.soat3.hackaton.atendmed.adapter.consulta.model.ConsultaRequest;
import com.soat3.hackaton.atendmed.adapter.consulta.model.ConsultaResponse;
import com.soat3.hackaton.atendmed.domain.enumerate.TipoEspecialidade;

import java.time.LocalDateTime;
import java.util.List;

public interface ConsultaUseCase {
    ConsultaResponse salvar(ConsultaRequest consulta);
    List<ConsultaResponse> obterConsultas(String crm);
    ConsultaResponse aprovarOuRejeitarConsulta(boolean aprovar, String idConsulta);
    List<AgendaResponse> obterAgendaPorEspecilidade(TipoEspecialidade especialidade, LocalDateTime dataHoraInicio, LocalDateTime dataHoraFim);


}
