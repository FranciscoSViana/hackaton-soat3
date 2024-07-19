package com.soat3.hackaton.atendmed.domain.model.consulta;

import com.soat3.hackaton.atendmed.domain.enumerate.SituacaoConsulta;
import com.soat3.hackaton.atendmed.domain.model.medico.AgendaModel;
import com.soat3.hackaton.atendmed.domain.model.medico.MedicoModel;
import com.soat3.hackaton.atendmed.domain.model.paciente.PacienteModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class ConsultaModel {
    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "medico_id", nullable = false)
    @NotNull
    private MedicoModel medico;

    @ManyToOne
    @JoinColumn(name = "paciente_id", nullable = false)
    @NotNull
    private PacienteModel paciente;

    @ManyToOne
    @JoinColumn(name = "agenda_id", nullable = false)
    @NotNull
    private AgendaModel agenda;

    @Enumerated(EnumType.STRING)
    @NotNull
    private SituacaoConsulta situacaoConsulta;

}
