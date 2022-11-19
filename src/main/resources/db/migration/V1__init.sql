create table  products(id bigserial primary key, title varchar(255), price int);
insert into products(title, price) values('Молоко', 2),('Хлеб', 2),('Конфеты', 15),('Яблоко', 5),('Кофе', 20),('Чай', 3),('Помидор', 2),('Огурец', 1),('Колбаса', 20),('Кефир', 2),('Яйцо', 3),('Крупа манная', 3),('Крупа гречневая', 4),('Фарш', 5),('Масло', 7),('Банан', 4),('Апельсин', 4),('Виноград', 7),('Перец', 3),('Маргарин', 2),('Соль', 1),('Сахар', 3);
create table users (id bigserial primary key, name varchar(255) not null, password varchar(80) not null);
insert into users (name, password)values('user', '$2a$04$Fx/SX9.BAvtPlMyIIqqFx.hLY2Xp8nnhpzvEEVINvVpwIPbA3v/.i'),('admin','$2a$04$Fx/SX9.BAvtPlMyIIqqFx.hLY2Xp8nnhpzvEEVINvVpwIPbA3v/.i');
create table roles (id bigserial primary key, name varchar(255) not null);
create table users_roles (user_id bigint not null, role_id int not null,primary key (user_id, role_id), foreign key (user_id) references users (id), foreign key (role_id) references roles (id));
insert into roles (name) values('ROLE_MANAGER'),('ROLE_ADMIN');
insert into users_roles (user_id, role_id)values(1, 1),(2,2);