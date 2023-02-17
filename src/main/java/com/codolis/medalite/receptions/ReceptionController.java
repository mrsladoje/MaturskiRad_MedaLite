package com.codolis.medalite.receptions;

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
public class ReceptionController {
	@Autowired
	ReceptionService receptionService;
	
	//create
	@PostMapping("/reception")
	public Reception createReception(@RequestBody ReceptionV2 rec) {
		return receptionService.createReception(rec);
	}
	
	//readAll
	@GetMapping("/receptions")
	public List<Reception> getReceptions() {
		return receptionService.getReceptions();
	}
	
	//readOne
	@GetMapping("/reception/{recId}")
	public Reception getReception(@PathVariable(value="recId") Long recId) {
		return receptionService.getReception(recId);
	}
	
	//delete
	@DeleteMapping("/reception/{recId}")
	public void deleteReception(@PathVariable(value="recId") Long recId) {
		receptionService.deleteReception(recId);
	}
	
	//update
	@PutMapping("/reception/{recId}")
	public Reception updateReception(@PathVariable(value="recId") Long recId, @RequestBody ReceptionV2 rec) {		
		return receptionService.updateReception(recId, rec);
	}
}
