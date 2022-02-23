package in.cdac.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.cdac.models.OrderModel;

@Repository
public interface OrderModelRepository extends JpaRepository<OrderModel, Long> {

}
