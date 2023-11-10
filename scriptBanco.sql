
create database clinicaMedica; 
use clinicaMedica; 


create table Endereco(
id_endereco int primary key auto_increment, 
cep_end int, 
rua_end varchar(200) not null, 
bairro_end varchar(100), 
cidade_end varchar(100) not null, 
uf_end varchar(5) not null
);


create table Pessoa (
id_pessoa int primary key auto_increment, 
nome_pes varchar(200), 
dataNascimento_pes date, 
sexo_pes varchar(10), 
cpf_pes varchar(20), 
telefone_pes varchar(30), 


id_endereco_fk int not null, 
foreign key (id_endereco_fk)
references Endereco(id_endereco)
on update cascade 
on delete restrict 
); 

create table Paciente(
id_paciente int primary key auto_increment,  
foto_pac varchar(500), 

id_pessoa_fk int not null, 
foreign key (id_pessoa_fk)
references Pessoa(id_pessoa)
on update cascade
on delete restrict
); 


create table Especialidade (
id_especialidade int primary key auto_increment,  
nome_esp varchar(200) 
); 

create table Medico (
id_medico int primary key auto_increment,  
crm_med int,


id_pessoa_fk int not null, 
foreign key (id_pessoa_fk)
references Pessoa(id_pessoa)
on update cascade
on delete restrict, 


id_especialidade_fk int not null, 
foreign key (id_especialidade_fk)
references Especialidade(id_especialidade)
on update cascade
on delete restrict
);  


create table Consulta (
id_consulta int primary key auto_increment,
data_con date, 
hora_con time, 
formaPagamento_con varchar(20),

id_paciente_fk int not null, 
foreign key (id_paciente_fk)
references Paciente(id_paciente)
on update cascade
on delete restrict, 

id_medico_fk int not null, 
foreign key (id_medico_fk)
references Medico(id_medico)
on update cascade
on delete restrict 
);


create table Exame(
id_exame int primary key auto_increment,
nome_exa varchar(200), 
valor_exa int, 
orientacao_exa varchar(1000)
);


create table PedidoExame (
id_pedidoExame int primary key auto_increment, 
data_pedExa date, 
hora_pedExa time, 
valor_pedExa int, 

id_exame_fk int not null, 
foreign key (id_exame_fk)
references Exame(id_exame)
on update cascade
on delete restrict, 

id_paciente_fk int not null, 
foreign key (id_paciente_fk)
references Paciente(id_paciente)
on update cascade
on delete restrict, 

id_medico_fk int not null, 
foreign key (id_medico_fk)
references Medico(id_medico)
on update cascade
on delete restrict 
);


