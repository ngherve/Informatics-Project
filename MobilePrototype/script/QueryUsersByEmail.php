  <?php
	$con = mysqli_connect("localhost", "root", "", "WirelecDatabase");
	
	if(isset($_POST["Email"])){
		$Email = $_POST["Email"];
	}
	
	$statement = mysqli_prepare($con, "SELECT * FROM User WHERE Email = ?");
	mysqli_stmt_bind_param($statement, "s", $Email);
	mysqli_stmt_execute($statement);

	mysqli_stmt_store_result($statement);
	mysqli_stmt_bind_result($statement, $UserID, $Name, $Username, $Email, $Password, $Tel_Number, $Address, $Gender, $DOB, $User_Type, $pphoto);
	
	$response = array();
	
	while(mysqli_stmt_fetch($statement)){
		$response["UserID"] = $UserID;
		$response["Name"] = $Name;
		$response["Username"] = $Username;
		$response["Email"] = $Email;
		$response["Tel_Number"] = $Tel_Number;
		$response["Address"] = $Address;
		$response["Gender"] = $Gender;
	}
	
	echo json_encode($response);
	
	mysqli_stmt_close($statement);
	
	mysqli_close($con);
?> 