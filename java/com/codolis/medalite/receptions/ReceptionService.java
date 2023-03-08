package com.codolis.medalite.receptions;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codolis.medalite.doctors.DoctorService;
import com.codolis.medalite.medical_services.MedServiceService;
import com.codolis.medalite.patients.PatientService;

@Service
public class ReceptionService {
	@Autowired
	ReceptionRepository receptionRepository;
	@Autowired
	PatientService patientService;
	@Autowired 
	DoctorService doctorService;
	@Autowired
	MedServiceService medServiceService;
	
	boolean IsOkToCreate(Reception rec) {
		boolean b = true;
		
		b = b & (rec.getReceptionDoctor() != null)
			& (rec.getReceptionPatient() != null)
			& (rec.getReceptionMedService() != null)
			& (rec.getReceptionTime() != null)
			& (rec.getReceptionIsLocked() != null);
		
		return b;
	}
	
	//create 
	public Reception createReception(ReceptionV2 rec2) {
		Reception rec = new Reception();
		
		rec.setReceptionPatient(patientService.getPatient(rec2.receptionPatient));
		rec.setReceptionDoctor(doctorService.getDoctor(rec2.receptionDoctor));
		rec.setReceptionMedService(medServiceService.getService(rec2.receptionMedService));
		rec.setReceptionTime(rec2.receptionTime);
		rec.setReceptionAnamnesis(rec2.receptionAnamnesis);
		rec.setReceptionConclusion(rec2.receptionConclusion);
		rec.setReceptionExpectedControlDate(rec2.receptionExpectedControlDate);
		rec.setReceptionFindings(rec2.receptionFindings);
		rec.setReceptionNotes(rec2.receptionNotes);
		rec.setReceptionIsLocked(rec2.receptionIsLocked);
		rec.setReceptionOpinion(rec2.receptionOpinion);
		rec.setReceptionSuggestedTreatment(rec2.receptionSuggestedTreatment);
		
		if (IsOkToCreate(rec)) return receptionRepository.save(rec);
		else {
			System.out.println("Prijem mora imati doktora, vreme, tip pregleda, pacijenta i opciju da li je lokovan!");
			return null;
		}
	}

	//readAll
	public List<Reception> getReceptions() {
	    return receptionRepository.findAll();
	}

	//readOne
	public Reception getReception(Long recId) {
	    return receptionRepository.findById(recId).get();
	}
	
	//delete
	public void deleteReception(Long recId) {
		Reception rec = receptionRepository.findById(recId).get();
		if (rec.getReceptionIsLocked()) {
			System.out.println("Prijem je lokovan - ne moze da se brise!");
		}
		else {
			receptionRepository.deleteById(recId);
		}
		
	}
	
	//update
	public Reception updateReception(Long recId, ReceptionV2 rec2) {
		Reception newRec = new Reception();
		
		newRec.setReceptionPatient(patientService.getPatient(rec2.receptionPatient));
		newRec.setReceptionDoctor(doctorService.getDoctor(rec2.receptionDoctor));
		newRec.setReceptionMedService(medServiceService.getService(rec2.receptionMedService));
		newRec.setReceptionTime(rec2.receptionTime);
		newRec.setReceptionAnamnesis(rec2.receptionAnamnesis);
		newRec.setReceptionConclusion(rec2.receptionConclusion);
		newRec.setReceptionExpectedControlDate(rec2.receptionExpectedControlDate);
		newRec.setReceptionFindings(rec2.receptionFindings);
		newRec.setReceptionNotes(rec2.receptionNotes);
		newRec.setReceptionIsLocked(rec2.receptionIsLocked);
		newRec.setReceptionOpinion(rec2.receptionOpinion);
		newRec.setReceptionSuggestedTreatment(rec2.receptionSuggestedTreatment);
		
		Reception rec = receptionRepository.findById(recId).get();
		if (!rec.getReceptionIsLocked()) {
			if (IsOkToCreate(newRec)) {
			    rec.setReceptionPatient(newRec.getReceptionPatient());
			    rec.setReceptionDoctor(newRec.getReceptionDoctor());
			    rec.setReceptionMedService(newRec.getReceptionMedService());
			    rec.setReceptionTime(newRec.getReceptionTime());
			    rec.setReceptionAnamnesis(newRec.getReceptionAnamnesis());
			    rec.setReceptionOpinion(newRec.getReceptionOpinion());
			    rec.setReceptionSuggestedTreatment(newRec.getReceptionSuggestedTreatment());
			    rec.setReceptionFindings(newRec.getReceptionFindings());
			    rec.setReceptionConclusion(newRec.getReceptionConclusion());
			    rec.setReceptionExpectedControlDate(newRec.getReceptionExpectedControlDate());
			    rec.setReceptionNotes(newRec.getReceptionNotes());
			    rec.setReceptionIsLocked(newRec.getReceptionIsLocked());
			    
			    return receptionRepository.save(rec);
			}
			else {
				System.out.println("Prijem mora imati doktora, vreme, tip pregleda, pacijenta i opciju da li je lokovan!");
				return null;
			}	    
		}
		else {
			System.out.println("Prijem je lokovan - ne moze da se azurira!");
			return null;
		}
		
	}
}
