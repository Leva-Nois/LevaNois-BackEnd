-- Tabelas Pais e Idioma (sem duplicação)
CREATE TABLE Pais (
    pais_id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    codigo_iso CHAR(3) NOT NULL UNIQUE
);

CREATE TABLE Idioma (
    idioma_id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(50) NOT NULL
);

-- Tabela Instituicao (unificada)
CREATE TABLE Instituicao (
    instituicao_id INT AUTO_INCREMENT PRIMARY KEY,
    tipo ENUM('Escola de Idiomas', 'Centro Cultural', 'Faculdade') NOT NULL,
    nome VARCHAR(60) NOT NULL,
    data_cadastro DATE NOT NULL,
    localizacao VARCHAR(65) NOT NULL,
    pais_id INT NOT NULL,
    idioma_id INT NOT NULL,
    status ENUM('Aceitando inscrições', 'Fechada a inscrições', 'Em processo de análise') NOT NULL,
    cursos_oferecidos VARCHAR(140),  -- Usado apenas para 'Faculdade'
    tipo_formacao ENUM('MBA', 'Graduação', 'Pós-graduação', 'Mestrado', 'Doutorado'),  -- Usado apenas para 'Faculdade'
    requisitos VARCHAR(255),  -- Usado para 'Escola de Idiomas' e 'Centro Cultural'
    custos DECIMAL(10,2),  -- Usado para 'Escola de Idiomas' e 'Faculdade'
    FOREIGN KEY (pais_id) REFERENCES Pais(pais_id) ON DELETE CASCADE,
    FOREIGN KEY (idioma_id) REFERENCES Idioma(idioma_id) ON DELETE CASCADE
);


-- Tabela Programas
CREATE TABLE Programas (
    programa_id INT AUTO_INCREMENT PRIMARY KEY,
    pais_id INT NOT NULL,
    permanencia ENUM('2-3 semanas', '1 mês', '3 meses', '6 meses', '1 ano'),
    planejamento VARCHAR(255),
    instituicao_id INT NOT NULL,
    FOREIGN KEY (pais_id) REFERENCES Pais(pais_id) ON DELETE CASCADE,
    FOREIGN KEY (instituicao_id) REFERENCES Instituicao(instituicao_id) ON DELETE CASCADE
);

-- Tabela Endereco
CREATE TABLE Endereco (
    endereco_id INT AUTO_INCREMENT PRIMARY KEY,
    estado VARCHAR(50) NOT NULL,
    cidade VARCHAR(50) NOT NULL,
    bairro VARCHAR(50),
    rua VARCHAR(100),
    numero VARCHAR(10),
    bloco VARCHAR(10),
    observacao VARCHAR(255)
);

-- Tabela Motivo_Instituicao
CREATE TABLE Motivo_Instituicao (
    motivo_id INT AUTO_INCREMENT PRIMARY KEY,
    motivo ENUM('Língua', 'Cultura', 'Estudo') NOT NULL,
    tipo_instituicao ENUM('Escola de Idiomas', 'Centro Cultural', 'Faculdade') NOT NULL
);

-- Tabela Trabalho
CREATE TABLE Trabalho (
    trabalho_id INT AUTO_INCREMENT PRIMARY KEY,
    profissao VARCHAR(100) NOT NULL,
    cargo VARCHAR(100) NOT NULL,
    salario DECIMAL(10,2) NOT NULL
);

-- Tabela Parentes_Convivio
CREATE TABLE Parentes_Convivio (
    parentes_convivio_id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    grau_parentesco VARCHAR(50) NOT NULL,
    trabalho_id INT,  -- Referência ao trabalho do parente
    FOREIGN KEY (trabalho_id) REFERENCES Trabalho(trabalho_id) ON DELETE SET NULL
);

-- Tabela Usuario
CREATE TABLE Usuario (
    usuario_id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    pais_interesse INT NOT NULL,
    motivo_id INT NOT NULL,
    senha VARCHAR(255) NOT NULL,
    telefone VARCHAR(15),
    celular VARCHAR(15) NOT NULL,
    data_nascimento DATE NOT NULL,
    data_inscricao DATE NOT NULL,
    status ENUM('Ativo', 'Inativo', 'Em viagem') NOT NULL,
    endereco_id INT NOT NULL,
    trabalho_id INT NOT NULL, -- Relacionamento com Trabalho
    parentes_convivio_id INT,  -- Relacionamento com Parentes_Convivio
    FOREIGN KEY (pais_interesse) REFERENCES Pais(pais_id) ON DELETE CASCADE,
    FOREIGN KEY (motivo_id) REFERENCES Motivo_Instituicao(motivo_id) ON DELETE CASCADE,
    FOREIGN KEY (endereco_id) REFERENCES Endereco(endereco_id) ON DELETE CASCADE,
    FOREIGN KEY (trabalho_id) REFERENCES Trabalho(trabalho_id) ON DELETE CASCADE,
    FOREIGN KEY (parentes_convivio_id) REFERENCES Parentes_Convivio(parentes_convivio_id) ON DELETE CASCADE
);

-- Tabela Candidatura
CREATE TABLE Candidatura (
    candidatura_id INT AUTO_INCREMENT PRIMARY KEY,
    usuario_id INT NOT NULL,
    programa_id INT NOT NULL,
    data_candidatura DATE NOT NULL,
    status ENUM('Aprovado', 'Em Análise', 'Rejeitado') NOT NULL,
    FOREIGN KEY (usuario_id) REFERENCES Usuario(usuario_id) ON DELETE CASCADE,
    FOREIGN KEY (programa_id) REFERENCES Programas(programa_id) ON DELETE CASCADE
);