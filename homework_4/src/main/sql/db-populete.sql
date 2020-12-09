-- room_types

INSERT INTO `hotel`.`room_types`
(`id`, `full_name`, `abbreviation_name`, `number_of_adults`, `number_of_children`)
VALUES (1, 'Single', 'SGL', '1', '0');
INSERT INTO `hotel`.`room_types`
(`id`,`full_name`, `abbreviation_name`, `number_of_adults`, `number_of_children`)
VALUES (2, 'Single + Child', 'SGL+CHD', '1', '1');
INSERT INTO `hotel`.`room_types`
(`id`,`full_name`, `abbreviation_name`, `number_of_adults`, `number_of_children`)
VALUES (3, 'Single + 2 Children', 'SGL+2 CHD', '1', '2');
INSERT INTO `hotel`.`room_types`
(`id`,`full_name`, `abbreviation_name`, `number_of_adults`, `number_of_children`)
VALUES (4, 'Double', 'DBL', '2', '0');
INSERT INTO `hotel`.`room_types`
(`id`,`full_name`, `abbreviation_name`, `number_of_adults`, `number_of_children`)
VALUES (5, 'Double twin', 'DBL TWN', '2', '0');
INSERT INTO `hotel`.`room_types`
(`id`,`full_name`, `abbreviation_name`, `number_of_adults`, `number_of_children`)
VALUES (6, 'Double + Extra Bed', 'DBL+EXB', '3', '0');
INSERT INTO `hotel`.`room_types`
(`id`,`full_name`, `abbreviation_name`, `number_of_adults`, `number_of_children`)
VALUES (7, 'Double + Child', 'DBL+CHD', '2', '1');
INSERT INTO `hotel`.`room_types`
(`id`,`full_name`, `abbreviation_name`, `number_of_adults`, `number_of_children`)
VALUES (8, 'Double + 2 Children', 'DBL+2 CHD', '2', '2');
INSERT INTO `hotel`.`room_types`
(`id`,`full_name`, `abbreviation_name`, `number_of_adults`, `number_of_children`)
VALUES (9, 'Double + Extra Bed + Child', 'DBL+EXB+CHD', '3', '1');
INSERT INTO `hotel`.`room_types`
(`id`,`full_name`, `abbreviation_name`, `number_of_adults`, `number_of_children`)
VALUES (10, 'Triple', 'TRPL', '3', '0');
INSERT INTO `hotel`.`room_types`
(`id`,`full_name`, `abbreviation_name`, `number_of_adults`, `number_of_children`)
VALUES (11, 'Triple + Child', 'TRPL+CHD', '3', '1');
INSERT INTO `hotel`.`room_types`
(`id`,`full_name`, `abbreviation_name`, `number_of_adults`, `number_of_children`)
VALUES (12, 'Triple + 2 Children', 'TRPL+2CHLD', '3', '2');

-- statuses

INSERT INTO `hotel`.`statuses` (`id`,`name`) VALUES (1, 'waiting for confirmation (unavailable)');
INSERT INTO `hotel`.`statuses` (`id`,`name`) VALUES (2, 'expired');
INSERT INTO `hotel`.`statuses` (`id`,`name`) VALUES (3, 'booked');
INSERT INTO `hotel`.`statuses` (`id`,`name`) VALUES (4, 'occupied');
INSERT INTO `hotel`.`statuses` (`id`,`name`) VALUES (5, 'completed');

-- roles

INSERT INTO `hotel`.`roles` (`id`, `name`) VALUES (1, 'user');
INSERT INTO `hotel`.`roles` (`id`, `name`) VALUES (2, 'admin');

-- positions

INSERT INTO `hotel`.`positions` (`id`, `name`) VALUES (1, 'manager');

-- room_classes

INSERT INTO `hotel`.`room_classes` (`id`, `name`) VALUES (1, 'Junior Suite');
INSERT INTO `hotel`.`room_classes` (`id`, `name`) VALUES (2, 'Suite');
INSERT INTO `hotel`.`room_classes` (`id`, `name`) VALUES (3, 'De Luxe');
INSERT INTO `hotel`.`room_classes` (`id`, `name`) VALUES (4, 'Duplex');
INSERT INTO `hotel`.`room_classes` (`id`, `name`) VALUES (5, 'Family Room');
INSERT INTO `hotel`.`room_classes` (`id`, `name`) VALUES (6, 'Studio');
INSERT INTO `hotel`.`room_classes` (`id`, `name`) VALUES (7, 'Standart');
INSERT INTO `hotel`.`room_classes` (`id`, `name`) VALUES (8, 'Bungalow');
INSERT INTO `hotel`.`room_classes` (`id`, `name`) VALUES (9, 'Apartament');
INSERT INTO `hotel`.`room_classes` (`id`, `name`) VALUES (10, 'Honeymoon Room');


-- rooms (5 floors, 4 rooms per floor from 2nd to 5th, 1st floor lobbies and dining room + Bungalow on the graund floor)

INSERT INTO `hotel`.`rooms` (`id`, `class_id`, `type_id`, `cost_per_day`, `floor`) VALUES (1, 1, 1, 1215.5, 2);
INSERT INTO `hotel`.`rooms` (`id`, `class_id`, `type_id`, `cost_per_day`, `floor`) VALUES (2, 9, 2, 450.7, 2);
INSERT INTO `hotel`.`rooms` (`id`, `class_id`, `type_id`, `cost_per_day`, `floor`) VALUES (3, 5, 2, 570.1, 2);
INSERT INTO `hotel`.`rooms` (`id`, `class_id`, `type_id`, `cost_per_day`, `floor`) VALUES (4, 6, 3, 560.74, 2);
INSERT INTO `hotel`.`rooms` (`id`, `class_id`, `type_id`, `cost_per_day`, `floor`) VALUES (5, 7, 4, 1000, 3);
INSERT INTO `hotel`.`rooms` (`id`, `class_id`, `type_id`, `cost_per_day`, `floor`) VALUES (6, 7, 5, 1000, 3);
INSERT INTO `hotel`.`rooms` (`id`, `class_id`, `type_id`, `cost_per_day`, `floor`) VALUES (7, 7, 6, 1000, 3);
INSERT INTO `hotel`.`rooms` (`id`, `class_id`, `type_id`, `cost_per_day`, `floor`) VALUES (8, 7, 7, 1000, 3);
INSERT INTO `hotel`.`rooms` (`id`, `class_id`, `type_id`, `cost_per_day`, `floor`) VALUES (9, 7, 8, 1100, 4);
INSERT INTO `hotel`.`rooms` (`id`, `class_id`, `type_id`, `cost_per_day`, `floor`) VALUES (10, 7, 9, 1100, 4);
INSERT INTO `hotel`.`rooms` (`id`, `class_id`, `type_id`, `cost_per_day`, `floor`) VALUES (11, 7, 10, 1100, 4);
INSERT INTO `hotel`.`rooms` (`id`, `class_id`, `type_id`, `cost_per_day`, `floor`) VALUES (12, 7, 11, 1100, 4);
INSERT INTO `hotel`.`rooms` (`id`, `class_id`, `type_id`, `cost_per_day`, `floor`) VALUES (13, 2, 4, 1500, 5);
INSERT INTO `hotel`.`rooms` (`id`, `class_id`, `type_id`, `cost_per_day`, `floor`) VALUES (14, 3, 4, 2000, 5);
INSERT INTO `hotel`.`rooms` (`id`, `class_id`, `type_id`, `cost_per_day`, `floor`) VALUES (15, 3, 4, 2000, 5);
INSERT INTO `hotel`.`rooms` (`id`, `class_id`, `type_id`, `cost_per_day`, `floor`) VALUES (16, 10, 4, 2500, 5);
INSERT INTO `hotel`.`rooms` (`id`, `class_id`, `type_id`, `cost_per_day`, `floor`) VALUES (17, 8, 4, 150, 0);

-- users

INSERT INTO `hotel`.`users` (`id`, `login`, `email`, `password`, `create_time`, `first_name`, `last_name`, `role_id`)
VALUES (1, 'first client', 'first@gmail.com', 'qwerty', '2020-10-02 14:28:56.388000', 'John', 'Doe ', 2);
INSERT INTO `hotel`.`users` (`id`, `login`, `email`, `password`, `create_time`, `first_name`, `last_name`, `role_id`)
VALUES (2, 'second client', 'first@gmail.com', 'qwerty', '2020-10-02 14:28:56.388000', 'Christopher', 'Roe', 1);
INSERT INTO `hotel`.`users` (`id`, `login`, `email`, `password`, `create_time`, `first_name`, `last_name`, `role_id`)
VALUES (3, 'third client', 'first@gmail.com', 'qwerty', '2020-10-02 14:28:56.388000', 'Jon ', 'Snow', 1);

-- staff

INSERT INTO `hotel`.`staff` (`id`, `user_id`, `position_id`) VALUES (1, 1, 1);

-- records

INSERT INTO `hotel`.`records` (`id`, `name`) VALUES (1, 'ordinary');
INSERT INTO `hotel`.`records` (`id`, `name`) VALUES (2, 'rowdy');
INSERT INTO `hotel`.`records` (`id`, `name`) VALUES (3, 'vip');

-- clients

INSERT INTO `hotel`.`clients` (`id`, `user_id`, `record_id`, `note`) VALUES (1, 2, 1, null);
INSERT INTO `hotel`.`clients` (`id`, `user_id`, `record_id`, `note`) VALUES (2, 3, 3, null);

-- order_flow

INSERT INTO `hotel`.`order_flow`
(`id`, `application_id`, `staff_id`, `client_id`, `room_id`, `check_in`, `check_out`,
 `total_price`, `payment_status`, `start_booking`, `room_order_status_id`)
VALUES (1, null, null, 1, 1, '2020-10-11', '2020-10-14', 3646.5, 'FALSE', '2020-10-03 02:11:34.369000', 1);
INSERT INTO `hotel`.`order_flow`
(`id`, `application_id`, `staff_id`, `client_id`, `room_id`, `check_in`, `check_out`,
 `total_price`, `payment_status`, `start_booking`, `room_order_status_id`)
VALUES (2, null, null, 1, 1, '2020-10-01', '2020-10-03', 6464, 'TRUE', '2020-10-01 02:14:29.173000', 4);
INSERT INTO `hotel`.`order_flow`
(`id`, `application_id`, `staff_id`, `client_id`, `room_id`, `check_in`, `check_out`,
 `total_price`, `payment_status`, `start_booking`, `room_order_status_id`)
VALUES (3, null, null, 2, 1, '2020-10-04', '2020-10-06', 1245, 'TRUE', '2020-10-01 02:14:29.173000', 3);
INSERT INTO `hotel`.`order_flow`
(`id`, `application_id`, `staff_id`, `client_id`, `room_id`, `check_in`, `check_out`,
 `total_price`, `payment_status`, `start_booking`, `room_order_status_id`)
VALUES (4, null, null, 2, 1, '2020-10-13', '2020-10-15', 1648, 'TRUE', '2020-10-01 02:14:29.173000', 3);
INSERT INTO `hotel`.`order_flow`
(`id`, `application_id`, `staff_id`, `client_id`, `room_id`, `check_in`, `check_out`,
 `total_price`, `payment_status`, `start_booking`, `room_order_status_id`)
VALUES (5, null, null, 2, 1, '2020-10-26', '2020-10-27', 2548, 'TRUE', '2020-10-01 02:14:29.173000', 3);
INSERT INTO `hotel`.`order_flow`
(`id`, `application_id`, `staff_id`, `client_id`, `room_id`, `check_in`, `check_out`,
 `total_price`, `payment_status`, `start_booking`, `room_order_status_id`)
VALUES (6, null, null, 2, 1, '2020-10-30', '2020-10-31', 5184, 'FALSE', '2020-10-01 02:14:29.173000', 1);





-- scenario
-- 1. order by filling out an application (заказ через заполнения заявки)
-- 1.1. filling out and sending an application (заполнение и отправка заявки)
INSERT INTO `hotel`.`applications`
(`client_id`, `number_of_adults`, `number_of_children`, `room_class_id`, `check_in`, `check_out`)
VALUES (2, 2, 0, 1, '2020-10-04', '2020-10-05');

-- 1.2. менеджер рассматривает заявку
-- вручную делает выборку по свободным номерам
-- (выборка свободных номеров в заданном диапазоне дат)
SELECT r.id                                                                                           'id',
       rt.full_name                                                                                   'room type',
       rc.name                                                                                        'room classes',
       rt.number_of_adults + rt.number_of_children                                                    'num',
       rt.number_of_adults                                                                            'adults',
       rt.number_of_children                                                                          'children',
       CAST((UNIX_TIMESTAMP('2020-10-14') - UNIX_TIMESTAMP('2020-10-01')) / (60 * 60 * 24) as SIGNED) 'days',
       r.cost_per_day                                                                                 `cost per day`,
       ROUND(((UNIX_TIMESTAMP('2020-10-14') - UNIX_TIMESTAMP('2020-10-01')) / (60 * 60 * 24) * r.cost_per_day),
             2)                                                                                       `total price`
FROM rooms r
         JOIN room_classes rc ON r.class_id = rc.id
         JOIN room_types rt ON r.type_id = rt.id
WHERE r.id NOT IN (
    SELECT r.id
    FROM hotel.order_flow ofl
             JOIN rooms r ON ofl.room_id = r.id
    WHERE ofl.check_out > '2020-10-01'
      and ofl.check_in < '2020-10-14'
      and ofl.room_order_status_id IN (1, 3, 4));


-- 1.2.1
-- выбирает лучшее предложение и прислыет запрос клиенту
-- (запрос сразу попадает в таблицу брони, сразу указывается время старта брони, но в учёт не берётся
-- т. к. статус брони не подтверждён)
INSERT INTO `hotel`.`order_flow`
(`application_id`, `staff_id`, `client_id`, `room_id`, `check_in`,
`check_out`, `total_price`, `payment_status_id`, `start_booking`, `booking_status_id`)
VALUES (1, 1, 2, 1, '2020-10-04', '2020-10-05', 300.5, 1, '2020-10-02 06:53:38.710000', 3);

-- 1.3. клиент одобряет запрос отеля
-- (в таблице bookings ? меняем статус брони на "забронировано" и обновлям время старта брони)
-- (в таблице hotel ? меняем статус номера на "забронировано")

UPDATE `hotel`.`bookings` t
SET t.`start_booking` = '2020-10-02 10:53:38.710000', t.`booking_status_id` = 1
WHERE t.`id` = 1;
UPDATE `hotel`.`rooms` t
SET t.`status_id` = 2
WHERE t.`id` = 1;

-- 1.4. клиенту выставляется счёт (все данные вынимаются из базы)
-- (запускается счётчик времени, если время 48 часов вышло ? снимается броня)

-- 1.5. клиент оплачивает счёт (время бнони 48 часов сутор не вышло)
-- (в таблице bookings ? меняем статус оплаты на оплачено)
UPDATE `hotel`.`bookings` t
SET t.`payment_status_id` = 2
WHERE t.`id` = 1;

-- 1.6. клиент заселяется в гостиницу
-- (в таблице bookings ? меняем статус на выполнено)
-- (в таблице rooms ? меняем статус номера на заселён)
UPDATE `hotel`.`bookings` t
SET t.`booking_status_id` = 4
WHERE t.`id` = 1;
PDATE `hotel`.`rooms` t SET t.`status_id` = 3 WHERE t.`id` = 1

-- 1.7. клиент выселился из отеля
-- (в таблице rooms ? меняем статус номера на свободен)
UPDATE `hotel`.`rooms` t SET t.`status_id` = 1 WHERE t.`id` = 1