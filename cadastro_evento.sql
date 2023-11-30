create database cadastro_evento;
use cadastro_evento;

create table usuario(


                        id  bigint(20) primary key auto_increment,
                        nome varchar(200)  ,
                        email varchar (500)


)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
select * from usuario;


drop schema cadastro_evento;

create schema cadastro_evento;

use cadastro_evento;


insert into usuario(id,nome,email) value ( 1,'joao ','joaozinho123@gmail');
insert into usuario(id,nome,email) value ( null,'igot ','igor@gmail');