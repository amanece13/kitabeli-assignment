insert into product_category (name, created_at ,modified_at, description) values('beauty', CURRENT_TIME(),CURRENT_TIME() ,'Beauty Products');
insert into product_category (name, created_at ,modified_at, description) values('books' , CURRENT_TIME(),CURRENT_TIME() , 'Readers digest');
insert into product_category (name, created_at ,modified_at, description) values('electronics', CURRENT_TIME(),CURRENT_TIME() , 'Electronic appliances');
insert into product_category (name, created_at ,modified_at, description) values('furniture', CURRENT_TIME(),CURRENT_TIME() , 'Furniture at home and work');
insert into product_category (name, created_at ,modified_at, description) values('kitchen', CURRENT_TIME(),CURRENT_TIME() , 'Accessories for your kitchen');
insert into product_category (name, created_at ,modified_at, description) values('jewellery', CURRENT_TIME(),CURRENT_TIME() , 'Jewellery for every ocassion');
insert into product_category (name, created_at ,modified_at, description) values('music', CURRENT_TIME(),CURRENT_TIME() , 'Music for every mood');
insert into product_category (name, created_at ,modified_at, description) values('watches', CURRENT_TIME(),CURRENT_TIME() , 'Cool wrist watches');
insert into product_category (name, created_at ,modified_at, description) values('grocery', CURRENT_TIME(),CURRENT_TIME() , 'Everything required for your hunger');
insert into product_category (name, created_at ,modified_at, description) values('footwear', CURRENT_TIME(),CURRENT_TIME() , 'Stare at the shoes');
insert into product_category (name, created_at ,modified_at, description) values('clothing', CURRENT_TIME(),CURRENT_TIME() , 'Rich and comfortable apparels');
insert into product_category (name, created_at ,modified_at, description) values('baby', CURRENT_TIME(),CURRENT_TIME() , 'Baby products');


insert into product_inventory (created_at ,modified_at, quantity) values(CURRENT_TIME(),CURRENT_TIME() , 100);
insert into product_inventory (created_at ,modified_at, quantity) values(CURRENT_TIME(),CURRENT_TIME() , 160);
insert into product_inventory (created_at ,modified_at, quantity) values(CURRENT_TIME(),CURRENT_TIME() ,50);
insert into product_inventory (created_at ,modified_at, quantity) values(CURRENT_TIME(),CURRENT_TIME() ,76);
insert into product_inventory (created_at ,modified_at, quantity) values(CURRENT_TIME(),CURRENT_TIME() ,20);
insert into product_inventory (created_at ,modified_at, quantity) values(CURRENT_TIME(),CURRENT_TIME() ,89);
insert into product_inventory (created_at ,modified_at, quantity) values(CURRENT_TIME(),CURRENT_TIME() ,65);
insert into product_inventory (created_at ,modified_at, quantity) values(CURRENT_TIME(),CURRENT_TIME() ,101);
insert into product_inventory (created_at ,modified_at, quantity) values(CURRENT_TIME(),CURRENT_TIME() ,90);
insert into product_inventory (created_at ,modified_at, quantity) values(CURRENT_TIME(),CURRENT_TIME() , 45);
insert into product_inventory (created_at ,modified_at, quantity) values(CURRENT_TIME(),CURRENT_TIME() , 0);
insert into product_inventory (created_at ,modified_at, quantity) values(CURRENT_TIME(),CURRENT_TIME() , 23);

insert into product (name,created_at ,modified_at, description, price,category_id,inventory_id) values ('Santoor soap',CURRENT_TIME(),CURRENT_TIME(), 'Beauty product', 20, (select id from product_category where id =1), (select id from product_inventory where id=1));
insert into product (name,created_at ,modified_at, description, price,category_id,inventory_id) values ('Sidney Sheldon',CURRENT_TIME(),CURRENT_TIME(), 'Readers digest', 220, (select id from product_category where id=2), (select id from product_inventory where id=2));
insert into product (name,created_at ,modified_at, description, price,category_id,inventory_id) values ('Apple 6s',CURRENT_TIME(),CURRENT_TIME(), 'Electronic appliances', 3220, (select id from product_category where id=3), (select id from product_inventory where id=3));
insert into product (name,created_at ,modified_at, description, price,category_id,inventory_id) values ('Rolling chair',CURRENT_TIME(),CURRENT_TIME(), 'Furniture at home and work', 2120, (select id from product_category where id=4), (select id from product_inventory where id=4));
insert into product (name,created_at ,modified_at, description, price,category_id,inventory_id) values ('Pressure cooker',CURRENT_TIME(),CURRENT_TIME(), 'Accessories for your kitchen', 2130, (select id from product_category where id=5), (select id from product_inventory where id=5));
insert into product (name,created_at ,modified_at, description, price,category_id,inventory_id) values ('Diamond ring',CURRENT_TIME(),CURRENT_TIME(), 'Jewellery for every ocassion', 1420, (select id from product_category where id=6), (select id from product_inventory where id=6));
insert into product (name,created_at ,modified_at, description, price,category_id,inventory_id) values ('Blue',CURRENT_TIME(),CURRENT_TIME(), 'Music for every mood', 5620, (select id from product_category where id=7), (select id from product_inventory where id=7));
insert into product (name,created_at ,modified_at, description, price,category_id,inventory_id) values ('Tommy Hilfiger soap',CURRENT_TIME(),CURRENT_TIME(), 'Cool wrist watches', 6520, (select id from product_category where id=8), (select id from product_inventory where id=8));
insert into product (name,created_at ,modified_at, description, price,category_id,inventory_id) values ('Bournvita',CURRENT_TIME(),CURRENT_TIME(), 'Everything required for your hunger', 230, (select id from product_category where id=9), (select id from product_inventory where id=9));
insert into product (name,created_at ,modified_at, description, price,category_id,inventory_id) values ('Loafers',CURRENT_TIME(),CURRENT_TIME(), 'Stare at the shoes', 720, (select id from product_category where id=10), (select id from product_inventory where id=10));
insert into product (name,created_at ,modified_at, description, price,category_id,inventory_id) values ('Nike men t-shirt',CURRENT_TIME(),CURRENT_TIME(), 'Rich and comfortable apparels', 280, (select id from product_category where id=11), (select id from product_inventory where id=11));
insert into product (name,created_at ,modified_at, description, price,category_id,inventory_id) values ('Baby soap',CURRENT_TIME(),CURRENT_TIME(), 'Baby products', 2000, (select id from product_category where id=12), (select id from product_inventory where id=12));