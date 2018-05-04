<?php
   require("connect.php");
	session_start();

	//$notedate=$_POST["date"];
	$notesender=$_POST["sender"];
	$notesubject=$_POST["subject"];
	$notebody=$_POST["body"];
	$notepin=$_POST["pin"];
	$noteorg=$_SESSION['login_user'];
	

			//set POST variables
			$url = 'http://localhost/notifyme/android/fcm/sendMultiplePush.php';
			$fields = array(
								  'title'=>urlencode($notesender),
								  'message'=>urlencode($notesubject),
								  'login'=>urlencode($noteorg),
							);

			//url-ify the data for the POST
			foreach($fields as $key=>$value) { $fields_string .= $key.'='.$value.'&'; }
			rtrim($fields_string,'&');

			//open connection
			$ch = curl_init();

			//set the url, number of POST vars, POST data
			curl_setopt($ch,CURLOPT_URL, $url);
			
			curl_setopt($ch, CURLOPT_POST, true);
			curl_setopt($ch,CURLOPT_POST, count($fields));
			curl_setopt($ch,CURLOPT_POSTFIELDS, $fields_string);

			//execute post
			$result = curl_exec($ch);
			
			//close connection
			curl_close($ch);
			
	
	$mysql_qry="INSERT INTO `notice`(`id`, `date`, `subject`, `sender`, `body`,`pin`,`org_name`) VALUES ('',CURRENT_TIMESTAMP(),'$notesubject','$notesender','$notebody','$notepin','$noteorg');";
	$result=mysqli_query($db,$mysql_qry);

	if(($result)>0){
		header ("Location: http://localhost/notifyme/list.php");
		
	}else
	{	echo "failed";
	}
	
?>

