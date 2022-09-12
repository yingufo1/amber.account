-- 创建账户余额表
DROP TABLE IF EXISTS `amber_00`.`t_account_0000`;
CREATE TABLE `amber_00`.`t_account_0000`(
  `id` BIGINT(20) NOT NULL COMMENT '唯一主键',
  `account_no` VARCHAR(32) NOT NULL COMMENT '账户号，唯一',
  `level` TINYINT(4) NULL COMMENT '账户级别',
  `account_name` VARCHAR(64) NULL COMMENT '账户名',
  `parent_id` BIGINT(20) NULL COMMENT '父账户id，通过id关联',
  `balance` DECIMAL(20,2) NOT NULL COMMENT '账户余额',
  `available_balance` DECIMAL(20,2) NOT NULL COMMENT '可用余额',
  `frozen_balance` DECIMAL(20,2) NOT NULL COMMENT '冻结余额',
  `direction` char(1) NOT NULL COMMENT '余额方向，C-贷记;D-借记',
  `status` TINYINT(4) NOT NULL DEFAULT '1' COMMENT '状态，1-正常；2-冻结；3-销户',
  `forbidden_flag` TINYINT(4) NOT NULL  DEFAULT '11' COMMENT '止入止出标记,11-可入可出；01-准入不准出；10-准出不准入;00-止入止出',
  `gmt_created` DATETIME NULL COMMENT '创建时间',
  `creator` VARCHAR(32) NULL COMMENT '创建者',
  `gmt_modified` DATETIME NULL COMMENT '最后修改时间',
  `modifier` VARCHAR(32) NULL COMMENT '最后修改人',
  `is_deleted` CHAR(1) NOT NULL DEFAULT 'N' COMMENT '止入止出标记,11-可入可出；01-准入不准出；10-准出不准入;00-止入止出',
  PRIMARY KEY (`id`),
  UNIQUE INDEX `account_no_UNIQUE` (`account_no` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COMMENT = '账户表';

CREATE TABLE `amber_00`.`account_0000` IF NOT EXIST(
  `id` BIGINT(20) NOT NULL COMMENT '唯一主键',
  `account_no` VARCHAR(32) NOT NULL COMMENT '账户号，唯一',
  `level` INT NULL COMMENT '账户级别',
  `account_name` VARCHAR(64) NULL COMMENT '账户名',
  `parent_id` BIGINT(20) NULL COMMENT '父账户id，通过id关联',
  `balance` DECIMAL(20,2) NOT NULL COMMENT '账户余额',
  `available_balance` DECIMAL(20,2) NOT NULL COMMENT '可用余额',
  `frozen_balance` DECIMAL(20,2) NOT NULL COMMENT '冻结余额',
  `gmt_created` DATETIME NULL,
  `creator` VARCHAR(32) NULL,
  `gmt_modified` DATETIME NULL,
  `MODIFIER` VARCHAR(32) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `account_no_UNIQUE` (`account_no` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COMMENT = '账户表';

-- 科目表
drop table `amber_00`.`subject`;

-- 创建法人表
drop table `amber_00`.`legal_person_00` if not exist;
-- 银行账户 与legal_person_00时多对一
drop table `amber_00`.`bank_account_00` if not exist;
-- 认证表 记录法人已通过哪些认证方式对其本人进行认证
drop table `amber_00`.`authentication_00` if not exist;
-- 认证记录表
drop table `amber_00`.`authentication_record_00` if not exist;
-- 会计凭证表
drop table `amber_00`.`` if not exist;
-- 会计分录表
drop table `amber_00`.`` if not exist;
-- 账户余额记录表
drop table `amber_00`.`` if not exist;
