-- 商品分类的父表
CREATE SEQUENCE type_father_seq START WITH 10000;
CREATE TABLE type_father (
  type_father_id    NUMBER PRIMARY KEY,
  type_father_name  VARCHAR2(50) NOT NULL,
  type_father_count NUMBER(10)   NOT NULL
);

INSERT INTO type_father VALUES (1, '小说', 100);
INSERT INTO type_father VALUES (2, '青春', 40);
INSERT INTO type_father VALUES (3, '人文社科', 140);
INSERT INTO type_father VALUES (4, '管理', 140);
INSERT INTO type_father VALUES (5, '少儿', 140);
INSERT INTO type_father VALUES (6, '外语', 140);
INSERT INTO type_father VALUES (7, '计算机', 140);


SELECT
  f.TYPE_FATHER_ID,
  f.TYPE_FATHER_NAME,
  f.TYPE_FATHER_COUNT,
  s.type_son_id,
  s.type_son_name,
  s.type_son_count
FROM TYPE_FATHER f LEFT JOIN TYPE_SON s ON f.TYPE_FATHER_ID = s.TYPE_FATHER_ID;


SELECT
  f.TYPE_FATHER_ID    AS ftype_father_id,
  f.TYPE_FATHER_NAME  AS ftype_father_name,
  f.TYPE_FATHER_COUNT AS ftype_father_count,
  s.type_son_id       AS stype_son_id,
  s.type_son_name     AS stype_son_name,
  s.type_son_count    AS stype_son_count
FROM TYPE_FATHER f LEFT JOIN TYPE_SON s ON f.TYPE_FATHER_ID = s.TYPE_FATHER_ID
WHERE f.TYPE_FATHER_ID = 7;

-- 商品分类的子表
SELECT *
FROM type_son;
CREATE SEQUENCE type_son_seq START WITH 10000;
CREATE TABLE type_son (
  type_son_id    NUMBER PRIMARY KEY,
  type_son_name  VARCHAR2(50) NOT NULL,
  type_son_count NUMBER(10)   NOT NULL,
  type_father_id NUMBER(10) REFERENCES type_father (type_father_id)
);

INSERT INTO type_son VALUES (1, '当代小说', 10, 1);
INSERT INTO type_son VALUES (2, '近现代小说', 20, 1);
INSERT INTO type_son VALUES (3, '古典小说', 30, 1);
INSERT INTO type_son VALUES (4, '四大名著', 20, 1);
INSERT INTO type_son VALUES (5, '世界名著', 20, 1);


INSERT INTO type_son VALUES (6, '校园', 10, 2);
INSERT INTO type_son VALUES (7, '爱情/情感', 20, 2);
INSERT INTO type_son VALUES (8, '叛逆/成长', 30, 2);
INSERT INTO type_son VALUES (9, '玄幻', 20, 2);
INSERT INTO type_son VALUES (10, '原创', 20, 2);


INSERT INTO type_son VALUES (11, '政治经济', 10, 3);
INSERT INTO type_son VALUES (12, '经济', 20, 3);
INSERT INTO type_son VALUES (13, '法律', 30, 3);
INSERT INTO type_son VALUES (14, '哲学', 20, 3);
INSERT INTO type_son VALUES (15, '历史', 20, 3);


INSERT INTO type_son VALUES (16, '管理学', 10, 4);
INSERT INTO type_son VALUES (17, '战略管理', 20, 4);
INSERT INTO type_son VALUES (18, '市场营销', 30, 4);
INSERT INTO type_son VALUES (19, '商业史传', 20, 4);
INSERT INTO type_son VALUES (20, '电子商务', 20, 4);


INSERT INTO type_son VALUES (21, '0-2岁', 10, 5);
INSERT INTO type_son VALUES (22, '2-6岁', 20, 5);
INSERT INTO type_son VALUES (23, '7-10岁', 30, 5);
INSERT INTO type_son VALUES (24, '11-14岁', 20, 5);
INSERT INTO type_son VALUES (25, '儿童文学', 20, 5);


INSERT INTO type_son VALUES (26, '英语', 10, 6);
INSERT INTO type_son VALUES (27, '日语', 20, 6);
INSERT INTO type_son VALUES (28, '韩语', 30, 6);
INSERT INTO type_son VALUES (29, '俄语', 20, 6);
INSERT INTO type_son VALUES (30, '德语', 20, 6);


INSERT INTO type_son VALUES (31, '计算机理论', 10, 7);
INSERT INTO type_son VALUES (32, '数据库', 20, 7);
INSERT INTO type_son VALUES (33, '程序设计', 30, 7);
INSERT INTO type_son VALUES (34, '人工智能', 20, 7);
INSERT INTO type_son VALUES (35, '计算机考试', 20, 7);

-- 商品详情表
DROP TABLE orderitem_dangdang;
DROP TABLE goods;
CREATE SEQUENCE goods_seq START WITH 10000;
CREATE TABLE goods (
  good_id                       NUMBER(38) PRIMARY KEY,
  good_name                     VARCHAR2(50),
  good_author                   VARCHAR2(10),
  good_press                    VARCHAR2(20),
  good_publication_time         DATE,
  good_publication_count        NUMBER(5),
  good_printing_time            DATE,
  good_printing_count           NUMBER(5),
  good_isbn                     NUMBER(38),
  good_number_of_words          NUMBER(10),
  good_number_of_page           NUMBER(10),
  good_folio                    NUMBER(5),
  good_paper                    VARCHAR2(10),
  good_package                  VARCHAR2(10),
  good_price                    NUMBER(10),
  good_dangdang_price           NUMBER(10),
  good_image                    VARCHAR2(100),
  good_editorial_recommendation VARCHAR2(38),
  good_editorial_score          VARCHAR2(38),
  good_content_validity         VARCHAR2(4000),
  good_author_validity          VARCHAR2(4000),
  good_catalog                  VARCHAR2(4000),
  good_media_review             VARCHAR2(4000),
  good_digest                   VARCHAR2(4000),
  good_sales_volume             NUMBER(10),
  good_shelf_time               DATE,
  good_stock                    NUMBER(10),
  good_type_son_id              NUMBER(10) REFERENCES type_son (type_son_id),
  good_type_father_id           NUMBER(10) REFERENCES type_father (type_father_id),
  GOOD_CLICK_AMOUNT             NUMBER(38)
);


INSERT INTO
  goods
  (good_id, good_editorial_score, good_name, good_author, good_press, good_image, good_publication_time, good_price, good_dangdang_price, good_content_validity, good_sales_volume, good_shelf_time, good_type_father_id, good_type_son_id)
VALUES
  (goods_seq.nextval, 67, 'Java从入门到放弃', '郭家丰', '郑州大学', '16.jpg',
                      to_date('2007-12-20 18:31:34', 'YYYY-MM-DD HH24:MI:SS'),
                      100, 80, 'Java从入门到放弃你值得拥有！', 10000, to_date('2017-10-13 18:31:34', 'YYYY-MM-DD HH24:MI:SS'), 7,
   32);


INSERT INTO
  goods
  (good_id, good_editorial_score, good_name, good_author, good_press, good_image, good_publication_time, good_price, good_dangdang_price, good_content_validity, good_sales_volume, good_shelf_time, good_type_father_id, good_type_son_id)
VALUES
  (goods_seq.nextval, 12, 'MySql从删库到跑路', '郭家丰', '郑州大学', '12.jpg',
                      to_date('2008-12-20 18:31:34', 'YYYY-MM-DD HH24:MI:SS'),
                      26, 10, 'MySql从删库到跑路你值得拥有！', 100, to_date('2017-09-13 18:31:34', 'YYYY-MM-DD HH24:MI:SS'), 7, 33);

INSERT INTO
  goods
  (good_id, good_editorial_score, good_name, good_author, good_press, good_image, good_publication_time, good_price, good_dangdang_price, good_content_validity, good_sales_volume, good_shelf_time, good_type_father_id, good_type_son_id)
VALUES
  (goods_seq.nextval, 27, 'MySql从删库到跑路', '郭家丰', '郑州大学', '3.jpg',
                      to_date('2009-12-20 18:31:34', 'YYYY-MM-DD HH24:MI:SS'),
                      122, 80, 'MySql从删库到跑路你值得拥有！', 12000, to_date('2016-09-13 18:31:34', 'YYYY-MM-DD HH24:MI:SS'), 1,
   2);


INSERT INTO
  goods
  (good_id, good_editorial_score, good_name, good_author, good_press, good_image, good_publication_time, good_price, good_dangdang_price, good_content_validity, good_sales_volume, good_shelf_time, good_type_father_id, good_type_son_id)
VALUES
  (goods_seq.nextval, 100, 'Oracle从删库到跑路', '郭家丰', '郑州大学', '1.jpg',
                      to_date('2008-12-20 18:31:34', 'YYYY-MM-DD HH24:MI:SS'),
                      120, 50, 'MySql从删库到跑路你值得拥有！', 12000, to_date('2017-09-13 18:31:34', 'YYYY-MM-DD HH24:MI:SS'), 2,
   7);


INSERT INTO
  goods
  (good_id, good_editorial_score, good_name, good_author, good_press, good_image, good_publication_time, good_price, good_dangdang_price, good_content_validity, good_sales_volume, good_shelf_time, good_type_father_id, good_type_son_id)
VALUES
  (goods_seq.nextval, 12, 'PHP从入门到放弃', '郭家丰', '郑州大学', '5.jpg', to_date('2009-09-20 18:31:34', 'YYYY-MM-DD HH24:MI:SS'),
                      60, 30, 'MySql从删库到跑路你值得拥有！', 9000, to_date('2015-10-24 18:31:34', 'YYYY-MM-DD HH24:MI:SS'), 3,
   12);


INSERT INTO
  goods
  (good_id, good_editorial_score, good_name, good_author, good_press, good_image, good_publication_time, good_price, good_dangdang_price, good_content_validity, good_sales_volume, good_shelf_time, good_type_father_id, good_type_son_id)
VALUES
  (goods_seq.nextval, 14, 'MySql从删库到跑路', '郭家丰', '郑州大学', '14.jpg',
                      to_date('2008-12-20 18:31:34', 'YYYY-MM-DD HH24:MI:SS'),
                      120, 50, 'MySql从删库到跑路你值得拥有！', 12000, to_date('2017-09-13 18:31:34', 'YYYY-MM-DD HH24:MI:SS'), 4,
   16);


INSERT INTO
  goods
  (good_id, good_editorial_score, good_name, good_author, good_press, good_image, good_publication_time, good_price, good_dangdang_price, good_content_validity, good_sales_volume, good_shelf_time, good_type_father_id, good_type_son_id)
VALUES
  (goods_seq.nextval, 25, 'MySql从删库到跑路', '郭家丰', '郑州大学', '12.jpg',
                      to_date('2008-12-20 18:31:34', 'YYYY-MM-DD HH24:MI:SS'),
                      120, 50, 'MySql从删库到跑路你值得拥有！', 12000, to_date('2017-09-13 18:31:34', 'YYYY-MM-DD HH24:MI:SS'), 5,
   22);


INSERT INTO
  goods
  (good_id, good_editorial_score, good_name, good_author, good_press, good_image, good_publication_time, good_price, good_dangdang_price, good_content_validity, good_sales_volume, good_shelf_time, good_type_father_id, good_type_son_id)
VALUES
  (goods_seq.nextval, 100, 'MySql从删库到跑路', '郭家丰', '郑州大学', '7.jpg',
                      to_date('2008-12-20 18:31:34', 'YYYY-MM-DD HH24:MI:SS'),
                      120, 50, 'MySql从删库到跑路你值得拥有！', 12000, to_date('2017-09-13 18:31:34', 'YYYY-MM-DD HH24:MI:SS'), 6,
   28);


INSERT INTO
  goods
  (good_id, good_editorial_score, good_name, good_author, good_press, good_image, good_publication_time, good_price, good_dangdang_price, good_content_validity, good_sales_volume, good_shelf_time, good_type_father_id, good_type_son_id)
VALUES
  (goods_seq.nextval, 97, 'MySql从删库到跑路', '郭家丰', '郑州大学', '7.jpg',
                      to_date('2008-12-20 18:31:34', 'YYYY-MM-DD HH24:MI:SS'),
                      120, 50, 'MySql从删库到跑路你值得拥有！', 12000, to_date('2017-09-13 18:31:34', 'YYYY-MM-DD HH24:MI:SS'), 7,
   32);

SELECT *
FROM goods;

DELETE FROM goods;

-- 用户表
DROP TABLE user_dangdang;
CREATE SEQUENCE user_dangdang_seq START WITH 10000;
CREATE TABLE user_dangdang (
  user_id         NUMBER(20) PRIMARY KEY,
  user_email      VARCHAR2(20) NOT NULL UNIQUE,
  user_nickname   VARCHAR2(10) NOT NULL,
  user_password   VARCHAR2(50) NOT NULL,
  user_salt       VARCHAR2(50) NOT NULL,
  user_status     CHAR(1),
  user_score      NUMBER(10),
  user_login_time DATE

);


INSERT INTO
  USER_DANGDANG (USER_ID, USER_EMAIL, USER_NICKNAME, USER_PASSWORD, USER_SALT, USER_STATUS)
VALUES (1, 2, 1, 1, 1, 1);

DELETE FROM user_dangdang;

SELECT *
FROM user_dangdang;

-- 地址表

DROP TABLE user_address;
CREATE SEQUENCE user_address_seq START WITH 10000;
CREATE TABLE user_address (
  address_id                NUMBER(20) PRIMARY KEY,
  address_detail            VARCHAR2(256),
  address_post_number       NUMBER(10),
  address_user_name         VARCHAR2(20),
  address_user_phone        VARCHAR2(20),
  address_user_mobile_phone VARCHAR2(20),
  address_user_id REFERENCES user_dangdang (user_id)

);

-- 订单表
DROP TABLE order_dangdang;
CREATE SEQUENCE order_dangdang_seq;
CREATE TABLE order_dangdang (
  order_id               NUMBER(20) PRIMARY KEY,
  order_create_time      DATE,
  order_delivery_time    DATE,
  order_getdelivery_time DATE,
  order_status           CHAR(1),
  order_total_price      NUMBER(10),
  order_address_id       NUMBER(20) REFERENCES user_address (address_id),
  order_user_id          NUMBER(20) REFERENCES user_dangdang (user_id)
);

-- 订单项表
DROP TABLE orderitem_dangdang;
CREATE SEQUENCE  orderitem_dangdang_seq;
CREATE TABLE orderitem_dangdang (
  orderitem_id         NUMBER(20) PRIMARY KEY,
  orderitem_good_id    NUMBER(20),
  orderitem_count      NUMBER(10),
  orderitem_totalprice NUMBER(10),
  orderitem_price      NUMBER(20),
  orderitem_order_id   NUMBER(10) REFERENCES order_dangdang (order_id)
);


SELECT
  f.TYPE_FATHER_ID   AS ftype_father_id,
  f.TYPE_FATHER_NAME AS ftype_father_name,
  s.type_son_id      AS stype_son_id,
  s.type_son_name    AS stype_son_name,
  s.type_son_count   AS stype_son_count
FROM TYPE_FATHER f LEFT JOIN TYPE_SON s ON f.TYPE_FATHER_ID = s.TYPE_FATHER_ID
WHERE f.TYPE_FATHER_ID = 1 AND s.TYPE_SON_ID = 1;


INSERT INTO ORDER_DANGDANG
(ORDER_ID,ORDER_CREATE_TIME,ORDER_STATUS,ORDER_TOTAL_PRICE,ORDER_ADDRESS_ID,ORDER_USER_ID)
VALUES (1,to_date('2017-09-13 18:31:34', 'YYYY-MM-DD HH24:MI:SS'),1,1,10003,10007);




SELECT
  ADDRESS_DETAIL,
  ADDRESS_POST_NUMBER,
  ADDRESS_USER_NAME,
  ADDRESS_USER_PHONE,
  ADDRESS_USER_MOBILE_PHONE
FROM USER_ADDRESS
WHERE ADDRESS_ID = 10043

SELECT
  ADDRESS_DETAIL,
  ADDRESS_POST_NUMBER,
  ADDRESS_USER_NAME,
  ADDRESS_USER_PHONE,
  ADDRESS_USER_MOBILE_PHONE
FROM USER_ADDRESS
WHERE ADDRESS_USER_ID = 10041
