package uz.sardor.apelsintask.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.sardor.apelsintask.entity.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice,Integer> {
}
