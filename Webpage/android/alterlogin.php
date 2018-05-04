<?php
require("connect.php");

$alterlogin=$_POST['orgname'];
$on_reg=$_POST['token'];

$mysqli_qry="UPDATE `devices` SET `login`='$alterlogin' WHERE `token`='$on_reg'";
$result=mysqli_query($db,$mysqli_qry);

echo json_encode($result);
?>