package com.codolis.medalite.reception_diagnoses;

import com.codolis.medalite.diagnoses.Diagnosis;
import com.codolis.medalite.receptions.Reception;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="tblreceptiondiagnoses")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ReceptionDiagnosis {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ReceptionDiagnosisID", nullable=false)
		private Long receptionDiagnosisId;
	
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@JoinColumn(name="ReceptionID")
		private Reception receptionDiagnosisReception;
	
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@JoinColumn(name="DiagnosisID")
		private Diagnosis receptionDiagnosisDiagnosis;

	public Long getReceptionDiagnosisId() {
		return receptionDiagnosisId;
	}

	public void setReceptionDiagnosisId(Long receptionDiagnosisId) {
		this.receptionDiagnosisId = receptionDiagnosisId;
	}

	public Reception getReceptionDiagnosisReception() {
		return receptionDiagnosisReception;
	}

	public void setReceptionDiagnosisReception(Reception receptionDiagnosisReception) {
		this.receptionDiagnosisReception = receptionDiagnosisReception;
	}

	public Diagnosis getReceptionDiagnosisDiagnosis() {
		return receptionDiagnosisDiagnosis;
	}

	public void setReceptionDiagnosisDiagnosis(Diagnosis receptionDiagnosisDiagnosis) {
		this.receptionDiagnosisDiagnosis = receptionDiagnosisDiagnosis;
	}
	
}
