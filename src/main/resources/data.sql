INSERT INTO role (id, name) VALUES (1, 'ADMIN') ON DUPLICATE KEY UPDATE name = 'ADMIN';
INSERT INTO role (id, name) VALUES (2, 'USER') ON DUPLICATE KEY UPDATE name = 'USER';
INSERT INTO criterion (id, type, libelle) VALUES (1, 'USER_NOTES', "Moyenne utilisateurs") ON DUPLICATE KEY UPDATE type = 'USER_NOTES';
INSERT INTO criterion (id, type, libelle) VALUES (2, 'METEO_NOTES', "Moyenne météo") ON DUPLICATE KEY UPDATE type = 'METEO_NOTES';