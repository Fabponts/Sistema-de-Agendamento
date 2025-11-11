package dev.fabpont.agendamento.service;

import dev.fabpont.agendamento.dto.AgendamentoCreateRequest;
import dev.fabpont.agendamento.dto.AgendamentoResponse;
import dev.fabpont.agendamento.dto.AgendamentoUpdateRequest;
import dev.fabpont.agendamento.mapper.AgendamentoMapper;
import dev.fabpont.agendamento.model.Agendamento;
import dev.fabpont.agendamento.model.StatusAgendamento;
import dev.fabpont.agendamento.repository.AgendamentoRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AgendamentoService {

    private final AgendamentoRepository agendamentoRepository;

    public AgendamentoService(AgendamentoRepository agendamentoRepository) {
        this.agendamentoRepository = agendamentoRepository;
    }

    @Transactional
    public AgendamentoResponse updateAgendamento(Long id, @Valid AgendamentoUpdateRequest agendamentoUpdateRequest) {
        Agendamento entity = agendamentoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Agendamento nao encontrado"));
        AgendamentoMapper.merge(entity,agendamentoUpdateRequest);
        validarInterval(agendamentoUpdateRequest.dataInicio(), agendamentoUpdateRequest.dataFinal());
        entity = agendamentoRepository.save(entity);
        return AgendamentoMapper.toResponse(entity);
    }

    @Transactional
    public AgendamentoResponse saveAgendamento(@Valid AgendamentoCreateRequest agendamentoCreateRequest) {
        validarInterval(agendamentoCreateRequest.dataInicio(), agendamentoCreateRequest.dataFinal());

        Agendamento entity = AgendamentoMapper.toEntity(agendamentoCreateRequest);
        entity = agendamentoRepository.save(entity);
        return AgendamentoMapper.toResponse(entity);
    }

    @Transactional
    public AgendamentoResponse cancelAgendamento(Long id) {
        Agendamento entity = agendamentoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Agendamento nao encontrado"));
        entity.setStatus(StatusAgendamento.CANCELADO);
        entity = agendamentoRepository.save(entity);
        return AgendamentoMapper.toResponse(entity);
    }

    @Transactional
    public AgendamentoResponse closeAgendamento(Long id){
        Agendamento entity = agendamentoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Agendamento nao encontrado"));
        entity.setStatus(StatusAgendamento.CONCLUIDO);
        entity = agendamentoRepository.save(entity);
        return AgendamentoMapper.toResponse(entity);
    }

    @Transactional
    public AgendamentoResponse findAgendamentoById(Long id){
        Agendamento entity = agendamentoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Agendamento nao encontrado"));
        return AgendamentoMapper.toResponse(entity);
    }

    private void validarInterval(LocalDateTime dataInicio, LocalDateTime dataFinal) {
        if(dataInicio == null || dataFinal == null || !dataInicio.isBefore(dataFinal)) {
            throw new IllegalArgumentException("Intervalo Data inicio deve ser interior a data final");
        }
    }

}
