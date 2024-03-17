create table shopping_cart (
    shopping_cart_id varchar(36) not null,
    user_id varchar(255) not null
);

alter table shopping_cart add constraint pk_shopping_cart primary key (shopping_cart_id);
alter table shopping_cart add constraint uk_user unique (user_id);
