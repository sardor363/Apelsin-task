package uz.sardor.apelsintask.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false,length = 14)
    private String name;
    @Column(nullable = false,length = 3)
    private String country;
    private String text;
    @Column(length = 50)
    private String phone;
}
