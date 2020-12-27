# mybatis-study
Mybatis学习项目

<br>

**数据库环境**

MySQL 8.0.18

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



**多表查询的数据表**

```sql

```

