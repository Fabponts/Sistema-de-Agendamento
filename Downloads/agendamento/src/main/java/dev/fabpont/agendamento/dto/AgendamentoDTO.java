package dev.fabpont.agendamento.dto;

import dev.fabpont.agendamento.model.StatusAgendamento;
import jakarta.persistence.*;

public class AgendamentoDTO {
    private String tituloDTO;
    private String descricaoDTO;
    private String dataInicioDTO;
    private String dataFimDTO;
    private StatusAgendamento statusDTO;
    private String criadoEmDTO;
}
