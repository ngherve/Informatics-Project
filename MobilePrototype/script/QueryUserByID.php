  <?php
	$con = mysqli_connect("localhost", "root", "", "WirelecDatabase");
	
	if(isset($_POST["UserID"])){
		$UserID = $_POST["UserID"];
	}
	
	$statement = mysqli_prepare($con, "SELECT * FROM User WHERE UserID = ?");
	mysqli_stmt_bind_param($statement, "s", $UserID);
	mysqli_stmt_execute($statement);

	mysqli_stmt_store_result($statement);
	mysqli_stmt_bind_result($statement, $UserID, $Name, $Username, $Email, $Password, $Tel_Number, $Address, $Gender, $DOB, $User_Type, $pphoto);
	
	$response = array();
	
	while(mysqli_stmt_fetch($statement)){
		$response["UserID"] = $UserID;
		$response["Name"] = $Name;
		$response["Username"] = $Username;
		$response["Email"] = $Email;
		$response["Password"] = $Password;
		$response["Tel_Number"] = $Tel_Number;
		$response["Address"] = $Address;
		$response["Gender"] = $Gender;
		$response["DOB"] = $DOB;
		$response["User_Type"] = $User_Type;
		$response["pphoto"] = $pphoto;
	}
	
	echo json_encode($response);
	
	mysqli_stmt_close($statement);
	
	mysqli_close($con);
?> 