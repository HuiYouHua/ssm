/*
 Navicat Premium Data Transfer

 Source Server         : myDatabase
 Source Server Type    : MySQL
 Source Server Version : 50721
 Source Host           : localhost:3306
 Source Schema         : ssm

 Target Server Type    : MySQL
 Target Server Version : 50721
 File Encoding         : 65001

 Date: 31/10/2018 16:00:35
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for itemList
-- ----------------------------
DROP TABLE IF EXISTS `itemList`;
CREATE TABLE `itemList` (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `price` varchar(50) DEFAULT NULL,
  `pic` varchar(50) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  `detail` char(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of itemList
-- ----------------------------
BEGIN;
INSERT INTO `itemList` VALUES (16, '苹果', '20', '2018/10/20181030160911975.png', '2018-10-30 16:09:11', '苹果描述');
INSERT INTO `itemList` VALUES (17, '栗子', '30', '2018/10/2018103016095148.png', '2018-10-30 16:09:51', '栗子描述');
INSERT INTO `itemList` VALUES (20, '香蕉', '30', '2018/10/20181030161343455.png', '2018-10-30 16:13:43', '香蕉描述');
INSERT INTO `itemList` VALUES (21, '樱桃', '20', '2018/10/20181030164922418.png', '2018-10-30 16:49:22', '樱桃描述');
INSERT INTO `itemList` VALUES (22, '樱桃22', '30', '2018/10/20181030165838773.png', '2018-10-30 16:58:38', '樱桃22描述');
COMMIT;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userid` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) NOT NULL,
  `userpwd` varchar(50) NOT NULL,
  `sex` varchar(1) NOT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES (1, 'huayoyu', 'huayoyu', '1');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
