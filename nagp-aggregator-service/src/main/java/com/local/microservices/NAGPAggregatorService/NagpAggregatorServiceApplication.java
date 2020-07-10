package com.local.microservices.NAGPAggregatorService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
//@EnableFeignClients("com.local.microservices.NAGPAggregatorService")
public class NagpAggregatorServiceApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(NagpAggregatorServiceApplication.class, args);
	}

//    @Bean
//    public OkHttpClient client() {
//        return new OkHttpClient();
//    }
//    
//    @Bean
//	public Contract feignContract() {
//		return new Contract.Default();
//	}
    
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
	
}
