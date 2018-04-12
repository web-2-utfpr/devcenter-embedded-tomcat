-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema sql10232125
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema sql10232125
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `sql10232125` DEFAULT CHARACTER SET utf8 ;
USE `sql10232125` ;

-- -----------------------------------------------------
-- Table `sql10232125`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sql10232125`.`usuario` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `senha` VARCHAR(45) NOT NULL,
  `email` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `nome_UNIQUE` (`nome` ASC),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sql10232125`.`imagem`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sql10232125`.`imagem` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `id_usuario` INT NOT NULL,
  `url` VARCHAR(255) NOT NULL,
  `path` VARCHAR(100) NOT NULL,
  `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`, `id_usuario`),
  INDEX `fk_Imagem_Usuario_idx` (`id_usuario` ASC),
  UNIQUE INDEX `path_UNIQUE` (`path` ASC),
  UNIQUE INDEX `url_UNIQUE` (`url` ASC),
  CONSTRAINT `fk_Imagem_Usuario`
    FOREIGN KEY (`id_usuario`)
    REFERENCES `sql10232125`.`usuario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
