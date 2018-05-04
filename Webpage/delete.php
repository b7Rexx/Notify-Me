<?php
require("connect.php");

$delfile=$_GET['id'];
$sql="DELETE FROM `notice` WHERE `id` LIKE '$delfile'";
$result=mysqli_query($db,$sql);

if(($result)>0){
		header ("Location: http://localhost/notifyme/list.php");
		
	}else
	{	echo "failed";
	}
?>