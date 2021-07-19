package ifsuldeminas.pas.bcc.teii.imhungry.model.entity;

//import java.util.ArrayList;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

// TODO: como lidar com classes filhas em relação ao ORM?

@Entity
@DiscriminatorValue(value="customer")
public class Customer extends User{
    private String cpf;
    private String age;

    @OneToMany
    @JoinColumn(name="user_id")
    private List<Address> addresses;

    @OneToMany
    @JoinColumn(name="user_id")
    private List<PaymentMethod> paymentMethods;

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

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(ArrayList<Address> addresses) {
        this.addresses = addresses;
    }

    public List<PaymentMethod> getPaymentMethods() {
        return paymentMethods;
    }

    public void setPaymentMethods(ArrayList<PaymentMethod> paymentMethods) {
        this.paymentMethods = paymentMethods;
    }
}