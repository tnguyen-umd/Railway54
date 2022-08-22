Use rdbms;

##2. Viết lệnh lấy ra thông tin của khách hàng: tên, số lượng oto khách hàng đã 
#mua và sắp sếp tăng dần theo số lượng oto đã mua.

SELECT A.customerID, A.name, B.Amount
FROM customer A
JOIN `order` B
ON A.customerID=B.customerID
ORDER BY B.Amount ASC;

#3. Viết hàm (không có parameter) trả về tên hãng sản xuất đã bán được nhiều oto nhất trong năm nay.
DROP PROCEDURE IF EXISTS max_car_maker;
DELIMITER $$
CREATE PROCEDURE max_car_maker ()
BEGIN
				SELECT B.maker, A.Amount
				 FROM `order` A
				 JOIN car B
				 ON A.CarID=B.CarID
				 ORDER BY A.Amount DESC
				 LIMIT 1;
END$$
DELIMITER ;

CALL max_car_maker();


#4. Viết 1 thủ tục (không có parameter) để xóa các đơn hàng đã bị hủy của 
#những năm trước. In ra số lượng bản ghi đã bị xóa.

SET AUTOCOMMIT = OFF; 
START TRANSACTION;

DROP PROCEDURE IF EXISTS Delete_order_last_year;
DELIMITER $$
CREATE PROCEDURE Delete_order_last_year ()

BEGIN
				DECLARE v_order_last_year INT;
                
                SET v_order_last_year= (SELECT COUNT(orderID) AS count 
												FROM `order`
												WHERE `order`.status='Cancelled' 
                                                AND YEAR(OrderDate)<=YEAR(date_sub(now(), INTERVAL 1 YEAR))
                                                GROUP BY status);
                                                              
				DELETE FROM `order`
				WHERE `order`.status='Cancelled'
                AND YEAR(OrderDate)<=YEAR(date_sub(now(), INTERVAL 1 YEAR));
				
                SELECT v_order_last_year AS Records_Deleted;
END$$
DELIMITER ;

CALL Delete_order_last_year ();

ROLLBACK;
COMMIT;

#5. Viết 1 thủ tục (có CustomerID parameter) để in ra thông tin của các đơn 
#hàng đã đặt hàng bao gồm: tên của khách hàng, mã đơn hàng, số lượng oto 
#và tên hãng sản xuất.
DROP PROCEDURE IF EXISTS Get_customer_order;
DELIMITER $$
CREATE PROCEDURE Get_customer_order (
				IN In_CustomerID INT
				)

BEGIN
				SELECT A.name, B.orderID, B.Amount, C.maker
				FROM customer A 
				JOIN `order` B ON A.customerID=B.customerID
				JOIN car C ON B.carID=C.carID
				WHERE A.customerID=In_CustomerID;

END$$
DELIMITER ;

CALL Get_customer_order(1);

#6. Viết trigger để tránh trường hợp người dụng nhập thông tin không hợp lệ 
#vào database (DeliveryDate < OrderDate + 15).
DROP TRIGGER IF EXISTS Trigger_DeliveryDate;
DELIMITER $$
CREATE TRIGGER Trigger_DeliveryDate
#BEFORE/AFTER/INSTEAD OF INSERT/UPDATE/DELETE ON name_table
BEFORE INSERT ON `order`
FOR EACH ROW
BEGIN 
-- logic
		IF NEW.DeliveryDate <date_add(NEW.OrderDate, INTERVAL 15 DAY)
        THEN
			SIGNAL SQLSTATE '12345'
			SET MESSAGE_TEXT='Ngay giao xe khong duoc som hon ngay dat hang 15 ngay';
		END IF;

END $$
DELIMITER ;

insert into `order` ( CustomerID, CarID, Amount, SalePrice, OrderDate, DeliveryDate, DeliveryAddress, `Status`, Note) 
values 
		( 1, 1, 11, 120, '2022-04-26', '2022-05-05', 'Unknown', 'Ordered', 'this is a test');