-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema acex
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema acex
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `acex` DEFAULT CHARACTER SET utf8mb3 ;
USE `acex` ;

-- -----------------------------------------------------
-- Table `acex`.`departamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `acex`.`departamento` (
  `id_depart` INT NOT NULL AUTO_INCREMENT,
  `jefe` INT UNSIGNED,
  `nombre` VARCHAR(45) NOT NULL,
  `codigo_departamento` VARCHAR(3) NOT NULL,
  PRIMARY KEY (`id_depart`),
  UNIQUE INDEX `codigo_UNIQUE` (`codigo_departamento` ASC) VISIBLE,
  INDEX `id_profesor_idx` (`jefe` ASC) VISIBLE,
  CONSTRAINT `id_profesor`
    FOREIGN KEY (`jefe`)
    REFERENCES `acex`.`profesor` (`id_profesor`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `acex`.`profesor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `acex`.`profesor` (
  `id_profesor` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `dni` VARCHAR(9) NOT NULL,
  `nombre` VARCHAR(20) NOT NULL,
  `apellidos` VARCHAR(45) NOT NULL,
  `departamento` INT NOT NULL,
  `correo` VARCHAR(45) NOT NULL,
  `contrasena` VARCHAR(45) NOT NULL,
  `perfil` ENUM('profesor', 'equipo directivo', 'administrador', 'superusuario') NULL DEFAULT NULL,
  `activo` TINYINT NOT NULL,
  PRIMARY KEY (`id_profesor`),
  UNIQUE INDEX `dni_UNIQUE` (`dni` ASC) VISIBLE,
  UNIQUE INDEX `correo_UNIQUE` (`correo` ASC) VISIBLE,
  INDEX `departamento_idx` (`departamento` ASC) VISIBLE,
  CONSTRAINT `departamento`
    FOREIGN KEY (`departamento`)
    REFERENCES `acex`.`departamento` (`id_depart`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `acex`.`actividades_solicitadas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `acex`.`actividades_solicitadas` (
  `id_actividad` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `solicitante` INT UNSIGNED NOT NULL,
  `titulo` VARCHAR(150) NOT NULL,
  `tipo` ENUM('Complementaria', 'Extraescolar') NOT NULL,
  `departamento` INT NOT NULL,
  `prevista` TINYINT NOT NULL,
  `fini` DATE NOT NULL,
  `ffin` DATE NOT NULL,
  `hini` TIME NOT NULL,
  `hfin` TIME NOT NULL,
  `transporte` TINYINT NOT NULL,
  `comentario_transporte` VARCHAR(300) NULL DEFAULT NULL,
  `alojamiento` TINYINT NOT NULL,
  `comentario_alojamiento` VARCHAR(300) NULL DEFAULT NULL,
  `comentario` VARCHAR(300) NULL DEFAULT NULL,
  `estado` ENUM('solicitada', 'aprobada', 'denegada', 'realizada') NULL DEFAULT 'solicitada',
  `comentario_estado` VARCHAR(300) NULL DEFAULT NULL,
  PRIMARY KEY (`id_actividad`),
  INDEX `fk_actividades_solicitadas_profesor1_idx` (`solicitante` ASC) VISIBLE,
  CONSTRAINT `fk_actividades_solicitadas_profesor1`
    FOREIGN KEY (`solicitante`)
    REFERENCES `acex`.`profesor` (`id_profesor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `acex`.`actividades_programadas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `acex`.`actividades_programadas` (
  `id_actividad` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `titulo` VARCHAR(150) NOT NULL,
  `tipo` ENUM('Complementaria', 'Extraescolar') NOT NULL,
  `departamento` INT NOT NULL,
  `prevista` TINYINT NOT NULL,
  `fini` DATE NOT NULL,
  `ffin` DATE NOT NULL,
  `hini` TIME NOT NULL,
  `hfin` TIME NOT NULL,
  `transporte` TINYINT NOT NULL,
  `comentario_transporte` VARCHAR(300) NULL DEFAULT NULL,
  `alojamiento` TINYINT NOT NULL,
  `comentario_alojamiento` VARCHAR(300) NULL DEFAULT NULL,
  `comentario` VARCHAR(300) NULL DEFAULT NULL,
  `estado` ENUM('solicitada', 'aprobada', 'denegada', 'realizada') NULL DEFAULT 'solicitada',
  `comentario_estado` VARCHAR(300) NULL DEFAULT NULL,
  `empresa_transporte` VARCHAR(300) NULL DEFAULT NULL,
  `importe_transporte` DOUBLE NULL DEFAULT NULL,
  `comentario_adicional` VARCHAR(500) NULL DEFAULT NULL,
  PRIMARY KEY (`id_actividad`),
  CONSTRAINT `id_actividad`
    FOREIGN KEY (`id_actividad`)
    REFERENCES `acex`.`actividades_solicitadas` (`id_actividad`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `acex`.`curso`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `acex`.`curso` (
  `id_curso` INT NOT NULL AUTO_INCREMENT,
  `codigo` VARCHAR(5) NOT NULL,
  `descripcion` VARCHAR(150) NOT NULL,
  `etapa` ENUM('ESO', 'Bachillerato', 'FPGS', 'FPGM', 'FPB', 'FPCE') NOT NULL,
  `activo` TINYINT NOT NULL,
  PRIMARY KEY (`id_curso`),
  UNIQUE INDEX `codigo_UNIQUE` (`codigo` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `acex`.`curso_participa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `acex`.`curso_participa` (
  `id_curso` INT NOT NULL,
  `id_actividad` INT UNSIGNED NOT NULL,
  `num_alumnos` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id_curso`, `id_actividad`),
  INDEX `fk_actividades_solicitadas_has_curso_curso1_idx` (`id_actividad` ASC) VISIBLE,
  INDEX `fk_actividades_solicitadas_has_curso_actividades_solicitada_idx` (`id_curso` ASC) VISIBLE,
  CONSTRAINT `fk_actividades_solicitadas_has_curso_actividades_solicitadas1`
    FOREIGN KEY (`id_actividad`)
    REFERENCES `acex`.`actividades_solicitadas` (`id_actividad`),
  CONSTRAINT `fk_curso_participa_curso`
    FOREIGN KEY (`id_curso`)
    REFERENCES `acex`.`curso` (`id_curso`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `acex`.`transporte`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `acex`.`transporte` (
  `id_transporte` INT NOT NULL,
  `tipo` VARCHAR(30) NOT NULL,
  `comentario` VARCHAR(300) NULL DEFAULT NULL,
  PRIMARY KEY (`id_transporte`),
  UNIQUE INDEX `tipo_UNIQUE` (`tipo` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `acex`.`desplazamiento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `acex`.`desplazamiento` (
  `id_actividad` INT UNSIGNED NOT NULL,
  `id_transporte` INT NOT NULL,
  `km` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id_actividad`, `id_transporte`),
  INDEX `fk_transporte_has_actividades_programadas_actividades_progr_idx` (`id_actividad` ASC) VISIBLE,
  INDEX `fk_transporte_has_actividades_programadas_transporte1_idx` (`id_transporte` ASC) VISIBLE,
  CONSTRAINT `fk_transporte_has_actividades_programadas_actividades_program1`
    FOREIGN KEY (`id_actividad`)
    REFERENCES `acex`.`actividades_programadas` (`id_actividad`),
  CONSTRAINT `fk_transporte_has_actividades_programadas_transporte1`
    FOREIGN KEY (`id_transporte`)
    REFERENCES `acex`.`transporte` (`id_transporte`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `acex`.`fotos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `acex`.`fotos` (
  `id_foto` INT NOT NULL AUTO_INCREMENT,
  `id_actividad` INT UNSIGNED NOT NULL,
  `url` VARCHAR(300) NOT NULL,
  `descripcion` VARCHAR(300) NOT NULL,
  PRIMARY KEY (`id_foto`),
  UNIQUE INDEX `url_UNIQUE` (`url` ASC) VISIBLE,
  INDEX `fk_fotos_actividades_programadas1_idx` (`id_actividad` ASC) VISIBLE,
  CONSTRAINT `fk_fotos_actividades_programadas`
    FOREIGN KEY (`id_actividad`)
    REFERENCES `acex`.`actividades_programadas` (`id_actividad`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `acex`.`grupo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `acex`.`grupo` (
  `id_grupo` INT NOT NULL,
  `codigo` VARCHAR(8) NOT NULL,
  `curso` INT NOT NULL,
  `num_alumnos` INT UNSIGNED NOT NULL,
  `activo` TINYINT NOT NULL,
  PRIMARY KEY (`id_grupo`),
  UNIQUE INDEX `codigo_UNIQUE` (`codigo` ASC) VISIBLE,
  INDEX `curso_idx` (`curso` ASC) VISIBLE,
  CONSTRAINT `curso`
    FOREIGN KEY (`curso`)
    REFERENCES `acex`.`curso` (`id_curso`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `acex`.`grupo_participa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `acex`.`grupo_participa` (
  `id_grupo` INT NOT NULL,
  `id_actividad` INT UNSIGNED NOT NULL,
  `num_alumnos` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id_grupo`, `id_actividad`),
  INDEX `fk_actividades_solicitadas_has_grupo_grupo1_idx` (`id_actividad` ASC) VISIBLE,
  INDEX `fk_actividades_solicitadas_has_grupo_actividades_solicitada_idx` (`id_grupo` ASC) VISIBLE,
  CONSTRAINT `fk_actividades_solicitadas_has_grupo_actividades_solicitadas1`
    FOREIGN KEY (`id_actividad`)
    REFERENCES `acex`.`actividades_solicitadas` (`id_actividad`),
  CONSTRAINT `fk_grupo_participa_grupo`
    FOREIGN KEY (`id_grupo`)
    REFERENCES `acex`.`grupo` (`id_grupo`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `acex`.`profesor_participa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `acex`.`profesor_participa` (
  `id_profesor` INT UNSIGNED NOT NULL,
  `id_actividad` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id_profesor`, `id_actividad`),
  INDEX `fk_profesor_has_actividades_solicitadas_actividades_solicit_idx` (`id_actividad` ASC) VISIBLE,
  INDEX `fk_profesor_has_actividades_solicitadas_profesor2_idx` (`id_profesor` ASC) VISIBLE,
  CONSTRAINT `fk_profesor_has_actividades_solicitadas_actividades_solicitad2`
    FOREIGN KEY (`id_actividad`)
    REFERENCES `acex`.`actividades_solicitadas` (`id_actividad`),
  CONSTRAINT `fk_profesor_has_actividades_solicitadas_profesor2`
    FOREIGN KEY (`id_profesor`)
    REFERENCES `acex`.`profesor` (`id_profesor`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `acex`.`profesor_responsable`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `acex`.`profesor_responsable` (
  `id_profesor` INT UNSIGNED NOT NULL,
  `id_actividad` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id_profesor`, `id_actividad`),
  INDEX `fk_profesor_has_actividades_solicitadas_actividades_solicit_idx` (`id_actividad` ASC) VISIBLE,
  INDEX `fk_profesor_has_actividades_solicitadas_profesor1_idx` (`id_profesor` ASC) VISIBLE,
  CONSTRAINT `fk_profesor_has_actividades_solicitadas_actividades_solicitad1`
    FOREIGN KEY (`id_actividad`)
    REFERENCES `acex`.`actividades_solicitadas` (`id_actividad`),
  CONSTRAINT `fk_profesor_has_actividades_solicitadas_profesor1`
    FOREIGN KEY (`id_profesor`)
    REFERENCES `acex`.`profesor` (`id_profesor`))
    


ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;
INSERT INTO acex.transporte (id_transporte, tipo) VALUES ('1', 'Andando');
INSERT INTO acex.transporte (id_transporte, tipo) VALUES ('2', 'Autobus');
INSERT INTO acex.transporte (id_transporte, tipo) VALUES ('3', 'Bicicleta');
INSERT INTO acex.transporte (id_transporte, tipo) VALUES ('4', 'Taxi');
INSERT INTO acex.transporte (id_transporte, tipo) VALUES ('5', 'Barco');
INSERT INTO acex.transporte (id_transporte, tipo) VALUES ('6', 'Avion');



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
