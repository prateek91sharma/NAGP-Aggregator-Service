package com.local.microservices.NAGPAggregatorService;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(/* name = "${user.service.url:user-details}", */ value="user-details"/*, url="${user.service.url}"*/)
@RibbonClient("user-details")
@Component
@Scope("prototype")
public interface UserServiceProxy {
	
	@GetMapping("/user/{id}")
	public User getUser(@PathVariable long id);
}
