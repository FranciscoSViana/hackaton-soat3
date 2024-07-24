package com.soat3.hackaton.atendmed.application.cep.service;
@FunctionalInterface
public interface CepService {
    double calcularDistanciaEntreCeps(String cepMedico, String cepPaciente);
}
