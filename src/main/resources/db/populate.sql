DELETE FROM dishes;
DELETE FROM lunches;
DELETE FROM restaurants;
DELETE FROM users;
DELETE FROM roles;
DELETE FROM votes;

INSERT INTO dishes (id, name, description, price) VALUES
  (
    1, 'Пицца', 'Пицца на тонком тесте', 540
  );

INSERT INTO restaurants (id, name) VALUES
  (1, 'Praga');

INSERT INTO lunches (id, date, restId, dishId) VALUES
  (1, now(), 1, 1);

INSERT INTO users (id, name, email, password, registered) VALUES
  (1, 'Anatoly', 'mehanat@mail.ru', 'pastol', now());

INSERT INTO roles(id, userid, role)  VALUES
  (1, 1, 'ADMIN');

INSERT INTO votes (id, userid, date, restid) VALUES
  (1, 1 , now(), 1);