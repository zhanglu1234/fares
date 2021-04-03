-- auto Generated on 2021-03-25
-- DROP TABLE IF EXISTS order_info;
CREATE TABLE orderInfo(
	order_status VARCHAR (50) NOT NULL COMMENT '订单状态:预约订单是否有效',
	payment DECIMAL (13,4) NOT NULL COMMENT '缴费金额',
	payment_status VARCHAR (50) NOT NULL COMMENT '缴费状态：是否缴费',
	order_number VARCHAR (50) NOT NULL COMMENT '订单号',
	payment_time DATETIME NOT NULL COMMENT '缴费时间',
	event_type VARCHAR (50) NOT NULL COMMENT '出入园区状态',
	event_time DATETIME NOT NULL COMMENT '出入园区时间',
	PRIMARY KEY (order_number)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT 'order_info';
-- auto Generated on 2021-03-25
-- DROP TABLE IF EXISTS order_info;
CREATE TABLE order_info(
	orderClientId INT (11) NOT NULL COMMENT '用户id',
	orderDriverId INT (11) NOT NULL COMMENT '司机id',
	orderStatus VARCHAR (50) NOT NULL COMMENT '订单状态:预约订单是否有效',
	payment DECIMAL (13,4) NOT NULL COMMENT '缴费金额',
	paymentStatus VARCHAR (50) NOT NULL COMMENT '缴费状态：是否缴费',
	orderNumber VARCHAR (50) NOT NULL COMMENT '订单号',
	paymentTime DATETIME NOT NULL COMMENT '缴费时间',
	eventType VARCHAR (50) NOT NULL COMMENT '出入园区状态',
	dateTime DATETIME NOT NULL COMMENT '出入园区时间',
	PRIMARY KEY (orderNumber)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT 'order_info';
