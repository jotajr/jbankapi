create table agencia
(
    id_agencia int auto_increment,
    nome_agencia varchar(45) not null,
    endereco varchar(45) not null,
    telefone varchar(20) not null,
    constraint agencia_id_agencia_uindex
        unique (id_agencia)
)
    comment 'Dados das Agencias do Banco';

alter table agencia
    add primary key (id_agencia);

