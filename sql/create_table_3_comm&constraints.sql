
/*==============================================================*/
/* Table: "account_definition"                                  */
/*==============================================================*/
comment on table "account_definition" is
'描述账户定义';

comment on column "account_definition"."id" is
'标识';

comment on column "account_definition"."name" is
'名称';

comment on column "account_definition"."min_surplus" is
'最小余额';

comment on column "account_definition"."max_surplus" is
'最大余额';

comment on column "account_definition"."user_own_max_count" is
'允许用户拥有最大数目';

comment on column "account_definition"."is_allow_child" is
'是否允许有子账户';

comment on column "account_definition"."is_allow_relate" is
'是否允许关联其他账户';

comment on column "account_definition"."type" is
'账户类型，约束请查阅《数据字典》';



/*==============================================================*/
/* Table: "account"                                  */
/*==============================================================*/

comment on table "account" is
'客户账户';

comment on column "account"."id" is
'标识';

comment on column "account"."code" is
'账户编码';

comment on column "account"."name" is
'账户名';

comment on column "account"."surplus" is
'余额';

comment on column "account"."account_definition_id" is
'账户定义标识';

comment on column "account"."customer_id" is
'客户id';

alter table "account"
   add constraint FK_ACC_ACC_DEFI_ID foreign key ("account_definition_id")
      references "account_definition" ("id");


/*==============================================================*/
/* Table: "system_service_log"                                  */
/*==============================================================*/

comment on table "system_service_log" is
'系统服务日志';

comment on column "system_service_log"."id" is
'标识';

comment on column "system_service_log"."service_provider" is
'服务提供方';

comment on column "system_service_log"."message_id" is
'消息id';

comment on column "system_service_log"."log_date" is
'日志生成日期';

comment on column "system_service_log"."service_ip" is
'服务ip';

comment on column "system_service_log"."service_host_name" is
'服务主机名';


/*==============================================================*/
/* Table: "account_surplus_log"                                  */
/*==============================================================*/

comment on table "account_surplus_log" is
'账户余额流水';

comment on column "account_surplus_log"."id" is
'标识';

comment on column "account_surplus_log"."log_seq_no" is
'账户变动流水号';

comment on column "account_surplus_log"."accounting_flag" is
'记账标记,C:借记;D:贷记';

comment on column "account_surplus_log"."amount" is
'金额';

comment on column "account_surplus_log"."sys_ser_log_id" is
'系统服务日志id';

comment on column "account_surplus_log"."account_id" is
'账户id';

alter table "account_surplus_log"
   add constraint FK_ACCOUNT_LOG_ACCOUNT_ID foreign key ("account_id")
      references "account" ("id");

alter table "account_surplus_log"
   add constraint FK_ACC_LOG_SYS_SERVICE_LOG_ID foreign key ("sys_ser_log_id")
      references "system_service_log" ("id");