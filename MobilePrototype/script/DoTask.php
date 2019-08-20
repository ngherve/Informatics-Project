 <?php
	$con = mysqli_connect("localhost", "root", "", "WirelecDatabase");
	
	if($_SERVER['REQUEST_METHOD'] == 'POST'){
	
	//if(isset($_POST["Task_ID"]) && isset($_POST["End_Date"]) && isset($_POST["Status"])){
		$Task_ID = $_POST["Task_ID"];
		$End_Date = $_POST["End_Date"];
		$Status = $_POST["Status"];
	//}
		$sql = "UPDATE Task SET End_Date='$End_Date', Status='$Status' WHERE Task_ID='$Task_ID' ";
		if(mysqli_query($con, $sql)) {

			$result["success"] = "1";
			$result["message"] = "success";
			echo json_encode($result);
			mysqli_close($con);
		}
	} else{

	    $result["success"] = "0";
	    $result["message"] = "error!";
	    echo json_encode($result);

	    mysqli_close($con);
	}
		
?> 