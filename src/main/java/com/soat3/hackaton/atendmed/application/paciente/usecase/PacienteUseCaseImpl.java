package com.soat3.hackaton.atendmed.application.paciente.usecase.impl;

import com.soat3.hackaton.atendmed.adapter.paciente.model.PacienteRequest;
import com.soat3.hackaton.atendmed.adapter.paciente.model.PacienteResponse;
import com.soat3.hackaton.atendmed.application.paciente.service.PacienteService;
import com.soat3.hackaton.atendmed.application.paciente.usecase.PacienteUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class PacienteUseCaseImpl implements PacienteUseCase {

    private final PacienteService service;

    @Override
    public PacienteResponse salvar(PacienteRequest paciente) {
        return service.salvar(paciente);
    }

    @Override
    public PacienteResponse atualizar(String id, PacienteRequest paciente) {
        return service.atualizar(id, paciente);
    }

    @Override
    public PacienteResponse buscarPorId(String id) {
        return service.buscarPorId(id);
    }

    @Override
    public List<PacienteResponse> buscarTodos() {
        return service.buscarTodos();
    }

    @Override
    public void deletar(String id) {
        service.deletar(id);
    }
}
