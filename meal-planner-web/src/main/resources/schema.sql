drop schema public cascade ;

create table users (
	id int not null primary key,
	
	email VARCHAR(255),
	
	pwSalt VARCHAR(255),
	psHashCode VARCHAR(255),
	
	externalType varchar(255),
	externalId varchar(255)
) ;
