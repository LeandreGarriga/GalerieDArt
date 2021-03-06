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
public class Galerie {
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer id;

    @Column(unique=true)
    @NonNull
    private String nom;
    
    @Column(unique=true)
    @NonNull
    private String adresse;
    
    @OneToMany
    List<Exposition> evenements = new LinkedList<>();
    
    // TODO : Mettre en oeuvre la relation oneToMany vers Exposition
    public float CAAnnuel(int annee){
        float caa = 0;
        for(Exposition e : evenements){
            if(e.getDateDebut().getYear()== annee){
                caa= caa + e.getCa();
            }
            
        }
        
        return caa;
    }
}

