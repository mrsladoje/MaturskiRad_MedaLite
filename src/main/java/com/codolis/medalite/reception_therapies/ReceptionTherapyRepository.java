package com.codolis.medalite.reception_therapies;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceptionTherapyRepository extends JpaRepository<ReceptionTherapy, Long>{
	
	public List<ReceptionTherapy> findByReceptionTherapyTherapyTherapyId(Long therapyId);
}
