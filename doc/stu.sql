/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : jtee

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2016-11-06 00:30:03
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `stu`
-- ----------------------------
DROP TABLE IF EXISTS `stu`;
CREATE TABLE `stu` (
  `uid` int(11) NOT NULL,
  `uname` varchar(20) DEFAULT NULL,
  `uno` varchar(10) DEFAULT NULL,
  `score` decimal(4,2) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of stu
-- ----------------------------
INSERT INTO `stu` VALUES ('12323', '三鹿奶粉', 'n2345365', '34.98');
INSERT INTO `stu` VALUES ('13153', '投哪儿网', 'n3598211', '37.91');
INSERT INTO `stu` VALUES ('13276', '华\\夏通宝', 'n3547681', '45.79');
INSERT INTO `stu` VALUES ('13453', '华为通讯\\', 'n5657523', '12.78');
INSERT INTO `stu` VALUES ('14542', '顺丰物流', 'n3490763', '49.09');
INSERT INTO `stu` VALUES ('15349', '大公国际', 'n6782066', '78.81');
INSERT INTO `stu` VALUES ('17764', '亚信联创', 'n5672436', '54.83');
INSERT INTO `stu` VALUES ('23189', '薪火\\金融', 'n3215672', '78.87');
INSERT INTO `stu` VALUES ('24345', '腾讯\"科\"技', 'n7696573', '89.99');
INSERT INTO `stu` VALUES ('27463', '小米科技', 'n9638462', '99.74');
INSERT INTO `stu` VALUES ('35987', '大众点评', 'n9873098', '87.32');
