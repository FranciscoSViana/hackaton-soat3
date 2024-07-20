package com.soat3.hackaton.atendmed.adapter.medico.controller;

import com.soat3.hackaton.atendmed.adapter.medico.model.MedicoRequest;
import com.soat3.hackaton.atendmed.adapter.medico.model.MedicoResponse;
import com.soat3.hackaton.atendmed.application.medico.usecase.MedicoUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/medicos")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class MedicoController {

    private final MedicoUseCase medicoUseCase;

    @PostMapping
    public ResponseEntity<MedicoResponse> criarMedico(@RequestBody MedicoRequest medicoRequest) {
        MedicoResponse response = medicoUseCase.salvar(medicoRequest);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MedicoResponse> atualizarMedico(@PathVariable UUID id, @RequestBody MedicoRequest medicoRequest,
                                                          @RequestHeader("crm") String crm, @RequestHeader("senha") String senha) {
        MedicoResponse response = medicoUseCase.atualizar(id, medicoRequest);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicoResponse> buscarMedicoPorId(@PathVariable UUID id,
                                                            @RequestHeader("crm") String crm, @RequestHeader("senha") String senha) {
        MedicoResponse response = medicoUseCase.buscarPorId(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<MedicoResponse>> buscarTodosMedicos(@RequestHeader("crm") String crm, @RequestHeader("senha") String senha) {
        List<MedicoResponse> response = medicoUseCase.buscarTodos();
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarMedico(@PathVariable UUID id, @RequestHeader("crm") String crm, @RequestHeader("senha") String senha) {
        medicoUseCase.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
