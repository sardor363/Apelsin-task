package uz.sardor.apelsintask.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {
    @Column(nullable = false,length = 14)
    private String name;
    @Column(nullable = false,length = 3)
    private String country;
    private String address;
    @Column(length = 50)
    private String phone;
}
