#--execute as root user
CREATE DATABASE IF NOT EXISTS paypal;
GRANT ALL ON `paypal`.* to 'paypal_user' IDENTIFIED BY 'paypal';

USE paypal;


#{
#  "sdk_version":"v1.0.2",
#  "sdk_platform":"java",
#  "jre_version":"1.7.0_45",
#  "puppet_version":"3.3.2"
#}

CREATE TABLE IF NOT EXISTS `sdk` (
  `id` int NOT NULL AUTO_INCREMENT,
  `version` varchar(10) NOT NULL,
  `platform` varchar(25) NOT NULL,
  `description` varchar(50) NOT NULL,
  `dt_created` datetime DEFAULT NULL,
  `ts_updated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  INDEX sdk_version (version),
  INDEX sdk_platform (platform)
) ENGINE=MyISAM AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

#--create the table
CREATE TABLE IF NOT EXISTS `geo_location` (
  `id` int NOT NULL AUTO_INCREMENT,
  `code` varchar(10) NOT NULL,
  `name` varchar(25) NOT NULL,
  `description` varchar(50) NOT NULL,
  `sdk_id` INT UNSIGNED NOT NULL REFERENCES sdk(id),
  `dt_created` datetime DEFAULT NULL,
  `ts_updated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  INDEX code (code)
) ENGINE=MyISAM AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

#--create the table
CREATE TABLE IF NOT EXISTS `store` (
  `id` int NOT NULL AUTO_INCREMENT,
  `number` varchar(10) NOT NULL,
  `geo_location_id` INT UNSIGNED NOT NULL REFERENCES geo_location(id),
  `name` varchar(25) NOT NULL,
  `description` varchar(50) NOT NULL,
  `sdk_id` INT UNSIGNED NOT NULL REFERENCES sdk(id),
  `dt_created` datetime DEFAULT NULL,
  `ts_updated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  INDEX store_number_geo_location_id (number,geo_location_id),
  INDEX geo_location_id (geo_location_id)
) ENGINE=MyISAM AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;



#--recreate the trigger
DROP TRIGGER IF EXISTS trigger_set_store_dt_created;
CREATE TRIGGER trigger_set_store_dt_created
  BEFORE INSERT ON store
  FOR EACH ROW SET NEW.dt_created = NOW();

DROP TRIGGER IF EXISTS trigger_set_sdk_dt_created;
CREATE TRIGGER trigger_set_sdk_dt_created
  BEFORE INSERT ON sdk
  FOR EACH ROW SET NEW.dt_created = NOW();

DROP TRIGGER IF EXISTS trigger_set_geo_location_dt_created;
CREATE TRIGGER trigger_set_geo_location_dt_created
  BEFORE INSERT ON geo_location
  FOR EACH ROW SET NEW.dt_created = NOW();