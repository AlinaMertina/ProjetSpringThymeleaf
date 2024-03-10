create database gestionvehiculeevaluation;
\c gestionvehiculeevaluation;

create table role(
    idrole bigint primary key,
    nomrole varchar(100)
);

insert into role values (1,'ADMIN');
insert into role values (2,'USER');

CREATE TABLE utilisateur (
    idutilisateur BIGINT PRIMARY KEY,
    idrole BIGINT  REFERENCES role(idrole),
    nomutilisateur VARCHAR(150) ,
    prenom VARCHAR(150),
    datenaissance TIMESTAMP ,
    email VARCHAR(255) , 
    password VARCHAR(255) 
);

insert into utilisateur values (1,1,'Administrateur','','2023-04-05','administrateur@gmail.com','administrateur');
insert into utilisateur values (2,2,'Chauffeur','','2023-04-05','chauffeur@gmail.com','chauffeur');

drop VIEW v_utilisateur;
CREATE VIEW v_utilisateur AS
SELECT idutilisateur,nomrole,role.idrole,nomutilisateur,prenom,datenaissance
FROM utilisateur join role on utilisateur.idrole=role.idrole;


create table Typevehicule(
    idtypevehicule  bigint primary key,
    nomtypevehicule  varchar(225)
);

insert into typevehicule values (1,'legere');
insert into typevehicule values (2,'utilitaire');
insert into typevehicule values (3,'SUV');
insert into typevehicule values (4,'camion');


create table vehicule(
    idvehicule bigint primary key,
    numero varchar(225),
    marque varchar(225),
    model varchar(225),
    idtypevehicule bigint references Typevehicule(idtypevehicule)
);

CREATE VIEW v_vehicule AS
SELECT idvehicule,numero,marque,model,typevehicule.idtypevehicule,typevehicule.nomtypevehicule
FROM vehicule join typevehicule  on vehicule.idvehicule=typevehicule.idtypevehicule;

create table Lieu(
    idlieu bigint primary key,
    nomlieu varchar(225)
);
drop table trajet;
create table trajet(
    idtrajet  bigint primary key,
    dateheurdepart timestamp ,
    idlieurdepart bigint references Lieu(idlieu),
    kilometragedepart double precision,
    dateheurarrive timestamp ,
    idlieurarrive bigint references Lieu(idlieu),
    kilometragearrive double precision,
    quantitecarburant double precision,
    prixcarburant double precision,
    motif text,
    idutilisateur bigint references utilisateur(idutilisateur),
    idvehicule bigint references vehicule(idvehicule)
);
SELECT ( CURRENT_DATE -'2024-03-01'::date) AS difference_in_days;

CREATE VIEW v_trajet AS
SELECT idtrajet,dateheurdepart,idlieurdepart,kilometragedepart,dateheurarrive,idlieurarrive,kilometragearrive,quantitecarburant
,prixcarburant,motif,idutilisateur,trajet.idvehicule,numero,lieuarrive.nomlieu as nomlieurarrive,lieudepart.nomlieu as nomlieurdepart
from trajet join vehicule on trajet.idvehicule=vehicule.idvehicule 
join Lieu as lieudepart on  lieudepart.idlieu=trajet.idlieurarrive
join Lieu as lieuarrive on  lieuarrive.idlieu=trajet.idlieurdepart;

create table echeance(
    idecheance  bigint primary key,
    nomecheance varchar(225)
);
insert into echeance values (1,'assurence');
insert into echeance values (2,'vitesse techinique');

drop VIEW v_echeancevehicule;

create VIEW v_echeancevehicule as
select idecheancevehicule,vehicule.idvehicule,echeancevehicule.idecheance,dateecheancevehicule,( dateecheancevehicule::date-CURRENT_DATE ) AS nbrjour ,nomecheance,numero
from echeancevehicule  join vehicule on echeancevehicule.idvehicule=vehicule.idvehicule
join echeance on echeancevehicule.idecheance=echeance.idecheance;

drop table echeancevehicule;

create table echeancevehicule(
    idecheancevehicule  bigint primary key,
    idvehicule bigint references vehicule(idvehicule),
    idecheance bigint references echeance(idecheance),
    dateecheancevehicule timestamp
);
drop table historiqueecheancevehicule;
select * from historiqueecheancevehicule;
create table historiqueecheancevehicule(
    idhistoriqueecheancevehicule  bigint primary key,
    idecheancevehicule  bigint references echeancevehicule(idecheancevehicule),
    idvehicule bigint references vehicule(idvehicule),
    idecheance bigint references echeance(idecheance),
    dateecheancevehicule timestamp,
    datemodif timestamp
);


create table garage(
    idgarage bigint primary key,
    idvehicule bigint references vehicule(idvehicule),
    date timestamp,
    idutilisateur bigint  references utilisateur(idutilisateur),
    entersortie int
);

create VIEW v_garage as
select idgarage,vehicule.idvehicule,date,utilisateur.idutilisateur,entersortie,nomutilisateur,prenom,
numero from garage join vehicule on garage.idvehicule=vehicule.idvehicule
join utilisateur on utilisateur.idutilisateur=garage.idutilisateur;


