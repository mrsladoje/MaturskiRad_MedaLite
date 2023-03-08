package com.codolis.medalite.reception_diagnoses;

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
public class ReceptionDiagnosisController {
	@Autowired
	ReceptionDiagnosisService receptiondiagnosisService;
	
	//create
	@PostMapping("/reception/diagnosis")
	public ReceptionDiagnosis createReceptionDiagnosis(@RequestBody ReceptionDiagnosisV2 recDiag) {
		return receptiondiagnosisService.createReceptionDiagnosis(recDiag);
	}
	
	//readAll
	@GetMapping("/reception/diagnoses")
	public List<ReceptionDiagnosis> getReceptionDiagnoses() {
		return receptiondiagnosisService.getReceptionDiagnoses();
	}
	
	//readOne
	@GetMapping("/reception/diagnosis/{recDiagId}")
	public ReceptionDiagnosis getReceptionDiagnosis(@PathVariable(value="recDiagId") Long recDiagId) {
		return receptiondiagnosisService.getReceptionDiagnosis(recDiagId);
	}
	
	//delete
	@DeleteMapping("/reception/diagnosis/{recDiagId}")
	public void deleteReceptionDiagnosis(@PathVariable(value="recDiagId") Long recDiagId) {
		receptiondiagnosisService.deleteReceptionDiagnosis(recDiagId);
	}
	
	//update
	@PutMapping("/reception/diagnosis/{recDiagId}")
	public ReceptionDiagnosis updateReceptionDiagnosis(@PathVariable(value="recDiagId") Long recDiagId, @RequestBody ReceptionDiagnosisV2 newRecDiag) {
		
		return receptiondiagnosisService.updateReceptionDiagnosis(recDiagId, newRecDiag);
	}
}
