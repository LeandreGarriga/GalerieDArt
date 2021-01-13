/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galerie.entity;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.*;
import lombok.*;

// Un exemple d'entité
// On utilise Lombok pour auto-générer getter / setter / toString...
// cf. https://examples.javacodegeeks.com/spring-boot-with-lombok/
@Getter @Setter @NoArgsConstructor @RequiredArgsConstructor @ToString
@Entity // Une entité JPA
public class Tableau {
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer id;
    
    @Column(unique=true)
    @NonNull
    private String titre;
    
    @Column(unique=true)
    @NonNull
    private int largeur;
    
    @Column(unique=true)
    @NonNull
    private int hauteur;
    
    @Column(unique=false)
    @NonNull
    private String support;
    
    @ManyToMany(mappedBy = "oeuvres")
    List<Exposition> accrochages = new LinkedList<>();
    
    @OneToMany(mappedBy = "oeuvres")
    List<Artiste> auteur = new LinkedList<>();
    
    @OneToOne(mappedBy = "oeuvre")
    private Transaction vendu ;
}
