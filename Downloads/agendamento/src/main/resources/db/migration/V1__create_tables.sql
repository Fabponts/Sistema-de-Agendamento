CREATE TABLE tb_agendamento(
    id INTEGER PRIMARY KEY,
    titulo VARCHAR (120) NOT NULL,
    descricao TEXT,
    data_inicio TIMESTAMP NOT NULL,
    date_final TIMESTAMP NOT NULL,
    status VARCHAR(20) NOT NULL DEFAULT 'AGENDADO',
    criado_em TIMESTAMP NOT NULL DEFAULT NOW(),
    CONSTRAINT ck_status CHECK(status IN ('AGENDADO', 'CANCELADO', 'CONCLUIDO')),
    CONSTRAINT ck_intervalo CHECK(data_inicio < date_final)
);

