create table if not exists users (
    user_id char(36) primary key not null unique,
    email varchar(255) not null unique,
    password varchar(50) not null,
    full_name varchar(100) not null,
    user_name varchar(15) not null unique,
    role text not null
);