
create user 'prospring5'@'%' identified WITH mysql_native_password  by 'prospring5';

grant all PRIVILEGES on musicdb.* to 'prospring5'@'%';
flush privileges;


create TABLE singer (
id int not null auto_increment,
first_name VARCHAR(60) not null,
last_name VARCHAR(40) not null,
birth_date date,
unique uq_singer_1 (first_name, last_name),
primary key(id)
);

create TABLE album (
id int not null auto_increment,
singer_id int not null,
title VARCHAR(100) not null,
release_date date,
unique uq_singer_album_1 (singer_id, title),
primary key(id),
constraint fk_album foreign key (singer_id) references singer(id)
);

create TABLE instrument (
instrument_id VARCHAR(20) not null,
primary key(instrument_id)
);

create TABLE singer_instrument (
singer_id int not null,
instrument_id VARCHAR(20) not null,
primary key(singer_id, instrument_id),
constraint fk_singer_instrument_1 foreign key (singer_id) references singer(id) on delete cascade,
constraint fk_singer_instrument_2 foreign key (instrument_id) references instrument(instrument_id)
);



#创建存储函数
DROP FUNCTION IF EXISTS getfirstnamebyid;
DELIMITER $$
CREATE FUNCTION getfirstnamebyid (in_id int)
RETURNS VARCHAR(60)
DETERMINISTIC
BEGIN
	#Routine body goes here...
	DECLARE out_first_name varchar(60);
	SELECT first_name INTO out_first_name from singer WHERE `id` = in_id;
	RETURN (out_first_name);
END
$$
DELIMITER ;
