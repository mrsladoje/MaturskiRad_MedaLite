package com.codolis.medalite.reception_documents;

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
public class ReceptionDocumentController {
	@Autowired
		ReceptionDocumentService receptionDocumentService;
	
	//create
	@PostMapping("/reception/document")
	public ReceptionDocument createReceptionDocument(@RequestBody ReceptionDocumentV2 rec) {
		return receptionDocumentService.createReceptionDocument(rec);
	}
	
	//readAll
	@GetMapping("/reception/documents")
	public List<ReceptionDocVRet> getReceptionDocuments() {
		return receptionDocumentService.getReceptionDocuments();
	}
	
	//readOne
	@GetMapping("/reception/document/{recDocId}")
	public ReceptionDocVRet getReceptionDocument(@PathVariable(value="recDocId") Long recDocId) {
		return receptionDocumentService.getReceptionDocument(recDocId);
	}
	
	//delete
	@DeleteMapping("/reception/document/{recDocId}")
	public void deleteReceptionDocument(@PathVariable(value="recDocId") Long recDocId) {
		receptionDocumentService.deleteReceptionDocument(recDocId);
	}
	
	//update
	@PutMapping("/reception/document/{recDocId}")
	public ReceptionDocument updateReceptionDocument(@PathVariable(value="recDocId") Long recDocId, @RequestBody ReceptionDocumentV2 rec) {		
		return receptionDocumentService.updateReceptionDocument(recDocId, rec);
	}
}
