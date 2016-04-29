CREATE TABLE `admin` (
  `AdminID` varchar(20) NOT NULL,
  `AName` varchar(50) DEFAULT NULL,
  `APwd` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`AdminID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

CREATE TABLE `book` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `book_id` varchar(32) NOT NULL DEFAULT '1' COMMENT '图书id',
  `book_name` varchar(50) NOT NULL DEFAULT '0' COMMENT '图书名称',
  `description` varchar(100) NOT NULL DEFAULT '0' COMMENT '描述',
  `price` decimal(10,0) NOT NULL DEFAULT '0' COMMENT '价格',
  `current_price` decimal(10,0) NOT NULL DEFAULT '0' COMMENT '当前价格',
  `discount` int(10) unsigned NOT NULL DEFAULT '100' COMMENT '折扣',
  `category_id` int(11) NOT NULL DEFAULT '1' COMMENT '类别id',
  `publish` varchar(50) DEFAULT NULL COMMENT '出版社',
  `author` varchar(20) DEFAULT '佚名' COMMENT '作者',
  `surplus` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '剩余量',
  `publish_date` timestamp NULL DEFAULT NULL,
  `state` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `book_id` (`book_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8
CREATE TABLE `book_dynamic_info` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `book_id` varchar(32) NOT NULL DEFAULT '1' COMMENT '未结束竞品的id',
  `collect_count` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '收藏人数',
  `buy_count` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '购买人数',
  `browse_count` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '浏览人数',
  PRIMARY KEY (`id`),
  UNIQUE KEY `book_id` (`book_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8
CREATE TABLE `cart` (
  `BookID` varchar(20) NOT NULL,
  `UID` varchar(20) NOT NULL,
  `CartID` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8
CREATE TABLE `category` (
  `category_id` int(11) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(100) NOT NULL,
  PRIMARY KEY (`category_id`),
  UNIQUE KEY `category_name` (`category_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8
CREATE TABLE `comments` (
  `BookID` varchar(20) NOT NULL,
  `UID` varchar(20) NOT NULL,
  `comments` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8
CREATE TABLE `orders` (
  `OrderID` varchar(20) NOT NULL,
  `UID` varchar(20) NOT NULL,
  `Address` varchar(500) NOT NULL,
  `Telphone` varchar(50) NOT NULL,
  `OrderTime` datetime NOT NULL,
  `CartID` varchar(20) NOT NULL,
  `Status` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`OrderID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8
CREATE TABLE `seller` (
  `SellerID` varchar(20) NOT NULL,
  `SName` varchar(50) DEFAULT NULL,
  `SPwd` varchar(50) DEFAULT NULL,
  `TEL` varchar(50) DEFAULT NULL,
  `Email` varchar(100) DEFAULT NULL,
  `IDCard` varchar(50) NOT NULL,
  `ShopID` varchar(20) NOT NULL,
  PRIMARY KEY (`SellerID`),
  UNIQUE KEY `IDCard` (`IDCard`),
  UNIQUE KEY `SName` (`SName`),
  KEY `FK_seller` (`ShopID`),
  CONSTRAINT `FK_seller` FOREIGN KEY (`ShopID`) REFERENCES `shop` (`ShopID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8
CREATE TABLE `shop` (
  `ShopID` varchar(20) NOT NULL,
  `ShopName` varchar(50) DEFAULT NULL,
  `ShopDes` varchar(500) NOT NULL,
  `book_id` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`ShopID`),
  UNIQUE KEY `ShopName` (`ShopName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

CREATE TABLE `user` (
  `UID` varchar(20) NOT NULL,
  `UName` varchar(50) DEFAULT NULL,
  `UPwd` varchar(50) DEFAULT NULL,
  `TEL` varchar(50) DEFAULT NULL,
  `Email` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`UID`),
  UNIQUE KEY `UName` (`UName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8