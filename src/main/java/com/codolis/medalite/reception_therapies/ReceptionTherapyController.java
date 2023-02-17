package com.codolis.medalite.reception_therapies;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ReceptionTherapyController {
	@Autowired
		ReceptionTherapyService receptiontherapyService;
	
	//create
	@PostMapping("/reception/therapy")
	public ReceptionTherapy createReceptionTherapy(@RequestBody ReceptionTherapyV2 recTher) {
		return receptiontherapyService.createReceptionTherapy(recTher);
	}
	
	//readAll
	@GetMapping("/reception/therapies")
	public List<ReceptionTherapy> getReceptionTherapies() {
		return receptiontherapyService.getReceptionTherapies();
	}
	
	//readOne
	@GetMapping("/reception/therapy/{recTherId}")
	public ReceptionTherapy getReceptionTherapy(@PathVariable(value="recTherId") Long recTherId) {
		return receptiontherapyService.getReceptionTherapy(recTherId);
	}
	
	//delete
	@DeleteMapping("/reception/therapy/{recTherId}")
	public void deleteReceptionTherapy(@PathVariable(value="recTherId") Long recTherId) {
		receptiontherapyService.deleteReceptionTherapy(recTherId);
	}
	
	//update
	@PutMapping("/reception/therapy/{recTherId}")
	public ReceptionTherapy updateReceptionTherapy(@PathVariable(value="recTherId") Long recTherId, @RequestBody ReceptionTherapyV2 newRecTher) {
		
		return receptiontherapyService.updateReceptionTherapy(recTherId, newRecTher);
	}

}
