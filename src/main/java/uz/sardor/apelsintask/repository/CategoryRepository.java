package uz.sardor.apelsintask.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.sardor.apelsintask.entity.Category;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
