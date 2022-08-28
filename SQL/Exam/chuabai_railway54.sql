-- ======================RAILWAY 54 - OVERVIEW======================

DROP DATABASE IF EXISTS Testingexam1;
CREATE DATABASE Testingexam1;
USE Testingexam1;


-- ============= Create Table =============================
DROP TABLE IF EXISTS customer;
CREATE TABLE customer(
	customer_id  			INT PRIMARY KEY AUTO_INCREMENT,
    `name`					VARCHAR(100) NOT NULL,
    phone					VARCHAR(20) UNIQUE NOT NULL,
    email					VARCHAR(100) UNIQUE NOT NULL,
    address					VARCHAR(200),
    note					VARCHAR(500)

);

DROP TABLE IF EXISTS car;
CREATE TABLE car(
	car_id					INT PRIMARY KEY AUTO_INCREMENT,
    maker					ENUM('HONDA', 'TOYOTA', 'NISSAN'),
    model					VARCHAR(100) NOT NULL,
    `year`					DATE,
    color					VARCHAR(50),
    note					VARCHAR(500)
    

);

DROP TABLE IF EXISTS car_order;
CREATE TABLE car_order(
	order_id				INT PRIMARY KEY AUTO_INCREMENT,
	customer_id				INT,
    car_id					INT,
	amount					INT DEFAULT 1,
    sale_price				LONG,
    order_date				DATETIME,
    deliver_date			DATETIME,
    deliver_address			VARCHAR(300),
    `status`				ENUM('đã đặt hàng', 'đã giao', 'đã hủy') DEFAULT 'đã đặt hàng',
    note					VARCHAR(500),
    
    FOREIGN KEY (customer_id) 		REFERENCES customer(customer_id),
    FOREIGN KEY (car_id) 			REFERENCES car(car_id)
    
);


-- ============= INSERT DATA =============================


-- Thêm data vào bảng CUSTOMER	======================
INSERT INTO `testingexam1`.`customer` (`customer_id`, `name`, `phone`, `email`, `address`, `note`) VALUES ('1', 'Nguyễn Văn A', '0123456789', 'nguyenvana@gmail.com', 'ha noi', 'chuan bi mua xe');
INSERT INTO `testingexam1`.`customer` (`customer_id`, `name`, `phone`, `email`, `address`, `note`) VALUES ('2', 'Nguyễn Văn B', '0147258369', 'nguyenvanB@gmail.com', 'nam dinh', 'chua du tien mua xe');
INSERT INTO `testingexam1`.`customer` (`customer_id`, `name`, `phone`, `email`, `address`, `note`) VALUES ('3', 'Nguyễn Văn C', '0111222333', 'nguyenvanC@gmail.com', 'ha nam', 'vay tien');
INSERT INTO `testingexam1`.`customer` (`customer_id`, `name`, `phone`, `email`, `address`, `note`) VALUES ('4', 'Nguyễn Văn D', '0122355569', 'nguyenvanD@gmail.com', 'Sai Gon', 'k co tien');
INSERT INTO `testingexam1`.`customer` (`customer_id`, `name`, `phone`, `email`, `address`, `note`) VALUES ('5', 'Nguyễn Văn E', '0258369444', 'nguyenvanE@gmail.com', 'ha nam', 'da co xe');

INSERT INTO `testingexam1`.`customer` (`customer_id`, `name`, `phone`, `email`, `address`, `note`) VALUES ('6', 'Nguyễn Văn F', '0159258666', 'nguyenvanF@gmail.com', 'Ha noi', 'k mua xe');

-- Thêm data vào bảng CAR	======================
INSERT INTO `testingexam1`.`car` (`car_id`, `maker`, `model`, `year`, `color`, `note`) VALUES ('1', 'HONDA', 'A001', '2022-02-24', 'red', 'expensive');
INSERT INTO `testingexam1`.`car` (`car_id`, `maker`, `model`, `year`, `color`, `note`) VALUES ('2', 'HONDA', 'A002', '2022-05-24', 'black', 'cheap');
INSERT INTO `testingexam1`.`car` (`car_id`, `maker`, `model`, `year`, `color`, `note`) VALUES ('3', 'TOYOTA', 'T001', '2022-03-20', 'pink', 'xe dep');
INSERT INTO `testingexam1`.`car` (`car_id`, `maker`, `model`, `year`, `color`, `note`) VALUES ('4', 'TOYOTA', 'T002', '2022-07-25', 'blue', 'camry');
INSERT INTO `testingexam1`.`car` (`car_id`, `maker`, `model`, `year`, `color`, `note`) VALUES ('5', 'NISSAN', 'N001', '2022-07-25', 'yellow', 'Nissan Almera 2021');
INSERT INTO `testingexam1`.`car` (`car_id`, `maker`, `model`, `year`, `color`, `note`) VALUES ('6', 'NISSAN', 'N002', '2022-07-25', 'green', 'GT-R');

-- Thêm data vào bảng CAR_ORDER	======================
INSERT INTO `testingexam1`.`car_order` (`order_id`, `customer_id`, `car_id`, `amount`, `sale_price`, `order_date`, `deliver_date`, `deliver_address`, `status`, `note`) VALUES ('1', '1', '1', '1', '1000000', '2022-12-01', '2022-12-01', 'Hà nội', '1', 'ok');
INSERT INTO `testingexam1`.`car_order` (`order_id`, `customer_id`, `car_id`, `amount`, `sale_price`, `order_date`, `deliver_date`, `deliver_address`, `status`, `note`) VALUES ('2', '2', '2', '2', '2000000', '2022-12-01 00:00:00', '2022-12-02 00:00:00', 'Hà nội', 'đã đặt hàng', 'ok');
INSERT INTO `testingexam1`.`car_order` (`order_id`, `customer_id`, `car_id`, `amount`, `sale_price`, `order_date`, `deliver_date`, `deliver_address`, `status`, `note`) VALUES ('3', '3', '3', '1', '2000000', '2022-12-01 00:00:00', '2022-12-02 00:00:00', 'Hà nội', 'đã đặt hàng', 'ok');
INSERT INTO `testingexam1`.`car_order` (`order_id`, `customer_id`, `car_id`, `amount`, `sale_price`, `order_date`, `deliver_date`, `deliver_address`, `status`, `note`) VALUES ('4', '4', '4', '4', '5000000', '2022-12-01 00:00:00', '2022-12-02 00:00:00', 'Hà nội', 'đã đặt hàng', 'ok');
INSERT INTO `testingexam1`.`car_order` (`order_id`, `customer_id`, `car_id`, `amount`, `sale_price`, `order_date`, `deliver_date`, `deliver_address`, `status`, `note`) VALUES ('5', '5', '1', '10', '25000000', '2022-12-01 00:00:00', '2022-12-02 00:00:00', 'Hà nội', 'đã đặt hàng', 'ok');
INSERT INTO `testingexam1`.`car_order` (`order_id`, `customer_id`, `car_id`, `amount`, `sale_price`, `order_date`, `deliver_date`, `deliver_address`, `status`, `note`) VALUES ('6', '1', '2', '8', '3000000', '2022-12-01 00:00:00', '2022-12-02 00:00:00', 'Hà nội', 'đã đặt hàng', 'ok');

INSERT INTO `testingexam1`.`car_order` (`order_id`, `customer_id`, `car_id`, `amount`, `sale_price`, `order_date`, `deliver_date`, `deliver_address`, `status`, `note`) VALUES ('7', '1', '5', '2', '15000000', '2022-12-01 00:00:00', '2022-12-02 00:00:00', 'Hà nội', 'đã đặt hàng', 'ok');
INSERT INTO `testingexam1`.`car_order` (`order_id`, `customer_id`, `car_id`, `amount`, `sale_price`, `order_date`, `deliver_date`, `deliver_address`, `status`, `note`) VALUES ('8', '1', '6', '3', '15000000', '2022-12-01 00:00:00', '2022-12-02 00:00:00', 'Hà nội', 'đã đặt hàng', 'ok');


UPDATE `testingexam1`.`car_order` SET `status` = '2' WHERE (`order_id` = '7');
UPDATE `testingexam1`.`car_order` SET `status` = '2' WHERE (`order_id` = '8');

UPDATE `testingexam1`.`car_order` SET `status` = '2' WHERE (`order_id` = '3');
UPDATE `testingexam1`.`car_order` SET `status` = '2' WHERE (`order_id` = '4');

UPDATE `testingexam1`.`car_order` SET `status` = '2' WHERE (`order_id` = '2');



INSERT INTO `testingexam1`.`car_order` (`order_id`, `customer_id`, `car_id`, `amount`, `sale_price`, `order_date`, `deliver_date`, `deliver_address`, `status`, `note`) VALUES ('9', '2', '3', '50', '100000000', '2021-12-01 00:00:00', '2021-12-02 00:00:00', 'Hà nội', '3', 'ok');
INSERT INTO `testingexam1`.`car_order` (`order_id`, `customer_id`, `car_id`, `amount`, `sale_price`, `order_date`, `deliver_date`, `deliver_address`, `status`) VALUES ('10', '1', '1', '1', '100000000', '2021-12-01 00:00:00', '2021-12-02 00:00:00', 'Hà nội', '3');


-- ============================================================================================================================================================================================================================
-- =============CHữa BÀI============================================

-- Câu 2: Viết lệnh lấy ra thông tin của khách hàng: tên, số lượng oto khách hàng đã
--       mua và sắp sếp tăng dần theo số lượng oto đã mua.
-- COALESCE(yourColumnName,0)

SELECT  c.`name`, COALESCE(sum(co.amount), 0) AS Số_Lượng_Xe_Đã_Mua
FROM	customer c
LEFT JOIN	car_order co
ON		c.customer_id = co.customer_id
GROUP BY c.customer_id
ORDER BY Số_Lượng_Xe_Đã_Mua;

-- Câu 3: Viết hàm (không có parameter) trả về tên hãng sản xuất đã bán được nhiều
--        oto nhất trong năm nay.


-- bán được nhiều oto nhất
SELECT c.maker, sum(co.amount) AS So_luong_xe_da_ban_ra
FROM car c
JOIN car_order co
ON c.car_id = co.car_id
WHERE YEAR(co.deliver_date) = year(now()) AND co.`status` = 'đã giao'
Group by c.maker
HAVING sum(co.amount) = (	SELECT sum(amount) AS sll
							FROM car_order
                            Group by sum(amount)
                            ORDER BY sll DESC
                            LIMIT 1 );



SELECT maker, So_luong_xe_da_ban_ra
FROM (	SELECT c.maker, sum(co.amount) AS So_luong_xe_da_ban_ra
		FROM car c
		JOIN car_order co
		ON c.car_id = co.car_id
		WHERE YEAR(co.deliver_date) = year(now()) AND co.`status` = 'đã giao'
		Group by c.maker) AS B
        
WHERE  So_luong_xe_da_ban_ra = (	SELECT max(So_luong_xe_da_ban_ra)
									FROM (	SELECT c.maker, sum(co.amount) AS So_luong_xe_da_ban_ra
											FROM car c
											JOIN car_order co
											ON c.car_id = co.car_id
											WHERE YEAR(co.deliver_date) = year(now()) AND co.`status` = 'đã giao'
											Group by c.maker) AS C );



SET GLOBAL log_bin_trust_function_creators = 1;

-- Dùng Subquery ===============================================================
DELIMITER $$
	CREATE FUNCTION hang_ban_nhieu_o_to_nhat() RETURNS VARCHAR(50)
    BEGIN
		DECLARE maker_func VARCHAR(50);
		SELECT maker INTO maker_func
			FROM (	SELECT c.maker, sum(co.amount) AS So_luong_xe_da_ban_ra
					FROM car c
					JOIN car_order co
					ON c.car_id = co.car_id
					WHERE YEAR(co.deliver_date) = year(now()) AND co.`status` = 'đã giao'
					Group by c.maker) AS B
        
			WHERE  So_luong_xe_da_ban_ra = (	SELECT max(So_luong_xe_da_ban_ra)
												FROM (	SELECT c.maker, sum(co.amount) AS So_luong_xe_da_ban_ra
														FROM car c
														JOIN car_order co
														ON c.car_id = co.car_id
														WHERE YEAR(co.deliver_date) = year(now()) AND co.`status` = 'đã giao'
														Group by c.maker) AS C );
    
    RETURN maker_func;
    END $$
DELIMITER ;

SELECT hang_ban_nhieu_o_to_nhat();

-- =================

-- WITH hang_ban_nhieu_o_to_nhat_cte
-- AS
-- 	(SELECT maker, So_luong_xe_da_ban_ra
-- 	FROM (	SELECT c.maker, sum(co.amount) AS So_luong_xe_da_ban_ra
-- 			FROM car c
-- 			JOIN car_order co
-- 			ON c.car_id = co.car_id
-- 			WHERE YEAR(co.deliver_date) = year(now()) AND co.`status` = 'đã giao'
-- 			Group by c.maker) AS B
-- 			
-- 	WHERE  So_luong_xe_da_ban_ra = (	SELECT max(So_luong_xe_da_ban_ra)
-- 										FROM (	SELECT c.maker, sum(co.amount) AS So_luong_xe_da_ban_ra
-- 												FROM car c
-- 												JOIN car_order co
-- 												ON c.car_id = co.car_id
-- 												WHERE YEAR(co.deliver_date) = year(now()) AND co.`status` = 'đã giao'
-- 												Group by c.maker) AS C ) )
--                                                 

-- SELECT maker From hang_ban_nhieu_o_to_nhat_cte



-- -- Dùng CTE ===========================
-- DELIMITER $$
-- 	CREATE FUNCTION hang_ban_nhieu_o_to_nhat() RETURNS VARCHAR(50)
--     BEGIN
-- 		DECLARE maker_func VARCHAR(50);
-- 		WITH hang_ban_nhieu_o_to_nhat_cte
-- AS
-- 	(SELECT maker, So_luong_xe_da_ban_ra
-- 	FROM (	SELECT c.maker, sum(co.amount) AS So_luong_xe_da_ban_ra
-- 			FROM car c
-- 			JOIN car_order co
-- 			ON c.car_id = co.car_id
-- 			WHERE YEAR(co.deliver_date) = year(now()) AND co.`status` = 'đã giao'
-- 			Group by c.maker) AS B
-- 			
-- 	WHERE  So_luong_xe_da_ban_ra = (	SELECT max(So_luong_xe_da_ban_ra)
-- 										FROM (	SELECT c.maker, sum(co.amount) AS So_luong_xe_da_ban_ra
-- 												FROM car c
-- 												JOIN car_order co
-- 												ON c.car_id = co.car_id
-- 												WHERE YEAR(co.deliver_date) = year(now()) AND co.`status` = 'đã giao'
-- 												Group by c.maker) AS C ) )
--                                                 

-- 	SELECT maker INTO maker_func From hang_ban_nhieu_o_to_nhat_cte;
--     
--     RETURN maker_func;
--     END $$
-- DELIMITER ;


-- Câu 4: Viết 1 thủ tục (không có parameter) để xóa các đơn hàng đã bị hủy của
-- những năm trước. In ra số lượng bản ghi đã bị xóa.


DELETE FROM car_order co
WHERE `status` = 3 AND year(order_date) < year(now());

SELECT count(order_id)
FROM car_order
WHERE `status` = 3 AND year(order_date) < year(now());

-- ===================================================
DROP PROCEDURE IF EXISTS xoa_don_hang_cua_nam_truoc;
DELIMITER $$
	CREATE PROCEDURE xoa_don_hang_cua_nam_truoc()
    
    BEGIN
		DECLARE so_ban_ghi_da_xoa INT;
    
		SELECT count(order_id) INTO So_ban_ghi_Da_xoa
		FROM car_order
		WHERE `status` = 3 AND year(order_date) < year(now());
    
		DELETE FROM car_order co
		WHERE `status` = 3 AND year(order_date) < year(now());
        
        SELECT so_ban_ghi_da_xoa;
    END $$
DELIMITER ;

Call xoa_don_hang_cua_nam_truoc();



-- Cau 5: Viết 1 thủ tục (có CustomerID parameter) để in ra thông tin của các đơn
-- hàng đã đặt hàng bao gồm: tên của khách hàng, mã đơn hàng, số lượng oto
-- và tên hãng sản xuất.


SELECT c.`name`, co.order_id, co.amount, ca.maker
FROM car_order co
JOIN car ca
ON co.car_id = ca.car_id
JOIN customer c
ON co.customer_id = c.customer_id
WHERE co.`status` = 1 AND c.customer_id = 1;


DROP PROCEDURE IF EXISTS don_hang_da_dat_hang;
DELIMITER $$
	CREATE PROCEDURE don_hang_da_dat_hang( IN customer_id INT)
    BEGIN
		SELECT c.`name`, co.order_id, co.amount, ca.maker
		FROM car_order co
		JOIN car ca
		ON co.car_id = ca.car_id
		JOIN customer c
		ON co.customer_id = c.customer_id
		WHERE co.`status` = 1 AND c.customer_id = customer_id;
    END $$
DELIMITER ;

SET @customer_id = 15;

SELECT @customer_id;

CALL don_hang_da_dat_hang(@customer_id);

CALL don_hang_da_dat_hang(5);



-- Câu 6: Viết trigger để tránh trường hợp người dụng nhập thông tin không hợp lệ
-- vào database (DeliveryDate > OrderDate + 15). -- ngày giao hàng phải lớn hơn ngày đặt hàng là 15 ngày

DROP TRIGGER IF EXISTS verify_date;
DELIMITER $$
	CREATE TRIGGER verify_date
    BEFORE INSERT ON car_order
    FOR EACH ROW
    BEGIN
		IF(NEW.deliver_date <= Date_add(NEW.order_date, interval(15) day))
        THEN
			SIGNAL SQLSTATE '12345'
			SET MESSAGE_TEXT = 'Sau 15 ngày đặt hàng mới được giao hàng';
        END IF;
    END $$
DELIMITER ;

Show TRIGGERS FROM testingexam1;



