 <?php
	$con = mysqli_connect("localhost", "root", "", "WirelecDatabase");
	
	if(isset($_POST["Name"]) && isset($_POST["Username"]) && isset($_POST["Email"])){
		$name = $_POST["Name"];
		$username = $_POST["Username"];
		$Email = $_POST["Email"];
	}
	
	$statement = mysqli_prepare($con, "SELECT * FROM User WHERE Name = ? OR Username = ? OR Email = ?");
	mysqli_stmt_bind_param($statement, "ss", $username, $password);
	mysqli_stmt_execute($statement);

	mysqli_stmt_store_result($statement);
	mysqli_stmt_bind_result($statement, $UserID, $Name, $Username, $Email, $Password, $Tel_Number, $Address, $Gender, $DOB, $User_Type, $pphoto);
	
	$response = array();
	$response["success"] = false;
	
	while(mysqli_stmt_fetch($statement)){
		$response["success"] = true;
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