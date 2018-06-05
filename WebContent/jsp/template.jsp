<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String sWS = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">



<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="msapplication-tap-highlight" content="no">
<meta name="description" content="EXPLOSIVOS OCEX PNP">
<meta name="keywords" content="EXPLOSIVOS OCEX PNP">
<title>SISTEMA OCEX PNP</title>

<!-- Favicons-->
<link rel="icon" href="images/ocex/escudo_ocex.ico" sizes="32x32">
<!-- Favicons-->
<link rel="apple-touch-icon-precomposed"
	href="images/ocex/escudo_ocex_2017.png">
<!-- For iPhone -->
<meta name="msapplication-TileColor" content="#00bcd4">
<meta name="msapplication-TileImage"
	content="images/ocex/escudo_ocex_2017.png">
<!-- For Windows Phone -->


<!-- CORE CSS-->

<link href="css/materialize.min.css" type="text/css" rel="stylesheet"
	media="screen,projection">
<link href="css/style.min.css" type="text/css" rel="stylesheet"
	media="screen,projection">
<!-- Custome CSS-->
<link href="css/custom/custom.min.css" type="text/css" rel="stylesheet"
	media="screen,projection">


<!-- INCLUDED PLUGIN CSS ON THIS PAGE -->
<link href="js/plugins/prism/prism.css" type="text/css" rel="stylesheet"
	media="screen,projection">
<link href="js/plugins/perfect-scrollbar/perfect-scrollbar.css"
	type="text/css" rel="stylesheet" media="screen,projection">
<link href="js/plugins/chartist-js/chartist.min.css" type="text/css"
	rel="stylesheet" media="screen,projection">
  <!--dropify-->
  <link href="js/plugins/dropify/css/dropify.min.css" type="text/css" rel="stylesheet" media="screen,projection">

<link href="css/ocex.css" type="text/css" rel="stylesheet" >


 <link rel="stylesheet" href="css/chosen.min.css">
  <link href="js/plugins/jsgrid/css/jsgrid.min.css" type="text/css" rel="stylesheet" media="screen,projection">
  <link href="js/plugins/jsgrid/css/jsgrid-theme.min.css" type="text/css" rel="stylesheet" media="screen,projection">

</head>

<body>
	<!-- Start Page Loading -->
	<div id="loader-wrapper">
		<div id="loader"></div>
		<div class="loader-section section-left"></div>
		<div class="loader-section section-right"></div>
	</div>
	<!-- End Page Loading -->

	<!-- //////////////////////////////////////////////////////////////////////////// -->

	<!-- START HEADER -->
	<%@include file="head.jspf"%>
	<!-- END HEADER -->

	<!-- //////////////////////////////////////////////////////////////////////////// -->

	<!-- START MAIN -->
	<div id="main">
		<!-- START WRAPPER -->
		<div class="wrapper">

			<!-- START LEFT SIDEBAR NAV-->
			<%@include file="menu.jspf"%>
			<!-- END LEFT SIDEBAR NAV-->

			<!-- //////////////////////////////////////////////////////////////////////////// -->

			<!-- START CONTENT -->
			<section id="content"> <!--breadcrumbs start-->
			<div id="breadcrumbs-wrapper">
				<!-- Search for small screen -->

				<div class="container">
					<div class="row">
						<div class="col s12 m12 l12">
							<h5 class="breadcrumbs-title">${breadcrumb}</h5>
							<ol class="breadcrumbs">
								<li><a href="SPage?action=pagehome">Home</a></li>
								<li class="active"><a href="#">${breadcrumb}</a></li>
							</ol>
						</div>
					</div>
				</div>
			</div>
			<!--breadcrumbs end--> <!--start container-->
			<div class="container">
				<div class="section">
					<div id="card-alert" class="card orange">
						<div class="card-content white-text">
							<p>
								<i class="mdi-alert-warning"></i> ${breadcrumb2}
							</p>
						</div>
						<button type="button" class="close white-text"
							data-dismiss="alert" aria-label="Close">
							<span aria-hidden="true">×</span>
						</button>
					</div>


					<div class="divider"></div>
					<c:import url="dinamico/${body}.jsp" />
				</div>
			</section>
			<!-- END CONTENT -->
			<!-- //////////////////////////////////////////////////////////////////////////// -->
			<!-- START RIGHT SIDEBAR NAV-->

			<!-- LEFT RIGHT SIDEBAR NAV-->

		</div>
		<!-- END WRAPPER -->

	</div>
	<!-- END MAIN -->



	<!-- //////////////////////////////////////////////////////////////////////////// -->

	<!-- START FOOTER -->
	<footer class="page-footer">
	<div class="footer-copyright">
		<div class="container" align="center">DIRTIC PNP © 2018</div>
	</div>
	</footer>
	<!-- END FOOTER -->



	<!-- ================================================
    Scripts
    ================================================ -->

	<!-- jQuery Library -->
	<script type="text/javascript" src="js/plugins/jquery-1.11.2.min.js"></script>
	<!--materialize js-->
	<script type="text/javascript" src="js/materialize.min.js"></script>
	<!--prism-->
	<script type="text/javascript" src="js/plugins/prism/prism.js"></script>
	<!--scrollbar-->
	<script type="text/javascript"
		src="js/plugins/perfect-scrollbar/perfect-scrollbar.min.js"></script>
	<!-- chartist -->
	<script type="text/javascript"
		src="js/plugins/chartist-js/chartist.min.js"></script>

	<!--plugins.js - Some Specific JS codes for Plugin Settings-->
	<script type="text/javascript" src="js/plugins.min.js"></script>
	<!--custom-script.js - Add your own theme custom JS-->
	<script type="text/javascript" src="js/custom-script.js"></script>
	
	<script type="text/javascript" src="js/plugins/angular.min.js"></script>
	 <script type="text/javascript" src="js/plugins/dropify/js/dropify.min.js"></script>
	<script type="text/javascript" src="js/serverJS/controller.js"></script>
	<script type="text/javascript" src="js/dirtexto.js"></script>
	<script type="text/javascript" src="js/validator.js"></script>

  <link rel="stylesheet" href="js/jsquery/jquery-ui.css">
  <link rel="stylesheet" href="js/jsquery/jquery-ui.themedark.css">
  
  <script type="text/javascript" src="js/chosen.jquery.min.js"></script>
  
  <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.16/css/jquery.dataTables.css">
  
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.js"></script>
  
  
  <script type="text/javascript" src="js/plugins/data-tables/js/jquery.dataTables.min.js"></script>
 <script type="text/javascript" src="js/plugins/data-tables/data-tables-script.js"></script> 
     <script type="text/javascript" src="js/plugins/jsgrid/js/db.js"></script> <!--data-->
    <script type="text/javascript" src="js/plugins/jsgrid/js/jsgrid.min.js"></script>
    <script type="text/javascript" src="js/plugins/jsgrid/js/jsgrid-script.js"></script>
   
<!--   <script src="js/jsquery/jquery.js"></script> -->
  <script src="js/jsquery/jquery-ui.js"></script>
</body>
<script type="text/javascript">
	function mensaje(msj) {
		Materialize.toast(msj, 4000, 'rounded');
	}

	  $( function() {
    $( "#datepicker" ).datepicker();
    $( "#datepicker1" ).datepicker();
    $( "#datepicker2" ).datepicker();
    $( "#datepicker3" ).datepicker();
    $( "#datepicker4" ).datepicker();
  } );
	  $( function() {
	    $( "#tabs" ).tabs();
	  } );
	
	  
	  $(document).ready( function () {
		    $('#table1').DataTable();
		    $('#table2').DataTable();
		} );

</script>

</html>