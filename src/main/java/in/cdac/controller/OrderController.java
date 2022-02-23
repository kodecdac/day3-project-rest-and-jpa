package in.cdac.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.cdac.models.OrderModel;
import in.cdac.repository.OrderModelRepository;

@Validated
@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderModelRepository orderModelRepository;
	
	
	
	@GetMapping("/list")
	public List<OrderModel> getAllOrder() {
		return orderModelRepository.findAll();
	}
	
	
	@PostMapping("/create")
	public OrderModel createOrder(@Valid @RequestBody OrderModel order) {
		
		orderModelRepository.save(order);
		
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
	public String createOrderV1( boolean offer, @DateTimeFormat(iso = ISO.DATE, pattern = "dd/MM/yyyy") LocalDate purchaseDate, double productPrice, String productId, int prodcutQty, String productName ) {
		return "success";
	}
	
	
	@GetMapping("/hi")
	public String hi() {
		return "Hi...";
	}
}
