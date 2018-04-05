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