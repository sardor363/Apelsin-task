package uz.sardor.apelsintask.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.sardor.apelsintask.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}
