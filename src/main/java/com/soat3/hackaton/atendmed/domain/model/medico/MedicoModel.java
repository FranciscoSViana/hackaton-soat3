package com.soat3.hackaton.atendmed.domain.model.medico;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.soat3.hackaton.atendmed.domain.enumerate.TipoEspecialidade;
import com.soat3.hackaton.atendmed.domain.model.consulta.ConsultaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class MedicoModel {
    @Id
    private String id;

    private String nome;

    private String crm;

    private String senha;

    @Enumerated(EnumType.STRING)
    private TipoEspecialidade especialidade;

    @JsonManagedReference
    @OneToMany(mappedBy = "medico")
    private List<ConsultaModel> consultas;

    @JsonManagedReference
    @OneToMany(mappedBy = "medico")
    private List<AgendaModel> agendas;
}
