create database TPG;

use tpg;
show tables;
show databases;
select * from candiadate;
drop table section;
drop table admin,questions,section,testpaper,subject,candidate;

ALTER TABLE questions MODIFY COLUMN actual_qns VARCHAR(700);
