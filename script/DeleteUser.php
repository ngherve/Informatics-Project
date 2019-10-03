<?php
	
	$conn = mysqli_connect("localhost", "root", "", "WirelecDatabase");

	if($_SERVER['REQUEST_METHOD'] == 'POST'){
	
		
		$UserID = $_POST["UserID"];
		$Name = $_POST["Name"];
		$Username = $_POST["Username"];
		$Email = $_POST["Email"];
		$Password = $_POST["Password"];
		$Tel_Number = $_POST["Tel_Number"];
		$Address = $_POST["Address"];
		$Gender = $_POST["Gender"];
		$DOB = $_POST["DOB"];
	
		$sql = "UPDATE User SET Username='$Username', Name='$Name', Password='$Password', Tel_Number='$Tel_Number',
							Address='$Address', Gender='$Gender', DOB='$DOB', Email='$Email' WHERE UserID='$UserID' ";

		if(mysqli_query($conn, $sql)) {

			  $result["success"] = "1";
			  $result["message"] = "success";

			  echo json_encode($result);
			  mysqli_close($conn);
		}
	} else{

	   $result["success"] = "0";
	   $result["message"] = "error!";
	   echo json_encode($result);

	   mysqli_close($conn);
	}

?>


