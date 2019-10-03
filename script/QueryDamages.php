 <?php
	$con = mysqli_connect("localhost", "root", "", "WirelecDatabase");
	
	$statement = mysqli_prepare($con, "SELECT * FROM Damaged");
	mysqli_stmt_execute($statement);

	mysqli_stmt_store_result($statement);
	mysqli_stmt_bind_result($statement,$D_ID, $DateDamaged, $P_ID, $Quantity, $Description, $P_Photo);
	
	$product = array();
	
	while(mysqli_stmt_fetch($statement)){
		$temp = array();
		
		$temp["D_ID"] = $D_ID;
		$temp["DateDamaged"] = $DateDamaged;
		$temp["P_ID"] = $P_ID;
		$temp["Quantity"] = $Quantity;
		$temp["Description"] = $Description;
		$temp["P_Photo"] = $P_Photo;
		
		array_push($product, $temp);
	}
	
	echo json_encode($product);
	
	mysqli_stmt_close($statement);
	
?> 