--docker run --name dockerspringdb -e "MYSQL_ROOT_PASSWORD=pass" -e "MYSQL_DATABASE=springdb" -p 3306:3306 -d mariadb --log-bin --binlog-format=MIXED
drop table if exists entidad_uno;
drop table if exists categoria;

create table categoria (
    id int primary key auto_increment,
    nombre varchar(30) not null,
    descripcion varchar(200)
);

create table entidad_uno (
    id int primary key auto_increment,
    nombre varchar(30) not null,
    descripcion varchar(200),
    categoria_id int not null,
    foreign key (categoria_id) references categoria(id)
);