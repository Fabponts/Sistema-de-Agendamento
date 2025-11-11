package dev.fabpont.agendamento.dto;

import dev.fabpont.agendamento.model.StatusAgendamento;

import java.time.LocalDateTime;

public record AgendamentoResponse(
        Long id,
        String titulo,
        String descricao,
        LocalDateTime dataIncio,
        LocalDateTime dataFinal,
        StatusAgendamento status,
        LocalDateTime criadoEm
) {


}
