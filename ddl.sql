drop database if exists enjoytrip;

create database enjoytrip character
    set utf8mb4 collate utf8mb4_general_ci;

use enjoytrip;

create table user
(
    id       bigint       not null primary key auto_increment,
    user_id  varchar(255) not null unique key,
    password varchar(255) not null,
    email    varchar(255) not null,
    nickname varchar(255) not null,
    role     varchar(255) not null default 'USER'
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;

CREATE TABLE post
(
    id         bigint       not null primary key auto_increment,
    title      varchar(255) not null,
    content    text         not null,
    hits       int          not null default 0,
    is_notice  tinyint      not null default 0,
    user_id    bigint,
    created_at datetime     not null default now()
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;

CREATE TABLE hotplace
(
    id         bigint       not null primary key auto_increment,
    title      varchar(255) not null,
    content    text         not null,
    created_at datetime     not null default now(),
    user_id    bigint,
    latitude   varchar(255) not null,
    longitude  varchar(255) not null,
    place_type int          not null,
    date       date         not null
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;

CREATE TABLE like_post
(
    id         bigint   not null primary key auto_increment,
    post_id    bigint   not null,
    user_id    bigint,
    created_at datetime not null default now()
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;

ALTER TABLE post
    ADD CONSTRAINT post_user_id_fk
        FOREIGN KEY (user_id)
            REFERENCES user (id) ON UPDATE CASCADE ON DELETE SET NULL;

ALTER TABLE hotplace
    ADD CONSTRAINT hotplace_user_id_fk
        FOREIGN KEY (user_id)
            REFERENCES user (id) ON UPDATE CASCADE ON DELETE SET NULL;

ALTER TABLE like_post
    ADD CONSTRAINT like_post_post_id_fk
        FOREIGN KEY (post_id)
            REFERENCES post (id) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE like_post
    ADD CONSTRAINT like_post_user_id_fk
        FOREIGN KEY (user_id)
            REFERENCES user (id) ON UPDATE CASCADE ON DELETE SET NULL;


