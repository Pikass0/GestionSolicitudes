
create table CATEGORIAS (
        ID_CATEGORIA bigint generated by default as identity (start with 1),
        CATEGORIA varchar(55),
        primary key (ID_CATEGORIA)
);

create table INTERESADOS (
        ID_INTERESADO bigint generated by default as identity (start with 1),
        NOMBRE varchar(55) NOT NULL,
        APELLIDOS varchar(75),
        EMPRESA varchar(75),
        E_MAIL varchar(45),
        MOVIL char(9),
        TELEFONO char(9),
        PROVINCIA varchar(60),
        FECHA_ALTA date ,
        ENVIAR_NOTIFICACIONES SMALLINT NOT NULL DEFAULT 1,
     VERSION int DEFAULT 1,
        primary key (ID_INTERESADO)
    );

create table SOLICITUDES_INFO  (
        ID_SOLICITUD bigint generated by default as identity (start with 1),
        FECHA_SOLICITUD date NOT NULL,
        ID_INTERESADO bigint NOT NULL,
        ID_CATEGORIA bigint NOT NULL,
        ACTIVO  int not null default 1,
        VERSION int default 1,
        primary key (ID_SOLICITUD)
    );

 alter table SOLICITUDES_INFO
        add constraint FK_SOLIC_INTERESADOS
        foreign key (ID_INTERESADO)
        references INTERESADOS;
 alter table SOLICITUDES_INFO
        add constraint FK_SOLIC_CAT
        foreign key (ID_CATEGORIA)
        references CATEGORIAS;

