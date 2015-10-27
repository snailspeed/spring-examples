CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `birthDay` date NOT NULL,
  `firstName` varchar(32) NOT NULL,
  `male` bit(1) NOT NULL,
  `name` varchar(32) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1;

INSERT INTO `users` (`id`, `birthDay`, `firstName`, `male`, `name`) VALUES
(1, '1955-10-28', 'Bill', '1', 'Gates');