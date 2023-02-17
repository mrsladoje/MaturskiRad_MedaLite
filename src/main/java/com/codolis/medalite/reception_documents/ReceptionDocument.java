package com.codolis.medalite.reception_documents;

import java.time.LocalDate;

import com.codolis.medalite.receptions.Reception;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="tblreceptiondocuments")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ReceptionDocument {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ReceptionDocumentID", nullable=false)
		private Long receptionDocumentId;
	
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@JoinColumn(name="ReceptionID")
		private Reception receptionDocumentReception;
	
	@Lob
	@Column(name="Document", nullable=false, columnDefinition="BLOB")
		private byte[] receptionDocumentDocument;
	
	@Column(name="DocDate")
		private LocalDate receptionDocumentDate;
	
	@Lob
	@Column(name="Description")
		private String receptionDocumentDescription;

	public Long getReceptionDocumentId() {
		return receptionDocumentId;
	}

	public void setReceptionDocumentId(Long receptionDocumentId) {
		this.receptionDocumentId = receptionDocumentId;
	}

	public Reception getReceptionDocumentReception() {
		return receptionDocumentReception;
	}

	public void setReceptionDocumentReception(Reception receptionDocumentReception) {
		this.receptionDocumentReception = receptionDocumentReception;
	}

	public byte[] getReceptionDocumentDocument() {
		return receptionDocumentDocument;
	}

	public void setReceptionDocumentDocument(byte[] receptionDocumentDocument) {
		this.receptionDocumentDocument = receptionDocumentDocument;
	}

	public LocalDate getReceptionDocumentDate() {
		return receptionDocumentDate;
	}

	public void setReceptionDocumentDate(LocalDate receptionDocumentDate) {
		this.receptionDocumentDate = receptionDocumentDate;
	}

	public String getReceptionDocumentDescription() {
		return receptionDocumentDescription;
	}

	public void setReceptionDocumentDescription(String receptionDocumentDescription) {
		this.receptionDocumentDescription = receptionDocumentDescription;
	}
}
