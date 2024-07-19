package com.soat3.hackaton.atendmed.application.consulta.factory;

import com.soat3.hackaton.atendmed.adapter.consulta.model.ConsultaRequest;
import com.soat3.hackaton.atendmed.commons.utils.DataProvider;
import com.soat3.hackaton.atendmed.domain.enumerate.SituacaoConsulta;
import com.soat3.hackaton.atendmed.domain.model.consulta.ConsultaModel;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class ConsultaFactoryImpl implements ConsultaFactory {
    private final DataProvider dataProvider;
    @Override
    public ConsultaModel criar(ConsultaRequest consulta) {

        return ConsultaModel.builder()
                .id(UUID.randomUUID())
                .agenda(consulta.getAgenda())
                .medico(consulta.getMedico())
                .situacaoConsulta(SituacaoConsulta.SOLICITADA)
                .build();
    }
}
