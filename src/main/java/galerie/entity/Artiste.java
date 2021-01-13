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
@Getter @Setter @NoArgsConstructor @RequiredArgsConstructor @ToString(callSuper = true) 
@Entity // Une entité JPA
public class Artiste extends Personne{
    @Column(unique=true)
    @NonNull
    private String biographie;
    
    public Artiste(Integer id, String nom, String adresse, String biographie){
    super(id, nom, adresse);
    this.biographie=biographie;
    }
    
    @OneToMany
    List<Tableau> oeuvres = new LinkedList<>();
}
