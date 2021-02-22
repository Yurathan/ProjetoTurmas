-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema ControleDeEvento
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema ControleDeEvento
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `ControleDeEvento` DEFAULT CHARACTER SET utf8 ;
USE `ControleDeEvento` ;

-- -----------------------------------------------------
-- Table `ControleDeEvento`.`Alunos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ControleDeEvento`.`Alunos` (
  `pkAluno` INT NOT NULL AUTO_INCREMENT,
  `NomeCompleto` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`pkAluno`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ControleDeEvento`.`Salas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ControleDeEvento`.`Salas` (
  `pkSala` INT NOT NULL AUTO_INCREMENT,
  `Descricao` VARCHAR(45) NOT NULL,
  `Lotacao` INT NOT NULL,
  PRIMARY KEY (`pkSala`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ControleDeEvento`.`Etapa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ControleDeEvento`.`Etapa` (
  `pkEtapa` INT NOT NULL AUTO_INCREMENT,
  `Descricao` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`pkEtapa`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ControleDeEvento`.`Cafe`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ControleDeEvento`.`Cafe` (
  `pkcafe` INT NOT NULL AUTO_INCREMENT,
  `Descricao` VARCHAR(45) NOT NULL,
  `Lotacao` INT NOT NULL,
  PRIMARY KEY (`pkcafe`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ControleDeEvento`.`Alunos_has_Etapa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ControleDeEvento`.`Alunos_has_Etapa` (
  `fkAluno` INT NOT NULL,
  `fkEtapa` INT NOT NULL,
  `fkSala` INT NOT NULL,
  `Cafe_pkcafe` INT NOT NULL,
  PRIMARY KEY (`fkAluno`, `fkEtapa`, `fkSala`, `Cafe_pkcafe`),
  INDEX `fk_Alunos_has_Etapa_Etapa1_idx` (`fkEtapa` ASC) ,
  INDEX `fk_Alunos_has_Etapa_Alunos_idx` (`fkAluno` ASC) ,
  INDEX `fk_Alunos_has_Etapa_Salas1_idx` (`fkSala` ASC) ,
  INDEX `fk_Alunos_has_Etapa_Cafe1_idx` (`Cafe_pkcafe` ASC) ,
  CONSTRAINT `fk_Alunos_has_Etapa_Alunos`
    FOREIGN KEY (`fkAluno`)
    REFERENCES `ControleDeEvento`.`Alunos` (`pkAluno`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Alunos_has_Etapa_Etapa1`
    FOREIGN KEY (`fkEtapa`)
    REFERENCES `ControleDeEvento`.`Etapa` (`pkEtapa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Alunos_has_Etapa_Salas1`
    FOREIGN KEY (`fkSala`)
    REFERENCES `ControleDeEvento`.`Salas` (`pkSala`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Alunos_has_Etapa_Cafe1`
    FOREIGN KEY (`Cafe_pkcafe`)
    REFERENCES `ControleDeEvento`.`Cafe` (`pkcafe`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

insert into ETAPA(Descricao) Values ('fase 1');
insert into ETAPA(Descricao) Values ('fase 2');
