package com.soat3.hackaton.atendmed.adapter.consulta;

import com.soat3.hackaton.atendmed.adapter.consulta.model.AgendaResponse;
import com.soat3.hackaton.atendmed.adapter.consulta.model.ConsultaRequest;
import com.soat3.hackaton.atendmed.adapter.consulta.model.ConsultaResponse;
import com.soat3.hackaton.atendmed.application.consulta.usecase.ConsultaUseCase;
import com.soat3.hackaton.atendmed.domain.enumerate.TipoEspecialidade;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/consultas")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class ConsultaController {

    private final ConsultaUseCase consultaUseCase;

    @PostMapping
    public ResponseEntity<ConsultaResponse> salvarConsulta(@RequestBody ConsultaRequest clienteRequest,
                                                           @RequestHeader("cpf") String cpf,
                                                           @RequestHeader("senha") String senha) {
        ConsultaResponse consultaCriada = consultaUseCase.salvar(clienteRequest);
        return ResponseEntity.ok(consultaCriada);
    }

    @GetMapping
    public ResponseEntity<List<ConsultaResponse>> obterConsultas(@RequestHeader("crm") String crm,
                                                                 @RequestHeader("senha") String senha) {
        List<ConsultaResponse> consultas = consultaUseCase.obterConsultas(crm);
        return ResponseEntity.ok(consultas);
    }

    @PutMapping("/{aprovar}/{idConsulta}/aprovacao-consulta")
    public ResponseEntity<ConsultaResponse> aprovarOuRejeitar(@PathVariable boolean aprovar,
                                                              @PathVariable String idConsulta,
                                                           @RequestHeader("crm") String crm,
                                                           @RequestHeader("senha") String senha) {
        ConsultaResponse consultaCriada = consultaUseCase.aprovarOuRejeitarConsulta(aprovar, idConsulta);
        return ResponseEntity.ok(consultaCriada);
    }

    @GetMapping("/consultas-paciente")
    public ResponseEntity<List<ConsultaResponse>> consultasConfirmadas(
                                                              @RequestHeader("cpf") String cpf,
                                                              @RequestHeader("senha") String senha) {

        List<ConsultaResponse> consultas = consultaUseCase.consultasConfirmadas(cpf);

        return ResponseEntity.ok(consultas);
    }

    @GetMapping("/agendas")
    public ResponseEntity<List<AgendaResponse>> obterAgendaPorEspecilidade(
            @RequestParam("especialidade") TipoEspecialidade especialidade,
            @RequestParam("dataHoraInicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataHoraInicio,
            @RequestParam("dataHoraFim") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataHoraFim,
            @RequestHeader("cpf") String cpf,
            @RequestHeader("senha") String senha) {

        List<AgendaResponse> agendas = consultaUseCase.obterAgendaPorEspecilidade(especialidade, dataHoraInicio, dataHoraFim, cpf);

        return ResponseEntity.ok(agendas);

    }
}
