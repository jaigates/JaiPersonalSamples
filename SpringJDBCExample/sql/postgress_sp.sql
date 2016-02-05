
create function dup(in int, out f1 int, out f2 text)
    as $$ select $1, cast($1 as text) || ' is text' $$
    language sql;

SELECT * FROM dup(42);

--returning a single record using SQL
CREATE OR REPLACE FUNCTION fn_sqltestout(param_subject text, 
    OUT subject_scramble text, OUT subject_char text)
   AS
$$
SELECT  substring($1, 1,CAST(random()*length($1) As integer)), substring($1, 1,1)
$$
LANGUAGE 'sql' VOLATILE;


CREATE OR REPLACE FUNCTION fn_sqltestout(param_subject text, 
    OUT subject_scramble text, OUT subject_char text)
   AS
$$
SELECT  substring($1, 1,CAST(random()*length($1) As integer)), substring($1, 1,1)
$$
LANGUAGE 'sql' VOLATILE;
  
SELECT  (fn_sqltestout('This is a test subject')).subject_scramble;


CREATE OR REPLACE FUNCTION fn_sqltestout(param_subject text, OUT subject_scramble text, OUT subject_char text)
AS
$$
SELECT  substring(param_subject, 1,CAST(random()*length(param_subject) As integer)), substring(param_subject, 1,1)
$$
LANGUAGE 'sql' VOLATILE;


CREATE or replace FUNCTION insert_emp_cust(IN eid integer, IN eoldid integer, IN ename text, IN edob date, IN version integer, IN ccust_id integer, IN cname text, IN cage integer) returns void AS
$$
insert into employee(id,oldid,name,dob,version) values (eid,eoldid,ename,edob,version);
INSERT INTO customer(cust_id, name, age) VALUES (ccust_id, cname,cage);
$$
LANGUAGE 'sql' VOLATILE;


SELECT insert_employee(1,1,'emp1', '2001-10-05',1);

SELECT insert_emp_cust(4,4,'emp4', '2001-10-05',1,3,'cust3',3);
exec insert_emp_cust(4,4,'emp4', '2001-10-05',1,3,'cust3',3);
select * from employee;
select * from customer;
delete from customer;
commit;
INSERT INTO customer(cust_id, name, age) VALUES (1,'cust1', 66);


CREATE OR REPLACE FUNCTION add_city(city VARCHAR(70), state CHAR(2)) 
RETURNS void AS $$
BEGIN
INSERT INTO cities VALUES (city, state);
END;
$$ LANGUAGE plpgsql;



 SELECT version();





 

CREATE TABLE customer
(
  cust_id serial NOT NULL,
  name character varying(100) NOT NULL,
  age integer NOT NULL,
  CONSTRAINT customer_pk PRIMARY KEY (cust_id),
  CONSTRAINT customer_age_check CHECK (age >= 0),
  CONSTRAINT customer_cust_id_check CHECK (cust_id >= 0)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE customer
  OWNER TO role1;




CREATE TABLE customer
(
  cust_id serial NOT NULL,
  name character varying(100) NOT NULL,
  age integer NOT NULL,
  CONSTRAINT customer_pk PRIMARY KEY (cust_id),
  CONSTRAINT customer_age_check CHECK (age >= 0),
  CONSTRAINT customer_cust_id_check CHECK (cust_id >= 0)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE customer
  OWNER TO role1;



