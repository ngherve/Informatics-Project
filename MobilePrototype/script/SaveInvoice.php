<?php
	
	$con = mysqli_connect("localhost", "root", "", "WirelecDatabase");
	
	if(isset($_POST["P_Code"]) && isset($_POST["Quantity"]) && isset($_POST["Total_Price"])
		&& isset($_POST["C_ID"]) && isset($_POST["INV_Date"]) && isset($_POST["UserID"]) && isset($_POST["Inv_Type"])){	
		//$INV_ID = $_POST["INV_ID"];
		$P_Code = $_POST["P_Code"];
		$Quantity = $_POST["Quantity"];
		$Total_Price = $_POST["Total_Price"];
		$C_ID = $_POST["C_ID"];
		$INV_Date = $_POST["INV_Date"];
		$UserID = $_POST["UserID"];
		$Inv_Type = $_POST["Inv_Type"];
	}

	
	$statement = mysqli_prepare($con, "INSERT INTO Invoice (P_Code, Quantity, Total_Price, C_ID, INV_Date, UserID, Inv_Type) 
									   VALUES (?, ?, ?, ?, ?, ?, ?) ");
	mysqli_stmt_bind_param($statement, "sssssss", $P_Code, $Quantity, $Total_Price, $C_ID, $INV_Date, $UserID, $Inv_Type);
	mysqli_stmt_execute($statement);
		
	$response = array();
	$response["success"] = true;
	
	echo json_encode($response);
	
	mysqli_stmt_close($statement);
	
	mysqli_close($con);
?>