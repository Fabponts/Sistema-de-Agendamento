package dev.fabpont.agendamento.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
    private String dataInicio;
    @Column(name = "data_final",nullable = false)
    private String dataFim;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 15)
    private StatusAgendamento status;
    @Column(name = "criado_em", nullable = false)
    private String criadoEm;
}
