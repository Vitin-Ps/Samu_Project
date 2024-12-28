CREATE TABLE escala_personalizada (
	id SERIAL PRIMARY KEY,
	nome VARCHAR(255) NOT NULL
);

CREATE TABLE escala_personalizada_dias (
	id SERIAL PRIMARY KEY,
	id_escala_personalizada INT NOT NULL,
	nome VARCHAR(255) NOT NULL,
	dia_semana INT NOT NULL,
	numero_intercessores INT NOT NULL,

	CONSTRAINT fk_personalizada_dias_escala_personalizada FOREIGN KEY(id_escala_personalizada) REFERENCES escala_personalizada(id)
);