insert into product_category (id, name, description) values(1, 'footwear', 'adidas casuals');
insert into product_category (id, name, description) values(2, 'footwear', 'nike casuals');


insert into product_inventory (id, quantity) values(1, 10);
insert into product_inventory (id, quantity) values(2, 10);


insert into product (id, name, description, category_id,inventory_id, price) values (1, 'dem','demo',1,1,2000);