<?php
require("connect.php");

$delfile=$_GET['id'];
$sql="DELETE FROM `notes` WHERE `id` LIKE '$delfile'";
$result=mysqli_query($db,$sql);

if(($result)>0){
		header ("Location: http://localhost/notifyme/notes.php");
		
	}else
	{	echo "failed";
	}
?>