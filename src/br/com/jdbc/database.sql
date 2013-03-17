SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';


-- -----------------------------------------------------
-- Table `pessoa`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `pessoa` (
  `id_pessoa` INT NOT NULL AUTO_INCREMENT ,
  `nome` VARCHAR(255) NOT NULL ,
  `sexo` VARCHAR(1) NOT NULL ,
  `data_nascimento` DATETIME NOT NULL ,
  PRIMARY KEY (`id_pessoa`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `classe_concurso`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `classe_concurso` (
  `id_classe` INT NOT NULL AUTO_INCREMENT ,
  `nome` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`id_classe`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `campus`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `campus` (
  `id_campus` INT NOT NULL AUTO_INCREMENT ,
  `cidade_campus` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`id_campus`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `concurso`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `concurso` (
  `id_concurso` INT NOT NULL AUTO_INCREMENT ,
  `ministerio` VARCHAR(45) NULL ,
  `instituicao` VARCHAR(45) NULL ,
  `id_campus` INT NULL ,
  `area` VARCHAR(45) NULL ,
  `edital` VARCHAR(45) NULL ,
  `id_classe_concurso` INT NULL ,
  `data_inicio` DATETIME NULL ,
  `tem_prova_escrita` TINYINT(1) NULL ,
  `tem_prova_titulo` TINYINT(1) NULL ,
  `tem_prova_didatica` TINYINT(1) NULL ,
  `tem_prova_memorial` TINYINT(1) NULL ,
  PRIMARY KEY (`id_concurso`) ,
  INDEX `fk_concurso_classe1_idx` (`id_classe_concurso` ASC) ,
  INDEX `fk_concurso_campus1_idx` (`id_campus` ASC) ,
  CONSTRAINT `fk_concurso_classe1`
    FOREIGN KEY (`id_classe_concurso` )
    REFERENCES `classe_concurso` (`id_classe` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_concurso_campus1`
    FOREIGN KEY (`id_campus` )
    REFERENCES `campus` (`id_campus` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `prova_didatica`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `prova_didatica` (
  `id_prova_didatica` INT NOT NULL ,
  `nota` VARCHAR(45) NULL ,
  `id_concurso` INT NOT NULL ,
  PRIMARY KEY (`id_prova_didatica`) ,
  INDEX `fk_prova_didatica_concurso1_idx` (`id_concurso` ASC) ,
  CONSTRAINT `fk_prova_didatica_concurso1`
    FOREIGN KEY (`id_concurso` )
    REFERENCES `concurso` (`id_concurso` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `candidato`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `candidato` (
  `id_candidato` INT NOT NULL AUTO_INCREMENT ,
  `id_pessoa` INT NOT NULL ,
  `id_concurso` INT NULL ,
  `apto_prova_escrita` TINYINT(1) NULL ,
  `apto_prova_didatica` TINYINT(1) NULL ,
  `id_prova_didatica` INT NULL ,
  `id_prova_escrita` INT NULL ,
  PRIMARY KEY (`id_candidato`) ,
  INDEX `fk_candidato_concurso_idx` (`id_concurso` ASC) ,
  INDEX `fk_candidato_prova_didatica1_idx` (`id_prova_didatica` ASC) ,
  INDEX `fk_candidato_usuario1_idx` (`id_pessoa` ASC) ,
  CONSTRAINT `fk_candidato_concurso`
    FOREIGN KEY (`id_concurso` )
    REFERENCES `concurso` (`id_concurso` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_candidato_prova_didatica1`
    FOREIGN KEY (`id_prova_didatica` )
    REFERENCES `prova_didatica` (`id_prova_didatica` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_candidato_usuario1`
    FOREIGN KEY (`id_pessoa` )
    REFERENCES `pessoa` (`id_pessoa` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = '			';


-- -----------------------------------------------------
-- Table `prova_memorial`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `prova_memorial` (
  `id_prova_memorial` INT NOT NULL AUTO_INCREMENT ,
  `local` VARCHAR(45) NULL ,
  `id_concurso` INT NOT NULL ,
  PRIMARY KEY (`id_prova_memorial`) ,
  INDEX `fk_prova_memorial_concurso1_idx` (`id_concurso` ASC) ,
  CONSTRAINT `fk_prova_memorial_concurso1`
    FOREIGN KEY (`id_concurso` )
    REFERENCES `concurso` (`id_concurso` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `abertura`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `abertura` (
  `id_abertura` INT NOT NULL AUTO_INCREMENT ,
  `hora_inicio` DATETIME NULL ,
  `local` VARCHAR(45) NULL ,
  `portaria` VARCHAR(45) NULL ,
  `emissor` VARCHAR(45) NULL ,
  `id_concurso` INT NOT NULL ,
  PRIMARY KEY (`id_abertura`) ,
  INDEX `fk_abertura_concurso1_idx` (`id_concurso` ASC) ,
  CONSTRAINT `fk_abertura_concurso1`
    FOREIGN KEY (`id_concurso` )
    REFERENCES `concurso` (`id_concurso` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cronograma`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `cronograma` (
  `id_cronograma` INT NOT NULL AUTO_INCREMENT ,
  `atividade` TEXT NULL ,
  `data` DATETIME NULL ,
  `local` VARCHAR(45) NULL ,
  `id_concurso` INT NOT NULL ,
  PRIMARY KEY (`id_cronograma`) ,
  INDEX `fk_cronograma_concurso1_idx` (`id_concurso` ASC) ,
  CONSTRAINT `fk_cronograma_concurso1`
    FOREIGN KEY (`id_concurso` )
    REFERENCES `concurso` (`id_concurso` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tipo_cargo`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `tipo_cargo` (
  `id_tipo_cargo` INT NOT NULL ,
  PRIMARY KEY (`id_tipo_cargo`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cargos`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `cargos` (
  `id_cargos` INT NOT NULL ,
  `id_tipo_cargo` INT NOT NULL ,
  PRIMARY KEY (`id_cargos`) ,
  INDEX `fk_cargos_tipo_cargo1_idx` (`id_tipo_cargo` ASC) ,
  CONSTRAINT `fk_cargos_tipo_cargo1`
    FOREIGN KEY (`id_tipo_cargo` )
    REFERENCES `tipo_cargo` (`id_tipo_cargo` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `banca_examinadora`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `banca_examinadora` (
  `id_banca_examinadora` INT NOT NULL AUTO_INCREMENT ,
  `examinador_1` INT NOT NULL ,
  `examinador_2` INT NOT NULL ,
  `examinador_3` INT NOT NULL ,
  `id_concurso` INT NOT NULL ,
  PRIMARY KEY (`id_banca_examinadora`) ,
  INDEX `fk_banca_examinadora_examinador1_idx` (`examinador_1` ASC) ,
  INDEX `fk_banca_examinadora_examinador2_idx` (`examinador_2` ASC) ,
  INDEX `fk_banca_examinadora_examinador3_idx` (`examinador_3` ASC) ,
  INDEX `fk_banca_examinadora_concurso1_idx` (`id_concurso` ASC) ,
  CONSTRAINT `fk_banca_examinadora_examinador1`
    FOREIGN KEY (`examinador_1` )
    REFERENCES `examinador` (`id_examinador` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_banca_examinadora_examinador2`
    FOREIGN KEY (`examinador_2` )
    REFERENCES `examinador` (`id_examinador` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_banca_examinadora_examinador3`
    FOREIGN KEY (`examinador_3` )
    REFERENCES `examinador` (`id_examinador` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_banca_examinadora_concurso1`
    FOREIGN KEY (`id_concurso` )
    REFERENCES `concurso` (`id_concurso` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `titulacao`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `titulacao` (
  `id_titulacao` INT NOT NULL AUTO_INCREMENT ,
  `titulacao` VARCHAR(255) NOT NULL ,
  PRIMARY KEY (`id_titulacao`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `examinador`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `examinador` (
  `id_examinador` INT NOT NULL AUTO_INCREMENT ,
  `id_titulacao` INT NOT NULL ,
  `id_pessoa` INT NOT NULL ,
  PRIMARY KEY (`id_examinador`) ,
  INDEX `fk_examinador_titulacao1_idx` (`id_titulacao` ASC) ,
  INDEX `fk_examinador_usuario1_idx` (`id_pessoa` ASC) ,
  CONSTRAINT `fk_examinador_titulacao1`
    FOREIGN KEY (`id_titulacao` )
    REFERENCES `titulacao` (`id_titulacao` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_examinador_usuario1`
    FOREIGN KEY (`id_pessoa` )
    REFERENCES `pessoa` (`id_pessoa` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `banca_exami_examindores`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `banca_exami_examindores` (
  `id_banca_exami_examindores` INT NOT NULL ,
  `id_banca_examinadora` INT NOT NULL ,
  `id_examinador` INT NOT NULL ,
  PRIMARY KEY (`id_banca_exami_examindores`, `id_banca_examinadora`, `id_examinador`) ,
  INDEX `fk_banca_exami_examindores_banca_examinadora1_idx` (`id_banca_examinadora` ASC) ,
  INDEX `fk_banca_exami_examindores_examinador1_idx` (`id_examinador` ASC) ,
  CONSTRAINT `fk_banca_exami_examindores_banca_examinadora1`
    FOREIGN KEY (`id_banca_examinadora` )
    REFERENCES `banca_examinadora` (`id_banca_examinadora` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_banca_exami_examindores_examinador1`
    FOREIGN KEY (`id_examinador` )
    REFERENCES `examinador` (`id_examinador` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `notas_prova_didatica`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `notas_prova_didatica` (
  `id_notas_prova_didatica` INT NOT NULL ,
  `descricao` VARCHAR(45) NULL ,
  `id_concurso` INT NOT NULL ,
  PRIMARY KEY (`id_notas_prova_didatica`) ,
  INDEX `fk_notas_prova_didatica_concurso1_idx` (`id_concurso` ASC) ,
  CONSTRAINT `fk_notas_prova_didatica_concurso1`
    FOREIGN KEY (`id_concurso` )
    REFERENCES `concurso` (`id_concurso` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sorteio_ponto_prov_didatica`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `sorteio_ponto_prov_didatica` (
  `id_sorteio_ponto_prov_didatica` INT NOT NULL ,
  `data_sorteio` DATETIME NULL ,
  `data_realizacao` DATETIME NULL ,
  `compareceu_sorteio` TINYINT(1) NULL ,
  `compareceu_realizacao_prova` TINYINT(1) NULL ,
  `id_pessoa` INT NOT NULL ,
  `id_notas_prova_didatica` INT NOT NULL ,
  PRIMARY KEY (`id_sorteio_ponto_prov_didatica`) ,
  INDEX `fk_sorteio_ponto_prov_didatica_usuario1_idx` (`id_pessoa` ASC) ,
  INDEX `fk_sorteio_ponto_prov_didatica_notas_prova_didatica1_idx` (`id_notas_prova_didatica` ASC) ,
  CONSTRAINT `fk_sorteio_ponto_prov_didatica_usuario1`
    FOREIGN KEY (`id_pessoa` )
    REFERENCES `pessoa` (`id_pessoa` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_sorteio_ponto_prov_didatica_notas_prova_didatica1`
    FOREIGN KEY (`id_notas_prova_didatica` )
    REFERENCES `notas_prova_didatica` (`id_notas_prova_didatica` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `classe`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `classe` (
  `id_classe` INT NOT NULL AUTO_INCREMENT ,
  `nome_classe` VARCHAR(255) NULL ,
  `peso_classe` FLOAT NULL ,
  `nota_referencia_classe` FLOAT NULL ,
  PRIMARY KEY (`id_classe`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `prova_titulo`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `prova_titulo` (
  `id_prova_titulo` INT NOT NULL AUTO_INCREMENT ,
  `local` VARCHAR(45) NULL ,
  `id_concurso` INT NOT NULL ,
  `classe_1` INT NOT NULL ,
  `classe_2` INT NOT NULL ,
  `classe_3` INT NOT NULL ,
  PRIMARY KEY (`id_prova_titulo`) ,
  INDEX `fk_prova_titulo_concurso1_idx` (`id_concurso` ASC) ,
  INDEX `fk_prova_titulo_classe1_idx` (`classe_1` ASC) ,
  INDEX `fk_prova_titulo_classe2_idx` (`classe_2` ASC) ,
  INDEX `fk_prova_titulo_classe3_idx` (`classe_3` ASC) ,
  CONSTRAINT `fk_prova_titulo_concurso1`
    FOREIGN KEY (`id_concurso` )
    REFERENCES `concurso` (`id_concurso` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_prova_titulo_classe1`
    FOREIGN KEY (`classe_1` )
    REFERENCES `classe` (`id_classe` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_prova_titulo_classe2`
    FOREIGN KEY (`classe_2` )
    REFERENCES `classe` (`id_classe` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_prova_titulo_classe3`
    FOREIGN KEY (`classe_3` )
    REFERENCES `classe` (`id_classe` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `avaliacao_prova_titulo`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `avaliacao_prova_titulo` (
  `id_avaliacao_prova_titulo` INT NOT NULL AUTO_INCREMENT ,
  `id_candidato` INT NOT NULL ,
  `id_prova_titulo` INT NOT NULL ,
  PRIMARY KEY (`id_avaliacao_prova_titulo`) ,
  INDEX `fk_avaliacao_prova_titulo_candidato1_idx` (`id_candidato` ASC) ,
  INDEX `fk_avaliacao_prova_titulo_prova_titulo1_idx` (`id_prova_titulo` ASC) ,
  CONSTRAINT `fk_avaliacao_prova_titulo_candidato1`
    FOREIGN KEY (`id_candidato` )
    REFERENCES `candidato` (`id_candidato` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_avaliacao_prova_titulo_prova_titulo1`
    FOREIGN KEY (`id_prova_titulo` )
    REFERENCES `prova_titulo` (`id_prova_titulo` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `item_classe`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `item_classe` (
  `id_item_classe` INT NOT NULL AUTO_INCREMENT ,
  `discriminacao` LONGTEXT NULL ,
  `pontuacao` FLOAT NULL ,
  `id_classe` INT NOT NULL ,
  PRIMARY KEY (`id_item_classe`) ,
  INDEX `fk_item_classe_classe1_idx` (`id_classe` ASC) ,
  CONSTRAINT `fk_item_classe_classe1`
    FOREIGN KEY (`id_classe` )
    REFERENCES `classe` (`id_classe` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `item_classe_has_classe`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `item_classe_has_classe` (
  `classe_id_classe` INT NOT NULL ,
  `item_classe_id_item_classe` INT NOT NULL ,
  PRIMARY KEY (`classe_id_classe`, `item_classe_id_item_classe`) ,
  INDEX `fk_item_classe_has_classe_classe1_idx` (`classe_id_classe` ASC) ,
  INDEX `fk_item_classe_has_classe_item_classe1_idx` (`item_classe_id_item_classe` ASC) ,
  CONSTRAINT `fk_item_classe_has_classe_item_classe1`
    FOREIGN KEY (`item_classe_id_item_classe` )
    REFERENCES `item_classe` (`id_item_classe` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_item_classe_has_classe_classe1`
    FOREIGN KEY (`classe_id_classe` )
    REFERENCES `classe` (`id_classe` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `avaliacao_item`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `avaliacao_item` (
  `id_item_classe` INT NOT NULL ,
  `id_avaliacao_prova_titulo` INT NOT NULL ,
  `quantidade` INT NULL ,
  INDEX `fk_item_classe_has_avaliacao_prova_titulo_avaliacao_prova_t_idx` (`id_avaliacao_prova_titulo` ASC) ,
  INDEX `fk_item_classe_has_avaliacao_prova_titulo_item_classe1_idx` (`id_item_classe` ASC) ,
  CONSTRAINT `fk_item_classe_has_avaliacao_prova_titulo_item_classe1`
    FOREIGN KEY (`id_item_classe` )
    REFERENCES `item_classe` (`id_item_classe` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_item_classe_has_avaliacao_prova_titulo_avaliacao_prova_tit1`
    FOREIGN KEY (`id_avaliacao_prova_titulo` )
    REFERENCES `avaliacao_prova_titulo` (`id_avaliacao_prova_titulo` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `avaliacao_prova_memorial`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `avaliacao_prova_memorial` (
  `id_avaliacao_prova_memorial` INT NOT NULL AUTO_INCREMENT ,
  `candidato_id_candidato` INT NOT NULL ,
  `id_prova_memorial` INT NOT NULL ,
  PRIMARY KEY (`id_avaliacao_prova_memorial`) ,
  INDEX `fk_avaliacao_prova_memorial_candidato1_idx` (`candidato_id_candidato` ASC) ,
  INDEX `fk_avaliacao_prova_memorial_prova_memorial1_idx` (`id_prova_memorial` ASC) ,
  CONSTRAINT `fk_avaliacao_prova_memorial_candidato1`
    FOREIGN KEY (`candidato_id_candidato` )
    REFERENCES `candidato` (`id_candidato` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_avaliacao_prova_memorial_prova_memorial1`
    FOREIGN KEY (`id_prova_memorial` )
    REFERENCES `prova_memorial` (`id_prova_memorial` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pontos_prova_escrita`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `pontos_prova_escrita` (
  `id_pontos_prova_escrita` INT NOT NULL AUTO_INCREMENT ,
  `descricao` VARCHAR(255) NULL ,
  `id_prova_escrita` INT NULL ,
  PRIMARY KEY (`id_pontos_prova_escrita`) ,
  INDEX `fk_pontos_prova_escrita_prova_escrita1_idx` (`id_prova_escrita` ASC) ,
  CONSTRAINT `fk_pontos_prova_escrita_prova_escrita1`
    FOREIGN KEY (`id_prova_escrita` )
    REFERENCES `prova_escrita` (`id_prova_escrita` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `prova_escrita`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `prova_escrita` (
  `id_prova_escrita` INT NOT NULL AUTO_INCREMENT ,
  `id_concurso` INT NULL ,
  `id_ponto_sorteado_prova_escrita` INT NULL ,
  `data_ponto_sorteado` DATETIME NULL ,
  `hora_inicio_prova` DATETIME NULL ,
  `hora_fim_prova` DATETIME NULL ,
  `local_realizacao` VARCHAR(255) NULL ,
  `hora_inicio_leitura` DATETIME NULL ,
  `hora_fim_leitura` DATETIME NULL ,
  `local_leitura` VARCHAR(255) NULL ,
  `hora_inicio_julgamento` DATETIME NULL ,
  `local_julgamento` VARCHAR(255) NULL ,
  `hora_inicio_resultado` DATETIME NULL ,
  `local_resultado` VARCHAR(255) NULL ,
  PRIMARY KEY (`id_prova_escrita`) ,
  INDEX `fk_prova_escrita_concurso2_idx` (`id_concurso` ASC) ,
  INDEX `fk_prova_escrita_pontos_prova_escrita1_idx` (`id_ponto_sorteado_prova_escrita` ASC) ,
  CONSTRAINT `fk_prova_escrita_concurso2`
    FOREIGN KEY (`id_concurso` )
    REFERENCES `concurso` (`id_concurso` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_prova_escrita_pontos_prova_escrita1`
    FOREIGN KEY (`id_ponto_sorteado_prova_escrita` )
    REFERENCES `pontos_prova_escrita` (`id_pontos_prova_escrita` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `criterio_avaliacao`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `criterio_avaliacao` (
  `id_criterio_avaliacao` INT NOT NULL AUTO_INCREMENT ,
  `criterio` VARCHAR(45) NULL ,
  `peso` FLOAT NULL ,
  `id_prova_memorial` INT NULL ,
  `id_prova_escrita` INT NULL ,
  PRIMARY KEY (`id_criterio_avaliacao`) ,
  INDEX `fk_criterio_avaliacao_prova_memorial_prova_memorial1_idx` (`id_prova_memorial` ASC) ,
  INDEX `fk_criterio_avaliacao_prova_escrita1_idx` (`id_prova_escrita` ASC) ,
  CONSTRAINT `fk_criterio_avaliacao_prova_memorial_prova_memorial1`
    FOREIGN KEY (`id_prova_memorial` )
    REFERENCES `prova_memorial` (`id_prova_memorial` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_criterio_avaliacao_prova_escrita1`
    FOREIGN KEY (`id_prova_escrita` )
    REFERENCES `prova_escrita` (`id_prova_escrita` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `avaliacao_examinador_criterio`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `avaliacao_examinador_criterio` (
  `id_avaliacao_examinador_criterio` INT NOT NULL AUTO_INCREMENT ,
  `ponto` FLOAT NULL ,
  `id_criterio_avaliacao_prova_memorial` INT NOT NULL ,
  `id_avaliacao_prova_memorial` INT NOT NULL ,
  `id_examinador` INT NOT NULL ,
  PRIMARY KEY (`id_avaliacao_examinador_criterio`) ,
  INDEX `fk_avaliacao_examinador_criterio_criterio_avaliacao_prova_m_idx` (`id_criterio_avaliacao_prova_memorial` ASC) ,
  INDEX `fk_avaliacao_examinador_criterio_avaliacao_prova_memorial1_idx` (`id_avaliacao_prova_memorial` ASC) ,
  INDEX `fk_avaliacao_examinador_criterio_examinador1_idx` (`id_examinador` ASC) ,
  CONSTRAINT `fk_avaliacao_examinador_criterio_criterio_avaliacao_prova_mem1`
    FOREIGN KEY (`id_criterio_avaliacao_prova_memorial` )
    REFERENCES `criterio_avaliacao` (`id_criterio_avaliacao` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_avaliacao_examinador_criterio_avaliacao_prova_memorial1`
    FOREIGN KEY (`id_avaliacao_prova_memorial` )
    REFERENCES `avaliacao_prova_memorial` (`id_avaliacao_prova_memorial` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_avaliacao_examinador_criterio_examinador1`
    FOREIGN KEY (`id_examinador` )
    REFERENCES `examinador` (`id_examinador` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `banca_examinadora`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `banca_examinadora` (
  `id_banca_examinadora` INT NOT NULL AUTO_INCREMENT ,
  `examinador_1` INT NOT NULL ,
  `examinador_2` INT NOT NULL ,
  `examinador_3` INT NOT NULL ,
  `id_concurso` INT NOT NULL ,
  PRIMARY KEY (`id_banca_examinadora`) ,
  INDEX `fk_banca_examinadora_examinador1_idx` (`examinador_1` ASC) ,
  INDEX `fk_banca_examinadora_examinador2_idx` (`examinador_2` ASC) ,
  INDEX `fk_banca_examinadora_examinador3_idx` (`examinador_3` ASC) ,
  INDEX `fk_banca_examinadora_concurso1_idx` (`id_concurso` ASC) ,
  CONSTRAINT `fk_banca_examinadora_examinador1`
    FOREIGN KEY (`examinador_1` )
    REFERENCES `examinador` (`id_examinador` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_banca_examinadora_examinador2`
    FOREIGN KEY (`examinador_2` )
    REFERENCES `examinador` (`id_examinador` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_banca_examinadora_examinador3`
    FOREIGN KEY (`examinador_3` )
    REFERENCES `examinador` (`id_examinador` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_banca_examinadora_concurso1`
    FOREIGN KEY (`id_concurso` )
    REFERENCES `concurso` (`id_concurso` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `candidatos_aptos_prova_escrita`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `candidatos_aptos_prova_escrita` (
  `id_candidato` INT NOT NULL ,
  `id_prova_escrita` INT NOT NULL ,
  PRIMARY KEY (`id_candidato`, `id_prova_escrita`) ,
  INDEX `fk_candidato_has_prova_escrita_prova_escrita1_idx` (`id_prova_escrita` ASC) ,
  INDEX `fk_candidato_has_prova_escrita_candidato1_idx` (`id_candidato` ASC) ,
  CONSTRAINT `fk_candidato_has_prova_escrita_candidato1`
    FOREIGN KEY (`id_candidato` )
    REFERENCES `candidato` (`id_candidato` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_candidato_has_prova_escrita_prova_escrita1`
    FOREIGN KEY (`id_prova_escrita` )
    REFERENCES `prova_escrita` (`id_prova_escrita` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `candidatos_aptos_leitura_prova_escrita`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `candidatos_aptos_leitura_prova_escrita` (
  `id_prova_escrita` INT NOT NULL ,
  `id_candidato` INT NOT NULL ,
  PRIMARY KEY (`id_candidato`, `id_prova_escrita`) ,
  INDEX `fk_prova_escrita_has_candidato_candidato1_idx` (`id_candidato` ASC) ,
  INDEX `fk_prova_escrita_has_candidato_prova_escrita1_idx` (`id_prova_escrita` ASC) ,
  CONSTRAINT `fk_prova_escrita_has_candidato_prova_escrita1`
    FOREIGN KEY (`id_prova_escrita` )
    REFERENCES `prova_escrita` (`id_prova_escrita` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_prova_escrita_has_candidato_candidato1`
    FOREIGN KEY (`id_candidato` )
    REFERENCES `candidato` (`id_candidato` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
