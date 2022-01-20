package ma.cigma.pfe.models;
import lombok.ToString;
import javax.persistence.*;
@Entity
public class Adresse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String avenue;
    private String Ville;
    private String pays;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
    public Adresse() {
    }
    public Adresse(String avenue, String ville, String pays,Client client) {
        this.avenue = avenue;
        this.Ville = ville;
        this.pays = pays;
        this.client=client;
    }


}
