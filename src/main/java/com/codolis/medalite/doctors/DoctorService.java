package com.codolis.medalite.doctors;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codolis.medalite.receptions.Reception;
import com.codolis.medalite.receptions.ReceptionRepository;

@Service
public class DoctorService {
	@Autowired
		DoctorRepository doctorRepository;
	@Autowired
		ReceptionRepository receptionRepository;
	
	boolean IsOkToCreate(Doctor doc) {
		boolean b = true;
		
		b = b & (doc.getDoctorName() != null)
			& (doc.getDoctorTitle() != null)
			& (doc.getDoctorSpec() != null)
			& (doc.getDoctorUsername() != null)
			& (doc.getDoctorPassword() != null);
		
		if (doc.getDoctorName() != null) {
			b &= !doc.getDoctorName().isEmpty();
			b &= !doc.getDoctorName().isBlank();
		}
		if (doc.getDoctorTitle() != null) {
			b &= !doc.getDoctorTitle().isEmpty();
			b &= !doc.getDoctorTitle().isBlank();
		}
		if (doc.getDoctorSpec() != null) {
			b &= !doc.getDoctorSpec().isEmpty();
			b &= !doc.getDoctorSpec().isBlank();
		}
		if (doc.getDoctorUsername() != null) {
			b &= !doc.getDoctorUsername().isEmpty();
			b &= !doc.getDoctorUsername().isBlank();
		}
		if (doc.getDoctorPassword() != null) {
			b &= !doc.getDoctorPassword().isEmpty();
			b &= !doc.getDoctorPassword().isBlank();
		}
		
		return b;
	}
	
	//create 
	public Doctor createDoctor(Doctor doc) {
		if (IsOkToCreate(doc)) return doctorRepository.save(doc);
		else {
			System.out.println("Doktor mora imati ime, zvanje, specijalizaciju, korisnicko ime i sifru!");
			return null;
		}
	}

	//readAll
	public List<Doctor> getDoctors() {
	    return doctorRepository.findAll();
	}

	//readOne
	public Doctor getDoctor(Long docId) {
	    return doctorRepository.findById(docId).get();
	}
	
	//delete
	public void deleteDoctor(Long docId) {
		List<Reception> doctorsReceptors = receptionRepository.findByReceptionDoctorDoctorId(docId);
		
		if (doctorsReceptors.isEmpty()) {
			doctorRepository.deleteById(docId);
		}
		else {
			System.out.println("Doktor se ne moze brisati - vrsio je preglede vec u ordinaciji.");
		}
	}
	
	//update
	public Doctor updateDoctor(Long docId, Doctor newDoc) {
		if (IsOkToCreate(newDoc)) {
			Doctor currDoc = doctorRepository.findById(docId).get();
		    currDoc.setDoctorName(newDoc.getDoctorName());
		    currDoc.setDoctorTitle(newDoc.getDoctorTitle());
		    currDoc.setDoctorSpec(newDoc.getDoctorSpec());
		    currDoc.setDoctorAddress(newDoc.getDoctorAddress());
		    currDoc.setDoctorPhone(newDoc.getDoctorPhone());
		    currDoc.setDoctorEmail(newDoc.getDoctorEmail());
		    currDoc.setDoctorUsername(newDoc.getDoctorUsername());
		    currDoc.setDoctorPassword(newDoc.getDoctorPassword());
		    currDoc.setDoctorNotes(newDoc.getDoctorNotes());
		    
		    return doctorRepository.save(currDoc);
		}
		else {
			System.out.println("Doktor mora imati ime, zvanje, specijalizaciju, korisnicko ime i sifru!");
			return null;
		}	    
	}

}
