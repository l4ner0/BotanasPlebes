/*PROCEDIMIENTO PARA VALIDAR LOGUEO DE USUARIOS*/

DELIMITER $$
CREATE PROCEDURE ValidarCredenciales( _usuario varchar(50), _password varchar(50) )
BEGIN
SELECT idUsuario FROM usuarios WHERE usuario = _usuario AND password = _password LIMIT 1;
END$$
DELIMITER ;


/*PROCEDIMIENTO PARA BUSCAR USUARIO POR ID*/

DELIMITER $$
CREATE PROCEDURE BuscarUsuario( _idUsuario int(11) )
BEGIN
SELECT * FROM usuarios WHERE idUsuario = _idUsuario LIMIT 1;
END$$
DELIMITER ;