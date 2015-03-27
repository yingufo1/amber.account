
/*==============================================================*/
/* Table: "account_definition"                                  */
/*==============================================================*/
comment on table "account_definition" is
'�����˻�����';

comment on column "account_definition"."id" is
'��ʶ';

comment on column "account_definition"."name" is
'����';

comment on column "account_definition"."min_surplus" is
'��С���';

comment on column "account_definition"."max_surplus" is
'������';

comment on column "account_definition"."user_own_max_count" is
'�����û�ӵ�������Ŀ';

comment on column "account_definition"."is_allow_child" is
'�Ƿ����������˻�';

comment on column "account_definition"."is_allow_relate" is
'�Ƿ�������������˻�';

comment on column "account_definition"."type" is
'�˻����ͣ�Լ������ġ������ֵ䡷';



/*==============================================================*/
/* Table: "account"                                  */
/*==============================================================*/

comment on table "account" is
'�ͻ��˻�';

comment on column "account"."id" is
'��ʶ';

comment on column "account"."code" is
'�˻�����';

comment on column "account"."name" is
'�˻���';

comment on column "account"."surplus" is
'���';

comment on column "account"."account_definition_id" is
'�˻������ʶ';

comment on column "account"."customer_id" is
'�ͻ�id';

alter table "account"
   add constraint FK_ACC_ACC_DEFI_ID foreign key ("account_definition_id")
      references "account_definition" ("id");


/*==============================================================*/
/* Table: "system_service_log"                                  */
/*==============================================================*/

comment on table "system_service_log" is
'ϵͳ������־';

comment on column "system_service_log"."id" is
'��ʶ';

comment on column "system_service_log"."service_provider" is
'�����ṩ��';

comment on column "system_service_log"."message_id" is
'��Ϣid';

comment on column "system_service_log"."log_date" is
'��־��������';

comment on column "system_service_log"."service_ip" is
'����ip';

comment on column "system_service_log"."service_host_name" is
'����������';


/*==============================================================*/
/* Table: "account_surplus_log"                                  */
/*==============================================================*/

comment on table "account_surplus_log" is
'�˻������ˮ';

comment on column "account_surplus_log"."id" is
'��ʶ';

comment on column "account_surplus_log"."log_seq_no" is
'�˻��䶯��ˮ��';

comment on column "account_surplus_log"."accounting_flag" is
'���˱��,C:���;D:����';

comment on column "account_surplus_log"."amount" is
'���';

comment on column "account_surplus_log"."sys_ser_log_id" is
'ϵͳ������־id';

comment on column "account_surplus_log"."account_id" is
'�˻�id';

alter table "account_surplus_log"
   add constraint FK_ACCOUNT_LOG_ACCOUNT_ID foreign key ("account_id")
      references "account" ("id");

alter table "account_surplus_log"
   add constraint FK_ACC_LOG_SYS_SERVICE_LOG_ID foreign key ("sys_ser_log_id")
      references "system_service_log" ("id");