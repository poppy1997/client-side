$(document).ready(function()
{ 
 if ($("#alertSuccess").text().trim() == "") 
 { 
 $("#alertSuccess").hide(); 
 } 
 $("#alertError").hide(); 
 
}); 

// SAVE ============================================
$(document).on("click", "#btnSave", function(event) 
{ 
	// Clear status msgs-------------
	$("#alertSuccess").text(""); 
 	$("#alertSuccess").hide(); 
	$("#alertError").text(""); 
 	$("#alertError").hide(); 
	$("#alertError").text(""); 
 	$("#alertError").hide(); 
 	$("#alertError").text(""); 
 	$("#alertError").hide(); 

	// Form validation----------------
	var status = validateItemForm(); 
	// If not valid-------------------
	if (status != true) 
 	{ 
 		$("#alertError").text(status); 
 		$("#alertError").show(); 
 	return; 
 	} 
 
	// If valid----------------------- 
	$("#formResearcher").submit(); 
	
 	// Generate the card and append
	var researcher = getResearcherCard($("#txtName").val().trim(), 
 	$('input[name="rdoUser"]:checked').val(), 
 	$("#textEmail").val().trim(),
	$("#textPhone").val().trim()); 
 	$("#colResearchers").append(researcher); 
 
 	$("#alertSuccess").text("Saved successfully."); 
 	$("#alertSuccess").show(); 
 
 	$("#formResearcher")[0].reset(); 
	
});

// UPDATE==========================================
$(document).on("click", ".btnUpdate", function(event) 
{ 
 $("#hidItemIDSave").val($(this).closest("tr").find('#hidItemIDUpdate').val()); 
 $("#itemCode").val($(this).closest("tr").find('td:eq(0)').text()); 
 $("#itemName").val($(this).closest("tr").find('td:eq(1)').text()); 
 $("#itemPrice").val($(this).closest("tr").find('td:eq(2)').text()); 
 $("#itemDesc").val($(this).closest("tr").find('td:eq(3)').text()); 
});


// REMOVE==========================================
$(document).on("click", ".remove", function(event) 
{ 
 $(this).closest(".student").remove(); 
 
 $("#alertSuccess").text("Removed successfully."); 
 $("#alertSuccess").show(); 
});


// CLIENT-MODEL================================================================


function validateItemForm()
{ 
// NAME
if ($("#txtName").val().trim() == "") 
 { 
 return "Insert researcher name."; 
 } 
// CODE
if ($('input[name="rdoUser"]:checked').length === 0) 
 { 
 return "Select user code."; 
 } 
// EMAIL
if ($("#txtName").val().trim() == "") 
 { 
 return "Insert researcher email."; 
 } 
//PHONE
if ($("#txtName").val().trim() == "") 
 { 
 return "Insert researcher phone."; 
 } 
return true; 
}

function getResearcherCard(userName, userCode, userEmail,userPhone)
{ 
var researcher = ""; 

 researcher += "<div class=\"researcher card bg-light m-2\" style=\"max-width: 10rem; float: left;\">"; 
 researcher += "<div class=\"card-body\">"; 
 researcher += title + " " + userName + ","; 
 researcher += "<br>"; 
 researcher += userCode + " userCode";
 researcher += "<br>"; 
 researcher += userEmail + " userEmail";
 researcher += "<br>"; 
 researcher += userPhone + " userPhone"; 
 researcher += "</div>"; 
 researcher += "<input type=\"button\" value=\"Remove\" class=\"btn btn-danger remove\">"; 
 researcher += "</div>"; 

 //Generate card 
return researcher; 
}
