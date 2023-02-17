package com.codolis.medalite.doctors;

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
@Table(name="tbldoctors")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Doctor {
	 @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name="DoctorID", nullable=false)
         private Long doctorId;
     
     @Column(name="Name", nullable=false)
         private String doctorName;
     
     @Column(name="Title", nullable=false)
 	     private String doctorTitle;
   
     @Column(name="Specialization", nullable=false)
         private String doctorSpec;
     
     @Column(name="Address")
         private String doctorAddress;
     
     @Column(name="Phone")
         private String doctorPhone;
     
     @Column(name="Email")
         private String doctorEmail;
     
     @Column(name="Username", nullable=false)
         private String doctorUsername;
     
     @Column(name="Password", nullable=false)
         private String doctorPassword;
 
     @Lob
     @Column(name="Notes")
     	  private String doctorNotes;
     
     @OneToMany(mappedBy="receptionDoctor")
     	  private Set<Reception> doctorReceptions = new HashSet<>();
     
	public Long getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getDoctorTitle() {
		return doctorTitle;
	}

	public void setDoctorTitle(String doctorTitle) {
		this.doctorTitle = doctorTitle;
	}

	public String getDoctorSpec() {
		return doctorSpec;
	}

	public void setDoctorSpec(String doctorSpec) {
		this.doctorSpec = doctorSpec;
	}

	public String getDoctorAddress() {
		return doctorAddress;
	}

	public void setDoctorAddress(String doctorAddress) {
		this.doctorAddress = doctorAddress;
	}

	public String getDoctorPhone() {
		return doctorPhone;
	}

	public void setDoctorPhone(String doctorPhone) {
		this.doctorPhone = doctorPhone;
	}

	public String getDoctorEmail() {
		return doctorEmail;
	}

	public void setDoctorEmail(String doctorEmail) {
		this.doctorEmail = doctorEmail;
	}

	public String getDoctorUsername() {
		return doctorUsername;
	}

	public void setDoctorUsername(String doctorUsername) {
		this.doctorUsername = doctorUsername;
	}

	public String getDoctorPassword() {
		return doctorPassword;
	}

	public void setDoctorPassword(String doctorPassword) {
		this.doctorPassword = doctorPassword;
	}

	public String getDoctorNotes() {
		return doctorNotes;
	}

	public void setDoctorNotes(String doctorNotes) {
		this.doctorNotes = doctorNotes;
	}
     
     
}
