function login(divID,userID,passID){
	
	
	// get inputs 
	var user = new Object();
	user.email = $("#"+userID).val();
	user.password = $("#"+passID).val();
	
	console.log("email id is "+user.email+" and password is "+user.password);
	$.ajax({
		url: "SignInServlet",
		type: 'POST',
        dataType: 'json',
        data: JSON.stringify(user),
        contentType: 'application/json',
        mimeType: 'application/json',
		
		success:function(data){
			console.log(data);
		},
		error:function(data,status,er){
			alert("error: "+data+" status "+status+" error is "+er);
		}
		
	});
}
	
	
	
