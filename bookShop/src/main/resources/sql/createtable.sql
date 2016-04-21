CREATE DATABASE qauction;
USE qauction;
CREATE TABLE unfinished_item_fixed_info (
  id            INT UNSIGNED     NOT NULL AUTO_INCREMENT
  COMMENT '自增id',
  item_id       VARCHAR(32)      NOT NULL DEFAULT 1
  COMMENT '竞拍物品id',
  item_name     VARCHAR(30)      NOT NULL DEFAULT ''
  COMMENT '竞品名称',
  old_degree    TINYINT UNSIGNED NOT NULL DEFAULT 5
  COMMENT '成色, 1-1成新, 2-2成新, 3-3成新, 4-4成新, 5-5成新, 6-6成新, 7-7成新, 8-8成新, 9-9成新, 10-10成新, 默认为10',
  category_id   TINYINT UNSIGNED NOT NULL DEFAULT 1
  COMMENT '类别, 1-电子, 2-衣服 etc.',
  seller_qtalk  VARCHAR(32)      NOT NULL DEFAULT ''
  COMMENT '卖家qtalk',
  state         TINYINT UNSIGNED NOT NULL DEFAULT 1
  COMMENT '拍卖物品状态, 1-未开始, 2-竞拍中, 3-竞拍成功, 4-竞拍失败',
  description   VARCHAR(100)     NOT NULL DEFAULT ''
  COMMENT '商品描述',
  start_time    TIMESTAMP        NOT NULL DEFAULT CURRENT_TIMESTAMP
  COMMENT '竞拍开始时间, 默认时当前时间, insert时自动更新',
  end_time      TIMESTAMP        NOT NULL DEFAULT '2038-01-09 03:14:07'
  COMMENT '竞拍结束时间',
  start_price   DECIMAL(6, 0)    NOT NULL DEFAULT 1
  COMMENT '起拍价格',
  step_price    DECIMAL(6, 0)    NOT NULL DEFAULT 1
  COMMENT '加价幅度, 默认1, 单位元',
  reserve_price DECIMAL(6, 0)    NOT NULL DEFAULT 1
  COMMENT '保留价, 默认1, 单位元',
  PRIMARY KEY (id),
  UNIQUE (item_id)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COMMENT = '未结束竞拍物品固定信息表';

CREATE TABLE unfinished_item_dynamic_info (
  id                   INT UNSIGNED  NOT NULL AUTO_INCREMENT
  COMMENT '自增id',
  item_id              VARCHAR(32)   NOT NULL DEFAULT 1
  COMMENT '未结束竞品的id',
  current_bidder_qtalk VARCHAR(32)   NOT NULL DEFAULT ''
  COMMENT '当前竞标人qtalk',
  current_price        DECIMAL(6, 0) NOT NULL DEFAULT 0
  COMMENT '当前价格',
  auction_count        INT UNSIGNED  NOT NULL DEFAULT 0
  COMMENT '报名人数',
  subscription_count   INT UNSIGNED  NOT NULL DEFAULT 0
  COMMENT '订阅人数',
  browse_count         INT UNSIGNED  NOT NULL DEFAULT 0
  COMMENT '浏览人数',
  PRIMARY KEY (id),
  UNIQUE (item_id)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COMMENT = '未结束竞拍物品动态信息表';

CREATE TABLE finished_item_fixed_info (
  id                 INT UNSIGNED     NOT NULL AUTO_INCREMENT
  COMMENT '自增id',
  item_id            VARCHAR(32)      NOT NULL DEFAULT 1
  COMMENT '竞品id',
  item_name          VARCHAR(10)      NOT NULL DEFAULT ''
  COMMENT '竞品名称',
  old_degree         TINYINT UNSIGNED NOT NULL DEFAULT 10
  COMMENT '成色, 1-1成新, 2-2成新, 3-3成新, 4-4成新, 5-5成新, 6-6成新, 7-7成新, 8-8成新, 9-9成新, 10-10成新, 默认为10',
  category_id        TINYINT UNSIGNED NOT NULL DEFAULT 1
  COMMENT '类别, 1-电子, 2-衣服 etc.',
  seller_qtalk       VARCHAR(32)      NOT NULL DEFAULT ''
  COMMENT '卖家qtalk',
  buyer_qtalk        VARCHAR(32)      NOT NULL DEFAULT ''
  COMMENT '买家qtalk',
  state              TINYINT UNSIGNED NOT NULL DEFAULT 1
  COMMENT '拍卖物品状态, 1-未开始, 2-竞拍中, 3-竞拍成功, 4-竞拍失败',
  description        VARCHAR(100)     NOT NULL DEFAULT ''
  COMMENT '商品描述',
  start_time         TIMESTAMP                 DEFAULT CURRENT_TIMESTAMP
  COMMENT '竞拍开始时间, 默认时当前时间, insert时自动更新',
  end_time           TIMESTAMP        NOT NULL DEFAULT '2038-01-09 03:14:07'
  COMMENT '竞拍结束时间',
  starting_price     DECIMAL(6, 0)    NOT NULL DEFAULT 1
  COMMENT '起拍价格',
  step_price         DECIMAL(6, 0)    NOT NULL DEFAULT 1
  COMMENT '加价幅度, 默认1, 单位元',
  reserve_price      DECIMAL(6, 0)    NOT NULL DEFAULT 1
  COMMENT '保留价格, 默认1, 单位元',
  final_price        DECIMAL(6, 0)    NOT NULL DEFAULT 0
  COMMENT '最终价格',
  auction_count      INT UNSIGNED     NOT NULL DEFAULT 0
  COMMENT '报名人数',
  subscription_count INT UNSIGNED     NOT NULL DEFAULT 0
  COMMENT '订阅人数',
  browse_count       INT UNSIGNED     NOT NULL DEFAULT 0
  COMMENT '浏览人数',
  PRIMARY KEY (id),
  UNIQUE (item_id)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COMMENT = '已结束竞拍物品动态信息表';

CREATE TABLE item_picture (
  id         INT UNSIGNED NOT NULL AUTO_INCREMENT
  COMMENT '自增id',
  item_id    VARCHAR(32)  NOT NULL DEFAULT 1
  COMMENT '竞品的id',
  picture_id VARCHAR(40)  NOT NULL DEFAULT ''
  COMMENT '竞拍物品pictureId',
  PRIMARY KEY (id)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COMMENT = '竞拍物品图片信息表';

CREATE TABLE item_category (
  id            INT UNSIGNED NOT NULL AUTO_INCREMENT
  COMMENT '自增id',
  category_name VARCHAR(10)  NOT NULL DEFAULT ''
  COMMENT '类别名, 唯一',
  PRIMARY KEY (id),
  UNIQUE (category_name)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COMMENT = '竞拍物品类别表';

CREATE TABLE auction_order (
  id            INT UNSIGNED  NOT NULL AUTO_INCREMENT
  COMMENT '自增id',
  item_id       VARCHAR(32)   NOT NULL DEFAULT 1
  COMMENT '竞拍物品id',
  bidder_qtalk  VARCHAR(32)   NOT NULL DEFAULT ''
  COMMENT '竞标人qtalk',
  auction_price DECIMAL(6, 0) NOT NULL DEFAULT 1
  COMMENT '此次加价后价格',
  auction_time  TIMESTAMP              DEFAULT CURRENT_TIMESTAMP
  COMMENT '此次加价时间',
  PRIMARY KEY (id)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COMMENT = '竞拍单信息表';

CREATE TABLE administrator (
  id          INT UNSIGNED NOT NULL AUTO_INCREMENT
  COMMENT '自增id',
  admin_qtalk VARCHAR(32)  NOT NULL DEFAULT ''
  COMMENT '管理员qtalk',
  PRIMARY KEY (id)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COMMENT = '竞拍单信息表';