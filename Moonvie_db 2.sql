use master if exists (SELECT * FROM SYS.databases WHERE name = 'moonvie_db')

DROP DATABASE moonvie_db
GO

CREATE DATABASE moonvie_db;
GO

USE moonvie_db
GO 

CREATE TABLE genero (
    id BIGINT IDENTITY(1,1) PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    descricao VARCHAR(255),
    cod_status BIT NOT NULL
);

CREATE TABLE titulo (
    id BIGINT IDENTITY(1,1) PRIMARY KEY,
    nome VARCHAR(150) NOT NULL,
    sinopse VARCHAR(MAX),
    descricao VARCHAR(255),
    ano_lancamento INT,
    cod_status BIT NOT NULL
);

CREATE TABLE filme (
    id BIGINT IDENTITY(1,1) PRIMARY KEY,
    titulo_id BIGINT NOT NULL,
    duracao_minutos INT,
    diretor VARCHAR(150),
    cod_status BIT NOT NULL,
    CONSTRAINT fk_filme_titulo FOREIGN KEY (titulo_id) REFERENCES titulo(id)
);

CREATE TABLE serie (
    id BIGINT IDENTITY(1,1) PRIMARY KEY,
    titulo_id BIGINT NOT NULL,
    total_temporadas INT,
    elenco VARCHAR(255),
    status VARCHAR(50),
    cod_status BIT NOT NULL,
    CONSTRAINT fk_serie_titulo FOREIGN KEY (titulo_id) REFERENCES titulo(id)
);

CREATE TABLE temporada (
    id BIGINT IDENTITY(1,1) PRIMARY KEY,
    numero INT NOT NULL,
    serie_id BIGINT NOT NULL,
    cod_status BIT NOT NULL,
    CONSTRAINT fk_temporada_serie FOREIGN KEY (serie_id) REFERENCES serie(id)
);

CREATE TABLE episodio (
    id BIGINT IDENTITY(1,1) PRIMARY KEY,
    numero INT NOT NULL,
    nome VARCHAR(150) NOT NULL,
    descricao VARCHAR(255),
    duracao INT NOT NULL, 
    temporada_id BIGINT NOT NULL,
    cod_status BIT NOT NULL,
    CONSTRAINT fk_episodio_temporada FOREIGN KEY (temporada_id) REFERENCES temporada(id)
);

CREATE TABLE classifica (
    id BIGINT IDENTITY(1,1) PRIMARY KEY,
    id_usuario BIGINT NOT NULL,
    id_titulo BIGINT NOT NULL,
    nota DECIMAL(3,1),
    comentario VARCHAR(MAX),
    cod_status BIT NOT NULL,
    CONSTRAINT fk_classifica_titulo FOREIGN KEY (id_titulo) REFERENCES titulo(id)
);