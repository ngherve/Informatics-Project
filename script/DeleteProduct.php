<?php
	
	$conn = mysqli_connect("localhost", "root", "", "WirelecDatabase");

	if($_SERVER['REQUEST_METHOD'] == 'POST'){
		
		$P_Code = $_POST["P_Code"];
		
	
		$sql = "DELETE FROM Product WHERE P_Code='$P_Code' ";

		if(mysqli_query($conn, $sql)) {

			  $result["success"] = true;

			  echo json_encode($result);
			  mysqli_close($conn);
		}
	} else{

	   $result["success"] = false;
	   
	   echo json_encode($result);

	   mysqli_close($conn);
	}

?>


