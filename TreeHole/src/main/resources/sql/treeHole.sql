/*
Navicat MySQL Data Transfer
Source Server         : conn
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : blog
Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001
Date: 2018-07-04 16:50:36
*/

SET FOREIGN_KEY_CHECKS=0;

-- -------------------------
-- Table structure for user
-- -------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userid` int(11) NOT NULL AUTO_INCREMENT,
  `nickname` varchar(50) NOT NULL COMMENT '昵称',
  `password` varchar(50) NOT NULL COMMENT '密码',
  `gender` ENUM('男','女','保密')DEFAULT '保密' COMMENT '性别',
  `age` int(3) DEFAULT '0' COMMENT '年龄',
  `info` varchar(255) DEFAULT NULL COMMENT '简介',
  `realname` varchar(50) DEFAULT NULL COMMENT '真实姓名',
  PRIMARY KEY (`userid`),
  UNIQUE KEY (`nickname`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='用户表';


-- ---------------------------------
-- Table structure for allTreeHoles
-- ---------------------------------
DROP TABLE IF EXISTS `allTreeHoles`;
CREATE TABLE `allTreeHoles` (
  `essayid` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL COMMENT '发布者id',
  `releasetime` DATETIME DEFAULT now() COMMENT '发布时间',
  `tag` varchar(20) DEFAULT NULL COMMENT '文章分类',
  PRIMARY KEY (`essayid`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='首页文章列表';


-- ------------------------------
-- Table structure for essayInfo
-- ------------------------------
DROP TABLE IF EXISTS `essayInfo`;
CREATE TABLE `essayInfo` (
  `essayid` int(11) NOT NULL,
  `info` varchar(1000) NOT NULL COMMENT '文章内容',
  `authorId` int(11) NOT NULL COMMENT '作者id',
  PRIMARY KEY (`essayid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='文章详细内容';


-- ----------------------------------
-- Table structure for essayComments
-- ----------------------------------
DROP TABLE IF EXISTS `essayComments`;
CREATE TABLE `essayComments` (
  `essayid` int(11) NOT NULL,
  `commentsUserId` int(11) DEFAULT NULL COMMENT '评论者id',
  `commentstime` DATETIME DEFAULT now() COMMENT '评论时间',
  `commentsInfo` VARCHAR(1000) NOT NULL COMMENT '评论信息',
  PRIMARY KEY (`essayid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='文章-评论对应表';
