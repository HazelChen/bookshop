CREATE DATABASE  IF NOT EXISTS `bookhouse` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `bookhouse`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: localhost    Database: bookhouse
-- ------------------------------------------------------
-- Server version	5.6.16-enterprise-commercial-advanced

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
INSERT INTO `bank` VALUES ('1',1000),('10',1000),('11',1000),('12',1000),('13',1000),('14',1000),('15',1000),('2',1000),('3',1000),('4',1000),('5',1000),('6',1000),('7',1000),('8',1000),('9',1000);
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
  `count` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `category_idx` (`category`),
  CONSTRAINT `category` FOREIGN KEY (`category`) REFERENCES `category` (`category`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES (4,'哈利波特与魔法石','9787020033430','J.K.罗琳','人民文学出版社','2009-09-01',14.1,'“哈利波特”系列图书自1997年在英国问世以来，迄今在全世界已发行三亿多册，2000年引进中国后，前六册发行量达800万册。因此无论在世界还是在中国，“哈利波特”都创造了出版史上的奇迹。“哈利波特”是一套既有畅销效应也有常销价值的儿童小说，从内容到艺术手法都具备了世界优秀儿童文学的潜质。其故事惊险离奇、神幻莫测；情节跌宕起伏、悬念丛生，从头至尾充满幽默。作者巧妙地将世界文学名著中所具有的美学品格集于一身，达到了想象丰富，情节紧凑，推理严密，人物刻画深刻的艺术效果。同时它也是一套引导孩子们勇敢向上，见义勇为，善良待人的婿作品。难能可贵的是，“哈利波特”不仅深受孩子们的追捧，同时又为成人所喜爱。','童书',9),(5,'哈利波特与密室','9787020033447','J.K.罗琳','人民文学出版社','2000-09-01',17.6,'哈利·波特在霍格沃茨魔法学校学习一年之后，暑假开始了。他在姨父姨妈家熬过痛苦的假期。正当他准备打点行装去学校时，小精灵多比前来发出警告：如果哈利返回霍格沃茨，灾难将会临头。\r\n“哈利·波特”系列图书自1997年在英国问世以来，迄今在全世界已发行三亿多册，2000年引进中国后，前六册发行量达800万册。因此无论在世界还是在中国，“哈利·波特”都创造了出版史上的奇迹。 “哈利·波特”是一套既有畅销效应也有常销价值的儿童小说，从内容到艺术手法都具备了世界优秀儿童文学的潜质。其故事惊险离奇、神幻莫测；情节跌宕起伏、悬念丛生，从头至尾充满幽默。作者巧妙地将世界文学名著中所具有的美学品格集于一身，达到了想象丰富，情节紧凑，推理严密，人物刻画深刻的艺术效果。同时它也是一套引导孩子们勇敢向上，见义勇为，善良待人的婿作品。难能可贵的是，“哈利·波特”不仅深受孩子们的追捧，同时又为成人所喜爱。','童书',9),(6,'历史不规矩','9787544270830','张鸣','南海出版社','2014-05-01',23.9,'清朝公主的幸福指数有多高？\r\n　　李二先生是何许人也？为什么说他是汉奸？他到底是不是汉奸？\r\n　　擦干净脸上的油彩，义和团的真实面目是什么？\r\n　　从一桩和捕快有关的冤案中能否窥探历史大变局？\r\n　　风流教坊里的皇帝贵胄如何开创一代盛世？\r\n　　……\r\n　　著名学者张鸣教授最新作品，大部分文章首次问世！\r\n　　不一样的历史视角，带给你另类的历史真实！\r\n　　历史，从来不按历史学家的规矩行事。在不规矩的历史里，隐藏着古今脉通、五光十色的世界……','人文社科',10),(7,'国学治要','9787564077730','张文治','北京理工大学出版社','2014-06-01',121,'净空法师倾力推荐，誉为能复兴中华的一本书。\r\n　　国学入门之捷径，繁而不芜，简而不陋；\r\n　　中华典籍之精华，统于四部，囊括百家。\r\n　　按经、史、子、集分类的小四库全书；四书五经、二十四史、先秦诸子、汉唐文赋、明清理学、唐诗宋词、音韵训诂，提要钩玄，兼容并包。\r\n　　中华国学之精华，东方文明之宝典；经世治国之镜鉴，修身养性之源泉。\r\n　　在港、澳、台及海外华人群体中广为流传，民国大中院校学生国学入门必读。\r\n　　国内唯一中文简体可阅读版。','人文社科',9),(8,'疾风回旋曲','9787514306538','东野圭吾','现代出版社','2014-05-01',21.8,'东野圭吾最新力作\r\n　　悬念迭起 颠覆想象 拿起就无法放下的阅读体验\r\n　　《白夜行》《嫌疑人X的献身》后再度挑战逻辑极限\r\n　　日本上市7日 销量突破100万册\r\n　　日本、韩国各大畅销榜TOP1\r\n　　东野圭吾中国首次签名珍藏','文艺',7),(9,'毁灭者的秘密','9787510828140','闫达','九州出版社','2014-05-01',23.6,'天涯论坛引起轰动的推理神贴，直击命案现场的诡异手记。　\r\n 不到最后一刻，真相绝不显现。情节反转挑战人性的高推理罪案悬疑故事。　\r\n 身临其境的类型氛围。最离奇的案情，最难以承受的真相。凶手时隐时现、沉默不语，与你同枕共眠。','文艺',9),(10,'奥数精讲与测试','9787542856166','熊斌','上海科技教育出版社','2013-02-01',20,'《奥数精讲与测试五年级》丛书从小学一年级至高中三年级共12册，将数学奥林匹克竞赛的内容以精讲和测试的形式系统地组织起来，目的是为学生提供一套强化知识、提高数学素养和能力的教材，让学生通过对这套教材的学习，具备和提高参加各种数学竞赛的知识和能力，使学生不仅能把自己课内的成绩提高，而且能在各级各类数学竞赛中取得理想的成绩。\r\n　 《奥数精讲与测试 五年级》的每一讲都有“精讲”和“测试ABC卷’’组成，分设三部分内容：\r\n　1．竞赛热点、考点、知识点。将数学奥林匹克竞赛的知识、内容以及当前的热点问题和历届数学奥林匹克竞赛中经常出现的问题给予分析、归纳、阐述和总结。\r\n　2．典型例题精讲。围绕数学竞赛的热点、考点，选择典型的例题，提高对典型例题的分析、讲解，使学生能够掌握基本思想和基本方法，进而提高分析问题和解决问题的能力。\r\n　3．测试ABC卷。有针对性地选择一些名题、新题、好题给学生练习。A卷是“精讲”内容的延伸与拓展，题目难度较小；B卷进一步加强数学竞赛的基本功，突出了解题的基本技巧与方法；C卷是为准备在数学奥林匹克竞赛中取得优异成绩的同学设计的，题目具有一定的挑战性，是学生发挥自己的创造性、一显身手的试金石。','教育',8),(11,'去野吧，西藏','9787111423584','洪舒靖','机械工业出版社','2013-06-01',44.4,' 提起西藏，毫无疑问是很多人向往的旅行圣地。雄浑壮阔的世界屋脊，淳朴自然的原生态文化，能洗净灵魂的秀美风光，大昭寺、布达拉宫、罗布林卡，无不让人心驰神往。而西藏特殊的地理位置，使大多数人虽然心向往之，但又受制于种种客观因素无法成行，即使有少数人能够成行，也因为大多采用飞机、火车、汽车等旅行方式而对西藏的众多美景也仅仅是走马观花般的匆匆而过。\r\n   本书作者历时40天，用单车的车轮和自己的双脚，丈量了从成都到拉萨，2000多公里风景秀丽的川藏线，用相机和文字记录下了川藏线上的众多美景和风土人情，用朴实的笔触给众多向往西藏却无法亲身涉足的读者真实、生动、绝美的川藏线体验。\r\n   本书也不仅仅是一本游记或者路书，它还承载了作者对人生态度、生命本质的一种探寻，能够支撑着作者完成40天艰苦的单车旅行的是人性中那些最宝贵的精神：坚定的信念、理智的判断、永不认输的态度、以及来自家人、好友和团队伙伴的帮助和支持。骑行西藏需要的这些精神，不也正是我们人生历程中始终需要的那些东西吗？作者在川藏线的骑行旅程中收获了自己的精神升华，我们希望读者能从这本书中也有自己的收获。','生活',8),(12,'信息简史','9787115331809','詹姆斯•格雷克 ','人民邮电出版社','2013-11-01',48.7,'百万级销量科普畅销书作家詹姆斯格雷克七年磨一剑\r\n　　带来一段人类与信息遭遇的波澜壮阔的历史\r\n　　告诉我们如何在信息时代的信息爆炸中生存\r\n　　2011年度《纽约时报》畅销书\r\n　　2011年度《出版商周刊》年度最佳图书\r\n　　2012年度英国皇家学会科普图书奖\r\n　　美国笔会爱德华威尔逊科普文学奖\r\n　　英国笔会赫塞尔-蒂尔特曼奖得主','科技',9),(13,'京城往事2','9787510828201','王山','九州出版社','2014-05-01',17.6,'京城往事2（原名《北京教父3》！从“文革”年代的胡同里杀出来的京城大亨成长史。翻开本书，了解北京城里的传闻与秘密。）\r       1967年，父亲因内部斗争自杀，母亲被监管，为了养活三个妹妹，陈成踏入江湖，与各派流氓厮杀混战，制造血案无数，迅速成长为京城流氓头子，在各种传闻中被夸张渲染为凶神恶煞的杀人恶魔，市民闻之色变；而那时，他不过是一个年仅17岁的少年。\r 　　此后数十年间，文革、武斗、下放当知青、返城上大学、当组织部副部长、辞职、经商、行贿、盗窃、诈骗、倒卖煤炭、闯海南、搞房地产、搞信托投资，跌荡起伏，几度生死，陈成一直在时代的刀尖上舔血生存。\r 　　当他离市民的传说越来越远，身影逐渐模糊，几乎就要被遗忘的时候，人们已经注意不到，在报纸、杂志、电视、网络的各种财经新闻中，一直隐藏着一个他们曾经熟悉的面孔。\r 　　翻开本书，了解北京城里的传闻与秘密。','文艺',29),(14,'曾文正公家书','9787514901245','曾国藩','中国书店出版社','2011-09-01',29,'《曾文正公家书》被研究专家称为“毛泽东最喜读的书”，他一生研读的就是这套清朝光绪已卯年传忠书局刊印的《曾文正公家书》，现在韶山毛泽东同志纪念馆还收藏着毛泽东当年读过的《曾文正公家书》。在延安时毛泽东建议党员干部们都要读读这本书。 \r\n* 教子圣经：蒋介石教育子女的不二宝典，钱穆一直向学生们推荐的读书入门书 \r\n蒋介石对其子蒋经国说过，曾国藩对子女的训诫可作模范，要认真体会，并且依照曾氏家训去践行。蒋经国常写信向父亲请安，蒋介石有时无空作复，就指定以《曾文正公家训》的第几篇代替回信。蒋经国偶尔身体有病，蒋介石就说是他没有好好地读《曾文正公家书》，因为那书里对于如何保持健康，是说得很详尽的。\r\n钱穆对《曾文正公家训》推崇备至，认为那是影响了他一生读书的重要经典。在《人生十论》的序言里，钱穆写到：凡属那些有关人生教训的话，我总感到亲切有味，时时盘旋在心中……待到中学大学去教书，许多学生问我读书法，我总劝他们且看像《曾文正公家训》和《论语》那一类书。 \r\n* 权威编校：真正全本传忠书局版《家书》，不仅仅是曾国藩家书结集，也可作为曾国藩人生自述来读 \r\n传忠书局版《曾文正公家书》经过李瀚章、李鸿章兄弟精心编校，它不仅仅是“千古第一完人”曾国藩家书的集结，同时还通过对家书篇目的整理，用曾国藩书信的形式将曾国藩一生的人生轨迹、教子思想的脉络完整地呈现给读者。《家书》采用以时间为序的编排方式，即和曾国藩的人生轨迹同步；而其全面展现曾国藩一生的编辑意图则从其中收录的少部分给非曾国藩家族成员的书信得以侧面印证，如曾国藩给湖南巡抚骆秉章的书信节选，给欧阳牧云等的信，均写于曾国藩人生重大事件的时期，而同时期曾国藩缺少和和家族成员的通信，这些和同僚、亲友的通信很好地对家书进行了补足。因此，从这一点上看，传忠书局版《曾文正公家书》除了是曾国藩家书的集结外，同时也可作为曾国藩一生自述来读，比后人写的传记要直接和深入得多。\r\n为了与传忠书局版《曾文正公家书》的权威编校相匹配，此次简体版在校对、标点等方面都达到了相当高的水准：首先简体版完全忠实于传忠书局版，完整地保留了传忠书局版以时间为序的编排方式，同时也保留了传忠书局版的分卷，可谓是“原汁原味的传忠书局版”。同时此次简体横排版还附了曾国藩家族成员的简介以及古人纪年方式和当下标准纪年方式的对比，非常有利于读者理解和阅读。本书在目前曾国藩家书的版本中堪称出类拔萃，是目前能够购买到最好的简体曾国藩家书。 ','人文社科',50),(15,'民国奇情大案','9787010133058','宋连生','人民出版社','2014-04-01',32.3,'阮玲玉自杀真相\r\n玉碎\r\n1935年，著名影星阮玲玉自杀身亡。她的死让无数影迷伤心欲绝，又让许多人困惑不已。她有着天生丽质和表演天分，她创造了中国早期电影的一个又一个经典。那么，是什么让她选择结束生命，把一段影界传奇变成了令人忧伤的往事？\r\n错爱\r\n阮玲玉如愿当上了电影演员，是否挽救了她的家庭危机？面对在赌博泥潭中越陷越深的张达民，阮玲玉为什么不能分手？面对唐季珊的热烈追求，阮玲玉该怎样抉择呢？\r\n躲不开的无赖\r\n在唐季珊甜蜜的爱情攻势下，阮玲玉和他同居生活在了一起，那么，当张达民得知这一消息后，他又使用了哪些无赖手段勒索昔日的女友呢？张达民的无赖行径，又是否是阮玲玉自杀的推手呢？\r\n人言可畏\r\n阮玲玉爱惜自己的名声，尤其不想让自己的私生活暴露于公众的注视之下，然而事与愿违，前男友张达民和现任男友唐季珊让她卷入了一场场官司之中，成为街头巷尾议论的话题。那么阮玲玉能否应对社会舆论带来的压力？这场名人官司与她的死又有着怎样的关系呢？\r\n真假遗书\r\n阮玲玉自杀后，唐季珊向社会公开了阮玲玉的遗书，“人言可畏”也成了当时最令人们心痛的四个字。然而，另一份报纸上又出现了两封阮玲玉的遗书，其中一封还痛斥了唐季','人文社科',20),(16,'赢在制空权','9787516504604','刘亚洲','中航出版传媒有限责任公司','2014-04-01',26.6,'《赢在制空权：刘亚洲解读世界空战百年史》是一部具有浪漫主义的军事读物。刘亚洲上将以宏观的视野梳理了飞机自诞生到成为战争利器的发展脉络，从战争的高度概述了飞机在百年战争中所发挥的作用。他以激情澎湃的写作风格对世界空军及大小空战进行了点评，语言铿锵有力、通俗易懂。这本凝聚了作者多年心血的作品集理论、实战于大成，融故事专业于一体；在解读世界空战百年史的过程中，更是对未来战争做出了暗示，对各国特别是中国在发展国防力量、武器研制上提供了可供参考的理论依据，对军事官员在未来战争部署上也有着相当的指导意义。无论是对普通读者还是军事官员，此书都有着较高的赏读价值。','人文社科',30),(17,'宏观经济学 第十版','9787300115283','多恩布什','中国人民大学出版社','2010-01-01',44.5,'本书自1977年第一版问世以来，就成为世界范围内的主流教材。不仅美国多所著名大学在使用，还被翻译成多种语言。在欧洲、中国、日本、拉美、南亚、东南亚和非洲，许多大学经济类院系的学生都在使用这本教材。该教材内容全面，结构合理，理论联系实际，难度适中，融合了经济领域的学术共识，并客观地表述和评价了各家各派的观点，是一本易于理解并且非常灵活的经济学教材。','教育',29),(18,'建设工程计价2013版','9787802428492','柯洪','中国计划出版社','2013-05-01',43,'柯洪主编的《建设工程计价（2013年版）》内容包括：建设工程造价构成；建设工程计价方法及计价依据；建设项目决策和设计阶段工程造价的预测；建设项目发承包阶段合同价款的约定；建设项目施工阶段合同价款的调整和结算；建设项目竣工决算的编制和竣工后质量保证金的处理等。','教育',20),(19,'高等数学习题全解指南 同济第6版（上册）','9787040207453','同济大学数学系','高等教育出版社','2007-04-01',20.1,'本书是与同济大学数学系编写的《高等数学》第六版相配套的学习辅导书，由同济大学数学系的教师编写。本书内容由三部分组成，第一部分是按《高等数学》（上册）的章节顺序编排，给出习题全解，部分题目在解答之后对该类题的解法作了小结、归纳，有的提供了多种解法；第二部分是全国硕士研究生入学统一考试数学试题选解，所选择的试题以工学类为主，少量涉及经济学类试题；第三部分是同济大学高等数学考卷选编以及考题的参考解答。\r\n本书对教材具有相对的独立性，可为学习高等数学的工科和其他非数学类专业学生以及复习高等数学准备报考硕士研究生的人员提供解题指导，也可供讲授高等数学的教师在备课和批改作业时参考。','教育',20),(20,'如何看一幅画','9787508643038','弗朗索瓦芭布－高尔','中信出版社','2014-04-01',36,'看画，是进入艺术世界的最佳途径之一！\r 　　法国资深艺术史家亲自教你怎么看画，打开你的艺术之眼！\r 　　6种最常见的看画情境，细致解读36件艺术作品，教你如何看一幅画！\r \r 　　全书由36幅艺术作品分析构成，图片精美，细节清晰，对想要初步了解如何看一幅艺术作品的读者是非常适合的读物。\r \r 　　作者有长期面向大众讲解艺术品的丰富经验，对于如何引导读者进入一件艺术作品的世界相当有帮助。当我们在一幅画前毫无感觉的时候，那么我们到底缺乏破解艺术的钥匙是什么呢？我们能感觉到一些情绪的变化，但是我们似乎仍然无法理解艺术作品。弗朗索瓦芭布-高尔介绍了艺术作品丰富的背景知识和它们的创作环境，让观者能够细致入微的理解艺术作品。','文艺',29),(21,'用故事喂大孩子系列','23465192','故事达妈团队','中国妇女出版社','2014-06-01',83,'★孩子只听得懂故事的语言！\r 　　★妈妈不知道怎么办，故事全知道！\r 　　★每天给孩子讲故事的妈妈，就是最好的妈妈！\r 　　★爱孩子，就请像喂牛奶一样每天喂故事给孩子吧！\r 　　★讲故事是最好的教养方式！\r 　　★192个故事良方，养出聪明、幸福感强、善良、自信、勇敢的好孩子！','生活',20),(22,'美食新鲜人','9787500129172','婉容','中国对外翻译出版公司','2014-05-01',16,'在06年之前的那段时间里，我对于做菜一无所知。那个时候的我从来没有想过自己有朝一日可以对着各大餐厅老板指点江山，每日与食物打交道，并且将此做为自己的终身职业。\r\n去世界各地的酒庄品尝美酒，和世界上最有名的厨师聊天，享受专门为你准备的食物，你甚至可以去到食材的原产地追根溯源。在研究食物的过程中，我们又重温了历史，在旅行的过程中又重新学习了地理，为了了解食物我们开始看所有与之相关的电影，书籍和绘画。食物中没有虚荣的成分，每一口食物都相当实在。因此，对于我来说与其做个穿prada的女魔头，倒不如做个食米其林三星的女魔头！','生活',10),(23,'时间简史（插图本）','9787535732309','史蒂芬·霍金','湖南科技出版社','2010-04-01',31.1,'史蒂芬·霍金的《时间简史》自1988年首版以来的岁月里，已成为全球科学著作的里程碑。它被翻译成40种文字，销售了近1000万册，成为国际出版史上的奇观。\r    　为了把许多观测揭示的新知识，以及他最新的研究纳入该书。霍金教授为这一增订版准备了新的前言，全面更新了原书的内容，而且还新增加了一章，有关虫洞和时间旅行的激动人心的课题。\r 　　尽管霍金教授的著述极为清晰而机智，有些读者仍然觉得难以掌握复杂的概念。为了使读者加深理解，本版还增加了240多幅彩色插图，包括卫星图像和照片。这些都应归功于诸如哈勃空间望远镜和电脑三维和四维实体成像等技术进步之赐。详细的插图说明使读者能体验到星系际太空的广漠、黑洞的奇妙性质以及物质和反物质碰撞的粒子物理的微观世界。\r 　　作为一本飨以读者宇宙学的最新理解的经典著作，《时间简史》插图本是探索时间和空间核心秘密的引人入胜的故事。','科技',49),(24,'谁说菜鸟不会数据分析（入门篇）','9787121187803','张文霖，刘夏璐，狄松','电子工业出版社','2012-11-08',33.3,'这是一本有趣的数据分析书！\r     本书基于通用的Excel工具，加上必知必会的数据分析概念，以小说般通俗易懂的方式讲解。本书基于职场三人行来构建内容，完全按照数据分析工作的完整流程来讲解。全书共8章，依次讲解数据分析必知必会知识、确定数据分析的结构化思维、数据处理技巧、数据展现的技术、通过专业化的视角来提升图表之美以及专业分析报告的撰写等内容。本书有足够的魅力让你一口气读下去，在无形之中掌握数据分析的技能，提升职场竞争能力。','科技',19),(25,'14只老鼠全集','21112439','岩村和朗','接力出版社','2010-09-01',97.7,'● 日本图画书大师岩村和朗的经典代表作\r 　　● 融合自然之美与家族亲情之爱的世界经典图画书\r 　　● 荣获2010年度父母必读&红泥巴童书排行榜第一名\r 　　● 荣获2010年度中国童书金奖----最美图画书奖\r 　　● 畅销20余年，全球销量超过1000万册\r 　　● 美的陶冶，观察力的训练，自然常识的认知\r 　　● 亲近自然、学会合作、珍惜拥有','童书',29),(26,'守护者系列','21058759','上桥菜穗子','中国少年儿童出版社','2011-04-01',56.5,'日本三大奇幻女作家之首上桥菜穗子的成名作。\r     日本近二十年来最值得一看的奇幻小说。\r     与《暮光之城》《哈利·波特》齐名的金字塔塔尖之作。\r     席卷日本各项文学大奖。\r  \r     这是一套风靡日本的幻想类儿童文学，其中《精灵守护者》已被改编成电视动画，在多国播出，获选为2007年第十一回日本文部省文化厅媒体艺术祭动画部门推荐的作品。\r     作品在通过一个幻想的世界，向读者展示了人类非凡的勇气和博大的爱。作品的张力让人读来痛快淋漓，而其中蕴含的深意更启人掩卷沉思。相信对今天的中国青少年乃至成人，能从书中找到非同寻常的生命的力量。','童书',19),(27,'再一次，遇见年轻的自己','9787510448409','克里斯汀 哈斯勒','新世界出版社','2014-05-01',16,'《再一次，遇见年轻的自己》，首次在全球提出了“双十三角问题”，大胆鼓励女性“听从内心，哪怕它，很狰狞……”并引爆全球1000000女性觉醒的“双十三角效应”，帮助新时代的年轻女性重新确立起一套适用于当下社会、专属于每一位女性的“觉醒自助指南”，让每一位女性都能在双十年华，活出最好的自己。\r 　　双十年华是生命中的一个转折点，在这个时期，学校和父母曾给我们架设的保护伞，已被拆除。摆在我们面前的是爱情、工作、生活等等。如果你看得足够远，你之后的人生，很大程度上和二十几岁的想法息息相关。','经管励志',30),(28,'疗愈时光，你终将盛放','9787505730588','清流','中国友谊出版公司','2014-06-01',19.2,'1.全时光疗愈手册，这不是一本“鸡汤”，而是教你用冥想、美食、触摸等简单的方法让生命中所有的时光美好起来。\r\n2.成长，不是等待疼痛过去，而是学会疗愈。遗忘、逃避、喊口号并不能真正解决你的问题，你的生命价值，在于你所有的经历和记忆。\r\n3. 抚平过去、现在和将来的伤痛。不是所有的经历都是经验财富，只有能够看懂、敢面对的才是人生！\r\n4.不能改变生命的长度，学会治愈所有的痛苦和挫折，就能增加生命的宽度，让你的所有时光明媚起来，就能增加生命的亮度。','经管励志',20);
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
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bookcollected`
--

LOCK TABLES `bookcollected` WRITE;
/*!40000 ALTER TABLE `bookcollected` DISABLE KEYS */;
INSERT INTO `bookcollected` VALUES (1,2,4,'2014-06-02'),(3,2,5,'2014-06-08'),(4,2,20,'2014-06-08'),(5,4,8,'2014-06-08'),(6,5,20,'2014-06-08'),(7,5,28,'2014-06-08'),(8,3,8,'2014-06-08'),(9,12,4,'2014-06-08'),(10,12,5,'2014-06-08'),(11,10,27,'2014-06-08');
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
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bookincart`
--

LOCK TABLES `bookincart` WRITE;
/*!40000 ALTER TABLE `bookincart` DISABLE KEYS */;
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
  `singlePrice` double NOT NULL,
  PRIMARY KEY (`id`),
  KEY `buyfk2_idx` (`bookId`),
  KEY `FKEA1066F4D552FFB` (`orderFormId`),
  CONSTRAINT `buyfk1` FOREIGN KEY (`orderFormId`) REFERENCES `orderform` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `buyfk2` FOREIGN KEY (`bookId`) REFERENCES `book` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `buybook`
--

LOCK TABLES `buybook` WRITE;
/*!40000 ALTER TABLE `buybook` DISABLE KEYS */;
INSERT INTO `buybook` VALUES (1,2,4,3,14.1),(2,2,5,1,17.6),(3,3,11,2,44.4),(4,3,12,1,48.7),(5,4,10,2,20),(6,5,9,1,23.6),(7,5,23,1,31.1),(8,6,8,1,21.8),(9,7,13,1,17.6),(10,7,17,1,44.5),(11,8,20,1,36),(12,9,24,1,33.3),(13,10,4,1,14.1),(14,10,5,1,17.6),(15,10,26,1,56.5),(16,11,7,1,121),(17,12,25,1,97.7),(18,13,8,1,21.8),(19,14,8,1,21.8);
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
INSERT INTO `category` VALUES ('人文社科'),('教育'),('文艺'),('生活'),('科技'),('童书'),('经管励志');
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
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customerinfo`
--

LOCK TABLES `customerinfo` WRITE;
/*!40000 ALTER TABLE `customerinfo` DISABLE KEYS */;
INSERT INTO `customerinfo` VALUES (2,'female','福建省连江县','2002-01-01','2014-05-30','1'),(3,'male','江苏省南通市','1993-01-25','2014-06-06','2'),(4,'female','江苏省扬州市','1983-06-08','2014-05-07','3'),(5,'female','浙江省温州市','1993-09-02','2014-05-07','4'),(6,'female','江苏省南通市','2002-11-08','2014-05-07','5'),(7,'female','江苏省苏州市','1993-06-22','2014-05-07','6'),(8,'female','江苏省盐城市','1993-12-23','2014-03-07','7'),(9,'female','浙江省宁波市','1982-09-29','2014-05-07','8'),(10,'male','江苏省镇江市','1992-01-01','2014-05-07','9'),(11,'male','辽宁省抚顺市','1972-12-08','2014-04-07','10'),(12,'male','江苏省苏州市','1992-11-26','2014-04-07','11'),(13,'male','江苏省苏州市','1981-12-08','2014-04-07','12'),(14,'male','江苏省常州市','1992-06-02','2014-06-07','13'),(15,'male','广东省深圳市','1983-06-13','2014-05-07','14'),(16,'female','福建省连江县','1973-03-12','2014-03-07','15');
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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `discountcoupons`
--

LOCK TABLES `discountcoupons` WRITE;
/*!40000 ALTER TABLE `discountcoupons` DISABLE KEYS */;
INSERT INTO `discountcoupons` VALUES (1,2,NULL,5),(2,1,11,NULL),(3,1,NULL,11),(4,2,4,NULL),(5,2,15,NULL),(6,2,16,NULL);
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `discountcouponsstandard`
--

LOCK TABLES `discountcouponsstandard` WRITE;
/*!40000 ALTER TABLE `discountcouponsstandard` DISABLE KEYS */;
INSERT INTO `discountcouponsstandard` VALUES (1,0.8),(2,0.9);
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
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equalcoupons`
--

LOCK TABLES `equalcoupons` WRITE;
/*!40000 ALTER TABLE `equalcoupons` DISABLE KEYS */;
INSERT INTO `equalcoupons` VALUES (1,1,2,NULL),(2,1,NULL,12),(3,1,3,NULL),(4,1,NULL,14),(5,1,NULL,6),(6,2,NULL,10),(7,1,NULL,8),(8,1,9,NULL),(9,1,NULL,13);
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equalcouponsstandard`
--

LOCK TABLES `equalcouponsstandard` WRITE;
/*!40000 ALTER TABLE `equalcouponsstandard` DISABLE KEYS */;
INSERT INTO `equalcouponsstandard` VALUES (1,10),(2,20);
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
  `price` double NOT NULL,
  PRIMARY KEY (`id`),
  KEY `orderFK1_idx` (`customerInfoId`),
  KEY `orderfk2_idx` (`state`),
  CONSTRAINT `orderFK1` FOREIGN KEY (`customerInfoId`) REFERENCES `customerinfo` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `orderfk2` FOREIGN KEY (`state`) REFERENCES `state` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderform`
--

LOCK TABLES `orderform` WRITE;
/*!40000 ALTER TABLE `orderform` DISABLE KEYS */;
INSERT INTO `orderform` VALUES (2,2,'2014-05-20','2014-06-06',NULL,NULL,2,49.9),(3,3,'2014-05-21','2014-06-06','2014-06-06',NULL,3,137.5),(4,2,'2014-05-23','2014-06-06',NULL,NULL,3,40),(5,1,'2014-06-08',NULL,NULL,NULL,2,49.23),(6,1,'2014-06-08',NULL,NULL,NULL,4,11.8),(7,1,'2014-05-27',NULL,NULL,NULL,4,62.1),(8,1,'2014-06-08',NULL,NULL,NULL,5,26),(9,1,'2014-06-08',NULL,NULL,NULL,5,33.3),(10,1,'2014-06-08',NULL,NULL,NULL,12,68.2),(11,1,'2014-06-08',NULL,NULL,NULL,10,96.8),(12,1,'2014-06-08',NULL,NULL,NULL,11,87.7),(13,1,'2014-06-09',NULL,NULL,NULL,6,11.8),(14,1,'2014-06-09',NULL,NULL,NULL,3,11.8);
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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'customer'),(2,'admin'),(3,'manager');
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
INSERT INTO `user` VALUES ('admin','admin',2,NULL),('baozhongjian','123',1,11),('bianpeng','123',1,3),('caihaolun','123',1,10),('caihui','123',1,4),('caohui','123',1,12),('chenhao','123',1,14),('chenlin','123',1,2),('chenqingqing','123',1,5),('chenruoqin','123',1,15),('chensiyi','123',1,13),('chentuoyi','123',1,9),('chuling','123',1,6),('dingyuwei','123',1,7),('dongyixuan','123',1,8),('manager','manager',3,NULL),('zhengyurong','123',1,16);
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

-- Dump completed on 2014-06-09 22:03:15
CREATE DATABASE  IF NOT EXISTS `bookhousestatistics` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `bookhousestatistics`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: localhost    Database: bookhousestatistics
-- ------------------------------------------------------
-- Server version	5.6.16-enterprise-commercial-advanced

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
-- Table structure for table `avginventory`
--

DROP TABLE IF EXISTS `avginventory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `avginventory` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `inventory` double NOT NULL,
  `itemCount` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `avginventory`
--

LOCK TABLES `avginventory` WRITE;
/*!40000 ALTER TABLE `avginventory` DISABLE KEYS */;
INSERT INTO `avginventory` VALUES (4,20,25);
/*!40000 ALTER TABLE `avginventory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bookanalyse`
--

DROP TABLE IF EXISTS `bookanalyse`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bookanalyse` (
  `isbn` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  `price` double NOT NULL,
  `sales` int(11) NOT NULL,
  `collections` int(11) NOT NULL,
  `category` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`isbn`),
  KEY `bookFK_idx` (`category`),
  CONSTRAINT `bookFK` FOREIGN KEY (`category`) REFERENCES `categoryanalyse` (`category`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bookanalyse`
--

LOCK TABLES `bookanalyse` WRITE;
/*!40000 ALTER TABLE `bookanalyse` DISABLE KEYS */;
INSERT INTO `bookanalyse` VALUES ('21058759','守护者系列',56.5,1,0,'童书'),('21112439','14只老鼠全集',97.7,1,0,'童书'),('23465192','用故事喂大孩子系列',83,0,0,'生活'),('9787010133058','民国奇情大案',32.3,0,0,'人文社科'),('9787020033430','哈利波特与魔法石',14.1,4,2,'童书'),('9787020033447','哈利波特与密室',17.6,2,2,'童书'),('9787040207453','高等数学习题全解指南 同济第6版（上册）',20.1,0,0,'教育'),('9787111423584','去野吧，西藏',44.4,2,0,'生活'),('9787115331809','信息简史',48.7,1,0,'科技'),('9787121187803','谁说菜鸟不会数据分析（入门篇）',33.3,1,0,'科技'),('9787300115283','宏观经济学 第十版',44.5,1,0,'教育'),('9787500129172','美食新鲜人',16,0,0,'生活'),('9787505730588','疗愈时光，你终将盛放',19.2,0,1,'经管励志'),('9787508643038','如何看一幅画',36,1,2,'文艺'),('9787510448409','再一次，遇见年轻的自己',16,0,1,'经管励志'),('9787510828140','毁灭者的秘密',23.6,1,0,'文艺'),('9787510828201','京城往事2',17.6,1,0,'文艺'),('9787514306538','疾风回旋曲',21.8,3,2,'文艺'),('9787514901245','曾文正公家书',29,0,0,'人文社科'),('9787516504604','赢在制空权',26.6,0,0,'人文社科'),('9787535732309','时间简史（插图本）',31.1,1,0,'科技'),('9787542856166','奥数精讲与测试',20,2,0,'教育'),('9787544270830','历史不规矩',23.9,0,0,'人文社科'),('9787564077730','国学治要',121,1,0,'人文社科'),('9787802428492','建设工程计价2013版',43,0,0,'教育');
/*!40000 ALTER TABLE `bookanalyse` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bookinventory`
--

DROP TABLE IF EXISTS `bookinventory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bookinventory` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `isbn` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  `price` double NOT NULL,
  `fundsUsedAvg` double NOT NULL,
  `item` int(11) NOT NULL,
  `itemPercentage` double NOT NULL,
  `fundsUsedAvgCount` double NOT NULL,
  `fundsUsedAvgCountPer` double NOT NULL,
  `category` varchar(45) NOT NULL,
  `avgInventoryId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `inventoryFK_idx` (`avgInventoryId`),
  CONSTRAINT `inventoryFK` FOREIGN KEY (`avgInventoryId`) REFERENCES `avginventory` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bookinventory`
--

LOCK TABLES `bookinventory` WRITE;
/*!40000 ALTER TABLE `bookinventory` DISABLE KEYS */;
INSERT INTO `bookinventory` VALUES (76,'9787020033430','哈利波特与魔法石',14.1,282,1,4,282,1,'A',4),(77,'9787510448409','再一次，遇见年轻的自己',16,320,2,8,602,3,'A',4),(78,'9787500129172','美食新鲜人',16,320,3,12,922,4,'A',4),(79,'9787510828201','京城往事2',17.6,352,4,16,1274,6,'B',4),(80,'9787020033447','哈利波特与密室',17.6,352,5,20,1626,8,'B',4),(81,'9787505730588','疗愈时光，你终将盛放',19.2,384,6,24,2010,10,'B',4),(82,'9787542856166','奥数精讲与测试',20,400,7,28,2410,12,'B',4),(83,'9787040207453','高等数学习题全解指南 同济第6版（上册）',20.1,402,8,32,2812,15,'C',4),(84,'9787514306538','疾风回旋曲',21.8,436,9,36,3248,17,'C',4),(85,'9787510828140','毁灭者的秘密',23.6,472,10,40,3720,19,'C',4),(86,'9787544270830','历史不规矩',23.9,478,11,44,4198,22,'C',4),(87,'9787516504604','赢在制空权',26.6,532,12,48,4730,25,'C',4),(88,'9787514901245','曾文正公家书',29,580,13,52,5310,28,'C',4),(89,'9787535732309','时间简史（插图本）',31.1,622,14,56,5932,31,'C',4),(90,'9787010133058','民国奇情大案',32.3,646,15,60,6578,35,'C',4),(91,'9787121187803','谁说菜鸟不会数据分析（入门篇）',33.3,666,16,64,7244,38,'C',4),(92,'9787508643038','如何看一幅画',36,720,17,68,7964,42,'C',4),(93,'9787802428492','建设工程计价2013版',43,860,18,72,8824,47,'C',4),(94,'9787111423584','去野吧，西藏',44.4,888,19,76,9712,51,'C',4),(95,'9787300115283','宏观经济学 第十版',44.5,890,20,80,10602,56,'C',4),(96,'9787115331809','信息简史',48.7,974,21,84,11576,61,'C',4),(97,'21058759','守护者系列',56.5,1130,22,88,12706,67,'C',4),(98,'23465192','用故事喂大孩子系列',83,1660,23,92,14366,76,'C',4),(99,'21112439','14只老鼠全集',97.7,1954,24,96,16320,87,'C',4),(100,'9787564077730','国学治要',121,2420,25,100,18740,100,'C',4);
/*!40000 ALTER TABLE `bookinventory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categoryanalyse`
--

DROP TABLE IF EXISTS `categoryanalyse`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categoryanalyse` (
  `category` varchar(45) NOT NULL,
  `count` int(11) NOT NULL,
  PRIMARY KEY (`category`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoryanalyse`
--

LOCK TABLES `categoryanalyse` WRITE;
/*!40000 ALTER TABLE `categoryanalyse` DISABLE KEYS */;
INSERT INTO `categoryanalyse` VALUES ('人文社科',1),('教育',3),('文艺',6),('生活',2),('科技',3),('童书',8),('经管励志',0);
/*!40000 ALTER TABLE `categoryanalyse` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `discountcouponsanalyse`
--

DROP TABLE IF EXISTS `discountcouponsanalyse`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `discountcouponsanalyse` (
  `value` varchar(45) NOT NULL,
  `totalCount` int(11) NOT NULL,
  `usedCount` int(11) NOT NULL,
  `usedPercent` double NOT NULL,
  PRIMARY KEY (`value`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `discountcouponsanalyse`
--

LOCK TABLES `discountcouponsanalyse` WRITE;
/*!40000 ALTER TABLE `discountcouponsanalyse` DISABLE KEYS */;
INSERT INTO `discountcouponsanalyse` VALUES ('0.8',2,1,0.5),('0.9',4,1,0.25),('total',6,2,0.33);
/*!40000 ALTER TABLE `discountcouponsanalyse` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `equalcouponseanalyse`
--

DROP TABLE IF EXISTS `equalcouponseanalyse`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `equalcouponseanalyse` (
  `value` varchar(45) NOT NULL,
  `totalCount` int(11) NOT NULL,
  `usedCount` int(11) NOT NULL,
  `usedPercent` double NOT NULL,
  PRIMARY KEY (`value`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equalcouponseanalyse`
--

LOCK TABLES `equalcouponseanalyse` WRITE;
/*!40000 ALTER TABLE `equalcouponseanalyse` DISABLE KEYS */;
INSERT INTO `equalcouponseanalyse` VALUES ('10.0',8,5,0.62),('20.0',1,1,1),('total',9,6,0.66);
/*!40000 ALTER TABLE `equalcouponseanalyse` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `useraddress`
--

DROP TABLE IF EXISTS `useraddress`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `useraddress` (
  `address` varchar(45) NOT NULL,
  `count` int(11) NOT NULL,
  `percentage` double NOT NULL,
  PRIMARY KEY (`address`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `useraddress`
--

LOCK TABLES `useraddress` WRITE;
/*!40000 ALTER TABLE `useraddress` DISABLE KEYS */;
INSERT INTO `useraddress` VALUES ('广东',1,0.06),('江苏',9,0.6),('浙江',2,0.13),('福建',2,0.13),('辽宁',1,0.06);
/*!40000 ALTER TABLE `useraddress` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userage`
--

DROP TABLE IF EXISTS `userage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `userage` (
  `ageRange` varchar(45) NOT NULL,
  `count` int(11) NOT NULL,
  `percentage` double NOT NULL,
  PRIMARY KEY (`ageRange`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userage`
--

LOCK TABLES `userage` WRITE;
/*!40000 ALTER TABLE `userage` DISABLE KEYS */;
INSERT INTO `userage` VALUES ('0-20',2,0.13),('20-40',11,0.73),('40-60',2,0.13),('60-80',0,0),('80-100',0,0);
/*!40000 ALTER TABLE `userage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usergender`
--

DROP TABLE IF EXISTS `usergender`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usergender` (
  `gender` varchar(45) NOT NULL,
  `count` int(11) NOT NULL,
  `percentage` double NOT NULL,
  PRIMARY KEY (`gender`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usergender`
--

LOCK TABLES `usergender` WRITE;
/*!40000 ALTER TABLE `usergender` DISABLE KEYS */;
INSERT INTO `usergender` VALUES ('Female',8,0.53),('Male',7,0.46);
/*!40000 ALTER TABLE `usergender` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usermonthadd`
--

DROP TABLE IF EXISTS `usermonthadd`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usermonthadd` (
  `month` varchar(45) NOT NULL,
  `count` int(11) NOT NULL,
  PRIMARY KEY (`month`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usermonthadd`
--

LOCK TABLES `usermonthadd` WRITE;
/*!40000 ALTER TABLE `usermonthadd` DISABLE KEYS */;
INSERT INTO `usermonthadd` VALUES ('Past 0 Months',3),('Past 1 Months',7),('Past 2 Months',3);
/*!40000 ALTER TABLE `usermonthadd` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-06-09 22:03:15
