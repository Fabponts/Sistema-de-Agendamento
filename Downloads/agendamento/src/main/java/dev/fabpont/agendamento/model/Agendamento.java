package dev.fabpont.agendamento.model;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tb_agendamento")

public class Agendamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,length = 120)
    private String titulo;
    @Column(columnDefinition = "TEXT")
    private String descricao;
    @Column(name = "data_inicio",nullable = false)
    private LocalDateTime dataInicio;
    @Column(name = "date_final",nullable = false)
    private LocalDateTime dataFinal;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 15)
    private StatusAgendamento status;
    @Column(name = "criado_em", nullable = false)
    private LocalDateTime criadoEm;
}
