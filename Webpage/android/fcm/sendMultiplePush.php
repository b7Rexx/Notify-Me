<?php 

//importing required files 
require_once 'DbOperation.php';
require_once 'Firebase.php';
require_once 'Push.php'; 
 
$db = new DbOperation();
 
$response = array(); 

 //checking the required params 
 if(isset($_POST['title']) and isset($_POST['message']) and ($_POST['login'])) {
 //creating a new push
 $push = null;
 $push = new Push(
 $_POST['title'],
 $_POST['message']
		
 );
 
 
 //getting the push from push object
 $mPushNotification = $push->getPush(); 
 
 //getting the token from database object
if($_POST['login'] == "asd")
{
$devicetoken = $db->getAllTokens_asd();
}
 else if($_POST['login'] == "Dunot")
 {
$devicetoken = $db->getAllTokens_dunot();
 } else if($_POST['login'] == "home")
 {
$devicetoken = $db->getAllTokens_home();
 }

 

//creating firebase class object 
 $firebase = new Firebase(); 
 
 //sending push notification and displaying result 
 echo $firebase->send($devicetoken, $mPushNotification);

 }else{
 $response['error']=true;
 $response['message']='Parameters missing';
 }
 
echo json_encode($response);