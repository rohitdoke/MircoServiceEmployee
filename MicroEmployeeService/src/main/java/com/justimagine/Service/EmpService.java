package com.justimagine.Service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.justimagine.Entity.Employee;
import com.justimagine.Repo.EmployeeRepo;
import com.justimagine.Response.AddressResponse;
import com.justimagine.Response.EmployeeResponse;

@Service
public class EmpService implements EmpServiceInterface {

	@Autowired
	private EmployeeRepo empRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
//	@Autowired
	private RestTemplate restTemplate;
	
	//@Value("${addressservice.base.url}")
	//private String addressBaseURL;
	
	public EmpService(@Value("${addressservice.base.url}") String addressBaseURL,
								RestTemplateBuilder builder) {
		
		
		this.restTemplate = builder.rootUri(addressBaseURL)
				.build();
	}	
	
	
	@Override
	public EmployeeResponse getEmployeeById(Integer id)
	{
		
			Employee emp = empRepo.findById(id).orElseThrow();
			
		
			EmployeeResponse empResponse = modelMapper.map(emp, EmployeeResponse.class);
			
			
		
			AddressResponse addressResponse = restTemplate.getForObject("/address/{employeeid}", AddressResponse.class,id );
			empResponse.setAddressresponse(addressResponse);
			return empResponse;
		
	}

	

}