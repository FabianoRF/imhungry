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
    private String number;
    private String cardName;
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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public Date getExpiration() {
        return expiration;
    }

    public void setExpiration(Date expiration) {
        this.expiration = expiration;
    }
}
