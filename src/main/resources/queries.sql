INSERT INTO spec(namespec) VALUES ('Английский язык');

INSERT INTO users(surname, name, email) VALUES ('kuznetsov', 'rodion', 'k.rodion97@gmail.com');

INSERT INTO reviews(iduser, surname, name, otchestvo, idspec, city, address,
                    datetime, content, status)
VALUES (1, 'филипас', 'иван', 'александрович', 1, 'томск', 'фрунзе', '02.04.2018',
        'молодец', 1);

INSERT INTO users(surname, name, email) VALUES ('филипас', 'иван', 'risterio@gmail.com');

INSERT INTO specusers VALUES (2, 'филипас', 'иван', 'александрович', 'risterio@gmail.com',
                              '89539225044', 1, 'томск', 'фрунзе',
                              'студент, стажа работы нет');

INSERT INTO specsreviews VALUES (2, 1);

INSERT INTO access(nameaccess) VALUES ('Пользователь'), ('Специалист'), ('Модератор');

INSERT INTO users(surname, name, email) VALUES ('Афанасьев', 'Павел', 'pavel@gmail.com');

INSERT INTO usersaccess VALUES (1, 1), (2, 2), (3, 3);

INSERT INTO parameters(nameparameter) VALUES ('Качество услуги'), ('Коммуникация'),
  ('Конфликтность');

INSERT INTO reviewsparameters(idreview, idparameter, value)
  VALUES (1, 1, 5), (1, 2, 4), (1, 3, 2);

DELETE FROM reviewsparameters;

DROP TABLE reviewsparameters;