<?php
	$con = mysqli_connect("localhost", "root", "", "WirelecDatabase");
	
	if(isset($_POST["P_Code"])){
		$P_Code = $_POST["P_Code"];
	}
	
	$statement = mysqli_prepare($con, "SELECT * FROM Product WHERE P_Code = ?");
	mysqli_stmt_bind_param($statement, "s", $P_Code);
	mysqli_stmt_execute($statement);

	mysqli_stmt_store_result($statement);
	mysqli_stmt_bind_result($statement,$P_ID, $P_Name, $P_Price, $P_Image, $P_Quantity, $Supplier_Name, $P_Type, $W_Name, $P_Code);
	
	$response = array();
	$response["success"] = false;
	
	while(mysqli_stmt_fetch($statement)){
		$response["success"] = true;
		$response["P_ID"] = $P_ID;
		$response["P_Name"] = $P_Name;
		$response["P_Price"] = $P_Price;
		$response["P_Image"] = $P_Image;
		$response["P_Quantity"] = $P_Quantity;
		$response["Supplier_Name"] = $Supplier_Name;
		$response["P_Type"] = $P_Type;
		$response["W_Name"] = $W_Name;
		$response["P_Code"] = $P_Code;
	}
	
	echo json_encode($response);
	
	mysqli_stmt_close($statement);
	
	mysqli_close($con);
?> 