DROP TABLE IF EXISTS part;
CREATE TABLE part
(
    id int PRIMARY KEY AUTO_INCREMENT,
    part_name varchar(50) NOT NULL,
    vendor varchar(30) NOT NULL,
    qty int NOT NULL,
    part_number varchar(30) NOT NULL,
    shipped_date date,
    receive_date date
);
