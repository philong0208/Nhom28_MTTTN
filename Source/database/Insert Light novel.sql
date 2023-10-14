insert into role(code,name) values('ADMIN','Quản trị hệ thống');
insert into role(code,name) values('USER','người dùng');

insert into users(username,password,fullname,email,status)
values('phamvandong','$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG','Phạm Văn Đồng','lamjavadev456@gmail.com',1);
insert into users(username,password,fullname,email,status)
values('vovankiet','$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG','Võ Văn Kiệt','laptrinhjavaweb@gmail.com',1);

INSERT INTO user_role(user_id,role_id) VALUES (1,1);
INSERT INTO user_role(user_id,role_id) VALUES (2,2);

INSERT INTO "post" ("id", "createdby", "createddate", "modifiedby", "modifieddate", "altthumbnail", "blogconfiguration", "content", "content1", "content10", "content11", "content12", "content13", "content2", "content3", "content4", "content5", "content6", "content7", "content8", "content9", "hotpost", "menuconfiguration", "menuconfigurationnumber", "metadescription", "metakeywords", "ogdescription", "ogimage", "ogtitle", "ogurl", "redirecturl", "seourl", "shortdescription", "shorttitle", "shorturl", "slideconfiguration", "slideconfigurationnumber", "thumbnail", "title", "titlethumbnail", "tomails", "category_id", "approved") VALUES (38, 'phamvandong', '2019-07-29 00:00:00', 'truonglam', '2023-01-25 00:00:00', 'lập trình java core web học java core web học lập trình web với java core', '1553      1554', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '/post/banner-home.png', 'lập trình java web', NULL, NULL, 'trang-chu', NULL, 'Trang chủ', NULL, NULL, NULL, '/post/banner-home.png', 'lập trình java web học java web học lập trình web với java cơ bản miễn phí', 'lập trình java core web học java core web học lập trình web với java core', NULL, NULL, true);