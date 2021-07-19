package ifsuldeminas.pas.bcc.teii.imhungry.model.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private long customerId;
    private long restaurantId;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name="orders_food",
            joinColumns={@JoinColumn(name = "orders_id")},
            inverseJoinColumns={@JoinColumn(name = "food_id")})
    private Set<Food> foods;

    private String status;
    private float totalPrice;
    private Date date;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(long restaurantId) {
        this.restaurantId = restaurantId;
    }

//    public Set<Food> getFoods() {
//        return foods;
//    }
//
//    public void setFoods(Set<Food> foods) {
//        this.foods = foods;
//    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
