 <?php
	$con = mysqli_connect("localhost", "root", "", "WirelecDatabase");
	
	$statement = mysqli_prepare($con, "SELECT * FROM Product");
	mysqli_stmt_execute($statement);

	mysqli_stmt_store_result($statement);
	mysqli_stmt_bind_result($statement,$P_ID, $P_Name, $P_Price, $P_Image, $P_Quantity, $Supplier_Name, $P_Type, $W_Name, $P_Code, $bin_location);
	
	$product = array();
	
	while(mysqli_stmt_fetch($statement)){
		$temp = array();
		
		$temp["P_ID"] = $P_ID;
		$temp["P_Name"] = $P_Name;
		$temp["P_Price"] = $P_Price;
		$temp["P_Image"] = $P_Image;
		$temp["P_Quantity"] = $P_Quantity;
		$temp["Supplier_Name"] = $Supplier_Name;
		$temp["P_Type"] = $P_Type;
		$temp["W_Name"] = $W_Name;
		$temp["P_Code"] = $P_Code;
		$temp["bin_location"] = $bin_location;
		
		array_push($product, $temp);
	}
	
	echo json_encode($product);
	
	mysqli_stmt_close($statement);
	
?> 