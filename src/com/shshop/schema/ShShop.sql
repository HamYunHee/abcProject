 -- ShShop ----------------------------------------------------------------------------------

SET NAMES 'utf8';
DROP DATABASE IF EXISTS `ShShop`;
CREATE DATABASE IF NOT EXISTS `ShShop` 
DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;
USE `ShShop`;


 -- cr_user ----------------------------------------------------------------------------------

CREATE TABLE `cr_user` (
	`id_user`                 SMALLINT     UNSIGNED NOT NULL AUTO_INCREMENT, -- id_user
	`name`                    VARCHAR(50)  NULL,    -- 유저명
	`gender`                  TINYINT(1)   NULL,    -- 성별
	`ktalk_id`                VARCHAR(50)  NULL,    -- 카카오톡아이디명
	`email`                   VARCHAR(128) NOT NULL,-- 이메일주소
	`phone`                   VARCHAR(30)  NULL,    -- 핸드폰번호
	`password`                VARCHAR(32)  NOT NULL,-- 패스워드
	`birthday`                DATETIME     NULL,    -- 생년월일
	`is_deleted`              TINYINT(1)   NULL,    -- 계정삭제된 유저인지여부 
	`is_guest`                TINYINT(1)   NULL,    -- 손님유저인지여부
	`is_producer`             TINYINT(1)   NULL,    -- 판매자인지 여부
    `bank_name`				  VARCHAR(128) NULL,	-- 계정 인증용 은행명
    `bank_num`				  VARCHAR(128) NULL,	-- 계정 인증용 계좌번호
	`last_password_generated` DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, 	-- 마지막으로 비번 변경날짜
	`date_created`            DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP, 								-- 가입날짜
	`date_updated`            DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, 	-- 정보변경날짜

	CONSTRAINT `PK_cr_user_id_user` 
		PRIMARY KEY (`id_user`)
);

CREATE INDEX `PK_cr_user_email`ON `cr_user` (`email` ASC);


-- ps_category ----------------------------------------------------------------------------------

CREATE TABLE `ps_category` (
	`id_category`        SMALLINT     UNSIGNED NOT NULL AUTO_INCREMENT, -- id_category
	`id_category_parent` SMALLINT     UNSIGNED NULL DEFAULT NULL,     	-- id_category_parent
	`name`               VARCHAR(50)  NOT NULL, -- 카테고리명
	`description`        TEXT         NOT NULL, -- 카테고리 설명
	`link`               VARCHAR(255) NULL,     -- 카테고리 기본링크
	`is_root_category`   TINYINT(1)   NOT NULL, -- 루트카테고리인지여부
	`date_created`       DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP,   				  -- 카테고리 생성 날짜
	`date_updated`       DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, -- 카테고리 업데이트된 날짜
    
     CONSTRAINT `PK_ps_category_id_category` 
		PRIMARY KEY (`id_category`),
        
	 CONSTRAINT `FK_ps_category_parent` 
		FOREIGN KEY (`id_category_parent`)
		REFERENCES `ps_category`(`id_category`)
		ON DELETE CASCADE
		ON UPDATE CASCADE
);

CREATE INDEX `PK_ps_category_name`ON `ps_category` (`name` ASC);

-- ps_product ----------------------------------------------------------------------------------

CREATE TABLE `ps_product` (
	`id_product`      SMALLINT     UNSIGNED NOT NULL AUTO_INCREMENT, -- id_product
	`id_user`         SMALLINT     UNSIGNED NOT NULL,     			 -- id_user
	`name`            VARCHAR(50)  NOT NULL, -- 제품이름
	`price`           INTEGER      NOT NULL, -- 제품가격
	`stock`           INTEGER      NOT NULL, -- 제고량
	`on_sale`         TINYINT(1)   NOT NULL, -- 세일중인지여부
	`on_open`         TINYINT(1)   NOT NULL, -- 공개설정
	`tag`             VARCHAR(128) NULL,     -- 태그
	`out_of_stock`    TINYINT(1)   NOT NULL, -- 상품이 다 팔렸는지 여부
	`description`     TEXT         NOT NULL, -- 상품설명
	`searching_count` INTEGER      NOT NULL, -- 히트수
	`date_created`    DATETIME     NOT NULL NOT NULL DEFAULT CURRENT_TIMESTAMP, 					-- 상품이 더해진 날짜
	`date_updated`    DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,  -- 상품이 업뎃된 날짜
    
    CONSTRAINT `PK_ps_product_id_product` 
		PRIMARY KEY (`id_product`),
	CONSTRAINT `FK_cr_user_TO_ps_product` 
		FOREIGN KEY (`id_user`)
		REFERENCES `cr_user`(`id_user`)
		ON DELETE RESTRICT 
        ON UPDATE CASCADE
);

CREATE INDEX `PK_ps_product_name`ON `ps_product` (`name` ASC);

 
-- ps_product_category ----------------------------------------------------------------------------------
 
CREATE TABLE `ps_product_category` (
	`id_category` SMALLINT UNSIGNED NOT NULL, -- id_category
	`id_product`  SMALLINT UNSIGNED NOT NULL, -- id_product
    
    -- compound key
	CONSTRAINT `PK_ps_product_category` 
		PRIMARY KEY (`id_category`, `id_product`),
        
	-- ps_category -> ps_product_category
	CONSTRAINT `FK_ps_category_TO_ps_product_category` 
		FOREIGN KEY (`id_category`)
		REFERENCES `ps_category` (`id_category`)
		ON DELETE CASCADE,
     
	 -- ps_product -> ps_product_category
	CONSTRAINT `FK_ps_product_TO_ps_product_category`
		FOREIGN KEY (`id_product`)
		REFERENCES `ps_product` ( `id_product` )
		ON DELETE CASCADE
);

CREATE UNIQUE INDEX `PK_ps_product_category`ON `ps_product_category` 
( 
	`id_category` ASC, -- id_category
	`id_product`  ASC  -- id_product
);
 
 -- Insert ----------------------------------------------------------------------------------
 
INSERT INTO `cr_user` 
(`email`, `password`) 
VALUES 
('name1@gmail.com', '1111'),
('name2@gmail.com', '2222'),
('name3@gmail.com', '3333'),
('name4@gmail.com', '4444');
 
 
INSERT INTO `ps_category` 
(`id_category_parent`, `name`, `description`, `link`, `is_root_category`)
VALUES 
(null, 'category1', 'category1_desc', 'category1_link', true),
(null, 'category2', 'category2_desc', 'category2_link', true),
(null, 'category3', 'category3_desc', 'category3_link', true),
(null, 'category4', 'category4_desc', 'category4_link', true),
(null, 'category5', 'category5_desc', 'category5_link', true),
(1, 'category11', 'category11_desc', 'category11_link', true),
(1, 'category12', 'category12_desc', 'category12_link', true),
(1, 'category13', 'category13_desc', 'category13_link', true),
(1, 'category14', 'category14_desc', 'category14_link', true),
(1, 'category15', 'category15_desc', 'category15_link', true),
(2, 'category21', 'category21_desc', 'category21_link', true),
(2, 'category22', 'category22_desc', 'category22_link', true),
(2, 'category23', 'category23_desc', 'category23_link', true),
(2, 'category24', 'category24_desc', 'category24_link', true),
(2, 'category25', 'category25_desc', 'category25_link', true),
(3, 'category31', 'category31_desc', 'category31_link', true),
(3, 'category32', 'category32_desc', 'category32_link', true),
(3, 'category33', 'category33_desc', 'category33_link', true),
(3, 'category34', 'category34_desc', 'category34_link', true),
(3, 'category35', 'category35_desc', 'category35_link', true),
(4, 'category41', 'category41_desc', 'category41_link', true),
(4, 'category42', 'category42_desc', 'category42_link', true),
(4, 'category43', 'category43_desc', 'category43_link', true),
(4, 'category44', 'category44_desc', 'category44_link', true),
(4, 'category45', 'category45_desc', 'category45_link', true),
(5, 'category51', 'category51_desc', 'category51_link', true),
(5, 'category52', 'category52_desc', 'category52_link', true),
(5, 'category53', 'category53_desc', 'category53_link', true),
(5, 'category54', 'category54_desc', 'category54_link', true),
(5, 'category55', 'category55_desc', 'category55_link', true);
 
 
INSERT INTO `ps_product` 
(`id_user`,`name`,`price`,`stock`,`on_sale`,`on_open`,`tag`,`out_of_stock`,`description`,`searching_count`)
VALUES
(1, 'product1', '10', '10', true, true, 'tag1', false, 'description1',0),
(1, 'product2', '20', '20', true, true, 'tag2', false, 'description2',0),
(2, 'product3', '30', '30', true, true, 'tag3', false, 'description3',0),
(2, 'product4', '40', '40', true, true, 'tag4', false, 'description4',0),
(3, 'product5', '50', '50', true, true, 'tag5', false, 'description5',0),
(3, 'product6', '60', '60', true, true, 'tag6', false, 'description6',0);
 
 
INSERT INTO `ps_product_category` 
(`id_category`, `id_product`)
VALUES 
(1, 1),
(1, 2),
(2, 3),
(2, 4),
(3, 5),
(3, 1);

 
 -- Confirm ----------------------------------------------------------------------------------
BEGIN;
 
 -- getUserCount
SELECT COUNT(`cr_user`.`id_user`) as count FROM `cr_user`;

-- getAllProducts
SELECT * FROM `ps_product` WHERE `ps_product`.`id_user`=1;

-- getUserByEmail
SELECT * FROM  `cr_user` WHERE `cr_user`.`email`='name1@gmail.com';

-- updateUser
UPDATE  `cr_user` SET `cr_user`.`name`='tttt' WHERE `cr_user`.`email`='name1@gmail.com';
 
-- getProductById
SELECT * FROM `ps_product` WHERE `id_product` = 1;

-- getProductCount
SELECT COUNT(`id_product`) as count FROM `ps_product`;

-- insertProduct
INSERT INTO  `ps_product` (`id_user`,`name`,`price`,`stock`,`on_sale`,`on_open`,`tag`,`out_of_stock`,`description`,`searching_count`)
VALUES (3, 'product6', '60', '60', true, true, 'tag7', false, 'description6',0);
        
-- getCategoryById
SELECT * FROM `ps_category` WHERE `id_category` = 1;

-- getChildrenCategories 
SELECT * FROM `ps_category` WHERE `id_category_parent`= 1;		

-- getRootCategories        
SELECT * FROM `ps_category` WHERE ISNULL(`id_category_parent`);

-- getAllProducts
SELECT p.*
FROM `ps_product` p
	INNER JOIN `ps_product_category` pc USING(`id_product`) 
	INNER JOIN `ps_category` c USING(`id_category`)
WHERE c.`id_category` = 1;
 
 -- getAllProducts
SELECT COUNT(`id_category`) as count FROM `ps_category`;
SELECT COUNT(`id_category`) as count FROM `ps_product_category`;
DELETE FROM `ps_category` WHERE `id_category`= 1;
SELECT COUNT(`id_category`) as count FROM `ps_category`;
SELECT COUNT(`id_category`) as count FROM `ps_product_category`;
SELECT * FROM `ps_category`;
SELECT * FROM `ps_product_category`;

ROLLBACK;