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


SELECT * FROM questoes WHERE serie = 'Segundo';

-- 🟩 Fáceis — Primeiro ano
INSERT INTO questoes (materia, enunciado, alternativaA, alternativaB, alternativaC, alternativaD, correta, dificuldade, serie)
VALUES 
('Português', 'Qual é o sujeito na frase: “O gato dorme”?', 'Gato', 'Dorme', 'O', 'Sujeito oculto', 'A', 'Fácil', 'Primeiro'),
('Matemática', 'Quanto é 5 + 7?', '11', '12', '13', '10', 'B', 'Fácil', 'Primeiro'),
('Geografia', 'Qual é o maior oceano do mundo?', 'Atlântico', 'Índico', 'Pacífico', 'Ártico', 'C', 'Fácil', 'Primeiro'),
('Inglês', 'Como se diz “cachorro” em inglês?', 'Dog', 'Cat', 'Horse', 'Bird', 'A', 'Fácil', 'Primeiro'),
('História', 'Quem foi o primeiro presidente do Brasil?', 'Getúlio Vargas', 'Dom Pedro II', 'Deodoro da Fonseca', 'Juscelino Kubitschek', 'C', 'Fácil', 'Primeiro');

-- 🟨 Médias — Primeiro ano
INSERT INTO questoes (materia, enunciado, alternativaA, alternativaB, alternativaC, alternativaD, correta, dificuldade, serie)
VALUES 
('Literatura', 'Quem escreveu Dom Casmurro?', 'José de Alencar', 'Machado de Assis', 'Clarice Lispector', 'Graciliano Ramos', 'B', 'Média', 'Primeiro'),
('Sociologia', 'O que significa “cultura” na sociologia?', 'Somente arte', 'Conjunto de saberes e práticas', 'Apenas religião', 'Apenas tecnologia', 'B', 'Média', 'Primeiro'),
('Filosofia', 'Quem é considerado o pai da Filosofia?', 'Aristóteles', 'Platão', 'Tales de Mileto', 'Sócrates', 'C', 'Média', 'Primeiro'),
('Matemática', 'Quanto é 5²?', '10', '20', '25', '30', 'C', 'Média', 'Primeiro'),
('Geografia', 'O desmatamento da Amazônia afeta:', 'Apenas o Brasil', 'Todo o planeta', 'Só a fauna local', 'Só os indígenas', 'B', 'Média', 'Primeiro');

-- 🟥 Difíceis — Primeiro ano
INSERT INTO questoes (materia, enunciado, alternativaA, alternativaB, alternativaC, alternativaD, correta, dificuldade, serie)
VALUES 
('História', 'Qual tratado dividiu o mundo entre Portugal e Espanha?', 'Tratado de Madri', 'Tratado de Tordesilhas', 'Tratado de Versalhes', 'Tratado de Paris', 'B', 'Difícil', 'Primeiro'),
('Filosofia', 'O mito da caverna foi criado por:', 'Aristóteles', 'Platão', 'Sócrates', 'Nietzsche', 'B', 'Difícil', 'Primeiro'),
('Português', 'A palavra “felicidade” é classificada como:', 'Verbo', 'Substantivo abstrato', 'Adjetivo', 'Advérbio', 'B', 'Difícil', 'Primeiro'),
('Inglês', 'Escolha a alternativa que representa corretamente o passado de “go”:', 'Go', 'Going', 'Went', 'Goed', 'C', 'Difícil', 'Primeiro'),
('Matemática', 'Qual é o valor de √144?', '10', '11', '12', '14', 'C', 'Difícil', 'Primeiro');

-- 🟩 Fáceis — Segundo ano
INSERT INTO questoes (materia, enunciado, alternativaA, alternativaB, alternativaC, alternativaD, correta, dificuldade, serie) VALUES
('Português', 'Qual é o plural de “cidadão”?', 'Cidadões', 'Cidadãos', 'Cidadães', 'Cidadãs', 'B', 'Fácil', 'Segundo'),
('Matemática', 'Qual é o valor de 3²?', '6', '9', '12', '8', 'B', 'Fácil', 'Segundo'),
('Geografia', 'Qual continente é conhecido como o “berço da humanidade”?', 'Europa', 'Ásia', 'África', 'América', 'C', 'Fácil', 'Segundo'),
('Inglês', 'O que significa a palavra “book”?', 'Caderno', 'Livro', 'Caneta', 'Mesa', 'B', 'Fácil', 'Segundo'),
('História', 'Em que ano ocorreu a Proclamação da República no Brasil?', '1822', '1889', '1891', '1870', 'B', 'Fácil', 'Segundo');

-- 🟨 Médias — Segundo ano
INSERT INTO questoes (materia, enunciado, alternativaA, alternativaB, alternativaC, alternativaD, correta, dificuldade, serie) VALUES
('Literatura', 'Quem é o autor de “A Moreninha”?', 'José de Alencar', 'Joaquim Manuel de Macedo', 'Machado de Assis', 'Álvares de Azevedo', 'B', 'Média', 'Segundo'),
('Sociologia', 'Qual o principal agente de socialização primária?', 'Escola', 'Família', 'Trabalho', 'Religião', 'B', 'Média', 'Segundo'),
('Filosofia', 'Quem disse: “O homem é o lobo do homem”?', 'Hobbes', 'Rousseau', 'Descartes', 'Kant', 'A', 'Média', 'Segundo'),
('Matemática', 'O que representa a fórmula de Bhaskara?', 'Área de um círculo', 'Solução de equações do 2º grau', 'Volume do cilindro', 'Regra de três', 'B', 'Média', 'Segundo'),
('Geografia', 'O que é uma zona de convergência?', 'Encontro de placas tectônicas', 'Região de muitos ventos', 'Área de chuvas intensas e prolongadas', 'Região de desertos', 'C', 'Média', 'Segundo');

-- 🟥 Difíceis — Segundo ano
INSERT INTO questoes (materia, enunciado, alternativaA, alternativaB, alternativaC, alternativaD, correta, dificuldade, serie) VALUES
('História', 'O que foi a Revolução Constitucionalista de 1932?', 'Um golpe militar', 'Uma luta contra a ditadura de Vargas', 'A criação da nova constituição', 'Um movimento separatista', 'B', 'Difícil', 'Segundo'),
('Filosofia', 'Para Nietzsche, qual é o papel do “além-do-homem” (Übermensch)?', 'Submissão ao Estado', 'Conformidade com a religião', 'Superação dos valores tradicionais', 'Obediência à moral cristã', 'C', 'Difícil', 'Segundo'),
('Português', 'Qual é a função da conjunção “embora” na frase: “Embora estivesse cansado, ele continuou”?', 'Aditiva', 'Concessiva', 'Explicativa', 'Causal', 'B', 'Difícil', 'Segundo'),
('Inglês', 'O que significa a expressão “take your time”?', 'Apresse-se', 'Aproveite o tempo', 'Leve o tempo', 'Vá com calma', 'D', 'Difícil', 'Segundo'),
('Matemática', 'Qual é o valor exato de log₁₀(1000)?', '2', '4', '3', '10', 'C', 'Difícil', 'Segundo');


-- 🟩 Fáceis — Terceiro ano
INSERT INTO questoes (materia, enunciado, alternativaA, alternativaB, alternativaC, alternativaD, correta, dificuldade, serie) VALUES
('Português', 'Qual é o antônimo da palavra “alegria”?', 'Tristeza', 'Felicidade', 'Amor', 'Cansaço', 'A', 'Fácil', 'Terceiro'),
('Matemática', 'Qual é a derivada de uma constante?', 'A própria constante', 'Zero', 'Infinito', 'A variável', 'B', 'Fácil', 'Terceiro'),
('Geografia', 'Qual é o bioma predominante na região Norte do Brasil?', 'Cerrado', 'Caatinga', 'Mata Atlântica', 'Floresta Amazônica', 'D', 'Fácil', 'Terceiro'),
('Inglês', 'Como se diz “faculdade” em inglês?', 'School', 'College', 'Factory', 'University', 'B', 'Fácil', 'Terceiro'),
('História', 'Qual país foi invadido pela Alemanha nazista em 1939, iniciando a Segunda Guerra Mundial?', 'França', 'Polônia', 'Inglaterra', 'União Soviética', 'B', 'Fácil', 'Terceiro');

-- 🟨 Médias — Terceiro ano
INSERT INTO questoes (materia, enunciado, alternativaA, alternativaB, alternativaC, alternativaD, correta, dificuldade, serie) VALUES
('Literatura', 'O movimento literário “Modernismo” no Brasil teve início em que ano?', '1922', '1888', '1930', '1900', 'A', 'Média', 'Terceiro'),
('Sociologia', 'Quem escreveu “A Ética Protestante e o Espírito do Capitalismo”?', 'Karl Marx', 'Émile Durkheim', 'Max Weber', 'Auguste Comte', 'C', 'Média', 'Terceiro'),
('Filosofia', 'O que significa o “Cogito, ergo sum” de Descartes?', 'Eu creio em Deus', 'Eu sou um homem', 'Penso, logo existo', 'Conheço o mundo', 'C', 'Média', 'Terceiro'),
('Matemática', 'Qual é a integral de x² dx?', 'x³', '(1/3)x³', '2x', 'ln(x)', 'B', 'Média', 'Terceiro'),
('Geografia', 'Qual o nome do processo de urbanização descontrolada que gera favelas?', 'Urbanismo', 'Gentrificação', 'Periferização', 'Migração rural', 'C', 'Média', 'Terceiro');

-- 🟥 Difíceis — Terceiro ano
INSERT INTO questoes (materia, enunciado, alternativaA, alternativaB, alternativaC, alternativaD, correta, dificuldade, serie) VALUES
('História', 'Qual tratado marcou o fim da Primeira Guerra Mundial?', 'Tratado de Tordesilhas', 'Tratado de Paris', 'Tratado de Versalhes', 'Tratado de Viena', 'C', 'Difícil', 'Terceiro'),
('Filosofia', 'Quem elaborou o conceito de “vontade de potência”?', 'Kant', 'Hegel', 'Nietzsche', 'Sócrates', 'C', 'Difícil', 'Terceiro'),
('Português', 'Qual figura de linguagem está presente em: “O vento cantava entre as árvores”?', 'Metáfora', 'Prosopopeia', 'Antítese', 'Ironia', 'B', 'Difícil', 'Terceiro'),
('Inglês', 'Qual é o tempo verbal da frase: “She had already eaten”?', 'Present Perfect', 'Past Simple', 'Future Perfect', 'Past Perfect', 'D', 'Difícil', 'Terceiro'),
('Matemática', 'Qual é o valor de sen(π/2) em radianos?', '0', '1', '-1', '√2', 'B', 'Difícil', 'Terceiro');