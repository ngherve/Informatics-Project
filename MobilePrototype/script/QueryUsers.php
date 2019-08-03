 <?php
	$con = mysqli_connect("localhost", "root", "", "WirelecDatabase");
	
	
	$statement = mysqli_prepare($con, "SELECT * FROM User");
	mysqli_stmt_execute($statement);

	mysqli_stmt_store_result($statement);
	mysqli_stmt_bind_result($statement, $UserID, $Name, $Username, $Email, $Password, $Tel_Number, $Address, $Gender, $DOB, $User_Type, $pphoto);
		
	$users = array();
	
	while(mysqli_stmt_fetch($statement)){
		$temp = array();

		$temp["UserID"] = $UserID;
		$temp["Name"] = $Name;
		$temp["Username"] = $Username;
		$temp["Email"] = $Email;
		$temp["Password"] = $Password;
		$temp["Tel_Number"] = $Tel_Number;
		$temp["Address"] = $Address;
		$temp["Gender"] = $Gender;
		$temp["DOB"] = $DOB;
		$temp["User_Type"] = $User_Type;
		$temp["pphoto"] = $pphoto;
		array_push($users, $temp);
	}
	
	echo json_encode($users);
	
	mysqli_stmt_close($statement);
	
	mysqli_close($con);
?> 