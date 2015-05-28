/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : reservation

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2015-05-28 13:27:09
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for consume
-- ----------------------------
DROP TABLE IF EXISTS `consume`;
CREATE TABLE `consume` (
  `CID` int(10) NOT NULL AUTO_INCREMENT,
  `Cname` varchar(20) NOT NULL,
  `Mname` varchar(20) NOT NULL,
  `Mprice` varchar(20) NOT NULL,
  PRIMARY KEY (`CID`)
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of consume
-- ----------------------------
INSERT INTO `consume` VALUES ('1', '郭卓2', '红烧茄子', '20');
INSERT INTO `consume` VALUES ('2', '郭卓2', '糖醋里脊', '50');
INSERT INTO `consume` VALUES ('51', '郭卓2', '老邢羊汤', '15');
INSERT INTO `consume` VALUES ('52', '郭卓2', '锅包肉', '38');
INSERT INTO `consume` VALUES ('53', '郭卓2', '糖醋里脊', '50');
INSERT INTO `consume` VALUES ('54', '章鱼', '红烧茄子', '20');
INSERT INTO `consume` VALUES ('55', '章鱼', '糖醋里脊', '50');
INSERT INTO `consume` VALUES ('56', '章鱼', '老邢羊汤', '15');
INSERT INTO `consume` VALUES ('57', '章鱼', '锅包肉', '38');

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `MID` int(10) NOT NULL AUTO_INCREMENT,
  `Mname` varchar(20) NOT NULL,
  `Mprice` varchar(20) NOT NULL,
  PRIMARY KEY (`MID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES ('1', '红烧茄子', '20');
INSERT INTO `menu` VALUES ('2', '糖醋里脊', '50');
INSERT INTO `menu` VALUES ('3', '老邢羊汤', '15');
INSERT INTO `menu` VALUES ('4', '锅包肉', '38');

-- ----------------------------
-- Table structure for reservation
-- ----------------------------
DROP TABLE IF EXISTS `reservation`;
CREATE TABLE `reservation` (
  `ReID` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `telnumber` varchar(20) NOT NULL,
  `tablenum` varchar(20) NOT NULL,
  `retime` varchar(20) NOT NULL,
  PRIMARY KEY (`ReID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of reservation
-- ----------------------------
INSERT INTO `reservation` VALUES ('1', '郭卓2', '18463102279', 'BJ1', '525222');
INSERT INTO `reservation` VALUES ('2', '小白', '18463100361', 'DT2', '555552');
INSERT INTO `reservation` VALUES ('4', '章鱼', '18463101111', 'DT1', '6465465465');
INSERT INTO `reservation` VALUES ('6', '辛大大', '18463101111', 'BJ4', '27号晚6点');

-- ----------------------------
-- Table structure for table
-- ----------------------------
DROP TABLE IF EXISTS `table`;
CREATE TABLE `table` (
  `TID` varchar(20) NOT NULL,
  `type` int(20) NOT NULL,
  `count` int(10) NOT NULL,
  `ReFlag` int(2) NOT NULL,
  PRIMARY KEY (`TID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of table
-- ----------------------------
INSERT INTO `table` VALUES ('BJ1', '1', '4', '1');
INSERT INTO `table` VALUES ('BJ2', '1', '6', '0');
INSERT INTO `table` VALUES ('BJ3', '1', '4', '0');
INSERT INTO `table` VALUES ('BJ4', '1', '6', '1');
INSERT INTO `table` VALUES ('DT1', '0', '6', '1');
INSERT INTO `table` VALUES ('DT2', '0', '5', '1');
INSERT INTO `table` VALUES ('DT3', '0', '4', '0');
