package com.codolis.medalite.reception_therapies;

import com.codolis.medalite.receptions.Reception;
import com.codolis.medalite.therapies.Therapy;
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
@Table(name="tblreceptiontherapies")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ReceptionTherapy {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ReceptionTherapyID", nullable=false)
		private Long receptionTherapyId;
	
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@JoinColumn(name="ReceptionID")
		private Reception receptionTherapyReception;
	
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@JoinColumn(name="TherapyID")
		private Therapy receptionTherapyTherapy;
	
	@Column(name="Dose", nullable=false)
		private String receptionTherapyDose;

	public Long getReceptionTherapyId() {
		return receptionTherapyId;
	}

	public void setReceptionTherapyId(Long receptionTherapyId) {
		this.receptionTherapyId = receptionTherapyId;
	}

	public Reception getReceptionTherapyReception() {
		return receptionTherapyReception;
	}

	public void setReceptionTherapyReception(Reception receptionTherapyReception) {
		this.receptionTherapyReception = receptionTherapyReception;
	}

	public Therapy getReceptionTherapyTherapy() {
		return receptionTherapyTherapy;
	}

	public void setReceptionTherapyTherapy(Therapy receptionTherapyTherapy) {
		this.receptionTherapyTherapy = receptionTherapyTherapy;
	}

	public String getReceptionTherapyDose() {
		return receptionTherapyDose;
	}

	public void setReceptionTherapyDose(String receptionTherapyDose) {
		this.receptionTherapyDose = receptionTherapyDose;
	}
	
}
