create table favorites (
    id_favorite bigint not null auto_increment,
    title varchar(255),
    url varchar(11400),
    id_user bigint not null,
    primary key (id_favorite)
);
