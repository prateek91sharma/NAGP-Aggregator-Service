package com.local.microservices.NAGPAggregatorService;

import java.text.ParseException;
import java.util.List;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(/* name = "${order.service.url:orders-service}", */ value="orders-service" /*, url="${order.service.url}"*/)
@RibbonClient("orders-service")
@Component
@Scope("prototype")
public interface OrderServiceProxy {
	
	@GetMapping("/orders/{userId}")
	public List<Order> getOrderForUser(@PathVariable Long userId) throws ParseException;
}
