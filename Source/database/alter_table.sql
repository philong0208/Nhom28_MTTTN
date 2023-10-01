set search_path to laptrinhjavaweb;

ALTER TABLE post ADD COLUMN hostpostnumber INT;
ALTER TABLE post ADD COLUMN slideconfigurationnumber INT;
ALTER TABLE post ADD COLUMN menuconfigurationnumber INT;
ALTER TABLE post ADD COLUMN blogconfiguration VARCHAR;

ALTER TABLE category ADD COLUMN title TEXT;
ALTER TABLE category ADD COLUMN content TEXT;
ALTER TABLE category ADD COLUMN description TEXT;

ALTER TABLE post ADD COLUMN tomails TEXT;




