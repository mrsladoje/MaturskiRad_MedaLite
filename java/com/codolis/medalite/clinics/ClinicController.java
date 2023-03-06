package com.codolis.medalite.clinics;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin()
@RestController
@RequestMapping("/api")
public class ClinicController {
	@Autowired
	ClinicService clinicService;
	
	//create
	@PostMapping("/clinic")
	public Clinic createClinic(@RequestBody Clinic cli) {
		return clinicService.createClinic(cli);
	}
	
	//read
	@GetMapping("/clinic")
	public ClinicV2 getClinics() {
		if (!clinicService.getClinics().isEmpty()) {
			ClinicV2 cli = new ClinicV2();
			Clinic cli1 = clinicService.getClinic();
			cli.clinicId = cli1.getClinicId();
			cli.clinicAddress = cli1.getClinicAddress();
			cli.clinicName = cli1.getClinicName();
			cli.clinicNotes = cli1.getClinicPhone();
			cli.clinicWeb = cli1.getClinicWeb();
			cli.clinicPhone = cli1.getClinicPhone();
			cli.clinicLogo = Base64.getEncoder().encodeToString(cli1.getClinicLogo());
			return cli;
		}
		else {
			System.out.println("Nije dodata nijedna klinika!");
			return null;
		}
		
	}
	
	//delete
	@DeleteMapping("/clinic")
	public void deleteClinic() {
		if (!clinicService.getClinics().isEmpty()) {
			Long cliId = clinicService.getClinics().get(0).getClinicId();
			clinicService.deleteClinic(cliId);
		}
		else {
			System.out.println("Nije dodata nijedna klinika - nema sta da se obrise!");
		}
	}
	
	//update
	@PutMapping("/clinic")
	public Clinic updateClinic(@RequestBody Clinic newCli) {
		if (!clinicService.getClinics().isEmpty()) {
			Long cliId = clinicService.getClinics().get(0).getClinicId();
			return clinicService.updateClinic(cliId, newCli);
		}
		else {
			System.out.println("Nije dodata nijedna klinika - nema sta da se azurira!");
			return null;
		}
	}
}
