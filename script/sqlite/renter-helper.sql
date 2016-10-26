--用户信息表
CREATE TABLE renter (
  uid INTEGER PRIMARY KEY,
  name CHAR(15) NOT NULL,
  mobile CHAR(15),
  age INT DEFAULT 0,
  gender CHAR DEFAULT '未知',
  birthday date DEFAULT '0000-00-00',
  comment CHAR(15),
  create_time TIMESTAMP DEFAULT (datetime('now', 'localtime'))
);

--房间信息表
CREATE TABLE room (
  rid INTEGER PRIMARY KEY,
  rental_per_month INT DEFAULT 0, --月租金
  create_time TIMESTAMP DEFAULT (datetime('now', 'localtime'))
);

--租住信息表
CREATE TABLE rent_info (
  iid INTEGER PRIMARY KEY, --信息id
  rid INT NOT NULL , --房间号
  uid INT NOT NULL , --租户id
  renter_number INT DEFAULT 1,  --租住人数
  start_time date DEFAULT '0000-00-00', --起租日期
  end_time date DEFAULT '0000-00-00', --结束日期
  type CHAR DEFAULT '月',  --租住类型：月，季度，半年，年
  rental_expire_time date DEFAULT '0000-00-00', --已缴租金到期时间
  create_time TIMESTAMP DEFAULT (datetime('now', 'localtime'))
);

--缴租日志
CREATE TABLE rent_log (
  lid INTEGER PRIMARY KEY,  --日志id
  uid INT NOT NULL, --租户id
  rid INT NOT NULL, --房号
  pay INT NOT NULL, --缴纳金额
  rental_expire_time date DEFAULT '0000-00-00', --下次缴租日期
  create_time TIMESTAMP DEFAULT (datetime('now', 'localtime'))
);