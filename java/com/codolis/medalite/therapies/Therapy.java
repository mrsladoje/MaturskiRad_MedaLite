package com.codolis.medalite.therapies;

import java.util.HashSet;
import java.util.Set;

import com.codolis.medalite.reception_therapies.ReceptionTherapy;
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
@Table(name="tbltherapies")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Therapy {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="TherapyID", nullable=false)
        private Long therapyId;
    
    @Column(name="Name", nullable=false)
    	  private String therapyName;
    

    @Column(name="GenericName")
	      private String therapyGenericName;
  
    @Column(name="Code")
    private String therapyCode;
    
    @Lob
    @Column(name="Description")
    	  private String therapyDescription;
    
    @OneToMany(mappedBy="receptionTherapyTherapy")
    	private Set<ReceptionTherapy> therapyReceptionTherapies = new HashSet<>(); 
    
    public Long getTherapyId() {
		return therapyId;
	}

	public void setTherapyId(Long therapyId) {
		this.therapyId = therapyId;
	}

	public String getTherapyName() {
		return therapyName;
	}

	public void setTherapyName(String therapyName) {
		this.therapyName = therapyName;
	}

	public String getTherapyGenericName() {
		return therapyGenericName;
	}

	public void setTherapyGenericName(String therapyGenericName) {
		this.therapyGenericName = therapyGenericName;
	}

	public String getTherapyCode() {
		return therapyCode;
	}

	public void setTherapyCode(String therapyCode) {
		this.therapyCode = therapyCode;
	}

	public String getTherapyDescription() {
		return therapyDescription;
	}

	public void setTherapyDescription(String therapyDescription) {
		this.therapyDescription = therapyDescription;
	}
}
