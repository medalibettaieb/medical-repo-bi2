
    create table A (
        idA integer not null,
        primary key (idA)
    );

    create table T_ROOM (
        id integer not null auto_increment,
        capacity integer not null,
        number integer not null,
        superviser_id integer,
        primary key (id)
    );

    create table T_USER (
        DTYPE varchar(31) not null,
        id integer not null auto_increment,
        name varchar(255),
        gender integer,
        level varchar(255),
        speciality varchar(255),
        patientsRoom_id integer,
        primary key (id)
    );

    create table T_USER_T_ROOM (
        visitedDoctors_id integer not null,
        visitedRooms_id integer not null
    );

    create table world.city (
        ID integer not null auto_increment,
        CountryCode varchar(3) not null,
        District varchar(20) not null,
        Name varchar(35) not null,
        Population integer not null,
        primary key (ID)
    );

    create table world.country (
        Code varchar(3) not null,
        Capital integer,
        Code2 varchar(2) not null,
        Continent varchar(13) not null,
        GNP float,
        GNPOld float,
        GovernmentForm varchar(45) not null,
        HeadOfState varchar(60),
        IndepYear smallint,
        LifeExpectancy float,
        LocalName varchar(45) not null,
        Name varchar(52) not null,
        Population integer not null,
        Region varchar(26) not null,
        SurfaceArea float not null,
        primary key (Code)
    );

    create table world.countrylanguage (
        CountryCode varchar(3) not null,
        Language varchar(30) not null,
        IsOfficial varchar(2) not null,
        Percentage float not null,
        primary key (CountryCode, Language)
    );

    alter table T_ROOM 
        add constraint FK_p3e2rl3lmtgmlo0aflo3qi8v 
        foreign key (superviser_id) 
        references T_USER (id);

    alter table T_USER 
        add constraint FK_nptv4b8h0apqjuu9tgsm80o5x 
        foreign key (patientsRoom_id) 
        references T_ROOM (id);

    alter table T_USER_T_ROOM 
        add constraint FK_37ovx7iptvigl40x6c6jk6os9 
        foreign key (visitedRooms_id) 
        references T_ROOM (id);

    alter table T_USER_T_ROOM 
        add constraint FK_s1d6u5ifsehsoqd8miy4mjbfu 
        foreign key (visitedDoctors_id) 
        references T_USER (id);
