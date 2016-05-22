DELETE FROM dishes;
DELETE FROM lunches;
DELETE FROM restaurants;
DELETE FROM users;
DELETE FROM roles;
DELETE FROM votes;

ALTER SEQUENCE lunches_id_seq RESTART ;
ALTER SEQUENCE dishes_id_seq RESTART ;
ALTER SEQUENCE restaurants_id_seq RESTART ;
ALTER SEQUENCE roles_id_seq RESTART ;
ALTER SEQUENCE votes_id_seq RESTART ;
ALTER SEQUENCE users_id_seq RESTART ;


INSERT INTO restaurants (name) VALUES
  ('Praga'), ('Mone'),('Grand'), ('McGold');

INSERT INTO lunches (date, name, restId, price) VALUES
  ('2016-05-01', 'Весенний', 1, 250), ('2016-05-02', 'Бизнес-ланч', 1, 250), ('2016-05-03', 'Деревенский', 1, 250), (now(), 'Ирландский', 1, 250),
  ('2016-05-01', 'Испанский', 2, 250), ('2016-05-02', 'На гриле', 2, 250), ('2016-05-03', 'Пицца', 2, 250), (now(), 'Индийский', 2, 250),
  ('2016-05-01', 'Бизнес-ланч', 3, 250), ('2016-05-02', 'Бизнес-ланч', 3, 250), ('2016-05-03', 'Деревенский', 3, 250), (now(), 'Ирландский', 3, 250),
  ('2016-05-01', 'Студенческий', 4, 250), ('2016-05-02', 'Бизнес-ланч', 4, 250), ('2016-05-03', 'Деревенский', 4, 250), (now(), 'Ирландский', 4, 250);

INSERT INTO dishes (name, description, lunch_id) VALUES
  ( 'Пицца', 'Пицца на тонком тесте', 1),('Салат', 'Цезарь с курицей', 1);

INSERT INTO users (name, email, password, registered) VALUES
  ('Anatoly', 'mehanat@mail.ru', 'pastol', now()), ('Sergey', 'serg@mail.ru', 'pastol', now());

INSERT INTO roles(userid, role)  VALUES
  (1, 'ADMIN'),
  (2, 'USER');

INSERT INTO votes (userid, lunchId) VALUES
  (1 , 1), (1, 2), (1, 7), (1, 16),
  (2, 1), (2, 6), (2, 11), (2, 16);