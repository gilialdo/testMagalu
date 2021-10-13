
CREATE TABLE cliente (
 idCliente BIGINT(20)  PRIMARY KEY AUTO_INCREMENT ,
 nome VARCHAR(250)  NOT NULL ,
 email VARCHAR(250)  NOT NULL 
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE permissao (
 idPermissao BIGINT(20)  PRIMARY KEY AUTO_INCREMENT ,
 descricao VARCHAR(45)  NOT NULL 
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE produto (
 
 price double   ,
 image VARCHAR(250)   ,
 brand VARCHAR(250)   ,
 id VARCHAR(250)   ,
 title VARCHAR(250)  ,
 reviewScore VARCHAR(2000) 
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE produto_favorito (
 idProdutoFavorito BIGINT(20)  PRIMARY KEY AUTO_INCREMENT ,
 idCliente BIGINT(20)  NOT NULL ,
 idProduto VARCHAR(250)  NOT NULL 
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE usuario (
 idUsuario BIGINT(20)  PRIMARY KEY AUTO_INCREMENT ,
 nome VARCHAR(45)  NOT NULL ,
 email VARCHAR(250)  NOT NULL ,
 senha VARCHAR(250)  NOT NULL 
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE usuario_permissao (
	idUsuario BIGINT(20) NOT NULL,
	idPermissao BIGINT(20) NOT NULL,
	PRIMARY KEY (idUsuario, idPermissao),
	FOREIGN KEY (idUsuario) REFERENCES usuario(idUsuario),
	FOREIGN KEY (idPermissao) REFERENCES permissao(idPermissao)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;