CREATE TABLE intercessor (
	id SERIAL PRIMARY KEY,
	nome VARCHAR(255) NOT NULL,
	idade INT NOT NULL,
	telefone CHAR(11)
);

CREATE TABLE intercessor_indisponibilidade (
	id SERIAL PRIMARY KEY,
	id_intercessor INT NOT NULL,
	dia DATE NOT NULL,

	CONSTRAINT fk_indisponibilidade_intercessor FOREIGN KEY(id_intercessor) REFERENCES intercessor(id)
);