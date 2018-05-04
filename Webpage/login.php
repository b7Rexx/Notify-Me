<?php
   require("connect.php");
	session_start();
	
    $orgname=$_POST["username"];
	$orgpass=$_POST["password"];
	  
    $mysql_qry="select * from organization where org_name like '$orgname' and admin_pass like '$orgpass'; ";
	$result=mysqli_query($db,$mysql_qry);
//	$row = mysqli_fetch_array($result,MYSQLI_ASSOC);
//    $active = $row['active'];

	$count = mysqli_num_rows($result);	
	
	 if($count == 1) {
       //  session_register("orgname");
         $_SESSION['login_user']=$orgname;
         
        header("location: http://localhost/notifyme/welcome.php");
		 
		}else { 
			header("location: http://localhost/notifyme/home.php");
		}
	

//	if(mysqli_num_rows($result)>0){
//		header ("Location: http://192.168.100.5/notifyme/welcome.php");
//	}else
//	{	echo "failed";
//	}
	
?>