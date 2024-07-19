package com.soat3.hackaton.atendmed.application.medico.converter;

import com.soat3.hackaton.atendmed.adapter.medico.model.MedicoResponse;
import com.soat3.hackaton.atendmed.domain.model.medico.MedicoModel;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class MedicoConverter {

    private final ModelMapper modelMapper;

    public MedicoResponse medicoModelToMedicoResponse(MedicoModel medico){
        return modelMapper.map(medico, MedicoResponse.class);
    }
}