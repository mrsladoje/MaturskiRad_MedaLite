package com.codolis.medalite.therapies;

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
public class TherapyController {
	@Autowired
	TherapyService therapyService;
	
	//create
	@PostMapping("/therapy")
	public Therapy createTherapy(@RequestBody Therapy ther) {
		return therapyService.createTherapy(ther);
	}
	
	//readAll
	@GetMapping("/therapies")
	public List<Therapy> getTherapies() {
		return therapyService.getTherapies();
	}
	
	//readOne
	@GetMapping("/therapy/{therId}")
	public Therapy getTherapy(@PathVariable(value="therId") Long therId) {
		return therapyService.getTherapy(therId);
	}
	
	//delete
	@DeleteMapping("/therapy/{therId}")
	public void deleteTherapy(@PathVariable(value="therId") Long therId) {
		therapyService.deleteTherapy(therId);
	}
	
	//update
	@PutMapping("/therapy/{therId}")
	public Therapy updateTherapy(@PathVariable(value="therId") Long therId, @RequestBody Therapy newTher) {
		return therapyService.updateTherapy(therId, newTher);
	}
}
