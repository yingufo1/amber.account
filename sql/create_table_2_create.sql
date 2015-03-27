/*==============================================================*/
/* Table: "account_definition"                                  */
/*==============================================================*/
create table "account_definition"  (
   "id"                 NUMBER(11)                      not null,
   "name"               VARCHAR2(64)                    not null,
   "min_surplus"        NUMBER(12)                      not null
      constraint CKC_MIN_SURPLUS_ACCOUNT_ check ("min_surplus" >= 0),
   "max_surplus"        NUMBER(12)                      not null,
   "user_own_max_count" NUMBER(1)                       not null,
   "is_allow_child"     boolean                         not null,
   "is_allow_relate"    boolean                         not null,
   "type"               VARCHAR2(2)                     not null,
   constraint PK_ACCOUNT_DEFINITION primary key ("id")
);



/*==============================================================*/
/* Table: "account"                                             */
/*==============================================================*/
create table "account"  (
   "id"                 NUMBER(11)                      not null,
   "code"               VARCHAR2(32)                    not null,
   "name"               VARCHAR2(64)                    not null,
   "surplus"            NUMBER(12)                      not null,
   "account_definition_id" NUMBER(11)                      not null,
   "customer_id"        NUMBER(11)                      not null,
   "status"             varchar(2)                      not null,
   constraint PK_ACCOUNT primary key ("id")
);



/*==============================================================*/
/* Table: "system_service_log"                                  */
/*==============================================================*/
create table "system_service_log"  (
   "id"                 NUMBER(11)                      not null,
   "service_provider"   VARCHAR2(64)                    not null,
   "message_id"         VARCHAR2(32)                    not null,
   "log_date"           DATE                            not null,
   "service_ip"         VARCHAR2(15),
   "service_host_name"  VARCHAR2(64),
   constraint PK_SYSTEM_SERVICE_LOG primary key ("id")
);



/*==============================================================*/
/* Table: "account_surplus_log"                                 */
/*==============================================================*/
create table "account_surplus_log"  (
   "id"                 NUMBER(11)                      not null,
   "log_seq_no"         NUMBER(24)                      not null,
   "accounting_flag"    VARCHAR2(1)                     not null,
   "amount"             NUMBER(12)                      not null,
   "sys_ser_log_id"     NUMBER(11)                      not null,
   "account_id"         NUMBER(11),
   constraint PK_ACCOUNT_SURPLUS_LOG primary key ("id")
);