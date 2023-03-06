$(document).ready(function() {
	
	let action = 0; // 0 je bez akcije, 1 je za delete, 2 je za edit
	let tablePatients, tablePatRec;
	let firstViewOfPatientReceptions = true;
	
	$("#singlePat").hide(0);
	
	$.ajax({
		url: "http://localhost:8080/api/clinic",
		type: "GET",
		success: function (data) {
			$(".navbar div").prepend("<img src='data:image/jpeg;base64," + data.clinicLogo + "' height='65px' class='ml-3 rounded' float-left></img>");
			$(".navbar div").prepend("<h2>" + data.clinicName + "</h2>");
			
		}
	});
	
	tablePatients = $('#tablePat').DataTable( {
 		ajax: {
			 url: 'http://localhost:8080/api/patients',
			 type: 'GET',
			 dataSrc: ''
		 },
		 columns: [
	        { data: 'patientId', "visible": false},
	        { data: 'patientName' },
	        { data: 'patientSurname' },
	        { data: 'patientParentName', "visible": false},
	        { data: 'patientBirthdate' },
	        { data: 'patientPlaceOfBirth', "visible": false},
	        { data: 'patientMbNo', "visible": false},
	        { data: 'patientPhone' },
	        { data: 'patientEmail' },
	        { data: 'patientEvidentionCode'},
	        { data: 'patientAddress', "visible": false},
	        { data: 'patientFamilyHistory', "visible": false},
	        { data: 'patientCurrentDiseases' },
	        { data: 'patientAllergens' },
	        { data: 'patientNotes' }
	    ]
	} );


	function initPatRecTable(patient) {
		tablePatRec = $('#tablePatRec').DataTable( {
			 		ajax: {
						 url: 'http://localhost:8080/api/patient/'+patient.patientId+'/receptions',
						 type: 'GET',
						 dataSrc: ''
					 },
					 columns: [
				        	{ data: 'receptionId', "visible": false },
					        { data: 'receptionPatient.patientName', "visible": false },
					        { data: 'receptionDoctor.doctorName' },
					        { data: 'receptionMedService.serviceName' },
					        { data: 'receptionTime' },
					        { data: 'receptionAnamnesis' },
					        { data: 'receptionOpinion' },
					        { data: 'receptionSuggestedTreatment' },
					        { data: 'receptionFindings' },
					        { data: 'receptionConclusion' },
					        { data: 'receptionExpectedControlDate' },
					        { data: 'receptionNotes', "visible": false },
					        { data: 'receptionIsLocked', "visible": false },
					        
				    ]
		} );
	}
	/*
	function editStudent(patient) {
		$("#addStudent").removeAttr('disabled');
		$("#deleteStudent").removeAttr('disabled');
		$("#addStudent").removeClass('disabled');
		$("#deleteStudent").removeClass('disabled');
		$("#tablePat tr").hover(function() {
				$(this).css("background", "#ECECEC");
			}, function () {
				$(this).css("background", "#ffffff");
		});
		$("#edith4").remove();
		action = 0;
			
		$("#editStudModal").show();
		$("#editFormStudName").val(patient.name);
		$("#editFormStudSureName").val(patient.sureName);
		$("#editFormStudBookNo").val(patient.patientsBookNo);
		$("#editFormStudBirthdate").val(patient.birthdate);
		$("#editFormStudPlaceOfBirth").val(patient.placeOfBirth);
		$("#smallxeditStud").click(function() {
			$("#editStudModal").hide();
			$("#editStudModal form").get(0).reset();
		});
		$("#editStudDanger").click(function() {
			$("#editStudModal").hide();
			$("#editStudModal form").get(0).reset();
		});
		$(".btn-success").off('click');
		$(".btn-success").on('click', function() {
			let patientToEdit = {
				"name": $("#editFormStudName").val(),
				"sureName": $("#editFormStudSureName").val(),
				"patientsBookNo": $("#editFormStudBookNo").val(),
				"birthdate": $("#editFormStudBirthdate").val(),
				"placeOfBirth": $("#editFormStudPlaceOfBirth").val()
			};
			let okToCreate = true;
			if (!$("#editFormStudName").val()) {
				okToCreate = false;
				$("#invEditStudName").show();
			}
			if (!$("#editFormStudSureName").val()) {
				okToCreate = false;
				$("#invEditStudSureName").show();
			}
			if (!$("#editFormStudBookNo").val()) {
				okToCreate = false;
				$("#invEditStudBookNo").show();
			}
			if (!okToCreate) return;
			$.ajax({
				type: 'PUT',
				url: 'http://localhost:8080/api/patient/'+patient.patientId,
				data: JSON.stringify(patientToEdit),
				contentType: "application/json",
				success: function() {
					$('form').get(0).reset();
					tablePatients.ajax.reload();
					$("#editStudModal").hide();
				}
			});
		});		
	}
	
	function deleteStudent(patient) { 
		$("#addStudent").removeAttr('disabled');
		$("#editStudent").removeAttr('disabled');
		$("#addStudent").removeClass('disabled');
		$("#editStudent").removeClass('disabled');
		$("#tablePat tr").hover(function() {
				$(this).css("background", "#ECECEC");
			}, function () {
				$(this).css("background", "#ffffff");
		});
		$("#edith4").remove();
		action = 0;
		$.ajax({
			type: 'DELETE',
			url: 'http://localhost:8080/api/patient/'+patient.patientId,
			success: function() {
				$('form').get(0).reset();
				tablePatients.ajax.reload();
				$("#editStudModal").hide();
			}
		});
	}*/
	
	$('#tablePat tbody').on( 'click', 'tr', function () {
			if (action === 0) {
				let patient = tablePatients.row(this).data();
				
		 		$("#toolbox").hide();
		   		
		   		$("#patientsView").hide(0);
				$("#singlePat").show(0);
				
				$("#singlePat").prepend("<div><hr></div><h3>The following are their receptions:</h3>");
				$("#singlePat").prepend("<h6> "+patient.patientNotes+"</strong></h6>");
				$("#singlePat").prepend("<h6> Allergens: "+patient.patientAllergens+"</h6>");
				$("#singlePat").prepend("<h6> Current diseases: "+patient.patientCurrentDiseases+"</h6>");
				$("#singlePat").prepend("<h6> Family history: "+patient.patientFamilyHistory+"</h6>");
				$("#singlePat").prepend("<h6> Their address: <strong>"+patient.patientAddress+"</strong></h6>");
				$("#singlePat").prepend("<h6> They can be contacted on: <strong>"+patient.patientPhone+"</strong> or on: <strong>"+patient.patientEmail+"</strong></h6>");
				$("#singlePat").prepend("<h6> Their MbNo is: <strong>"+patient.patientMbNo+"</strong> and Evidention code: <strong>"+patient.patientEvidentionCode+"</strong></h6>");
				$("#singlePat").prepend("<h6> Born on <strong>"+patient.patientBirthdate+"</strong> in <strong>"+patient.patientPlaceOfBirth+"</strong></h6>");
				$("#singlePat").prepend("<h1> Patient: "+patient.patientName+" ("+patient.patientParentName+") "+patient.patientSurname+"</h1>");
				
				if (firstViewOfPatientReceptions) initPatRecTable(patient);
				else {
					tablePatRec.ajax.url('http://localhost:8080/api/patient/'+patient.patientId+'/receptions').load();	
				}
				firstViewOfPatientReceptions = false;
				
				$(".jumbotron .btn-primary").click(function() {
					$("#singlePat").hide(0);
					$("#patientsView").show(0);
					$("#toolbox").show();
					$(".jumbotron tbody").empty();
					$(".jumbotron h1").remove();
					$(".jumbotron h6").remove();
					$(".jumbotron h3").remove();
					$(".jumbotron div hr").remove();
					
				});
				$(".jumbotron .btn-info").off('click');
				/*$(".jumbotron .btn-info").click(function() {
					$("#singlePat").hide(0);
					$("#patientsView").show(0);
					$("#toolbox").show();
					$(".jumbotron tbody").empty();
					$(".jumbotron h1").remove();
					$(".jumbotron h6").remove();
					$(".jumbotron h3").remove();
					$(".jumbotron div hr").remove();
					
					editStudent(patient);
				});
				$(".jumbotron .btn-danger").off('click');
				$(".jumbotron .btn-danger").click(function() {
					$("#singlePat").hide(0);
					$("#patientsView").show(0);
					$("#toolbox").show();
					$(".jumbotron tbody").empty();
					$(".jumbotron h1").remove();
					$(".jumbotron h6").remove();
					$(".jumbotron h3").remove();
					$(".jumbotron div hr").remove();
					
					deleteStudent(patient);
				});*/
			}
			else if (action === 2) {
				let patient = tablePatients.row(this).data();
		 		editStudent(patient);
			}
			else {
				let patient = tablePatients.row(this).data();
		 		deleteStudent(patient);
			}
	} );
	
	/*
	
	$("#addStudent").on('click', function() {
		$("#addStudModal").show();
		$(".close").click(function() {
			$("#addStudModal").hide();
			$('#addStudModal form').get(0).reset();
		});
		$(".btn-danger").click(function() {
			$("#addStudModal").hide();
			$('#addStudModal form').get(0).reset();
		});
		$(".btn-success").off('click');
		$(".btn-success").on('click', function() {
			let patientToAdd = {
				"name": $("#addFormStudName").val(),
				"sureName": $("#addFormStudSureName").val(),
				"patientsBookNo": $("#addFormStudBookNo").val(),
				"birthdate": $("#addFormStudBirthdate").val(),
				"placeOfBirth": $("#addFormStudPlaceOfBirth").val()
			};
			let okToCreate = true;
			if (!$("#addFormStudName").val()) {
				okToCreate = false;
				$("#invAddStudName").show();
			}
			if (!$("#addFormStudSureName").val()) {
				okToCreate = false;
				$("#invAddStudSureName").show();
			}
			if (!$("#addFormStudBookNo").val()) {
				okToCreate = false;
				$("#invAddStudBookNo").show();
			}
			if (!okToCreate) return;
			
			$.ajax({
				type: 'POST',
				url: 'http://localhost:8080/api/patient',
				data: JSON.stringify(patientToAdd),
				contentType: "application/json",
				success: function() {
					$('form').get(0).reset();
					tablePatients.ajax.reload();
					$("#addStudModal").hide();
				}
			});
		});			
	});
	
	$("#editStudent").click(function() {
		if (action === 2) {
			$("#addStudent").removeAttr('disabled');
			$("#deleteStudent").removeAttr('disabled');
			$("#addStudent").removeClass('disabled');
			$("#deleteStudent").removeClass('disabled');
			$("#tablePat tr").hover(function() {
					$(this).css("background", "#ECECEC");
				}, function () {
					$(this).css("background", "#ffffff");
			});
			$("#edith4").remove();
			action = 0;
			
			return;
		}
		
		action = 2;
		
		$("#patientsViewEditDel").append("<h4 id='edith4'>  Click on patient to edit! <br> To abort this operation, reclick the Edit button.</h4>");
		$("#edith4").css("background", "#a8d5e5");
		$("#deleteStudent").attr('disabled', 'disabled');
		$("#addStudent").attr('disabled', 'disabled');
		$("#deleteStudent").addClass('disabled');
		$("#addStudent").addClass('disabled');
		$("#tablePat tr").hover(function() {
			$(this).css("background", "#a8d5e5");
		}, function () {
			$(this).css("background", "#ffffff");
		});		
	});
	
	$("#deleteStudent").click(function() {
		if (action === 1) {
			$("#addStudent").removeAttr('disabled');
			$("#editStudent").removeAttr('disabled');
			$("#addStudent").removeClass('disabled');
			$("#editStudent").removeClass('disabled');
			$("#tablePat tr").hover(function() {
					$(this).css("background", "#ECECEC");
				}, function () {
					$(this).css("background", "#ffffff");
			});
			$("#edith4").remove();
			action = 0;
			
			return;
		}
		
		action = 1;
		
		$("#patientsViewEditDel").append("<h4 id='edith4'>  Click on patient to delete! <br> To abort this operation, reclick the Delete button.</h4>");
		$("#edith4").css("background", "#FAA0A0");
		$("#editStudent").attr('disabled', 'disabled');
		$("#addStudent").attr('disabled', 'disabled');
		$("#editStudent").addClass('disabled');
		$("#addStudent").addClass('disabled');
		$("#tablePat tr").hover(function() {
			$(this).css("background", "#FAA0A0");
		}, function () {
			$(this).css("background", "#ffffff");
		});
		
	});
		*/
	
});
















