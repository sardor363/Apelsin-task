package uz.sardor.apelsintask.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.sardor.apelsintask.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}

