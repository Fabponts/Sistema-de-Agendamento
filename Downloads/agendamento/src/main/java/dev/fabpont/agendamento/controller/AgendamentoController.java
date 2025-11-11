package dev.fabpont.agendamento.controller;

import dev.fabpont.agendamento.dto.AgendamentoResponse;
import dev.fabpont.agendamento.model.Agendamento;
import dev.fabpont.agendamento.service.AgendamentoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/agendamentos")
public class AgendamentoController {
    private final AgendamentoService agendamentoService;

    public AgendamentoController(AgendamentoService agendamentoService) {
        this.agendamentoService = agendamentoService;
    }

    @PostMapping
    public AgendamentoResponse createAgendamento(@RequestBody Agendamento agendamento){}
}
