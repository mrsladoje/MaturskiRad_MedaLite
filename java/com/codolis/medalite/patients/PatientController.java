package com.codolis.medalite.patients;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codolis.medalite.receptions.Reception;


@CrossOrigin()
@RestController
@RequestMapping("/api")
public class PatientController {
	@Autowired
	PatientService patientService;
	
	//create
	@PostMapping("/patient")
	public Patient createPatient(@RequestBody Patient pat) {
		return patientService.createPatient(pat);
	}
	
	//readAll
	@GetMapping("/patients")
	public List<Patient> getPatients() {
		return patientService.getPatients();
	}
	
	//readOne
	@GetMapping("/patient/{patId}")
	public Patient getPatient(@PathVariable(value="patId") Long patId) {
		return patientService.getPatient(patId);
	}
	
	//readPatientReceptions
	@GetMapping("/patient/{patId}/receptions")
	public List<Reception> getPatientReceptions(@PathVariable(value="patId") Long patId) {
		return patientService.getPatientReceptions(patId);
	}
	
	//delete
	@DeleteMapping("/patient/{patId}")
	public void deletePatient(@PathVariable(value="patId") Long patId) {
		patientService.deletePatient(patId);
	}
	
	//update
	@PutMapping("/patient/{patId}")
	public Patient updatePatient(@PathVariable(value="patId") Long patId, @RequestBody Patient newPat) {
		return patientService.updatePatient(patId, newPat);
	}

}
