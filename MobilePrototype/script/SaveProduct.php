<?php
	
	$con = mysqli_connect("localhost", "root", "", "WirelecDatabase");
	
	if(isset($_POST["P_Name"]) && isset($_POST["P_Price"]) && isset($_POST["P_Image"]) && isset($_POST["P_Quantity"])
		&& isset($_POST["Supplier_Name"]) && isset($_POST["P_Type"]) && isset($_POST["W_Name"]) && isset($_POST["P_Code"])){	
		$P_Name = $_POST["P_Name"];
		$P_Price = $_POST["P_Price"];
		$P_Image = $_POST["P_Image"];
		$P_Quantity = $_POST["P_Quantity"];
		$Supplier_Name = $_POST["Supplier_Name"];
		$P_Type = $_POST["P_Type"];
		$W_Name = $_POST["W_Name"];
		$P_Code = $_POST["P_Code"];
		$bin_location = $_POST["bin_location"];
	}

	
	$statement = mysqli_prepare($con, "INSERT INTO Product (P_Name, P_Price, P_Image, P_Quantity, Supplier_Name, P_Type, W_Name, P_Code, bin_location) 
									   VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?) ");
	mysqli_stmt_bind_param($statement, "sssssssss", $P_Name, $P_Price, $P_Image, $P_Quantity, $Supplier_Name, $P_Type, $W_Name, $P_Code, $bin_location);
	mysqli_stmt_execute($statement);
		
	$response = array();
	$response["success"] = true;
	
	echo json_encode($response);
	
	mysqli_stmt_close($statement);
	
	mysqli_close($con);
?>