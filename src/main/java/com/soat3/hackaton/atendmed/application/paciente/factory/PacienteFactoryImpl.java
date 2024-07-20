package com.soat3.hackaton.atendmed.application.paciente.factory;

import com.soat3.hackaton.atendmed.adapter.paciente.model.PacienteRequest;
import com.soat3.hackaton.atendmed.domain.model.paciente.PacienteModel;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class PacienteFactoryImpl implements PacienteFactory {

    @Override
    public PacienteModel criar(PacienteRequest paciente) {
        return PacienteModel.builder()
                .id(UUID.randomUUID())
                .nome(paciente.getNome())
                .cpf(paciente.getCpf())
                .senha(paciente.getSenha())
                .email(paciente.getEmail())
                .build();
    }
}