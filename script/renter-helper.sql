CREATE TABLE renter (
  uid INTEGER PRIMARY KEY,
  name CHAR(15) NOT NULL ,
  mobile CHAR(15) ,
  age INT DEFAULT ,
  gender CHAR DEFAULT '未知',
  birthday TEXT DEFAULT '0000-00-00 00:00:00',
  comment CHAR(15) DEFAULT '',
  create_time TIMESTAMP DEFAULT (datetime('now', 'localtime'))
);

CREATE TABLE rent_info (
  iid INTEGER PRIMARY KEY,
  rid INT NOT NULL ,
  uid INT NOT NULL ,
  renter_number INT DEFAULT 1,
  rental_per_month INT DEFAULT 0,
  start_time TEXT DEFAULT '0000-00-00',
  end_time TEXT DEFAULT '0000-00-00',
  type CHAR DEFAULT '月',
  rental_expire_time TEXT DEFAULT '0000-00-00',
  create_time TIMESTAMP DEFAULT (datetime('now', 'localtime'))
);

CREATE TABLE rent_log(
  lid INTEGER PRIMARY KEY ,
  uid INT NOT NULL ,
  rid INT NOT NULL ,
  pay INT NOT NULL ,
  rental_expire_time TEXT DEFAULT '0000-00-00',
  create_time TIMESTAMP DEFAULT (datetime('now', 'localtime'))
)