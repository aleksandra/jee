insert into User (login, imie, haslo) values ('ola', 'Ola', '12345');
insert into User (login, imie, haslo) values ('ala', 'Ala', '12345');
insert into User (login, imie, haslo) values ('zosia', 'Zosia', '12345');
insert into User (login, imie, haslo) values ('admin', 'Administrator', 'admin');


insert into Notatka (user_login, data, tresc) values ('ola', '2011-01-29 01:00:00.0', 'projekt Java!!!!');
insert into Notatka (user_login, data, tresc) values ('ola', '2011-01-02 01:00:00.0', 'styczen costam');
insert into Notatka (user_login, data, tresc) values ('ola', '2010-01-02 01:00:00.0', 'stara notatka');
insert into Notatka (user_login, data, tresc) values ('ola', '2000-01-02 01:00:00.0', 'bardzo stara notatka');
insert into Notatka (user_login, data, tresc) values ('ola', '2012-01-02 01:00:00.0', 'przysz³y rok');
insert into Notatka (user_login, data, tresc) values ('ola', '2011-02-06 01:00:00.0', 'luty luty luty');
insert into Notatka (user_login, data, tresc) values ('ola', CURRENT_TIMESTAMP, 'dzis');


insert into Notatka (user_login, data, tresc) values ('ala', '2011-01-02 01:00:00.0', 'styczen costam ala');
insert into Notatka (user_login, data, tresc) values ('ala', '2010-01-02 01:00:00.0', 'stara notatka alaa');
insert into Notatka (user_login, data, tresc) values ('ala', '2012-01-02 01:00:00.0', 'przysz³y rok alala');
insert into Notatka (user_login, data, tresc) values ('ala', '2011-02-06 01:00:00.0', 'luty luty luty ala');
insert into Notatka (user_login, data, tresc) values ('ala', CURRENT_TIMESTAMP, 'dzis ali');