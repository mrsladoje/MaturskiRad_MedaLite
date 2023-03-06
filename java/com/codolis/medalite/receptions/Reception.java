package com.codolis.medalite.receptions;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import com.codolis.medalite.doctors.Doctor;
import com.codolis.medalite.medical_services.MedService;
import com.codolis.medalite.patients.Patient;
import com.codolis.medalite.reception_diagnoses.ReceptionDiagnosis;
import com.codolis.medalite.reception_documents.ReceptionDocument;
import com.codolis.medalite.reception_therapies.ReceptionTherapy;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="tblreceptions")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Reception {
	 @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name="ReceptionID", nullable=false)
         private Long receptionId;

	 @ManyToOne(fetch = FetchType.LAZY, optional=false)
	 @JoinColumn(name="PatientID")
     	private Patient receptionPatient;
 
	 @ManyToOne(fetch = FetchType.LAZY, optional=false)
	 @JoinColumn(name="DoctorID")
     	private Doctor receptionDoctor;
 
	 @ManyToOne(fetch = FetchType.LAZY, optional=false)
	 @JoinColumn(name="ServiceID")
     	private MedService receptionMedService;
 
     @Column(name="ReceptionTime", nullable=false)
         private LocalDateTime receptionTime;
     
     @Lob
     @Column(name="Anamnesis")
 	     private String receptionAnamnesis;
   
     @Lob
     @Column(name="Opinion")
         private String receptionOpinion;
     
     @Lob
     @Column(name="SuggestedTreatment")
         private String receptionSuggestedTreatment;
     
     @Lob
     @Column(name="Findings")
         private String receptionFindings;
     
     @Lob
     @Column(name="Conclusion")
         private String receptionConclusion;
     
     @Column(name="ExpectedControlDate")
         private LocalDate receptionExpectedControlDate;
     
     @Lob
     @Column(name="Notes")
         private String receptionNotes;
 
     @Column(name="IsLocked", nullable=false)
     	  private Boolean receptionIsLocked;
     
     @OneToMany(mappedBy="receptionDiagnosisReception", cascade=CascadeType.REMOVE)
     	private Set<ReceptionDiagnosis> receptionReceptionDiagnoses = new HashSet<>();
     
     @OneToMany(mappedBy="receptionTherapyReception", cascade=CascadeType.REMOVE)
     	private Set<ReceptionTherapy> receptionReceptionTherapies = new HashSet<>();

     @OneToMany(mappedBy="receptionDocumentReception", cascade=CascadeType.REMOVE)
  		private Set<ReceptionDocument> receptionReceptionDocuments = new HashSet<>();
     
	public Long getReceptionId() {
		return receptionId;
	}

	public void setReceptionId(Long receptionId) {
		this.receptionId = receptionId;
	}

	public Patient getReceptionPatient() {
		return receptionPatient;
	}

	public void setReceptionPatient(Patient receptionPatient) {
		this.receptionPatient = receptionPatient;
	}

	public Doctor getReceptionDoctor() {
		return receptionDoctor;
	}

	public void setReceptionDoctor(Doctor receptionDoctor) {
		this.receptionDoctor = receptionDoctor;
	}

	public MedService getReceptionMedService() {
		return receptionMedService;
	}

	public void setReceptionMedService(MedService receptionMedService) {
		this.receptionMedService = receptionMedService;
	}

	public LocalDateTime getReceptionTime() {
		return receptionTime;
	}

	public void setReceptionTime(LocalDateTime receptionTime) {
		this.receptionTime = receptionTime;
	}

	public String getReceptionAnamnesis() {
		return receptionAnamnesis;
	}

	public void setReceptionAnamnesis(String receptionAnamnesis) {
		this.receptionAnamnesis = receptionAnamnesis;
	}

	public String getReceptionOpinion() {
		return receptionOpinion;
	}

	public void setReceptionOpinion(String receptionOpinion) {
		this.receptionOpinion = receptionOpinion;
	}

	public String getReceptionSuggestedTreatment() {
		return receptionSuggestedTreatment;
	}

	public void setReceptionSuggestedTreatment(String receptionSuggestedTreatment) {
		this.receptionSuggestedTreatment = receptionSuggestedTreatment;
	}

	public String getReceptionFindings() {
		return receptionFindings;
	}

	public void setReceptionFindings(String receptionFindings) {
		this.receptionFindings = receptionFindings;
	}

	public String getReceptionConclusion() {
		return receptionConclusion;
	}

	public void setReceptionConclusion(String receptionConclusion) {
		this.receptionConclusion = receptionConclusion;
	}

	public LocalDate getReceptionExpectedControlDate() {
		return receptionExpectedControlDate;
	}

	public void setReceptionExpectedControlDate(LocalDate receptionExpectedControlDate) {
		this.receptionExpectedControlDate = receptionExpectedControlDate;
	}

	public String getReceptionNotes() {
		return receptionNotes;
	}

	public void setReceptionNotes(String receptionNotes) {
		this.receptionNotes = receptionNotes;
	}

	public Boolean getReceptionIsLocked() {
		return receptionIsLocked;
	}

	public void setReceptionIsLocked(Boolean receptionIsLocked) {
		this.receptionIsLocked = receptionIsLocked;
	}
     
     
}
