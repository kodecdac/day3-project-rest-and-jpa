package in.cdac.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.cdac.models.OrderModel;
import in.cdac.repository.OrderModelRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Validated
@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderModelRepository orderModelRepository;
	
	
	
	@GetMapping("/list")
	public List<OrderModel> getAllOrder() {
		
		List<OrderModel> list1 = orderModelRepository.findByProductName("iphone");
		System.out.println(list1);
		
		list1 = orderModelRepository.findAllCustomQuery();
		list1 = orderModelRepository.findAllWhereCustomQuery(5l, "iphone");
		
		return orderModelRepository.findAll(Sort.by(Direction.DESC, "productName"));
	}
	
	
	@PostMapping("/create")
	public OrderModel createOrder(@Valid @RequestBody OrderModel order) {
		
		orderModelRepository.save(order);
		
		// orderModelRepository.addRecord(10000l, "ABCD001", "ABCD PQRS", 10, 99.99, true);
		
		
		return order;
	}
	
	
	
	
	
	
	
	// PRACTICE
	@GetMapping("/createV2")
	public OrderModel createOrderV2(@Valid OrderModel order) {
		// ...
		// list.add(order);
		return order;
	}
	
	
	@GetMapping("/createV1")
	public String createOrderV1(@RequestParam(name = "offer1") boolean offer, @DateTimeFormat(iso = ISO.DATE, pattern = "dd/MM/yyyy") LocalDate purchaseDate, double productPrice, String productId, int prodcutQty, String productName ) {
		return "success";
	}
	
	
	@GetMapping("/hi")
	public String hi() {
		return "Hi...";
	}
	
	@GetMapping("/jwt")
	public String jwt() {
		
		return Jwts.builder()
					.claim("name", "xyz")
					.signWith(SignatureAlgorithm.HS256, "secret")
					.setIssuedAt(new Date())
					.setExpiration(new Date(System.currentTimeMillis() + 60 * 60 * 24 * 1000))
					.compact();
	}
}
