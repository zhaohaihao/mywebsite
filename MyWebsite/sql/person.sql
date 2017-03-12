/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.5.28 : Database - person_site
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`person_site` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;

USE `person_site`;

/*Table structure for table `article` */

DROP TABLE IF EXISTS `article`;

CREATE TABLE `article` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '文章编号',
  `title` varchar(32) COLLATE utf8_unicode_ci NOT NULL COMMENT '文章标题',
  `url` varchar(64) COLLATE utf8_unicode_ci NOT NULL COMMENT '文章存放地址',
  `img_id` int(11) NOT NULL DEFAULT '0' COMMENT '主题图片编号',
  `keyword` varchar(32) COLLATE utf8_unicode_ci NOT NULL COMMENT '关键字',
  `state` int(11) NOT NULL DEFAULT '0' COMMENT '状态:0未审核,1审核通过,2审核未通过,3已删除',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '上次修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `article` */

insert  into `article`(`id`,`title`,`url`,`img_id`,`keyword`,`state`,`create_time`,`update_time`) values (1,'你好','rere',1,'hi',1,'2017-03-10 23:18:18','2017-03-10 23:18:18');

/*Table structure for table `attachment` */

DROP TABLE IF EXISTS `attachment`;

CREATE TABLE `attachment` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '附件编号',
  `article_id` int(11) NOT NULL DEFAULT '0' COMMENT '文章编号',
  `title` varchar(32) COLLATE utf8_unicode_ci NOT NULL COMMENT '标题名',
  `filename` varchar(32) COLLATE utf8_unicode_ci NOT NULL COMMENT '文件名',
  `url` varchar(64) COLLATE utf8_unicode_ci NOT NULL COMMENT '附件地址',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '上传时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `attachment` */

insert  into `attachment`(`id`,`article_id`,`title`,`filename`,`url`,`create_time`) values (1,1,'哦','file','ew','2017-03-10 23:18:18');

/*Table structure for table `comment` */

DROP TABLE IF EXISTS `comment`;

CREATE TABLE `comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '评论编号',
  `type_id` int(11) NOT NULL DEFAULT '0' COMMENT '类型编号',
  `content` varchar(64) COLLATE utf8_unicode_ci NOT NULL COMMENT '评论内容',
  `parent_id` int(11) DEFAULT '0' COMMENT '评论父编号',
  `child_id` int(11) DEFAULT '0' COMMENT '评论子编号',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '评论时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `comment` */

insert  into `comment`(`id`,`type_id`,`content`,`parent_id`,`child_id`,`create_time`) values (1,1,'哈啊哈哈',1,0,'2017-03-10 23:18:18');

/*Table structure for table `count` */

DROP TABLE IF EXISTS `count`;

CREATE TABLE `count` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '统计编号',
  `type_id` int(11) NOT NULL DEFAULT '0' COMMENT '类型编号',
  `views` int(11) NOT NULL DEFAULT '0' COMMENT '浏览数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `count` */

insert  into `count`(`id`,`type_id`,`views`) values (1,1,58);

/*Table structure for table `image` */

DROP TABLE IF EXISTS `image`;

CREATE TABLE `image` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '图片编号',
  `name` varchar(32) COLLATE utf8_unicode_ci NOT NULL COMMENT '图片名称',
  `depict` varchar(64) COLLATE utf8_unicode_ci NOT NULL COMMENT '图片描述',
  `url` varchar(64) COLLATE utf8_unicode_ci NOT NULL COMMENT '图片地址',
  `type` int(11) NOT NULL DEFAULT '0' COMMENT '图片类型:0未分类,1人物,2地方,3事物',
  `state` int(11) NOT NULL DEFAULT '0' COMMENT '状态:0未审核,1审核通过,2审核未通过,3已删除',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '上传时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `image` */

insert  into `image`(`id`,`name`,`depict`,`url`,`type`,`state`,`create_time`) values (1,'人物','人物照片','sdss',1,0,'2017-03-10 23:16:36');

/*Table structure for table `type` */

DROP TABLE IF EXISTS `type`;

CREATE TABLE `type` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '类型编号',
  `obj_type` int(11) NOT NULL DEFAULT '0' COMMENT '对象类型:1图片,2文章',
  `obj_id` int(11) NOT NULL DEFAULT '0' COMMENT '对象编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `type` */

insert  into `type`(`id`,`obj_type`,`obj_id`) values (1,1,1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
