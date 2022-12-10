/*
 Navicat Premium Data Transfer

 Source Server         : javaweb
 Source Server Type    : MySQL
 Source Server Version : 80015
 Source Host           : localhost:3306
 Source Schema         : chaoshi

 Target Server Type    : MySQL
 Target Server Version : 80015
 File Encoding         : 65001

 Date: 03/12/2022 10:05:56
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for shell
-- ----------------------------
DROP TABLE IF EXISTS `shell`;
CREATE TABLE `shell`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `count` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Pname` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Oname` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of shell
-- ----------------------------
INSERT INTO `shell` VALUES (1, '2022:12:01 20-26', '20', '进货', '泡面');
INSERT INTO `shell` VALUES (2, '2022:12:01 20-11', '10', '进货', '泡面');
INSERT INTO `shell` VALUES (3, '2022:12:01 20-11', '10', '进货', '泡面');

SET FOREIGN_KEY_CHECKS = 1;
