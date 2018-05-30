<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="javax.servlet.ServletRequest"%>
<%@page import="com.captcha.botdetect.web.servlet.Captcha"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
	href="images/ocex/escudo_ocex.ico">
<!-- For iPhone -->
<meta name="msapplication-TileColor" content="#00bcd4">
<meta name="msapplication-TileImage"
	content="images/ocex/escudo_ocex.ico">
<!-- For Windows Phone -->


<!-- CORE CSS-->

<link href="css/materialize.min.css" type="text/css" rel="stylesheet"
	media="screen,projection">
<link href="css/style.min.css" type="text/css" rel="stylesheet"
	media="screen,projection">
<!-- Custome CSS-->
<link href="css/custom/custom.min.css" type="text/css" rel="stylesheet"
	media="screen,projection">
<link href="css/layouts/page-center.css" type="text/css"
	rel="stylesheet" media="screen,projection">

<!-- INCLUDED PLUGIN CSS ON THIS PAGE -->
<link href="js/plugins/prism/prism.css" type="text/css" rel="stylesheet"
	media="screen,projection">
<link href="js/plugins/perfect-scrollbar/perfect-scrollbar.css"
	type="text/css" rel="stylesheet" media="screen,projection">
</head>
<body class="cyan">
  <!-- Start Page Loading -->
  <div id="loader-wrapper">
      <div id="loader"></div>        
      <div class="loader-section section-left"></div>
      <div class="loader-section section-right"></div>
  </div>
  <!-- End Page Loading -->


  <div id="login-page" class="row">
    <div class="col s12 z-depth-4 card-panel">
      <form class="login-form" data-toggle="validator" role="form" action="SSeguridad"
					method="post">
        <div class="row">
          <div class="input-field col s12 center">
            <img src="images/ocex/escudo_ocex_2017.png" alt="" class="responsive-img valign profile-image-login">
            <p class="center login-form-text">SISTEMA OCEX PNP</p>
          </div>
        </div>
        <div class="row margin">
          <div class="input-field col s12">
            <i class="mdi-social-person-outline prefix"></i>
            <input id="username" name="username" required="required" type="text"
							placeholder="Ingrese su usuario" value="31424836">
            <label for="username" class="center-align">N° de CIP</label>
          </div>
        </div>
        <div class="row margin">
          <div class="input-field col s12">
            <i class="mdi-action-lock-outline prefix"></i>
            <input id="password" name="password"
							type="password" placeholder="Ingrese su contraseña"
							required="required" value="marian16">
            <label for="password">Contraseña</label>
          </div>
        </div>
        <div class="row margin">
						<div class="col-lg-3"></div>
						<div class="form-group">
							<div class="panel-body">
								<div align="center">
									<%
										Captcha captcha = Captcha.load(request, "exampleCaptcha");
										captcha.setUserInputID("captchaCode");
										String captchaHtml = captcha.getHtml();
										out.write(captchaHtml);
									%>
								</div>

							</div>
							<div class="form-group has-error" style="align-content: center; text-align: center;">
								<input name="captchaCode" type="text" id="captchaCode"
									class="form-control" required="required"  style="align-content: center; text-align: center;"/>
							</div>
						</div>
					</div>
        <div class="row">
          <div class="input-field col s12">
            <button type="submit" class="btn waves-effect waves-light col s12">INGRESAR</button>
          </div>
        </div>
        
      </form>
      <c:if test="${msg!=null}">
					<div class="alert alert-danger" align="center">
						<strong>ERROR!</strong> ${msg}
					</div>
				</c:if>
    </div>
  </div>



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
  <script type="text/javascript" src="js/plugins/perfect-scrollbar/perfect-scrollbar.min.js"></script>

      <!--plugins.js - Some Specific JS codes for Plugin Settings-->
    <script type="text/javascript" src="js/plugins.min.js"></script>
    <!--custom-script.js - Add your own theme custom JS-->
    <script type="text/javascript" src="js/custom-script.js"></script>

</body>
</html>