#建表和初始化数据语句

CREATE TABLE `ganesha_asset` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `asset_code` varchar(255) NOT NULL DEFAULT '' COMMENT '资产ID',
  `asset_name` varchar(50) NOT NULL DEFAULT '' COMMENT '资产名称',
  `asset_unit` varchar(50) NOT NULL DEFAULT '' COMMENT '资产单位',
  `asset_unit_code` tinyint(4) NOT NULL DEFAULT '0' COMMENT '资产单位代码',
  `asset_amount` int(11) NOT NULL DEFAULT '0' COMMENT '资产总额',
  `asset_type` tinyint(4) DEFAULT '' COMMENT '资产类型',
  `expires` int(11) DEFAULT '-1' COMMENT '资产过期时间（秒），-1：永不过期',
  `description` varchar(255) NOT NULL DEFAULT '' COMMENT '资产描述',
  `m_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `c_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `index_asset_code` (`asset_code`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='资产表';

CREATE TABLE `ganesha_account_asset` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `account` varchar(255) NOT NULL DEFAULT '' COMMENT '账户',
  `asset_code` varchar(255) NOT NULL DEFAULT '' COMMENT '资产ID',
  `asset_name` varchar(50) NOT NULL DEFAULT '' COMMENT '资产名称',
  `asset_unit` varchar(50) NOT NULL DEFAULT '' COMMENT '资产单位',
  `asset_unit_code` tinyint(4) NOT NULL DEFAULT '0' COMMENT '资产单位代码',
  `asset_amount` int(11) NOT NULL DEFAULT '0' COMMENT '资产总额',
  `asset_type` tinyint(4) DEFAULT '' COMMENT '资产类型',
  `expires` int(11) DEFAULT '-1' COMMENT '资产过期时间（秒），-1：永不过期',
  `m_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `c_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `index_asset_code` (`asset_code`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='账户资产表';

CREATE TABLE `ganesha_asset_trans`(
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `trans_no` VARCHAR(255) NOT NULL DEFAULT '' COMMENT '转账流水',
  `from_account` varchar(255) NOT NULL DEFAULT '' COMMENT '转出账户',
  `to_account` VARCHAR(255) NOT NULL DEFAULT '' COMMENT '转入账户',
  `asset_code` VARCHAR(255) NOT NULL DEFAULT '' COMMENT '资产ID',
  `trans_amount` INT(11) NOT NULL DEFAULT 0 COMMENT '转出额',
  `status` TINYINT(4) NOT NULL DEFAULT 0 COMMENT '0：冻结，1：成功，2：失败',
  `m_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `c_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `index_trans_no`(`trans_no`),
  KEY `index_from_account` (`from_account`),
  KEY `index_to_account` (`to_account`)
) ENGINE = InnoDB AUTO_INCREMENT=1 DEFAULT CHAR SET =utf8mb4 COMMENT = '资产转账记录表';

################################## 活动相关表 ###########################################
CREATE TABLE `ganesha_activity`(
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `operator` VARCHAR(50) NOT NULL DEFAULT '' COMMENT '操作用户',
  `name` VARCHAR(50) NOT NULL DEFAULT '' COMMENT '活动名称',
  `start_time` DATETIME COMMENT '开始时间',
  `end_time` DATETIME COMMENT '结束时间',
  `m_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `c_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE = InnoDB AUTO_INCREMENT=1 DEFAULT CHAR SET =utf8mb4 COMMENT = '活动表';

################################## 积分相关表 ###########################################
CREATE TABLE `ganesha_integral`(
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `account_id` VARCHAR(50) NOT NULL DEFAULT '' COMMENT '账户ID',
  `balance` BIGINT(20) NOT NULL DEFAULT 0 COMMENT '账户余额',
  `freeze` CHAR(1) NOT NULL DEFAULT 'N' COMMENT '是否冻结，Y：冻结，N：解锁',
  `m_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `c_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `index_account_id`(`account_id`)
) ENGINE = InnoDB AUTO_INCREMENT=1 DEFAULT CHAR SET =utf8mb4 COMMENT = '积分表';

CREATE TABLE `ganesha_integral_add_event`(
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `account_id` VARCHAR(50) NOT NULL DEFAULT '' COMMENT '账户ID',
  `amount` BIGINT(20) NOT NULL DEFAULT 0 COMMENT '总额',
  `operator` VARCHAR(50) NOT NULL DEFAULT '' COMMENT '操作用户',
  `source` TINYINT(2) NOT NULL DEFAULT '0' COMMENT '积分来源，0：签到，1：活动，2：转账',
  `activityId` VARCHAR(50) NOT NULL DEFAULT '' COMMENT '活动ID',
  `m_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `c_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE = InnoDB AUTO_INCREMENT=1 DEFAULT CHAR SET =utf8mb4 COMMENT = '积分获取事件表';

CREATE TABLE `ganesha_integral_trans_event`(
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `m_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `c_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE = InnoDB AUTO_INCREMENT=1 DEFAULT CHAR SET =utf8mb4 COMMENT = '积分转账事件表';

CREATE TABLE `ganesha_integral_operation_event`(
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `m_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `c_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE = InnoDB AUTO_INCREMENT=1 DEFAULT CHAR SET =utf8mb4 COMMENT = '积分操作事件表';

CREATE TABLE `ganesha_integral_freeze_event`(
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `m_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `c_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE = InnoDB AUTO_INCREMENT=1 DEFAULT CHAR SET =utf8mb4 COMMENT = '积分冻结事件表';



