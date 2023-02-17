package com.codolis.medalite.diagnoses;

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
public class DiagnosisController {
	@Autowired
	DiagnosisService diagnosisService;
	
	//create
	@PostMapping("/diagnosis")
	public Diagnosis createDiagnosis(@RequestBody Diagnosis diag) {
		return diagnosisService.createDiagnosis(diag);
	}
	
	//readAll
	@GetMapping("/diagnoses")
	public List<Diagnosis> getDiagnoses() {
		return diagnosisService.getDiagnoses();
	}
	
	//readOne
	@GetMapping("/diagnosis/{diagId}")
	public Diagnosis getDiagnosis(@PathVariable(value="diagId") Long diagId) {
		return diagnosisService.getDiagnosis(diagId);
	}
	
	//delete
	@DeleteMapping("/diagnosis/{diagId}")
	public void deleteDiagnosis(@PathVariable(value="diagId") Long diagId) {
		diagnosisService.deleteDiagnosis(diagId);
	}
	
	//update
	@PutMapping("/diagnosis/{diagId}")
	public Diagnosis updateDiagnosis(@PathVariable(value="diagId") Long diagId, @RequestBody Diagnosis newDiag) {
		return diagnosisService.updateDiagnosis(diagId, newDiag);
	}
}
