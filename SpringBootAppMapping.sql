--------------------------------------------------------
--  File created - Thursday-June-18-2020   
--------------------------------------------------------
DROP TABLE "SCOTT"."USER_ADDRES" cascade constraints;
DROP TABLE "SCOTT"."USER_CONTRACT" cascade constraints;
DROP TABLE "SCOTT"."USER_DETAILS" cascade constraints;
DROP TABLE "SCOTT"."USER_EDUCATION" cascade constraints;
DROP TABLE "SCOTT"."USER_MASTER" cascade constraints;
--------------------------------------------------------
--  DDL for Table USER_ADDRES
--------------------------------------------------------

  CREATE TABLE "SCOTT"."USER_ADDRES" 
   (	"USER_ADDRS_ID" NUMBER(10,0), 
	"CREATE_DATE" TIMESTAMP (6), 
	"STREET_NAME" VARCHAR2(255 CHAR), 
	"CITY_NAME" VARCHAR2(255 CHAR), 
	"HOUSE_NO" VARCHAR2(255 CHAR), 
	"PIN_CODE" NUMBER(10,0), 
	"UPDATE_DATE" TIMESTAMP (6), 
	"UR_MASTER_ID" NUMBER(19,0)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table USER_CONTRACT
--------------------------------------------------------

  CREATE TABLE "SCOTT"."USER_CONTRACT" 
   (	"USER_CONTRACT_ID" NUMBER(10,0), 
	"CREATE_DATE" TIMESTAMP (6), 
	"COMPANY_NAME" VARCHAR2(255 CHAR), 
	"DURATION" VARCHAR2(255 CHAR), 
	"EXP" VARCHAR2(255 CHAR), 
	"UPDATE_DATE" TIMESTAMP (6), 
	"UR_MASTER_ID" NUMBER(19,0)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table USER_DETAILS
--------------------------------------------------------

  CREATE TABLE "SCOTT"."USER_DETAILS" 
   (	"USERID" NUMBER(10,0), 
	"CREATE_DATE" TIMESTAMP (6), 
	"ADDRS" VARCHAR2(255 CHAR), 
	"DOB" TIMESTAMP (6), 
	"DOJ" TIMESTAMP (6), 
	"EMAIL" VARCHAR2(255 CHAR), 
	"FNAME" VARCHAR2(255 CHAR), 
	"IS_ACTIVE" NUMBER(1,0), 
	"LNAME" VARCHAR2(255 CHAR), 
	"MOBILE_NO" NUMBER(19,0), 
	"PINCODE" NUMBER(10,0), 
	"UPDATE_DATE" TIMESTAMP (6), 
	"UR_MASTER_ID" NUMBER(19,0)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table USER_EDUCATION
--------------------------------------------------------

  CREATE TABLE "SCOTT"."USER_EDUCATION" 
   (	"UREDUID" NUMBER(10,0), 
	"CREATE_DATE" TIMESTAMP (6), 
	"USER_CLG_CITY_NAM" VARCHAR2(255 CHAR), 
	"UPDATE_DATE" TIMESTAMP (6), 
	"USER_BRANCH_NAME" VARCHAR2(255 CHAR), 
	"USER_CLG_NAME" VARCHAR2(255 CHAR), 
	"USER_SC_CITY_NAME" VARCHAR2(255 CHAR), 
	"USER_SC_NAME" VARCHAR2(255 CHAR), 
	"UR_MASTER_ID" NUMBER(19,0)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table USER_MASTER
--------------------------------------------------------

  CREATE TABLE "SCOTT"."USER_MASTER" 
   (	"USERM_ID" NUMBER(19,0), 
	"CREATE_DATE" TIMESTAMP (6), 
	"IS_ACTIVE" NUMBER(1,0), 
	"PASSWORD" VARCHAR2(255 CHAR), 
	"UPDATE_DATE" TIMESTAMP (6), 
	"USER_NAME" VARCHAR2(255 CHAR)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
REM INSERTING into SCOTT.USER_ADDRES
SET DEFINE OFF;
REM INSERTING into SCOTT.USER_CONTRACT
SET DEFINE OFF;
REM INSERTING into SCOTT.USER_DETAILS
SET DEFINE OFF;
REM INSERTING into SCOTT.USER_EDUCATION
SET DEFINE OFF;
REM INSERTING into SCOTT.USER_MASTER
SET DEFINE OFF;
--------------------------------------------------------
--  DDL for Index SYS_C0013772
--------------------------------------------------------

  CREATE UNIQUE INDEX "SCOTT"."SYS_C0013772" ON "SCOTT"."USER_ADDRES" ("USER_ADDRS_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C0013775
--------------------------------------------------------

  CREATE UNIQUE INDEX "SCOTT"."SYS_C0013775" ON "SCOTT"."USER_CONTRACT" ("USER_CONTRACT_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C0013778
--------------------------------------------------------

  CREATE UNIQUE INDEX "SCOTT"."SYS_C0013778" ON "SCOTT"."USER_DETAILS" ("USERID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C0013781
--------------------------------------------------------

  CREATE UNIQUE INDEX "SCOTT"."SYS_C0013781" ON "SCOTT"."USER_EDUCATION" ("UREDUID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C0013783
--------------------------------------------------------

  CREATE UNIQUE INDEX "SCOTT"."SYS_C0013783" ON "SCOTT"."USER_MASTER" ("USERM_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  Constraints for Table USER_ADDRES
--------------------------------------------------------

  ALTER TABLE "SCOTT"."USER_ADDRES" MODIFY ("USER_ADDRS_ID" NOT NULL ENABLE);
 
  ALTER TABLE "SCOTT"."USER_ADDRES" MODIFY ("UR_MASTER_ID" NOT NULL ENABLE);
 
  ALTER TABLE "SCOTT"."USER_ADDRES" ADD PRIMARY KEY ("USER_ADDRS_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 NOCOMPRESS LOGGING
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table USER_CONTRACT
--------------------------------------------------------

  ALTER TABLE "SCOTT"."USER_CONTRACT" MODIFY ("USER_CONTRACT_ID" NOT NULL ENABLE);
 
  ALTER TABLE "SCOTT"."USER_CONTRACT" MODIFY ("UR_MASTER_ID" NOT NULL ENABLE);
 
  ALTER TABLE "SCOTT"."USER_CONTRACT" ADD PRIMARY KEY ("USER_CONTRACT_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 NOCOMPRESS LOGGING
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table USER_DETAILS
--------------------------------------------------------

  ALTER TABLE "SCOTT"."USER_DETAILS" MODIFY ("USERID" NOT NULL ENABLE);
 
  ALTER TABLE "SCOTT"."USER_DETAILS" MODIFY ("UR_MASTER_ID" NOT NULL ENABLE);
 
  ALTER TABLE "SCOTT"."USER_DETAILS" ADD PRIMARY KEY ("USERID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 NOCOMPRESS LOGGING
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table USER_EDUCATION
--------------------------------------------------------

  ALTER TABLE "SCOTT"."USER_EDUCATION" MODIFY ("UREDUID" NOT NULL ENABLE);
 
  ALTER TABLE "SCOTT"."USER_EDUCATION" MODIFY ("UR_MASTER_ID" NOT NULL ENABLE);
 
  ALTER TABLE "SCOTT"."USER_EDUCATION" ADD PRIMARY KEY ("UREDUID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 NOCOMPRESS LOGGING
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table USER_MASTER
--------------------------------------------------------

  ALTER TABLE "SCOTT"."USER_MASTER" MODIFY ("USERM_ID" NOT NULL ENABLE);
 
  ALTER TABLE "SCOTT"."USER_MASTER" ADD PRIMARY KEY ("USERM_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 NOCOMPRESS LOGGING
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table USER_ADDRES
--------------------------------------------------------

  ALTER TABLE "SCOTT"."USER_ADDRES" ADD CONSTRAINT "FKE1J600S2S6EI5CGXGYU4D3OID" FOREIGN KEY ("UR_MASTER_ID")
	  REFERENCES "SCOTT"."USER_MASTER" ("USERM_ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table USER_CONTRACT
--------------------------------------------------------

  ALTER TABLE "SCOTT"."USER_CONTRACT" ADD CONSTRAINT "FKKUO5LVQDK5TT4R0VK80HJ9GVC" FOREIGN KEY ("UR_MASTER_ID")
	  REFERENCES "SCOTT"."USER_MASTER" ("USERM_ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table USER_DETAILS
--------------------------------------------------------

  ALTER TABLE "SCOTT"."USER_DETAILS" ADD CONSTRAINT "FKE48J7RIR22HC7CY6AFWM6LN3Q" FOREIGN KEY ("UR_MASTER_ID")
	  REFERENCES "SCOTT"."USER_MASTER" ("USERM_ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table USER_EDUCATION
--------------------------------------------------------

  ALTER TABLE "SCOTT"."USER_EDUCATION" ADD CONSTRAINT "FK4CIPL3H8R0X4F2GUBBBE4CMES" FOREIGN KEY ("UR_MASTER_ID")
	  REFERENCES "SCOTT"."USER_MASTER" ("USERM_ID") ENABLE;
