
create database UserApiRepository
go
use UserApiRepository

go

if exists (select 'yes' from sys.objects where name='roles')
insert into roles values ('USER' ),('ROLE_ADMIN')

--select * from users 
if exists (select 'yes' from sys.objects where name='users')
insert into users values ('Arber','Zeneli','$2a$12$3PDxf.PbK3L9E0JKn38Azu.1FSHH/0KYSCKcdG2aL4q/1heL1zol.','azeneli',1)
--the encrypted password is 123456
