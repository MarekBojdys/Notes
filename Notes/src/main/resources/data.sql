insert into user_role(role, description) VALUES ("ROLE_ADMIN", "admin account");
insert into user_role(role, description) VALUES ("ROLE_USER", "default role for user");
insert into user(login, password) VALUES ("admin", "{bcrypt}$2a$10$3xBxR0F1WifRpkbkjptkF.pvdOuhHeU9qjZVFxv/OXtHV3GkOJGua");
insert into user_roles(user_id, roles_id) VALUES ("1","1");