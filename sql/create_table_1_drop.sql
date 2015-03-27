/*==============================================================*/
/* Table: "account_definition"                                  */
/*==============================================================*/
alter table "account"
   drop constraint FK_ACC_ACC_DEFI_ID;

drop table "account_definition" cascade constraints;

/*==============================================================*/
/* drop Table: "account"                                  */
/*=======================================================*/
alter table "account"
   drop constraint FK_ACC_ACC_DEFI_ID;

alter table "account_log"
   drop constraint FK_ACCOUNT_LOG_ACCOUNT_ID;

drop table "account" cascade constraints;


/*==============================================================*/
/* drop Table: "system_service_log"                                  */
/*=======================================================*/

alter table "account_log"
   drop constraint FK_ACC_LOG_SYS_SERVICE_LOG_ID;

drop table "system_service_log" cascade constraints;


/*==============================================================*/
/* drop Table: "account_surplus_log"                                  */
/*=======================================================*/
alter table "account_surplus_log"
   drop constraint FK_ACCOUNT_LOG_ACCOUNT_ID;

alter table "account_surplus_log"
   drop constraint FK_ACC_LOG_SYS_SERVICE_LOG_ID;

drop table "account_surplus_log" cascade constraints;


