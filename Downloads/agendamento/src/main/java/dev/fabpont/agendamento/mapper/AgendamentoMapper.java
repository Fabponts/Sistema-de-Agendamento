package dev.fabpont.agendamento.mapper;

import dev.fabpont.agendamento.dto.AgendamentoCreateRequest;
import dev.fabpont.agendamento.dto.AgendamentoResponse;
import dev.fabpont.agendamento.dto.AgendamentoUpdateRequest;
import dev.fabpont.agendamento.model.Agendamento;
import dev.fabpont.agendamento.model.StatusAgendamento;

import java.time.LocalDateTime;

public class AgendamentoMapper {

    public static Agendamento toEntity(AgendamentoCreateRequest agendamentoCreateRequest) {
        return Agendamento.builder()
                .titulo(agendamentoCreateRequest.titulo())
                .descricao(agendamentoCreateRequest.descricao())
                .dataInicio(agendamentoCreateRequest.dataInicio())
                .dataFim(agendamentoCreateRequest.dataFinal())
                .status(StatusAgendamento.AGENDADO)
                .criadoEm(LocalDateTime.now())
                .build();
    }

    public static AgendamentoResponse toResponse(Agendamento agendamento) {
        return new AgendamentoResponse(
                agendamento.getId(),
                agendamento.getTitulo(),
                agendamento.getDescricao(),
                agendamento.getDataInicio(),
                agendamento.getDataFim(),
                agendamento.getStatus(),
                agendamento.getCriadoEm()
        );
    }
    public static void merge(Agendamento entity, AgendamentoUpdateRequest agendamentoUpdateRequest) {
        if(agendamentoUpdateRequest!= null) {
            entity.setTitulo(agendamentoUpdateRequest.titulo());
        }
        if(agendamentoUpdateRequest!= null) {
            entity.setDescricao(agendamentoUpdateRequest.descricao());
        }
        if(agendamentoUpdateRequest!= null) {
            entity.setDataInicio(agendamentoUpdateRequest.dataInicio());
        }
        if(agendamentoUpdateRequest!= null) {
            entity.setDataFim(agendamentoUpdateRequest.dataFinal());
        }
    }
}
