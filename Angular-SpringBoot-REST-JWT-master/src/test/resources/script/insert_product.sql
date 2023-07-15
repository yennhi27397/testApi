INSERT INTO public.products (id,product_code,product_name,description,standard_cost,list_price,target_level,reorder_level,minimum_reorder_quantity,quantity_per_unit,discontinued,category) VALUES
	 (601,'P1','Nikon D810',NULL,1167.0900,1123.3900,75,10,10,'50',1,'Camera'),
	 (602,'P2','Canon EOS 5D Mark IV',NULL,1382.8300,1293.8400,90,15,15,'56',0,'Camera'),
	 (603,'P3','Dell XPS 13',NULL,1482.8300,1393.8400,95,20,30,'56',0,'Laptop'),
	 (604,'P4','iPad Air',NULL,382.8300,293.8400,180,75,50,'56',0,'Tablet'),
	 (605,'P5','Acer Aspire S 13',NULL,882.8300,793.8400,40,15,15,'56',0,'Laptop'),
	 (606,'P6','Nexus 6',NULL,633.8800,511.7000,75,10,20,'79',1,'Phone'),
	 (607,'P7','ThinkPad T365',NULL,1441.0200,1308.9800,100,30,10,'92',1,'Laptop'),
	 (608,'P8','Moto Z',NULL,538.4400,462.3400,75,20,20,'54',1,'Phone'),
	 (609,'P9','HTC 10',NULL,547.5800,481.8300,50,5,15,'58',1,'Tablet'),
	 (610,'P10','MacBook Pro 13.3',NULL,1625.8100,1576.6100,120,40,30,'11',1,'Laptop');
INSERT INTO public.products (id,product_code,product_name,description,standard_cost,list_price,target_level,reorder_level,minimum_reorder_quantity,quantity_per_unit,discontinued,category) VALUES
	 (611,'P11','Nikon D500',NULL,867.0900,723.3900,75,25,15,'50',1,'Camera'),
	 (612,'P12','Pentax K-1',NULL,882.8300,793.8400,50,10,5,'56',0,'Camera'),
	 (613,'P13','Asus Zenbook Ux305',NULL,1182.8300,1093.8400,55,10,5,'56',0,'Laptop'),
	 (614,'P14','HP Envy m7-n109dx 17.3',NULL,1382.8300,1293.8400,50,10,10,'56',0,'Laptop'),
	 (615,'P15','Microsft Surface Book',NULL,1682.8300,1593.8400,200,80,50,'56',0,'Tablet'),
	 (616,'P16','Apple iPhone 7',NULL,833.8800,711.7600,250,100,50,'79',1,'Phone'),
	 (617,'P17','Google Pixel',NULL,641.0200,608.9800,100,30,20,'92',1,'Phone'),
	 (618,'P18','Samsung Galaxy S7',NULL,538.4400,562.3400,75,15,10,'54',1,'Phone'),
	 (619,'P19','Samasung Note',NULL,547.5800,481.8300,75,15,15,'58',1,'Tablet'),
	 (620,'P20','Chromebook 11.6',NULL,1078.8100,1008.6100,80,14,10,'11',1,'Laptop');



INSERT INTO public.orders (id,employee_id,customer_id,order_date,shipped_date,ship_name,ship_address1,ship_address2,ship_city,ship_state,ship_postal_code,ship_country,shipping_fee,payment_type,paid_date,order_status) VALUES
	 (4001,204,40,'2016-04-05 00:00:00.000','2016-11-06 00:00:00.000','Jean Fuller','93 Spohn Place',NULL,'Manggekompo',NULL,NULL,'Indonesia',8.1400,'Card','2016-10-12 00:00:00.000','On Hold'),
	 (4002,204,95,'2017-01-29 00:00:00.000','2016-05-28 00:00:00.000','Diane Holmes','46 Eliot Trail',NULL,'Virginia Beach','Virginia','23459','United States',1.5500,'Check','2016-06-27 00:00:00.000','Shipped'),
	 (4003,218,54,'2016-08-19 00:00:00.000','2016-12-08 00:00:00.000','Jerry Frazier','23 Sundown Junction',NULL,'Obodivka',NULL,NULL,'Ukraine',2.2900,'Cash','2016-09-27 00:00:00.000','On Hold'),
	 (4004,204,69,'2016-09-25 00:00:00.000','2016-12-24 00:00:00.000','Denise Freeman','4909 Beilfuss Hill',NULL,'Nova Venécia',NULL,'29830-000','Brazil',4.7700,'Check','2016-07-04 00:00:00.000','New'),
	 (4005,215,10,'2017-03-14 00:00:00.000','2016-03-19 00:00:00.000','Jonathan Gordon','7 Ludington Court',NULL,'Sukamaju',NULL,NULL,'Indonesia',8.7800,'Check','2016-03-22 00:00:00.000','On Hold'),
	 (4006,211,23,'2016-08-14 00:00:00.000','2016-12-05 00:00:00.000','Sean Carter','859 Dahle Plaza',NULL,'Dayou',NULL,NULL,'China',9.4300,'Cash','2016-08-21 00:00:00.000','New'),
	 (4007,204,92,'2017-01-02 00:00:00.000','2016-07-09 00:00:00.000','Alice Warren','5 Fuller Center',NULL,'Log pri Brezovici',NULL,'1358','India',3.2500,'Cash','2016-03-24 00:00:00.000','Shipped'),
	 (4008,205,20,'2016-05-15 00:00:00.000','2016-09-12 00:00:00.000','Andrea Hamilton','99 Blue Bill Park Junction',NULL,'Liangshui',NULL,NULL,'China',7.0400,'Check','2016-09-02 00:00:00.000','On Hold'),
	 (4009,219,58,'2016-11-27 00:00:00.000','2017-03-02 00:00:00.000','Wanda Hill','907 Sundown Court',NULL,'Pedra Azul',NULL,'39970-000','Brazil',4.3500,'Cash','2016-09-27 00:00:00.000','On Hold'),
	 (4010,218,57,'2016-09-11 00:00:00.000','2017-02-26 00:00:00.000','Carolyn Foster','0 Charing Cross Court',NULL,'Chicago','Illinois','60609','United States',1.2300,'Cash','2016-08-09 00:00:00.000','Complete');
INSERT INTO public.orders (id,employee_id,customer_id,order_date,shipped_date,ship_name,ship_address1,ship_address2,ship_city,ship_state,ship_postal_code,ship_country,shipping_fee,payment_type,paid_date,order_status) VALUES
	 (4011,207,3,'2017-03-01 00:00:00.000','2016-08-04 00:00:00.000','Timothy Warren','19 John Wall Parkway',NULL,'Lyon','Rhône-Alpes','69362 CEDEX 07','France',9.5700,'Card','2016-05-08 00:00:00.000','Complete'),
	 (4012,210,59,'2016-12-31 00:00:00.000','2016-08-08 00:00:00.000','Kathleen Marshall','2 Swallow Circle',NULL,'Cunliji',NULL,NULL,'China',9.0300,'Cash','2016-04-23 00:00:00.000','On Hold'),
	 (4013,204,57,'2017-01-11 00:00:00.000','2017-02-13 00:00:00.000','Jane Ortiz','1136 Kedzie Alley',NULL,'Eirado','Viana do Castelo','4990-540','Portugal',8.9000,'Check','2016-10-26 00:00:00.000','Shipped'),
	 (4014,212,26,'2016-09-23 00:00:00.000','2016-05-13 00:00:00.000','Carolyn Martinez','954 Kropf Court',NULL,'Ibitinga',NULL,'14940-000','Brazil',4.5700,'Card','2016-09-11 00:00:00.000','New'),
	 (4015,201,86,'2016-11-04 00:00:00.000','2016-10-03 00:00:00.000','Debra Willis','89 Grasskamp Road',NULL,'San Francisco',NULL,'8501','Philippines',3.5300,'Card','2016-10-05 00:00:00.000','New'),
	 (4016,208,17,'2016-04-17 00:00:00.000','2016-03-22 00:00:00.000','Sharon Little','27501 Sommers Junction',NULL,'San Juan Opico',NULL,NULL,'India',6.8700,'Card','2017-01-08 00:00:00.000','Complete'),
	 (4017,205,73,'2016-07-03 00:00:00.000','2016-09-26 00:00:00.000','Nancy Hughes','1 John Wall Avenue',NULL,'La Libertad',NULL,NULL,'Argentina',4.6700,'Check','2017-02-01 00:00:00.000','New'),
	 (4018,213,16,'2016-12-01 00:00:00.000','2016-06-08 00:00:00.000','Sara Knight','98248 Tony Pass',NULL,'Val-d''Or','Québec','J9P','Canada',9.5200,'Card','2016-08-06 00:00:00.000','New'),
	 (4019,209,10,'2016-04-18 00:00:00.000','2016-04-25 00:00:00.000','Russell Wood','3 Commercial Point',NULL,'Rokietnica',NULL,'62-090','Poland',6.8000,'Card','2017-01-20 00:00:00.000','On Hold'),
	 (4020,216,1,'2016-07-23 00:00:00.000','2017-02-23 00:00:00.000','Aaron Grant','15477 Farwell Circle',NULL,'Yongyang',NULL,NULL,'China',3.1700,'Cash','2016-08-11 00:00:00.000','Complete');


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
	 (4005,620,2.0000,10.0000,1.0000,'No Stock','2016-12-14 00:00:00.000'),
	 (4006,617,1.0000,10.0000,1.0000,'No Stock','2016-12-14 00:00:00.000'),
	 (4006,618,2.0000,10.0000,1.0000,'No Stock','2016-12-14 00:00:00.000'),
	 (4006,607,1.0000,10.0000,1.0000,'No Stock','2016-12-14 00:00:00.000');
INSERT INTO public.order_items (order_id,product_id,quantity,unit_price,discount,order_item_status,date_allocated) VALUES
	 (4007,617,1.0000,10.0000,1.0000,'Allocated','2016-12-14 00:00:00.000'),
	 (4007,610,2.0000,10.0000,1.0000,'Allocated','2016-12-14 00:00:00.000'),
	 (4007,612,5.0000,10.0000,1.0000,'Allocated','2016-12-14 00:00:00.000'),
	 (4008,612,1.0000,57.2000,8.9400,'Allocated','2017-01-13 00:00:00.000'),
	 (4008,615,3.0000,57.2000,8.9400,'Allocated','2017-01-13 00:00:00.000'),
	 (4008,611,1.0000,57.2000,8.9400,'Allocated','2017-01-13 00:00:00.000'),
	 (4009,605,6.0000,62.1600,5.6800,'No Stock','2017-02-13 00:00:00.000'),
	 (4009,610,6.0000,19.3100,5.0000,'No Stock','2016-09-16 00:00:00.000'),
	 (4009,615,9.0000,51.2100,4.4800,'Allocated','2016-10-18 00:00:00.000'),
	 (4010,601,1.0000,32.1800,9.4100,'On Order','2016-03-17 00:00:00.000');
INSERT INTO public.order_items (order_id,product_id,quantity,unit_price,discount,order_item_status,date_allocated) VALUES
	 (4010,602,1.0000,31.3500,7.1800,'No Stock','2016-12-30 00:00:00.000'),
	 (4010,603,10.0000,24.2400,2.7600,'Allocated','2016-07-05 00:00:00.000'),
	 (4010,610,6.0000,9.0900,3.0200,'On Order','2016-07-17 00:00:00.000'),
	 (4011,604,10.0000,58.2500,9.3000,'No Stock','2016-04-04 00:00:00.000'),
	 (4011,606,5.0000,73.3400,1.7600,'Allocated','2016-06-30 00:00:00.000'),
	 (4011,608,3.0000,95.0700,4.6000,'On Order','2016-06-04 00:00:00.000'),
	 (4011,615,9.0000,20.8400,3.9300,'Allocated','2016-06-10 00:00:00.000'),
	 (4012,604,5.0000,19.8200,9.9700,'No Stock','2016-09-21 00:00:00.000'),
	 (4012,601,3.0000,19.8200,9.9700,'No Stock','2016-09-21 00:00:00.000'),
	 (4012,610,3.0000,19.8200,9.9700,'No Stock','2016-09-21 00:00:00.000');
INSERT INTO public.order_items (order_id,product_id,quantity,unit_price,discount,order_item_status,date_allocated) VALUES
	 (4013,614,1.0000,10.0000,1.0000,'No Stock','2016-12-14 00:00:00.000'),
	 (4013,604,2.0000,19.8200,9.9700,'No Stock','2016-09-21 00:00:00.000'),
	 (4013,606,5.0000,19.8200,9.9700,'No Stock','2016-09-21 00:00:00.000'),
	 (4014,601,3.0000,37.5700,4.9900,'Allocated','2016-08-21 00:00:00.000'),
	 (4015,611,8.0000,95.2700,6.6200,'Allocated','2017-03-13 00:00:00.000'),
	 (4015,612,2.0000,89.6300,4.1400,'Allocated','2016-04-07 00:00:00.000'),
	 (4015,615,8.0000,69.0300,1.1100,'On Order','2016-08-15 00:00:00.000'),
	 (4016,616,1.0000,10.0000,1.0000,'On Order','2016-12-14 00:00:00.000'),
	 (4016,611,1.0000,10.0000,1.0000,'On Order','2016-12-14 00:00:00.000'),
	 (4016,612,1.0000,10.0000,1.0000,'On Order','2016-12-14 00:00:00.000');
INSERT INTO public.order_items (order_id,product_id,quantity,unit_price,discount,order_item_status,date_allocated) VALUES
	 (4017,605,6.0000,75.8800,2.1000,'On Order','2017-02-15 00:00:00.000'),
	 (4017,610,4.0000,26.4300,7.1800,'On Order','2016-04-30 00:00:00.000'),
	 (4017,619,6.0000,77.9100,9.2600,'No Stock','2016-04-02 00:00:00.000'),
	 (4018,615,1.0000,10.0000,1.0000,'On Order','2016-12-14 00:00:00.000'),
	 (4019,615,1.0000,10.0000,1.0000,'No Stock','2016-12-14 00:00:00.000'),
	 (4020,614,1.0000,10.0000,1.0000,'Allocated','2016-12-14 00:00:00.000');
