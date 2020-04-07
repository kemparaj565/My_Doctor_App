drop table if exists disease;

create table disease(Disease_ID integer NOT NULL AUTO_INCREMENT,disease_name varchar(1000),symptom varchar(2000),
disease_Description varchar(3000),duration_Of_Disease integer);


drop table if exists symptom;

create table symptom(Symptom_ID integer NOT NULL AUTO_INCREMENT,symptom_name varchar(2000),symptom_description varchar(4000),
duration_of_symptom integer);


drop table if exists medicine;

create table medicine(Medicine_ID integer NOT NULL AUTO_INCREMENT,medicine_name varchar(2000),disease_name varchar(1000),
symptom_name varchar(1000),treatment_description varchar(4000),number_Of_Times_Prescribed integer,vendor_name varchar(1000),
duration_to_use varchar(1500));