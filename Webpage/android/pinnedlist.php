<?php
$mysql_host='localhost';
$mysql_user='root';
$mysql_password='';
$mysql_db='notifyme';

$con=mysqli_connect($mysql_host,$mysql_user,$mysql_password,$mysql_db);

$note=$_POST["org_name"];

$mysql_qry="select * from notice where org_name like '$note' and pin like 'Yes' ORDER BY date DESC;";
$result = mysqli_query($con,$mysql_qry);
$json = array();
 
if(mysqli_num_rows($result)){
while($row=mysqli_fetch_assoc($result)){
$json['notice'][]=$row;
}
}
mysqli_close($con);
echo json_encode($json);
?>