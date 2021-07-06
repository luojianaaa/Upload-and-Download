/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50540
Source Host           : localhost:3306
Source Database       : demo

Target Server Type    : MYSQL
Target Server Version : 50540
File Encoding         : 65001

Date: 2021-05-13 16:26:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for filedownload
-- ----------------------------
DROP TABLE IF EXISTS `filedownload`;
CREATE TABLE `filedownload` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `filename` varchar(255) DEFAULT NULL,
  `filedown_ip` varchar(255) NOT NULL,
  `downtime` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of filedownload
-- ----------------------------
INSERT INTO `filedownload` VALUES ('40', '下载说明.txt', '64.188.110.165', '2021-05-13 16:23:13');
INSERT INTO `filedownload` VALUES ('41', 'Zip.SFX', '64.188.110.165', '2021-05-13 16:23:16');
INSERT INTO `filedownload` VALUES ('42', 'www.51pptmoban.com.url', '64.188.110.165', '2021-05-13 16:23:18');
INSERT INTO `filedownload` VALUES ('43', 'WinRAR.chm', '64.188.110.165', '2021-05-13 16:23:23');
INSERT INTO `filedownload` VALUES ('44', 'txupd.exe', '64.188.110.165', '2021-05-13 16:23:25');
INSERT INTO `filedownload` VALUES ('45', 'sysdiag-full-5.0.57.0-20210125.exe', '64.188.110.165', '2021-05-13 16:23:27');

-- ----------------------------
-- Table structure for fileinfo
-- ----------------------------
DROP TABLE IF EXISTS `fileinfo`;
CREATE TABLE `fileinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `filename` varchar(255) DEFAULT NULL,
  `uploadtime` varchar(255) DEFAULT NULL,
  `filetype` varchar(255) DEFAULT NULL,
  `uploadip` varchar(255) DEFAULT NULL,
  `filesize` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of fileinfo
-- ----------------------------
INSERT INTO `fileinfo` VALUES ('51', 'Zip.SFX', '2021-05-13 16:22:49', 'SFX', '64.188.110.165', '207.50KB');
INSERT INTO `fileinfo` VALUES ('52', 'www.51pptmoban.com.url', '2021-05-13 16:22:49', 'url', '64.188.110.165', '129.00B');
INSERT INTO `fileinfo` VALUES ('53', 'WinRAR.chm', '2021-05-13 16:22:49', 'chm', '64.188.110.165', '415.04KB');
INSERT INTO `fileinfo` VALUES ('54', 'txupd.exe', '2021-05-13 16:22:49', 'exe', '64.188.110.165', '4.04MB');
INSERT INTO `fileinfo` VALUES ('55', 'sysdiag-full-5.0.57.0-20210125.exe', '2021-05-13 16:22:50', 'exe', '64.188.110.165', '17.94MB');
