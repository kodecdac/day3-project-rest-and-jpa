package in.cdac.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import in.cdac.models.OrderModel;

@Repository
public interface OrderModelRepository extends JpaRepository<OrderModel, Long> {

	List<OrderModel> findByProductName(String productName);
	
	@Query(nativeQuery = true, value = "SELECT * FROM order_model")
	List<OrderModel> findAllCustomQuery();
	
	@Query(nativeQuery = true, value = "SELECT * FROM order_model where id=?")
	List<OrderModel> findAllWhereCustomQuery(Long id);
	
	@Query(nativeQuery = true, value = "SELECT * FROM order_model where id=? and product_name=?")
	List<OrderModel> findAllWhereCustomQuery(Long id, String productName);
	
	
	
	@Modifying
	@Transactional
	@Query(nativeQuery = true, value = "INSERT INTO order_model (id, product_id,  product_name, product_qty, product_price, offer) VALUES (?, ?, ?, ?, ?, ?)")
	void addRecord(Long id, String pid, String pname, int pqty, double pprice, boolean offer);
	
}
