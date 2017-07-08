/*
Navicat MySQL Data Transfer

Source Server         : jiajingong
Source Server Version : 50519
Source Host           : localhost:3306
Source Database       : didi

Target Server Type    : MYSQL
Target Server Version : 50519
File Encoding         : 65001

Date: 2017-07-08 11:48:31
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `name` varchar(50) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `password` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('sa', '123');

-- ----------------------------
-- Table structure for `car`
-- ----------------------------
DROP TABLE IF EXISTS `car`;
CREATE TABLE `car` (
  `carnuber` varchar(50) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `cartype` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `carcompany` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `carpurchase` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `carusetime` int(11) DEFAULT NULL,
  PRIMARY KEY (`carnuber`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of car
-- ----------------------------

-- ----------------------------
-- Table structure for `driver`
-- ----------------------------
DROP TABLE IF EXISTS `driver`;
CREATE TABLE `driver` (
  `username` varchar(50) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `password` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `name` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `sex` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `driverage` int(11) DEFAULT NULL,
  `phonenumber` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of driver
-- ----------------------------
INSERT INTO `driver` VALUES ('jia', '123', '王五', '男', '19', '2', '123456');

-- ----------------------------
-- Table structure for `driverhistory`
-- ----------------------------
DROP TABLE IF EXISTS `driverhistory`;
CREATE TABLE `driverhistory` (
  `username` varchar(50) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `startpoint` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `endpoint` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `phonenumber` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `date` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of driverhistory
-- ----------------------------
INSERT INTO `driverhistory` VALUES ('jia', '鲁东大学', '烟台大学', '123', '2017-07-08 11:44:47');
