CREATE TABLE Base_Datos (
  id         SERIAL NOT NULL, 
  Cuentaid   int4 NOT NULL, 
  nombre     varchar(100) NOT NULL, 
  url        varchar(255) NOT NULL, 
  usuario    varchar(100) NOT NULL, 
  contrasena varchar(255) NOT NULL, 
  driver     varchar(100) NOT NULL, 
  Tokentoken varchar(255) NOT NULL, 
  PRIMARY KEY (id));
CREATE TABLE Cuenta (
  id         SERIAL NOT NULL, 
  usuario    varchar(50) NOT NULL UNIQUE, 
  contrasena varchar(255) NOT NULL, 
  estado     varchar(255), 
  PRIMARY KEY (id));
CREATE TABLE Token (
  token      varchar(255) NOT NULL, 
  expiracion date, 
  PRIMARY KEY (token));
ALTER TABLE Base_Datos ADD CONSTRAINT FKBase_Datos789795 FOREIGN KEY (Tokentoken) REFERENCES Token (token);
ALTER TABLE Base_Datos ADD CONSTRAINT FKBase_Datos588987 FOREIGN KEY (Cuentaid) REFERENCES Cuenta (id);
