create table candidato(
	id bigint not null auto_increment,
    nome varchar(60) not null,
    cpf varchar(14) not null,
    data_nascimento varchar(14),
    email varchar(60),
	telefone varchar(60),
    escolaridade varchar(60),
    funcao varchar(60),
    status varchar(20),
    tipo varchar(10),
    
    primary key(id)
);