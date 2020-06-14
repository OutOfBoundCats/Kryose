CREATE TABLE `user_details` (
  `id` int NOT NULL AUTO_INCREMENT,
  `userID` int NOT NULL,
  `username` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `userID` (`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

ALTER TABLE user
ADD `userDetailsID` int(11),
ADD foreign key(userDetailsID) references user_details(id);

ALTER TABLE user_details
DROP `userID` ;

ALTER TABLE `user` CHANGE `userDetailsID` `user_details_id` int;

DROP TABLE IF EXISTS `resource`;
CREATE TABLE `resource` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `credits` int(11) default 0,
  `username` varchar(50) NOT NULL unique,
  `start_date` datetime,
  `end_date` datetime ,
  `current_plan` varchar(50) ,
  `current_plan_credits` int(11) ,
  `current_plan_surcharge` int(11),
  `surcharge_amount` int(11),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

ALTER TABLE user_details
ADD `resource_id` int(11),
ADD foreign key(resource_id) references resource(id);

CREATE TABLE `money_transactions` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_details_id` int(11),
  `amount` int(11) default 0,
  `username` varchar(50) NOT NULL ,
  `transaction_date` datetime,
  `info` varchar(50) ,
  `credits_deposited` int(11) ,
  `current_plan_surcharge` int(11),
  PRIMARY KEY (`id`),
  foreign key(user_details_id) references user_details(id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;