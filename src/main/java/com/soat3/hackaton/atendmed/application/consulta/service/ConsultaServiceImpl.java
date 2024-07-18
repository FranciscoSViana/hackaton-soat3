package com.soat3.hackaton.atendmed.application.consulta.service;

import com.soat3.hackaton.atendmed.adapter.consulta.model.ConsultaRequest;
import com.soat3.hackaton.atendmed.adapter.consulta.model.ConsultaResponse;
import com.soat3.hackaton.atendmed.application.consulta.converter.ConsultaConverter;
import com.soat3.hackaton.atendmed.application.consulta.factory.ConsultaFactory;
import com.soat3.hackaton.atendmed.domain.model.consulta.ConsultaModel;
import com.soat3.hackaton.atendmed.infrastructure.repository.consulta.ConsultaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class ConsultaServiceImpl implements ConsultaService{

    private final ConsultaRepository repository;
    private final ConsultaFactory factory;
    private final ConsultaConverter converter;

    @Override
    public ConsultaResponse salvar(ConsultaRequest consulta) {

        ConsultaModel consultaCriada =  factory.criar(consulta);

        ConsultaModel consultaNova = repository.save(consultaCriada);

        return converter.consultaModelToConsultaResponse(consultaNova);

    }
}
