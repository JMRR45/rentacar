CREATE TABLE TOURIST( 
                PASSPORT  VARCHAR (9)  NOT NULL,
                NAME  TEXT NOT NULL,
                AGE  INT NOT NULL,
                SEX  CHAR NOT NULL,
                CONTACT  TEXT NOT NULL,
                COUNTRY__ID  INT,
                PRIMARY KEY ( PASSPORT )
 );
  
CREATE TABLE CATEGORY( 
                ID  INT NOT NULL,
                NAME  TEXT NOT NULL,
                PRIMARY KEY ( ID )
 );
  
CREATE TABLE DATE( 
                START_DATE  DATE NOT NULL,
                PRIMARY KEY ( START_DATE )
 );
  
CREATE TABLE DRIVER( 
                DNI  VARCHAR (11)  NOT NULL,
                NAME  TEXT NOT NULL,
                ADDRESS  TEXT NOT NULL,
                CATEGORY__ID  INT,
                PRIMARY KEY ( DNI )
 );
  
CREATE TABLE MODEL( 
                ID  INT NOT NULL,
                NAME  TEXT NOT NULL,
                BRAND__ID  INT,
                PRIMARY KEY ( ID )
 );
  
CREATE TABLE BRAND( 
                ID  INT NOT NULL,
                NAME  TEXT NOT NULL,
                PRIMARY KEY ( ID )
 );
  
CREATE TABLE COUNTRY( 
                ID  INT NOT NULL,
                NAME  TEXT NOT NULL,
                PRIMARY KEY ( ID )
 );
  
CREATE TABLE SITUATION( 
                ID  INT NOT NULL,
                NAME  TEXT NOT NULL,
                PRIMARY KEY ( ID )
 );
  
CREATE TABLE PAY_METHOD( 
                ID  INT NOT NULL,
                NAME  TEXT NOT NULL,
                PRIMARY KEY ( ID )
 );
  
CREATE TABLE CAR( 
                PLATE  VARCHAR (7)  NOT NULL,
                COLOR  TEXT NOT NULL,
                CANT_KM  INT NOT NULL,
                MODEL__ID  INT,
                SITUATION__ID  INT,
                PRIMARY KEY ( PLATE )
 );
  
CREATE TABLE CONTRACT( 
                CAR__PLATE  VARCHAR (7)  NOT NULL,
                DATE__START_DATE  DATE NOT NULL,
                END_DATE  DATE NOT NULL,
                DELIVERY_DATE  DATE NOT NULL,
                TOURIST__PASSPORT  VARCHAR (9) ,
                DRIVER__DNI  VARCHAR (11) ,
                PAY_METHOD__ID  INT,
                PRIMARY KEY ( CAR__PLATE ,DATE__START_DATE )
 );
  
ALTER TABLE TOURIST ADD CONSTRAINT FK_TOURIST_COUNTRY
                  FOREIGN KEY ( COUNTRY__ID )
                 REFERENCES COUNTRY(ID );
 
ALTER TABLE DRIVER ADD CONSTRAINT FK_DRIVER_CATEGORY
                  FOREIGN KEY ( CATEGORY__ID )
                 REFERENCES CATEGORY(ID );
 
ALTER TABLE MODEL ADD CONSTRAINT FK_MODEL_BRAND
                  FOREIGN KEY ( BRAND__ID )
                 REFERENCES BRAND(ID );
 
ALTER TABLE CAR ADD CONSTRAINT FK_CAR_MODEL
                  FOREIGN KEY ( MODEL__ID )
                 REFERENCES MODEL(ID );
 
ALTER TABLE CAR ADD CONSTRAINT FK_CAR_SITUATION
                  FOREIGN KEY ( SITUATION__ID )
                 REFERENCES SITUATION(ID );
 
ALTER TABLE CONTRACT ADD CONSTRAINT FK_CONTRACT_CAR
                  FOREIGN KEY ( CAR__PLATE )
                 REFERENCES CAR(PLATE );
 
ALTER TABLE CONTRACT ADD CONSTRAINT FK_CONTRACT_DATE
                  FOREIGN KEY ( DATE__START_DATE )
                 REFERENCES DATE(START_DATE );
 
ALTER TABLE CONTRACT ADD CONSTRAINT FK_CONTRACT_TOURIST
                  FOREIGN KEY ( TOURIST__PASSPORT )
                 REFERENCES TOURIST(PASSPORT );
 
ALTER TABLE CONTRACT ADD CONSTRAINT FK_CONTRACT_DRIVER
                  FOREIGN KEY ( DRIVER__DNI )
                 REFERENCES DRIVER(DNI );
 
ALTER TABLE CONTRACT ADD CONSTRAINT FK_CONTRACT_PAY_METHOD
                  FOREIGN KEY ( PAY_METHOD__ID )
                 REFERENCES PAY_METHOD(ID );
 
