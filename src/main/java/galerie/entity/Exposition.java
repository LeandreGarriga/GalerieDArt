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
public class Exposition {
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer id;
    
    @Column(unique=true)
    @NonNull
    private String intitule;
    
    @Column(unique=true)
    private LocalDate dateDebut;
    
    @Column(unique=true)
    private int duree;
    
    @ManyToMany
    @JoinTable(name="expo_tableau",
        joinColumns = 
                @JoinColumn(name = "exposition_id", referencedColumnName="id"),
        inverseJoinColumns = 
                @JoinColumn(name = "tableau_id",  referencedColumnName="id")
    )    
    List<Tableau> oeuvres = new LinkedList<>();
    
    @OneToMany
    List<Galerie> organisateurs = new LinkedList<>();
    
    @OneToMany
    List<Transaction> ventes = new LinkedList<>();
    
    private float ca=0;
    
    private float chiffreAffaire(){
        for(Transaction t : ventes){
            if(t.getId()==id){
                ca=ca + t.getPrixVente();
            }
        }
        return ca;
    }
}
