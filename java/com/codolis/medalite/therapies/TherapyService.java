package com.codolis.medalite.therapies;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TherapyService {
	@Autowired
	TherapyRepository therapyRepository;
	
	boolean IsOkToCreate(Therapy ther) {
		boolean b = true;
		
		b = b & (ther.getTherapyName() != null);
		
		if (ther.getTherapyName() != null) {
			b &= !ther.getTherapyName().isEmpty();
			b &= !ther.getTherapyName().isBlank();
		}
		
		return b;
	}
	
	//create 
	public Therapy createTherapy(Therapy ther) {
		if (IsOkToCreate(ther)) return therapyRepository.save(ther);
		else {
			System.out.println("Terapija mora imati ime!");
			return null;
		}
	}

	//readAll
	public List<Therapy> getTherapies() {
	    return therapyRepository.findAll();
	}

	//readOne
	public Therapy getTherapy(Long therId) {
	    return therapyRepository.findById(therId).get();
	}
	
	//delete
	public void deleteTherapy(Long therId) {
	    therapyRepository.deleteById(therId);
	}
	
	//update
	public Therapy updateTherapy(Long therId, Therapy newTher) {
		if (IsOkToCreate(newTher)) {
		    Therapy currTher = therapyRepository.findById(therId).get();
		    currTher.setTherapyCode(newTher.getTherapyCode());
		    currTher.setTherapyDescription(newTher.getTherapyDescription());
		    currTher.setTherapyName(newTher.getTherapyName());
		    currTher.setTherapyGenericName(newTher.getTherapyGenericName());
		    
		    return therapyRepository.save(currTher);
		}
		else {
			System.out.println("Terapija mora imati ime!");
			return null;
		}	    
	}
}
