CREATE TABLE `schema1`.`employee` (
  `emp_id` INT NOT NULL COMMENT '',
  `emp_name` VARCHAR(45) NULL COMMENT '',
  PRIMARY KEY (`empid`)  COMMENT '');
  
  
DELIMITER $$
CREATE DEFINER=`user1`@`%` PROCEDURE `usp_GetEmployeeName`(IN id INT, OUT name VARCHAR(20))
begin
select emp_name into name from employee where emp_id = id;
end$$
DELIMITER ;


CREATE TABLE `customer` (
  `CUST_ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `NAME` varchar(100) NOT NULL,
  `AGE` int(10) unsigned NOT NULL,
  PRIMARY KEY (`CUST_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;


CREATE TABLE customer (
    CUST_ID SERIAL,
    NAME VARCHAR(100) NOT NULL,
    AGE INTEGER NOT NULL,
    CONSTRAINT customer_pk PRIMARY KEY (CUST_ID),
    CHECK (CUST_ID>=0),
    CHECK (AGE>=0)
);

CREATE TABLE epictable
(
    mytable_key    serial primary key,
    moobars        VARCHAR(40) not null,
    foobars        DATE
);

select * from customer;
insert into epictable(moobars,foobars) values('delicious moobars','2012-05-01')
