package com.codolis.medalite.diagnoses;

import java.util.HashSet;
import java.util.Set;

import com.codolis.medalite.reception_diagnoses.ReceptionDiagnosis;
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
@Table(name="tbldiagnoses")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Diagnosis {
	  @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      @Column(name="DiagnosisID", nullable=false)
          private Long diagnosisId;
      
      @Column(name="Name", nullable=false)
      	  private String diagnosisName;
      

      @Column(name="Code", nullable=false)
  	      private String diagnosisCode;
    
      @Lob
      @Column(name="Description")
      	  private String diagnosisDescription;
      
      @OneToMany(mappedBy="receptionDiagnosisDiagnosis")
      	private Set<ReceptionDiagnosis> diagnosisReceptionDiagnoses = new HashSet<>();
      
      public Long getDiagnosisId() {
	      return diagnosisId;
	  }

	  public void setDiagnosisId(Long diagnosisId) {
		  this.diagnosisId = diagnosisId;
	  }

	  public String getDiagnosisName() {
		  return diagnosisName;
	  }

	  public void setDiagnosisName(String diagnosisName) {
	  	this.diagnosisName = diagnosisName;
	  }

	  public String getDiagnosisCode() {
	   	return diagnosisCode;
	  }

	  public void setDiagnosisCode(String diagnosisCode) {
	 	  this.diagnosisCode = diagnosisCode;
	  } 

	  public String getDiagnosisDescription() {
	   	  return diagnosisDescription;
	  }

	  public void setDiagnosisDescription(String diagnosisDescription) {
		  this.diagnosisDescription = diagnosisDescription;
	  }
}
