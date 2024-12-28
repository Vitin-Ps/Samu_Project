CREATE TABLE escala_configuracao (
	id SERIAL PRIMARY KEY,
	max_participacoes INT NOT NULL,
	percentual_principal INT NOT NULL
);

CREATE TABLE escala (
	id SERIAL PRIMARY KEY,
	id_configuracao INT NOT NULL,
	nome VARCHAR(255) NOT NULL,
	dia DATE NOT NULL,

	CONSTRAINT fk_escala_configuracao FOREIGN KEY(id_configuracao) REFERENCES escala_configuracao(id)
);

CREATE TABLE escala_intercessor (
	id SERIAL PRIMARY KEY,
	id_escala INT NOT NULL,
	id_intercessor INT NOT NULL,
	tipo_intercessor CHAR(9),

	CONSTRAINT fk_escala_intercessor_escala FOREIGN KEY(id_escala) REFERENCES escala(id),
	CONSTRAINT fk_escala_intercessor_intercessor FOREIGN KEY(id_intercessor) REFERENCES intercessor(id)
);