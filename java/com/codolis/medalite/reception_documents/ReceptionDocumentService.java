package com.codolis.medalite.reception_documents;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codolis.medalite.receptions.ReceptionService;

@Service
public class ReceptionDocumentService {
	@Autowired
		ReceptionDocumentRepository recdocumentRepository;
	@Autowired
		ReceptionService receptionService;
	
	boolean IsOkToCreate(ReceptionDocument recdoc) {
		boolean b = true;
		
		b = b & (recdoc.getReceptionDocumentReception() != null)
			& (recdoc.getReceptionDocumentDocument() != null);
		
		return b;
	}
	
	//create 
	public ReceptionDocument createReceptionDocument(ReceptionDocumentV2 recDoc2) {
		ReceptionDocument recDoc = new ReceptionDocument();
	
		recDoc.setReceptionDocumentReception(receptionService.getReception(recDoc2.receptionDocumentReception));
		recDoc.setReceptionDocumentDocument(recDoc2.receptionDocumentDocument);
		recDoc.setReceptionDocumentDate(recDoc2.receptionDocumentDate);
		recDoc.setReceptionDocumentDescription(recDoc2.receptionDocumentDescription);
		
		if (IsOkToCreate(recDoc)) return recdocumentRepository.save(recDoc);
		else {
			System.out.println("Dokument pri prijemu mora imati identifikator dokument i identifikator prijema!");
			return null;
		}
	}
	
	//readAll
	public List<ReceptionDocVRet> getReceptionDocuments() {
	    List<ReceptionDocument> recDocList = recdocumentRepository.findAll();
	    List<ReceptionDocVRet> recDocListVret = new ArrayList<>();
	    
	    for (ReceptionDocument recDoc : recDocList) {
	    	ReceptionDocVRet recDocVRet = new ReceptionDocVRet();
	    	
	    	recDocVRet.receptionDocumentId = recDoc.getReceptionDocumentId();
	    	recDocVRet.receptionDocumentReception = recDoc.getReceptionDocumentReception();
	    	recDocVRet.receptionDocumentDocument = Base64.getEncoder().encodeToString(recDoc.getReceptionDocumentDocument());
	    	recDocVRet.receptionDocumentDate = recDoc.getReceptionDocumentDate();
	    	recDocVRet.receptionDocumentDescription = recDoc.getReceptionDocumentDescription();
	    	
	    	recDocListVret.add(recDocVRet);
	    }
		
		return recDocListVret;
	}
	
	//readOne
	public ReceptionDocVRet getReceptionDocument(Long recdocId) {
		ReceptionDocument recDoc = recdocumentRepository.findById(recdocId).get();
		ReceptionDocVRet recDocVRet = new ReceptionDocVRet();
		
		recDocVRet.receptionDocumentId = recDoc.getReceptionDocumentId();
    	recDocVRet.receptionDocumentReception = recDoc.getReceptionDocumentReception();
    	recDocVRet.receptionDocumentDocument = Base64.getEncoder().encodeToString(recDoc.getReceptionDocumentDocument());
    	recDocVRet.receptionDocumentDate = recDoc.getReceptionDocumentDate();
    	recDocVRet.receptionDocumentDescription = recDoc.getReceptionDocumentDescription();
		
	    return recDocVRet;
	}
	
	//delete
	public void deleteReceptionDocument(Long recdocId) {
		if (recdocumentRepository.findById(recdocId).get().getReceptionDocumentReception().getReceptionIsLocked()) {
			System.out.println("Dokument pri prijemu se ne moze obrisati jer je prijem lokovan.");
		}
		else {
			recdocumentRepository.deleteById(recdocId);
		}
	}
	
	//update
	public ReceptionDocument updateReceptionDocument(Long recdocId, ReceptionDocumentV2 newRecDiag2) {
		if (recdocumentRepository.findById(recdocId).get().getReceptionDocumentReception().getReceptionIsLocked()) {
			System.out.println("Dokument pri prijemu se ne moze azurirati jer je prijem lokovan.");
			return null;
		}
		else {
			ReceptionDocument recDoc = new ReceptionDocument();
			
			recDoc.setReceptionDocumentReception(receptionService.getReception(newRecDiag2.receptionDocumentReception));
			recDoc.setReceptionDocumentDocument(newRecDiag2.receptionDocumentDocument);
			recDoc.setReceptionDocumentDate(newRecDiag2.receptionDocumentDate);
			recDoc.setReceptionDocumentDescription(newRecDiag2.receptionDocumentDescription);
			
			if (IsOkToCreate(recDoc)) {
			    ReceptionDocument currRecDoc = recdocumentRepository.findById(recdocId).get();
			    
			    currRecDoc.setReceptionDocumentReception(recDoc.getReceptionDocumentReception());
			    currRecDoc.setReceptionDocumentDocument(recDoc.getReceptionDocumentDocument());
			    currRecDoc.setReceptionDocumentDate(recDoc.getReceptionDocumentDate());
			    currRecDoc.setReceptionDocumentDescription(recDoc.getReceptionDocumentDescription());
			    
			    return recdocumentRepository.save(currRecDoc);
			}
			else {
				System.out.println("Dokument pri prijemu mora imati identifikator dokument i identifikator prijema!");
				return null;
			}	    
		}
	}
}
