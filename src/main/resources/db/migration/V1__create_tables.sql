CREATE DATABASE IF NOT EXISTS pilaresdb;
USE pilaresdb;

CREATE TABLE IF NOT EXISTS pilar (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    latitud DOUBLE,
    longitud DOUBLE,
    Estado VARCHAR(50) NOT NULL DEFAULT 'activo'
);

CREATE TABLE IF NOT EXISTS mensaje (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    contenido_fragmentado TEXT,
    contenido_reconstruido TEXT,
    fragmento INT,
    fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP, 
    pilar_id BIGINT NOT NULL,
    FOREIGN KEY (pilar_id) REFERENCES pilar(id)
);
