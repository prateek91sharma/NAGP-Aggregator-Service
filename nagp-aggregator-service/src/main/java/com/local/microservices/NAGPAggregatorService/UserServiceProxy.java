package com.local.microservices.NAGPAggregatorService;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(/* name = "${user.service.url:user-details}", */ value="user-details"/*, url="${user.service.url}"*/)
public interface UserServiceProxy {
	
	@GetMapping("/user/{id}")
	public User getUser(@PathVariable long id);
}
