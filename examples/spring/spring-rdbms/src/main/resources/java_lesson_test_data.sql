INSERT INTO `customer` (`id`, `first_name`, `last_name`, `mobile_number`, `email`, `accepts_newsletter`, `comment`) VALUES
(1, 'John', 'Doe', '5-555-5555-55', 'whoisjohndoe@gmail.com', 0, 'I am John Doe.'),
(2, 'Waldo', 'Neverknown', '12345654321', 'find@me.com', 1, 'Where is Waldo?');

INSERT INTO `product` (`id`, `long_name`, `short_name`, `category`, `net_price`, `vat`, `description`, `brand`, `is_chinese`) VALUES
(1, 'Edelweiss Hefetrüb', 'edelweiss1', 'beer', 280, '25', 'Edelweiss Hefetrüb 5.5% búzasör', 'Edelweiss', 0),
(2, 'Coronita Cerveza', 'coronita', 'beer', 380, '25', 'Coronita Cerveza 0,33l üveges', 'Coronita Cerveza', 0),
(3, 'Oremus édes Szamorodni 2007 Tokaj', 'szamorod1', 'wine', 2072, '25', 'Oremus édes Szamorodni 2007 Tokaj', 'Oremus', 1);

INSERT INTO `javacourse`.`address` (`id`, `customer_id`, `zip_code`, `city`, `street`, `house_number`, `phone_number`, `comment`) VALUES
(1, 1, '4026', 'Debrecen', 'Bethlen u.', '3-9.', '+36(52)999-485 #56324', 'EPAM');