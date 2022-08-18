#=============================== HOW TO USE TRANSACTION
# need to set autocommit to OFF before each transaction
SET AUTOCOMMIT =OFF; 
START TRANSACTION;

INSERT INTO `Account`(Email , Username, FullName , DepartmentID , PositionID, CreateDate)
VALUES 		('Email1@gmail.com' , 'Username1' ,'Fullname1' , '5' , '1','2020-03-05'),
			('Email2@gmail.com' , 'Username2' ,'Fullname2' , '1' , '2','2020-03-05');

INSERT INTO `Group` ( GroupName , CreatorID , CreateDate)
VALUES 
			(N'Testing System' , 5,'2019-03-05'),
			(N'Development' , 1,'2020-03-07');
            
INSERT INTO Group_Account ( GroupID , AccountID , JoinDate )
VALUES 
			( 1 , 1,'2019-03-05'),
			( 1 , 2,'2020-03-07');
-- If any of these query is not successful, you can rollback the query to the last successful transaction ONLY
ROLLBACK;
COMMIT;

# need to set autocommit to ON after each transaction
SET AUTOCOMMIT =ON;