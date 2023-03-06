package com.codolis.medalite.medical_services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MedServiceController {
	@Autowired
	MedServiceService medServiceService;
	
	//create
	@PostMapping("/service")
	public MedService createService(@RequestBody MedService ser) {
		return medServiceService.createService(ser);
	}
	
	//readAll
	@GetMapping("/services")
	public List<MedService> getServices() {
		return medServiceService.getServices();
	}
	
	//readOne
	@GetMapping("/service/{serId}")
	public MedService getService(@PathVariable(value="serId") Long serId) {
		return medServiceService.getService(serId);
	}
	
	//delete
	@DeleteMapping("/service/{serId}")
	public void deleteService(@PathVariable(value="serId") Long serId) {
		medServiceService.deleteService(serId);
	}
	
	//update
	@PutMapping("/service/{serId}")
	public MedService updateService(@PathVariable(value="serId") Long serId, @RequestBody MedService newSer) {
		return medServiceService.updateService(serId, newSer);
	}

}
