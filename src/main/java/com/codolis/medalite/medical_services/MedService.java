package com.codolis.medalite.medical_services;

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
@Table(name="tblservices")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class MedService {
	  @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      @Column(name="ServiceID", nullable=false)
          private Long serviceId;
      
      @Column(name="Name", nullable=false)
      	  private String serviceName;
      

      @Column(name="Duration")
  	      private String serviceDuration;
    
      @Lob
      @Column(name="Notes")
      	  private String serviceNotes;

      @OneToMany(mappedBy="receptionMedService")
      	  private Set<Reception> serviceReception = new HashSet<>();
      
	public Long getServiceId() {
		return serviceId;
	}

	public void setServiceId(Long serviceId) {
		this.serviceId = serviceId;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getServiceDuration() {
		return serviceDuration;
	}

	public void setServiceDuration(String serviceDuration) {
		this.serviceDuration = serviceDuration;
	}

	public String getServiceNotes() {
		return serviceNotes;
	}

	public void setServiceNotes(String serviceNotes) {
		this.serviceNotes = serviceNotes;
	}
      
}
