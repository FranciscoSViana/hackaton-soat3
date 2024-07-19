package com.soat3.hackaton.atendmed.application.medico.service;

import com.soat3.hackaton.atendmed.adapter.medico.model.MedicoRequest;
import com.soat3.hackaton.atendmed.adapter.medico.model.MedicoResponse;

public interface MedicoService {
    MedicoResponse salvar(MedicoRequest medico);
}