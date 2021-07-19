package ifsuldeminas.pas.bcc.teii.imhungry.repository;

import ifsuldeminas.pas.bcc.teii.imhungry.model.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {
}
