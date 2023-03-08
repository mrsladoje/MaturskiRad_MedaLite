package com.codolis.medalite.patients;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codolis.medalite.receptions.Reception;
import com.codolis.medalite.receptions.ReceptionRepository;


@Service
public class PatientService {
	@Autowired
		PatientRepository patientRepository;
	@Autowired
		ReceptionRepository receptionRepository;

	boolean IsOkToCreate(Patient pat) {
		boolean b = true;
		
		b = b & (pat.getPatientName() != null)
			& (pat.getPatientSurname() != null)
			& (pat.getPatientParentName() != null)
			& (pat.getPatientMbNo() != null)
			& (pat.getPatientEvidentionCode() != null);
		
		if (pat.getPatientName() != null) {
			b &= !pat.getPatientName().isEmpty();
			b &= !pat.getPatientName().isBlank();
		}
		if (pat.getPatientSurname() != null) {
			b &= !pat.getPatientSurname().isEmpty();
			b &= !pat.getPatientSurname().isBlank();
		}
		if (pat.getPatientParentName() != null) {
			b &= !pat.getPatientParentName().isEmpty();
			b &= !pat.getPatientParentName().isBlank();
		}
		if (pat.getPatientMbNo() != null) {
			b &= !pat.getPatientMbNo().isEmpty();
			b &= !pat.getPatientMbNo().isBlank();
		}
		if (pat.getPatientEvidentionCode() != null) {
			b &= !pat.getPatientEvidentionCode().isEmpty();
			b &= !pat.getPatientEvidentionCode().isBlank();
		}
		
		return b;
	}
	
	//create 
	public Patient createPatient(Patient pat) {
		if (IsOkToCreate(pat)) return patientRepository.save(pat);
		else {
			System.out.println("Pacijent mora imati ime, prezime, ime roditelja, maticni broj gradjana i evidencioni kod!");
			return null;
		}
	}

	//readAll
	public List<Patient> getPatients() {
	    return patientRepository.findAll();
	}

	//readOne
	public Patient getPatient(Long patId) {
	    return patientRepository.findById(patId).get();
	}
	
	//readPatientReceptions
	public List<Reception> getPatientReceptions(Long patId) {
		return receptionRepository.findByReceptionPatientPatientId(patId);
	}
	
	//delete
	public void deletePatient(Long patId) {
		List<Reception> receptedPatients = receptionRepository.findByReceptionPatientPatientId(patId);
		
		if (receptedPatients.isEmpty()) {
			patientRepository.deleteById(patId);
		}
		else {
			System.out.println("Ne moze da se obrise pacijent - aktivan je, tj. bio je primljen u ordinaciju.");
		}
	}
	
	//update
	public Patient updatePatient(Long patId, Patient newPat) {
		if (IsOkToCreate(newPat)) {
			Patient currPat = patientRepository.findById(patId).get();
		    currPat.setPatientName(newPat.getPatientName());
		    currPat.setPatientSurname(newPat.getPatientSurname());
		    currPat.setPatientParentName(newPat.getPatientParentName());
		    currPat.setPatientBirthdate(newPat.getPatientBirthdate());
		    currPat.setPatientPlaceOfBirth(newPat.getPatientPlaceOfBirth());
		    currPat.setPatientMbNo(newPat.getPatientMbNo());
		    currPat.setPatientPhone(newPat.getPatientPhone());
		    currPat.setPatientEmail(newPat.getPatientEmail());
		    currPat.setPatientEvidentionCode(newPat.getPatientEvidentionCode());
		    currPat.setPatientAddress(newPat.getPatientAddress());
		    currPat.setPatientFamilyHistory(newPat.getPatientFamilyHistory());
		    currPat.setPatientCurrentDiseases(newPat.getPatientCurrentDiseases());
		    currPat.setPatientAllergens(newPat.getPatientAllergens());
		    currPat.setPatientNotes(newPat.getPatientNotes());
		    
		    return patientRepository.save(currPat);
		}
		else {
			System.out.println("Pacijent mora imati ime, prezime, ime roditelja, maticni broj gradjana i evidencioni kod!");
			return null;
		}	    
	}
}
