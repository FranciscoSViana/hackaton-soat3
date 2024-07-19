package com.soat3.hackaton.atendmed.domain.model.medico;

import com.soat3.hackaton.atendmed.domain.enumerate.TipoEspecialidade;
import com.soat3.hackaton.atendmed.domain.model.consulta.ConsultaModel;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class MedicoModel {
    @Id
    private UUID id;

    private String nome;

    private String crm;

    private String senha;

    private TipoEspecialidade especialidade;

    @OneToMany(mappedBy = "medico")
    private List<ConsultaModel> consultas;

    @OneToMany(mappedBy = "medico")
    private List<AgendaModel> agendas;


}
