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

CREATE TABLE rent_info (
  iid INTEGER PRIMARY KEY,
  rid INT NOT NULL,
  uid INT NOT NULL,
  renter_number INT DEFAULT 1,
  rental_per_month INT DEFAULT 0,
  start_time date DEFAULT '0000-00-00',
  end_time date DEFAULT '0000-00-00',
  type CHAR DEFAULT '月',
  rental_expire_time date DEFAULT '0000-00-00',
  create_time TIMESTAMP DEFAULT (datetime('now', 'localtime'))
);

CREATE TABLE rent_log (
  lid INTEGER PRIMARY KEY,
  uid INT NOT NULL,
  rid INT NOT NULL,
  pay INT NOT NULL,
  rental_expire_time date DEFAULT '0000-00-00',
  create_time TIMESTAMP DEFAULT (datetime('now', 'localtime'))
);