--- SQL Hoteles
-- Gabriela Soler, Silvana Sandoval, Santiago Celis
-- Creacion del secuenciador
create sequence hoteles_sequence;

CREATE TABLE acompanantes (
    idacompanante      NUMBER NOT NULL,
    clientes_documento NUMBER NOT NULL
);

ALTER TABLE acompanantes ADD CONSTRAINT acompanantes_pk PRIMARY KEY ( idacompanante,
                                                                      clientes_documento );

CREATE TABLE bares (
    nombre         VARCHAR2(255) NOT NULL,
    estilo         VARCHAR2(255),
    costo          NUMBER,
    capacidad      NUMBER,
    costocargado   NUMBER,
    hoteles_nombre VARCHAR2(255) NOT NULL
);

ALTER TABLE bares ADD CONSTRAINT bares_pk PRIMARY KEY ( nombre );

CREATE TABLE checksins (
    id                  NUMBER NOT NULL,
    documentocliente    NUMBER,
    dia                 DATE,
    realizadopor        VARCHAR2(255),
    cuentaabierta       NUMBER,
    clientes_documento  NUMBER NOT NULL,
    empleados_documento NUMBER NOT NULL
);

CREATE UNIQUE INDEX checksins__idx ON
    checksins (
        clientes_documento
    ASC );

ALTER TABLE checksins ADD CONSTRAINT checksins_pk PRIMARY KEY ( id );

CREATE TABLE checksouts (
    id                  NUMBER NOT NULL,
    dia                 DATE,
    cuentaabierta       NUMBER,
    cuentatotal         NUMBER,
    pagocuenta          NUMBER,
    clientes_documento  NUMBER NOT NULL,
    empleados_documento NUMBER NOT NULL
);

CREATE UNIQUE INDEX checksouts__idx ON
    checksouts (
        clientes_documento
    ASC );

ALTER TABLE checksouts ADD CONSTRAINT checksouts_pk PRIMARY KEY ( id );

CREATE TABLE clientes (
    nombre         VARCHAR2(255) NOT NULL,
    apellido       VARCHAR2(255) NOT NULL,
    documento      NUMBER NOT NULL,
    edad           NUMBER,
    habitacion     NUMBER,
    consumo        NUMBER,
    hoteles_nombre VARCHAR2(255) NOT NULL,
    checksins_id   NUMBER NOT NULL,
    checksouts_id  NUMBER NOT NULL,
    reservas_id    NUMBER NOT NULL
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

ALTER TABLE clientes ADD CONSTRAINT clientes_pk PRIMARY KEY ( documento );

CREATE TABLE cntasbares (
    cuentas_id   NUMBER NOT NULL,
    bares_nombre VARCHAR2(255) NOT NULL
);

ALTER TABLE cntasbares ADD CONSTRAINT cntasbares_pk PRIMARY KEY ( cuentas_id,
                                                                  bares_nombre );

CREATE TABLE cntasredes (
    internets_id NUMBER NOT NULL,
    cuentas_id   NUMBER NOT NULL
);

ALTER TABLE cntasredes ADD CONSTRAINT cntasredes_pk PRIMARY KEY ( internets_id,
                                                                  cuentas_id );

CREATE TABLE cntasres (
    cuentas_id            NUMBER NOT NULL,
    restaurantes_rests_id NUMBER NOT NULL
);

ALTER TABLE cntasres ADD CONSTRAINT cntasres_pk PRIMARY KEY ( cuentas_id,
                                                              restaurantes_rests_id );

CREATE TABLE cntasser (
    cuentas_id   NUMBER NOT NULL,
    servicios_id NUMBER NOT NULL
);

ALTER TABLE cntasser ADD CONSTRAINT cntasser_pk PRIMARY KEY ( cuentas_id,
                                                              servicios_id );

CREATE TABLE cntassupers (
    cuentas_id    NUMBER NOT NULL,
    supers_nombre VARCHAR2(255) NOT NULL
);

ALTER TABLE cntassupers ADD CONSTRAINT cntassupers_pk PRIMARY KEY ( cuentas_id,
                                                                    supers_nombre );

CREATE TABLE cntastiendas (
    cuentas_id      NUMBER NOT NULL,
    tiendas_nombre  VARCHAR2(255) NOT NULL,
    tiendas_nombre1 VARCHAR2(255) NOT NULL
);

ALTER TABLE cntastiendas
    ADD CONSTRAINT cntastiendas_pk PRIMARY KEY ( cuentas_id,
                                                 tiendas_nombre,
                                                 tiendas_nombre1 );

CREATE TABLE comodidades (
    comodidad       VARCHAR2(255),
    habitaciones_id NUMBER NOT NULL
);

CREATE TABLE cuentas (
    id                 NUMBER NOT NULL,
    consumo            NUMBER,
    valor              NUMBER,
    clientes_documento NUMBER NOT NULL
);

CREATE UNIQUE INDEX cuentas__idx ON
    cuentas (
        clientes_documento
    ASC );

ALTER TABLE cuentas ADD CONSTRAINT cuentas_pk PRIMARY KEY ( id );

CREATE TABLE cuentasspas (
    cuentas_id NUMBER NOT NULL,
    spas_id    NUMBER NOT NULL
);

ALTER TABLE cuentasspas ADD CONSTRAINT cuentasspas_pk PRIMARY KEY ( cuentas_id,
                                                                    spas_id );

CREATE TABLE empleados (
    documento      NUMBER NOT NULL,
    nombre         VARCHAR2(255),
    apellido       VARCHAR2(255),
    edad           NUMBER,
    cargo          VARCHAR2(255),
    salario        NUMBER,
    hoteles_nombre VARCHAR2(255) NOT NULL
);

ALTER TABLE empleados ADD CONSTRAINT empleados_pk PRIMARY KEY ( documento );

CREATE TABLE gimnasios (
    id             NUMBER NOT NULL,
    capacidad      NUMBER,
    horario        DATE,
    hoteles_nombre VARCHAR2(255) NOT NULL
);

ALTER TABLE gimnasios ADD CONSTRAINT gimnasios_pk PRIMARY KEY ( id );

CREATE TABLE habitaciones (
    id             NUMBER NOT NULL,
    tipo           VARCHAR2(255),
    capacidad      NUMBER,
    precio         NUMBER,
    consumo        NUMBER,
    hoteles_nombre VARCHAR2(255) NOT NULL
);

ALTER TABLE habitaciones ADD CONSTRAINT habitaciones_pk PRIMARY KEY ( id );

CREATE TABLE hoteles (
    nombre        VARCHAR2(255) NOT NULL,
    tipo          VARCHAR2(255) NOT NULL,
    ciudad        VARCHAR2(255),
    pais          VARCHAR2(255),
    internets_id  NUMBER NOT NULL,
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
    id             NUMBER NOT NULL,
    costo          NUMBER,
    capacidad      NUMBER,
    hoteles_nombre VARCHAR2(255) NOT NULL
);

CREATE UNIQUE INDEX internets__idx ON
    internets (
        hoteles_nombre
    ASC );

ALTER TABLE internets ADD CONSTRAINT internets_pk PRIMARY KEY ( id );

CREATE TABLE maquinas (
    nombre       VARCHAR2(255),
    gimnasios_id NUMBER NOT NULL
);

ALTER TABLE maquinas ADD CONSTRAINT maquinas_pk PRIMARY KEY ( gimnasios_id );

CREATE TABLE piscinas (
    id             NUMBER,
    capacidad      NUMBER,
    profundidad    NUMBER,
    horario        VARCHAR2(255),
    hoteles_nombre VARCHAR2(255) NOT NULL
);

CREATE TABLE planesconsumo (
    id             NUMBER NOT NULL,
    tiempo         NUMBER,
    tipo           VARCHAR2(255),
    precio         NUMBER,
    promocion      VARCHAR2(255),
    beneficio      VARCHAR2(255),
    hoteles_nombre VARCHAR2(255) NOT NULL
);

ALTER TABLE planesconsumo ADD CONSTRAINT planesconsumo_pk PRIMARY KEY ( id );

CREATE TABLE platos (
    id                    NUMBER,
    nombre                VARCHAR2(255),
    costo                 NUMBER,
    restaurantes_rests_id NUMBER NOT NULL
);

CREATE TABLE prestamos (
    id             NUMBER NOT NULL,
    devuelto       NUMBER,
    malestado      NUMBER,
    hoteles_nombre VARCHAR2(255) NOT NULL,
    cuentas_id     NUMBER NOT NULL
);

ALTER TABLE prestamos ADD CONSTRAINT prestamos_pk PRIMARY KEY ( id );

CREATE TABLE productos (
    id            NUMBER NOT NULL,
    nombre        VARCHAR2(255),
    precio        NUMBER,
    supers_nombre VARCHAR2(255) NOT NULL
);

ALTER TABLE productos ADD CONSTRAINT productos_pk PRIMARY KEY ( id );

CREATE TABLE reservas (
    id                 NUMBER NOT NULL,
    numpersonas        NUMBER,
    fechaentrada       DATE,
    fechasalida        DATE,
    clientes_documento NUMBER NOT NULL
);

CREATE UNIQUE INDEX reservas__idx ON
    reservas (
        clientes_documento
    ASC );

ALTER TABLE reservas ADD CONSTRAINT reservas_pk PRIMARY KEY ( id );

CREATE TABLE reservasservicios (
    id                 NUMBER NOT NULL,
    habitacion         NUMBER,
    servicio           VARCHAR2(255),
    horainicio         VARCHAR2(255),
    horafin            VARCHAR2(255),
    clientes_documento NUMBER NOT NULL
);

ALTER TABLE reservasservicios ADD CONSTRAINT reservasservicios_pk PRIMARY KEY ( id );

CREATE TABLE restaurantes (
    nombre         VARCHAR2(255),
    estilo         VARCHAR2(255),
    capacidad      NUMBER,
    costo          NUMBER,
    costocargado   NUMBER,
    hoteles_nombre VARCHAR2(255) NOT NULL,
    rests_id       NUMBER NOT NULL
);

ALTER TABLE restaurantes ADD CONSTRAINT rests_pk PRIMARY KEY ( rests_id );

CREATE TABLE salones (
    id             NUMBER NOT NULL,
    capacidad      NUMBER,
    costo          NUMBER,
    tienecostoad   NUMBER,
    costoad        NUMBER,
    tiempolimpieza DATE,
    hoteles_nombre VARCHAR2(255) NOT NULL
);

ALTER TABLE salones ADD CONSTRAINT salones_pk PRIMARY KEY ( id );

CREATE TABLE servicios (
    id             NUMBER NOT NULL,
    tipo           VARCHAR2(255),
    numprendas     NUMBER,
    costos         NUMBER,
    hoteles_nombre VARCHAR2(255) NOT NULL
);

ALTER TABLE servicios ADD CONSTRAINT servicios_pk PRIMARY KEY ( id );

CREATE TABLE spas (
    id             NUMBER NOT NULL,
    duracion       NUMBER,
    costo          NUMBER,
    consumo        NUMBER,
    horario        VARCHAR2(255),
    hoteles_nombre VARCHAR2(255) NOT NULL
);

ALTER TABLE spas ADD CONSTRAINT spas_pk PRIMARY KEY ( id );

CREATE TABLE supers (
    nombre         VARCHAR2(255) NOT NULL,
    consumo        NUMBER NOT NULL,
    hoteles_nombre VARCHAR2(255) NOT NULL
);

CREATE UNIQUE INDEX supers__idx ON
    supers (
        hoteles_nombre
    ASC );

ALTER TABLE supers ADD CONSTRAINT supers_pk PRIMARY KEY ( nombre );

CREATE TABLE tiendas (
    nombre         VARCHAR2(255) NOT NULL,
    tipo           VARCHAR2(255),
    consumo        NUMBER,
    hoteles_nombre VARCHAR2(255) NOT NULL
);

ALTER TABLE tiendas ADD CONSTRAINT tiendas_pk PRIMARY KEY ( nombre,
                                                            hoteles_nombre );

ALTER TABLE acompanantes
    ADD CONSTRAINT acompanantes_clientes_fk FOREIGN KEY ( clientes_documento )
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

ALTER TABLE cuentas
    ADD CONSTRAINT cuentas_clientes_fk FOREIGN KEY ( clientes_documento )
        REFERENCES clientes ( documento );

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

ALTER TABLE piscinas
    ADD CONSTRAINT piscinas_hoteles_fk FOREIGN KEY ( hoteles_nombre )
        REFERENCES hoteles ( nombre );

ALTER TABLE planesconsumo
    ADD CONSTRAINT planesconsumo_hoteles_fk FOREIGN KEY ( hoteles_nombre )
        REFERENCES hoteles ( nombre );

ALTER TABLE platos
    ADD CONSTRAINT platos_restaurantes_fk FOREIGN KEY ( restaurantes_rests_id )
        REFERENCES restaurantes ( rests_id );

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

CREATE SEQUENCE rests_rests_id_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER rests_rests_id_trg BEFORE
    INSERT ON restaurantes
    FOR EACH ROW
    WHEN ( new.rests_id IS NULL )
BEGIN
    :new.rests_id := rests_rests_id_seq.nextval;
END;