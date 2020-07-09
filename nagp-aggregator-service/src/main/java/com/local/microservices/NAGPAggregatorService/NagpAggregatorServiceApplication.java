package com.local.microservices.NAGPAggregatorService;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableFeignClients("com.local.microservices.NAGPAggregatorService")
public class NagpAggregatorServiceApplication {
	
	@Autowired
	UserServiceProxy userService;
	
	@Autowired
	OrderServiceProxy orderService;

	public static void main(String[] args) {
		SpringApplication.run(NagpAggregatorServiceApplication.class, args);
	}
	
@GetMapping("/orderdetails/{id}")
public OrderDetail getOrderDetails(@PathVariable long id) throws ParseException
{
	OrderDetail orderDetail=new OrderDetail();
	User user=userService.getUser(id);
	List<Order> orders =orderService.getOrderForUser(id);
	orderDetail.setUser(user);
	orderDetail.setOrders(orders);
	return orderDetail;
}

}
