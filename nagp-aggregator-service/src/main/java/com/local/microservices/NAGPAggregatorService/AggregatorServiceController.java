package com.local.microservices.NAGPAggregatorService;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class AggregatorServiceController {

	@Autowired
	RestTemplate restTemplate;
	
//	UserServiceProxy userService;
//	
//	OrderServiceProxy orderService;
//
//	@Autowired
//	public AggregatorServiceController(Client client, Tracer tracer, Contract contract) {
////		userService=Feign.builder().client(new TracingClient(client, tracer)).target(UserServiceProxy.class, "http://user-details");
//		orderService = Feign.builder().encoder(new JacksonEncoder()).decoder(new JacksonDecoder())
//				.client(new TracingClient(client, tracer)).contract(contract).target(OrderServiceProxy.class,
//		/* "http://orders-service", */"http://localhost:8081");
//
//	}
//	
//	
	
@GetMapping("/orderdetails/{id}")
public OrderDetail getOrderDetails(@PathVariable long id) throws ParseException
{
	OrderDetail orderDetail=new OrderDetail();
	//Commenting Feign Impl due to Jaeger
//	User user=userService.getUser(id);
//	List<Order> orders =orderService.getOrderForUser(id);
	Map<String,String> map=new HashMap<>();
	map.put("id", String.valueOf(id));
	
	String userDetailsURL = UriComponentsBuilder.fromHttpUrl("http://user-details/user/{id}").buildAndExpand(map).toUriString();
	String orderURL = UriComponentsBuilder.fromHttpUrl("http://orders-service/orders/{id}").buildAndExpand(map).toUriString();
	User user=restTemplate.getForEntity(userDetailsURL, User.class).getBody();
	List<Order> orders =restTemplate.getForEntity(orderURL, List.class).getBody();
	orderDetail.setUser(user);
	orderDetail.setOrders(orders);
	return orderDetail;
}


}
