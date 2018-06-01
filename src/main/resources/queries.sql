INSERT INTO spec(namespec) VALUES ('Английский язык');
INSERT INTO spec(namespec) VALUES ('Spanish');

INSERT INTO access(nameaccess) VALUES ('Пользователь'), ('Специалист'), ('Модератор');

INSERT INTO users(surname, name, email) VALUES ('kuznetsov', 'rodion', 'k.rodion97@gmail.com');
INSERT INTO users(surname, name, email) VALUES ('ivanov', 'ivan', 'ivan@gmail.com');
INSERT INTO users(surname, name, email) VALUES ('leonov', 'leonid', 'leonid@gmail.com');

INSERT INTO usersaccess VALUES (1, 1), (2, 2), (3, 3);

INSERT INTO specusers VALUES (2, 'ivanov', 'ivan', 'aleksandrovich', 'ivan@gmail.com',
                              0, 'english', 'tomsk', 'frunze',
                              'student');

INSERT INTO reviews(iduser, surname, name, otchestvo, specName, city, address, onCall,
                    datetime, content, status)
VALUES (1, 'ivanov', 'ivan', '', 'english', 'tomsk', 'frunze', 0, '02.04.2018',
        'good job', 1);
INSERT INTO reviews(iduser, surname, name, otchestvo, specName, city, address, onCall,
                    datetime, content, status)
VALUES (3, 'ivanov', 'ivan', 'aleksandrovich', 'english', 'tomsk', 'frunze', 0, '01.05.2018',
        'not so good', 1);

INSERT INTO reviewsparameters(idreview, parametername, value)
VALUES (1, 'Качество услуги', 5), (1, 'Коммуникация', 4), (1, 'Конфликтность', 2);

INSERT INTO specsreviews VALUES (2, 1);

SELECT * FROM reviews WHERE status = 1 ORDER BY datetime;

UPDATE specusers SET surname = 'филипас', name = 'иван', otchestvo = 'александрович',
  city = 'томск', address = 'фрунзе', info = 'студент, стажа работы нет'
  WHERE iduser = 2;

INSERT INTO parameters(nameparameter) VALUES ('Качество услуги'), ('Коммуникация'),
  ('Конфликтность');

DELETE FROM reviewsparameters;
DELETE FROM specsreviews;
DELETE FROM usersaccess;
DELETE FROM reviews;
DELETE FROM specusers;
DELETE FROM users;
DELETE FROM parameters;
DELETE FROM spec;
DELETE FROM access;

DELETE FROM usersaccess WHERE iduser = -44;

DELETE FROM users WHERE iduser = -44;

DROP TABLE reviewsparameters, specsreviews, usersaccess, reviews, specusers,
  users, parameters, spec, access;

DROP SEQUENCE access_id_seq, parameter_id_seq, review_id_seq, reviewsparameters_id_seq,
  spec_id_seq, user_id_seq;

DELETE FROM parameters WHERE idparameter = 7;

ALTER TABLE reviews RENAME COLUMN idspec to specName;

ALTER TABLE reviews DROP CONSTRAINT reviews_idspec_fkey;

ALTER TABLE reviews ALTER COLUMN specname TYPE VARCHAR;

ALTER TABLE reviews ALTER COLUMN datetime TYPE DATE USING datetime::DATE;

ALTER TABLE reviews ALTER COLUMN specname SET NOT NULL;

DELETE FROM reviewsparameters WHERE idreviewsparameters BETWEEN 19 AND 42;

DELETE FROM reviews WHERE idreview = 9;

ALTER TABLE reviewsparameters ALTER COLUMN value TYPE FLOAT;

SELECT * from specusers WHERE iduser = 5;

DELETE FROM reviews WHERE idreview = 16;

UPDATE usersaccess SET idaccess = 3 WHERE iduser = 7;

UPDATE reviews SET status = 1 WHERE idreview = 24;

DELETE FROM specusers;

