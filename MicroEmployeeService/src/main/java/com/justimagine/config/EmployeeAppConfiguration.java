package com.justimagine.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class EmployeeAppConfiguration {

	@Bean
	public ModelMapper getModelMapper()
	{
		
		
		return new ModelMapper();
	}
	
//	@Bean
//	public RestTemplate getRestTemplate()
//	{
//		
//		
//		return new RestTemplate();
//	}
}
