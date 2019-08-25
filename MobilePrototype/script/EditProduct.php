 <?php
	
	$conn = mysqli_connect("localhost", "root", "", "WirelecDatabase");

	if($_SERVER['REQUEST_METHOD'] == 'POST'){
	
		$P_Name = $_POST["P_Name"];
		$P_Price = $_POST["P_Price"];
		$P_Quantity = $_POST["P_Quantity"];
		$Supplier_Name = $_POST["Supplier_Name"];
		$P_Type = $_POST["P_Type"];
		$W_Name = $_POST["W_Name"];
		$P_Code = $_POST["P_Code"];
		$bin_location = $_POST["bin_location"];
	
		$sql = "UPDATE Product SET P_Name='$P_Name', P_Price='$P_Price', P_Quantity='$P_Quantity', 
				Supplier_Name='$Supplier_Name', P_Type='$P_Type', W_Name='$W_Name', bin_location='$bin_location' 
				WHERE P_Code='$P_Code' ";

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


