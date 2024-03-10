
create database sendermail;
\c sendermail;

create table role(
    idrole bigint primary key,
    nomrole varchar(100)
);

insert into role values (1,'ADMIN');
insert into role values (2,'USER');


CREATE TABLE utilisateur (
    idutilisateur BIGINT PRIMARY KEY,
    idrole BIGINT NOT NULL REFERENCES role(idrole),
    nomutilisateur VARCHAR(150) NOT NULL,
    prenom VARCHAR(150),
    datenaissance TIMESTAMP NOT NULL,
    email VARCHAR(255) NOT NULL, 
    password VARCHAR(255) NOT NULL,
    activer int,
);



insert into utilisateur(idutilisateur,idrole,nomutilisateur,prenom,datenaissance,email,password,activer) values (1,1,'Centrale','','2015-02-03','centrale@gmail.com','centrale123',1);
insert into utilisateur(idutilisateur,idrole,nomutilisateur,prenom,datenaissance,email,password,activer) values (2,2,'Station1','','2015-02-03','station1@gmail.com','station1123',1);
insert into utilisateur(idutilisateur,idrole,nomutilisateur,prenom,datenaissance,email,password,activer) values (3,2,'Station2','','2015-02-03','station2@gmail.com','station2123',1);

drop VIEW v_utilisateur;
CREATE VIEW v_utilisateur AS
SELECT idutilisateur,nomrole,role.idrole,nomutilisateur,prenom,datenaissance
FROM utilisateur join role on utilisateur.idrole=role.idrole;

select * from v_utilisateur;