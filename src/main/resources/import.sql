
INSERT INTO imona.city (enabled, created_date, name) VALUES (true, '2021-01-29 01:04:01', 'İstanbul');
INSERT INTO imona.city (enabled, created_date, name) VALUES (true, '2021-01-29 01:04:01', 'Ankara');
INSERT INTO imona.city (enabled, created_date, name) VALUES (true, '2021-01-29 01:04:01', 'İzmir');



INSERT INTO imona.game (enabled, created_date, description, logo, name) VALUES (true, '2021-01-29 01:16:25', 'Flappy Bird oynamak için artık kimsenin telefona ihtiyacı yok. Büyük ekranda oyunun keyfine varacaksınız. Oyunun amacı minik kuşu havada tutabilmek. Fazla yükselirse, yere yada herhangi bir yere çarparsa kuşumuz yaralanır', null, 'Flappy Bird');
INSERT INTO imona.game (enabled, created_date, description, logo, name) VALUES (true, '2021-01-29 01:16:25', 'Araba park etme oyunları ile hem park etmeyi daha iyi öğreneceksiniz hem de eğleneceksiniz. Gerçekte araba park etmeyi bilenler oyunlarda da başarı sağlayabiliyorlar', null, 'ARABA PARK ETME');


INSERT INTO imona.player (enabled, created_date, birth_date, flag, gender, name, surname, city_id, game_id) VALUES (true, '2021-01-29 01:20:04', '2021-01-29 01:20:05', true, 'MALE', 'Mahmut', 'Savur', 1, 1);
INSERT INTO imona.player (enabled, created_date, birth_date, flag, gender, name, surname, city_id, game_id) VALUES (true, '2021-01-29 01:20:04', '2021-01-29 01:20:05', true, 'FEMALE', 'Jale', 'Jale2', 2, 2);


INSERT INTO imona.action (enabled, created_date, description, name, point, game_id) VALUES (true, '2021-01-29 01:21:20', 'Kuş havadan uçması', 'Uçmak', 50, 1);
INSERT INTO imona.action (enabled, created_date, description, name, point, game_id) VALUES (true, '2021-01-29 01:21:20', 'Araç park edildi.', 'Araç park etmek', 20, 2);
INSERT INTO imona.action (enabled, created_date, description, name, point, game_id) VALUES (true, '2021-01-29 01:21:20', 'Kuş Kanat çırpması', 'Kanat çırpmak', 30, 2);


