package one_to_many;

import javax.persistence.*;

@Entity(name = "BL_one_to_many")
@Table(name = "labels")
public class BasicLabel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String color;

    @OneToOne(mappedBy = "label", targetEntity = BasicShampoo.class)
    private BasicShampoo shampoo;

    public BasicLabel() {
    }

    public BasicLabel(String color) {
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public BasicShampoo getShampoo() {
        return shampoo;
    }

    public void setShampoo(BasicShampoo shampoo) {
        this.shampoo = shampoo;
    }
}
