create table CAR (
  id IDENTITY primary key,
  brand VARCHAR2(150),
  model VARCHAR2(200),
  power DOUBLE,
  year_of_issue YEAR,
  assessed_value DEC(20)
);

create table AIRPLANE (
  id IDENTITY primary key,
  brand VARCHAR2(150),
  model VARCHAR2(200),
  manufacturer VARCHAR2(500),
  year_of_issue YEAR,
  fuelCapacity INT,
  seats INT
);

create table ASSESSMENT (
   id IDENTITY primary key,
   assessed_date DATE,
   assessed_value DEC(20)
);

CREATE TABLE CAR_ASSESSMENT (
    car_id int NOT NULL,
    assessment_id int NOT NULL,
    CONSTRAINT  FOREIGN KEY (car_id )
    REFERENCES CAR (id)
    ON DELETE NO ACTION ON UPDATE NO ACTION,
    CONSTRAINT FOREIGN KEY (assessment_id)
    REFERENCES ASSESSMENT (id)
    ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE AIRPLANE_ASSESSMENT (
    airplane_id int NOT NULL,
    assessment_id int NOT NULL,
    CONSTRAINT  FOREIGN KEY (airplane_id )
    REFERENCES AIRPLANE (id)
    ON DELETE NO ACTION ON UPDATE NO ACTION,
    CONSTRAINT FOREIGN KEY (assessment_id)
    REFERENCES ASSESSMENT (id)
    ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;