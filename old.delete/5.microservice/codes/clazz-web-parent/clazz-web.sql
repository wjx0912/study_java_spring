/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 50528
 Source Host           : 127.0.0.1:3306
 Source Schema         : clazz-web

 Target Server Type    : MySQL
 Target Server Version : 50528
 File Encoding         : 65001

 Date: 13/09/2021 16:19:13
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for city
-- ----------------------------
DROP TABLE IF EXISTS `city`;
CREATE TABLE `city`  (
  `id` int(40) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of city
-- ----------------------------
INSERT INTO `city` VALUES (4, '北京');
INSERT INTO `city` VALUES (5, '南京');
INSERT INTO `city` VALUES (6, '天津');
INSERT INTO `city` VALUES (7, '杭州');
INSERT INTO `city` VALUES (8, '上海');
INSERT INTO `city` VALUES (9, '深圳');
INSERT INTO `city` VALUES (11, '福建');
INSERT INTO `city` VALUES (12, '郑州');
INSERT INTO `city` VALUES (13, '云南');
INSERT INTO `city` VALUES (15, '辽宁');
INSERT INTO `city` VALUES (16, '超级大城市');

-- ----------------------------
-- Table structure for clazz
-- ----------------------------
DROP TABLE IF EXISTS `clazz`;
CREATE TABLE `clazz`  (
  `id` int(40) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `path` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `tagId` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of clazz
-- ----------------------------
INSERT INTO `clazz` VALUES (10, '2010班', '/20210531170642.png', '13');
INSERT INTO `clazz` VALUES (11, '2011班', '/20210531170831.png', '14');
INSERT INTO `clazz` VALUES (12, '2012班', '/20210531170842.png', '5');
INSERT INTO `clazz` VALUES (13, '2013班', '/20210531170853.png', '5');
INSERT INTO `clazz` VALUES (15, '2101班', 'f4493e9a5a1e41dcb62441b95112431f.png', '5');

-- ----------------------------
-- Table structure for group
-- ----------------------------
DROP TABLE IF EXISTS `group`;
CREATE TABLE `group`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `createDate` date DEFAULT NULL,
  `clazzId` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of group
-- ----------------------------
INSERT INTO `group` VALUES (5, '1组', '2021-05-31', '11');
INSERT INTO `group` VALUES (6, '2组', '2021-05-31', '10');
INSERT INTO `group` VALUES (7, '1组', '2021-05-31', '10');
INSERT INTO `group` VALUES (8, '2组', '2021-05-31', '11');
INSERT INTO `group` VALUES (9, '3组', '2021-05-31', '11');
INSERT INTO `group` VALUES (10, '1组', '2021-09-13', '15');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `id` int(40) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `age` int(3) DEFAULT NULL,
  `qq` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `bir` date DEFAULT NULL,
  `starts` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `attr` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `mark` varchar(600) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `clazzId` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `groupId` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `cityId` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (11, 'yannan chen', 9, '344355', '01010533789', '2012-12-12', '射手座', '龙', '', '11', '5', '4');
INSERT INTO `student` VALUES (12, '小二黑', 9, '344355', '01010533789', '2012-10-11', '天秤座', '龙', '他是傻子', '15', '10', '16');

-- ----------------------------
-- Table structure for student_tag
-- ----------------------------
DROP TABLE IF EXISTS `student_tag`;
CREATE TABLE `student_tag`  (
  `sid` int(40) NOT NULL,
  `tid` int(40) NOT NULL,
  PRIMARY KEY (`sid`, `tid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of student_tag
-- ----------------------------
INSERT INTO `student_tag` VALUES (11, 16);
INSERT INTO `student_tag` VALUES (11, 17);
INSERT INTO `student_tag` VALUES (11, 18);
INSERT INTO `student_tag` VALUES (12, 3);
INSERT INTO `student_tag` VALUES (12, 6);
INSERT INTO `student_tag` VALUES (12, 16);

-- ----------------------------
-- Table structure for tag
-- ----------------------------
DROP TABLE IF EXISTS `tag`;
CREATE TABLE `tag`  (
  `id` int(40) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `type` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `createDate` date DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tag
-- ----------------------------
INSERT INTO `tag` VALUES (3, '帅哥', '学生', '2021-05-24');
INSERT INTO `tag` VALUES (4, '美女', '学生', '2021-05-24');
INSERT INTO `tag` VALUES (5, '探知源码', '班级', '2021-05-24');
INSERT INTO `tag` VALUES (6, '学渣', '学生', '2021-05-24');
INSERT INTO `tag` VALUES (13, '人数最多', '班级', '2021-05-31');
INSERT INTO `tag` VALUES (14, '坚持不懈', '班级', '2021-05-31');
INSERT INTO `tag` VALUES (15, '勤学好问', '班级', '2021-05-31');
INSERT INTO `tag` VALUES (16, '聪明', '学生', '2021-05-31');
INSERT INTO `tag` VALUES (17, '浪漫', '学生', '2021-05-31');
INSERT INTO `tag` VALUES (18, '油腻', '学生', '2021-05-31');
INSERT INTO `tag` VALUES (19, '懒惰', '学生', '2021-05-31');
INSERT INTO `tag` VALUES (20, '精英班', '班级', '2021-09-13');

SET FOREIGN_KEY_CHECKS = 1;
