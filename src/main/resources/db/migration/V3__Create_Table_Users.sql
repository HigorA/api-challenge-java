create table users (
    id_user bigint not null auto_increment,
    account_non_expired bit,
    account_non_locked bit,
    credentials_non_expired bit,
    email varchar(255),
    enabled bit,
    name varchar(255),
    password varchar(255),
    primary key (id_user)
)
;