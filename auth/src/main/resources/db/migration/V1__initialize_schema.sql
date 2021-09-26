CREATE TABLE IF NOT EXISTS `USER` (
	`id` varchar(50) NOT NULL PRIMARY KEY,
	`username` varchar(100) not null, 
	`password` varchar(100) not null, 
	`roles` varchar(255)
)