package com.soat3.hackaton.atendmed.application.consulta.converter;

import com.soat3.hackaton.atendmed.adapter.consulta.model.ConsultaResponse;
import com.soat3.hackaton.atendmed.domain.model.consulta.ConsultaModel;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class ConsultaConverter {

    private final ModelMapper modelMapper;

    public ConsultaResponse consultaModelToConsultaResponse(ConsultaModel consulta){
        return modelMapper.map(consulta, ConsultaResponse.class);
    }


}
