package com.local.microservices.NAGPAggregatorService;

import org.springframework.web.bind.annotation.GetMapping;

import feign.Param;
import feign.RequestLine;

//@FeignClient(/* name = "${user.service.url:user-details}", */ value="user-details"/*, url="${user.service.url}"*/)
//@RibbonClient("user-details")
//@Component
//@Scope("prototype")
public interface UserServiceProxy {
	
//	@GetMapping("/user/{id}")
	@RequestLine("GET /user/{id}")
	public User getUser(/* @PathVariable */ @Param("id") long id);
}
