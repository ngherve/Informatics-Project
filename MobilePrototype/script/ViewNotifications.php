 <?php
	$con = mysqli_connect("localhost", "root", "", "WirelecDatabase");
	
	if(isset($_POST["UserID"])){
		$UserID = $_POST["UserID"];
	}
	
	$statement = mysqli_prepare($con, "SELECT * FROM Notification WHERE UserID = ?");
	
	mysqli_stmt_bind_param($statement, "s", $UserID);
	mysqli_stmt_execute($statement);

	mysqli_stmt_store_result($statement);
	mysqli_stmt_bind_result($statement,$N_ID, $UserID, $Message, $N_Datetime, $N_Email);
	
	$notif = array();
	
	while(mysqli_stmt_fetch($statement)){
		$temp = array();
		
		$temp["N_ID"] = $N_ID;
		$temp["UserID"] = $UserID;
		$temp["Message"] = $Message;
		$temp["N_Datetime"] = $N_Datetime;
		$temp["N_Email"] = $N_Email;
		
		array_push($notif, $temp);
	}
	
	echo json_encode($notif);
	
	mysqli_stmt_close($statement);
	
?> 