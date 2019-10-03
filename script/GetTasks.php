<?php
	$con = mysqli_connect("localhost", "root", "", "WirelecDatabase");
	
	$statement = mysqli_prepare($con, "SELECT * FROM Task");
	mysqli_stmt_execute($statement);

	mysqli_stmt_store_result($statement);
	mysqli_stmt_bind_result($statement,$Task_ID, $UserID, $TaskContent, $Start_Date, $End_Date, $Priority, $Status, $T_Type);
	
	$product = array();
	
	while(mysqli_stmt_fetch($statement)){
		$temp = array();
		
		$temp["Task_ID"] = $Task_ID;
		$temp["UserID"] = $UserID;
		$temp["TaskContent"] = $TaskContent;
		$temp["Start_Date"] = $Start_Date;
		$temp["End_Date"] = $End_Date;
		$temp["Priority"] = $Priority;
		$temp["Status"] = $Status;
		$temp["T_Type"] = $T_Type;
		
		array_push($product, $temp);
	}
	
	echo json_encode($product);
	
	mysqli_stmt_close($statement);
	mysqli_close($con);
	
?> 