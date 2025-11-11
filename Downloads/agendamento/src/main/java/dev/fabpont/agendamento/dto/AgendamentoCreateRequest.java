package dev.fabpont.agendamento.dto;

import dev.fabpont.agendamento.model.StatusAgendamento;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public record AgendamentoCreateRequest(
        @NotBlank @Size(max = 120) String titulo,
        @Size(max =4000) String descricao,
        @NotNull LocalDateTime dataInicio,
        @NotNull LocalDateTime dataFinal
) {
}
