--changeset Marin:Create.database
create table users (
    id serial primary key,
    name varchar not null,
    username varchar not null unique,
    password varchar not null,
    bio varchar,
    active bool not null default true
);

create table social_network (
    id serial primary key,
    ico varchar not null,
    name varchar not null unique,
    prefix varchar
);

create table social_network_link (
    user_id int,
    social_network_id int,
    link varchar not null,
    primary key (user_id, social_network_id),
    foreign key (user_id) references users (id),
    foreign key (social_network_id) references social_network (id)
);

create table language (
    id serial primary key ,
    name varchar not null
);

create table user_language (
    user_id int,
    language_id int,
    level varchar not null ,
    primary key (user_id, language_id),
    foreign key (user_id) references users (id),
    foreign key (language_id) references language (id)
);

create table contact_type (
    code varchar primary key ,
    description varchar,
    ico varchar not null
);

create table contacts (
    id serial primary key ,
    user_id int not null ,
    value varchar not null unique ,
    type varchar not null ,
    foreign key (user_id) references users (id),
    foreign key (type) references contact_type (code)
);