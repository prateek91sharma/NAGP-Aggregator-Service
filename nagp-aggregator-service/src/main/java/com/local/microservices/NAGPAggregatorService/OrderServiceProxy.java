package com.local.microservices.NAGPAggregatorService;

import java.text.ParseException;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

import feign.Param;
import feign.RequestLine;

//@FeignClient(/* name = "${order.service.url:orders-service}", */ value="orders-service" /*, url="${order.service.url}"*/)
//@RibbonClient("orders-service")
//@Component
//@Scope("prototype")
public interface OrderServiceProxy {
	
//	@GetMapping("/orders/{userId}")
    @RequestLine("GET /orders/{userId}")
	public List<Order> getOrderForUser(/* @PathVariable */ @Param("userId") Long userId) throws ParseException;
}
