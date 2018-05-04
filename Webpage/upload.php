<?php
   require("connect.php");
	session_start();

	$uploadsender=$_POST["sender"];
	$uploadsubject=$_POST["subject"];
	$uploadbody=$_POST["uploadfile"];
	$uploadorg=$_SESSION['login_user'];
	
	$mysql_qry="INSERT INTO `notes`(`id`, `sender`, `subject`, `files`, `date`, `org_name`) VALUES ('','$uploadsender','$uploadsubject','$uploadbody',CURRENT_TIMESTAMP(),'$uploadorg');";
	$result=mysqli_query($db,$mysql_qry);

	if(($result)>0){
		header ("Location: http://localhost/notifyme/notes.php");
		
	}else
	{	echo "failed";
	}
	
?>

