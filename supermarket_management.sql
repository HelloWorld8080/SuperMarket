/*
Navicat MySQL Data Transfer

Source Server         : niu
Source Server Version : 50714
Source Host           : localhost:3306
Source Database       : supermarket_management

Target Server Type    : MYSQL
Target Server Version : 50714
File Encoding         : 65001

Date: 2018-07-16 14:14:18
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `sm_commodity`
-- ----------------------------
DROP TABLE IF EXISTS `sm_commodity`;
CREATE TABLE `sm_commodity` (
  `commodity_id` int(11) NOT NULL AUTO_INCREMENT,
  `commodity_name` varchar(20) NOT NULL,
  `commodity_price` int(11) NOT NULL,
  `is_discount` int(11) DEFAULT NULL,
  `discount_start_at` date DEFAULT NULL,
  `discount_end_at` date DEFAULT NULL,
  `commodity_bar_code` varchar(40) NOT NULL,
  PRIMARY KEY (`commodity_id`)
) ENGINE=MyISAM AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sm_commodity
-- ----------------------------
INSERT INTO `sm_commodity` VALUES ('1', '牛牛牛', '33', null, null, null, '112233');
INSERT INTO `sm_commodity` VALUES ('2', '清真牛肉', '11', null, null, null, '223344');
INSERT INTO `sm_commodity` VALUES ('4', '电灯泡', '123', '1', '2018-05-01', '2018-05-08', '123');
INSERT INTO `sm_commodity` VALUES ('5', '西红柿', '1', '1', '2018-05-10', '2018-05-03', '11');
INSERT INTO `sm_commodity` VALUES ('6', '苹果', '13', '1', '2018-05-03', '2018-05-05', '11222');
INSERT INTO `sm_commodity` VALUES ('7', '猪肉', '13', '1', '2018-05-03', '2018-05-17', '123');
INSERT INTO `sm_commodity` VALUES ('3', ' 茶叶', '200', null, null, null, '123');
INSERT INTO `sm_commodity` VALUES ('8', '面包', '10', null, null, null, '567');
INSERT INTO `sm_commodity` VALUES ('9', '蛋糕', '20', null, null, null, '89');
INSERT INTO `sm_commodity` VALUES ('11', 'iPhone10', '8888', '123', '1996-12-30', '1998-12-17', '123456');
INSERT INTO `sm_commodity` VALUES ('12', '1', '1', '1', '2018-05-02', '2018-05-05', '112222');
INSERT INTO `sm_commodity` VALUES ('13', 'Laptop', '6000', null, null, null, '112222');
INSERT INTO `sm_commodity` VALUES ('14', '玻璃杯', '15', null, null, null, '10021');

-- ----------------------------
-- Table structure for `sm_damaged`
-- ----------------------------
DROP TABLE IF EXISTS `sm_damaged`;
CREATE TABLE `sm_damaged` (
  `damaged_id` int(11) NOT NULL AUTO_INCREMENT,
  `commodity_id` int(11) NOT NULL,
  `damaged_at` date NOT NULL,
  `employee_id` int(11) NOT NULL,
  `employee_id1` int(11) NOT NULL,
  PRIMARY KEY (`damaged_id`),
  KEY `FK_Reference_7` (`employee_id1`),
  KEY `FK_Reference_8` (`employee_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sm_damaged
-- ----------------------------

-- ----------------------------
-- Table structure for `sm_employees`
-- ----------------------------
DROP TABLE IF EXISTS `sm_employees`;
CREATE TABLE `sm_employees` (
  `employee_id` int(11) NOT NULL AUTO_INCREMENT,
  `employee_name` varchar(10) NOT NULL,
  `employee_sex` int(11) NOT NULL,
  `employee_tel` varchar(11) NOT NULL,
  `employee_add` varchar(20) NOT NULL,
  `employee_at` date NOT NULL,
  PRIMARY KEY (`employee_id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sm_employees
-- ----------------------------
INSERT INTO `sm_employees` VALUES ('1', 'zz', '1', '2', '3', '2018-05-01');
INSERT INTO `sm_employees` VALUES ('5', 'justinniu', '1', '0', '山东科技大学', '2018-09-08');
INSERT INTO `sm_employees` VALUES ('2', 'Happy', '2', '0', '不告诉你', '2018-05-15');
INSERT INTO `sm_employees` VALUES ('3', 'Distiny', '1', '13210057003', '青岛', '2015-09-12');

-- ----------------------------
-- Table structure for `sm_outbound`
-- ----------------------------
DROP TABLE IF EXISTS `sm_outbound`;
CREATE TABLE `sm_outbound` (
  `outbound_id` int(11) NOT NULL AUTO_INCREMENT,
  `commodity_id` int(11) NOT NULL,
  `outbound_at` date NOT NULL,
  `employee_id` int(11) NOT NULL,
  `outbound_amount` decimal(10,0) NOT NULL,
  PRIMARY KEY (`outbound_id`),
  KEY `FK_Reference_10` (`employee_id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sm_outbound
-- ----------------------------
INSERT INTO `sm_outbound` VALUES ('1', '1', '2018-12-17', '1', '10');
INSERT INTO `sm_outbound` VALUES ('2', '2', '2018-12-17', '1', '10');
INSERT INTO `sm_outbound` VALUES ('3', '2', '2018-12-17', '1', '10');
INSERT INTO `sm_outbound` VALUES ('4', '2', '2017-12-18', '1', '1');
INSERT INTO `sm_outbound` VALUES ('5', '2', '2017-12-18', '1', '1');

-- ----------------------------
-- Table structure for `sm_purchase`
-- ----------------------------
DROP TABLE IF EXISTS `sm_purchase`;
CREATE TABLE `sm_purchase` (
  `purchase_id` int(11) NOT NULL,
  `purchase_at` date NOT NULL,
  `employee_id` int(11) NOT NULL,
  PRIMARY KEY (`purchase_id`),
  KEY `FK_Reference_11` (`employee_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sm_purchase
-- ----------------------------
INSERT INTO `sm_purchase` VALUES ('1', '2018-05-17', '1');
INSERT INTO `sm_purchase` VALUES ('2', '2018-05-17', '1');
INSERT INTO `sm_purchase` VALUES ('3', '2018-05-17', '1');
INSERT INTO `sm_purchase` VALUES ('4', '2018-05-01', '1');
INSERT INTO `sm_purchase` VALUES ('9', '2018-05-04', '1');
INSERT INTO `sm_purchase` VALUES ('7', '2018-05-02', '1');
INSERT INTO `sm_purchase` VALUES ('10', '2018-05-02', '1');
INSERT INTO `sm_purchase` VALUES ('20', '1996-12-30', '1');
INSERT INTO `sm_purchase` VALUES ('1231', '1996-12-30', '1');
INSERT INTO `sm_purchase` VALUES ('44', '1996-12-30', '1');
INSERT INTO `sm_purchase` VALUES ('199', '2018-07-14', '1');
INSERT INTO `sm_purchase` VALUES ('197', '2018-07-06', '1');

-- ----------------------------
-- Table structure for `sm_purchase_child`
-- ----------------------------
DROP TABLE IF EXISTS `sm_purchase_child`;
CREATE TABLE `sm_purchase_child` (
  `purchild_id` int(11) NOT NULL AUTO_INCREMENT,
  `purchase_id` int(11) NOT NULL,
  `commodity_id` int(11) NOT NULL,
  `purchase_price` decimal(10,0) NOT NULL,
  `supplier_id` int(11) NOT NULL,
  `purchase_amount` decimal(10,0) NOT NULL,
  PRIMARY KEY (`purchild_id`),
  KEY `FK_Reference_1` (`purchase_id`),
  KEY `commodity_id` (`commodity_id`)
) ENGINE=MyISAM AUTO_INCREMENT=44 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sm_purchase_child
-- ----------------------------
INSERT INTO `sm_purchase_child` VALUES ('1', '1', '1', '2', '1', '250');
INSERT INTO `sm_purchase_child` VALUES ('2', '1', '2', '3', '1', '300');
INSERT INTO `sm_purchase_child` VALUES ('5', '2', '9', '4', '3', '3');
INSERT INTO `sm_purchase_child` VALUES ('6', '1', '5', '1', '1', '1');
INSERT INTO `sm_purchase_child` VALUES ('7', '1', '4', '123', '123', '123');
INSERT INTO `sm_purchase_child` VALUES ('8', '1', '3', '3', '4', '5');
INSERT INTO `sm_purchase_child` VALUES ('9', '7', '8', '1', '1', '1');
INSERT INTO `sm_purchase_child` VALUES ('10', '1', '2', '3', '4', '1');
INSERT INTO `sm_purchase_child` VALUES ('11', '20', '1', '1', '1', '1');
INSERT INTO `sm_purchase_child` VALUES ('12', '20', '2', '1', '1', '1');
INSERT INTO `sm_purchase_child` VALUES ('13', '1', '1', '1', '1', '1');
INSERT INTO `sm_purchase_child` VALUES ('14', '1', '1', '1', '2', '1');
INSERT INTO `sm_purchase_child` VALUES ('15', '1', '1', '1', '1', '1');
INSERT INTO `sm_purchase_child` VALUES ('16', '1', '1', '1', '2', '4');
INSERT INTO `sm_purchase_child` VALUES ('17', '1', '1', '2', '3', '4');
INSERT INTO `sm_purchase_child` VALUES ('18', '2', '1', '2', '3', '4');
INSERT INTO `sm_purchase_child` VALUES ('19', '1', '1', '1', '1', '1');
INSERT INTO `sm_purchase_child` VALUES ('20', '1', '1', '1', '4', '1');
INSERT INTO `sm_purchase_child` VALUES ('21', '1', '1', '1', '1', '1');
INSERT INTO `sm_purchase_child` VALUES ('22', '1', '1', '1', '1', '1');
INSERT INTO `sm_purchase_child` VALUES ('23', '2', '2', '2', '2', '2');
INSERT INTO `sm_purchase_child` VALUES ('24', '1', '1', '2', '3', '4');
INSERT INTO `sm_purchase_child` VALUES ('25', '2', '1', '2', '3', '4');
INSERT INTO `sm_purchase_child` VALUES ('26', '2', '4', '5', '6', '7');
INSERT INTO `sm_purchase_child` VALUES ('27', '2', '4', '7', '9', '1');
INSERT INTO `sm_purchase_child` VALUES ('28', '2', '4', '7', '9', '1');
INSERT INTO `sm_purchase_child` VALUES ('29', '2', '4', '7', '9', '1');
INSERT INTO `sm_purchase_child` VALUES ('30', '2', '1', '3', '7', '8');
INSERT INTO `sm_purchase_child` VALUES ('31', '20', '1', '2', '4', '5');
INSERT INTO `sm_purchase_child` VALUES ('32', '2', '1', '50', '6', '6000');
INSERT INTO `sm_purchase_child` VALUES ('33', '2', '222', '400', '5000', '600');
INSERT INTO `sm_purchase_child` VALUES ('34', '0', '6000', '800', '1012', '12');
INSERT INTO `sm_purchase_child` VALUES ('35', '299', '121', '12', '1212', '123');
INSERT INTO `sm_purchase_child` VALUES ('36', '299', '8888', '9999', '1000', '10');
INSERT INTO `sm_purchase_child` VALUES ('37', '1', '2', '3', '4', '4');
INSERT INTO `sm_purchase_child` VALUES ('38', '1', '1', '2', '4', '5');
INSERT INTO `sm_purchase_child` VALUES ('39', '2', '2', '3', '4', '2');
INSERT INTO `sm_purchase_child` VALUES ('40', '13123', '1', '3', '111', '4');
INSERT INTO `sm_purchase_child` VALUES ('41', '13123', '1', '3', '111', '4');
INSERT INTO `sm_purchase_child` VALUES ('42', '13123', '1', '2', '3', '123');
INSERT INTO `sm_purchase_child` VALUES ('43', '13123', '123', '123', '12', '12');

-- ----------------------------
-- Table structure for `sm_receipt`
-- ----------------------------
DROP TABLE IF EXISTS `sm_receipt`;
CREATE TABLE `sm_receipt` (
  `receipt_id` int(11) NOT NULL AUTO_INCREMENT,
  `receipt_at` date NOT NULL,
  `employee_id` int(11) NOT NULL,
  `receipt_desk` int(11) NOT NULL,
  `receipt_cost` decimal(10,0) NOT NULL,
  PRIMARY KEY (`receipt_id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sm_receipt
-- ----------------------------
INSERT INTO `sm_receipt` VALUES ('1', '2018-05-23', '1', '2', '30');

-- ----------------------------
-- Table structure for `sm_receipt_child`
-- ----------------------------
DROP TABLE IF EXISTS `sm_receipt_child`;
CREATE TABLE `sm_receipt_child` (
  `rechild_id` int(11) NOT NULL AUTO_INCREMENT,
  `receipt_id` int(11) NOT NULL,
  `commodity_id` int(11) NOT NULL,
  `receipt_amount` decimal(10,0) NOT NULL,
  `receipt_price` decimal(10,0) NOT NULL,
  `receipt_discount` decimal(10,0) NOT NULL,
  `receipt_expense` decimal(10,0) NOT NULL,
  PRIMARY KEY (`rechild_id`),
  KEY `FK_Reference_3` (`receipt_id`),
  KEY `FK_Reference_5` (`commodity_id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sm_receipt_child
-- ----------------------------
INSERT INTO `sm_receipt_child` VALUES ('1', '1', '2', '2', '5', '0', '10');
INSERT INTO `sm_receipt_child` VALUES ('2', '1', '6', '3', '5', '5', '10');
INSERT INTO `sm_receipt_child` VALUES ('3', '1', '4', '3', '7', '11', '10');

-- ----------------------------
-- Table structure for `sm_reserve`
-- ----------------------------
DROP TABLE IF EXISTS `sm_reserve`;
CREATE TABLE `sm_reserve` (
  `reserve_id` int(11) NOT NULL AUTO_INCREMENT,
  `commodity_id` int(11) NOT NULL,
  `reserve_at` date NOT NULL,
  `employee_id` int(11) NOT NULL,
  `reserve_amount` decimal(10,0) NOT NULL,
  PRIMARY KEY (`reserve_id`),
  KEY `FK_Reference_9` (`employee_id`)
) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sm_reserve
-- ----------------------------
INSERT INTO `sm_reserve` VALUES ('1', '1', '1996-12-17', '1', '1');
INSERT INTO `sm_reserve` VALUES ('2', '2', '2018-05-16', '1', '1');
INSERT INTO `sm_reserve` VALUES ('3', '31', '2018-06-29', '2', '1');
INSERT INTO `sm_reserve` VALUES ('4', '31', '2018-06-29', '2', '1');
INSERT INTO `sm_reserve` VALUES ('5', '31', '2018-06-29', '2', '1');
INSERT INTO `sm_reserve` VALUES ('6', '31', '2018-06-29', '2', '1');
INSERT INTO `sm_reserve` VALUES ('7', '31', '2018-06-29', '2', '1');
INSERT INTO `sm_reserve` VALUES ('8', '10', '2018-06-29', '2', '1');
INSERT INTO `sm_reserve` VALUES ('9', '9', '2018-06-29', '2', '1');
INSERT INTO `sm_reserve` VALUES ('10', '4', '2018-06-29', '2', '2');

-- ----------------------------
-- Table structure for `sm_storage`
-- ----------------------------
DROP TABLE IF EXISTS `sm_storage`;
CREATE TABLE `sm_storage` (
  `commodity_id` int(11) NOT NULL,
  `storage_amount` int(11) NOT NULL,
  `storage_check_at` date NOT NULL,
  `employee_id` int(11) NOT NULL,
  `storage_alert` decimal(10,0) NOT NULL,
  PRIMARY KEY (`commodity_id`),
  KEY `FK_Reference_6` (`employee_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sm_storage
-- ----------------------------
INSERT INTO `sm_storage` VALUES ('5', '10', '2018-12-17', '1', '109');
INSERT INTO `sm_storage` VALUES ('2', '28', '2018-12-17', '1', '10');
INSERT INTO `sm_storage` VALUES ('3', '10', '2018-12-17', '1', '10');
INSERT INTO `sm_storage` VALUES ('4', '12', '2018-12-17', '1', '109');
INSERT INTO `sm_storage` VALUES ('7', '10', '2018-12-17', '1', '109');
INSERT INTO `sm_storage` VALUES ('8', '10', '2018-12-17', '1', '109');
INSERT INTO `sm_storage` VALUES ('9', '11', '2018-12-17', '1', '109');
INSERT INTO `sm_storage` VALUES ('10', '11', '2018-12-17', '1', '109');
INSERT INTO `sm_storage` VALUES ('30', '10', '1996-12-30', '1', '20');

-- ----------------------------
-- Table structure for `sm_supplier`
-- ----------------------------
DROP TABLE IF EXISTS `sm_supplier`;
CREATE TABLE `sm_supplier` (
  `supplier_id` int(11) NOT NULL AUTO_INCREMENT,
  `supplier_add` varchar(20) NOT NULL,
  `supplier_name` varchar(20) NOT NULL,
  `supplier_tel` varchar(11) NOT NULL,
  `supplier_principal` varchar(20) NOT NULL,
  PRIMARY KEY (`supplier_id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sm_supplier
-- ----------------------------
INSERT INTO `sm_supplier` VALUES ('1', '山东科技大学', '牛贞昊', '13210057008', '1');
INSERT INTO `sm_supplier` VALUES ('2', '山东科技大学', '牛贞昊', '13210057008', '牛贞昊');

-- ----------------------------
-- Table structure for `sm_user`
-- ----------------------------
DROP TABLE IF EXISTS `sm_user`;
CREATE TABLE `sm_user` (
  `email` varchar(40) NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(10) NOT NULL,
  `pass_word` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sm_user
-- ----------------------------
INSERT INTO `sm_user` VALUES ('1129114837@qq.com', '5', 'niu', '123456');
INSERT INTO `sm_user` VALUES ('nullbull@yeah.net', '2', 'test', 'root');
INSERT INTO `sm_user` VALUES ('1129114837@qq.com', '3', '123', '123');
INSERT INTO `sm_user` VALUES ('nullbull@yeah.net', '6', '123', '123');
INSERT INTO `sm_user` VALUES ('1129114837@qq.com', '7', '123', '123');
INSERT INTO `sm_user` VALUES ('nullbull@yeah.net', '8', '123', '123');

-- ----------------------------
-- Table structure for `sm_vip`
-- ----------------------------
DROP TABLE IF EXISTS `sm_vip`;
CREATE TABLE `sm_vip` (
  `vip_id` int(11) NOT NULL AUTO_INCREMENT,
  `vip_name` varchar(10) NOT NULL,
  `vip_tel` varchar(11) NOT NULL,
  `vip_add` varchar(20) DEFAULT NULL,
  `vip_points` int(11) NOT NULL,
  `vip_balance` decimal(10,0) NOT NULL,
  `vip_level` int(11) NOT NULL,
  PRIMARY KEY (`vip_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sm_vip
-- ----------------------------
