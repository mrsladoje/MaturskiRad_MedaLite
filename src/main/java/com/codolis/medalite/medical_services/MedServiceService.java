package com.codolis.medalite.medical_services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codolis.medalite.receptions.Reception;
import com.codolis.medalite.receptions.ReceptionRepository;

@Service
public class MedServiceService {
	@Autowired
		MedServiceRepository serviceRepository;
	@Autowired
		ReceptionRepository receptionRepository;
	
	boolean IsOkToCreate(MedService ser) {
		boolean b = true;
		
		b = b & (ser.getServiceName() != null);
		
		if (ser.getServiceName() != null) {
			b &= !ser.getServiceName().isEmpty();
			b &= !ser.getServiceName().isBlank();
		}
		
		return b;
	}
	
	//create 
	public MedService createService(MedService ser) {
		if (IsOkToCreate(ser)) return serviceRepository.save(ser);
		else {
			System.out.println("Servis mora imati ime!");
			return null;
		}
	}

	//readAll
	public List<MedService> getServices() {
	    return serviceRepository.findAll();
	}

	//readOne
	public MedService getService(Long serId) {
	    return serviceRepository.findById(serId).get();
	}
	
	//delete
	public void deleteService(Long serId) {
		List<Reception> receptedMedServices = receptionRepository.findByReceptionMedServiceServiceId(serId);
		
		if (receptedMedServices.isEmpty()) {
			serviceRepository.deleteById(serId);
		}
		else {
			System.out.println("Ne moze da se brise servis jer je aktivan - bio je koristen u prijemu u ordinaciji.");
		}
	}
	
	//update
	public MedService updateService(Long serId, MedService newSer) {
		if (IsOkToCreate(newSer)) {
		    MedService currSer = serviceRepository.findById(serId).get();
		    currSer.setServiceDuration(newSer.getServiceDuration());
		    currSer.setServiceNotes(newSer.getServiceNotes());
		    currSer.setServiceName(newSer.getServiceName());
		    
		    return serviceRepository.save(currSer);
		}
		else {
			System.out.println("Servis mora imati ime!");
			return null;
		}	    
	}
}
