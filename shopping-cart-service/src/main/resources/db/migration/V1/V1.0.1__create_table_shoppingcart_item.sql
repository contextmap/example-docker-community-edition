create table shopping_cart_item (
    id varchar(36) not null,
    shopping_cart_id varchar(36) not null,
    inventory_item_id varchar(255) not null,
    amount integer not null,
    created_on timestamp not null,
    last_modified_on timestamp not null
);

alter table shopping_cart_item add constraint pk_shopping_cart_item primary key (id);
alter table shopping_cart_item add constraint uk_item unique (shopping_cart_id, inventory_item_id);
alter table shopping_cart_item add constraint fk_item_to_cart foreign key (shopping_cart_id) references shopping_cart (id);
