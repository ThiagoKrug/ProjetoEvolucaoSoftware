SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';


-- -----------------------------------------------------
-- Table `usuario`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `usuario` (
  `id_pessoa` INT NOT NULL ,
  `nome` VARCHAR(255) NOT NULL ,
  `sexo` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`id_pessoa`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `classe`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `classe` (
  `id_classe` INT NOT NULL ,
  `nome` VARCHAR(45) NULL ,
  PRIMARY KEY (`id_classe`) )
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
-- Table `concurso`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `concurso` (
  `id_concurso` INT NOT NULL ,
  `ministerio` VARCHAR(45) NULL ,
  `instituicao` VARCHAR(45) NULL ,
  `campus` VARCHAR(45) NULL ,
  `area` VARCHAR(45) NULL ,
  `edital` VARCHAR(45) NULL ,
  `id_classe` INT NOT NULL ,
  `id_cargos` INT NOT NULL ,
  PRIMARY KEY (`id_concurso`) ,
  INDEX `fk_concurso_classe1_idx` (`id_classe` ASC) ,
  INDEX `fk_concurso_cargos1_idx` (`id_cargos` ASC) ,
  CONSTRAINT `fk_concurso_classe1`
    FOREIGN KEY (`id_classe` )
    REFERENCES `classe` (`id_classe` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_concurso_cargos1`
    FOREIGN KEY (`id_cargos` )
    REFERENCES `cargos` (`id_cargos` )
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
-- Table `prova_escrita`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `prova_escrita` (
  `id_prova_escrita` INT NOT NULL ,
  `nota` VARCHAR(45) NOT NULL ,
  `local` VARCHAR(45) NULL ,
  `id_concurso` INT NOT NULL ,
  PRIMARY KEY (`id_prova_escrita`) ,
  INDEX `fk_prova_escrita_concurso1_idx` (`id_concurso` ASC) ,
  CONSTRAINT `fk_prova_escrita_concurso1`
    FOREIGN KEY (`id_concurso` )
    REFERENCES `concurso` (`id_concurso` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `candidato`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `candidato` (
  `id_candidato` INT NOT NULL ,
  `nome_candidato` VARCHAR(45) NULL ,
  `data_nascimento` DATE NULL ,
  `apto_prova_escrita` TINYINT(1) NULL ,
  `apto_prova_didatica` TINYINT(1) NULL ,
  `candidatocol` VARCHAR(45) NULL ,
  `id_concurso` INT NOT NULL ,
  `id_prova_didatica` INT NOT NULL ,
  `id_prova_escrita` INT NOT NULL ,
  `id_pessoa` INT NOT NULL ,
  PRIMARY KEY (`id_candidato`) ,
  INDEX `fk_candidato_concurso_idx` (`id_concurso` ASC) ,
  INDEX `fk_candidato_prova_didatica1_idx` (`id_prova_didatica` ASC) ,
  INDEX `fk_candidato_prova_escrita1_idx` (`id_prova_escrita` ASC) ,
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
  CONSTRAINT `fk_candidato_prova_escrita1`
    FOREIGN KEY (`id_prova_escrita` )
    REFERENCES `prova_escrita` (`id_prova_escrita` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_candidato_usuario1`
    FOREIGN KEY (`id_pessoa` )
    REFERENCES `usuario` (`id_pessoa` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = '			';


-- -----------------------------------------------------
-- Table `memorial`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `memorial` (
  `id_memorial` INT NOT NULL ,
  `data_comparecimento` VARCHAR(45) NULL ,
  `compareceu` TINYINT(1) NOT NULL ,
  `id_candidato` INT NOT NULL ,
  PRIMARY KEY (`id_memorial`) ,
  INDEX `fk_memorial_candidato1_idx` (`id_candidato` ASC) ,
  CONSTRAINT `fk_memorial_candidato1`
    FOREIGN KEY (`id_candidato` )
    REFERENCES `candidato` (`id_candidato` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `classe_titulo`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `classe_titulo` (
  `id_classe_titulo` INT NOT NULL ,
  `descricao` VARCHAR(45) NULL ,
  PRIMARY KEY (`id_classe_titulo`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `titulo`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `titulo` (
  `id_titulo` INT NOT NULL ,
  `descricao` VARCHAR(45) NULL ,
  `pontuacao` DECIMAL(2) NULL ,
  `id_classe_titulo` INT NOT NULL ,
  PRIMARY KEY (`id_titulo`) ,
  INDEX `fk_titulo_classe_titulo1_idx` (`id_classe_titulo` ASC) ,
  CONSTRAINT `fk_titulo_classe_titulo1`
    FOREIGN KEY (`id_classe_titulo` )
    REFERENCES `classe_titulo` (`id_classe_titulo` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `prova_titulo`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `prova_titulo` (
  `id_prova_titulo` INT NOT NULL ,
  `quantidade` DECIMAL NULL ,
  `local` VARCHAR(45) NULL ,
  `id_candidato` INT NOT NULL ,
  `id_titulo` INT NOT NULL ,
  PRIMARY KEY (`id_prova_titulo`) ,
  INDEX `fk_prova_titulo_candidato1_idx` (`id_candidato` ASC) ,
  INDEX `fk_prova_titulo_titulo1_idx` (`id_titulo` ASC) ,
  CONSTRAINT `fk_prova_titulo_candidato1`
    FOREIGN KEY (`id_candidato` )
    REFERENCES `candidato` (`id_candidato` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_prova_titulo_titulo1`
    FOREIGN KEY (`id_titulo` )
    REFERENCES `titulo` (`id_titulo` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pesos`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `pesos` (
  `id_pesos` INT NOT NULL ,
  `peso` DECIMAL NULL ,
  `id_prova_escrita` INT NOT NULL ,
  `id_memorial` INT NOT NULL ,
  `id_prova_titulo` INT NOT NULL ,
  PRIMARY KEY (`id_pesos`) ,
  INDEX `fk_pesos_prova_escrita1_idx` (`id_prova_escrita` ASC) ,
  INDEX `fk_pesos_memorial1_idx` (`id_memorial` ASC) ,
  INDEX `fk_pesos_prova_titulo1_idx` (`id_prova_titulo` ASC) ,
  CONSTRAINT `fk_pesos_prova_escrita1`
    FOREIGN KEY (`id_prova_escrita` )
    REFERENCES `prova_escrita` (`id_prova_escrita` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_pesos_memorial1`
    FOREIGN KEY (`id_memorial` )
    REFERENCES `memorial` (`id_memorial` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_pesos_prova_titulo1`
    FOREIGN KEY (`id_prova_titulo` )
    REFERENCES `prova_titulo` (`id_prova_titulo` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `abertura`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `abertura` (
  `id_abertura` INT NOT NULL ,
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
-- Table `criterios_prova_escrita`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `criterios_prova_escrita` (
  `id_criterios_prova_escrita` INT NOT NULL ,
  `descricao` VARCHAR(255) NULL ,
  `peso` DECIMAL(2) NULL ,
  `id_concurso` INT NOT NULL ,
  PRIMARY KEY (`id_criterios_prova_escrita`) ,
  INDEX `fk_criterios_prova_escrita_concurso1_idx` (`id_concurso` ASC) ,
  CONSTRAINT `fk_criterios_prova_escrita_concurso1`
    FOREIGN KEY (`id_concurso` )
    REFERENCES `concurso` (`id_concurso` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cronograma`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `cronograma` (
  `id_cronograma` INT NOT NULL ,
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
-- Table `banca_examinadora`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `banca_examinadora` (
  `id_banca_examinadora` INT NOT NULL ,
  PRIMARY KEY (`id_banca_examinadora`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `titulacao`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `titulacao` (
  `id_titulacao` INT NOT NULL AUTO_INCREMENT ,
  `titulacao` VARCHAR(255) NULL ,
  PRIMARY KEY (`id_titulacao`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `examinador`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `examinador` (
  `id_examinador` INT NOT NULL ,
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
    REFERENCES `usuario` (`id_pessoa` )
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
    REFERENCES `usuario` (`id_pessoa` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_sorteio_ponto_prov_didatica_notas_prova_didatica1`
    FOREIGN KEY (`id_notas_prova_didatica` )
    REFERENCES `notas_prova_didatica` (`id_notas_prova_didatica` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
