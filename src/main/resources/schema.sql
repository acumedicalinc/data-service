drop table if exists users;
create table users(
	`id` bigint auto_increment,
	`username` varchar(255),
	`password` varchar(255),
	`enabled` boolean,
	PRIMARY KEY(`id`));
    
insert into users(`username`,`password`,`enabled`)
values('frank','cGFzc3dvcmQ=',true);

insert into users(`username`,`password`,`enabled`)
values('julia','cGFzc3dvcmQ=',true);

insert into users(`username`,`password`,`enabled`)
values('user','password',true);

drop table if exists authorities;
create table authorities(
	`id` bigint auto_increment, 
	`username`  varchar(255),
	`authority`  varchar(255), 
	UNIQUE(`username`,`authority`),
	PRIMARY KEY(`id`));
    
insert into authorities(`username`,`authority`)
values('julia','admin');
insert into authorities(`username`,`authority`)
values('frank','superadmin');
insert into authorities(`username`,`authority`)
values('user','USER');