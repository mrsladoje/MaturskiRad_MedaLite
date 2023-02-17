package com.codolis.medalite.doctors;

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
public class DoctorController {
	@Autowired
	DoctorService doctorService;
	
	//create
	@PostMapping("/doctor")
	public Doctor createDoctor(@RequestBody Doctor doc) {
		return doctorService.createDoctor(doc);
	}
	
	//readAll
	@GetMapping("/doctors")
	public List<Doctor> getDoctors() {
		return doctorService.getDoctors();
	}
	
	//readOne
	@GetMapping("/doctor/{docId}")
	public Doctor getDoctor(@PathVariable(value="docId") Long docId) {
		return doctorService.getDoctor(docId);
	}
	
	//delete
	@DeleteMapping("/doctor/{docId}")
	public void deleteDoctor(@PathVariable(value="docId") Long docId) {
		doctorService.deleteDoctor(docId);
	}
	
	//update
	@PutMapping("/doctor/{docId}")
	public Doctor updateDoctor(@PathVariable(value="docId") Long docId, @RequestBody Doctor newDoc) {
		return doctorService.updateDoctor(docId, newDoc);
	}

}
