<?php

$conn = mysqli_connect("localhost", "root", "", "WirelecDatabase");

	if(isset($_POST["UserID"]) && isset($_POST["pphoto"])){
		$UserID = $_POST["UserID"];
		$pphoto = $_POST["pphoto"];
	}

    $path = "profile_image/$UserID.jpeg";
    $finalPath = "http://10.254.17.96:80/script/".$path;

    $sql = "UPDATE User SET pphoto='$finalPath' WHERE UserID='$UserID' ";

    if (mysqli_query($conn, $sql)) {
        
        if ( file_put_contents( $path, base64_decode($pphoto) ) ) {
            
            $result['success'] = "1";
            $result['message'] = "success";

            echo json_encode($result);
            mysqli_close($conn);

        }

    }



?>