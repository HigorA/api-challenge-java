alter table user_permission add constraint FKo47t1we6do84ku6rb9jcey2s9 foreign key (id_permission) references permission (id_permission);
alter table user_permission add constraint FKprpp02ivhe66b5nrc0a3a4lk8 foreign key (id_user) references users (id_user);
