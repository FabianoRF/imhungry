package ifsuldeminas.pas.bcc.teii.imhungry.model.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Set;

@Entity
public class Restaurant {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String cnpj;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name="restaurant_food",
            joinColumns={@JoinColumn(name = "restaurant_id")},
            inverseJoinColumns={@JoinColumn(name = "food_id")})
    private Set<Food> foodMenu;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public Set<Food> getFoodMenu() {
        return foodMenu;
    }

    public void setFoodMenu(Set<Food> foodMenu) {
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