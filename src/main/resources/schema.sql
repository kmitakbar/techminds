DROP TABLE IF EXISTS `sql12309742`.`account_payables`;
CREATE TABLE  `sql12309742`.`account_payables` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `account_number` varchar(45) NOT NULL DEFAULT '',
  `buyer_id` varchar(45) NOT NULL DEFAULT '',
  `purchase_date` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `amount` double NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `sql12309742`.`account_receivable`;
CREATE TABLE  `sql12309742`.`account_receivable` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `account_number` varchar(45) NOT NULL DEFAULT '',
  `seller_id` varchar(45) NOT NULL DEFAULT '',
  `sold_date` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `amount` double unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=latin1;