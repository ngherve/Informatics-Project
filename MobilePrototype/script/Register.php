<?php
	
	$con = mysqli_connect("localhost", "root", "", "WirelecDatabase");
	
	
	if(isset($_POST["Name"]) && isset($_POST["Password"]) && isset($_POST["Email"]) && isset($_POST["Tel_Number"]) &&
		isset($_POST["Username"]) && isset($_POST["Address"]) && isset($_POST["Gender"]) && isset($_POST["DOB"])){		
		$Name = $_POST["Name"];
		$Username = $_POST["Username"];
		$Email = $_POST["Email"];
		$Password = $_POST["Password"];
		$Tel_Number = $_POST["Tel_Number"];
		$Address = $_POST["Address"];
		$Gender = $_POST["Gender"];
		$DOB = $_POST["DOB"];
	}
	/*$dateOfB = explode(' ', $DOB);
	print_r($dateOfB);
	$string = date("Y-m-d", strtotime("$dateOfB[0]-$dateOfB[1]-$dateOfB[2]"));*/
	
	$statement = mysqli_prepare($con, "INSERT INTO User (Name, Username, Email, Password, Tel_Number, Address, Gender, DOB) 
									   VALUES (?, ?, ?, ?, ?, ?, ?, ?) ");
	mysqli_stmt_bind_param($statement, "ssssssss", $Name, $Username, $Email, $Password, $Tel_Number, $Address, $Gender, $DOB);
	mysqli_stmt_execute($statement);
		
	$response = array();
	$response["success"] = true;
	
	echo json_encode($response);
	
	mysqli_stmt_close($statement);
	
	mysqli_close($con);
?>