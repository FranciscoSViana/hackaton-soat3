package com.soat3.hackaton.atendmed.adapter.paciente.controller;

import com.soat3.hackaton.atendmed.adapter.paciente.model.PacienteRequest;
import com.soat3.hackaton.atendmed.adapter.paciente.model.PacienteResponse;
import com.soat3.hackaton.atendmed.application.paciente.usecase.PacienteUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/pacientes")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class PacienteController {

    private final PacienteUseCase pacienteUseCase;

    @PostMapping
    public ResponseEntity<PacienteResponse> criarPaciente(@RequestBody PacienteRequest pacienteRequest) {
        PacienteResponse response = pacienteUseCase.salvar(pacienteRequest);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PacienteResponse> atualizarPaciente(@PathVariable UUID id, @RequestBody PacienteRequest pacienteRequest,
                                                              @RequestHeader("cpf") String cpf, @RequestHeader("senha") String senha) {
        PacienteResponse response = pacienteUseCase.atualizar(id, pacienteRequest);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PacienteResponse> buscarPacientePorId(@PathVariable UUID id,
                                                                @RequestHeader("cpf") String cpf, @RequestHeader("senha") String senha) {
        PacienteResponse response = pacienteUseCase.buscarPorId(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<PacienteResponse>> buscarTodosPacientes(@RequestHeader("cpf") String cpf, @RequestHeader("senha") String senha) {
        List<PacienteResponse> response = pacienteUseCase.buscarTodos();
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPaciente(@PathVariable UUID id, @RequestHeader("cpf") String cpf, @RequestHeader("senha") String senha) {
        pacienteUseCase.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
