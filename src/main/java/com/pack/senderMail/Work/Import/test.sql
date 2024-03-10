INSERT INTO personn (colonne) VALUES ('l''ambdat');

create table numerodecompte(
    compte varchar(225),
    intitule varchar(225)
);
create table  exercice(
    date TIMESTAMP,
    REFPIECE varchar(225),
    COMPTE varchar(225),
    TIERS varchar(225),
    INTITULE varchar(225),
    LIBELLE varchar(225),
    debit double precision,
    CREDIT double precision
);
