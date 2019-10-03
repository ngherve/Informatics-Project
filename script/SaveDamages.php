<?php
	
	$con = mysqli_connect("localhost", "root", "", "WirelecDatabase");
	
	if(isset($_POST["DateDamaged"]) && isset($_POST["P_ID"]) && isset($_POST["Quantity"]) 
		&& isset($_POST["Description"]) && isset($_POST["P_Photo"]) ){	
		$DateDamaged = $_POST["DateDamaged"];
		$P_ID = $_POST["P_ID"];
		$Quantity = $_POST["Quantity"];
		$Description = $_POST["Description"];
		$P_Photo = $_POST["P_Photo"];
	}

	$statement1 = mysqli_prepare($con, "INSERT INTO Damaged (DateDamaged, P_ID, Quantity, Description, P_Photo) 
									   VALUES (?, ?, ?, ?, ?) ");
	mysqli_stmt_bind_param($statement1, "sssss", $DateDamaged, $P_ID, $Quantity, $Description, $P_Photo);
	mysqli_stmt_execute($statement1);
		
	$response = array();
	$response["success"] = true;
	
	echo json_encode($response);
	
	mysqli_stmt_close($statement1);
	
	mysqli_close($con);
?>