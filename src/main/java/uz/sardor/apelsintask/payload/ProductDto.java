package uz.sardor.apelsintask.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.sardor.apelsintask.entity.Category;

import javax.persistence.Column;
import javax.persistence.ManyToOne;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    @Column(nullable = false,length = 10)
    private String name;
    private Integer categoryId;
    @Column(nullable = false,length = 20)
    private String description;
    private double price;
    @Column(length = 1024)
    private String photo;
}
