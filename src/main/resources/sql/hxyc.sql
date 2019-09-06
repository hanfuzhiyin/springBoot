/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50722
Source Host           : localhost:3306
Source Database       : hxyc

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2019-09-05 19:00:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for hxyc_user
-- ----------------------------
DROP TABLE IF EXISTS `hxyc_user`;
CREATE TABLE `hxyc_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `status` int(1) NOT NULL DEFAULT '1' COMMENT '0无效 1正常 2冻结 3彻底封锁',
  `createtime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `publickey` varchar(3000) NOT NULL COMMENT '安全码公',
  `privatekey` varchar(3000) NOT NULL COMMENT '安全码私',
  `lv` int(255) NOT NULL DEFAULT '0' COMMENT '级别',
  `Identity` int(255) NOT NULL DEFAULT '4' COMMENT '0 超管 1管理 2版主 3会员 4用户 5未验证用户 ',
  `phone` varchar(20) DEFAULT NULL COMMENT '手机号',
  `realname` varchar(50) DEFAULT NULL COMMENT '真实姓名',
  `nickname` varchar(20) DEFAULT NULL COMMENT '昵称',
  `idcard` varchar(18) DEFAULT NULL COMMENT '身份证号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
