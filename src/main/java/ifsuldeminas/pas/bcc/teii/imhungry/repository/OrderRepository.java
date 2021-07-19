package ifsuldeminas.pas.bcc.teii.imhungry.repository;

import ifsuldeminas.pas.bcc.teii.imhungry.model.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Long> {
}
