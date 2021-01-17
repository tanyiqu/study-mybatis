## 步骤

- 准备数据库
- 创建springboot项目
- 导入依赖
- 配置数据源
- 编写实体类
- 编写Mapper
- 编写Mapper配置文件
- 配置整合文件
- 测试

<br>

## 数据库环境

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

## 创建项目

使用Spring Initializr创建项目，勾选**MySQL驱动**和**JDBC API**，如果忘记勾选可以添加下面的依赖

然后添加**mybatis-spring-boot-starter**依赖

也可以直接复制下面所有的依赖，总共就是下面这么多

```xml
<dependencies>
    <!-- mybatis-springboot -->
    <dependency>
        <groupId>org.mybatis.spring.boot</groupId>
        <artifactId>mybatis-spring-boot-starter</artifactId>
        <version>2.1.4</version>
    </dependency>

    <!-- 忘记勾选的话，添加从这个往下的依赖 -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-jdbc</artifactId>
    </dependency>

    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <scope>runtime</scope>
    </dependency>

    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>
</dependencies>
```

<br>

## 配置数据源

这里使用yml的配置文件

```yml
# 数据源
spring:
  datasource:
    username: root
    password: mysql
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://127.0.0.1:3306/mybatis?serverTimezone=UTC
```

<br>

## 编写实体类

User.java

```java
package love.tanyiqu.pojo;

public class User {
    private int id;
    private String name;
    private String pwd;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
```

<br>

## 编写Mapper

UserMapper.java

```java
package love.tanyiqu.mapper;

import love.tanyiqu.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    List<User> getUsers();
}
```

<br>

## 编写Mapper配置文件

在resources文件夹下面，创建mybatis文件夹，在创建mappers文件夹

在mappers文件夹里面创建mapper.xml文件

UserMapper.xml

```xml
<?xml version="1.0"  encoding="UTF8"?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<!--suppress SqlNoDataSourceInspection, SqlDialectInspection -->
<mapper namespace="love.tanyiqu.mapper.UserMapper">
    <select id="getUsers" resultType="user">
        select * from user
    </select>
</mapper>
```

<br>

## 配置整合文件

在application.yml添加下面配置

```yml
# 整合mybatis
mybatis:
  type-aliases-package: love.tanyiqu.pojo
  mapper-locations: classpath:mybatis/mappers/*.xml
```

<br>

## 测试

测试类

```java
@SpringBootTest
class MybatisSpringbootApplicationTests {

	@Autowired
	UserMapper userMapper;

	@Test
	void contextLoads() {
		List<User> users = userMapper.getUsers();

		for (User user : users) {
			System.out.println(user);
		}
	}

}
```

