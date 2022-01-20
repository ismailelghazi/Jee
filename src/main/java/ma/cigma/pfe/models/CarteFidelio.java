package ma.cigma.pfe.models;
import lombok.ToString;
import javax.persistence.*;
@ToString
@Entity
public class CarteFidelio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String code;
    @OneToOne
    @JoinColumn(name = "client_id")
    private Client client;
    public CarteFidelio() {
    }
    public CarteFidelio(Client client, String code) {
        this.client = client;
        this.code = code;
    }
    public void setClient(Client client) {
    }
}
