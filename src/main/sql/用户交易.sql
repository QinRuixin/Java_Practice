create table users
(
    user_id        int primary key auto_increment,
    join_date      date,
    favorite_brand varchar(50)
);

create table orders
(
    order_id   int primary key auto_increment,
    order_date date,
    item_id    int,
    buyer_id   int,
    seller_id  int
);

create table items
(
    item_id    int primary key auto_increment,
    item_brand varchar(50)
);

insert into users(user_id, join_date, favorite_brand)
values (1, '2019-01-01', 'Lenovo'),
       (2, '2019-02-09', 'Samsung'),
       (3, '2019-01-19', 'LG'),
       (4, '2019-05-21', 'HP');

insert into orders(order_id, order_date, item_id, buyer_id, seller_id)
VALUES (1, '2019-08-01', 4, 1, 2),
       (2, '2019-08-02', 2, 1, 3),
       (3, '2019-08-03', 3, 2, 3),
       (4, '2019-08-04', 1, 4, 2),
       (5, '2019-08-04', 1, 3, 4),
       (6, '2019-08-05', 2, 2, 4);

insert into items (item_id, item_brand)
values (1, 'Samsung'),
       (2, 'Lenovo'),
       (3, 'LG'),
       (4, 'HP');


select user_id seller_id, if(favorite_brand = item_brand, 'yes', 'no') 2nd_item_fav_brand
from users
         left join (
    select o1.seller_id, item_brand
    from orders o1
             join orders o2
                  on o1.seller_id = o2.seller_id
             join items i
                  on o1.item_id = i.item_id
    group by o1.order_id
    having sum(o1.order_date > o2.order_date) = 1
) tmp
on user_id = seller_id;
