drop database if exists norwaylife;

create database norwaylife;

use norwaylife;

drop table if exists photo_path;

create table photo_path (
  id int not null auto_increment comment 'id',
  file_name varchar(20) not null comment 'photo的名称',
  file_path varchar(50) not null comment 'photo的完整相对路径',
  file_size bigint not null comment 'photo的文件大小',
  insert_time timestamp(3) default current_timestamp(3) not null comment '记录插入时间',
  update_time timestamp(3) default current_timestamp(3) on update current_timestamp(3) not null comment '记录更新时间',
  primary key (id),
  unique (file_path)
)