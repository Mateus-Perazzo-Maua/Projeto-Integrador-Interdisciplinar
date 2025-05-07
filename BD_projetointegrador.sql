CREATE SCHEMA projeto_integrador;

USE projeto_integrador;

DROP TABLE tb_usuario;
CREATE TABLE tb_usuario (id INT PRIMARY KEY AUTO_INCREMENT, nome VARCHAR(200), senha VARCHAR(200), tipo VARCHAR(200));
INSERT INTO tb_usuario(nome, senha, tipo) VALUES ('aluno','aluno', 'aluno');
INSERT INTO tb_usuario(nome, senha, tipo) VALUES ('professor','professor', 'professor');

CREATE TABLE tb_materia(
id INT PRIMARY KEY AUTO_INCREMENT,
nome VARCHAR(200) NOT NULL
);

SELECT * FROM tb_materia;