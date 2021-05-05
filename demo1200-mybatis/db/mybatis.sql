/*
Navicat MySQL Data Transfer

Source Server         : mysql3306
Source Server Version : 80016
Source Host           : 192.168.1.180:3306
Source Database       : mybatis

Target Server Type    : MYSQL
Target Server Version : 80016
File Encoding         : 65001

Date: 2019-10-14 01:47:09
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_position
-- ----------------------------
DROP TABLE IF EXISTS `tb_position`;
CREATE TABLE `tb_position` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `t_pos_name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_position
-- ----------------------------
INSERT INTO `tb_position` VALUES ('1', '教授');
INSERT INTO `tb_position` VALUES ('2', '副教授');
INSERT INTO `tb_position` VALUES ('3', '讲师');

-- ----------------------------
-- Table structure for tb_student
-- ----------------------------
DROP TABLE IF EXISTS `tb_student`;
CREATE TABLE `tb_student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `t_stu_name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_student
-- ----------------------------
INSERT INTO `tb_student` VALUES ('1', '赵依');
INSERT INTO `tb_student` VALUES ('2', '钱迩');
INSERT INTO `tb_student` VALUES ('3', '张山');
INSERT INTO `tb_student` VALUES ('4', '李石');
INSERT INTO `tb_student` VALUES ('5', '王武');
INSERT INTO `tb_student` VALUES ('6', '马柳');

-- ----------------------------
-- Table structure for tb_stu_teach
-- ----------------------------
DROP TABLE IF EXISTS `tb_stu_teach`;
CREATE TABLE `tb_stu_teach` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `t_stu_id` int(11) DEFAULT NULL,
  `t_teach_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_stu_teach
-- ----------------------------
INSERT INTO `tb_stu_teach` VALUES ('1', '1', '1');
INSERT INTO `tb_stu_teach` VALUES ('2', '1', '2');
INSERT INTO `tb_stu_teach` VALUES ('3', '1', '3');
INSERT INTO `tb_stu_teach` VALUES ('4', '2', '2');
INSERT INTO `tb_stu_teach` VALUES ('5', '2', '3');
INSERT INTO `tb_stu_teach` VALUES ('6', '2', '4');
INSERT INTO `tb_stu_teach` VALUES ('7', '3', '3');
INSERT INTO `tb_stu_teach` VALUES ('8', '3', '4');
INSERT INTO `tb_stu_teach` VALUES ('9', '3', '5');
INSERT INTO `tb_stu_teach` VALUES ('10', '4', '4');
INSERT INTO `tb_stu_teach` VALUES ('11', '4', '5');
INSERT INTO `tb_stu_teach` VALUES ('12', '4', '1');

-- ----------------------------
-- Table structure for tb_teacher
-- ----------------------------
DROP TABLE IF EXISTS `tb_teacher`;
CREATE TABLE `tb_teacher` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `t_name` varchar(255) DEFAULT NULL,
  `t_no` varchar(255) DEFAULT NULL,
  `position_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_teacher
-- ----------------------------
INSERT INTO `tb_teacher` VALUES ('1', '张文远', '163314001', '1');
INSERT INTO `tb_teacher` VALUES ('2', '赵传智', '163314002', '1');
INSERT INTO `tb_teacher` VALUES ('3', '风清扬', '163314003', '2');
INSERT INTO `tb_teacher` VALUES ('4', '王汇智', '163314004', '2');
INSERT INTO `tb_teacher` VALUES ('5', '汪思远', '163314005', '3');
