package com.soat3.hackaton.atendmed.application.consulta.service;

import com.soat3.hackaton.atendmed.adapter.consulta.model.ConsultaRequest;
import com.soat3.hackaton.atendmed.adapter.consulta.model.ConsultaResponse;
import com.soat3.hackaton.atendmed.application.consulta.converter.ConsultaConverter;
import com.soat3.hackaton.atendmed.application.consulta.factory.ConsultaFactory;
import com.soat3.hackaton.atendmed.application.exception.NotFoundException;
import com.soat3.hackaton.atendmed.application.reuniao.service.ReunicaoService;
import com.soat3.hackaton.atendmed.domain.enumerate.SituacaoConsulta;
import com.soat3.hackaton.atendmed.domain.model.consulta.ConsultaModel;
import com.soat3.hackaton.atendmed.domain.model.medico.AgendaModel;
import com.soat3.hackaton.atendmed.domain.model.medico.MedicoModel;
import com.soat3.hackaton.atendmed.domain.model.paciente.PacienteModel;
import com.soat3.hackaton.atendmed.infrastructure.repository.consulta.ConsultaRepository;
import com.soat3.hackaton.atendmed.infrastructure.repository.medico.AgendaRepository;
import com.soat3.hackaton.atendmed.infrastructure.repository.medico.MedicoRepository;
import com.soat3.hackaton.atendmed.infrastructure.repository.paciente.PacienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.soat3.hackaton.atendmed.domain.constant.I18n.*;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class ConsultaServiceImpl implements ConsultaService {

    private final ConsultaRepository repository;
    private final ConsultaFactory factory;
    private final ConsultaConverter converter;
    private final MedicoRepository medicorepository;
    private final PacienteRepository pacientepository;
    private final AgendaRepository agendaRepository;

    private final ReunicaoService reunicaoService;

    @Override
    public ConsultaResponse salvar(ConsultaRequest consulta) {

        ConsultaModel consultaCriada = factory.criar(consulta);

        ConsultaModel consultaNova = repository.save(consultaCriada);

        return converter.consultaModelToConsultaResponse(consultaNova);

    }

    @Override
    public ConsultaResponse atualizar(String id, ConsultaRequest consultaRequest) {

        ConsultaModel consultaModel = repository.findById(id)
                .orElseThrow(() -> new NotFoundException(CONSULTA_NAO_ENCONTRADA));
        consultaModel.setMedico(medicorepository.findById(consultaRequest.getMedico().getId())
                .orElseThrow(() -> new NotFoundException(MEDICO_NAO_ENCONTRADO)));
        consultaModel.setPaciente(pacientepository.findById(consultaRequest.getPaciente().getId())
                .orElseThrow(() -> new NotFoundException(PACIENTE_NAO_ENCONTRADO)));
        consultaModel.setAgenda(agendaRepository.findById(consultaRequest.getAgenda().getId())
                .orElseThrow(() -> new NotFoundException(AGENDA_NAO_ENCONTRADA)));

        consultaModel.setSituacaoConsulta(consultaRequest.getSituacaoConsulta());

        ConsultaModel consultaAtualizada = repository.save(consultaModel);

        return converter.consultaModelToConsultaResponse(consultaAtualizada);
    }

    @Override
    public ConsultaResponse buscarPorId(String id) {

        ConsultaModel consulta = repository.findById(id)
                .orElseThrow(() -> new NotFoundException(CONSULTA_NAO_ENCONTRADA));

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

    @Override
    public List<ConsultaResponse> obterConsultas(String crm) {

        MedicoModel medico = medicorepository.findByCrm(crm)
                .orElseThrow(() -> new NotFoundException(MEDICO_NAO_ENCONTRADO));

        return repository.findAllByMedico(medico).stream()
                .map(converter::consultaModelToConsultaResponse)
                .collect(Collectors.collectingAndThen(
                        Collectors.toList(),
                        consultas -> {
                            if (consultas.isEmpty()) {
                                throw new NotFoundException("Consultas não encontradas para o médico com CRM: " + crm);
                            }
                            return consultas;
                        }
                ));

    }

    @Override
    public ConsultaResponse aprovarOuRejeitarConsulta(boolean aprovar, String idConsulta) {

        if(aprovar){

            ConsultaModel consulta = repository.findById(idConsulta)
                    .orElseThrow(() -> new NotFoundException(CONSULTA_NAO_ENCONTRADA));

            consulta.setSituacaoConsulta(SituacaoConsulta.AGENDADA);

            consulta.setLinkReuniao(reunicaoService.geradorReuniao());

            AgendaModel agenda = agendaRepository.findById(consulta.getAgenda().getId())
                    .orElseThrow(() -> new NotFoundException(AGENDA_NAO_ENCONTRADA));

            agenda.setSituacao(false);

            agendaRepository.save(agenda);

            return converter.consultaModelToConsultaResponse(consulta);

        }

        else{
            ConsultaModel consulta = repository.findById(idConsulta)
                    .orElseThrow(() -> new NotFoundException(CONSULTA_NAO_ENCONTRADA));

            consulta.setSituacaoConsulta(SituacaoConsulta.CANCELADA);

            AgendaModel agenda = agendaRepository.findById(consulta.getAgenda().getId())
                    .orElseThrow(() -> new NotFoundException(AGENDA_NAO_ENCONTRADA));

            agenda.setSituacao(true);

            agendaRepository.save(agenda);

            return converter.consultaModelToConsultaResponse(consulta);
        }


    }

    @Override
    public List<ConsultaResponse> consultasConfirmadas(String cpf) {

        PacienteModel paciente = pacientepository.findByCpf(cpf)
                .orElseThrow(() -> new NotFoundException(PACIENTE_NAO_ENCONTRADO));

        List<ConsultaModel> consultas = repository.findAllByPaciente(paciente);


        return consultas.stream().map(converter::consultaModelToConsultaResponse).collect(Collectors.toList());
    }


}
