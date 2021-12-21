package uz.sardor.apelsintask.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.sardor.apelsintask.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment,Integer> {
}
