package com.soat3.hackaton.atendmed.application.medico.factory;

import com.soat3.hackaton.atendmed.adapter.medico.model.MedicoRequest;
import com.soat3.hackaton.atendmed.domain.model.medico.MedicoModel;

public interface MedicoFactory {
    MedicoModel criar(MedicoRequest medico);
}