CREATE DATABASE `prototipo_db`;

CREATE TABLE `empresas` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome_empresa` varchar(255) DEFAULT NULL,
  `endereco` varchar(255) DEFAULT NULL,
  `cidade` varchar(255) DEFAULT NULL,
  `estado` varchar(255) DEFAULT NULL,
  `funcionarios_qtde` int(11) DEFAULT NULL,
  `funcionarios_ti_qtde` int(11) DEFAULT NULL,
  `metodos_ageis` tinyint(1) DEFAULT NULL,
  `metodos_tempo` int(11) DEFAULT NULL,
  `quaisAgeis` varchar(60) DEFAULT NULL,
  `nome_funcionario` varchar(255) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `funcao_funcionario` varchar(255) DEFAULT NULL,
  `funcao_tempo` int(11) DEFAULT NULL,
  `empresa_tempo` int(11) DEFAULT NULL,
  `curso_gestao` tinyint(1) DEFAULT NULL,
  `curso_metodos` tinyint(1) DEFAULT NULL,
  `curso_gestao_tempo` int(11) DEFAULT NULL,
  `curso_ageis_tempo` int(11) DEFAULT NULL,
  `gestao_conhecimento` varchar(40) DEFAULT NULL,
  `ageis_conhecimento` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

CREATE TABLE `problemas` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  `categoria` varchar(255) NOT NULL,
  `descricao` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=latin1;

CREATE TABLE `solucoes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  `metodologia` varchar(255) NOT NULL,
  `descricao` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=latin1;


CREATE TABLE `empresas_problemas` (
  `empresa_id` int(11) NOT NULL,
  `problema_id` int(11) NOT NULL,
  PRIMARY KEY (`empresa_id`,`problema_id`),
  KEY `fk_empresas_has_problemas_problemas1_idx` (`problema_id`),
  KEY `fk_empresas_has_problemas_empresas_idx` (`empresa_id`),
  CONSTRAINT `fk_empresas_has_problemas_empresas` FOREIGN KEY (`empresa_id`) REFERENCES `empresas` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_empresas_has_problemas_problemas1` FOREIGN KEY (`problema_id`) REFERENCES `problemas` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `problemas_solucoes` (
  `problema_id` int(11) NOT NULL,
  `solucao_id` int(11) NOT NULL,
  PRIMARY KEY (`problema_id`,`solucao_id`),
  KEY `fk_problemas_has_solucoes_solucoes1_idx` (`solucao_id`),
  KEY `fk_problemas_has_solucoes_problemas1_idx` (`problema_id`),
  CONSTRAINT `fk_problemas_has_solucoes_problemas1` FOREIGN KEY (`problema_id`) REFERENCES `problemas` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_problemas_has_solucoes_solucoes1` FOREIGN KEY (`solucao_id`) REFERENCES `solucoes` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
