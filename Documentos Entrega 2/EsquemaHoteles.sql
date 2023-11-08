-- Generado por Oracle SQL Developer Data Modeler 23.1.0.087.0806
--   en:        2023-11-07 20:21:04 COT
--   sitio:      Oracle Database 12c
--   tipo:      Oracle Database 12c



-- predefined type, no DDL - MDSYS.SDO_GEOMETRY

-- predefined type, no DDL - XMLTYPE

CREATE TABLE acompañantes (
    idacompañante      INTEGER NOT NULL,
    clientes_documento INTEGER NOT NULL
);

ALTER TABLE acompañantes ADD CONSTRAINT acompañantes_pk PRIMARY KEY ( idacompañante );

CREATE TABLE bares (
    nombre         VARCHAR2(255) NOT NULL,
    estilo         VARCHAR2(255),
    costo          INTEGER,
    capacidad      INTEGER,
    costocargado   INTEGER,
    hoteles_nombre VARCHAR2(255) NOT NULL,
    fecha          DATE NOT NULL,
    semana         INTEGER
);

ALTER TABLE bares ADD CONSTRAINT bares_pk PRIMARY KEY ( nombre );

CREATE TABLE checksins (
    id                  INTEGER NOT NULL,
    documentocliente    INTEGER,
    dia                 DATE,
    realizadopor        VARCHAR2(255),
    cuentaabierta       NUMBER,
    clientes_documento  INTEGER NOT NULL,
    empleados_documento INTEGER NOT NULL
);

CREATE UNIQUE INDEX checksins__idx ON
    checksins (
        clientes_documento
    ASC );

ALTER TABLE checksins ADD CONSTRAINT checksins_pk PRIMARY KEY ( id );

CREATE TABLE checksouts (
    id                  INTEGER NOT NULL,
    dia                 DATE,
    cuentaabierta       NUMBER,
    cuentatotal         INTEGER,
    pagocuenta          NUMBER,
    clientes_documento  INTEGER NOT NULL,
    empleados_documento INTEGER NOT NULL
);

CREATE UNIQUE INDEX checksouts__idx ON
    checksouts (
        clientes_documento
    ASC );

ALTER TABLE checksouts ADD CONSTRAINT checksouts_pk PRIMARY KEY ( id );

CREATE TABLE clientes (
    nombre         VARCHAR2(255) NOT NULL,
    apellido       VARCHAR2(255) NOT NULL,
    documento      INTEGER NOT NULL,
    edad           INTEGER,
    habitacion     INTEGER,
    consumo        INTEGER,
    hoteles_nombre VARCHAR2(255) NOT NULL,
    checksins_id   INTEGER NOT NULL,
    checksouts_id  INTEGER NOT NULL,
    reservas_id    INTEGER NOT NULL,
    cuentas_id     INTEGER NOT NULL
);

CREATE UNIQUE INDEX clientes__idx ON
    clientes (
        checksins_id
    ASC );

CREATE UNIQUE INDEX clientes__idxv1 ON
    clientes (
        reservas_id
    ASC );

CREATE UNIQUE INDEX clientes__idxv2 ON
    clientes (
        checksouts_id
    ASC );

CREATE UNIQUE INDEX clientes__idx ON
    clientes (
        cuentas_id
    ASC );

ALTER TABLE clientes ADD CONSTRAINT clientes_pk PRIMARY KEY ( documento );

CREATE TABLE cntasbares (
    cuentas_id   INTEGER NOT NULL,
    bares_nombre VARCHAR2(255) NOT NULL
);

ALTER TABLE cntasbares ADD CONSTRAINT cntasbares_pk PRIMARY KEY ( cuentas_id,
                                                                  bares_nombre );

CREATE TABLE cntasredes (
    internets_id INTEGER NOT NULL,
    cuentas_id   INTEGER NOT NULL
);

ALTER TABLE cntasredes ADD CONSTRAINT cntasredes_pk PRIMARY KEY ( internets_id,
                                                                  cuentas_id );

CREATE TABLE cntasres (
    cuentas_id            INTEGER NOT NULL,
    restaurantes_rests_id NUMBER NOT NULL
);

ALTER TABLE cntasres ADD CONSTRAINT cntasres_pk PRIMARY KEY ( cuentas_id,
                                                              restaurantes_rests_id );

CREATE TABLE cntasser (
    cuentas_id   INTEGER NOT NULL,
    servicios_id INTEGER NOT NULL
);

ALTER TABLE cntasser ADD CONSTRAINT cntasser_pk PRIMARY KEY ( cuentas_id,
                                                              servicios_id );

CREATE TABLE cntassupers (
    cuentas_id    INTEGER NOT NULL,
    supers_nombre VARCHAR2(255) NOT NULL
);

ALTER TABLE cntassupers ADD CONSTRAINT cntassupers_pk PRIMARY KEY ( cuentas_id,
                                                                    supers_nombre );

CREATE TABLE cntastiendas (
    cuentas_id      INTEGER NOT NULL,
    tiendas_nombre  VARCHAR2(255) NOT NULL,
    tiendas_nombre1 VARCHAR2(255) NOT NULL
);

ALTER TABLE cntastiendas
    ADD CONSTRAINT cntastiendas_pk PRIMARY KEY ( cuentas_id,
                                                 tiendas_nombre,
                                                 tiendas_nombre1 );

CREATE TABLE comodidades (
    comodidad       VARCHAR2(255),
    habitaciones_id INTEGER NOT NULL
);

ALTER TABLE comodidades ADD CONSTRAINT comodidades_pk PRIMARY KEY ( habitaciones_id );

CREATE TABLE cuentas (
    id                 INTEGER NOT NULL,
    consumo            INTEGER,
    valor              INTEGER,
    clientes_documento INTEGER NOT NULL
);

CREATE UNIQUE INDEX cuentas__idx ON
    cuentas (
        clientes_documento
    ASC );

ALTER TABLE cuentas ADD CONSTRAINT cuentas_pk PRIMARY KEY ( id );

CREATE TABLE cuentasspas (
    cuentas_id INTEGER NOT NULL,
    spas_id    INTEGER NOT NULL
);

ALTER TABLE cuentasspas ADD CONSTRAINT cuentasspas_pk PRIMARY KEY ( cuentas_id,
                                                                    spas_id );

CREATE TABLE empleados (
    documento      INTEGER NOT NULL,
    nombre         VARCHAR2(255),
    apellido       VARCHAR2(255),
    edad           INTEGER,
    cargo          VARCHAR2(255),
    salario        INTEGER,
    hoteles_nombre VARCHAR2(255) NOT NULL
);

ALTER TABLE empleados ADD CONSTRAINT empleados_pk PRIMARY KEY ( documento );

CREATE TABLE gimnasios (
    id             INTEGER NOT NULL,
    capacidad      INTEGER,
    horario        DATE,
    hoteles_nombre VARCHAR2(255) NOT NULL,
    fecha          DATE NOT NULL,
    semana         INTEGER
);

ALTER TABLE gimnasios ADD CONSTRAINT gimnasios_pk PRIMARY KEY ( id );

CREATE TABLE habitaciones (
    id                  INTEGER NOT NULL,
    tipo                VARCHAR2(255),
    capacidad           INTEGER,
    precio              INTEGER,
    consumo             INTEGER,
    hoteles_nombre      VARCHAR2(255) NOT NULL,
    porcentajeocupacion INTEGER
);

ALTER TABLE habitaciones ADD CONSTRAINT habitaciones_pk PRIMARY KEY ( id );

CREATE TABLE hoteles (
    nombre        VARCHAR2(255) NOT NULL,
    tipo          VARCHAR2(255) NOT NULL,
    ciudad        VARCHAR2(255),
    pais          VARCHAR2(255),
    internets_id  INTEGER NOT NULL,
    supers_nombre VARCHAR2(255) NOT NULL
);

CREATE UNIQUE INDEX hoteles__idx ON
    hoteles (
        internets_id
    ASC );

CREATE UNIQUE INDEX hoteles__idxv1 ON
    hoteles (
        supers_nombre
    ASC );

ALTER TABLE hoteles ADD CONSTRAINT hoteles_pk PRIMARY KEY ( nombre );

CREATE TABLE internets (
    id             INTEGER NOT NULL,
    costo          INTEGER,
    capacidad      INTEGER,
    hoteles_nombre VARCHAR2(255) NOT NULL,
    fecha          DATE NOT NULL,
    semana         INTEGER
);

CREATE UNIQUE INDEX internets__idx ON
    internets (
        hoteles_nombre
    ASC );

ALTER TABLE internets ADD CONSTRAINT internets_pk PRIMARY KEY ( id );

CREATE TABLE maquinas (
    nombre       VARCHAR2(255),
    gimnasios_id INTEGER NOT NULL
);

ALTER TABLE maquinas ADD CONSTRAINT maquinas_pk PRIMARY KEY ( gimnasios_id );

CREATE TABLE planesconsumo (
    id             INTEGER NOT NULL,
    tiempo         INTEGER,
    tipo           VARCHAR2(255),
    precio         INTEGER,
    promocion      VARCHAR2(255),
    beneficio      VARCHAR2(255),
    hoteles_nombre VARCHAR2(255) NOT NULL
);

ALTER TABLE planesconsumo ADD CONSTRAINT planesconsumo_pk PRIMARY KEY ( id );

CREATE TABLE platos (
    id                    INTEGER,
    nombre                VARCHAR2(255),
    costo                 INTEGER,
    restaurantes_rests_id NUMBER NOT NULL
);

CREATE TABLE pools (
    pools_id       NUMBER NOT NULL,
    id             INTEGER,
    capacidad      INTEGER,
    profundidad    INTEGER,
    horario        VARCHAR2(255),
    hoteles_nombre VARCHAR2(255) NOT NULL,
    fecha          DATE NOT NULL,
    semana         INTEGER
);

ALTER TABLE pools ADD CONSTRAINT piscinas_pk PRIMARY KEY ( pools_id );

CREATE TABLE prestamos (
    id             INTEGER NOT NULL,
    devuelto       NUMBER,
    malestado      NUMBER,
    hoteles_nombre VARCHAR2(255) NOT NULL,
    cuentas_id     INTEGER NOT NULL,
    fecha          DATE
);

ALTER TABLE prestamos ADD CONSTRAINT prestamos_pk PRIMARY KEY ( id );

CREATE TABLE productos (
    id            INTEGER NOT NULL,
    nombre        VARCHAR2(255),
    precio        INTEGER,
    supers_nombre VARCHAR2(255) NOT NULL
);

ALTER TABLE productos ADD CONSTRAINT productos_pk PRIMARY KEY ( id );

CREATE TABLE reservas (
    id                 INTEGER NOT NULL,
    numpersonas        INTEGER,
    fechaentrada       DATE,
    fechasalida        DATE,
    clientes_documento INTEGER NOT NULL
);

CREATE UNIQUE INDEX reservas__idx ON
    reservas (
        clientes_documento
    ASC );

ALTER TABLE reservas ADD CONSTRAINT reservas_pk PRIMARY KEY ( id );

CREATE TABLE reservasservicios (
    id                 INTEGER NOT NULL,
    habitacion         INTEGER,
    servicio           VARCHAR2(255),
    horainicio         VARCHAR2(255),
    horafin            VARCHAR2(255),
    clientes_documento INTEGER NOT NULL,
    fecha              DATE
);

ALTER TABLE reservasservicios ADD CONSTRAINT reservasservicios_pk PRIMARY KEY ( id );

CREATE TABLE restaurantes (
    nombre         VARCHAR2(255),
    estilo         VARCHAR2(255),
    capacidad      INTEGER,
    costo          INTEGER,
    costocargado   INTEGER,
    hoteles_nombre VARCHAR2(255) NOT NULL,
    rests_id       NUMBER NOT NULL,
    fecha          DATE,
    semana         INTEGER
);

ALTER TABLE restaurantes ADD CONSTRAINT rests_pk PRIMARY KEY ( rests_id );

CREATE TABLE salones (
    id             INTEGER NOT NULL,
    capacidad      INTEGER,
    costo          INTEGER,
    tienecostoad   NUMBER,
    costoad        INTEGER,
    tiempolimpieza INTEGER,
    hoteles_nombre VARCHAR2(255) NOT NULL,
    fecha          DATE NOT NULL,
    duracion       INTEGER NOT NULL,
    semana         INTEGER
);

ALTER TABLE salones ADD CONSTRAINT salones_pk PRIMARY KEY ( id );

CREATE TABLE semanas (
    semana                 INTEGER NOT NULL,
    bares_nombre           VARCHAR2(255) NOT NULL,
    tiendas_nombre         VARCHAR2(255) NOT NULL,
    tiendas_hoteles_nombre VARCHAR2(255) NOT NULL,
    internets_id           INTEGER NOT NULL,
    spas_id                INTEGER NOT NULL,
    supers_nombre          VARCHAR2(255) NOT NULL,
    servicios_id           INTEGER NOT NULL,
    salones_id             INTEGER NOT NULL,
    gimnasios_id           INTEGER NOT NULL,
    cuentas_id             INTEGER NOT NULL,
    pools_piscinas_id      NUMBER NOT NULL,
    restaurantes_rests_id  NUMBER NOT NULL
);

CREATE TABLE servicios (
    id             INTEGER NOT NULL,
    tipo           VARCHAR2(255),
    numprendas     INTEGER,
    costos         INTEGER,
    hoteles_nombre VARCHAR2(255) NOT NULL,
    nombre_1       VARCHAR2(255) NOT NULL,
    fecha          DATE NOT NULL,
    semana         INTEGER
);

ALTER TABLE servicios ADD CONSTRAINT servicios_pk PRIMARY KEY ( id );

CREATE TABLE spas (
    id             INTEGER NOT NULL,
    duracion       INTEGER,
    costo          INTEGER,
    consumo        INTEGER,
    horario        VARCHAR2(255),
    hoteles_nombre VARCHAR2(255) NOT NULL,
    fecha          DATE NOT NULL,
    semana         INTEGER
);

ALTER TABLE spas ADD CONSTRAINT spas_pk PRIMARY KEY ( id );

CREATE TABLE supers (
    nombre         VARCHAR2(255) NOT NULL,
    consumo        INTEGER NOT NULL,
    hoteles_nombre VARCHAR2(255) NOT NULL,
    fecha          DATE NOT NULL,
    semana         INTEGER
);

CREATE UNIQUE INDEX supers__idx ON
    supers (
        hoteles_nombre
    ASC );

ALTER TABLE supers ADD CONSTRAINT supers_pk PRIMARY KEY ( nombre );

CREATE TABLE tiendas (
    nombre         VARCHAR2(255) NOT NULL,
    tipo           VARCHAR2(255),
    consumo        INTEGER,
    hoteles_nombre VARCHAR2(255) NOT NULL,
    fecha          DATE NOT NULL,
    semana         INTEGER
);

ALTER TABLE tiendas ADD CONSTRAINT tiendas_pk PRIMARY KEY ( nombre,
                                                            hoteles_nombre );

ALTER TABLE acompañantes
    ADD CONSTRAINT acompañantes_clientes_fk FOREIGN KEY ( clientes_documento )
        REFERENCES clientes ( documento );

ALTER TABLE bares
    ADD CONSTRAINT bares_hoteles_fk FOREIGN KEY ( hoteles_nombre )
        REFERENCES hoteles ( nombre );

ALTER TABLE checksins
    ADD CONSTRAINT checksins_clientes_fk FOREIGN KEY ( clientes_documento )
        REFERENCES clientes ( documento );

ALTER TABLE checksins
    ADD CONSTRAINT checksins_empleados_fk FOREIGN KEY ( empleados_documento )
        REFERENCES empleados ( documento );

ALTER TABLE checksouts
    ADD CONSTRAINT checksouts_clientes_fk FOREIGN KEY ( clientes_documento )
        REFERENCES clientes ( documento );

ALTER TABLE checksouts
    ADD CONSTRAINT checksouts_empleados_fk FOREIGN KEY ( empleados_documento )
        REFERENCES empleados ( documento );

ALTER TABLE clientes
    ADD CONSTRAINT clientes_checksins_fk FOREIGN KEY ( checksins_id )
        REFERENCES checksins ( id );

ALTER TABLE clientes
    ADD CONSTRAINT clientes_checksouts_fk FOREIGN KEY ( checksouts_id )
        REFERENCES checksouts ( id );

ALTER TABLE clientes
    ADD CONSTRAINT clientes_hoteles_fk FOREIGN KEY ( hoteles_nombre )
        REFERENCES hoteles ( nombre );

ALTER TABLE clientes
    ADD CONSTRAINT clientes_reservas_fk FOREIGN KEY ( reservas_id )
        REFERENCES reservas ( id );

ALTER TABLE cntasbares
    ADD CONSTRAINT cntasbares_bares_fk FOREIGN KEY ( bares_nombre )
        REFERENCES bares ( nombre );

ALTER TABLE cntasbares
    ADD CONSTRAINT cntasbares_cuentas_fk FOREIGN KEY ( cuentas_id )
        REFERENCES cuentas ( id );

ALTER TABLE cntasredes
    ADD CONSTRAINT cntasredes_cuentas_fk FOREIGN KEY ( cuentas_id )
        REFERENCES cuentas ( id );

ALTER TABLE cntasredes
    ADD CONSTRAINT cntasredes_internets_fk FOREIGN KEY ( internets_id )
        REFERENCES internets ( id );

ALTER TABLE cntasres
    ADD CONSTRAINT cntasres_cuentas_fk FOREIGN KEY ( cuentas_id )
        REFERENCES cuentas ( id );

ALTER TABLE cntasres
    ADD CONSTRAINT cntasres_restaurantes_fk FOREIGN KEY ( restaurantes_rests_id )
        REFERENCES restaurantes ( rests_id );

ALTER TABLE cntasser
    ADD CONSTRAINT cntasser_cuentas_fk FOREIGN KEY ( cuentas_id )
        REFERENCES cuentas ( id );

ALTER TABLE cntasser
    ADD CONSTRAINT cntasser_servicios_fk FOREIGN KEY ( servicios_id )
        REFERENCES servicios ( id );

ALTER TABLE cntassupers
    ADD CONSTRAINT cntassupers_cuentas_fk FOREIGN KEY ( cuentas_id )
        REFERENCES cuentas ( id );

ALTER TABLE cntassupers
    ADD CONSTRAINT cntassupers_supers_fk FOREIGN KEY ( supers_nombre )
        REFERENCES supers ( nombre );

ALTER TABLE cntastiendas
    ADD CONSTRAINT cntastiendas_cuentas_fk FOREIGN KEY ( cuentas_id )
        REFERENCES cuentas ( id );

ALTER TABLE cntastiendas
    ADD CONSTRAINT cntastiendas_tiendas_fk FOREIGN KEY ( tiendas_nombre,
                                                         tiendas_nombre1 )
        REFERENCES tiendas ( nombre,
                             hoteles_nombre );

ALTER TABLE comodidades
    ADD CONSTRAINT comodidades_habitaciones_fk FOREIGN KEY ( habitaciones_id )
        REFERENCES habitaciones ( id );

ALTER TABLE cuentasspas
    ADD CONSTRAINT cuentasspas_cuentas_fk FOREIGN KEY ( cuentas_id )
        REFERENCES cuentas ( id );

ALTER TABLE cuentasspas
    ADD CONSTRAINT cuentasspas_spas_fk FOREIGN KEY ( spas_id )
        REFERENCES spas ( id );

ALTER TABLE empleados
    ADD CONSTRAINT empleados_hoteles_fk FOREIGN KEY ( hoteles_nombre )
        REFERENCES hoteles ( nombre );

ALTER TABLE gimnasios
    ADD CONSTRAINT gimnasios_hoteles_fk FOREIGN KEY ( hoteles_nombre )
        REFERENCES hoteles ( nombre );

ALTER TABLE habitaciones
    ADD CONSTRAINT habitaciones_hoteles_fk FOREIGN KEY ( hoteles_nombre )
        REFERENCES hoteles ( nombre );

ALTER TABLE hoteles
    ADD CONSTRAINT hoteles_internets_fk FOREIGN KEY ( internets_id )
        REFERENCES internets ( id );

ALTER TABLE hoteles
    ADD CONSTRAINT hoteles_supers_fk FOREIGN KEY ( supers_nombre )
        REFERENCES supers ( nombre );

ALTER TABLE internets
    ADD CONSTRAINT internets_hoteles_fk FOREIGN KEY ( hoteles_nombre )
        REFERENCES hoteles ( nombre );

ALTER TABLE maquinas
    ADD CONSTRAINT maquinas_gimnasios_fk FOREIGN KEY ( gimnasios_id )
        REFERENCES gimnasios ( id );

ALTER TABLE planesconsumo
    ADD CONSTRAINT planesconsumo_hoteles_fk FOREIGN KEY ( hoteles_nombre )
        REFERENCES hoteles ( nombre );

ALTER TABLE platos
    ADD CONSTRAINT platos_restaurantes_fk FOREIGN KEY ( restaurantes_rests_id )
        REFERENCES restaurantes ( rests_id );

ALTER TABLE pools
    ADD CONSTRAINT pools_hoteles_fk FOREIGN KEY ( hoteles_nombre )
        REFERENCES hoteles ( nombre );

ALTER TABLE prestamos
    ADD CONSTRAINT prestamos_cuentas_fk FOREIGN KEY ( cuentas_id )
        REFERENCES cuentas ( id );

ALTER TABLE prestamos
    ADD CONSTRAINT prestamos_hoteles_fk FOREIGN KEY ( hoteles_nombre )
        REFERENCES hoteles ( nombre );

ALTER TABLE productos
    ADD CONSTRAINT productos_supers_fk FOREIGN KEY ( supers_nombre )
        REFERENCES supers ( nombre );

ALTER TABLE reservas
    ADD CONSTRAINT reservas_clientes_fk FOREIGN KEY ( clientes_documento )
        REFERENCES clientes ( documento );

ALTER TABLE reservasservicios
    ADD CONSTRAINT reservasservicios_clientes_fk FOREIGN KEY ( clientes_documento )
        REFERENCES clientes ( documento );

ALTER TABLE restaurantes
    ADD CONSTRAINT restaurantes_hoteles_fk FOREIGN KEY ( hoteles_nombre )
        REFERENCES hoteles ( nombre );

ALTER TABLE salones
    ADD CONSTRAINT salones_hoteles_fk FOREIGN KEY ( hoteles_nombre )
        REFERENCES hoteles ( nombre );

ALTER TABLE semanas
    ADD CONSTRAINT semanas_bares_fk FOREIGN KEY ( bares_nombre )
        REFERENCES bares ( nombre );

ALTER TABLE semanas
    ADD CONSTRAINT semanas_cuentas_fk FOREIGN KEY ( cuentas_id )
        REFERENCES cuentas ( id );

ALTER TABLE semanas
    ADD CONSTRAINT semanas_gimnasios_fk FOREIGN KEY ( gimnasios_id )
        REFERENCES gimnasios ( id );

ALTER TABLE semanas
    ADD CONSTRAINT semanas_internets_fk FOREIGN KEY ( internets_id )
        REFERENCES internets ( id );

ALTER TABLE semanas
    ADD CONSTRAINT semanas_pools_fk FOREIGN KEY ( pools_piscinas_id )
        REFERENCES pools ( pools_id );

ALTER TABLE semanas
    ADD CONSTRAINT semanas_restaurantes_fk FOREIGN KEY ( restaurantes_rests_id )
        REFERENCES restaurantes ( rests_id );

ALTER TABLE semanas
    ADD CONSTRAINT semanas_salones_fk FOREIGN KEY ( salones_id )
        REFERENCES salones ( id );

ALTER TABLE semanas
    ADD CONSTRAINT semanas_servicios_fk FOREIGN KEY ( servicios_id )
        REFERENCES servicios ( id );

ALTER TABLE semanas
    ADD CONSTRAINT semanas_spas_fk FOREIGN KEY ( spas_id )
        REFERENCES spas ( id );

ALTER TABLE semanas
    ADD CONSTRAINT semanas_supers_fk FOREIGN KEY ( supers_nombre )
        REFERENCES supers ( nombre );

ALTER TABLE semanas
    ADD CONSTRAINT semanas_tiendas_fk FOREIGN KEY ( tiendas_nombre,
                                                    tiendas_hoteles_nombre )
        REFERENCES tiendas ( nombre,
                             hoteles_nombre );

ALTER TABLE servicios
    ADD CONSTRAINT servicios_hoteles_fk FOREIGN KEY ( hoteles_nombre )
        REFERENCES hoteles ( nombre );

ALTER TABLE spas
    ADD CONSTRAINT spas_hoteles_fk FOREIGN KEY ( hoteles_nombre )
        REFERENCES hoteles ( nombre );

ALTER TABLE supers
    ADD CONSTRAINT supers_hoteles_fk FOREIGN KEY ( hoteles_nombre )
        REFERENCES hoteles ( nombre );

ALTER TABLE tiendas
    ADD CONSTRAINT tiendas_hoteles_fk FOREIGN KEY ( hoteles_nombre )
        REFERENCES hoteles ( nombre );

CREATE SEQUENCE pools_pools_id_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER pools_pools_id_trg BEFORE
    INSERT ON pools
    FOR EACH ROW
    WHEN ( new.pools_id IS NULL )
BEGIN
    :new.pools_id := pools_pools_id_seq.nextval;
END;
/

CREATE SEQUENCE rests_rests_id_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER rests_rests_id_trg BEFORE
    INSERT ON restaurantes
    FOR EACH ROW
    WHEN ( new.rests_id IS NULL )
BEGIN
    :new.rests_id := rests_rests_id_seq.nextval;
END;
/



-- Informe de Resumen de Oracle SQL Developer Data Modeler: 
-- 
-- CREATE TABLE                            34
-- CREATE INDEX                            12
-- ALTER TABLE                             89
-- CREATE VIEW                              0
-- ALTER VIEW                               0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           2
-- ALTER TRIGGER                            0
-- CREATE COLLECTION TYPE                   0
-- CREATE STRUCTURED TYPE                   0
-- CREATE STRUCTURED TYPE BODY              0
-- CREATE CLUSTER                           0
-- CREATE CONTEXT                           0
-- CREATE DATABASE                          0
-- CREATE DIMENSION                         0
-- CREATE DIRECTORY                         0
-- CREATE DISK GROUP                        0
-- CREATE ROLE                              0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE SEQUENCE                          2
-- CREATE MATERIALIZED VIEW                 0
-- CREATE MATERIALIZED VIEW LOG             0
-- CREATE SYNONYM                           0
-- CREATE TABLESPACE                        0
-- CREATE USER                              0
-- 
-- DROP TABLESPACE                          0
-- DROP DATABASE                            0
-- 
-- REDACTION POLICY                         0
-- TSDP POLICY                              0
-- 
-- ORDS DROP SCHEMA                         0
-- ORDS ENABLE SCHEMA                       0
-- ORDS ENABLE OBJECT                       0
-- 
-- ERRORS                                   0
-- WARNINGS                                 0
