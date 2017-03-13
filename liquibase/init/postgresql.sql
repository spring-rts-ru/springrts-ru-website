-- http://eax.me/postgresql-install/

-- start postgres on fedora linux:
-- sudo systemctl start postgresql

-- enter postgres console on linux:
-- sudo -u postgres psql

drop database springrtsru;
create database springrtsru;

create user local with password 'local';

grant all privileges on database springrtsru to local;

