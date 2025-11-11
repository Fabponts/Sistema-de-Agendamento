package dev.fabpont.agendamento.controller;

import dev.fabpont.agendamento.dto.AgendamentoCreateRequest;
import dev.fabpont.agendamento.dto.AgendamentoResponse;
import dev.fabpont.agendamento.dto.AgendamentoUpdateRequest;
import dev.fabpont.agendamento.service.AgendamentoService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/agendamentos")
public class AgendamentoController {
    private final AgendamentoService agendamentoService;

    public AgendamentoController(AgendamentoService agendamentoService) {
        this.agendamentoService = agendamentoService;
    }

    @PostMapping
    public AgendamentoResponse createAgendamento(@RequestBody AgendamentoCreateRequest agendamentocreateRequest){
        return agendamentoService.saveAgendamento(agendamentocreateRequest);
    }

    @PutMapping("/{id}/update")
    public AgendamentoResponse updateAgendamento(@PathVariable Long id, @RequestBody AgendamentoUpdateRequest agendamentoupdateRequest){
        return agendamentoService.updateAgendamento(id, agendamentoupdateRequest);
    }

    @PutMapping("/{id}/cancel")
    public AgendamentoResponse cancelAgendamento(Long id){
        return agendamentoService.cancelAgendamento(id);
    }

    @PutMapping("/{id}/concluir")
    public AgendamentoResponse concluirAgendamento(Long id){
        return agendamentoService.closeAgendamento(id);
    }

    @GetMapping("/{id}")
    public AgendamentoResponse findAgendamentoById(@PathVariable Long id){
        return agendamentoService.findAgendamentoById(id);
    }
}
