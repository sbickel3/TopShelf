
create table Fridge (
    id          number primary key,
    ingredient  blob,
    constraint fridge_json check (ingredient is JSON)
);

CREATE SEQUENCE fridge_id_seq
    MINVALUE 1
    MAXVALUE 99999999999
    INCREMENT BY 1
    START WITH 1;

create table GroceryList (
    id          number primary key,
    ingredient  blob, 
    constraint grocery_json check (ingredient is JSON)
);

CREATE SEQUENCE grocery_id_seq
    MINVALUE 1
    MAXVALUE 99999999999
    INCREMENT BY 1
    START WITH 1;


create table Chef (
    id          number primary key,
    firstname   varchar2(300) not null,
    lastname    varchar2(300) not null,
    email       varchar2(300) unique not null,
    username    varchar2(300) unique not null, 
    password    varchar2(300) not null,
    fridge_id   number unique not null,
    grocery_id  number unique not null,
    constraint fridge_id_fk foreign key (fridge_id) references Fridge (id),
    constraint grocery_id_fk foreign key (grocery_id) references GroceryList (id)  
);

CREATE SEQUENCE chef_id_seq
    MINVALUE 1
    MAXVALUE 99999999999
    INCREMENT BY 1
    START WITH 1;


create table Recipe (
    id          number primary key,
    name        varchar2(300) not null,
    instruction varchar2(4000) not null,
    photo       varchar2(4000),
    chef_id     number unique not null, 
    ingredient  blob not null, 
    constraint recipe_json check (ingredient is JSON),
    constraint chef_id_fk foreign key (chef_id) references Chef (id)  
);

CREATE SEQUENCE recipe_id_seq
    MINVALUE 1
    MAXVALUE 99999999999
    INCREMENT BY 1
    START WITH 1;
    
create table CookBook (
    cookbook_id number primary key,
    chef_id     number not null,
    recipe_id   number not null,
    foreign key (chef_id) references Chef(id),
    foreign key (recipe_id) references Recipe(id),
    constraint unique_chef_cookbook unique (chef_id, recipe_id)
    );


commit;