/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galerie.entity;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.*;
import lombok.*;

// Un exemple d'entité
// On utilise Lombok pour auto-générer getter / setter / toString...
// cf. https://examples.javacodegeeks.com/spring-boot-with-lombok/
@Getter @Setter @NoArgsConstructor @RequiredArgsConstructor @ToString
@Entity // Une entité JPA
public class Transaction {
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer id;
    
    @Column(unique=true)
    @NonNull
    private LocalDate venduLe;
    
    @Column(unique=true)
    @NonNull
    private float prixVente;
    
    @OneToMany(mappedBy = "achats")
    List<Personne> client = new LinkedList<>();
    
    @OneToMany(mappedBy = "ventes")
    List<Exposition> lieuDeVente = new LinkedList<>();
    
    @OneToOne
    private Tableau oeuvre;
}
