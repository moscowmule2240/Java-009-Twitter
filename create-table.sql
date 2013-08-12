delimiter $$

drop table favorites$$
drop table directs$$
drop table follows$$
drop table tweets$$
drop table users$$

CREATE TABLE `users` (
  `userid` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(128) NOT NULL,
  `password` varchar(128) NOT NULL,
  `displayname` varchar(128) NOT NULL,
  `introduction` varchar(2048) DEFAULT NULL,
  PRIMARY KEY (`userid`),
  UNIQUE KEY `usersunique01` (`username`),
  KEY `usersindex01` (`username`(20))
)$$

CREATE TABLE `tweets` (
  `tweetid` bigint(20) NOT NULL AUTO_INCREMENT,
  `userid` bigint(20) NOT NULL,
  `tweettime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `tweet` varchar(256) NOT NULL,
  PRIMARY KEY (`tweetid`),
  KEY `tweetsforeign01` (`userid`),
  KEY `tweetsindex01` (`userid`,`tweettime`),
  CONSTRAINT `tweetsforeign01` FOREIGN KEY (`userid`) REFERENCES `users` (`userid`) ON DELETE CASCADE ON UPDATE CASCADE
)$$

CREATE TABLE `follows` (
  `userid` bigint(20) NOT NULL,
  `useridfollow` bigint(20) NOT NULL,
  `registrationtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`userid`,`useridfollow`),
  KEY `followsforeign01` (`userid`),
  KEY `followsforeign02` (`useridfollow`),
  CONSTRAINT `followsforeign01` FOREIGN KEY (`userid`) REFERENCES `users` (`userid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `followsforeign02` FOREIGN KEY (`useridfollow`) REFERENCES `users` (`userid`) ON DELETE CASCADE ON UPDATE CASCADE
)$$

CREATE TABLE `favorites` (
  `userid` bigint(20) NOT NULL,
  `tweetid` bigint(20) NOT NULL,
  PRIMARY KEY (`userid`,`tweetid`),
  KEY `favoritesforeign01` (`userid`),
  KEY `favoritesforeign02` (`tweetid`),
  CONSTRAINT `favoritesforeign01` FOREIGN KEY (`userid`) REFERENCES `users` (`userid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `favoritesforeign02` FOREIGN KEY (`tweetid`) REFERENCES `tweets` (`tweetid`) ON DELETE CASCADE ON UPDATE CASCADE
)$$

CREATE TABLE `directs` (
  `messageid` bigint(20) NOT NULL AUTO_INCREMENT,
  `userid` bigint(20) NOT NULL,
  `useridreceiver` bigint(20) NOT NULL,
  `messagetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `message` varchar(256) NOT NULL,
  PRIMARY KEY (`messageid`),
  KEY `directsindex01` (`userid`,`useridreceiver`,`messagetime`),
  KEY `directsforeign01` (`userid`,`useridreceiver`),
  CONSTRAINT `directsforeign01` FOREIGN KEY (`userid`, `useridreceiver`) REFERENCES `follows` (`useridfollow`, `userid`) ON DELETE CASCADE ON UPDATE CASCADE
)$$
