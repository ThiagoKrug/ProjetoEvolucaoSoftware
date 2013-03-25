-- SET FOREIGN_KEY_CHECKS = 0; --

-- ------------------------------
-- INSERTS TABELA CLASSE 
-- ------------------------------
INSERT INTO `classe` (`id_classe`, `nome_classe`, `peso_classe`, `nota_referencia_classe`) VALUES (NULL, 'Formação e Aperfeiçoamento Acadêmico', '0.3', '10');
INSERT INTO `classe` (`id_classe`, `nome_classe`, `peso_classe`, `nota_referencia_classe`) VALUES (NULL, 'Produção Científica, Tecnológica, Artística e Cultural', '0.4', '10');
INSERT INTO `classe` (`id_classe`, `nome_classe`, `peso_classe`, `nota_referencia_classe`) VALUES (NULL, 'Atividades de Pesquisa, Ensino e Extensão', '0.3', '10');

-- -----------------------------
-- INSERTS TABELA ITEM_CLASSE
-- -----------------------------
-- Classe 1

INSERT IGNORE INTO `item_classe` (`id_item_classe`, `discriminacao`, `pontuacao`, `id_classe`) VALUES (NULL, 'Doutorado na área objeto do Concurso', '6', '1');
INSERT IGNORE INTO `item_classe` (`id_item_classe`, `discriminacao`, `pontuacao`, `id_classe`) VALUES (NULL, 'Doutorado em área afim da área objeto do Concurso', '5', '1');
INSERT IGNORE INTO `item_classe` (`id_item_classe`, `discriminacao`, `pontuacao`, `id_classe`) VALUES (NULL, 'Mestrado na área objeto do Concurso', '4', '1');
INSERT IGNORE INTO `item_classe` (`id_item_classe`, `discriminacao`, `pontuacao`, `id_classe`) VALUES (NULL, 'Mestrado em área afim da área objeto do Concurso', '2.5', '1');
INSERT IGNORE INTO `item_classe` (`id_item_classe`, `discriminacao`, `pontuacao`, `id_classe`) VALUES (NULL, 'Especialização na área objeto do Concurso, com exigência de aproveitamento e frequência com duração mínima de 360 horas', '0.5', '1');
INSERT IGNORE INTO `item_classe` (`id_item_classe`, `discriminacao`, `pontuacao`, `id_classe`) VALUES (NULL, 'Residência realizada em instituição credenciada pela Comissão Nacional de Residência Médica ou equivalente, na especialidade objeto do concurso', '0.5', '1');
INSERT IGNORE INTO `item_classe` (`id_item_classe`, `discriminacao`, `pontuacao`, `id_classe`) VALUES (NULL, 'Conclusão, com aproveitamento comprovado pelos conceitos, de todos os créditos de Doutorado na área do Concurso, desde que com elaboração de tese em andamento e vículo regular ao programa de Pós-graduação no qual obteve os créditos (não cumulativo com os itens 1 e 2)', '0.5', '1');
INSERT IGNORE INTO `item_classe` (`id_item_classe`, `discriminacao`, `pontuacao`, `id_classe`) VALUES (NULL, 'Pós-doutorado na área objeto do concurso, tempo mínimo de 1 ano', '1', '1');
INSERT IGNORE INTO `item_classe` (`id_item_classe`, `discriminacao`, `pontuacao`, `id_classe`) VALUES (NULL, 'Pós-doutorado em área afim da área objeto do Concurso, tempo mínimo de 1 ano', '0.5', '1');

-- Classe 2
INSERT IGNORE INTO `item_classe` (`id_item_classe`, `discriminacao`, `pontuacao`, `id_classe`) VALUES (NULL, 'Autoria individual de livro internacional na área do concurso, cadastrado no ISBN ou similar (por unidade)', '8', '2');
INSERT IGNORE INTO `item_classe` (`id_item_classe`, `discriminacao`, `pontuacao`, `id_classe`) VALUES (NULL, 'Autoria individual de livro nacional na área do concurso, cadastrado no ISBN ou similar (por unidade)', '4', '2');
INSERT IGNORE INTO `item_classe` (`id_item_classe`, `discriminacao`, `pontuacao`, `id_classe`) VALUES (NULL, 'Co-autoria de livro na área do concurso, cadastrado no ISBN ou similar (por unidade, dentre os três primeiros autores)', '2', '2');
INSERT IGNORE INTO `item_classe` (`id_item_classe`, `discriminacao`, `pontuacao`, `id_classe`) VALUES (NULL, 'Autoria de capítulo de livro na área do concurso, cadastrado no ISBN ou similar (por unidade)', '1', '2');
INSERT IGNORE INTO `item_classe` (`id_item_classe`, `discriminacao`, `pontuacao`, `id_classe`) VALUES (NULL, 'Artigo publicado em periódicos científicos especializados, classificado no sistema Qualis da CAPES como A1 ou A2, na área do concurso (por artigo) * ', '4', '2');
INSERT IGNORE INTO `item_classe` (`id_item_classe`, `discriminacao`, `pontuacao`, `id_classe`) VALUES (NULL, 'Artigo publicado em periódicos científicos especializados, classificado no sistema Qualis da CAPES como B1 ou B2, na área do concurso (por artigo) * ', '2', '2');
INSERT IGNORE INTO `item_classe` (`id_item_classe`, `discriminacao`, `pontuacao`, `id_classe`) VALUES (NULL, 'Artigo publicado em periódicos científicos especializados, classificado no sistema Qualis da CAPES como B3 ou B4, na área do concurso (por artigo) *', '1', '2');
INSERT IGNORE INTO `item_classe` (`id_item_classe`, `discriminacao`, `pontuacao`, `id_classe`) VALUES (NULL, 'Artigo publicado em periódicos científicos especializados, classificado no sistema Qualis da CAPES como B5, na área do concurso (por artigo) *', '0.3', '2');
INSERT IGNORE INTO `item_classe` (`id_item_classe`, `discriminacao`, `pontuacao`, `id_classe`) VALUES (NULL, 'Artigo publicado em periódico não classificado no sistema Qualis da CAPES, na área do concurso (por artigo) *', '0.1', '2');
INSERT IGNORE INTO `item_classe` (`id_item_classe`, `discriminacao`, `pontuacao`, `id_classe`) VALUES (NULL, 'Trabalho completo publicado em Anais de Congressos Científicos, classificado no sistema Qualis da CAPES como A1 ou A2, na área do concurso (por trabalho) *', '0.8', '2');
INSERT IGNORE INTO `item_classe` (`id_item_classe`, `discriminacao`, `pontuacao`, `id_classe`) VALUES (NULL, 'Trabalho completo publicado em Anais de Congressos Científicos, classificado no sistema Qualis da CAPES como B1, B2 ou B3, na área do concurso (por trabalho). *', '0.4', '2');
INSERT IGNORE INTO `item_classe` (`id_item_classe`, `discriminacao`, `pontuacao`, `id_classe`) VALUES (NULL, 'Trabalho completo publicado em Anais de Congressos Científicos, classificado no sistema Qualis da CAPES como B4 ou B5, na área do concurso (por trabalho). *', '0.2', '2');
INSERT IGNORE INTO `item_classe` (`id_item_classe`, `discriminacao`, `pontuacao`, `id_classe`) VALUES (NULL, 'Trabalho completo publicado em Anais de Congressos Científicos, não classificados no sistema Qualis da CAPES, na área do concurso (por trabalho) *', '0.05', '2');
INSERT IGNORE INTO `item_classe` (`id_item_classe`, `discriminacao`, `pontuacao`, `id_classe`) VALUES (NULL, 'Patente ou licença de produtos tecnológicos e registro de software (documentos emitidos por autoridades), na área do concurso (por patente ou licença)', '8', '2');
INSERT IGNORE INTO `item_classe` (`id_item_classe`, `discriminacao`, `pontuacao`, `id_classe`) VALUES (NULL, 'Prêmios e Títulos honoríficos de reconhecimento internacional, recebidos na área do concurso (por prêmio ou título)', '1.6', '2');
INSERT IGNORE INTO `item_classe` (`id_item_classe`, `discriminacao`, `pontuacao`, `id_classe`) VALUES (NULL, 'Prêmios e Títulos honoríficos, de reconhecimento nacional, recebidos na área do concurso (por prêmio ou título)', '0.8', '2');
INSERT IGNORE INTO `item_classe` (`id_item_classe`, `discriminacao`, `pontuacao`, `id_classe`) VALUES (NULL, 'Prêmios e títulos honoríficos de reconhecimento regional ou estadual, recebidos na área do Concurso (por prêmio ou título)', '0.4', '2');
INSERT IGNORE INTO `item_classe` (`id_item_classe`, `discriminacao`, `pontuacao`, `id_classe`) VALUES (NULL, 'Promoção ou Produção artística em evento local', '0.2', '2');
INSERT IGNORE INTO `item_classe` (`id_item_classe`, `discriminacao`, `pontuacao`, `id_classe`) VALUES (NULL, 'Promoção ou Produção artística em evento nacional', '0.4', '2');
INSERT IGNORE INTO `item_classe` (`id_item_classe`, `discriminacao`, `pontuacao`, `id_classe`) VALUES (NULL, 'Promoção ou Produção artística em evento internacional', '0.8', '2');
INSERT IGNORE INTO `item_classe` (`id_item_classe`, `discriminacao`, `pontuacao`, `id_classe`) VALUES (NULL, 'Filmes, vídeos, discos ou audiovisuais de apoio pedagógico, artístico, informativo ou de divulgação científica', '1', '2');

-- Classe 3
INSERT IGNORE INTO `item_classe` (`id_item_classe`, `discriminacao`, `pontuacao`, `id_classe`) VALUES (NULL, 'Disciplina ministrada no Magistério Superior (a cada 60h ministradas, no máximo 8,0 pontos)', '1', '3');
INSERT IGNORE INTO `item_classe` (`id_item_classe`, `discriminacao`, `pontuacao`, `id_classe`) VALUES (NULL, 'Magistério no Ensino Mèdio ou Fundamental (por ano lecionado) ', '0.5', '3');
INSERT IGNORE INTO `item_classe` (`id_item_classe`, `discriminacao`, `pontuacao`, `id_classe`) VALUES (NULL, 'Atividade profissional na área objeto do concurso (por ano de trabalho)', '0.5', '3');
INSERT IGNORE INTO `item_classe` (`id_item_classe`, `discriminacao`, `pontuacao`, `id_classe`) VALUES (NULL, 'Orientação de tese de Doutorado * (unidade)', '2', '3');
INSERT IGNORE INTO `item_classe` (`id_item_classe`, `discriminacao`, `pontuacao`, `id_classe`) VALUES (NULL, 'Orientação dissertação de Mestrado * (unidade)', '1', '3');
INSERT IGNORE INTO `item_classe` (`id_item_classe`, `discriminacao`, `pontuacao`, `id_classe`) VALUES (NULL, 'Orientação monografia de Especialização * (unidade, no máximo 10)', '0.3', '3');
INSERT IGNORE INTO `item_classe` (`id_item_classe`, `discriminacao`, `pontuacao`, `id_classe`) VALUES (NULL, 'Orientação de Projeto de Iniciação Científica ou de Extensão (vinculados a órgãos de fomento) e de Trabalho de Conclusão de Curso de Graduação (TCC) reconhecidos * (unidade, no máximo 20)', '0.1', '3');
INSERT IGNORE INTO `item_classe` (`id_item_classe`, `discriminacao`, `pontuacao`, `id_classe`) VALUES (NULL, 'Membro de Banca de Concurso para Docentes Efetivos', '0.2', '3');
INSERT IGNORE INTO `item_classe` (`id_item_classe`, `discriminacao`, `pontuacao`, `id_classe`) VALUES (NULL, 'Membro de Banca de Concurso para Professor Substituto', '0.1', '3');
INSERT IGNORE INTO `item_classe` (`id_item_classe`, `discriminacao`, `pontuacao`, `id_classe`) VALUES (NULL, 'Membro de banca de tese de Doutorado', '0.2', '3');
INSERT IGNORE INTO `item_classe` (`id_item_classe`, `discriminacao`, `pontuacao`, `id_classe`) VALUES (NULL, 'Membro de banca de dissertação de Mestrado', '0.1', '3');
INSERT IGNORE INTO `item_classe` (`id_item_classe`, `discriminacao`, `pontuacao`, `id_classe`) VALUES (NULL, 'Membro de banca de defesa de monografia de conclusão de curso de Graduação e/ou Especialização', '0.05', '3');
INSERT IGNORE INTO `item_classe` (`id_item_classe`, `discriminacao`, `pontuacao`, `id_classe`) VALUES (NULL, 'Curso de Extensão ministrado com 40h ou mais', '0.4', '3');
INSERT IGNORE INTO `item_classe` (`id_item_classe`, `discriminacao`, `pontuacao`, `id_classe`) VALUES (NULL, 'Curso de Extensão ministrado 20h e 40h', '0.2', '3');
INSERT IGNORE INTO `item_classe` (`id_item_classe`, `discriminacao`, `pontuacao`, `id_classe`) VALUES (NULL, 'Palestrante, conferencista ou participante de mesa redonda, em evento científico, cultural ou artístico em nível Nacional ou Internacional', '0.2', '3');
INSERT IGNORE INTO `item_classe` (`id_item_classe`, `discriminacao`, `pontuacao`, `id_classe`) VALUES (NULL, 'Palestrante, conferencista ou participante em mesa redonda em evento científico, cultural ou artístico em nível Local ou Estadual', '0.1', '3');
INSERT IGNORE INTO `item_classe` (`id_item_classe`, `discriminacao`, `pontuacao`, `id_classe`) VALUES (NULL, 'Coordenador de Projeto de Pesquisa (duração mínima de 6 meses)', '0.1', '3');
INSERT IGNORE INTO `item_classe` (`id_item_classe`, `discriminacao`, `pontuacao`, `id_classe`) VALUES (NULL, 'Coordenador de Projeto de Extensão (duração mínima de 6 meses)', '0.1', '3');
INSERT IGNORE INTO `item_classe` (`id_item_classe`, `discriminacao`, `pontuacao`, `id_classe`) VALUES (NULL, 'Coordenador de curso de graduação (a cada ano)', '0.4', '3');
INSERT IGNORE INTO `item_classe` (`id_item_classe`, `discriminacao`, `pontuacao`, `id_classe`) VALUES (NULL, 'Coordenador de curso de especialização (a cada ano)', '0.2', '3');
INSERT IGNORE INTO `item_classe` (`id_item_classe`, `discriminacao`, `pontuacao`, `id_classe`) VALUES (NULL, 'Diretor de Unidade Universitária (a cada ano)', '0.6', '3');
INSERT IGNORE INTO `item_classe` (`id_item_classe`, `discriminacao`, `pontuacao`, `id_classe`) VALUES (NULL, 'Vice-reitor ou Pró-Reitor (a cada ano)', '0.8', '3');
INSERT IGNORE INTO `item_classe` (`id_item_classe`, `discriminacao`, `pontuacao`, `id_classe`) VALUES (NULL, 'Reitor (a cada ano)', '1', '3');


-- --------------------------
-- INSERTS TABELA CLASSE_CONCURSO
-- --------------------------
INSERT INTO `classe_concurso` (`id_classe`, `nome`) VALUES ( NULL, 'Professor Adjunto');
INSERT INTO `classe_concurso` (`id_classe`, `nome`) VALUES ( NULL, 'Professor Assistente');
INSERT INTO `classe_concurso` (`id_classe`, `nome`) VALUES ( NULL, 'Professor Auxiliar');
INSERT INTO `classe_concurso` (`id_classe`, `nome`) VALUES ( NULL, 'Professor Substituto');
INSERT INTO `classe_concurso` (`id_classe`, `nome`) VALUES ( NULL, 'Professor Temporário');


-- --------------------------
-- INSERTS TABELA CAMPUS
-- --------------------------
INSERT INTO `campus` (`id_campus`, `cidade_campus`) VALUES (NULL, 'Alegrete');
INSERT INTO `campus` (`id_campus`, `cidade_campus`) VALUES (NULL, 'Bagé');
INSERT INTO `campus` (`id_campus`, `cidade_campus`) VALUES (NULL, 'Caçapava do Sul');
INSERT INTO `campus` (`id_campus`, `cidade_campus`) VALUES (NULL, 'Dom Pedrito');
INSERT INTO `campus` (`id_campus`, `cidade_campus`) VALUES (NULL, 'Itaqui');
INSERT INTO `campus` (`id_campus`, `cidade_campus`) VALUES (NULL, 'Jaguarão');
INSERT INTO `campus` (`id_campus`, `cidade_campus`) VALUES (NULL, 'Santana do Livramento');
INSERT INTO `campus` (`id_campus`, `cidade_campus`) VALUES (NULL, 'São Borja');
INSERT INTO `campus` (`id_campus`, `cidade_campus`) VALUES (NULL, 'São Gabriel');
INSERT INTO `campus` (`id_campus`, `cidade_campus`) VALUES (NULL, 'Uruguaiana');

-- ---------------------------
-- INSERTS TABELA CONCURSO
-- ---------------------------
INSERT INTO `concurso` (`id_concurso`, `ministerio`, `instituicao`, `id_campus`, `area`, `edital`, `id_classe_concurso`, `data_inicio`, `tem_prova_escrita`, `tem_prova_titulo`, `tem_prova_didatica`, `tem_prova_memorial`) VALUES ( NULL, 'Ministério da Educação', 'Universidade Federal do Pampa', '1', 'Engenharia de Software', '666/2013', '1', '2013-03-15 00:00:00', '1', '1', '1', '1');

-- ---------------------------
-- INSERTS TABELA PESSOA
-- --------------------------
INSERT INTO `pessoa` (`id_pessoa`, `nome`, `sexo`, `data_nascimento`) VALUES (NULL, 'João da Silva', 'M', '2013-03-15 00:00:00');
INSERT INTO `pessoa` (`id_pessoa`, `nome`, `sexo`, `data_nascimento`) VALUES (NULL, 'Gilberto', 'M', '2013-06-11 00:00:00');
INSERT INTO `pessoa` (`id_pessoa`, `nome`, `sexo`, `data_nascimento`) VALUES (NULL, 'Maria Luiza', 'F', '2013-01-05 00:00:00');
INSERT INTO `pessoa` (`id_pessoa`, `nome`, `sexo`, `data_nascimento`) VALUES (NULL, 'Theodoro Luiz', 'M', '2013-12-15 00:00:00');
INSERT INTO `pessoa` (`id_pessoa`, `nome`, `sexo`, `data_nascimento`) VALUES (NULL, 'Debora', 'F', '2011-03-15 00:00:00');
INSERT INTO `pessoa` (`id_pessoa`, `nome`, `sexo`, `data_nascimento`) VALUES (NULL, 'Thais', 'F', '2010-01-15 00:00:00');
INSERT INTO `pessoa` (`id_pessoa`, `nome`, `sexo`, `data_nascimento`) VALUES (NULL, 'José Alberto', 'M', '2013-02-15 00:00:00');
INSERT INTO `pessoa` (`id_pessoa`, `nome`, `sexo`, `data_nascimento`) VALUES (NULL, 'Dafine Beiço', 'F', '2013-11-10 00:00:00');

-- ---------------------------
-- INSERTS TABELA TITULACAO
-- --------------------------
INSERT INTO `titulacao` (`id_titulacao`, `titulacao`) VALUES (NULL, 'Professor Titular');
INSERT INTO `titulacao` (`id_titulacao`, `titulacao`) VALUES (NULL, 'Professor Associado');
INSERT INTO `titulacao` (`id_titulacao`, `titulacao`) VALUES (NULL, 'Professor Adjunto');
INSERT INTO `titulacao` (`id_titulacao`, `titulacao`) VALUES (NULL, 'Professor Assistente');

-- ---------------------------
-- INSERTS TABELA EXAMINADOR
-- --------------------------
INSERT INTO `examinador` (`id_examinador`, `id_titulacao`, `id_pessoa`) VALUES ( NULL, '1', '5');
INSERT INTO `examinador` (`id_examinador`, `id_titulacao`, `id_pessoa`) VALUES ( NULL, '2', '2');
INSERT INTO `examinador` (`id_examinador`, `id_titulacao`, `id_pessoa`) VALUES ( NULL, '3', '4');


-- ---------------------------
-- INSERTS TABELA CANDIDATO
-- --------------------------
INSERT INTO `candidato` (`id_candidato`, `id_pessoa`, `id_concurso`, `apto_prova_escrita`, `apto_prova_didatica`,  `id_prova_escrita`) VALUES (NULL, '1', '1', '1', '1',  NULL);
INSERT INTO `candidato` (`id_candidato`, `id_pessoa`, `id_concurso`, `apto_prova_escrita`, `apto_prova_didatica`, `id_prova_escrita`) VALUES (NULL, '2', '1', '1', '1',  NULL);
INSERT INTO `candidato` (`id_candidato`, `id_pessoa`, `id_concurso`, `apto_prova_escrita`, `apto_prova_didatica`,  `id_prova_escrita`) VALUES (NULL, '3', '1', '1', '1',  NULL);

-- -----------------------------
-- INSERTS TABELA PROVA_TITULO
-- -----------------------------
INSERT INTO `prova_titulo` (`id_prova_titulo`, `local`, `id_concurso`, `classe_1`, `classe_2`, `classe_3`) VALUES (NULL, 'sala 212', '1', '1', '2', '3');

-- --------------------------------------
-- INSERTS TABELA AVALIACAO_PROVA_TITULO
-- --------------------------------------
INSERT INTO `avaliacao_prova_titulo` (`id_avaliacao_prova_titulo`, `id_candidato`, `id_prova_titulo`) VALUES (NULL, '3', '1');

-- --------------------------------------
-- INSERTS TABELA AVALIACAO_ITEM
-- --------------------------------------
INSERT INTO `avaliacao_item` (`id_item_classe`, `id_avaliacao_prova_titulo`, `quantidade`) VALUES ('1', '1', '5');
INSERT INTO `avaliacao_item` (`id_item_classe`, `id_avaliacao_prova_titulo`, `quantidade`) VALUES ('2', '1', '3');
INSERT INTO `avaliacao_item` (`id_item_classe`, `id_avaliacao_prova_titulo`, `quantidade`) VALUES ('3', '1', '2');
INSERT INTO `avaliacao_item` (`id_item_classe`, `id_avaliacao_prova_titulo`, `quantidade`) VALUES ('4', '1', '2');
INSERT INTO `avaliacao_item` (`id_item_classe`, `id_avaliacao_prova_titulo`, `quantidade`) VALUES ('5', '1', '2');
INSERT INTO `avaliacao_item` (`id_item_classe`, `id_avaliacao_prova_titulo`, `quantidade`) VALUES ('6', '1', '6');
INSERT INTO `avaliacao_item` (`id_item_classe`, `id_avaliacao_prova_titulo`, `quantidade`) VALUES ('1', '1', '4');
INSERT INTO `avaliacao_item` (`id_item_classe`, `id_avaliacao_prova_titulo`, `quantidade`) VALUES ('1', '1', '3');
INSERT INTO `avaliacao_item` (`id_item_classe`, `id_avaliacao_prova_titulo`, `quantidade`) VALUES ('1', '1', '5');
INSERT INTO `avaliacao_item` (`id_item_classe`, `id_avaliacao_prova_titulo`, `quantidade`) VALUES ('1', '1', '3');
INSERT INTO `avaliacao_item` (`id_item_classe`, `id_avaliacao_prova_titulo`, `quantidade`) VALUES ('1', '1', '2');
INSERT INTO `avaliacao_item` (`id_item_classe`, `id_avaliacao_prova_titulo`, `quantidade`) VALUES ('1', '1', '2');

-- --------------------------------------
-- INSERTS TABELA PROVA_MEMORIAL
-- --------------------------------------
INSERT INTO `prova_memorial` (`id_prova_memorial`, `local`, `id_concurso`) VALUES (NULL, 'sala 212', '1');

-- --------------------------------------
-- INSERTS TABELA CRITERIO_AVALIACAO
-- --------------------------------------
INSERT INTO `criterio_avaliacao` (`id_criterio_avaliacao`, `criterio`, `peso`, `id_prova_memorial`) VALUES (NULL, 'Clareza', '2', '1');
INSERT INTO `criterio_avaliacao` (`id_criterio_avaliacao`, `criterio`, `peso`, `id_prova_memorial`) VALUES (NULL, 'Compreensão', '2', '1');
INSERT INTO `criterio_avaliacao` (`id_criterio_avaliacao`, `criterio`, `peso`, `id_prova_memorial`) VALUES (NULL, 'Oratória', '2', '1');
INSERT INTO `criterio_avaliacao` (`id_criterio_avaliacao`, `criterio`, `peso`, `id_prova_memorial`) VALUES (NULL, 'Dicção', '2', '1');
INSERT INTO `criterio_avaliacao` (`id_criterio_avaliacao`, `criterio`, `peso`, `id_prova_memorial`) VALUES (NULL, 'Desenvoltura', '2', '1');

-- --------------------------------------
-- INSERTS TABELA AVALIACAO_PROVA_MEMORIAL
-- --------------------------------------
-- INSERT INTO `avaliacao_prova_memorial` (`id_avaliacao_prova_memorial`, `candidato_id_candidato`, `id_prova_memorial`) VALUES (NULL, '1', '1');


-- ---------------------------------------------
-- INSERTS TABELA AVALIACAO_EXAMINADOR_CRITERIO
-- ---------------------------------------------
-- INSERT INTO `avaliacao_examinador_criterio` (`id_avaliacao_examinador_criterio`, `ponto`, `id_criterio_avaliacao_prova_memorial`, `id_avaliacao_prova_memorial`, `id_examinador`) VALUES (NULL, '2', '1', '1', '1');
-- INSERT INTO `avaliacao_examinador_criterio` (`id_avaliacao_examinador_criterio`, `ponto`, `id_criterio_avaliacao_prova_memorial`, `id_avaliacao_prova_memorial`, `id_examinador`) VALUES (NULL, '2', '1', '1', '1');
-- INSERT INTO `avaliacao_examinador_criterio` (`id_avaliacao_examinador_criterio`, `ponto`, `id_criterio_avaliacao_prova_memorial`, `id_avaliacao_prova_memorial`, `id_examinador`) VALUES (NULL, '2', '1', '1', '1');



-- SET FOREIGN_KEY_CHECKS = 1; --