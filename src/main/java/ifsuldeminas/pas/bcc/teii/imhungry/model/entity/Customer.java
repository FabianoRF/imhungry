package ifsuldeminas.pas.bcc.teii.imhungry.model.entity;

//import java.util.ArrayList;
import javax.persistence.*;

// TODO: como lidar com classes filhas em relação ao ORM?

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="class")
public class Customer extends User{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String cpf;
    private String age;
//    private ArrayList<Address> addresses;
//    private ArrayList<PaymentMethods> paymentMethods

    // atenção aos atributos faltantes

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
