insert INTO ct_cave(cave_id, square) values (1, 10);
insert INTO ct_cave (cave_id, square) values (3, 30);
insert into hr_dragon (dragon_id, color, gold, name, power, cave_id) values (1, 'BLACK', 2, 'Smok11', 'POWER_1', 1);
insert into hr_dragon (dragon_id, color, gold, name, power, cave_id) values (2, 'BLACK', 2, 'Smok12', 'POWER_2', 1);
insert into hr_dragon (dragon_id, color, gold, name, power, cave_id) values (3, 'WHITE', 2, 'Smok3', 'POWER_3', 3);
commit;
--
