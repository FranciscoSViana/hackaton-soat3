package com.soat3.hackaton.atendmed.application.consulta.usecase;

import com.soat3.hackaton.atendmed.adapter.consulta.model.ConsultaRequest;
import com.soat3.hackaton.atendmed.adapter.consulta.model.ConsultaResponse;
import com.soat3.hackaton.atendmed.application.consulta.service.ConsultaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class ConsultaUseCaseImpl implements ConsultaUseCase {

    private final ConsultaService service;
    @Override
    public ConsultaResponse salvar(ConsultaRequest consulta) {
        return service.salvar(consulta);
    }
    @Override
    public List<ConsultaResponse> obterConsultas(String crm) {
        return service.obterConsultas(crm);
    }

    @Override
    public ConsultaResponse aprovarOuRejeitarConsulta(boolean aprovar, String idConsulta) {
        return service.aprovarOuRejeitarConsulta(aprovar, idConsulta);
    }
}
