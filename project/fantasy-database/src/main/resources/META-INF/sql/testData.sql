insert into ct_cave (cave_id, square) values (1001, 10);
insert into ct_cave (cave_id, square) values (1002, 30);
insert into hr_dragon (dragon_id, color, gold, name, power, cave_id) values (1, 'BLACK', 2, 'Smok11', 'POWER_1', 1001);
insert into hr_dragon (dragon_id, color, gold, name, power, cave_id) values (2, 'BLACK', 2, 'Smok12', 'POWER_2', 1001);
insert into hr_dragon (dragon_id, color, gold, name, power, cave_id) values (3, 'WHITE', 2, 'Smok3', 'POWER_3', 1002);

insert into ct_forest (forest_id, amount_of_trees) values (11, 200);
insert into ct_forest (forest_id, amount_of_trees) values (12, 300);
insert into hr_elf (elf_id, arrow_count, bow_type, name, power, forest_id)
values (11, 11, 'GOOD', 'Elf1', 'POWER_1', 11);
insert into hr_elf (elf_id, arrow_count, bow_type, name, power, forest_id)
values (12, 12, 'MIDDLE', 'Elf2', 'POWER_2', 12);
insert into hr_elf (elf_id, arrow_count, bow_type, name, power, forest_id)
values (13, 13, 'BAD', 'Elf3', 'POWER_3', 12);

insert into ct_tower (tower_id, height) values (111, 115);
insert into ct_tower (tower_id, height) values (112, 205);
insert into hr_mag (mag_id, element, mana, name, power, tower_id) VALUES (111, 'STICK_1', 10, 'Mag1', 'POWER_1', 111);
insert into hr_mag (mag_id, element, mana, name, power, tower_id) VALUES (112, 'STICK_2', 15, 'Mag2', 'POWER_2', 111);
insert into hr_mag (mag_id, element, mana, name, power, tower_id) VALUES (113, 'STICK_3', 20, 'Mag3', 'POWER_3', 112);
commit;
--
