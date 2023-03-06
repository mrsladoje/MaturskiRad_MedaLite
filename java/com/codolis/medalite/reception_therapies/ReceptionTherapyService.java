package com.codolis.medalite.reception_therapies;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codolis.medalite.receptions.ReceptionService;
import com.codolis.medalite.therapies.TherapyService;


@Service
public class ReceptionTherapyService {
	@Autowired
		ReceptionTherapyRepository rectherapyRepository;
	@Autowired
		ReceptionService receptionService;
	@Autowired
		TherapyService therapyService;
	
	boolean IsOkToCreate(ReceptionTherapy recther) {
		boolean b = true;
		
		b = b & (recther.getReceptionTherapyReception() != null)
			& (recther.getReceptionTherapyTherapy() != null)
			& (recther.getReceptionTherapyDose() != null);
		
		if (recther.getReceptionTherapyDose() != null) {
			b &= !recther.getReceptionTherapyDose().isEmpty();
			b &= !recther.getReceptionTherapyDose().isBlank();
		}
		
		return b;
	}
	
	//create 
	public ReceptionTherapy createReceptionTherapy(ReceptionTherapyV2 recTher2) {
		ReceptionTherapy recTher = new ReceptionTherapy();
	
		recTher.setReceptionTherapyReception(receptionService.getReception(recTher2.receptionTherapyReception));
		recTher.setReceptionTherapyTherapy(therapyService.getTherapy(recTher2.receptionTherapyTherapy));
		recTher.setReceptionTherapyDose(recTher2.receptionTherapyDose);
		
		if (IsOkToCreate(recTher)) return rectherapyRepository.save(recTher);
		else {
			System.out.println("Terapija pri prijemu mora imati identifikator prijema i terapije i dozu!");
			return null;
		}
	}

	//readAll
	public List<ReceptionTherapy> getReceptionTherapies() {
	    return rectherapyRepository.findAll();
	}

	//readOne
	public ReceptionTherapy getReceptionTherapy(Long rectherId) {
	    return rectherapyRepository.findById(rectherId).get();
	}
	
	//delete
	public void deleteReceptionTherapy(Long rectherId) {
		if (rectherapyRepository.findById(rectherId).get().getReceptionTherapyReception().getReceptionIsLocked()) {
			System.out.println("Terapija pri prijemu se ne moze obrisati jer je prijem lokovan.");
		}
		else {
			rectherapyRepository.deleteById(rectherId);
		}
	}
	
	//update
	public ReceptionTherapy updateReceptionTherapy(Long rectherId, ReceptionTherapyV2 newRecDiag2) {
		if (rectherapyRepository.findById(rectherId).get().getReceptionTherapyReception().getReceptionIsLocked()) {
			System.out.println("Terapija pri prijemu se ne moze azurirati jer je prijem lokovan.");
			return null;
		}
		else {
			ReceptionTherapy recTher = new ReceptionTherapy();
			
			recTher.setReceptionTherapyReception(receptionService.getReception(newRecDiag2.receptionTherapyReception));
			recTher.setReceptionTherapyTherapy(therapyService.getTherapy(newRecDiag2.receptionTherapyTherapy));
			recTher.setReceptionTherapyDose(newRecDiag2.receptionTherapyDose);
			
			if (IsOkToCreate(recTher)) {
			    ReceptionTherapy currRecTher = rectherapyRepository.findById(rectherId).get();
			    
			    currRecTher.setReceptionTherapyReception(recTher.getReceptionTherapyReception());
			    currRecTher.setReceptionTherapyTherapy(recTher.getReceptionTherapyTherapy());
			    currRecTher.setReceptionTherapyDose(recTher.getReceptionTherapyDose());
			    
			    return rectherapyRepository.save(currRecTher);
			}
			else {
				System.out.println("Terapija pri prijemu mora imati identifikator prijema i terapije i dozu!");
				return null;
			}	    
		}
	}
}
