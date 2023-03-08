package com.codolis.medalite.reception_diagnoses;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceptionDiagnosisRepository extends JpaRepository<ReceptionDiagnosis, Long>{
	
	public List<ReceptionDiagnosis> findByReceptionDiagnosisDiagnosisDiagnosisId(Long diagId);
}
