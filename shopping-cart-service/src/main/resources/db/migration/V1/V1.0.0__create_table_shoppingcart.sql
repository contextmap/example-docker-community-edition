create table shopping_cart (
    id varchar(36) not null,
    user_id varchar(255) not null,
    created_on timestamp not null,
    last_modified_on timestamp not null
);

alter table shopping_cart add constraint pk_shopping_cart primary key (id);
alter table shopping_cart add constraint uk_user unique (user_id);
