package com.soat3.hackaton.atendmed.domain.model.medico;

import com.soat3.hackaton.atendmed.domain.model.medico.MedicoModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class AgendaModel {
    @Id
    String  id;

    @ManyToOne
    @JoinColumn(name = "medico_id")
    private MedicoModel medico;

    private LocalDateTime dataHoraInicio;

    private LocalDateTime dataHoraFim;
}