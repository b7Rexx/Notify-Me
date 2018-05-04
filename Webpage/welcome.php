<?php
require("connect.php");
session_start();
 $user_check = $_SESSION['login_user'];
if(!isset($user_check)){

		header("location: http://localhost/notifyme/home.php");
	}
?>


<!DOCTYPE html>
<!-- ==============================
    Project:       Notify-Me
   
================================== -->
<html lang="en" class="no-js" >
    <!-- BEGIN HEAD -->
    <head>
        <meta charset="utf-8"/>
        <title>Notify-Me : A notification system</title>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta content="width=device-width, initial-scale=1" name="viewport"/>
        <meta content="" name="description"/>
        <meta content="" name="author"/>

        <!-- GLOBAL MANDATORY STYLES -->
        <link href="http://fonts.googleapis.com/css?family=Hind:300,400,500,600,700" rel="stylesheet" type="text/css">
        <link href="vendor/simple-line-icons/simple-line-icons.min.css" rel="stylesheet" type="text/css"/>
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>

        <!-- PAGE LEVEL PLUGIN STYLES -->
        <link href="css/animate.css" rel="stylesheet">

        <!-- THEME STYLES -->
        <link href="css/layout.min.css" rel="stylesheet" type="text/css"/>

        <!-- Favicon -->
        <link rel="shortcut icon" href="favicon.ico"/>
    </head>
    <!-- END HEAD -->

    <!-- BODY -->
    <body>

        <!--========== HEADER ==========-->
        <header class="header navbar-fixed-top">
            <!-- Navbar -->
            <nav class="navbar" role="navigation">
                <div class="container">
                    <!-- Brand and toggle get grouped for better mobile display -->
                    <div class="menu-container">
                        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".nav-collapse">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="toggle-icon"></span>
                        </button>

                        <!-- Logo -->
                        <div class="logo">
                            <a class="logo-wrap" href="http://localhost/notifyme/home.php">
                                <img class="logo-img logo-img-main" src="img/logo.png" alt="Asentus Logo">
                                <img class="logo-img logo-img-active" src="img/logo-dark.png" alt="Asentus Logo">
                            </a>
                        </div>
                        <!-- End Logo -->
                    </div>

                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse nav-collapse">
                        <div class="menu-container">
                            <ul class="navbar-nav navbar-nav-right">
                                <li class="nav-item"><a class="nav-item-child nav-item-hover" href="home.php">Home</a></li>
								<li class="nav-item"><a class="nav-item-child nav-item-hover" href="list.php">Notice</a></li>
                                <li class="nav-item"><a class="nav-item-child nav-item-hover" href="notes.php">Notes</a></li>
								<li class="nav-item"><a class="nav-item-child nav-item-hover" href="about.php">About</a></li>
								<li class="nav-item"><a class="nav-item-child nav-item-hover" href="logout.php">Logout</a></li>
                            </ul>
                        </div>
                    </div>
                    <!-- End Navbar Collapse -->
                </div>
            </nav>
            <!-- Navbar -->
        </header>
        <!--========== END HEADER ==========-->

        <div class="parallax-window" data-parallax="scroll" data-image-src="img/1920x1080/01.jpg">
        <!--========== PARALLAX ==========-->
            <div class="parallax-content container">
                <h1 class="carousel-title">Notify-Me</h1>
                <p>A notification system that provides in hand notices <br/> with minimal effort and ease</p>
            </div>
        </div>
        <!--========== PARALLAX ==========-->

        

        <!--========== FOOTER ==========-->
        <footer class="footer">
            <!-- Links -->
            <div class="footer-seperator">
                <div class="content-lg container">
                    <div class="row">
					<div class="col-md-2 sm-margin-b-10">
                        </div>
                        <div class="col-md-5 sm-margin-b-10">
						<br></br><br></br>
						<h2>Welcome!</h2>
						<h5>This is the Admin Section of the Notify-Me.</h5> 
						<h5>Go to Notice and Notes page for the available services.</h5>
                        </div>
						<div class="col-md-3 sm-margin-b-10">
                        <div>
                            <img src="img/organization/<?php echo $user_check; ?>.jpg" width="100" height="100" class="img-circle" style="float:left"/><h1 class="text-uppercase" style="font-size:30px; color:#080957"><br></br><?php echo $user_check; ?></h1>
							<a href="list.php"class="customlink">Notice</a><br></br> <a href="notes.php"class="customlink">Note</a>
							</div>
						</div>
						
                    </div>
												
                    <!--// end row -->
                </div>
            </div>
            <!-- End Links -->

            <!-- Copyright -->
            <div class="content container">
                <div class="row">
                    <div class="col-xs-6">
                        <img class="footer-logo" src="img/logo.png" alt="Asentus Logo">
                    </div>
                    <div class="col-xs-6 text-right">
                        <p class="margin-b-0"><a class="color-base fweight-700" href="http://localhost/notifyme/home.php">Notify-Me</a> Powered by: <a class="color-base fweight-700" href="http://www.dunotdevelopers.com.np/">Dunot Developers</a></p>
                    </div>
                </div>
                <!--// end row -->
            </div>
            <!-- End Copyright -->
        </footer>
        <!--========== END FOOTER ==========-->

        <!-- Back To Top -->
        <a href="javascript:void(0);" class="js-back-to-top back-to-top">Top</a>

        <!-- JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->
        <!-- CORE PLUGINS -->
        <script src="vendor/jquery.min.js" type="text/javascript"></script>
        <script src="vendor/jquery-migrate.min.js" type="text/javascript"></script>
        <script src="vendor/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>

        <!-- PAGE LEVEL PLUGINS -->
        <script src="vendor/jquery.easing.js" type="text/javascript"></script>
        <script src="vendor/jquery.back-to-top.js" type="text/javascript"></script>
        <script src="vendor/jquery.smooth-scroll.js" type="text/javascript"></script>
        <script src="vendor/jquery.wow.min.js" type="text/javascript"></script>
        <script src="vendor/jquery.parallax.min.js" type="text/javascript"></script>

        <!-- PAGE LEVEL SCRIPTS -->
        <script src="js/layout.min.js" type="text/javascript"></script>
        <script src="js/components/wow.min.js" type="text/javascript"></script>
        <script src="js/components/gmap.min.js" type="text/javascript"></script>
        <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBsXUGTFS09pLVdsYEE9YrO2y4IAncAO2U&amp;callback=initMap" async defer></script>

    </body>
    <!-- END BODY -->
</html>