CREATE TABLE DRIVER( 
                DNI  VARCHAR (11)  NOT NULL,
                NAME  TEXT NOT NULL,
                CATEGORY  TEXT NOT NULL,
                ADDRESS  TEXT NOT NULL,
                PRIMARY KEY ( DNI )
 );
  
CREATE TABLE TOURIST( 
                PASSPORT  VARCHAR (11)  NOT NULL,
                NAME  TEXT NOT NULL,
                AGE  SMALLINT NOT NULL,
                SEX  BINARY NOT NULL,
                COUNTRY  TEXT NOT NULL,
                CONTACT  TEXT NOT NULL,
                PRIMARY KEY ( PASSPORT )
 );
  
CREATE TABLE CAR( 
                PLATE  VARCHAR (7)  NOT NULL,
                BRAND  TEXT NOT NULL,
                MODEL  TEXT NOT NULL,
                COLOR  TEXT NOT NULL,
                CANTKM  INT NOT NULL,
                STATE  TEXT NOT NULL,
                PRIMARY KEY ( PLATE )
 );
  
CREATE TABLE CONTRACT( 
                CAR__PLATE  VARCHAR (7)  NOT NULL,
                TOURIST__PASSPORT  VARCHAR (11)  NOT NULL,
                END_DATE  DATE NOT NULL,
                PAY_METHOD  TEXT NOT NULL,
                EXTENSION  INT NOT NULL,
                START_DATE  DATE NOT NULL,
                DRIVER__DNI  VARCHAR (11) ,
                PRIMARY KEY ( CAR__PLATE ,TOURIST__PASSPORT )
 );
  
ALTER TABLE CONTRACT ADD CONSTRAINT FK_CONTRACT_CAR
                  FOREIGN KEY ( CAR__PLATE )
                 REFERENCES CAR(PLATE );
 
ALTER TABLE CONTRACT ADD CONSTRAINT FK_CONTRACT_TOURIST
                  FOREIGN KEY ( TOURIST__PASSPORT )
                 REFERENCES TOURIST(PASSPORT );
 
ALTER TABLE CONTRACT ADD CONSTRAINT FK_CONTRACT_DRIVER
                  FOREIGN KEY ( DRIVER__DNI )
                 REFERENCES DRIVER(DNI );
 
