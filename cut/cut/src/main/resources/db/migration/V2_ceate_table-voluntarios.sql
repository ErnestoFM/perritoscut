CREATE TABLE voluntario (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       nombre VARCHAR(100) NOT NULL,
                       apellido VARCHAR(100),
                       correo VARCHAR(30) NOT NULL,
                       telefono VARCHAR(15) NO NULL,
                       roll VARCHAR(30) NOT NULL
);