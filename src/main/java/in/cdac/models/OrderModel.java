package in.cdac.models;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.Data;

@Data
@Entity
public class OrderModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Size(min = 3, max=10)
	private String productName;
	private String productId;
	
	@Min(1)
	@Max(10)
	private int productQty;
	
	private double productPrice;
	
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate purchaseDate;
	private boolean offer;
	
}
