/*
7. В подключенном MySQL репозитории создать базу данных “Друзья человека”
*/

CREATE DATABASE IF NOT EXISTS Human_Friends;

/*
8. Создать таблицы с иерархией из диаграммы в БД
*/

USE Human_Friends;

CREATE TABLE animals (
  idAnimals INT NOT NULL,
  type VARCHAR(45) NULL,
  PRIMARY KEY (idAnimals));

ALTER TABLE animals
CHANGE COLUMN idAnimals idAnimals INT NOT NULL AUTO_INCREMENT ;

INSERT INTO animals (type) VALUES ("pets");
INSERT INTO animals (type) VALUES ("pack");

CREATE TABLE pets (
  id_pets INT NOT NULL AUTO_INCREMENT,
  type_pets VARCHAR(45) NOT NULL,
  PRIMARY KEY (id_pets));

CREATE TABLE pack (
  id_pack INT NOT NULL AUTO_INCREMENT,
  type_pack VARCHAR(45) NOT NULL,
  PRIMARY KEY (id_pack));

INSERT INTO pets (type_pets) VALUES ("dog");
INSERT INTO pets (type_pets) VALUES ("cat");
INSERT INTO pets (type_pets) VALUES ("hamster");

INSERT INTO pack (type_pack) VALUES ("horse");
INSERT INTO pack (type_pack) VALUES ("camel");
INSERT INTO pack (type_pack) VALUES ("donkey");

/*
9. Заполнить низкоуровневые таблицы именами(животных), командами которые они выполняют и датами рождения
*/

CREATE TABLE dog (
  id_dog INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NOT NULL,
  commands VARCHAR(45) NOT NULL,
  date_of_birth VARCHAR(45) NOT NULL,
  PRIMARY KEY (id_dog));

CREATE TABLE cat (
  id_cat INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NOT NULL,
  commands VARCHAR(45) NOT NULL,
  date_of_birth VARCHAR(45) NOT NULL,
  PRIMARY KEY (id_cat));

CREATE TABLE hamster (
  id_hamster INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NOT NULL,
  commands VARCHAR(45) NOT NULL,
  date_of_birth VARCHAR(45) NOT NULL,
  PRIMARY KEY (id_hamster));

CREATE TABLE horse (
  id_horse INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NOT NULL,
  commands VARCHAR(45) NOT NULL,
  date_of_birth VARCHAR(45) NOT NULL,
  PRIMARY KEY (id_horse));

CREATE TABLE camel (
  id_camel INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NOT NULL,
  commands VARCHAR(45) NOT NULL,
  date_of_birth VARCHAR(45) NOT NULL,
  PRIMARY KEY (id_camel));

CREATE TABLE donkey (
  id_donkey INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NOT NULL,
  commands VARCHAR(45) NOT NULL,
  date_of_birth VARCHAR(45) NOT NULL,
  PRIMARY KEY (id_donkey));

ALTER TABLE camel
CHANGE COLUMN date_of_birth date_of_birth DATE NOT NULL ;

ALTER TABLE cat
CHANGE COLUMN date_of_birth date_of_birth DATE NOT NULL ;

ALTER TABLE dog
CHANGE COLUMN date_of_birth date_of_birth DATE NOT NULL ;

ALTER TABLE donkey
CHANGE COLUMN date_of_birth date_of_birth DATE NOT NULL ;

ALTER TABLE hamster
CHANGE COLUMN date_of_birth date_of_birth DATE NOT NULL ;

ALTER TABLE horse
CHANGE COLUMN date_of_birth date_of_birth DATE NOT NULL ;

INSERT INTO dog (name, commands, date_of_birth) VALUES
("Джесси", "стоять, фас", "2021-01-01"),
("Шарик", "лежать, фас", "2022-01-01"),
("Тузик", "сидеть", "2022-01-01");

INSERT INTO cat (name, commands, date_of_birth) VALUES 
("Фросик", "есть", "2023-01-06"),
("Даша", "бежать", "2020-01-01"),
("Барсик", "лежать", "2021-05-01");

INSERT INTO hamster (name, commands, date_of_birth) VALUES
("Гарик", "нельзя", "2017-03-22"),
("Звиздюк", "есть", "2022-06-01"),
("Фунтик", "бежать", "2021-04-01");

INSERT INTO horse (name, commands, date_of_birth) VALUES
("Плотва", "Галоп", "2023-02-03"),
("Машка", "Стоять", "2021-04-03"),
("Цезарь", "Лежать", "2022-02-13");

INSERT INTO camel (name, commands, date_of_birth) VALUES
("Вася", "вставай", "2015-07-07"),
("Коля", "Иди", "2016-03-03"),
("Ваха", "Стой", "2019-04-27");

INSERT INTO donkey (name, commands, date_of_birth) VALUES
("Абизян", "пошел, стоять", "2016-07-01"),
("Муха", "лежать, стоять", "2018-03-02"),
("Протон", "пошел, лежать", "2022-01-01");


/*
10. Удалив из таблицы верблюдов, т.к. верблюдов решили перевезти в другой питомник на зимовку.
Объединить таблицы лошади, и ослы в одну таблицу.
*/

TRUNCATE camel;

CREATE TABLE horse_and_donkey AS
SELECT name, commands, date_of_birth FROM horse
UNION
SELECT name, commands, date_of_birth FROM donkey;

/*
11. Создать новую таблицу “молодые животные” в которую попадут все животные старше 1 года,
но младше 3 лет и в отдельном столбце с точностью до месяца подсчитать возраст животных в новой таблице
*/

CREATE TABLE young_animals AS
SELECT name, commands, date_of_birth, CONCAT(TIMESTAMPDIFF(YEAR, date_of_birth, CURDATE()), " year ", TIMESTAMPDIFF(MONTH, date_of_birth, CURDATE()) % 12, " month ") AS age
FROM dog
WHERE date_of_birth BETWEEN DATE_SUB(CURDATE(), INTERVAL 3 YEAR) AND DATE_SUB(CURDATE(), INTERVAL 1 YEAR)
UNION
SELECT name, commands, date_of_birth, CONCAT(TIMESTAMPDIFF(YEAR, date_of_birth, CURDATE()), " year ", TIMESTAMPDIFF(MONTH, date_of_birth, CURDATE()) % 12, " month ") AS age
FROM cat
WHERE date_of_birth BETWEEN DATE_SUB(CURDATE(), INTERVAL 3 YEAR) AND DATE_SUB(CURDATE(), INTERVAL 1 YEAR)
UNION
SELECT name, commands, date_of_birth, CONCAT(TIMESTAMPDIFF(YEAR, date_of_birth, CURDATE()), " year ", TIMESTAMPDIFF(MONTH, date_of_birth, CURDATE()) % 12, " month ") AS age
FROM hamster
WHERE date_of_birth BETWEEN DATE_SUB(CURDATE(), INTERVAL 3 YEAR) AND DATE_SUB(CURDATE(), INTERVAL 1 YEAR)
UNION
SELECT name, commands, date_of_birth, CONCAT(TIMESTAMPDIFF(YEAR, date_of_birth, CURDATE()), " year ", TIMESTAMPDIFF(MONTH, date_of_birth, CURDATE()) % 12, " month ") AS age
FROM horse
WHERE date_of_birth BETWEEN DATE_SUB(CURDATE(), INTERVAL 3 YEAR) AND DATE_SUB(CURDATE(), INTERVAL 1 YEAR)
UNION
SELECT name, commands, date_of_birth, CONCAT(TIMESTAMPDIFF(YEAR, date_of_birth, CURDATE()), " year ", TIMESTAMPDIFF(MONTH, date_of_birth, CURDATE()) % 12, " month ") AS age
FROM camel
WHERE date_of_birth BETWEEN DATE_SUB(CURDATE(), INTERVAL 3 YEAR) AND DATE_SUB(CURDATE(), INTERVAL 1 YEAR)
UNION
SELECT name, commands, date_of_birth, CONCAT(TIMESTAMPDIFF(YEAR, date_of_birth, CURDATE()), " year ", TIMESTAMPDIFF(MONTH, date_of_birth, CURDATE()) % 12, " month ") AS age
FROM donkey
WHERE date_of_birth BETWEEN DATE_SUB(CURDATE(), INTERVAL 3 YEAR) AND DATE_SUB(CURDATE(), INTERVAL 1 YEAR);

/*
12. Объединить все таблицы в одну, при этом сохраняя поля, указывающие на прошлую принадлежность к старым таблицам.
*/

CREATE TABLE all_tables AS
SELECT  name,
        commands,
        date_of_birth,
        "dog" as old_table
FROM dog
UNION
SELECT  name,
        commands,
        date_of_birth,
        "cat" as old_table
FROM cat
UNION
SELECT  name,
        commands,
        date_of_birth,
        "hamster" as old_table
FROM hamster
UNION
SELECT  name,
        commands,
        date_of_birth,
        "horse" as old_table
FROM horse
UNION
SELECT  name,
        commands,
        date_of_birth,
        "camel" as old_table
FROM camel
UNION
SELECT  name,
        commands,
        date_of_birth,
        "donkey" as old_table
FROM donkey;