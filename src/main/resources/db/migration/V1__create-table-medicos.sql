
create table medicos(

    id BIGSERIAL NOT NULL,
    nombre varchar(100) not null,
    email varchar(100) not null unique,
    telefono varchar(12) not null,
    cedula varchar(7) not null,
    activo BOOLEAN NOT NULL,
    especialidad varchar(100) not null,
    calle varchar(100) not null,
    colonia varchar(100) not null,
    estado varchar(100) not null,
    codigo varchar(20) not null,
    interior varchar(100),
    exterior varchar(100),
    PRIMARY KEY (id)

);
