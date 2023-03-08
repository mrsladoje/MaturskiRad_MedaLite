package com.codolis.medalite.receptions;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ReceptionV2 {
	public Long receptionId;
	public Long receptionPatient;
	public Long receptionDoctor;
    public Long receptionMedService;
    public LocalDateTime receptionTime;
    public String receptionAnamnesis;  
    public String receptionOpinion;    
    public String receptionSuggestedTreatment;   
    public String receptionFindings;    
    public String receptionConclusion;    
    public LocalDate receptionExpectedControlDate;    
    public String receptionNotes;
    public Boolean receptionIsLocked;
}
