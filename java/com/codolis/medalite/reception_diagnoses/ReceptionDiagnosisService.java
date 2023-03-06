package com.codolis.medalite.reception_diagnoses;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codolis.medalite.diagnoses.DiagnosisService;
import com.codolis.medalite.receptions.ReceptionService;


@Service
public class ReceptionDiagnosisService {
	@Autowired
	ReceptionDiagnosisRepository recdiagnosisRepository;
	@Autowired
	ReceptionService receptionService;
	@Autowired
	DiagnosisService diagnosisService;
	
	boolean IsOkToCreate(ReceptionDiagnosis recdiag) {
		boolean b = true;
		
		b = b & (recdiag.getReceptionDiagnosisReception() != null)
			& (recdiag.getReceptionDiagnosisDiagnosis() != null);
		
		return b;
	}
	
	//create 
	public ReceptionDiagnosis createReceptionDiagnosis(ReceptionDiagnosisV2 recDiag2) {
		ReceptionDiagnosis recDiag = new ReceptionDiagnosis();
		
		recDiag.setReceptionDiagnosisReception(receptionService.getReception(recDiag2.receptionDiagnosisReception));
		recDiag.setReceptionDiagnosisDiagnosis(diagnosisService.getDiagnosis(recDiag2.receptionDiagnosisDiagnosis));		
		
		if (IsOkToCreate(recDiag)) return recdiagnosisRepository.save(recDiag);
		else {
			System.out.println("Dijagnoza pri prijemu mora imati identifikator prijema i dijagnoze!");
			return null;
		}
	}

	//readAll
	public List<ReceptionDiagnosis> getReceptionDiagnoses() {
	    return recdiagnosisRepository.findAll();
	}

	//readOne
	public ReceptionDiagnosis getReceptionDiagnosis(Long recdiagId) {
	    return recdiagnosisRepository.findById(recdiagId).get();
	}
	
	//delete
	public void deleteReceptionDiagnosis(Long recdiagId) {
		if (recdiagnosisRepository.findById(recdiagId).get().getReceptionDiagnosisReception().getReceptionIsLocked()) {
			System.out.println("Ne moze da se brise dijagnoza pri pregledu jer jer pregled lokovan.");
		}
		else {
			recdiagnosisRepository.deleteById(recdiagId);
		}
	}
	
	//update
	public ReceptionDiagnosis updateReceptionDiagnosis(Long recdiagId, ReceptionDiagnosisV2 newRecDiag2) {
		if (recdiagnosisRepository.findById(recdiagId).get().getReceptionDiagnosisReception().getReceptionIsLocked()) {
			System.out.println("Ne moze da se azurira dijagnoza pri pregledu jer jer pregled lokovan.");
			return null;
		}
		else {
			ReceptionDiagnosis newRecDiag = new ReceptionDiagnosis();
			
			newRecDiag.setReceptionDiagnosisReception(receptionService.getReception(newRecDiag2.receptionDiagnosisReception));
			newRecDiag.setReceptionDiagnosisDiagnosis(diagnosisService.getDiagnosis(newRecDiag2.receptionDiagnosisDiagnosis));
			
			if (IsOkToCreate(newRecDiag)) {
			    ReceptionDiagnosis currRecDiag = recdiagnosisRepository.findById(recdiagId).get();
			    
			    currRecDiag.setReceptionDiagnosisReception(newRecDiag.getReceptionDiagnosisReception());
			    currRecDiag.setReceptionDiagnosisDiagnosis(newRecDiag.getReceptionDiagnosisDiagnosis());
			    
			    return recdiagnosisRepository.save(currRecDiag);
			}
			else {
				System.out.println("Dijagnoza pri prijemu mora imati identifikator prijema i dijagnoze!");
				return null;
			}	   
		}
		 
	}
}
