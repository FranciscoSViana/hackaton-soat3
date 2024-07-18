package com.soat3.hackaton.atendmed.domain.model.consulta;

import com.soat3.hackaton.atendmed.domain.enumerate.SituacaoConsulta;
import com.soat3.hackaton.atendmed.domain.model.medico.MedicoModel;
import com.soat3.hackaton.atendmed.domain.model.paciente.PacienteModel;
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
public class ConsultaModel {
    @Id
    private UUID id;

    @OneToOne
    @JoinColumn(name = "medico_id")
    private MedicoModel medico;

    @OneToOne
    @JoinColumn(name = "paciente_id")
    private PacienteModel paciente;

    private LocalDateTime dataHoraConsulta;

    private SituacaoConsulta situacaoConsulta;


}
