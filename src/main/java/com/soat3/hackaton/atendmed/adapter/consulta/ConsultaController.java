package com.soat3.hackaton.atendmed.adapter.consulta.controller;

import com.soat3.hackaton.atendmed.adapter.consulta.model.ConsultaRequest;
import com.soat3.hackaton.atendmed.adapter.consulta.model.ConsultaResponse;
import com.soat3.hackaton.atendmed.application.consulta.usecase.ConsultaUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/consulta")
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
}
