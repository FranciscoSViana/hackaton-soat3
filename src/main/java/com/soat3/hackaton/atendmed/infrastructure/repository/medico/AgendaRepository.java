package com.soat3.hackaton.atendmed.infrastructure.repository.medico;

import com.soat3.hackaton.atendmed.domain.enumerate.TipoEspecialidade;
import com.soat3.hackaton.atendmed.domain.model.medico.AgendaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface AgendaRepository extends JpaRepository<AgendaModel, String> {

    @Query("SELECT a FROM AgendaModel a WHERE a.medico.especialidade = :especialidade AND a.situacao = false AND a.dataHoraInicio >= :dataHoraInicio AND a.dataHoraFim <= :dataHoraFim")
    List<AgendaModel> findAvailableAgendasByEspecialidadeAndSituacao(
            @Param("especialidade") TipoEspecialidade especialidade,
            @Param("dataHoraInicio") LocalDateTime dataHoraInicio,
            @Param("dataHoraFim") LocalDateTime dataHoraFim);
}