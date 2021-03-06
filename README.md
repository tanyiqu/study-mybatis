# MyBatis学习项目
**官方文档：** https://mybatis.org/mybatis-3/zh/

<br>

**数据库环境**

MySQL 8.0.18

<br>

**单表CRUD的数据表**

```sql
create database mybatis;

use mybatis;

create table `user`(
	`id` int(20) primary key,
    `name` varchar(30) default null,
    `pwd` varchar(30) default null
) engine=InnoDB default charset=utf8;

insert into user(id,name,pwd) values
(1,'张一','111111'),
(2,'张二','222222'),
(3,'张三','333333')

select * from user;
```

<br>

**多表查询的数据表**

```sql
create table teacher(
	id int primary key auto_increment,
    name nvarchar(20)
) engine=InnoDB default charset=utf8;

insert into teacher values(1,'李一');
insert into teacher values(2,'李二');

create table student(
	id int primary key auto_increment,
    name nvarchar(20),
    tid int
) engine=InnoDB default charset=utf8;

insert into student values(1,'张一',1);
insert into student values(2,'张二',2);
insert into student values(3,'张三',2);
insert into student values(4,'张四',1);
```

<br>

**动态SQL中使用的数据表**

```sql
create table blog(
	id varchar(50) primary key,
	title varchar(100) not null ,
	author varchar(30) not null,
	create_time datetime not null,
	views int(30) not null
) engine=InnoDB default charset=utf8;
```

<br>