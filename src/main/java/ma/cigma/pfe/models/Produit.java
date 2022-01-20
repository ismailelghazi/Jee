package ma.cigma.pfe.models;
import lombok.*;
import javax.persistence.*;
@Entity
@ToString

public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    private String name;
    private int price;
    public Produit() {
    }
    public Produit(String name, int price) {
        this.name = name;
        this.price = price;
    }

}
