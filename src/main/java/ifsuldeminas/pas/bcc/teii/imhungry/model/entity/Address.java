package ifsuldeminas.pas.bcc.teii.imhungry.model.entity;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="class")
public class Address {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private User user;
    private String road;
    private String district;
    private String complement;
    private int number;
    private City city;
}
