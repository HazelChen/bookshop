CREATE DATABASE  IF NOT EXISTS `bookhouse` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `bookhouse`;
-- MySQL dump 10.13  Distrib 5.5.16, for Win32 (x86)
--
-- Host: localhost    Database: bookhouse
-- ------------------------------------------------------
-- Server version	5.5.28

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `bank`
--

DROP TABLE IF EXISTS `bank`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bank` (
  `id` varchar(45) NOT NULL,
  `balance` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bank`
--

LOCK TABLES `bank` WRITE;
/*!40000 ALTER TABLE `bank` DISABLE KEYS */;
INSERT INTO `bank` VALUES ('1',1000);
/*!40000 ALTER TABLE `bank` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `ISBN` varchar(45) NOT NULL,
  `author` varchar(45) NOT NULL,
  `press` varchar(45) NOT NULL,
  `publishDate` date NOT NULL,
  `price` double NOT NULL,
  `description` text NOT NULL,
  `category` varchar(45) NOT NULL,
  `orderFormId` int(11) DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `category_idx` (`category`),
  KEY `orderFormFK_idx` (`orderFormId`),
  CONSTRAINT `category` FOREIGN KEY (`category`) REFERENCES `category` (`category`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `orderFormFK` FOREIGN KEY (`orderFormId`) REFERENCES `orderform` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES (4,'哈利波特与魔法石','9787020033430','J.K.罗琳','人民文学出版社','2009-09-01',14.1,'“哈利波特”系列图书自1997年在英国问世以来，迄今在全世界已发行三亿多册，2000年引进中国后，前六册发行量达800万册。因此无论在世界还是在中国，“哈利波特”都创造了出版史上的奇迹。“哈利波特”是一套既有畅销效应也有常销价值的儿童小说，从内容到艺术手法都具备了世界优秀儿童文学的潜质。其故事惊险离奇、神幻莫测；情节跌宕起伏、悬念丛生，从头至尾充满幽默。作者巧妙地将世界文学名著中所具有的美学品格集于一身，达到了想象丰富，情节紧凑，推理严密，人物刻画深刻的艺术效果。同时它也是一套引导孩子们勇敢向上，见义勇为，善良待人的婿作品。难能可贵的是，“哈利波特”不仅深受孩子们的追捧，同时又为成人所喜爱。','童书',NULL,10),(5,'哈利波特与密室','9787020033447','J.K.罗琳','人民文学出版社','2000-09-01',17.6,'哈利·波特在霍格沃茨魔法学校学习一年之后，暑假开始了。他在姨父姨妈家熬过痛苦的假期。正当他准备打点行装去学校时，小精灵多比前来发出警告：如果哈利返回霍格沃茨，灾难将会临头。\r\n“哈利·波特”系列图书自1997年在英国问世以来，迄今在全世界已发行三亿多册，2000年引进中国后，前六册发行量达800万册。因此无论在世界还是在中国，“哈利·波特”都创造了出版史上的奇迹。 “哈利·波特”是一套既有畅销效应也有常销价值的儿童小说，从内容到艺术手法都具备了世界优秀儿童文学的潜质。其故事惊险离奇、神幻莫测；情节跌宕起伏、悬念丛生，从头至尾充满幽默。作者巧妙地将世界文学名著中所具有的美学品格集于一身，达到了想象丰富，情节紧凑，推理严密，人物刻画深刻的艺术效果。同时它也是一套引导孩子们勇敢向上，见义勇为，善良待人的婿作品。难能可贵的是，“哈利·波特”不仅深受孩子们的追捧，同时又为成人所喜爱。','童书',NULL,10),(6,'历史不规矩','9787544270830','张鸣','南海出版社','2014-05-01',23.9,'清朝公主的幸福指数有多高？\r\n　　李二先生是何许人也？为什么说他是汉奸？他到底是不是汉奸？\r\n　　擦干净脸上的油彩，义和团的真实面目是什么？\r\n　　从一桩和捕快有关的冤案中能否窥探历史大变局？\r\n　　风流教坊里的皇帝贵胄如何开创一代盛世？\r\n　　……\r\n　　著名学者张鸣教授最新作品，大部分文章首次问世！\r\n　　不一样的历史视角，带给你另类的历史真实！\r\n　　历史，从来不按历史学家的规矩行事。在不规矩的历史里，隐藏着古今脉通、五光十色的世界……','人文社科',NULL,10),(7,'国学治要','9787564077730','张文治','北京理工大学出版社','2014-06-01',121,'净空法师倾力推荐，誉为能复兴中华的一本书。\r\n　　国学入门之捷径，繁而不芜，简而不陋；\r\n　　中华典籍之精华，统于四部，囊括百家。\r\n　　按经、史、子、集分类的小四库全书；四书五经、二十四史、先秦诸子、汉唐文赋、明清理学、唐诗宋词、音韵训诂，提要钩玄，兼容并包。\r\n　　中华国学之精华，东方文明之宝典；经世治国之镜鉴，修身养性之源泉。\r\n　　在港、澳、台及海外华人群体中广为流传，民国大中院校学生国学入门必读。\r\n　　国内唯一中文简体可阅读版。','人文社科',NULL,10),(8,'疾风回旋曲','9787514306538','东野圭吾','现代出版社','2014-05-01',21.8,'东野圭吾最新力作\r\n　　悬念迭起 颠覆想象 拿起就无法放下的阅读体验\r\n　　《白夜行》《嫌疑人X的献身》后再度挑战逻辑极限\r\n　　日本上市7日 销量突破100万册\r\n　　日本、韩国各大畅销榜TOP1\r\n　　东野圭吾中国首次签名珍藏','文艺',NULL,10),(9,'毁灭者的秘密','9787510828140','闫达','九州出版社','2014-05-01',23.6,'天涯论坛引起轰动的推理神贴，直击命案现场的诡异手记。　\r\n 不到最后一刻，真相绝不显现。情节反转挑战人性的高推理罪案悬疑故事。　\r\n 身临其境的类型氛围。最离奇的案情，最难以承受的真相。凶手时隐时现、沉默不语，与你同枕共眠。','文艺',NULL,10),(10,'奥数精讲与测试','9787542856166','熊斌','上海科技教育出版社','2013-02-01',20,'《奥数精讲与测试五年级》丛书从小学一年级至高中三年级共12册，将数学奥林匹克竞赛的内容以精讲和测试的形式系统地组织起来，目的是为学生提供一套强化知识、提高数学素养和能力的教材，让学生通过对这套教材的学习，具备和提高参加各种数学竞赛的知识和能力，使学生不仅能把自己课内的成绩提高，而且能在各级各类数学竞赛中取得理想的成绩。\r\n　 《奥数精讲与测试 五年级》的每一讲都有“精讲”和“测试ABC卷’’组成，分设三部分内容：\r\n　1．竞赛热点、考点、知识点。将数学奥林匹克竞赛的知识、内容以及当前的热点问题和历届数学奥林匹克竞赛中经常出现的问题给予分析、归纳、阐述和总结。\r\n　2．典型例题精讲。围绕数学竞赛的热点、考点，选择典型的例题，提高对典型例题的分析、讲解，使学生能够掌握基本思想和基本方法，进而提高分析问题和解决问题的能力。\r\n　3．测试ABC卷。有针对性地选择一些名题、新题、好题给学生练习。A卷是“精讲”内容的延伸与拓展，题目难度较小；B卷进一步加强数学竞赛的基本功，突出了解题的基本技巧与方法；C卷是为准备在数学奥林匹克竞赛中取得优异成绩的同学设计的，题目具有一定的挑战性，是学生发挥自己的创造性、一显身手的试金石。','教育',NULL,10),(11,'去野吧，西藏','9787111423584','洪舒靖','机械工业出版社','2013-06-01',44.4,' 提起西藏，毫无疑问是很多人向往的旅行圣地。雄浑壮阔的世界屋脊，淳朴自然的原生态文化，能洗净灵魂的秀美风光，大昭寺、布达拉宫、罗布林卡，无不让人心驰神往。而西藏特殊的地理位置，使大多数人虽然心向往之，但又受制于种种客观因素无法成行，即使有少数人能够成行，也因为大多采用飞机、火车、汽车等旅行方式而对西藏的众多美景也仅仅是走马观花般的匆匆而过。\r\n   本书作者历时40天，用单车的车轮和自己的双脚，丈量了从成都到拉萨，2000多公里风景秀丽的川藏线，用相机和文字记录下了川藏线上的众多美景和风土人情，用朴实的笔触给众多向往西藏却无法亲身涉足的读者真实、生动、绝美的川藏线体验。\r\n   本书也不仅仅是一本游记或者路书，它还承载了作者对人生态度、生命本质的一种探寻，能够支撑着作者完成40天艰苦的单车旅行的是人性中那些最宝贵的精神：坚定的信念、理智的判断、永不认输的态度、以及来自家人、好友和团队伙伴的帮助和支持。骑行西藏需要的这些精神，不也正是我们人生历程中始终需要的那些东西吗？作者在川藏线的骑行旅程中收获了自己的精神升华，我们希望读者能从这本书中也有自己的收获。','生活',NULL,10),(12,'信息简史','9787115331809','詹姆斯•格雷克 ','人民邮电出版社','2013-11-01',48.7,'百万级销量科普畅销书作家詹姆斯格雷克七年磨一剑\r\n　　带来一段人类与信息遭遇的波澜壮阔的历史\r\n　　告诉我们如何在信息时代的信息爆炸中生存\r\n　　2011年度《纽约时报》畅销书\r\n　　2011年度《出版商周刊》年度最佳图书\r\n　　2012年度英国皇家学会科普图书奖\r\n　　美国笔会爱德华威尔逊科普文学奖\r\n　　英国笔会赫塞尔-蒂尔特曼奖得主','科技',NULL,10);
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bookcollected`
--

DROP TABLE IF EXISTS `bookcollected`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bookcollected` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customerInfoId` int(11) NOT NULL,
  `bookId` int(11) NOT NULL,
  `date` date NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKBE4EC6806B842E99` (`bookId`),
  KEY `FKBE4EC6802D20D6B9` (`customerInfoId`),
  CONSTRAINT `bookId_collected` FOREIGN KEY (`bookId`) REFERENCES `book` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `customerInfoId_collected` FOREIGN KEY (`customerInfoId`) REFERENCES `customerinfo` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bookcollected`
--

LOCK TABLES `bookcollected` WRITE;
/*!40000 ALTER TABLE `bookcollected` DISABLE KEYS */;
INSERT INTO `bookcollected` VALUES (1,2,4,'2014-06-02');
/*!40000 ALTER TABLE `bookcollected` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bookincart`
--

DROP TABLE IF EXISTS `bookincart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bookincart` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customerInfoId` int(11) NOT NULL,
  `bookId` int(11) NOT NULL,
  `date` date NOT NULL,
  `count` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `FKAE1015EE6B842E99` (`bookId`),
  KEY `FKAE1015EE2D20D6B9` (`customerInfoId`),
  CONSTRAINT `bookId_cart` FOREIGN KEY (`bookId`) REFERENCES `book` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `customerInfoId_cart` FOREIGN KEY (`customerInfoId`) REFERENCES `customerinfo` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bookincart`
--

LOCK TABLES `bookincart` WRITE;
/*!40000 ALTER TABLE `bookincart` DISABLE KEYS */;
INSERT INTO `bookincart` VALUES (1,2,4,'2014-06-03',3),(3,2,5,'2014-06-03',1);
/*!40000 ALTER TABLE `bookincart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `buybook`
--

DROP TABLE IF EXISTS `buybook`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `buybook` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `orderFormId` int(11) NOT NULL,
  `bookId` int(11) NOT NULL,
  `count` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `buyfk2_idx` (`bookId`),
  KEY `FKEA1066F4D552FFB` (`orderFormId`),
  CONSTRAINT `buyfk1` FOREIGN KEY (`orderFormId`) REFERENCES `orderform` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `buyfk2` FOREIGN KEY (`bookId`) REFERENCES `book` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `buybook`
--

LOCK TABLES `buybook` WRITE;
/*!40000 ALTER TABLE `buybook` DISABLE KEYS */;
/*!40000 ALTER TABLE `buybook` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category` (
  `category` varchar(45) NOT NULL,
  PRIMARY KEY (`category`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES ('人文社科'),('教育'),('文艺'),('生活'),('科技'),('童书'),('经管励志'),('音像');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customerinfo`
--

DROP TABLE IF EXISTS `customerinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customerinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `gender` varchar(45) NOT NULL,
  `address` varchar(45) NOT NULL,
  `birthday` date NOT NULL,
  `registerDay` date NOT NULL,
  `bank` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `bank_idx` (`bank`),
  CONSTRAINT `bank` FOREIGN KEY (`bank`) REFERENCES `bank` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customerinfo`
--

LOCK TABLES `customerinfo` WRITE;
/*!40000 ALTER TABLE `customerinfo` DISABLE KEYS */;
INSERT INTO `customerinfo` VALUES (2,'female','福建省连江县','1992-01-01','2014-05-30','1');
/*!40000 ALTER TABLE `customerinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `discountcoupons`
--

DROP TABLE IF EXISTS `discountcoupons`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `discountcoupons` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `standard` int(11) NOT NULL,
  `customerInfoId` int(11) DEFAULT NULL,
  `orderFormId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1_idx` (`standard`),
  KEY `FK2_idx` (`customerInfoId`),
  KEY `FK3_idx` (`orderFormId`),
  CONSTRAINT `FK1` FOREIGN KEY (`standard`) REFERENCES `discountcouponsstandard` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK2` FOREIGN KEY (`customerInfoId`) REFERENCES `customerinfo` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK3` FOREIGN KEY (`orderFormId`) REFERENCES `orderform` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `discountcoupons`
--

LOCK TABLES `discountcoupons` WRITE;
/*!40000 ALTER TABLE `discountcoupons` DISABLE KEYS */;
/*!40000 ALTER TABLE `discountcoupons` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `discountcouponsstandard`
--

DROP TABLE IF EXISTS `discountcouponsstandard`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `discountcouponsstandard` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `discount` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `discountcouponsstandard`
--

LOCK TABLES `discountcouponsstandard` WRITE;
/*!40000 ALTER TABLE `discountcouponsstandard` DISABLE KEYS */;
/*!40000 ALTER TABLE `discountcouponsstandard` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `equalcoupons`
--

DROP TABLE IF EXISTS `equalcoupons`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `equalcoupons` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `standard` int(11) NOT NULL,
  `customerInfoId` int(11) DEFAULT NULL,
  `orderFormId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `equalFK1_idx` (`standard`),
  KEY `equalFK2_idx` (`customerInfoId`),
  KEY `equalfk3_idx` (`orderFormId`),
  CONSTRAINT `equalFK1` FOREIGN KEY (`standard`) REFERENCES `equalcouponsstandard` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `equalFK2` FOREIGN KEY (`customerInfoId`) REFERENCES `customerinfo` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `equalfk3` FOREIGN KEY (`orderFormId`) REFERENCES `orderform` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equalcoupons`
--

LOCK TABLES `equalcoupons` WRITE;
/*!40000 ALTER TABLE `equalcoupons` DISABLE KEYS */;
/*!40000 ALTER TABLE `equalcoupons` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `equalcouponsstandard`
--

DROP TABLE IF EXISTS `equalcouponsstandard`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `equalcouponsstandard` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `equalValue` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equalcouponsstandard`
--

LOCK TABLES `equalcouponsstandard` WRITE;
/*!40000 ALTER TABLE `equalcouponsstandard` DISABLE KEYS */;
/*!40000 ALTER TABLE `equalcouponsstandard` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orderform`
--

DROP TABLE IF EXISTS `orderform`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orderform` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `state` int(11) NOT NULL,
  `confirmDate` date DEFAULT NULL,
  `distributeDate` date DEFAULT NULL,
  `sendDate` date DEFAULT NULL,
  `receiveDate` date DEFAULT NULL,
  `customerInfoId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `orderFK1_idx` (`customerInfoId`),
  KEY `orderfk2_idx` (`state`),
  CONSTRAINT `orderFK1` FOREIGN KEY (`customerInfoId`) REFERENCES `customerinfo` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `orderfk2` FOREIGN KEY (`state`) REFERENCES `state` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderform`
--

LOCK TABLES `orderform` WRITE;
/*!40000 ALTER TABLE `orderform` DISABLE KEYS */;
/*!40000 ALTER TABLE `orderform` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `id` int(11) NOT NULL,
  `type` varchar(45) DEFAULT NULL,
  `admin` tinyint(1) NOT NULL,
  `customer` tinyint(1) NOT NULL,
  `manager` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'customer',0,0,0),(2,'admin',0,0,0);
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `state`
--

DROP TABLE IF EXISTS `state`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `state` (
  `id` int(11) NOT NULL,
  `state` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `state`
--

LOCK TABLES `state` WRITE;
/*!40000 ALTER TABLE `state` DISABLE KEYS */;
INSERT INTO `state` VALUES (1,'confirm'),(2,'distribute'),(3,'send'),(4,'received');
/*!40000 ALTER TABLE `state` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `role` int(11) NOT NULL,
  `customerInfo` int(11) DEFAULT NULL,
  PRIMARY KEY (`username`),
  KEY `role_idx` (`role`),
  KEY `FK36EBCBF3ACC261` (`customerInfo`),
  CONSTRAINT `customerInfo` FOREIGN KEY (`customerInfo`) REFERENCES `customerinfo` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `role` FOREIGN KEY (`role`) REFERENCES `role` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('admin','admin',2,NULL),('陈霖','123',1,2);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-06-03 19:29:18
