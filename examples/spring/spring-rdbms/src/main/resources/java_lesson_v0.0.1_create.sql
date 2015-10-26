SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

DROP SCHEMA IF EXISTS `javacourse` ;
CREATE SCHEMA IF NOT EXISTS `javacourse` DEFAULT CHARACTER SET utf8 COLLATE utf8_bin ;
USE `javacourse` ;

-- -----------------------------------------------------
-- Table `javacourse`.`customer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `javacourse`.`customer` ;

CREATE  TABLE IF NOT EXISTS `javacourse`.`customer` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `first_name` VARCHAR(45) NOT NULL ,
  `last_name` VARCHAR(45) NOT NULL ,
  `mobile_number` VARCHAR(20) NULL ,
  `email` VARCHAR(45) NULL ,
  `accepts_newsletter` TINYINT(1)  NULL DEFAULT false ,
  `comment` VARCHAR(1024) NULL ,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`)  )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `javacourse`.`address`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `javacourse`.`address` ;

CREATE  TABLE IF NOT EXISTS `javacourse`.`address` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `customer_id` INT NOT NULL ,
  `zip_code` VARCHAR(10) NOT NULL ,
  `city` VARCHAR(45) NOT NULL ,
  `street` VARCHAR(45) NOT NULL ,
  `house_number` VARCHAR(45) NOT NULL ,
  `phone_number` VARCHAR(45) NULL ,
  `comment` VARCHAR(1024) NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_address_customer` (`customer_id` ASC) ,
  CONSTRAINT `fk_address_customer`
    FOREIGN KEY (`customer_id` )
    REFERENCES `javacourse`.`customer` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `javacourse`.`product`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `javacourse`.`product` ;

CREATE  TABLE IF NOT EXISTS `javacourse`.`product` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `long_name` VARCHAR(45) NOT NULL ,
  `short_name` VARCHAR(10) NOT NULL ,
  `category` VARCHAR(20) NOT NULL ,
  `net_price` INT NOT NULL ,
  `vat` DECIMAL( 4, 2 ) NOT NULL ,
  `description` VARCHAR(1024) NULL ,
  `brand` VARCHAR(45) NULL ,
  `is_chinese` TINYINT(1)  NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `javacourse`.`order`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `javacourse`.`order` ;

CREATE  TABLE IF NOT EXISTS `javacourse`.`order` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `customer_id` INT NOT NULL ,
  `billing_address_id` INT NOT NULL ,
  `shipping_address_id` INT NOT NULL ,
  `created_at` DATETIME NOT NULL ,
  `packaged_at` DATETIME NULL ,
  `posted_at` DATETIME NULL ,
  `cancelled_at` DATETIME NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_order_customer` (`customer_id` ASC) ,
  INDEX `fk_order_billing_address` (`billing_address_id` ASC) ,
  INDEX `fk_order_shipping_address` (`shipping_address_id` ASC) ,
  CONSTRAINT `fk_order_customer`
    FOREIGN KEY (`customer_id` )
    REFERENCES `javacourse`.`customer` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_order_billing_address`
    FOREIGN KEY (`billing_address_id` )
    REFERENCES `javacourse`.`address` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_order_shipping_address`
    FOREIGN KEY (`shipping_address_id` )
    REFERENCES `javacourse`.`address` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `javacourse`.`order_item`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `javacourse`.`order_item` ;

CREATE  TABLE IF NOT EXISTS `javacourse`.`order_item` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `order_id` INT NOT NULL ,
  `product_id` INT NOT NULL ,
  `quantity` INT NOT NULL ,
  `gift_wrapping` TINYINT(1)  NOT NULL DEFAULT false ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_order_item_order` (`order_id` ASC) ,
  INDEX `fk_order_item_product` (`product_id` ASC) ,
  CONSTRAINT `fk_order_item_order`
    FOREIGN KEY (`order_id` )
    REFERENCES `javacourse`.`order` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_order_item_product`
    FOREIGN KEY (`product_id` )
    REFERENCES `javacourse`.`product` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
