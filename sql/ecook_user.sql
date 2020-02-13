/*
 Navicat Premium Data Transfer

 Source Server         : qiao
 Source Server Type    : MySQL
 Source Server Version : 50715
 Source Host           : localhost:3306
 Source Schema         : ecook

 Target Server Type    : MySQL
 Target Server Version : 50715
 File Encoding         : 65001

 Date: 13/02/2020 09:53:16
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for ecook_user
-- ----------------------------
DROP TABLE IF EXISTS `ecook_user`;
CREATE TABLE `ecook_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `nickname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号码',
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码(MD5)',
  `gender` int(2) NULL DEFAULT NULL COMMENT '性别\r\n\r\n',
  `hometown` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '家乡',
  `intro` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '自我介绍',
  `head_photo` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像',
  `createtime` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `updatetime` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ecook_user
-- ----------------------------
INSERT INTO `ecook_user` VALUES (1, 'admin', '管理员', '15177778888', '123123', 1, '三里屯', '我的家在北京，我喜欢做美食和分享美食', '/images/head.jpg', '2020-02-13 09:50:02', '2020-02-14 09:50:10');

SET FOREIGN_KEY_CHECKS = 1;
