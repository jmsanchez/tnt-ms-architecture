insert into `orders` (id, created_at) values (1, CURRENT_TIMESTAMP() );
insert into `orders` (id, created_at) values (2, CURRENT_TIMESTAMP() );

insert into order_line (id, order_id, product_id, quantity, price) values (1, 1, '0055', 1, 9.99);
insert into order_line (id, order_id, product_id, quantity, price) values (2, 1, '0071', 1, 9.99);

insert into order_line (id, order_id, product_id, quantity, price) values (3, 2, '0055', 1, 9.99);
insert into order_line (id, order_id, product_id, quantity, price) values (4, 2, '0079', 1, 9.99);
