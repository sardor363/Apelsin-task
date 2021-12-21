package uz.sardor.apelsintask.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {
    @Column(nullable = false)
    private String name;
}
