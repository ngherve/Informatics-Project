<?php

$conn = mysqli_connect("localhost", "root", "", "WirelecDatabase");

	if(isset($_POST["P_Code"]) && isset($_POST["P_Image"])){
		$P_Code = $_POST["P_Code"];
		$P_Image = $_POST["P_Image"];
	}

    $path = "profile_image/damprod$P_Code.jpeg";
    $finalPath = "http://10.254.17.96:80/script/".$path;

    $sql = "UPDATE Damaged SET P_Photo='$finalPath' WHERE P_ID='$P_Code' ";

    if (mysqli_query($conn, $sql)) {
        
        if ( file_put_contents( $path, base64_decode($P_Image) ) ) {
            
            $result['success'] = "1";
            $result['message'] = "success";

            echo json_encode($result);
            mysqli_close($conn);

        }

    }



?>