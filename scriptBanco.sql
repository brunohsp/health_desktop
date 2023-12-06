-- drop database clinicaMedica;
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
dataNascimento_pes varchar(20), 
sexo_pes varchar(10), 
cpf_pes varchar(30), 
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
metodoPagamento_pac varchar(500),

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
insert especialidade values (null, "cardiologia");
select * from especialidade;

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
data_con varchar(20), 
hora_con varchar(20), 

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
valor_exa double, 
orientacao_exa varchar(1000)
);
-- update Exame set nome_exa = ?, valor_exa = ?, orientacao_exa = ?, codigo_exa = ? where id_exame = ?
-- delete from Consulta where codigo_exa = ?;     


create table PedidoExame (
id_pedidoExame int primary key auto_increment, 
data_pedExa varchar(20), 
hora_pedExa varchar(20), 
pagamentoRecebido double,

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


insert especialidade values (null, "Cardiologia", 987);
update Especialidade set nome_esp = "Cardiopatia" where id_especialidade = 1;
select * from especialidade;
*/


delimiter $$ 
create procedure inserirPaciente (nome varchar(200), dataNascimento varchar(20), sexo varchar(10), cpf varchar(30), telefone varchar(30), foto varchar(500), pagamento varchar(500),
									cep int, rua varchar(200), bairro varchar(100), cidade varchar(100), uf varchar(5))
	begin 
		declare idEnd int;
		declare idPes int; 
		
		insert into endereco values (null, cep, rua, bairro, cidade, uf);
        select id_endereco into idEnd from Endereco where id_endereco = last_insert_id();
		
		insert into pessoa values (null, nome, dataNascimento, sexo, cpf, telefone, pagamento, idEnd);
        select id_pessoa into idPes from Pessoa where id_pessoa = last_insert_id();
		
		insert into paciente values (null, foto, idPes);
	end; 
$$ delimiter ; 
-- call inserirPaciente ("Angelica das Jabuticabas", "2000-10-10", "Feminino", "213211", "879845", "liktjgfhgc.com", "963775", "João Antonio", "Jardim Carvalho", "Ponta Grossa", "PR");
/*
** drop procedure inserirPaciente;
** call inserirPaciente ("Jose das Couves", "1970-04-01", "Masculino", "789369", "453454354", "jgfjgfdjgfgj.com", "789666", "Monteiro Lobato", "Jardim Carvalho", "Ponta Grossa", "PR");
** select * from paciente; 
*/

delimiter $$ 
create procedure alterarPaciente (idPaciente int, nome varchar(200), dataNascimento varchar(20), sexo varchar(10), cpf varchar(30), telefone varchar(30), foto varchar(500), pagamento varchar(500),
									cep int, rua varchar(200), bairro varchar(100), cidade varchar(100), uf varchar(5))
	begin 
		declare idEnd int;
		declare idPes int; 
        declare idPac int; 
        
        select id_pessoa_fk into idPac from Paciente where id_paciente = idPaciente; 		
        select id_pessoa into idPes from Pessoa where id_pessoa = idPac;
        select id_endereco into idEnd from Endereco where id_endereco = idPes;
        
        
		update Endereco set cep_end = cep, rua_end = rua, bairro_end = bairro, cidade_end = cidade, uf_end = uf where id_endereco = idEnd; 
		update Pessoa set nome_pes = nome, dataNascimento_pes = dataNascimento, sexo_pes = sexo, cpf_pes = cpf, telefone_pes = telefone where id_pessoa = idPes;
        update Paciente set foto_pac = foto, metodoPagamento_pac = pagamento where id_paciente = idPaciente; 
        
	end; 
$$ delimiter ;

/*
drop procedure alterarPaciente;  
call alterarPaciente (2, "Jose das Aboboras", "1988-04-01", "Masculino", "789369", "453454354", "jgfjgfdjgfgj.com", "789666", "Monteiro Lobato", "Jardim Carvalho", "Ponta Grossa", "PR");
select * from Pessoa; 
*/ 

delimiter $$ 
create procedure excluirPaciente (cpf varchar(30))
-- excluisão pelo cpf 
    begin 
		declare idEnd int;
        declare idEndPes int;
		declare idPessoa int;     
        declare idPac int;
        
        select id_pessoa into idPessoa from Pessoa where cpf_pes = cpf; 
        select id_endereco_fk into idEndPes from Pessoa where id_endereco_fk = idPessoa; 
        select id_endereco into idEnd from Endereco where idEndPes = id_endereco;
        select id_paciente into idPac from Paciente where id_pessoa_fk = idPessoa;
        
        delete from Paciente where id_paciente = idPac;
        delete from Pessoa where id_pessoa = idPessoa;
        delete from Endereco where id_endereco = idEnd;        
        
	end; 
$$ delimiter ; 

/*
drop procedure excluirPaciente;
call excluirPaciente ("789369");
select * from paciente;
select * from pessoa;
*/

  
delimiter $$ 
create procedure buscarPacienteTodos()
	begin 
		select pessoa.nome_pes, pessoa.dataNascimento_pes, pessoa.sexo_pes, pessoa.cpf_pes, pessoa.telefone_pes, paciente.foto_pac, 
					pessoa.metodoPagamento_pac from pessoa inner join paciente on (paciente.id_pessoa_fk = pessoa.id_pessoa) order by pessoa.nome_pes;       
	end; 
$$ delimiter ;

delimiter $$ 
create procedure buscarPacienteCpf(cpf varchar(30))
	begin 
		
		declare idPessoa int;     
        declare idPac int;
        
        select id_pessoa into idPessoa from Pessoa where cpf_pes = cpf; 
        select id_paciente into idPac from Paciente where id_pessoa_fk = idPessoa;
        
		select pessoa.nome_pes, pessoa.dataNascimento_pes, pessoa.sexo_pes, pessoa.cpf_pes, paciente.foto_pac, pessoa.metodoPagamento_pac 
        from pessoa inner join paciente on (paciente.id_pessoa_fk = pessoa.id_pessoa) order by pessoa.nome_pes;    
        
	end; 
$$ delimiter ;

delimiter $$ 
create procedure relatórioCliente(cpf varchar(30))
	begin 
		declare idPessoa int;     
        declare idPac int;
        declare idMed int;
        
        
        select id_pessoa into idPessoa from Pessoa where cpf_pes = cpf; 
        select id_paciente into idPac from Paciente where id_pessoa_fk = idPessoa;
        
		select pessoa.nome_pes, pessoa.dataNascimento_pes, pessoa.sexo_pes, pessoa.cpf_pes, paciente.foto_pac, pessoa.metodoPagamento_pac, 
				consulta.data_con, consulta.hora_con, (select medico.nome_med from medico where id_medico = consulta.id_medico_fk) , 
                PedidoExame.data_pedExa, PedidoExame.hora_pedExa, PedidoExame.pagamentoRecebido, (select medico.nome_med from medico where id_medico = pedidoExame.id_medico_fk),
                (select exame.nome_exa from exame where id_exame = pedidoExame.id_exame_fk)
        from pessoa inner join paciente on (paciente.id_pessoa_fk = pessoa.id_pessoa) 
        inner join consulta on (consulta.id_paciente_fk = paciente.id_paciente)
        inner join PedidoExame on (pedidoExame.id_paciente_fk = paciente.id_paciente)
        order by consulta.data_con;    
        
	end; 
$$ delimiter ;

/*
create table PedidoExame (
id_pedidoExame int primary key auto_increment, 
data_pedExa varchar(20), 
hora_pedExa varchar(20), 
pagamentoRecebido double,

id_exame_fk int not null, 
id_paciente_fk int not null,

from pessoa inner join paciente on (paciente.id_pessoa_fk = pessoa.id_pessoa) inner join consulta on (consulta.id_paciente_fk = paciente.id_paciente) 
            inner join medico on (consulta.id_medico_fk = medico.id_medico) order by consulta.data_con; 
*/



-- drop procedure buscarPacienteTodos;
-- call buscarPacienteTodos();

delimiter $$ 
create procedure inserirMedico (nome varchar(200), dataNascimento varchar(20), sexo varchar(10), cpf varchar(30), telefone varchar(30), crm int,
								cep int, rua varchar(200), bairro varchar(100), cidade varchar(100), uf varchar(5), especialidade varchar(200))
    begin
		declare idEsp int; 
        declare idEnd int; 
        declare idPes int;
        
        select id_especialidade into idEsp from Especialidade where nome_esp = especialidade; 
        
        insert into endereco values (null, cep, rua, bairro, cidade, uf);
        select id_endereco into idEnd from Endereco where id_endereco = last_insert_id();
        
        insert into pessoa values (null, nome, dataNascimento, sexo, cpf, telefone, idEnd);
		select id_pessoa into idPes from Pessoa where id_pessoa = last_insert_id();
        
        insert into medico values (null, crm, idPes, idEsp);
        
    end; 
$$ delimiter ;


/*
select * from especialidade;
call inserirMedico ("Carolina Almeida", "1988-09-16", "Feminino", 753369, "42987451589", 987, 78654321, "Rua Guarani", "Jardim America", "Ponta Grossa", "PR", "Cardiologia" );
*/


delimiter $$ 
create procedure alterarMedico (idMedico int, nome varchar(200), dataNascimento varchar(20), sexo varchar(10), cpf varchar(30), telefone varchar(30), crm int,
									cep int, rua varchar(200), bairro varchar(100), cidade varchar(100), uf varchar(5))
	begin 
		declare idEnd int;
		declare idPes int; 
        declare idMec int; 
        
        select id_pessoa_fk into idMec from Medico where id_medico = idMedico; 		
        select id_pessoa into idPes from Pessoa where id_pessoa = idMec;
        select id_endereco into idEnd from Endereco where id_endereco = idPes;
        
        
		update Endereco set cep_end = cep, rua_end = rua, bairro_end = bairro, cidade_end = cidade, uf_end = uf where id_endereco = idEnd; 
		update Pessoa set nome_pes = nome, dataNascimento_pes = dataNascimento, sexo_pes = sexo, cpf_pes = cpf, telefone_pes = telefone where id_pessoa = idPes;
        update Medico set crm_med = crm where id_medico = idMedico; 
        
	end; 
$$ delimiter ;

-- update Consulta set data_con = ?, hora_con = ?, formaPagamento_con = ?, id_paciente_fk = ?, id_medico_fk = ? where id_consulta = ?

delimiter $$ 
create procedure excluirMedico (cpf varchar(30))
-- exclusão pelo cpf 
    begin 
		declare idEnd int;
        declare idEndPes int;
		declare idPessoa int;     
        declare idMec int;
        
        select id_pessoa into idPessoa from Pessoa where cpf_pes = cpf; 
        select id_endereco_fk into idEndPes from Pessoa where id_endereco_fk = idPessoa; 
        select id_endereco into idEnd from Endereco where idEndPes = id_endereco;
        select id_medico into idMec from Medico where id_pessoa_fk = idPessoa;
        
        delete from Medico where id_medico = idMec;
        delete from Pessoa where id_pessoa = idPessoa;
        delete from Endereco where id_endereco = idEnd;        
        
	end; 
$$ delimiter ; 

delimiter $$
create procedure buscarMedicoTodos()
	begin 
		select pessoa.nome_pes, pessoa.dataNascimento_pes, pessoa.sexo_pes, pessoa.cpf_pes, pessoa.telefone_pes, medico.crm_med 
			from pessoa inner join medico on (medico.id_pessoa_fk = pessoa.id_pessoa) order by pessoa.nome_pes;        
	end; 
$$ delimiter ;

/*
drop procedure buscarMedicoTodos;
call buscarMedicoTodos();
*/

delimiter $$
create procedure excluirEspecialidade (especialidade varchar(200))
	begin 
    declare idEsp int; 
    
    select id_especialidade into idEsp from Especialidade where nome_esp = especialidade; 
    
    delete from Especialidade where id_especialidade = idEsp; 
    
	end;
$$ delimiter ;

/*
call excluirEspecialidade("cardiopatia");
select * from Especialidade;
*/


delimiter $$ 
create procedure inserirConsulta(dataConsulta varchar(20), horaConsulta varchar(20), cpfPaciente varchar(30), crm int)
	begin 
        declare idPesPac int;
		declare idPac int; 
        declare idMed int; 
        
        select id_pessoa into idPesPac from Pessoa where cpf_pes = cpfPaciente;
		select id_paciente into idPac from Paciente where id_pessoa_fk = idPesPac; 
		select id_medico into idMed from Medico where crm_med = crm;
       
		insert into Consulta values (null, dataConsulta, horaConsulta, idPac, idMed);
    end; 
$$ delimiter ; 


delimiter $$ 
create procedure excluirConsulta(cpfPaciente varchar(30), dia varchar(20))
	begin 
		declare idPesPac int;
        declare idPac int; 
        
        select id_pessoa into idPesPac from Pessoa where cpf_pes = cpfPaciente;
        select id_paciente into idPac from Paciente where id_pessoa_fk = idPesPac; 
        
        delete from Consulta where id_paciente_fk = idPac and data_con = dia;
        
    end;
$$ delimiter ;


delimiter $$ 
create procedure buscarTodosConsulta ()
	begin 
    
    select pessoa.nome_pes, pessoa.cpf_pes, pessoa.telefone_pes, medico.crm_med, consulta.data_con, consulta.hora_con 
			from pessoa inner join paciente on (paciente.id_pessoa_fk = pessoa.id_pessoa) inner join consulta on (consulta.id_paciente_fk = paciente.id_paciente) 
            inner join medico on (consulta.id_medico_fk = medico.id_medico) order by consulta.data_con;        
    
    end;
$$ delimiter ;
/*
call buscarTodosConsulta();
select * from consulta;

-- call alterarConsulta()


call inserirConsulta(213211, 987, "cheque");
insert into Consulta values (null, curdate(), curtime(), "Cartao credito", 2, 1);
select * from Consulta;
select * from medico;
select * from paciente;
select * from pessoa;
*/

 delimiter $$ 
 create procedure  inserirPedidoExame (dataExame varchar(20), horaExame varchar(20), cpf varchar(30), crm int, exame varchar(100), pagamento double)
	begin 
		declare idPesPac int;
		declare idPac int; 
        declare idExa int;
        declare idMed int;
        
        select id_pessoa into idPesPac from Pessoa where cpf_pes = cpfPaciente;
        select id_paciente into idPac from Paciente where id_pessoa_fk = idPesPac; 
        select id_exame into idExa from Exame where codigo_exa = exame;
        select id_medico into idMed from Medico where crm_med = crm;
        
        insert into PedidoExame values (null, dataExame, horaExame, pagamento, idExa, idPac, idMed);
    
    end;
 $$ delimiter ;
 
 
 
 
 delimiter $$ 
 create procedure atualizarPedidoExame (idPedido int, dataExa date, horaExa time, valor double, pagamento double, idExame int, idPaciente int, idMedico int)
	begin
    
    update PedidoExame set data_pedExa = dataExa, hora_pedExa = horaExa, pagamentoRecebido = pagamento, id_exame_fk = idExame, id_paciente_fk = idPaciente, id_medico_fk = idMedico;
    end; 
 $$ delimiter ;
 

delimiter $$ 
create procedure buscarTodosPedidoExame ()
	begin
    
		 select pessoa.nome_pes, pessoa.cpf_pes, pessoa.telefone_pes, medico.crm_med, pedidoExame.data_pedExa, pedidoExame.hora_pedExa
			from pessoa inner join paciente on (paciente.id_pessoa_fk = pessoa.id_pessoa) inner join PedidoExame on (PedidoExame.id_paciente_fk = paciente.id_paciente) 
            inner join medico on (PedidoExame.id_medico_fk = medico.id_medico) order by PedidoExame.data_con;      
            
    end;
$$ delimiter ;


            