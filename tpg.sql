create database TPG;

use tpg;
show tables;
show databases;
select * from questions;
drop table admin,questions,section,testpaper,subject;

ALTER TABLE questions MODIFY COLUMN actual_qns VARCHAR(1000);
