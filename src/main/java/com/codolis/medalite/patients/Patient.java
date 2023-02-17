package com.codolis.medalite.patients;

import java.util.HashSet;
import java.util.Set;

import com.codolis.medalite.receptions.Reception;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="tblpatients")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Patient {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="PatientID", nullable=false)
        private Long patientId;
    
    @Column(name="Name", nullable=false)
        private String patientName;
    
    @Column(name="Surname", nullable=false)
	     private String patientSurname;
  
    @Column(name="ParentName", nullable=false)
        private String patientParentName;
    
    @Column(name="Birthdate")
        private String patientBirthdate;
    
    @Column(name="PlaceOfBirth")
        private String patientPlaceOfBirth;
    
    @Column(name="MbNo", nullable=false)
        private String patientMbNo;
    
    @Column(name="Phone")
        private String patientPhone;
    
    @Column(name="Email")
        private String patientEmail;

    @Column(name="EvidentionCode", nullable=false)
    	private String patientEvidentionCode;

    @Column(name="Address")
    	private String patientAddress;
    
    @Lob
    @Column(name="FamilyHistory")
    	  private String patientFamilyHistory;
	
    @Lob
    @Column(name="CurrentDiseases")
    	  private String patientCurrentDiseases;
	
    @Lob
    @Column(name="Allergens")
    	  private String patientAllergens;
	
    @Lob
    @Column(name="Notes")
    	  private String patientNotes;

    @OneToMany(mappedBy="receptionPatient")
    	private Set<Reception> patientReceptions = new HashSet<>();
    
	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getPatientSurname() {
		return patientSurname;
	}

	public void setPatientSurname(String patientSurname) {
		this.patientSurname = patientSurname;
	}

	public String getPatientParentName() {
		return patientParentName;
	}

	public void setPatientParentName(String patientParentName) {
		this.patientParentName = patientParentName;
	}

	public String getPatientBirthdate() {
		return patientBirthdate;
	}

	public void setPatientBirthdate(String patientBirthdate) {
		this.patientBirthdate = patientBirthdate;
	}

	public String getPatientPlaceOfBirth() {
		return patientPlaceOfBirth;
	}

	public void setPatientPlaceOfBirth(String patientPlaceOfBirth) {
		this.patientPlaceOfBirth = patientPlaceOfBirth;
	}

	public String getPatientMbNo() {
		return patientMbNo;
	}

	public void setPatientMbNo(String patientMbNo) {
		this.patientMbNo = patientMbNo;
	}

	public String getPatientPhone() {
		return patientPhone;
	}

	public void setPatientPhone(String patientPhone) {
		this.patientPhone = patientPhone;
	}

	public String getPatientEmail() {
		return patientEmail;
	}

	public void setPatientEmail(String patientEmail) {
		this.patientEmail = patientEmail;
	}

	public String getPatientEvidentionCode() {
		return patientEvidentionCode;
	}

	public void setPatientEvidentionCode(String patientEvidentionCode) {
		this.patientEvidentionCode = patientEvidentionCode;
	}

	public String getPatientAddress() {
		return patientAddress;
	}

	public void setPatientAddress(String patientAddress) {
		this.patientAddress = patientAddress;
	}

	public String getPatientFamilyHistory() {
		return patientFamilyHistory;
	}

	public void setPatientFamilyHistory(String patientFamilyHistory) {
		this.patientFamilyHistory = patientFamilyHistory;
	}

	public String getPatientCurrentDiseases() {
		return patientCurrentDiseases;
	}

	public void setPatientCurrentDiseases(String patientCurrentDiseases) {
		this.patientCurrentDiseases = patientCurrentDiseases;
	}

	public String getPatientAllergens() {
		return patientAllergens;
	}

	public void setPatientAllergens(String patientAllergens) {
		this.patientAllergens = patientAllergens;
	}

	public String getPatientNotes() {
		return patientNotes;
	}

	public void setPatientNotes(String patientNotes) {
		this.patientNotes = patientNotes;
	}
	
}
