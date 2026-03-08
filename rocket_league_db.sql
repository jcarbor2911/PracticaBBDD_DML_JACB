-- Base de datos: rocket_league_db
-- Modelo: ARENA 1:N PARTIDA

drop database if exists rocket_league_db;
create database rocket_league_db;
use rocket_league_db;

-- DDL
create table arena (
    id_arena bigint primary key,
    nombre varchar(255) not null,
    tematica varchar(255),
    capacidad_jugadores int not null,
    clima_visual varchar(255)
);

create table partida (
    id_partida bigint primary key,
    fecha_hora datetime not null,
    duracion_minutos int not null,
    marcador_final varchar(255),
    modo_juego varchar(255),
    id_arena bigint not null,
    constraint fk_partida_arena foreign key (id_arena) references arena(id_arena)
);


-- Inserts en ARENA
INSERT INTO arena (id_arena, nombre, tematica, capacidad_jugadores, clima_visual) VALUES
(1, 'DFH Stadium', 'Estadio competitivo', 8, 'Despejado'),
(2, 'Mannfield', 'Campo urbano', 8, 'Atardecer'),
(3, 'Champions Field', 'Final profesional', 8, 'Nocturno'),
(4, 'Beckwith Park', 'Parque verde', 8, 'Soleado'),
(5, 'Utopia Coliseum', 'Coliseo futurista', 8, 'Cubierto'),
(6, 'Neo Tokyo', 'Ciudad cyberpunk', 8, 'Lluvioso'),
(7, 'Urban Central', 'Centro metropolitano', 8, 'Nublado'),
(8, 'Forbidden Temple', 'Templo oriental', 8, 'Amanecer'),
(9, 'Farmstead', 'Entorno rural', 8, 'Ventoso'),
(10, 'Salty Shores', 'Playa tropical', 8, 'Veraniego');


-- Inserts en PARTIDA
INSERT INTO partida (id_partida, fecha_hora, duracion_minutos, marcador_final, modo_juego, id_arena) VALUES
(1, '2026-03-01 18:00:00', 5, '3-2', '3v3 Estandar', 1),
(2, '2026-03-01 18:20:00', 6, '4-3', '2v2 Dobles', 2),
(3, '2026-03-01 18:45:00', 5, '2-1', '1v1 Duelo', 3),
(4, '2026-03-02 17:30:00', 7, '5-4', 'Rumble', 4),
(5, '2026-03-02 18:10:00', 5, '6-2', 'Hoops', 5),
(6, '2026-03-02 18:40:00', 6, '2-0', 'Snow Day', 6),
(7, '2026-03-03 19:00:00', 5, '3-3', 'Dropshot', 7),
(8, '2026-03-03 19:25:00', 8, '4-3', '3v3 Estandar', 8),
(9, '2026-03-03 19:50:00', 5, '1-0', '2v2 Dobles', 9),
(10, '2026-03-04 20:15:00', 6, '5-1', '1v1 Duelo', 10);


-- Consultas de prueba
select * from arena;
select * from partida;

select 
    p.id_partida,
    p.fecha_hora,
    p.duracion_minutos,
    p.marcador_final,
    p.modo_juego,
    a.nombre as nombre_arena,
    a.tematica,
    a.clima_visual
from partida p
inner join arena a
    on p.id_arena = a.id_arena;
