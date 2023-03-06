package com.codolis.medalite.diagnoses;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codolis.medalite.reception_diagnoses.ReceptionDiagnosis;
import com.codolis.medalite.reception_diagnoses.ReceptionDiagnosisRepository;

@Service
public class DiagnosisService {
	@Autowired
		DiagnosisRepository diagnosisRepository;
	@Autowired
		ReceptionDiagnosisRepository rdRepo;
	
	boolean IsOkToCreate(Diagnosis diag) {
		boolean b = true;
		
		b = b & (diag.getDiagnosisName() != null)
			& (diag.getDiagnosisCode() != null)
			& (diag.getDiagnosisDescription() != null);
		
		if (diag.getDiagnosisName() != null) {
			b &= !diag.getDiagnosisName().isEmpty();
			b &= !diag.getDiagnosisName().isBlank();
		}
		if (diag.getDiagnosisCode() != null) {
			b &= !diag.getDiagnosisCode().isEmpty();
			b &= !diag.getDiagnosisCode().isBlank();
		}
		
		return b;
	}
	
	//create 
	public Diagnosis createDiagnosis(Diagnosis diag) {
		if (IsOkToCreate(diag)) return diagnosisRepository.save(diag);
		else {
			System.out.println("Dijagnoza mora imati ime i kod!");
			return null;
		}
	}

	//readAll
	public List<Diagnosis> getDiagnoses() {
	    return diagnosisRepository.findAll();
	}

	//readOne
	public Diagnosis getDiagnosis(Long diagId) {
	    return diagnosisRepository.findById(diagId).get();
	}
	
	//delete
	public void deleteDiagnosis(Long diagId) {
		List<ReceptionDiagnosis> receptedDiagnoses = rdRepo.findByReceptionDiagnosisDiagnosisDiagnosisId(diagId);
		
		if (receptedDiagnoses.isEmpty()) {
		    diagnosisRepository.deleteById(diagId);
		}
		else {
			System.out.println("Ne moze da se brise dijagnoza - bila je ustanovljena na pregledu.");
		}
	}
	
	//update
	public Diagnosis updateDiagnosis(Long diagId, Diagnosis newDiag) {
		if (IsOkToCreate(newDiag)) {
		    Diagnosis currDiag = diagnosisRepository.findById(diagId).get();
		    currDiag.setDiagnosisCode(newDiag.getDiagnosisCode());
		    currDiag.setDiagnosisDescription(newDiag.getDiagnosisDescription());
		    currDiag.setDiagnosisName(newDiag.getDiagnosisName());
		    
		    return diagnosisRepository.save(currDiag);
		}
		else {
			System.out.println("Dijagnoza mora imati ime i kod!");
			return null;
		}	    
	}
}
