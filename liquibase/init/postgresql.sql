-- http://eax.me/postgresql-install/

-- on linux: sudo -u postgres psql
-- on fedora: sudo systemctl start postgresql


drop database springrtsru;
create database springrtsru;

create user local with password 'local';

grant all privileges on database springrtsru to local;

