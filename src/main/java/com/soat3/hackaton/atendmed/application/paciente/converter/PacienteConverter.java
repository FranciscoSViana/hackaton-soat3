package com.soat3.hackaton.atendmed.application.paciente.converter;

import com.soat3.hackaton.atendmed.adapter.paciente.model.PacienteResponse;
import com.soat3.hackaton.atendmed.domain.model.paciente.PacienteModel;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class PacienteConverter {

    private final ModelMapper modelMapper;

    public PacienteResponse pacienteModelToPacienteResponse(PacienteModel paciente){
        return modelMapper.map(paciente, PacienteResponse.class);
    }
}