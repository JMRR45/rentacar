CREATE TABLE TOURIST( 
                PASSPORT  VARCHAR (11)  NOT NULL,
                NAME  TEXT NOT NULL,
                AGE  SMALLINT NOT NULL,
                SEX  BINARY NOT NULL,
                CONTACT  TEXT NOT NULL,
                COUNTRY__ID  INT,
                PRIMARY KEY ( PASSPORT )
 );
  
CREATE TABLE CAR( 
                PLATE  VARCHAR (7)  NOT NULL,
                COLOR  TEXT NOT NULL,
                CANTKM  INT NOT NULL,
                SITUATION  TEXT NOT NULL,
                MODEL__ID  INT,
                PRIMARY KEY ( PLATE )
 );
  
CREATE TABLE MODEL( 
                ID  INT NOT NULL,
                MODEL  TEXT NOT NULL,
                BRAND__ID  INT,
                PRIMARY KEY ( ID )
 );
  
CREATE TABLE BRAND( 
                ID  INT NOT NULL,
                BRAND  TEXT NOT NULL,
                PRIMARY KEY ( ID )
 );
  
CREATE TABLE DRIVER( 
                DNI  VARCHAR (11)  NOT NULL,
                NAME  TEXT NOT NULL,
                ADDRESS  TEXT NOT NULL,
                CATEGORY__ID  INT,
                PRIMARY KEY ( DNI )
 );
  
CREATE TABLE CATEGORY( 
                ID  INT NOT NULL,
                CATEGORY  TEXT NOT NULL,
                PRIMARY KEY ( ID )
 );
  
CREATE TABLE COUNTRY( 
                ID  INT NOT NULL,
                COUNTRY  TEXT NOT NULL,
                PRIMARY KEY ( ID )
 );
  
CREATE TABLE CONTRACT( 
                CAR__PLATE  VARCHAR (7)  NOT NULL,
                TOURIST__PASSPORT  VARCHAR (11)  NOT NULL,
                END_DATE  DATETIME NOT NULL,
                PAY_METHOD  TEXT NOT NULL,
                EXTENSION  INT NOT NULL,
                DRIVER__DNI  VARCHAR (11) ,
                PRIMARY KEY ( CAR__PLATE ,TOURIST__PASSPORT )
 );
  
ALTER TABLE TOURIST ADD CONSTRAINT FK_TOURIST_COUNTRY
                  FOREIGN KEY ( COUNTRY__ID )
                 REFERENCES COUNTRY(ID );
 
ALTER TABLE CAR ADD CONSTRAINT FK_CAR_MODEL
                  FOREIGN KEY ( MODEL__ID )
                 REFERENCES MODEL(ID );
 
ALTER TABLE MODEL ADD CONSTRAINT FK_MODEL_BRAND
                  FOREIGN KEY ( BRAND__ID )
                 REFERENCES BRAND(ID );
 
ALTER TABLE DRIVER ADD CONSTRAINT FK_DRIVER_CATEGORY
                  FOREIGN KEY ( CATEGORY__ID )
                 REFERENCES CATEGORY(ID );
 
ALTER TABLE CONTRACT ADD CONSTRAINT FK_CONTRACT_CAR
                  FOREIGN KEY ( CAR__PLATE )
                 REFERENCES CAR(PLATE );
 
ALTER TABLE CONTRACT ADD CONSTRAINT FK_CONTRACT_TOURIST
                  FOREIGN KEY ( TOURIST__PASSPORT )
                 REFERENCES TOURIST(PASSPORT );
 
ALTER TABLE CONTRACT ADD CONSTRAINT FK_CONTRACT_DRIVER
                  FOREIGN KEY ( DRIVER__DNI )
                 REFERENCES DRIVER(DNI );
 
