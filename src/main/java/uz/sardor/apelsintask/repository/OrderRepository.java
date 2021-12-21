package uz.sardor.apelsintask.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.sardor.apelsintask.entity.Order;

public interface OrderRepository extends JpaRepository<Order,Integer> {
}
