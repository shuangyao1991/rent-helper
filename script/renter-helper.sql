CREATE TABLE renter (
  uid INTEGER PRIMARY KEY,
  name CHAR(15) NOT NULL ,
  mobile CHAR(15) DEFAULT '',
  age INT DEFAULT 0,
  gender CHAR DEFAULT '未知',
  birthday TEXT DEFAULT '0000-00-00 00:00:00',
  create_time TIMESTAMP DEFAULT (datetime('now', 'localtime'))
);

CREATE TABLE rent_info (
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
  create_time TIMESTAMP DEFAULT (datetime('now', 'localtime'))
)