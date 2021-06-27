package ifsuldeminas.pas.bcc.teii.imhungry.model.entity;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="class")

public class Restaurant {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String cnpj;

    @OneToOne
    private Address address;
    @OneToMany(mappedBy = "restaurant")
    private ArrayList<Food> foodMenu;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public ArrayList<Food> getFoodMenu() {
        return foodMenu;
    }

    public void setFoodMenu(ArrayList<Food> foodMenu) {
        this.foodMenu = foodMenu;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

}