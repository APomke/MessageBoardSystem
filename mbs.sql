/*
--部门表
部门id int(20) 主键自增
部门名称 varchar(20) 不为空
部门人数 int(20)
部门领导 varchar(20)
部门图片路径
*/

CREATE TABLE department (
    deptId INT(20) PRIMARY KEY AUTO_INCREMENT,
    deptName VARCHAR(20) NOT NULL,
    deptSize INT(20),
    deptLeader VARCHAR(20),
    deptImagePath VARCHAR(255)
);

/*
创建验证码表
*/

create table code (
    codeId int(255) AUTO_INCREMENT,
    code varchar(20),
    PRIMARY KEY (`codeId`)
);

/*
--用户表
用户id int(20) 主键自增
用户账号 varchar(255)
用户密码 varchar(255)
用户昵称 varchar(255)
用户角色 varchar(255)
用户部门id deptId int(20)
用户邮箱 varchar(255)
用户头像图片路径 varchar(255)
*/

CREATE TABLE `user` (
    `id` INT(20) NOT NULL AUTO_INCREMENT COMMENT '用户id',
    `account` VARCHAR(255) DEFAULT NULL COMMENT '用户账号',
    `password` VARCHAR(255) DEFAULT NULL COMMENT '用户密码',
    `nickname` VARCHAR(255) DEFAULT NULL COMMENT '用户昵称',
    `role` VARCHAR(255) DEFAULT NULL COMMENT '用户角色',
    `deptId` INT(20) DEFAULT NULL COMMENT '用户部门id',
    `email` VARCHAR(255) DEFAULT NULL COMMENT '用户邮箱',
    `avatarUrl` VARCHAR(255) DEFAULT NULL COMMENT '用户头像图片路径',
    PRIMARY KEY (`id`)
);


/*
--角色表
角色id int(20)
角色名称 varchar(20)
*/
CREATE TABLE `role` (
    `id` INT(20) NOT NULL,
    `name` VARCHAR(20) DEFAULT NULL,
    PRIMARY KEY (`id`)
);


/*
--留言表
留言id int(255) 主键自增
留言发布人id
留言主题 varchar(255)
留言内容 varchar(255)
留言点赞数 int(255)
留言类型id int(255)
留言评论数 int(255)
留言图片路径 varchar(255)
留言时间 varchar(255)
*/

CREATE TABLE message (
    id INT(255) NOT NULL AUTO_INCREMENT,
    masterId INT(255) NOT NULL,
    topic VARCHAR(255),
    content VARCHAR(255),
    likes INT(255) DEFAULT 0,
    typeId INT(255),
    comments INT(255) DEFAULT 0,
    imagePath VARCHAR(255),
    time VARCHAR (255),
    PRIMARY KEY (id)
);

/*
类型表
类型id 主键自增
类型名称 varchar(255)
*/
CREATE TABLE type (
    typeId INT(255) NOT NULL AUTO_INCREMENT,
    typeName VARCHAR(255) NOT NULL,
    PRIMARY KEY (typeId)
);

INSERT INTO type (typeName) VALUES ("生活");
INSERT INTO type (typeName) VALUES ("公务");
INSERT INTO type (typeName) VALUES ("通知");
INSERT INTO type (typeName) VALUES ("其它");

/*
-- 评论表
评论id int(255) 主键自增
评论留言id int(255)
评论用户 varchar(255)
评论内容 varchar(255)
评论级别 int(20)
评论时间 varchar(255)
*/

CREATE TABLE comments (
    commentId INT(255) PRIMARY KEY AUTO_INCREMENT,
    messageId INT(255),
    commentUserId INT(255),
    commentContent VARCHAR(255),
    commentLevel INT(20),
    commentTime VARCHAR(255)
);
