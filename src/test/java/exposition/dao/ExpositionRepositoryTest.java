/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exposition.dao;

import galerie.entity.Exposition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.jdbc.Sql;
import galerie.dao.ExpositionRepository;

@Log4j2 // Génère le 'logger' pour afficher les messages de trace
@DataJpaTest
public class ExpositionRepositoryTest {
    @Autowired
    private ExpositionRepository expoDAO;
    
    @Test
    @Sql("test-data.sql") // On peut charger des donnnées spécifiques pour un test
    public void onSaitCompterLesEnregistrements() {
        log.info("On compte les enregistrements de la table 'Exposition'");
        int combienDansLeJeuDeTest = 2; 
        long nombre = expoDAO.count();
        assertEquals(combienDansLeJeuDeTest, nombre, "On doit trouver 4 galerie" );
    }
}
