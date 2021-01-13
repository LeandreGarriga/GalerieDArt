-- Initialisation spécifiques pour un jeu de test
/**
INSERT INTO Galerie(nom, adresse) VALUES ('Saatchi', 'King\''s Road, Londres');
INSERT INTO Galerie(nom, adresse) VALUES ('Louvre', 'Paris');
INSERT INTO Galerie(nom, adresse) VALUES ('Fabre', 'Montpellier');
INSERT INTO Galerie(nom, adresse) VALUES ('Capitolins', 'Rome');

INSERT INTO Exposition(intitule, dateDebut, duree) VALUES ('L\''art brut contemporain', NOW(),30);
INSERT INTO Exposition(intitule, dateDebut, duree) VALUES ('Les expressionistes français',NULL,NULL);

INSERT INTO Personne(nom, adresse) VALUES ('Rémi Bastide','ISIS Castres');
**/
INSERT INTO Galerie(id, nom, adresse) VALUES (1, 'Saatchi', 'King\''s Road, Londres');
INSERT INTO Galerie(id, nom, adresse) VALUES (2, 'Louvre', 'Paris');
INSERT INTO Galerie(id, nom, adresse) VALUES (3, 'Fabre', 'Montpellier');
INSERT INTO Galerie(id, nom, adresse) VALUES (4, 'Capitolins', 'Rome');

INSERT INTO Exposition(id, intitule, dateDebut, duree) VALUES (1, 'L\''art brut contemporain', NOW(),30);
INSERT INTO Exposition(id, intitule, dateDebut, duree) VALUES (2, 'Les expressionistes français',NOW(),15);

INSERT INTO Exposition(id, nom, adresse) VALUES (1, 'Rémi Bastide','ISIS Castres');
