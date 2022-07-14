create table competencia(
	id bigint not null auto_increment,
    candidato_id bigint not null,
    nome varchar(30) not null,
    descricao varchar(255) not null,
    nivel varchar(20) not null,
    
	primary key(id)
);

alter table competencia add constraint fk_competencia_candidato 
foreign key(candidato_id) references candidato(id);