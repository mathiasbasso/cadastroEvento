create database cadastro_evento;
use cadastro_evento;

create table usuario(
  id  bigint(20) primary key auto_increment,
  nome varchar(200) not null ,
  email varchar (500) not  null 

);
select * from usuario;
insert into usuario(id,nome,email) value ( 1,'joao ','joaozinho123@gmail');