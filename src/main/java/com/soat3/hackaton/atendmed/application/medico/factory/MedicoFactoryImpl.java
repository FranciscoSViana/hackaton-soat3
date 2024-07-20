package com.soat3.hackaton.atendmed.application.medico.factory;

import com.soat3.hackaton.atendmed.adapter.medico.model.MedicoRequest;
import com.soat3.hackaton.atendmed.domain.model.medico.MedicoModel;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class MedicoFactoryImpl implements MedicoFactory {

    @Override
    public MedicoModel criar(MedicoRequest medico) {
        return MedicoModel.builder()
                .id(UUID.randomUUID().toString())
                .nome(medico.getNome())
                .crm(medico.getCrm())
                .senha(medico.getSenha())
                .especialidade(medico.getEspecialidade())
                .build();
    }
}