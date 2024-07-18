package com.soat3.hackaton.atendmed.application.consulta.factory;


import com.soat3.hackaton.atendmed.adapter.consulta.model.ConsultaRequest;
import com.soat3.hackaton.atendmed.domain.model.consulta.ConsultaModel;

public interface ConsultaFactory {

    ConsultaModel criar(ConsultaRequest consulta);


}
