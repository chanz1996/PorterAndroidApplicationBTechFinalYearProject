BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS `train_route` (
	`route_id`	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,
	`route_train_id`	INTEGER,
	`arrival_station_id`	INTEGER,
	`departure_station_id`	INTEGER,
	`arrival_time`	TEXT,
	`departure_time`	TEXT,
	FOREIGN KEY(`arrival_station_id`) REFERENCES `Station`(`station_id`) ON DELETE SET NULL,
	FOREIGN KEY(`departure_station_id`) REFERENCES `Station`(`station_id`) ON DELETE SET NULL,
	FOREIGN KEY(`route_train_id`) REFERENCES `Train`(`train_id`) ON DELETE SET NULL
);
CREATE TABLE IF NOT EXISTS `booking_train` (
	`pnr`	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,
	`bt_user_id`	NUMERIC NOT NULL,
	`bt_route_id`	INTEGER NOT NULL,
	`coach_no`	INTEGER NOT NULL,
	`seat_no`	INTEGER NOT NULL,
	FOREIGN KEY(`bt_user_id`) REFERENCES `User`(`user_id`) ON DELETE SET NULL,
	FOREIGN KEY(`bt_route_id`) REFERENCES `train_route`(`route_id`) ON DELETE SET NULL
);
CREATE TABLE IF NOT EXISTS `booking_porter` (
	`booking_id`	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,
	`bp_user_id`	INTEGER NOT NULL,
	`bp_porter_id`	INTEGER NOT NULL,
	`bp_pnr`	TEXT NOT NULL,
	`bp_check_point_id`	INTEGER NOT NULL,
	`trip_status`	TEXT NOT NULL,
	`bp_payment_id`	INTEGER,
	FOREIGN KEY(`bp_pnr`) REFERENCES `booking_train`(`pnr`) ON DELETE SET NULL,
	FOREIGN KEY(`bp_porter_id`) REFERENCES `Porter`(`porter_id`) ON DELETE SET NULL,
	FOREIGN KEY(`bp_user_id`) REFERENCES `User`(`user_id`) ON DELETE SET NULL
);
CREATE TABLE IF NOT EXISTS `User` (
	`user_id`	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,
	`user_first_name`	TEXT,
	`user_last_name`	TEXT,
	`user_gender`	TEXT,
	`user_email`	TEXT,
	`user_password`	TEXT,
	`user_age`	INTEGER,
	`user_phone_no`	INTEGER,
	`user_image`	BLOB
);
CREATE TABLE IF NOT EXISTS `Train` (
	`train_id`	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,
	`train_name`	TEXT,
	`no_of_coach`	INTEGER
);
CREATE TABLE IF NOT EXISTS `Station` (
	`station_id`	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,
	`station_name`	TEXT
);
CREATE TABLE IF NOT EXISTS `Porter` (
	`porter_id`	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,
	`porter_first_name`	TEXT NOT NULL,
	`porter_last_name`	TEXT NOT NULL,
	`porter_gender`	TEXT,
	`porter_age`	INTEGER,
	`porter_phone_no`	INTEGER,
	`porter_email`	TEXT,
	`porter_image`	BLOB,
	`porter_status`	INTEGER
);
CREATE TABLE IF NOT EXISTS `Payment` (
	`payment_id`	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,
	`payment_type`	TEXT NOT NULL,
	`discount_percentage`	REAL NOT NULL,
	`amount`	INTEGER NOT NULL,
	`net_amount`	INTEGER NOT NULL
);
CREATE TABLE IF NOT EXISTS `Check_Point` (
	`check_point_id`	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,
	`check_point_name`	TEXT NOT NULL,
	`check_point_longitude`	REAL NOT NULL,
	`check_point_lattitude`	REAL NOT NULL
);
COMMIT;
