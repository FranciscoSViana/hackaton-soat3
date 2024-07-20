package com.soat3.hackaton.atendmed.application.consulta.service;

import com.soat3.hackaton.atendmed.adapter.consulta.model.ConsultaRequest;
import com.soat3.hackaton.atendmed.adapter.consulta.model.ConsultaResponse;
import com.soat3.hackaton.atendmed.application.consulta.converter.ConsultaConverter;
import com.soat3.hackaton.atendmed.application.consulta.factory.ConsultaFactory;
import com.soat3.hackaton.atendmed.domain.model.consulta.ConsultaModel;
import com.soat3.hackaton.atendmed.infrastructure.repository.consulta.ConsultaRepository;
import com.soat3.hackaton.atendmed.infrastructure.repository.medico.AgendaRepository;
import com.soat3.hackaton.atendmed.infrastructure.repository.medico.MedicoRepository;
import com.soat3.hackaton.atendmed.infrastructure.repository.paciente.PacienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class ConsultaServiceImpl implements ConsultaService{

    private final ConsultaRepository repository;
    private final ConsultaFactory factory;
    private final ConsultaConverter converter;
    private final MedicoRepository medicorepository;
    private final PacienteRepository pacientepository;
    private final AgendaRepository agendaRepository;

    @Override
    public ConsultaResponse salvar(ConsultaRequest consulta) {

        ConsultaModel consultaCriada =  factory.criar(consulta);

        ConsultaModel consultaNova = repository.save(consultaCriada);

        return converter.consultaModelToConsultaResponse(consultaNova);

    }

    @Override
    public ConsultaResponse atualizar(String id, ConsultaRequest consultaRequest) {

        ConsultaModel consultaModel = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Consulta não encontrada"));
        consultaModel.setMedico(medicorepository.findById(consultaRequest.getMedico().getId())
                .orElseThrow(() -> new RuntimeException("Médico não encontrado")));
        consultaModel.setPaciente(pacientepository.findById(consultaRequest.getPaciente().getId())
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado")));
        consultaModel.setAgenda(agendaRepository.findById(consultaRequest.getAgenda().getId())
                .orElseThrow(() -> new RuntimeException("Agenda não encontrada")));

        consultaModel.setSituacaoConsulta(consultaRequest.getSituacaoConsulta());

        ConsultaModel consultaAtualizada = repository.save(consultaModel);

        return converter.consultaModelToConsultaResponse(consultaAtualizada);
    }

    @Override
    public ConsultaResponse buscarPorId(String id) {

        ConsultaModel consulta = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Consulta não encontrada"));

        return converter.consultaModelToConsultaResponse(consulta);
    }

    @Override
    public List<ConsultaResponse> buscarTodos() {
        return repository.findAll().stream()
                .map(converter::consultaModelToConsultaResponse)
                .collect(Collectors.toList());
    }

    @Override
    public void deletar(String id) {
        repository.deleteById(id);
    }
}
