set names utf8;
set foreign_key_checks=0;

drop database if exists rose;
create database if not exists rose;

use rose;

drop table if exists user_info;
create table user_info(
id int primary key not null auto_increment comment "ID",
user_id varchar(16) unique not null comment "ユーザーID",
password varchar(16) not null comment "パスワード",
family_name varchar(32) not null comment "姓",
first_name varchar(32) not null comment "名",
family_name_kana varchar(32) not null comment "姓かな",
first_name_kana varchar(32) not null comment "名かな",
sex tinyint not null default 0 comment "性別 0:男性 1:女性",
email varchar(32) not null comment "メールアドレス",
status tinyint not null default 0 comment "ステータス 0:無効 1:有効",
logined tinyint not null default 0 comment "ログインフラグ 0:未ログイン 1:ログイン済",
regist_date datetime not null comment "登録日",
update_date datetime comment "更新日"
)default charset=utf8 comment="会員情報テーブル";

insert into user_info values
(1,"guest","guest","ゲストユーザー","ローズチーム","げすとゆーざー","ろーずちーむ",0,"guest@gmail.com",0,0,now(),now()),
(2,"guest2","guest2","ゲストユーザー2","ローズチーム2","げすとゆーざー2","ろーずちーむ2",0,"guest2@gmail.com",0,0,now(),now()),
(3,"guest3","guest3","ゲストユーザー3","ローズチーム3","げすとゆーざー3","ろーずちーむ3",0,"guest3@gmail.com",0,0,now(),now()),
(4,"guest4","guest4","ゲストユーザー4","ローズチーム4","げすとゆーざー4","ろーずちーむ4",0,"guest4@gmail.com",0,0,now(),now()),
(5,"guest5","guest5","ゲストユーザー5","ローズチーム5","げすとゆーざー5","ろーずちーむ5",0,"guest5@gmail.com",0,0,now(),now()),
(6,"guest6","guest6","ゲストユーザー6","ローズチーム6","げすとゆーざー6","ろーずちーむ6",0,"guest6@gmail.com",0,0,now(),now()),
(7,"guest7","guest7","ゲストユーザー7","ローズチーム7","げすとゆーざー7","ろーずちーむ7",0,"guest7@gmail.com",0,0,now(),now()),
(8,"guest8","guest8","ゲストユーザー8","ローズチーム8","げすとゆーざー8","ろーずちーむ8",0,"guest8@gmail.com",0,0,now(),now()),
(9,"guest9","guest9","ゲストユーザー9","ローズチーム9","げすとゆーざー9","ろーずちーむ9",0,"guest9@gmail.com",0,0,now(),now()),
(10,"guest10","guest10","ゲストユーザー10","ローズチーム10","げすとゆーざー10","ろーずちーむ10",0,"guest10@gmail.com",0,0,now(),now()),
(11,"guest11","guest11","ゲストユーザー11","ローズチーム11","げすとゆーざー11","ろーずちーむ11",0,"guest11@gmail.com",0,0,now(),now()),
(12,"guest12","guest12","ゲストユーザー12","ローズチーム12","げすとゆーざー12","ろーずちーむ12",0,"guest12@gmail.com",0,0,now(),now());


drop table if exists product_info;
create table product_info(
id int primary key not null auto_increment comment "ID",
product_id int unique not null comment "商品ID",
product_name varchar(100) unique not null comment "商品名",
product_name_kana varchar(100) unique not null comment "商品名かな",
product_description varchar(255) not null comment "商品詳細",
category_id int not null comment "カテゴリID",
price int comment "価格",
image_file_path varchar(100) comment "画像ファイルパス",
image_file_name varchar(50) comment "画像ファイル名",
release_date datetime not null comment "発売年月",
release_company varchar(50) comment "発売会社",
status tinyint not null default 0 comment "ステータス 0:無効 1:有効",
regist_date datetime not null comment "登録日",
update_date datetime comment "更新日",
foreign key(category_id) references m_category(category_id)
)default charset=utf8 comment="商品情報テーブル";

insert into product_info values
( 1, 1,"木製まな板","もくせいまないた","木製まな板の商品詳細",2,100,"./images","CuttingBoard1.jpg",now(),"発売会社",0,now(),now()),
( 2, 2,"カップセット","かっぷせっと","カップセットの商品詳細",2,200,"./images","2cup.jpg",now(),"発売会社",0,now(),now()),
( 3, 3,"アク取り名人","あくとりめいじん","アク取り名人の商品詳細",2,300,"./images","akuupdevice.jpg",now(),"発売会社",0,now(),now()),
( 4, 4,"箸立て","はしたて","箸立ての商品詳細",2,100,"./images","chopstickstand.jpg",now(),"発売会社",0,now(),now()),
( 5, 5,"胡麻擂りセット","ごますりせっと","胡麻擂りセットの商品詳細",2,200,"./images","gomasuri.jpg",now(),"発売会社",0,now(),now()),
( 6, 6,"ヤカン","やかん","ヤカンの商品詳細",2,300,"./images","kettle.jpg",now(),"発売会社",0,now(),now()),
( 7, 7,"上皿自動天秤","うわざらじどうてんびん","上皿自動天秤の商品詳細",2,100,"./images","measure.jpg",now(),"発売会社",0,now(),now()),
( 8, 8,"ジュースミキサー","じゅーすみきさー","ジュースミキサーの商品詳細",2,200,"./images","mixer.jpg",now(),"発売会社",0,now(),now()),
( 9, 9,"ステンレスボール","すてんれすぼーる","ステンレスボールの商品詳細",2,300,"./images","mixingbowl.jpg",now(),"発売会社",0,now(),now()),
( 10, 10,"御猪口セット","おちょこせっと","御猪口セットの商品詳細",2,100,"./images","smallcup.jpg",now(),"発売会社",0,now(),now()),
( 11, 11,"木製ヘラ","もくせいへら","木製ヘラの商品詳細",2,200,"./images","woodspatula.jpg",now(),"発売会社",0,now(),now()),
( 12, 12,"プラスチック製ヘラ","ぷらすちっくせいへら","プラスチック製ヘラの商品詳細",2,300,"./images","spatula2.jpg",now(),"発売会社",0,now(),now()),
( 13, 13,"スプーン・フォーク","すぷーん・ふぉーく","スプーン・フォークの商品詳細",2,100,"./images","spoonfork.jpg",now(),"発売会社",0,now(),now()),
( 14, 14,"食器セット","しょっきせっと","食器セットの商品詳細",2,200,"./images","tableware.jpg",now(),"発売会社",0,now(),now()),
( 15, 15,"ヘラ(白)","へら（しろ）","ヘラ(白)の商品詳細",2,300,"./images","spatula.jpg",now(),"発売会社",0,now(),now()),
( 28,28,"ソファー（ホワイト）","そふぁー（ほわいと）","ソファー（ホワイト）の商品詳細",3,100,"./images","sofa1.jpg",now(),"発売会社",0,now(),now()),
( 29,29,"ガラステーブル","がらすてーぶる","ガラステーブルの商品詳細",3,200,"./images","table2.jpg",now(),"発売会社",0,now(),now()),
( 30,30,"ソファー（花柄）","そふぁー（はながら）","ソファー（花柄）の商品詳細",3,300,"./images","sofa2.jpg",now(),"発売会社",0,now(),now()),
( 31,31,"竹編丸テーブル","たけあみまるてーぶる","竹編丸テーブルの商品詳細",3,100,"./images","minitable.jpg",now(),"発売会社",0,now(),now()),
( 32,32,"丸テーブル＆チェアセット","まるてーぶるちぇあせっと","丸テーブル＆チェアセットの商品詳細",3,200,"./images","tablechair.jpg",now(),"発売会社",0,now(),now()),
( 55,55,"ベッド１","べっど１","ベッド１の商品詳細",4,100,"./images","bed1.jpg",now(),"発売会社",0,now(),now()),
( 56,56,"ベッド2","べっど2","ベッド2の商品詳細",4,200,"./images","bed2.jpg",now(),"発売会社",0,now(),now()),
( 57,57,"U字枕","ゆうじまくら","U字枕の商品詳細",4,300,"./images","pillow.jpg",now(),"発売会社",0,now(),now()),
( 58,58,"目覚まし時計","めざましどけい","目覚まし時計の商品詳細",4,400,"./images","目覚まし時計.jpg",now(),"発売会社",0,now(),now()),
( 59,59,"寝袋","ねぶくろ","寝袋の商品詳細",4,500,"./images","寝袋.jpg",now(),"発売会社",0,now(),now()),
( 60,60,"敷布団","しきぶとん","敷布団の商品詳細",4,600,"./images","敷布団.jpg",now(),"発売会社",0,now(),now()),
( 61,61,"枕","まくら","枕の商品詳細",4,700,"./images","枕.jpg",now(),"発売会社",0,now(),now()),
( 62,62,"枕カバー","まくらかばー","枕カバーの商品詳細",4,800,"./images","枕カバー.jpg",now(),"発売会社",0,now(),now()),
( 63,63,"間接照明","かんせつしょうめい","間接照明の商品詳細",4,900,"./images","間接照明.jpg",now(),"発売会社",0,now(),now()),
( 64,64,"毛布","もうふ","毛布の商品詳細",4,1000,"./images","毛布.jpg",now(),"発売会社",0,now(),now());



drop table if exists cart_info;
create table cart_info(
id int primary key not null auto_increment comment "ID",
user_id varchar(16) not null comment "ユーザーID",
temp_user_id varchar(16) comment "仮ユーザーID",
product_id int not null comment "商品ID",
product_count int not null comment "個数",
price int not null comment "金額",
regist_date datetime not null comment "登録日",
update_date datetime comment "更新日"
)default charset=utf8 comment="カート情報テーブル";


drop table if exists purchase_history_info;
create table purchase_history_info(
id int primary key not null auto_increment comment "ID",
user_id varchar(16) not null comment "ユーザーID",
product_id int not null comment "商品ID",
product_count int not null comment "個数",
price int not null comment "金額",
destination_id int not null comment "宛先情報ID",
regist_date datetime not null comment "登録日",
update_date datetime not null comment "更新日",
foreign key(product_id) references product_info(product_id)
)default charset=utf8 comment="購入履歴情報テーブル";


drop table if exists destination_info;
create table destination_info(
id int primary key not null auto_increment comment "ID",
user_id varchar(16) not null comment "ユーザーID",
family_name varchar(32) not null comment "姓",
first_name varchar(32) not null comment "名",
family_name_kana varchar(32) not null comment "姓かな",
first_name_kana varchar(32) not null comment "名かな",
email varchar(32) not null comment "メールアドレス",
tel_number varchar(13) not null comment "電話番号",
user_address varchar(50) not null comment "住所",
regist_date datetime not null comment "登録日",
update_date datetime comment "更新日"
)default charset=utf8 comment="宛先情報テーブル";


drop table if exists m_category;
create table m_category(
id int primary key not null comment "ID",
category_id int not null unique comment "カテゴリID",
category_name varchar(20) not null unique comment "カテゴリ名",
category_description varchar(100) comment "カテゴリ詳細",
insert_date datetime not null comment "登録日",
update_date datetime comment "更新日"
)default charset=utf8 comment="カテゴリマスタテーブル";

insert into m_category values
(1,1,"全てのカテゴリー","キッチン・リビング・ベッドルーム全てのカテゴリーが対象となります",now(),now()),
(2,2,"キッチン","キッチンに関するカテゴリーが対象となります",now(),now()),
(3,3,"リビング","リビングに関するカテゴリーが対象となります",now(),now()),
(4,4,"ベッドルーム","ベッドルームに関するカテゴリーが対象となります",now(),now());