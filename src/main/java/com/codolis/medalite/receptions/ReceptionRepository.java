package com.codolis.medalite.receptions;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceptionRepository extends JpaRepository<Reception, Long>{
	
	public List<Reception> findByReceptionPatientPatientId(Long patientId);
	public List<Reception> findByReceptionDoctorDoctorId(Long doctorId);
	public List<Reception> findByReceptionMedServiceServiceId(Long serviceId);
}
