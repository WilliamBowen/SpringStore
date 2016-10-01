-- delete old data
delete from user;
delete from product;
delete from cart;
delete from productincart;

-- add a few users (id, first name, last name, username, password, email)
insert into user values(1, 'William', 'Bowen', 'wbowen', 'password', 'willwbowen@gmail.com');
insert into user values(2, 'Tam', 'Bowen', 'tbowen', 'password2', 'tambowen@gmail.com');
insert into user values(3, 'Bill', 'Gates', 'bgates', 'password3', 'bgates@microsoft.com');

-- create a cart for each user
insert into cart values(1, 2) --Tam gets the first cart
insert into cart values(2, 3) --Bill gets the second cart
insert into cart values(3, 1) --William gets the third cart

-- create some products
