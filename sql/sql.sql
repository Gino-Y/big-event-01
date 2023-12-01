-- 创建数据库
create database if not exists big_event;

-- 使用数据库
use big_event;

-- 创建用户表
create table if not exists user(
    id int unsigned primary key auto_increment comment 'ID',
    username varchar(20) not null unique comment '姓名',
    password varchar(32) not null comment '密码',
    nickname varchar(10) default '' comment '昵称',
    email varchar(128) default '' comment '邮箱',
    user_pic varchar(128) default '' comment '头像',
    create_time timestamp default current_timestamp comment '创建时间',
    update_time timestamp default current_timestamp on update current_timestamp comment '更新时间'
) comment '用户表';

-- 分类表
create table if not exists category(
    id int unsigned primary key auto_increment comment 'ID',
    category_name varchar(32) not null comment '分类名称',
    create_user int unsigned not null comment '创建人ID',
    create_time timestamp default current_timestamp comment '创建时间',
    update_time timestamp default current_timestamp on update current_timestamp comment '更新时间',
    foreign key (create_user) references user(id) -- 外键
) comment '分类表';

-- 文章表
create table if not exists article(
    id int unsigned primary key auto_increment comment 'ID',
    title varchar(30) not null comment '文章标题',
    content text not null comment '文章内容',
    cover_img varchar(128) not null comment '封面图片',
    state varchar(3) default '草稿' comment '文章状态, 只能是: [已发布]或着[草稿]',
    category_id int unsigned comment '文章分类ID',
    create_user int unsigned not null comment '创建人ID',
    create_time timestamp default current_timestamp comment '创建时间',
    update_time timestamp default current_timestamp on update current_timestamp comment '更新时间',
    foreign key (category_id) references category(id), -- 外键
    foreign key (create_user) references user(id) -- 外键
) comment '文章表';