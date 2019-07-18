<?php

if($_SERVER['REQUEST_METHOD'] == 'POST'){
	
	
	$con = mysqli_connect("localhost", "root", "", "WirelecDatabase");
	

    if(isset($_POST["UserID"]) && $_POST["Name"]) && isset($_POST["Password"]) && isset($_POST["Email"]) && isset($_POST["Tel_Number"]) &&
		isset($_POST["Username"]) && isset($_POST["Address"]) && isset($_POST["Gender"]) && isset($_POST["DOB"])){		
		$UserID = $_POST["UserID"];
		$Name = $_POST["Name"];
		$Username = $_POST["Username"];
		$Email = $_POST["Email"];
		$Password = $_POST["Password"];
		$Tel_Number = $_POST["Tel_Number"];
		$Address = $_POST["Address"];
		$Gender = $_POST["Gender"];
		$DOB = $_POST["DOB"];
	}

    $sql = "UPDATE User SET Username='$Username', Email='$Email' WHERE UserID='$UserID' ";

    if(mysqli_query($conn, $sql)) {

          $result["success"] = "1";
          $result["message"] = "success";

          echo json_encode($result);
          mysqli_close($conn);
      }
  }

else{

   $result["success"] = "0";
   $result["message"] = "error!";
   echo json_encode($result);

   mysqli_close($conn);
}

?>


