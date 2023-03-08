package com.codolis.medalite.clinics;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClinicService {
	@Autowired
	ClinicRepository clinicRepository;
	
	boolean IsOkToCreate(Clinic cli) {
		boolean b = true;
		
		b = b & (cli.getClinicName() != null)
			& (cli.getClinicAddress() != null)
			& (cli.getClinicPhone() != null);
		
		if (cli.getClinicName() != null) {
			b &= !cli.getClinicName().isEmpty();
			b &= !cli.getClinicName().isBlank();
		}
		if (cli.getClinicAddress() != null) {
			b &= !cli.getClinicAddress().isEmpty();
			b &= !cli.getClinicAddress().isBlank();
		}
		if (cli.getClinicPhone() != null) {
			b &= !cli.getClinicPhone().isEmpty();
			b &= !cli.getClinicPhone().isBlank();
		}
		
		return b;
	}
	
	//create 
	public Clinic createClinic(Clinic cli) {
		if (IsOkToCreate(cli)) {
			if (clinicRepository.findAll().isEmpty()) return clinicRepository.save(cli);
			else {
				System.out.print("Moze biti samo jedna klinika u sistemu!");
				return null;
			}
		}
		else {
			System.out.println("Klinika mora imati ime, adresu i telefon!");
			return null;
		}
	}

	//read
	public Clinic getClinic() {
		if (!clinicRepository.findAll().isEmpty()) return clinicRepository.findAll().get(0);
		else return null;
	}
	
	//readAsList
	public List<Clinic> getClinics() {
	    return clinicRepository.findAll();
	}
	
	//delete
	public void deleteClinic(Long cliId) {
	    clinicRepository.deleteById(cliId);
	}
	
	//update
	public Clinic updateClinic(Long cliId, Clinic newCli) {
		if (IsOkToCreate(newCli)) {
		    Clinic currCli = clinicRepository.findById(cliId).get();
		    currCli.setClinicPhone(newCli.getClinicPhone());
		    currCli.setClinicNotes(newCli.getClinicNotes());
		    currCli.setClinicName(newCli.getClinicName());
		    currCli.setClinicAddress(newCli.getClinicAddress());
		    currCli.setClinicWeb(newCli.getClinicWeb());
		    currCli.setClinicLogo(newCli.getClinicLogo());
		    
		    return clinicRepository.save(currCli);
		}
		else {
			System.out.println("Klinika mora imati ime, adresu i telefon!");
			return null;
		}	    
	}
}
