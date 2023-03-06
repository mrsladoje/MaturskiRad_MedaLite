package com.codolis.medalite.clinics;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name="tblclinics")
public class Clinic {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ClinicID", nullable=false)
        private Long clinicId;
    
    @Column(name="Name", nullable=false)
    	  private String clinicName;
    
    @Column(name="Address", nullable=false)
	      private String clinicAddress;
  
    @Column(name="Phone", nullable=false)
    	private String clinicPhone;
    
    @Column(name="Web")
    	private String clinicWeb;
    
    @Lob
    @Column(name="Logo", columnDefinition="BLOB")
    	private byte[] clinicLogo;
    
    @Lob
    @Column(name="Notes")
		private String clinicNotes;

	public Long getClinicId() {
		return clinicId;
	}

	public void setClinicId(Long clinicId) {
		this.clinicId = clinicId;
	}

	public String getClinicName() {
		return clinicName;
	}

	public void setClinicName(String clinicName) {
		this.clinicName = clinicName;
	}

	public String getClinicAddress() {
		return clinicAddress;
	}

	public void setClinicAddress(String clinicAddress) {
		this.clinicAddress = clinicAddress;
	}

	public String getClinicPhone() {
		return clinicPhone;
	}

	public void setClinicPhone(String clinicPhone) {
		this.clinicPhone = clinicPhone;
	}

	public String getClinicWeb() {
		return clinicWeb;
	}

	public void setClinicWeb(String clinicWeb) {
		this.clinicWeb = clinicWeb;
	}

	public byte[] getClinicLogo() {
		return this.clinicLogo;
	}

	public void setClinicLogo(byte[] newClinicLogo) {
		this.clinicLogo = newClinicLogo;
	}

	public String getClinicNotes() {
		return clinicNotes;
	}

	public void setClinicNotes(String clinicNotes) {
		this.clinicNotes = clinicNotes;
	}
    
}
