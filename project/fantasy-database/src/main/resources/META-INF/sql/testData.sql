begin;
insert into user_data(user_id, index, login, password, role) values (1111, 000001, 'admin', 'ISMvKXpXpadDiUoOSoAfww==','ADMIN');
insert into user_data(user_id, index, login, password, role) values (1002, 111111, 'user', '7hHLsZBS5AsHqsDKBgwj7g==','USER');
insert into user_data(user_id, index, login, password, role) values (1003, 111112, 'pietsy', 'wXy/kdFyHasXk07j6c9UAg==','USER');

insert into ct_cave (cave_id, square, user_id) values (1001, 10, 1002);
insert into ct_cave (cave_id, square, user_id) values (1002, 30, 1003);
insert into hr_dragon (dragon_id, color, gold, name, power, cave_id) values (1001, 'BLACK', 2, 'Smok11', 'POWER_1', 1001);
insert into hr_dragon (dragon_id, color, gold, name, power, cave_id) values (1002, 'BLACK', 2, 'Smok12', 'POWER_2', 1001);
insert into hr_dragon (dragon_id, color, gold, name, power, cave_id) values (1003, 'WHITE', 2, 'Smok3', 'POWER_3', 1002);

insert into ct_forest (forest_id, amount_of_trees, user_id) values (1011, 200, 1002);
insert into ct_forest (forest_id, amount_of_trees, user_id) values (1012, 300, 1003);
insert into hr_elf (elf_id, arrow_count, bow_type, name, power, forest_id) values (1011, 11, 'GOOD', 'Elf1', 'POWER_1', 1011);
insert into hr_elf (elf_id, arrow_count, bow_type, name, power, forest_id) values (1012, 12, 'MIDDLE', 'Elf2', 'POWER_2', 1012);
insert into hr_elf (elf_id, arrow_count, bow_type, name, power, forest_id) values (1013, 13, 'BAD', 'Elf3', 'POWER_3', 1012);

insert into ct_tower (tower_id, height, user_id) values (1111, 115, 1002);
insert into ct_tower (tower_id, height, user_id) values (1112, 205, 1003);
insert into hr_mag (mag_id, element, mana, name, power, tower_id) VALUES (1111, 'STICK_1', 10, 'Mag1', 'POWER_1', 1111);
insert into hr_mag (mag_id, element, mana, name, power, tower_id) VALUES (1112, 'STICK_2', 15, 'Mag2', 'POWER_2', 1111);
insert into hr_mag (mag_id, element, mana, name, power, tower_id) VALUES (1113, 'STICK_3', 20, 'Mag3', 'POWER_3', 1112);
commit;
--
