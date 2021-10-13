
INSERT INTO usuario
(nome, email, senha)
VALUES
('usuario', 'admin@magalu.com', '$2a$10$hF6JZ/z9WtY9kWyVEZOz6OlPamwpIs5pbM3Wjt/wXIzw3gdoWKmz2');

INSERT INTO usuario_permissao
( idUsuario, idPermissao)
SELECT usuario.idUsuario , permissao.idPermissao FROM usuario,  permissao;