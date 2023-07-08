INSERT INTO public.employees (id,last_name,first_name,email,avatar,job_title,department,manager_id,phone,address1,address2,city,state,postal_code,country) VALUES
	 (204,'Alvarez','Laura','lalvarez3@time.com','https://robohash.org/nobisplaceatquisquam.jpg?size=50x50&set=set1','Computer Systems Analyst II','Health',NULL,'1-(518)328-2658','647 Lakeland Road',NULL,'Albany','New York','12210','United States'),
	 (215,'Gilbert','Jessica','jgilberte@infoseek.co.jp','https://robohash.org/providentaccusamussed.bmp?size=50x50&set=set1','Account Executive','Baby',NULL,'1-(320)607-0289','32 Summit Park',NULL,'Saint Cloud','Minnesota','56372','United States'),
	 (218,'Jenkins','Frances','fjenkinsh@huffingtonpost.com','https://robohash.org/voluptatemnamaliquam.bmp?size=50x50&set=set1','Developer IV','Baby',NULL,'1-(512)764-3809','69255 Dakota Plaza',NULL,'Austin','Texas','78769','United States');

INSERT INTO public.customers (id,last_name,first_name,email,company,phone,address1,address2,city,state,postal_code,country) VALUES
	 (10,'Owens','Tina','towens9@earthlink.net','Blogtag','1-(712)989-9002','59039 Sachtjen Street',NULL,'Sioux City','Iowa','51105','United States'),
	 (40,'Sanchez','Sean','ssanchez13@bandcamp.com','Chatterpoint','1-(316)535-7647','10 Stuart Road',NULL,'Wichita','Kansas','67260','United States'),
	 (54,'Mitchell','Lisa','lmitchell1h@live.com','Trudoo','1-(225)794-6979','17242 Eagan Terrace',NULL,'Baton Rouge','Louisiana','70820','United States'),
	 (69,'Willis','Robert','rwillis1w@si.edu','Tazz','1-(678)738-3382','0998 Bellgrove Circle',NULL,'Duluth','United Kingdom','30195','United States'),
	 (95,'Carter','Alan','acarter2m@simplemachines.org','Centizu','1-(952)234-1678','043 Sunnyside Center',NULL,'Young America','Minnesota','55551','United States');

INSERT INTO public.orders (id,employee_id,customer_id,order_date,shipped_date,ship_name,ship_address1,ship_address2,ship_city,ship_state,ship_postal_code,ship_country,shipping_fee,payment_type,paid_date,order_status) VALUES
	 (4001,204,40,'2016-04-05 00:00:00.000','2016-11-06 00:00:00.000','Jean Fuller','93 Spohn Place',NULL,'Manggekompo',NULL,NULL,'Indonesia',8.1400,'Card','2016-10-12 00:00:00.000','On Hold'),
	 (4002,204,95,'2017-01-29 00:00:00.000','2016-05-28 00:00:00.000','Diane Holmes','46 Eliot Trail',NULL,'Virginia Beach','Virginia','23459','United States',1.5500,'Check','2016-06-27 00:00:00.000','Complete'),
	 (4003,218,54,'2016-08-19 00:00:00.000','2016-12-08 00:00:00.000','Jerry Frazier','23 Sundown Junction',NULL,'Obodivka',NULL,NULL,'Ukraine',2.2900,'Cash','2016-09-27 00:00:00.000','On Hold'),
	 (4004,204,69,'2016-09-25 00:00:00.000','2016-12-24 00:00:00.000','Denise Freeman','4909 Beilfuss Hill',NULL,'Nova Venécia',NULL,'29830-000','Brazil',4.7700,'Check','2016-07-04 00:00:00.000','New'),
	 (4005,215,10,'2017-03-14 00:00:00.000','2016-03-19 00:00:00.000','Jonathan Gordon','7 Ludington Court',NULL,'Sukamaju',NULL,NULL,'Indonesia',8.7800,'Check','2016-03-22 00:00:00.000','On Hold');

INSERT INTO public.order_items (order_id,product_id,quantity,unit_price,discount,order_item_status,date_allocated) VALUES
	 (4001,608,1.0000,97.3400,8.7300,'Allocated','2017-01-15 00:00:00.000'),
	 (4001,611,2.0000,58.4600,4.3600,'No Stock','2016-09-21 00:00:00.000'),
	 (4001,616,2.0000,58.4600,4.3600,'No Stock','2016-09-21 00:00:00.000'),
	 (4001,613,2.0000,58.4600,4.3600,'No Stock','2016-09-21 00:00:00.000'),
	 (4001,615,2.0000,58.4600,4.3600,'No Stock','2016-09-21 00:00:00.000'),
	 (4002,604,3.0000,88.9700,2.8600,'On Order','2016-12-15 00:00:00.000'),
	 (4002,610,4.0000,37.1900,8.6500,'Allocated','2016-10-12 00:00:00.000'),
	 (4002,615,4.0000,37.1900,8.6500,'Allocated','2016-10-12 00:00:00.000'),
	 (4003,609,8.0000,92.8700,4.0100,'No Stock','2016-06-15 00:00:00.000'),
	 (4003,612,7.0000,87.1500,3.5400,'No Stock','2017-02-09 00:00:00.000');

INSERT INTO public.order_items (order_id,product_id,quantity,unit_price,discount,order_item_status,date_allocated) VALUES
	 (4004,616,1.0000,10.0000,1.0000,'On Order','2016-12-14 00:00:00.000'),
	 (4004,620,2.0000,10.0000,1.0000,'On Order','2016-12-14 00:00:00.000'),
	 (4004,611,4.0000,10.0000,1.0000,'On Order','2016-12-14 00:00:00.000'),
	 (4004,612,1.0000,10.0000,1.0000,'On Order','2016-12-14 00:00:00.000'),
	 (4005,618,1.0000,10.0000,1.0000,'No Stock','2016-12-14 00:00:00.000'),
	 (4005,619,1.0000,10.0000,1.0000,'No Stock','2016-12-14 00:00:00.000'),
	 (4005,620,2.0000,10.0000,1.0000,'No Stock','2016-12-14 00:00:00.000');
