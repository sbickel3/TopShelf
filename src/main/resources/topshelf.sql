
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
    firstname   varchar2(30) not null,
    lastname    varchar2(30) not null,
    email       varchar2(30) unique not null,
    username    varchar2(30) unique not null, 
    password    varchar2(30) not null,
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
    name        varchar2(30) not null,
    instruction clob not null,
    photo       blob,
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
    chef_id     number not null,
    recipe_id   number not null,
    foreign key (chef_id) references Chef(id),
    foreign key (recipe_id) references Recipe(id),
    constraint unique_chef_cookbook unique (chef_id, recipe_id)
    );


    update Fridge
set ingredient = utl_raw.cast_to_raw('
{
    "flour": {
        "quantity": "2",
        "unit": "cup",
        "ingredient": "flour"
    },
    "olive oil": {
        "quantity": "1/2",
        "unit": "teaspoon",
        "ingredient": "olive oil"
    }
}')

where id = 32;

update GroceryList
set ingredient = utl_raw.cast_to_raw('
{
    "flour": {
        "quantity": "2",
        "unit": "cup",
        "ingredient": "flour"
    },
    "olive oil": {
        "quantity": "1/2",
        "unit": "teaspoon",
        "ingredient": "olive oil"
    }
}')

where id = 32;


commit;