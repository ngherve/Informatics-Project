 <?php
	$con = mysqli_connect("localhost", "root", "", "WirelecDatabase");
	
	$statement = mysqli_prepare($con, "SELECT * FROM Invoice");
	mysqli_stmt_execute($statement);

	mysqli_stmt_store_result($statement);
	mysqli_stmt_bind_result($statement, $INV_ID, $P_Code, $Quantity, $Total_Price, $C_ID, $INV_Date, $UserID);
	
	$inv = array();
	
	while(mysqli_stmt_fetch($statement)){
		$temp = array();
		
		$temp["INV_ID"] = $INV_ID;
		$temp["P_Code"] = $P_Code;
		$temp["Quantity"] = $Quantity;
		$temp["Total_Price"] = $Total_Price;
		$temp["C_ID"] = $C_ID;
		$temp["INV_Date"] = $INV_Date;
		$temp["UserID"] = $UserID;
		$temp["Inv_Type"] = $Inv_Type;]
		
		
		array_push($inv, $temp);
	}
	
	echo json_encode($inv);
	
	mysqli_stmt_close($statement);
	
?> 