package uz.sardor.apelsintask.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne
    private Order ordId;
    @Column(nullable = false)
    private double amount;
    @Column(nullable = false)
    private Date issued;
    @Column(nullable = false)
    private Date due;
}
