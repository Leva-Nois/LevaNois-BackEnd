-- Gerenciamento de banco
DROP DATABASE IF EXISTS PlataformaIntercambio;
CREATE DATABASE IF NOT EXISTS PlataformaIntercambio;
USE PlataformaIntercambio;

-- Tabelas Auxiliares
CREATE TABLE IF NOT EXISTS Pais (
    pais_id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    codigo_iso CHAR(3) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS Idioma (
    idioma_id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(50) NOT NULL
);

-- Tabelas Principais
CREATE TABLE IF NOT EXISTS Instituicao (
    instituicao_id INT AUTO_INCREMENT PRIMARY KEY,
    tipo ENUM('Escola de Idiomas', 'Centro Cultural', 'Faculdade') NOT NULL,
    nome VARCHAR(60) NOT NULL,
    data_cadastro DATE NOT NULL,
    localizacao VARCHAR(65) NOT NULL,
    pais_id INT NOT NULL,
    idioma_id INT NOT NULL,
    situacao ENUM('Aceitando Inscrições', 'Fechada a Inscrições', 'Em Análise') NOT NULL,
    cursos_oferecidos VARCHAR(140),
    tipo_formacao ENUM('MBA', 'Graduação', 'Pós-graduação', 'Mestrado', 'Doutorado'),
    requisitos VARCHAR(255),
    custos DECIMAL(10,2),
    FOREIGN KEY (pais_id) REFERENCES Pais(pais_id) ON DELETE CASCADE,
    FOREIGN KEY (idioma_id) REFERENCES Idioma(idioma_id) ON DELETE CASCADE
);

-- Tabela Parentes_Convivio
CREATE TABLE IF NOT EXISTS Parentes_Convivio (
    parentes_convivio_id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    grau_parentesco VARCHAR(50) NOT NULL,
    trabalho_id INT,  -- Referência ao trabalho do parente
    FOREIGN KEY (trabalho_id) REFERENCES Trabalho(trabalho_id) ON DELETE SET NULL
);

-- Tabela Trabalho
CREATE TABLE IF NOT EXISTS Trabalho (
    trabalho_id INT AUTO_INCREMENT PRIMARY KEY,
    cargo VARCHAR(100) NOT NULL,
    nome_empresa VARCHAR (30),
    salario DECIMAL(10,2) NOT NULL
);

-- Tabelas de Trilha e Atividades
CREATE TABLE IF NOT EXISTS Trilha (
    trilha_id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    descricao TEXT NOT NULL,
    tipo_trilha ENUM('Língua', 'Cultura', 'Estudo') NOT NULL,
    data_criacao DATETIME DEFAULT CURRENT_TIMESTAMP,
    total_atividades INT NOT NULL
);

CREATE TABLE IF NOT EXISTS Atividade (
    atividade_id INT AUTO_INCREMENT PRIMARY KEY,
    trilha_id INT NOT NULL,
    nome VARCHAR(100) NOT NULL,
    descricao TEXT NOT NULL,
    ordem INT NOT NULL,
    duracao_estimada INT NOT NULL, -- Em minutos
    tipo_atividade ENUM('Vídeo', 'Artigo', 'Quiz', 'Prática') NOT NULL,
    FOREIGN KEY (trilha_id) REFERENCES Trilha(trilha_id) ON DELETE CASCADE
);

-- Progresso do Usuário
CREATE TABLE IF NOT EXISTS ProgressoTrilha (
    progresso_trilha_id INT AUTO_INCREMENT PRIMARY KEY,
    usuario_id INT NOT NULL,
    trilha_id INT NOT NULL,
    etapa_atual INT NOT NULL DEFAULT 0, -- Número da etapa em progresso
    total_etapas INT NOT NULL,
    situacao_trilha ENUM('Em Andamento', 'Concluído') NOT NULL,
    data_inicio DATETIME DEFAULT CURRENT_TIMESTAMP,
    data_fim DATETIME,
    FOREIGN KEY (usuario_id) REFERENCES Usuario(usuario_id) ON DELETE CASCADE,
    FOREIGN KEY (trilha_id) REFERENCES Trilha(trilha_id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS ProgressoAtividade (
    progresso_atividade_id INT AUTO_INCREMENT PRIMARY KEY,
    usuario_id INT NOT NULL,
    atividade_id INT NOT NULL,
    situacao_atividade ENUM('Pendente', 'Concluído') NOT NULL,
    data_conclusao DATETIME,
    FOREIGN KEY (usuario_id) REFERENCES Usuario(usuario_id) ON DELETE CASCADE,
    FOREIGN KEY (atividade_id) REFERENCES Atividade(atividade_id) ON DELETE CASCADE
);

-- Tabela de Usuários
CREATE TABLE IF NOT EXISTS Usuario (
    usuario_id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    pais_interesse INT NOT NULL,
    senha VARCHAR(255) NOT NULL,
    celular VARCHAR(15) NOT NULL,
    data_nascimento DATE NOT NULL,
    data_cadastro DATETIME DEFAULT CURRENT_TIMESTAMP,
    status_usuario ENUM('Ativo', 'Inativo', 'Em Trilha') NOT NULL,
    trabalho_id INT,
    parentes_convivio_id INT,
    FOREIGN KEY (pais_interesse) REFERENCES Pais(pais_id) ON DELETE CASCADE,
    FOREIGN KEY (trabalho_id) REFERENCES Trabalho(trabalho_id) ON DELETE CASCADE,
    FOREIGN KEY (parentes_convivio_id) REFERENCES Parentes_Convivio(parentes_convivio_id) ON DELETE CASCADE
);
