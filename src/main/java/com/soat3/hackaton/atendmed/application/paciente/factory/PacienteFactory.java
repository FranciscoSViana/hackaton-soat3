package com.soat3.hackaton.atendmed.application.paciente.factory;

import com.soat3.hackaton.atendmed.adapter.paciente.model.PacienteRequest;
import com.soat3.hackaton.atendmed.domain.model.paciente.PacienteModel;

public interface PacienteFactory {
    PacienteModel criar(PacienteRequest paciente);
}