package ifsuldeminas.pas.bcc.teii.imhungry.model.entity;

//import java.util.ArrayList;
import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="class")
public class Customer {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String cpf;
    private String age;
//    private ArrayList<Address> addresses;
//    private ArrayList<PaymentMethods> paymentMethods
}
