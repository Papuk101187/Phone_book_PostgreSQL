CREATE TABLE users(
id_user SERIAL PRIMARY KEY,
login_user VARCHAR(30),
login_password VARCHAR(30),
date_born VARCHAR(30));

(id_contacts SERIAL PRIMARY KEY,
name_contact VARCHAR(30),
type_contact VARCHAR(30),
value_contact VARCHAR(30),
id_user INT,
CONSTRAINT users_id_users_fk FOREIGN KEY(id_user) REFERENCES users(id_user));