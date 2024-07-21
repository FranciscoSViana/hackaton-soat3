package com.soat3.hackaton.atendmed.application.medico.converter;

import com.soat3.hackaton.atendmed.adapter.consulta.model.AgendaRequest;
import com.soat3.hackaton.atendmed.adapter.consulta.model.AgendaResponse;
import com.soat3.hackaton.atendmed.adapter.medico.model.MedicoResponse;
import com.soat3.hackaton.atendmed.domain.model.medico.AgendaModel;
import com.soat3.hackaton.atendmed.domain.model.medico.MedicoModel;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class AgendaConverter {
    private final ModelMapper modelMapper;
    public AgendaResponse agendaModelToAgendaResponse(AgendaModel agenda){
        return modelMapper.map(agenda, AgendaResponse.class);
    }

    public AgendaModel agendaRequestToAgendaModel(AgendaRequest agenda){
        return modelMapper.map(agenda, AgendaModel.class);
    }
}
