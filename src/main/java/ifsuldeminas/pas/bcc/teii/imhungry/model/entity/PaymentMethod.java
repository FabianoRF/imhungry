package ifsuldeminas.pas.bcc.teii.imhungry.model.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="class")

public class PaymentMethod {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String type;
    private ArrayList<PaymentMethod> number;
    private String cardNAme;
    private Date expiration;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ArrayList<PaymentMethod> getNumber() {
        return number;
    }

    public void setNumber(ArrayList<PaymentMethod> number) {
        this.number = number;
    }

    public String getCardNAme() {
        return cardNAme;
    }

    public void setCardNAme(String cardNAme) {
        this.cardNAme = cardNAme;
    }

    public Date getExpiration() {
        return expiration;
    }

    public void setExpiration(Date expiration) {
        this.expiration = expiration;
    }
}
