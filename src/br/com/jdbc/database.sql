SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `concursos` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `concursos` ;

-- -----------------------------------------------------
-- Table `concursos`.`pessoa`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `concursos`.`pessoa` ;

CREATE  TABLE IF NOT EXISTS `concursos`.`pessoa` (
  `id_pessoa` INT NOT NULL AUTO_INCREMENT ,
  `nome` VARCHAR(255) NOT NULL ,
  `sexo` VARCHAR(1) NOT NULL ,
  `data_nascimento` DATETIME NOT NULL ,
  PRIMARY KEY (`id_pessoa`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `concursos`.`classe_concurso`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `concursos`.`classe_concurso` ;

CREATE  TABLE IF NOT EXISTS `concursos`.`classe_concurso` (
  `id_classe` INT NOT NULL AUTO_INCREMENT ,
  `nome` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`id_classe`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `concursos`.`campus`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `concursos`.`campus` ;

CREATE  TABLE IF NOT EXISTS `concursos`.`campus` (
  `id_campus` INT NOT NULL AUTO_INCREMENT ,
  `cidade_campus` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`id_campus`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `concursos`.`concurso`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `concursos`.`concurso` ;

CREATE  TABLE IF NOT EXISTS `concursos`.`concurso` (
  `id_concurso` INT NOT NULL AUTO_INCREMENT ,
  `ministerio` VARCHAR(45) NULL ,
  `instituicao` VARCHAR(45) NULL ,
  `id_campus` INT NOT NULL ,
  `area` VARCHAR(45) NULL ,
  `edital` VARCHAR(45) NULL ,
  `id_classe_concurso` INT NOT NULL ,
  `data_inicio` DATETIME NULL ,
  `tem_prova_escrita` TINYINT(1) NOT NULL ,
  `tem_prova_titulo` TINYINT(1) NOT NULL ,
  `tem_prova_didatica` TINYINT(1) NOT NULL ,
  `tem_prova_memorial` TINYINT(1) NOT NULL ,
  PRIMARY KEY (`id_concurso`) ,
  INDEX `fk_concurso_classe1_idx` (`id_classe_concurso` ASC) ,
  INDEX `fk_concurso_campus1_idx` (`id_campus` ASC) ,
  CONSTRAINT `fk_concurso_classe1`
    FOREIGN KEY (`id_classe_concurso` )
    REFERENCES `concursos`.`classe_concurso` (`id_classe` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_concurso_campus1`
    FOREIGN KEY (`id_campus` )
    REFERENCES `concursos`.`campus` (`id_campus` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `concursos`.`prova_didatica`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `concursos`.`prova_didatica` ;

CREATE  TABLE IF NOT EXISTS `concursos`.`prova_didatica` (
  `id_prova_didatica` INT NOT NULL ,
  `nota` VARCHAR(45) NULL ,
  `id_concurso` INT NOT NULL ,
  PRIMARY KEY (`id_prova_didatica`) ,
  INDEX `fk_prova_didatica_concurso1_idx` (`id_concurso` ASC) ,
  CONSTRAINT `fk_prova_didatica_concurso1`
    FOREIGN KEY (`id_concurso` )
    REFERENCES `concursos`.`concurso` (`id_concurso` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `concursos`.`prova_escrita`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `concursos`.`prova_escrita` ;

CREATE  TABLE IF NOT EXISTS `concursos`.`prova_escrita` (
  `id_prova_escrita` INT NOT NULL AUTO_INCREMENT ,
  `nota` VARCHAR(45) NOT NULL ,
  `local` VARCHAR(45) NULL ,
  `id_concurso` INT NOT NULL ,
  PRIMARY KEY (`id_prova_escrita`) ,
  INDEX `fk_prova_escrita_concurso1_idx` (`id_concurso` ASC) ,
  CONSTRAINT `fk_prova_escrita_concurso1`
    FOREIGN KEY (`id_concurso` )
    REFERENCES `concursos`.`concurso` (`id_concurso` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `concursos`.`candidato`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `concursos`.`candidato` ;

CREATE  TABLE IF NOT EXISTS `concursos`.`candidato` (
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
  INDEX `fk_candidato_prova_escrita1_idx` (`id_prova_escrita` ASC) ,
  INDEX `fk_candidato_usuario1_idx` (`id_pessoa` ASC) ,
  CONSTRAINT `fk_candidato_concurso`
    FOREIGN KEY (`id_concurso` )
    REFERENCES `concursos`.`concurso` (`id_concurso` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_candidato_prova_didatica1`
    FOREIGN KEY (`id_prova_didatica` )
    REFERENCES `concursos`.`prova_didatica` (`id_prova_didatica` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_candidato_prova_escrita1`
    FOREIGN KEY (`id_prova_escrita` )
    REFERENCES `concursos`.`prova_escrita` (`id_prova_escrita` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_candidato_usuario1`
    FOREIGN KEY (`id_pessoa` )
    REFERENCES `concursos`.`pessoa` (`id_pessoa` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = '			';


-- -----------------------------------------------------
-- Table `concursos`.`pesos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `concursos`.`pesos` ;

CREATE  TABLE IF NOT EXISTS `concursos`.`pesos` (
  `id_pesos` INT NOT NULL AUTO_INCREMENT ,
  `descricao_peso` VARCHAR(45) NULL ,
  `valor` FLOAT NULL ,
  `id_prova_escrita` INT NULL ,
  PRIMARY KEY (`id_pesos`) ,
  INDEX `fk_pesos_prova_escrita1_idx` (`id_prova_escrita` ASC) ,
  CONSTRAINT `fk_pesos_prova_escrita1`
    FOREIGN KEY (`id_prova_escrita` )
    REFERENCES `concursos`.`prova_escrita` (`id_prova_escrita` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `concursos`.`prova_memorial`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `concursos`.`prova_memorial` ;

CREATE  TABLE IF NOT EXISTS `concursos`.`prova_memorial` (
  `id_prova_memorial` INT NOT NULL AUTO_INCREMENT ,
  `local` VARCHAR(45) NULL ,
  `id_concurso` INT NOT NULL ,
  PRIMARY KEY (`id_prova_memorial`) ,
  INDEX `fk_prova_memorial_concurso1_idx` (`id_concurso` ASC) ,
  CONSTRAINT `fk_prova_memorial_concurso1`
    FOREIGN KEY (`id_concurso` )
    REFERENCES `concursos`.`concurso` (`id_concurso` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `concursos`.`abertura`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `concursos`.`abertura` ;

CREATE  TABLE IF NOT EXISTS `concursos`.`abertura` (
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
    REFERENCES `concursos`.`concurso` (`id_concurso` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `concursos`.`criterios_prova_escrita`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `concursos`.`criterios_prova_escrita` ;

CREATE  TABLE IF NOT EXISTS `concursos`.`criterios_prova_escrita` (
  `id_criterios_prova_escrita` INT NOT NULL ,
  `descricao` VARCHAR(255) NULL ,
  `peso` DECIMAL(2) NULL ,
  `id_concurso` INT NOT NULL ,
  PRIMARY KEY (`id_criterios_prova_escrita`) ,
  INDEX `fk_criterios_prova_escrita_concurso1_idx` (`id_concurso` ASC) ,
  CONSTRAINT `fk_criterios_prova_escrita_concurso1`
    FOREIGN KEY (`id_concurso` )
    REFERENCES `concursos`.`concurso` (`id_concurso` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `concursos`.`cronograma`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `concursos`.`cronograma` ;

CREATE  TABLE IF NOT EXISTS `concursos`.`cronograma` (
  `id_cronograma` INT NOT NULL AUTO_INCREMENT ,
  `atividade` TEXT NULL ,
  `data` DATETIME NULL ,
  `local` VARCHAR(45) NULL ,
  `id_concurso` INT NOT NULL ,
  PRIMARY KEY (`id_cronograma`) ,
  INDEX `fk_cronograma_concurso1_idx` (`id_concurso` ASC) ,
  CONSTRAINT `fk_cronograma_concurso1`
    FOREIGN KEY (`id_concurso` )
    REFERENCES `concursos`.`concurso` (`id_concurso` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `concursos`.`tipo_cargo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `concursos`.`tipo_cargo` ;

CREATE  TABLE IF NOT EXISTS `concursos`.`tipo_cargo` (
  `id_tipo_cargo` INT NOT NULL ,
  PRIMARY KEY (`id_tipo_cargo`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `concursos`.`cargos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `concursos`.`cargos` ;

CREATE  TABLE IF NOT EXISTS `concursos`.`cargos` (
  `id_cargos` INT NOT NULL ,
  `id_tipo_cargo` INT NOT NULL ,
  PRIMARY KEY (`id_cargos`) ,
  INDEX `fk_cargos_tipo_cargo1_idx` (`id_tipo_cargo` ASC) ,
  CONSTRAINT `fk_cargos_tipo_cargo1`
    FOREIGN KEY (`id_tipo_cargo` )
    REFERENCES `concursos`.`tipo_cargo` (`id_tipo_cargo` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `concursos`.`banca_examinadora`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `concursos`.`banca_examinadora` ;

CREATE  TABLE IF NOT EXISTS `concursos`.`banca_examinadora` (
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
    REFERENCES `concursos`.`examinador` (`id_examinador` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_banca_examinadora_examinador2`
    FOREIGN KEY (`examinador_2` )
    REFERENCES `concursos`.`examinador` (`id_examinador` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_banca_examinadora_examinador3`
    FOREIGN KEY (`examinador_3` )
    REFERENCES `concursos`.`examinador` (`id_examinador` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_banca_examinadora_concurso1`
    FOREIGN KEY (`id_concurso` )
    REFERENCES `concursos`.`concurso` (`id_concurso` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `concursos`.`titulacao`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `concursos`.`titulacao` ;

CREATE  TABLE IF NOT EXISTS `concursos`.`titulacao` (
  `id_titulacao` INT NOT NULL AUTO_INCREMENT ,
  `titulacao` VARCHAR(255) NOT NULL ,
  PRIMARY KEY (`id_titulacao`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `concursos`.`examinador`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `concursos`.`examinador` ;

CREATE  TABLE IF NOT EXISTS `concursos`.`examinador` (
  `id_examinador` INT NOT NULL AUTO_INCREMENT ,
  `id_titulacao` INT NOT NULL ,
  `id_pessoa` INT NOT NULL ,
  PRIMARY KEY (`id_examinador`) ,
  INDEX `fk_examinador_titulacao1_idx` (`id_titulacao` ASC) ,
  INDEX `fk_examinador_usuario1_idx` (`id_pessoa` ASC) ,
  CONSTRAINT `fk_examinador_titulacao1`
    FOREIGN KEY (`id_titulacao` )
    REFERENCES `concursos`.`titulacao` (`id_titulacao` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_examinador_usuario1`
    FOREIGN KEY (`id_pessoa` )
    REFERENCES `concursos`.`pessoa` (`id_pessoa` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `concursos`.`banca_exami_examindores`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `concursos`.`banca_exami_examindores` ;

CREATE  TABLE IF NOT EXISTS `concursos`.`banca_exami_examindores` (
  `id_banca_exami_examindores` INT NOT NULL ,
  `id_banca_examinadora` INT NOT NULL ,
  `id_examinador` INT NOT NULL ,
  PRIMARY KEY (`id_banca_exami_examindores`, `id_banca_examinadora`, `id_examinador`) ,
  INDEX `fk_banca_exami_examindores_banca_examinadora1_idx` (`id_banca_examinadora` ASC) ,
  INDEX `fk_banca_exami_examindores_examinador1_idx` (`id_examinador` ASC) ,
  CONSTRAINT `fk_banca_exami_examindores_banca_examinadora1`
    FOREIGN KEY (`id_banca_examinadora` )
    REFERENCES `concursos`.`banca_examinadora` (`id_banca_examinadora` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_banca_exami_examindores_examinador1`
    FOREIGN KEY (`id_examinador` )
    REFERENCES `concursos`.`examinador` (`id_examinador` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `concursos`.`notas_prova_didatica`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `concursos`.`notas_prova_didatica` ;

CREATE  TABLE IF NOT EXISTS `concursos`.`notas_prova_didatica` (
  `id_notas_prova_didatica` INT NOT NULL ,
  `descricao` VARCHAR(45) NULL ,
  `id_concurso` INT NOT NULL ,
  PRIMARY KEY (`id_notas_prova_didatica`) ,
  INDEX `fk_notas_prova_didatica_concurso1_idx` (`id_concurso` ASC) ,
  CONSTRAINT `fk_notas_prova_didatica_concurso1`
    FOREIGN KEY (`id_concurso` )
    REFERENCES `concursos`.`concurso` (`id_concurso` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `concursos`.`sorteio_ponto_prov_didatica`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `concursos`.`sorteio_ponto_prov_didatica` ;

CREATE  TABLE IF NOT EXISTS `concursos`.`sorteio_ponto_prov_didatica` (
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
    REFERENCES `concursos`.`pessoa` (`id_pessoa` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_sorteio_ponto_prov_didatica_notas_prova_didatica1`
    FOREIGN KEY (`id_notas_prova_didatica` )
    REFERENCES `concursos`.`notas_prova_didatica` (`id_notas_prova_didatica` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `concursos`.`classe`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `concursos`.`classe` ;

CREATE  TABLE IF NOT EXISTS `concursos`.`classe` (
  `id_classe` INT NOT NULL AUTO_INCREMENT ,
  `nome_classe` VARCHAR(255) NULL ,
  `peso_classe` FLOAT NULL ,
  `nota_referencia_classe` FLOAT NULL ,
  PRIMARY KEY (`id_classe`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `concursos`.`prova_titulo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `concursos`.`prova_titulo` ;

CREATE  TABLE IF NOT EXISTS `concursos`.`prova_titulo` (
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
    REFERENCES `concursos`.`concurso` (`id_concurso` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_prova_titulo_classe1`
    FOREIGN KEY (`classe_1` )
    REFERENCES `concursos`.`classe` (`id_classe` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_prova_titulo_classe2`
    FOREIGN KEY (`classe_2` )
    REFERENCES `concursos`.`classe` (`id_classe` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_prova_titulo_classe3`
    FOREIGN KEY (`classe_3` )
    REFERENCES `concursos`.`classe` (`id_classe` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `concursos`.`avaliacao_prova_titulo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `concursos`.`avaliacao_prova_titulo` ;

CREATE  TABLE IF NOT EXISTS `concursos`.`avaliacao_prova_titulo` (
  `id_avaliacao_prova_titulo` INT NOT NULL AUTO_INCREMENT ,
  `id_candidato` INT NOT NULL ,
  `id_prova_titulo` INT NOT NULL ,
  PRIMARY KEY (`id_avaliacao_prova_titulo`) ,
  INDEX `fk_avaliacao_prova_titulo_candidato1_idx` (`id_candidato` ASC) ,
  INDEX `fk_avaliacao_prova_titulo_prova_titulo1_idx` (`id_prova_titulo` ASC) ,
  CONSTRAINT `fk_avaliacao_prova_titulo_candidato1`
    FOREIGN KEY (`id_candidato` )
    REFERENCES `concursos`.`candidato` (`id_candidato` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_avaliacao_prova_titulo_prova_titulo1`
    FOREIGN KEY (`id_prova_titulo` )
    REFERENCES `concursos`.`prova_titulo` (`id_prova_titulo` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `concursos`.`item_classe`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `concursos`.`item_classe` ;

CREATE  TABLE IF NOT EXISTS `concursos`.`item_classe` (
  `id_item_classe` INT NOT NULL AUTO_INCREMENT ,
  `discriminacao` VARCHAR(45) NULL ,
  `pontuacao` FLOAT NULL ,
  `id_classe` INT NOT NULL ,
  PRIMARY KEY (`id_item_classe`) ,
  INDEX `fk_item_classe_classe1_idx` (`id_classe` ASC) ,
  CONSTRAINT `fk_item_classe_classe1`
    FOREIGN KEY (`id_classe` )
    REFERENCES `concursos`.`classe` (`id_classe` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `concursos`.`item_classe_has_classe`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `concursos`.`item_classe_has_classe` ;

CREATE  TABLE IF NOT EXISTS `concursos`.`item_classe_has_classe` (
  `classe_id_classe` INT NOT NULL ,
  `item_classe_id_item_classe` INT NOT NULL ,
  PRIMARY KEY (`classe_id_classe`, `item_classe_id_item_classe`) ,
  INDEX `fk_item_classe_has_classe_classe1_idx` (`classe_id_classe` ASC) ,
  INDEX `fk_item_classe_has_classe_item_classe1_idx` (`item_classe_id_item_classe` ASC) ,
  CONSTRAINT `fk_item_classe_has_classe_item_classe1`
    FOREIGN KEY (`item_classe_id_item_classe` )
    REFERENCES `concursos`.`item_classe` (`id_item_classe` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_item_classe_has_classe_classe1`
    FOREIGN KEY (`classe_id_classe` )
    REFERENCES `concursos`.`classe` (`id_classe` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `concursos`.`avaliacao_item`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `concursos`.`avaliacao_item` ;

CREATE  TABLE IF NOT EXISTS `concursos`.`avaliacao_item` (
  `id_item_classe` INT NOT NULL ,
  `id_avaliacao_prova_titulo` INT NOT NULL ,
  `quantidade` INT NULL ,
  INDEX `fk_item_classe_has_avaliacao_prova_titulo_avaliacao_prova_t_idx` (`id_avaliacao_prova_titulo` ASC) ,
  INDEX `fk_item_classe_has_avaliacao_prova_titulo_item_classe1_idx` (`id_item_classe` ASC) ,
  CONSTRAINT `fk_item_classe_has_avaliacao_prova_titulo_item_classe1`
    FOREIGN KEY (`id_item_classe` )
    REFERENCES `concursos`.`item_classe` (`id_item_classe` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_item_classe_has_avaliacao_prova_titulo_avaliacao_prova_tit1`
    FOREIGN KEY (`id_avaliacao_prova_titulo` )
    REFERENCES `concursos`.`avaliacao_prova_titulo` (`id_avaliacao_prova_titulo` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `concursos`.`avaliacao_prova_memorial`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `concursos`.`avaliacao_prova_memorial` ;

CREATE  TABLE IF NOT EXISTS `concursos`.`avaliacao_prova_memorial` (
  `id_avaliacao_prova_memorial` INT NOT NULL AUTO_INCREMENT ,
  `candidato_id_candidato` INT NOT NULL ,
  `id_prova_memorial` INT NOT NULL ,
  PRIMARY KEY (`id_avaliacao_prova_memorial`) ,
  INDEX `fk_avaliacao_prova_memorial_candidato1_idx` (`candidato_id_candidato` ASC) ,
  INDEX `fk_avaliacao_prova_memorial_prova_memorial1_idx` (`id_prova_memorial` ASC) ,
  CONSTRAINT `fk_avaliacao_prova_memorial_candidato1`
    FOREIGN KEY (`candidato_id_candidato` )
    REFERENCES `concursos`.`candidato` (`id_candidato` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_avaliacao_prova_memorial_prova_memorial1`
    FOREIGN KEY (`id_prova_memorial` )
    REFERENCES `concursos`.`prova_memorial` (`id_prova_memorial` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `concursos`.`criterio_avaliacao`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `concursos`.`criterio_avaliacao` ;

CREATE  TABLE IF NOT EXISTS `concursos`.`criterio_avaliacao` (
  `id_criterio_avaliacao_prova_memorial` INT NOT NULL AUTO_INCREMENT ,
  `criterio` VARCHAR(45) NULL ,
  `peso` FLOAT NULL ,
  `id_prova_memorial` INT NOT NULL ,
  PRIMARY KEY (`id_criterio_avaliacao_prova_memorial`) ,
  INDEX `fk_criterio_avaliacao_prova_memorial_prova_memorial1_idx` (`id_prova_memorial` ASC) ,
  CONSTRAINT `fk_criterio_avaliacao_prova_memorial_prova_memorial1`
    FOREIGN KEY (`id_prova_memorial` )
    REFERENCES `concursos`.`prova_memorial` (`id_prova_memorial` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `concursos`.`avaliacao_examinador_criterio`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `concursos`.`avaliacao_examinador_criterio` ;

CREATE  TABLE IF NOT EXISTS `concursos`.`avaliacao_examinador_criterio` (
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
    REFERENCES `concursos`.`criterio_avaliacao` (`id_criterio_avaliacao_prova_memorial` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_avaliacao_examinador_criterio_avaliacao_prova_memorial1`
    FOREIGN KEY (`id_avaliacao_prova_memorial` )
    REFERENCES `concursos`.`avaliacao_prova_memorial` (`id_avaliacao_prova_memorial` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_avaliacao_examinador_criterio_examinador1`
    FOREIGN KEY (`id_examinador` )
    REFERENCES `concursos`.`examinador` (`id_examinador` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `concursos`.`banca_examinadora`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `concursos`.`banca_examinadora` ;

CREATE  TABLE IF NOT EXISTS `concursos`.`banca_examinadora` (
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
    REFERENCES `concursos`.`examinador` (`id_examinador` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_banca_examinadora_examinador2`
    FOREIGN KEY (`examinador_2` )
    REFERENCES `concursos`.`examinador` (`id_examinador` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_banca_examinadora_examinador3`
    FOREIGN KEY (`examinador_3` )
    REFERENCES `concursos`.`examinador` (`id_examinador` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_banca_examinadora_concurso1`
    FOREIGN KEY (`id_concurso` )
    REFERENCES `concursos`.`concurso` (`id_concurso` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

USE `concursos` ;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
