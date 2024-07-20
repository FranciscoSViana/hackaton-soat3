package com.soat3.hackaton.atendmed.application.paciente.service;

import com.soat3.hackaton.atendmed.adapter.paciente.model.PacienteRequest;
import com.soat3.hackaton.atendmed.adapter.paciente.model.PacienteResponse;
import com.soat3.hackaton.atendmed.application.exception.NotFoundException;
import com.soat3.hackaton.atendmed.application.paciente.converter.PacienteConverter;
import com.soat3.hackaton.atendmed.application.paciente.factory.PacienteFactory;
import com.soat3.hackaton.atendmed.commons.utils.AuthUtil;
import com.soat3.hackaton.atendmed.domain.model.paciente.PacienteModel;

import com.soat3.hackaton.atendmed.infrastructure.repository.paciente.PacienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PacienteServiceImpl implements PacienteService {

    private final PacienteRepository pacienteRepository;
    private final AuthUtil authUtil;
    private final PacienteFactory pacienteFactory;
    private final PacienteConverter pacienteConverter;

    @Override
    public PacienteResponse salvar(PacienteRequest pacienteRequest) {

        PacienteModel paciente = pacienteFactory.criar(pacienteRequest);
        paciente.setSenha(authUtil.encriptarSenha(paciente.getSenha()));
        PacienteModel savedPaciente = pacienteRepository.save(paciente);

        return pacienteConverter.pacienteModelToPacienteResponse(savedPaciente);
    }

    @Override
    public PacienteResponse atualizar(UUID id, PacienteRequest pacienteRequest) {

        PacienteModel paciente = pacienteRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Paciente não encontrado"));
        paciente.setNome(pacienteRequest.getNome());
        paciente.setCpf(pacienteRequest.getCpf());
        paciente.setEmail(pacienteRequest.getEmail());
        if (!pacienteRequest.getSenha().isEmpty()) {
            paciente.setSenha(authUtil.encriptarSenha(pacienteRequest.getSenha()));
        }
        PacienteModel updatedPaciente = pacienteRepository.save(paciente);
        return pacienteConverter.pacienteModelToPacienteResponse(updatedPaciente);
    }

    @Override
    public PacienteResponse buscarPorId(UUID id) {
        PacienteModel paciente = pacienteRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Paciente não encontrado"));
        return pacienteConverter.pacienteModelToPacienteResponse(paciente);
    }

    @Override
    public void deletar(UUID id) {
        PacienteModel paciente = pacienteRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Paciente não encontrado"));
        pacienteRepository.delete(paciente);
    }

    @Override
    public boolean validarCredenciais(String cpf, String senha) {
        PacienteModel paciente = pacienteRepository.findByCpf(cpf)
                .orElseThrow(() -> new NotFoundException("Paciente não encontrado"));
        return authUtil.validarSenha(senha, paciente.getSenha());
    }

    @Override
    public List<PacienteResponse> buscarTodos() {
        return pacienteRepository.findAll().stream()
                .map(pacienteConverter::pacienteModelToPacienteResponse)
                .collect(Collectors.toList());
    }
}