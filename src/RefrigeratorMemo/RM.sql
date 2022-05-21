create table RmHw(
	idx int not null auto_increment,
	mid varchar(20) not null,
	pwd varchar(20) not null,
	HwName varchar(20) not null,
	age int default 20,
	primary key(idx)
);

insert into RmHw values (default,'hkd123','1234','홍길동',21);
drop table RM;
select *  from RmHw;

create table RM(
	idx int not null auto_increment,
	name varchar(20) not null,
	putdate datetime,
	position varchar(20) not null,
	num int default 20,
	kind varchar(20) not null,
	memo varchar(50) not null,
	primary key(idx)
);

desc RM;
insert into RM values (default,'앞다리살','2021-10-01','냉장실',1,'육류','한돈앞다리살');
select * from RM;
select * from RM where putdate > now();

create table Recipe(
	idx int not null auto_increment,
	name varchar(20) not null,
	link varchar(100) not null,
	memo varchar(100) not null,
	primary key(idx)
);

drop table Recipe;
insert into Recipe values (default,'순두부찌개','https://www.youtube.com/watch?v=epIQdnRap1Y&list=PLG-A3oEQGr1jq2qUOfU2Epi4MIDmnokRz','계란,호두,밀가루');
select * from Recipe;
