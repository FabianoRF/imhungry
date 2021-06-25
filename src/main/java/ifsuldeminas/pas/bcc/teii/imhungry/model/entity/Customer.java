package ifsuldeminas.pas.bcc.teii.imhungry.model.entity;

//import java.util.ArrayList;
import javax.persistence.*;
import java.util.ArrayList;

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
    private ArrayList<Address> addresses;
    private ArrayList<PaymentMethod> paymentMethods;

// atenção aos atributos faltantes

    @Override
    public long getId() {
        return id;
    }

    @Override
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

    public ArrayList<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(ArrayList<Address> addresses) {
        this.addresses = addresses;
    }

    public ArrayList<PaymentMethod> getPaymentMethods() {
        return paymentMethods;
    }

    public void setPaymentMethods(ArrayList<PaymentMethod> paymentMethods) {
        this.paymentMethods = paymentMethods;
    }
}
