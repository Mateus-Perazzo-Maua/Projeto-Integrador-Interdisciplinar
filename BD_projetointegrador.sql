CREATE SCHEMA projeto_integrador;

USE projeto_integrador;

DROP TABLE IF EXISTS tb_usuario;
CREATE TABLE tb_usuario (id INT PRIMARY KEY AUTO_INCREMENT, nome VARCHAR(200), senha VARCHAR(200), tipo VARCHAR(200));
INSERT INTO tb_usuario(nome, senha, tipo) VALUES ('aluno','aluno', 'aluno');
INSERT INTO tb_usuario(nome, senha, tipo) VALUES ('professor','professor', 'professor');
SELECT * FROM tb_usuario;

DROP TABLE IF EXISTS questoes;
CREATE TABLE questoes (id INT AUTO_INCREMENT PRIMARY KEY, materia VARCHAR(50), enunciado TEXT, alternativaA VARCHAR(255), alternativaB VARCHAR(255), 
alternativaC VARCHAR(255), alternativaD VARCHAR(255), correta CHAR(1));
ALTER TABLE questoes ADD COLUMN dificuldade VARCHAR(10);
ALTER TABLE questoes ADD COLUMN serie VARCHAR(10);
SELECT * FROM questoes;
SELECT * FROM questoes;