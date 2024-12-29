ALTER TABLE escala_intercessor ADD COLUMN id_configuracao INT NOT NULL;

ALTER TABLE escala_intercessor ADD CONSTRAINT fk_escala_intercessor_configuracao FOREIGN KEY (id_configuracao) REFERENCES escala_configuracao(id);