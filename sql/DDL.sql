-- 创建账户余额表
drop table `amber_00`.`account_0000` if not exist;
CREATE TABLE `amber_00`.`account_0000` (
  `id` BIGINT(20) NOT NULL COMMENT '唯一主键',
  `account_no` VARCHAR(32) NOT NULL COMMENT '账户号，唯一',
  `level` INT NULL COMMENT '账户级别',
  `account_name` VARCHAR(64) NULL COMMENT '账户名',
  `parent_id` BIGINT(20) NULL COMMENT '父账户id，通过id关联',
  `balance` DECIMAL(20,2) NOT NULL COMMENT '账户余额',
  `avalivable_balance` DECIMAL(20,2) NOT NULL COMMENT '可用余额',
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

CREATE TABLE `amber_00`.`account_0001` (
  `id` BIGINT(20) NOT NULL COMMENT '唯一主键',
  `account_no` VARCHAR(32) NOT NULL COMMENT '账户号，唯一',
  `level` INT NULL COMMENT '账户级别',
  `account_name` VARCHAR(64) NULL COMMENT '账户名',
  `parent_id` BIGINT(20) NULL COMMENT '父账户id，通过id关联',
  `balance` DECIMAL(20,2) NOT NULL COMMENT '账户余额',
  `avalivable_balance` DECIMAL(20,2) NOT NULL COMMENT '可用余额',
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

CREATE TABLE `amber_01`.`account_0002` (
  `id` BIGINT(20) NOT NULL COMMENT '唯一主键',
  `account_no` VARCHAR(32) NOT NULL COMMENT '账户号，唯一',
  `level` INT NULL COMMENT '账户级别',
  `account_name` VARCHAR(64) NULL COMMENT '账户名',
  `parent_id` BIGINT(20) NULL COMMENT '父账户id，通过id关联',
  `balance` DECIMAL(20,2) NOT NULL COMMENT '账户余额',
  `avalivable_balance` DECIMAL(20,2) NOT NULL COMMENT '可用余额',
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

CREATE TABLE `amber_01`.`account_0003` (
  `id` BIGINT(20) NOT NULL COMMENT '唯一主键',
  `account_no` VARCHAR(32) NOT NULL COMMENT '账户号，唯一',
  `level` INT NULL COMMENT '账户级别',
  `account_name` VARCHAR(64) NULL COMMENT '账户名',
  `parent_id` BIGINT(20) NULL COMMENT '父账户id，通过id关联',
  `balance` DECIMAL(20,2) NOT NULL COMMENT '账户余额',
  `avalivable_balance` DECIMAL(20,2) NOT NULL COMMENT '可用余额',
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
