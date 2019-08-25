 <?php
	$con = mysqli_connect("localhost", "root", "", "WirelecDatabase");
	
	if(isset($_POST["UserID"]) && isset($_POST["Message"])&& isset($_POST["N_Datetime"])&& isset($_POST["N_Email"])){
		$UserID = $_POST["UserID"];
		$Message = $_POST["Message"];
		$N_Datetime = $_POST["N_Datetime"];
		$N_Email = $_POST["N_Email"];
	}
		
	$statement = mysqli_prepare($con, "INSERT INTO Notification (UserID, Message, N_Datetime, N_Email) 
									   VALUES (?, ?, ?, ?) ");
	mysqli_stmt_bind_param($statement, "ssss", $UserID, $Message, $N_Datetime, $N_Email);
	mysqli_stmt_execute($statement);
	
	$notif["success"] = true;
	
	echo json_encode($notif);
	
	mysqli_stmt_close($statement);
	mysqli_close($con);
	
?> 