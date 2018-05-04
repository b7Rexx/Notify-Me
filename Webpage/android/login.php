<?php
require("connect.php");
$orgname=$_POST["org_name"];
$orgpass=$_POST["org_pass"];
$alterorg=$_POST["alterorg"];
$mysql_qry="select * from organization where org_name like '$orgname' and password like '$orgpass'; ";
$result=mysqli_query($db,$mysql_qry);

if(mysqli_num_rows($result)>0){

$qry="UPDATE `devices` SET `login`='$orgname' WHERE `token`='$alterorg'";
$response=mysqli_query($db,$qry);
	echo "success";
}else
{echo "failed";
}

?>