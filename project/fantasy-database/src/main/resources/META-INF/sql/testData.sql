insert into user_data(user_id, index, login, password, role) values (1, 000001, 'admin', 'c7ad44cbad762a5da0a452f9e854fdc1e0e7a52a38015f23f3eab1d80b931dd472634dfac71cd34ebc35d16ab7fb8a90c81f975113d6c7538dc69dd8de9077ec','ADMIN');
insert into user_data(user_id, index, login, password, role) values (2, 111111, 'user', 'b14361404c078ffd549c03db443c3fede2f3e534d73f78f77301ed97d4a436a9fd9db05ee8b325c0ad36438b43fec8510c204fc1c1edb21d0941c00e9e2c1ce2','User');

insert into ct_cave (cave_id, square) values (1001, 10);
insert into ct_cave (cave_id, square) values (1002, 30);
insert into hr_dragon (dragon_id, color, gold, name, power, cave_id)
values (1001, 'BLACK', 2, 'Smok11', 'POWER_1', 1001);
insert into hr_dragon (dragon_id, color, gold, name, power, cave_id)
values (1002, 'BLACK', 2, 'Smok12', 'POWER_2', 1001);
insert into hr_dragon (dragon_id, color, gold, name, power, cave_id)
values (1003, 'WHITE', 2, 'Smok3', 'POWER_3', 1002);

insert into ct_forest (forest_id, amount_of_trees) values (1011, 200);
insert into ct_forest (forest_id, amount_of_trees) values (1012, 300);
insert into hr_elf (elf_id, arrow_count, bow_type, name, power, forest_id)
values (1011, 11, 'GOOD', 'Elf1', 'POWER_1', 1011);
insert into hr_elf (elf_id, arrow_count, bow_type, name, power, forest_id)
values (1012, 12, 'MIDDLE', 'Elf2', 'POWER_2', 1012);
insert into hr_elf (elf_id, arrow_count, bow_type, name, power, forest_id)
values (1013, 13, 'BAD', 'Elf3', 'POWER_3', 1012);

insert into ct_tower (tower_id, height) values (1111, 115);
insert into ct_tower (tower_id, height) values (1112, 205);
insert into hr_mag (mag_id, element, mana, name, power, tower_id) VALUES (1111, 'STICK_1', 10, 'Mag1', 'POWER_1', 1111);
insert into hr_mag (mag_id, element, mana, name, power, tower_id) VALUES (1112, 'STICK_2', 15, 'Mag2', 'POWER_2', 1111);
insert into hr_mag (mag_id, element, mana, name, power, tower_id) VALUES (1113, 'STICK_3', 20, 'Mag3', 'POWER_3', 1112);
commit;
--
