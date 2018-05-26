<jsp:useBean id="now" class="java.util.Date" scope="request" />
<%
	String sWS = request.getContextPath();
%>


<script type="text/javascript">
function validar(){
	var estado=true;
	var tipo= $('#tipo').val();
	if (tipo!='') {
		if (tipo=='VACACIONES') {
			var fechainivac=$('#fechainivac').val();
			fechainivac=atDate(fechainivac);
			if (fechainivac=='') {
				estado=false;
				mensaje('Falta Seleccionar fecha de inicio de vacaciones');	
			}
			var txtdiasvac=$('#txtdiasvac').val();
			var fechafinvac=$('#fechafinvac').val();
			var fechainiservicio=$('#fechainiservicio').val();
			fechainiservicio=atDate(fechainiservicio);
			var txtdiasservicio= $('#txtdiasservicio').val();
			var fechafinservicio= $('#fechafinservicio').val();	
		}else if (tipo=='FRANCO') {
			var diasfranco = $('#diasfranco').val();
			var messervicio =$('#messervicio').val();
			var añoservicio =$('#añoservicio').val();
		}
		var aptitud= $('#aptitud').val();
		var pistola=$('#pistola').val();
		var serie=$('#serie').val();
		var marca =$('#marca').val();
		var calibre=$('#calibre').val();
		var caf=$('#caf').val();
		var municion= $('#municion').val();
		var nrorevista=$('#nrorevista').val();
		var unidadrevista=$('#unidadrevista').val();
		var cuenta=$('#cuenta').val();
		var telefono=$('#telefono').val();
		var domicilio=$('#domicilio').val();
	}else{
		estado=false;
		mensaje('Falta Seleccionar la modalidad del servicio');
	}
	var id_persona = $('#id_persona').val();
	var id_fichero1= $('#id_fichero1').val();
	var id_fichero2= $('#id_fichero2').val();
	var id_fichero3= $('#id_fichero3').val();
	return estado;	
}




function verautorizacion(){
	$( "#divautorizacion" ).toggle();
}
function verpapeleta(){
	$( "#divpapeleta" ).toggle();
}
function verfichamedica(){
	$("#divfichamedica").toggle();
}

function fn_registrar(){
	 if (confirm("ESTA SEGURO DE REGISTRAR SU PRE-INSCRIPCIÓN")) {
		 validar();
	    }
}


function fn_subirFichero(){
    var file = $('[name="myPDF"]');
    var filename = $.trim(file.val());
    if (filename !== '') {
    	 if (updateSize('uploadPDF') < 5000000) {
    		 var contexto = document.getElementById("contexto").value;
    			var vservlet = contexto + '/SFichero';
    	 		var load='<img  height="100px" width="100px" src="'+contexto+'/images/ocex/reloj.gif">';
    	 	     	$('#msjPDF').html(load);
    	 	     	fn_upload_ajax(vservlet);
         } else {
        	 var contexto = document.getElementById("contexto").value;
         	 $('#viewer').attr('src', 'about:blank');
              $('#uploadPDF').val('');
              var load='<img  height="50px" width="50px" src="'+contexto+'/images/ocex/error.png">';
             document.getElementById("msjPDF").innerHTML =  load+' ERROR, ARCHIVO SUPERA LOS 5MB';
         }
    	
    	
    }
}
function fn_upload_ajax(vservlet){
	$.ajax({
        url: vservlet,
        type: "POST",
        data: new FormData(document.getElementById("fileForm")),
        enctype: 'multipart/form-data',
        processData: false,
        contentType: false,
      }).done(function(data) {
    	//alert(data);
    	if (data!=null) {
    		if (data=='0') {
    			var contexto = document.getElementById("contexto").value;
            	 $('#viewer').attr('src', 'about:blank');
                 $('#uploadPDF').val('');
                 var load='<img  height="50px" width="50px" src="'+contexto+'/images/ocex/error.png">';
                document.getElementById("msjPDF").innerHTML =  load+' ERROR, NOMBRE MUY EXTENSO';	
			}else{
				var contexto = document.getElementById("contexto").value;
	    		var load ='<img  height="50px" width="50px" src="'+contexto+'/images/ocex/check.jpg">';
	    		$('#msjPDF').html(load);
	    		document.getElementById("id_fichero1").value=data;		
			}
    		
    		
		}
      }).fail(function(jqXHR, textStatus) {
    	  //alert(jqXHR.responseText);
    	  alert('File upload failed ...');
      });
}
</script>
<script type="text/javascript">
function fn_subirFichero1(){
    var file = $('[name="myPDF1"]');
    var filename = $.trim(file.val());
    if (filename !== '') {
    	 if (updateSize('uploadPDF1') < 5000000) {
    		 var contexto = document.getElementById("contexto").value;
    			var vservlet = contexto + '/SFichero';
    	 		var load='<img  height="100px" width="100px" src="'+contexto+'/images/ocex/reloj.gif">';
    	 	     	$('#msjPDF1').html(load);
    	 	     	fn_upload_ajax1(vservlet);
         } else {
        	 var contexto = document.getElementById("contexto").value;
         	 $('#viewer1').attr('src', 'about:blank');
              $('#uploadPDF1').val('');
              var load='<img  height="50px" width="50px" src="'+contexto+'/images/ocex/error.png">';
             document.getElementById("msjPDF1").innerHTML =  load+' ERROR, ARCHIVO SUPERA LOS 5MB';
         }
    	
    	
    }
}
function fn_upload_ajax1(vservlet){
	$.ajax({
        url: vservlet,
        type: "POST",
        data: new FormData(document.getElementById("fileForm1")),
        enctype: 'multipart/form-data',
        processData: false,
        contentType: false,
      }).done(function(data) {
    	//alert(data);
    	if (data!=null) {
    		if (data=='0') {
    			var contexto = document.getElementById("contexto").value;
            	 $('#viewer1').attr('src', 'about:blank');
                 $('#uploadPDF1').val('');
                 var load='<img  height="50px" width="50px" src="'+contexto+'/images/ocex/error.png">';
                document.getElementById("msjPDF1").innerHTML =  load+' ERROR, NOMBRE MUY EXTENSO';	
			}else{
				var contexto = document.getElementById("contexto").value;
	    		var load ='<img  height="50px" width="50px" src="'+contexto+'/images/ocex/check.jpg">';
	    		$('#msjPDF1').html(load);
	    		document.getElementById("id_fichero2").value=data;		
			}
    		
    		
		}
      }).fail(function(jqXHR, textStatus) {
    	  //alert(jqXHR.responseText);
    	  alert('File upload failed ...');
      });
}
</script>
<script type="text/javascript">
function fn_subirFichero2(){
    var file = $('[name="myPDF2"]');
    var filename = $.trim(file.val());
    if (filename !== '') {
    	 if (updateSize('uploadPDF2') < 5000000) {
    		 var contexto = document.getElementById("contexto").value;
    			var vservlet = contexto + '/SFichero';
    	 		var load='<img  height="100px" width="100px" src="'+contexto+'/images/ocex/reloj.gif">';
    	 	     	$('#msjPDF2').html(load);
    	 	     	fn_upload_ajax2(vservlet);
         } else {
        	 var contexto = document.getElementById("contexto").value;
         	 $('#viewer2').attr('src', 'about:blank');
              $('#uploadPDF2').val('');
              var load='<img  height="50px" width="50px" src="'+contexto+'/images/ocex/error.png">';
             document.getElementById("msjPDF2").innerHTML =  load+' ERROR, ARCHIVO SUPERA LOS 5MB';
         }
    	
    	
    }
}
function fn_upload_ajax2(vservlet){
	$.ajax({
        url: vservlet,
        type: "POST",
        data: new FormData(document.getElementById("fileForm2")),
        enctype: 'multipart/form-data',
        processData: false,
        contentType: false,
      }).done(function(data) {
    	//alert(data);
    	if (data!=null) {
    		if (data=='0') {
    			var contexto = document.getElementById("contexto").value;
            	 $('#viewer2').attr('src', 'about:blank');
                 $('#uploadPDF2').val('');
                 var load='<img  height="50px" width="50px" src="'+contexto+'/images/ocex/error.png">';
                document.getElementById("msjPDF2").innerHTML =  load+' ERROR, NOMBRE MUY EXTENSO';	
			}else{
				var contexto = document.getElementById("contexto").value;
	    		var load ='<img  height="50px" width="50px" src="'+contexto+'/images/ocex/check.jpg">';
	    		$('#msjPDF2').html(load);
	    		document.getElementById("id_fichero3").value=data;		
			}
    		
    		
		}
      }).fail(function(jqXHR, textStatus) {
    	  //alert(jqXHR.responseText);
    	  alert('File upload failed ...');
      });
}
</script>
<script>

    /**
    * definimos las variables que almacenar&aacute;n los componentes de la fecha actual
    */
    ahora      = new Date();
    ahoraDay   = ahora.getDate();
    ahoraMonth = ahora.getMonth();
    ahoraYear  = ahora.getYear();

    /**
	* Nestcape Navigator 4x cuenta el anyo a partir de 1900, por lo que es necesario
	* sumarle esa cantidad para obtener el anyo actual adecuadamente
	**/
	if (ahoraYear < 2000) 
        ahoraYear += 1900;

    /**
	* funcion para saber cuantos dias tiene cada mes
	*/


    /**
	* una vez que sabemos cuantos dias tiene cada mes
	* asignamos dinamicamente este numero al combo de los dias dependiendo 
	* del mes que aparezca en el combo de los meses
	*/
    function asignaDias()
    {
        comboDias = document.Fecha.seleccionaDia;
        comboMeses = document.Fecha.seleccionaMes;
        comboAnyos = document.formFecha.seleccionaAnyo;

        Month = comboMeses[comboMeses.selectedIndex].text;
        Year = comboAnyos[comboAnyos.selectedIndex].text;

        diasEnMes = cuantosDias(Month, Year);
        diasAhora = comboDias.length;

        if (diasAhora > diasEnMes)
        {
            for (i=0; i<(diasAhora-diasEnMes); i++)
            {
                comboDias.options[comboDias.options.length - 1] = null
            }
        }
        if (diasEnMes > diasAhora)
        {
            for (i=0; i<(diasEnMes-diasAhora); i++)
            {
                sumaOpcion = new Option(comboDias.options.length + 1);
                comboDias.options[comboDias.options.length]=sumaOpcion;
            }
        }
        if (comboDias.selectedIndex < 0) 
	         comboDias.selectedIndex = 0;
     }

    /**
	* ahora selecionamos en los combos los valores correspondientes 
	* a la fecha actual del sistema
	*/
    function ponDia()
    {
        comboDias = eval("document.formFecha.seleccionaDia");
        comboMeses = eval("document.formFecha.seleccionaMes");
        comboAnyos = eval("document.formFecha.seleccionaAnyo");

        comboAnyos[0].selected = true;
        comboMeses[ahoraMonth].selected = true;
  
        asignaDias();

        comboDias[ahoraDay-1].selected = true;
    }

    /**
	* esta funcion crea dinamicamente el comb o de los anyos, empezando
	* por el actual y acabando por el actual+masAnyos
	*/
    function rellenaAnyos(masAnyos)
    {
        cadena = "";

        for (i=0; i<masAnyos; i++)
        {
            cadena += "<option>";
            cadena += ahoraYear + i;
        }
        return cadena;
    }

  </script>
<input type="hidden" id="contexto" name="contexto" value="<%=sWS%>">
<input type="text" id="tipo" name="tipo" value="VACACIONES">
<input type="text" id="id_persona" name="id_persona" value="${sessionScope.persona.idPer}">
<input type="text" id="id_fichero1" name="id_fichero1" value="">
<input type="text" id="id_fichero2" name="id_fichero2" value="">
<input type="text" id="id_fichero3" name="id_fichero3" value="">
<div id="preselecting-tab" class="section">
	<div class="card-panel">
		<h4 class="header">Seleccione su modalidad de Pre-inscripción</h4>
		<div class="row">

			<div class="col s12 m12 l12">
				<div class="row">
					<div class="col s12">
						<ul class="tabs tab-demo-active z-depth-1 cyan">
							<li class="tab col s3"><a
								class="white-text waves-effect waves-light tooltipped "
								data-position="center" data-delay="50"
								data-tooltip="Seleccione aqui si estará disponible de vacaciones"
								href="#vaca" onclick="fn_tipo('VACACIONES')">VACACIONES</a></li>
							<li class="tab col s3"><a
								class="white-text red darken-1 waves-effect waves-light tooltipped "
								data-position="center" data-delay="50"
								data-tooltip="Seleccione aqui si estará disponible en sus dias de franco"
								href="#franco" onclick="fn_tipo('FRANCO')">FRANCO</a></li>
						</ul>
					</div>
					<div class="col s12">
						<div id="vaca" class="col s12  cyan lighten-6">
							<div class="row">
								<div class="col s12 m12 l12">
									<div class="card-panel">
										<h4 class="header2 tooltipped " data-position="left"
											data-delay="50"
											data-tooltip="Ingrese datos de las Vacaciones">Registro
											de Pre-inscripción - Vacaciones</h4>
										<div class="row">
											<div class="col s12">
												<div class="row">
													<div class="input-field col s6">
														<input id="first_name" type="text"
															value="${sessionScope.usuario}" readonly="readonly">
														<label for="first_name">Efectivo PNP</label>
													</div>

													<div class="input-field col s6">
														<input id="last_name" type="text"
															value="${sessionScope.unidad}" readonly="readonly">
														<label for="Unidad">Unidad</label>
													</div>
												</div>
												<div class="row">
													<div class="input-field col s4">
														<input type="date" class="datepicker" id="fechainivac"
															onchange="fnlimpiarvacaciones()"> <label
															for="Fecha Inicio Vacaciones">Fecha Inicio
															Vacaciones</label>
													</div>
													<div class="input-field col s4">
														<label for="dias">Dias de vacaciones</label> <input
															type="text" class="number"
															onkeypress="return solo_numeros(event);"
															onchange="fnfechaload();" maxlength="2" id="txtdiasvac">
													</div>

													<div class="input-field col s4">
														<input type="text" class="text" readonly="readonly"
															id="fechafinvac" value=" "> <label
															for="Fecha Inicio Vacaciones">Fecha Fin
															Vacaciones</label>
													</div>
												</div>

											</div>
										</div>

									</div>
								</div>
								<div class="col s12 m12 l12">
									<div class="card-panel">
										<h4 class="header2 tooltipped " data-position="left"
											data-delay="50" data-tooltip="Ingrese datos del servicio">Servicio
											de Custodia de Material Explosivo</h4>
										<div class="row">
											<div class="col s12">
												<div class="row">
													<div class="input-field col s4">
														<input type="date" class="datepicker"
															id="fechainiservicio" onchange="fnlimpiarservicio()">
														<label for="Fecha Inicio Servicio Custodio">Fecha
															Inicio Servicio Custodio</label>
													</div>
													<div class="input-field col s4">
														<label for="dias">Dias de disponibilidad para el
															servicio</label> <input type="text" class="number"
															onkeypress="return solo_numeros(event);"
															onchange="fnfechaloadservicio();" maxlength="2"
															id="txtdiasservicio">
													</div>

													<div class="input-field col s4">
														<input type="text" class="text" readonly="readonly"
															id="fechafinservicio" value=" "> <label
															for="Fecha Fin Servicio Custodio">Fecha Fin
															Servicio Custodio</label>
													</div>
												</div>
											</div>
										</div>
									</div>

								</div>


							</div>
						</div>
						<div id="franco" class="col s12  red lighten-3">
							<div class="row">
								<div class="col s12 m12 l12">
									<div class="card-panel">
										<h4 class="header2 tooltipped " data-position="left"
											data-delay="50"
											data-tooltip="Ingrese datos de la autorización">Registro de Pre-inscripción - Franco</h4>
										<div class="row">
											<div class="col s12">
												<div class="row">
													<div class="input-field col s6">
														<input id="first_name" type="text"
															value="${sessionScope.usuario}" readonly="readonly">
														<label for="first_name">Efectivo PNP</label>
													</div>

													<div class="input-field col s6">
														<input id="last_name" type="text"
															value="${sessionScope.unidad}" readonly="readonly">
														<label for="Unidad">Unidad</label>
													</div>
												</div>
											</div>
										</div>
									</div>

								</div>
								<div class="col s12 m12 l12">
									<div class="card-panel">
										<h4 class="header2 tooltipped " data-position="left"
											data-delay="50" data-tooltip="Ingrese datos del Servicio">Servicio de Custodia de Material Explosivo</h4>
										<div class="row">
											<div class="col s12">
												<div class="row">
													<div class="input-field col s6">
														<select id="diasfranco">
															<option value="" disabled selected>Dias de Franco</option>
															<option value="P">PARES</option>
															<option value="I">IMPARES</option>
														</select> <label>Seleccione Dias de Franco</label>
													</div>
													<div class="input-field col s6">
														<select id="messervicio">
															<option value="" disabled selected>Seleccione Mes disponible para el Servicio</option>
															<option value="1">Enero</option>
															<option value="2">Febrero</option>
															<option value="3">Marzo</option>
															<option value="4">Abril</option>
															<option value="5">Mayo</option>
															<option value="6">Junio</option>
															<option value="7">Julio</option>
															<option value="8">Agosto</option>
															<option value="9">Setiembre</option>
															<option value="10">Octubre</option>
															<option value="11">Noviembre</option>
															<option value="12">Diciembre</option>
														</select> <label>Seleccione Mes de Servicio</label>
													</div>
													<div class="input-field col s6">
														<select id="añoservicio">
															<option value="" disabled selected>Seleccione Año disponible para el Servicio</option>
															<script>document.write(rellenaAnyos(2));</script>
														</select> <label>Seleccione Año disponible para el Servicio</label>
													</div>

												</div>
											</div>
												<button class="waves-effect waves-light  btn" onclick="verautorizacion();">Adjuntar autorización</button>
											<div id="divautorizacion" style="display:none">
											<form id="fileForm">
												<div class="form-group" align="center">
													<label class="strong">Seleccione su Autorizacion</label>
													<input id="uploadPDF" type="file" name="myPDF"
														onchange="PreviewImage();" />&nbsp;
													<button type="button" onclick="fn_subirFichero();">
														 Guardar fichero
													</button>
													<div id="msjPDF"></div>
												</div>
												<div class="video-container" style="clear: both" align="center">
													<iframe id="viewer" frameborder="0" allowfullscreen> </iframe> 
												</div>
											</form>
											</div>
										</div>
									</div>

								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

		</div>
	</div>










</div>


<div class="col s12 m12 l12">
	<div class="card-panel">
		<h4 class="header2 tooltipped " data-position="left" data-delay="50"
			data-tooltip="Ingrese datos de la Ficha médica">Ficha Médica</h4>
		<div class="row">
			<div class="col s12">
				<div class="row">
					<div class="input-field col s6">
						<select id="aptitud">
							<option value="" disabled selected>Aptitud Médica</option>
							<option value="A">A</option>
							<option value="B">B</option>
							<option value="C">C</option>
						</select> <label>Seleccione su aptitud Médica</label>
					</div>
					<div class="input-field col s6">
						<input type="text" maxlength="20" id="nrofichamedica"> <label for="dob">Numero
							De Constancia de Ficha Médica</label>
					</div>
				</div>
				<button class="waves-effect waves-light  btn" onclick="verfichamedica();">Adjuntar Constancia de Ficha Médica</button>
				<div id="divfichamedica" style="display:none">
				<form id="fileForm1">
												<div class="form-group" align="center">
												<label class="strong">Seleccione su Constancia de Ficha Médica</label>
													<input id="uploadPDF1" type="file" name="myPDF1"
														onchange="PreviewImage1();" />&nbsp;
													<button type="button" onclick="fn_subirFichero1();">
														 Guardar fichero
													</button>
													<div id="msjPDF1"></div>
												</div>
												<div class="video-container" style="clear: both" align="center">
													<iframe id="viewer1" frameborder="0" allowfullscreen> </iframe> 
												</div>
											</form>
											</div>
			</div>
		</div>
	</div>

</div>

<div class="col s12 m12 l12">
	<div class="card-panel">
		<h4 class="header2 tooltipped " data-position="left" data-delay="50"
			data-tooltip="Ingrese datos del armamento">Papeleta de Revista
			de Arma</h4>
		<div class="row">
			<div class="col s12">
				<div class="row">
					<div class="input-field col s4">
						<input id="pistola" type="text" value="PISTOLA"
							readonly="readonly"> <label for="Tipo">Tipo de
							Armamento </label>
					</div>

					<div class="input-field col s4">
						<input id="serie" type="text" value=""> <label
							for="Serie">Serie del Armamento</label>
					</div>
					<div class="input-field col s4">
						<input id="marca" type="text" value=""> <label
							for="Marca">Marca del Armamento</label>
					</div>
				</div>
				<div class="row">
					<div class="input-field col s4">
						<input id="calibre" type="text" value=""> <label
							for="Calibre">Calibre </label>
					</div>

					<div class="input-field col s4">
						<input id="caf" type="text" value=""> <label
							for="N° DE CAF">N° DE CAF</label>
					</div>
					<div class="input-field col s4">
						<input id="municion" type="text" value=""> <label
							for="MUNICIÓN">CANT. DE MUNICIÓN</label>
					</div>
				</div>
				<div class="row">
					<div class="input-field col s6">
						<input id="nrorevista" type="text" value=""> <label
							for="N° Papeleta">Nro Papeleta Revista </label>
					</div>

					<div class="input-field col s6">
						<input id="unidadrevista" type="text" value=""> <label
							for="Unidad que emite papeleta">Unidad emite papeleta</label>
					</div>
				</div>
				<button class="waves-effect waves-light  btn" onclick="verpapeleta();">Adjuntar Papeleta de Armamento</button>
				
				<div id="divpapeleta" style="display:none">
				<form id="fileForm2">
												<div class="form-group" align="center">
													<label class="strong">Seleccione su Papeleta de Armamento</label>
													<input id="uploadPDF2" type="file" name="myPDF2"
														onchange="PreviewImage2();" />&nbsp;
													<button type="button" onclick="fn_subirFichero2();">
														 Guardar fichero
													</button>
													<div id="msjPDF2"></div>
												</div>
												<div class="video-container" style="clear: both" align="center">
													<iframe id="viewer2" frameborder="0" allowfullscreen> </iframe> 
												</div>
											</form>
											</div>
			</div>
		</div>
	</div>

</div>
<div class="col s12 m12 l12">
	<div class="card-panel">
		<h4 class="header2">Contacto</h4>
		<div class="row">
			<div class="col s12">
				<div class="row">
					<div class="input-field col s4">
						<i class="mdi-action-credit-card prefix"></i> <input
							id="cuenta" type="text"
							onkeypress="return solo_numeros(event);" maxlength="20">
						<label for="mdi-action-credit-card">N° CUENTA DE AHORRO
							BANCO DE LA NACIÓN</label>
					</div>
					<div class="input-field col s4">
						<i class="mdi-communication-phone prefix"></i> <input
							id="telefono" type="text"
							onkeypress="return solo_numeros(event);" maxlength="9"> <label
							for="icon_telephone">Telephone</label>
					</div>
					<div class="input-field col s4">
						<i class="mdi-action-home prefix"></i> <input id="domicilio"
							type="text"> <label for="mdi-action-home">Domicilio</label>
					</div>

				</div>
			</div>
		</div>
</div>
</div>
<div class="col s12 m12 l12">
	<div class="card-panel center">
	<a class="btn btn-large waves-effect waves-light light-green darken-4" onclick="fn_registrar();">REGISTRAR PRE INSCRIPCIÓN</a>
	</div>
	</div>
	<script type="text/javascript">
	function PreviewImage2() {
    	$('#msjPDF2').html('');
        var file = $('[name="myPDF2"]');
        var filename = $.trim(file.val());
        if (filename !== '') {
            if (isJpg(filename) || isPdf(filename)) {
                $('#viewer2').attr('src', 'about:blank');
                pdffile = document.getElementById("uploadPDF2").files[0];
                pdffile_url = URL.createObjectURL(pdffile);
                $('#viewer2').attr('src', pdffile_url);
            } else {
                $('#viewer2').attr('src', 'about:blank');
                $('#uploadPDF2').val('');
            }
        }
    }
	   function PreviewImage1() {
	    	$('#msjPDF1').html('');
	        var file = $('[name="myPDF1"]');
	        var filename = $.trim(file.val());
	        if (filename !== '') {
	            if (isJpg(filename) || isPdf(filename)) {
	                $('#viewer1').attr('src', 'about:blank');
	                pdffile = document.getElementById("uploadPDF1").files[0];
	                pdffile_url = URL.createObjectURL(pdffile);
	                $('#viewer1').attr('src', pdffile_url);
	            } else {
	                $('#viewer1').attr('src', 'about:blank');
	                $('#uploadPDF1').val('');
	            }
	        }
	    }
    function PreviewImage() {
    	$('#msjPDF').html('');
        var file = $('[name="myPDF"]');
        var filename = $.trim(file.val());
        if (filename !== '') {
            if (isJpg(filename) || isPdf(filename)) {
                $('#viewer').attr('src', 'about:blank');
                pdffile = document.getElementById("uploadPDF").files[0];
                pdffile_url = URL.createObjectURL(pdffile);
                $('#viewer').attr('src', pdffile_url);
            } else {
                $('#viewer').attr('src', 'about:blank');
                $('#uploadPDF').val('');
            }
        }
    }

    var isJpg = function (name) {
        return name.match(/jpg$/i)
    };
    var isPdf = function (name) {
        return name.match(/jpeg$/i)
    };  
    
    
    function updateSize(elementId) {
        var nBytes = 0,
                oFiles = document.getElementById(elementId).files,
                nFiles = oFiles.length;

        for (var nFileId = 0; nFileId < nFiles; nFileId++) {
            nBytes += oFiles[nFileId].size;
        }
        var sOutput = nBytes + " bytes";
        // optional code for multiples approximation
        for (var aMultiples = ["K", "M", "G", "T", "P", "E", "Z", "Y"], nMultiple = 0, nApprox = nBytes / 1024; nApprox > 1; nApprox /= 1024, nMultiple++) {
            sOutput = " (" + nApprox.toFixed(3) + aMultiples[nMultiple] + ")";
        }

        return nBytes;
    }
 
    
</script>
	<script>
	function fnverfechavacaciones() {
		var fecha = $("#fechainivac").val();
		return atDate(fecha);
	}
	function fnfechaload() {
		var dias = $("#txtdiasvac").val();
		if (dias == '') {
			$("#fechafinvac").val('');
		}
		if (dias == 'null') {
			$("#fechafinvac").val('');
		}
		if (dias > 30 || dias == 0) {
			mensaje('ERROR DIAS NO DEBE SER MAYOR A 30');
			$("#txtdiasvac").val('');
			$("#fechafinvac").val('');
		} else {
			var fecha = $("#fechainivac").val();
			if (fecha != '') {
				var dias = $("#txtdiasvac").val();
				var fechainivac = fnverfechavacaciones();
				var fechafinvac = editar_fecha(fechainivac, '+' + dias, 'd',
						'-');
				$("#fechafinvac").val(fechafinvac);
			} else {
				mensaje('ERROR PRIMERO DEBE INDICAR UNA FECHA DE INICIO');
				$("#txtdiasvac").val('');
				$("#fechafinvac").val('');
			}

		}

	}
	function fnlimpiarvacaciones() {
		$("#txtdiasvac").val('');
		$("#fechafinvac").val('');
	}
	function fnlimpiarservicio() {
		$("#txtdiasservicio").val('');
		$("#fechafinservicio").val('');
	}
	function fnverfechaservicio() {
		var fecha = $("#fechainiservicio").val();
		return atDate(fecha);
	}
	function fnfechaloadservicio() {
		var dias = $("#txtdiasservicio").val();
		if (dias == '') {
			$("#fechafinvac").val('');
		}
		if (dias == 'null') {
			$("#fechafinvac").val('');
		}
		if (dias > 30 || dias == 0) {
			mensaje('ERROR DIAS NO DEBE SER MAYOR A 30');
			$("#txtdiasservicio").val('');
			$("#fechafinservicio").val('');
		} else {
			var fecha = $("#fechainiservicio").val();
			if (fecha != '') {
				var dias = $("#txtdiasservicio").val();
				var fechainiservicio = fnverfechaservicio();
				var fechafinservicio = editar_fecha(fechainiservicio, '+'
						+ dias, 'd', '-');
				$("#fechafinservicio").val(fechafinservicio);
			} else {
				mensaje('ERROR PRIMERO DEBE INDICAR UNA FECHA DE DISPONIBILIDAD DE INICIO');
				$("#txtdiasservicio").val('');
				$("#fechafinservicio").val('');
			}

		}

	}

	function atDate(date) {
		var d = new Date(date), month = '' + (d.getMonth() + 1), day = ''
				+ d.getDate(), year = d.getFullYear();

		if (month.length < 2)
			month = '0' + month;
		if (day.length < 2)
			day = '0' + day;

		return [ day, month, year ].join('-');
	}

	function editar_fecha(fecha, intervalo, dma, separador) {

		var separador = separador || "-";
		var arrayFecha = fecha.split(separador);
		var dia = arrayFecha[0];
		var mes = arrayFecha[1];
		var anio = arrayFecha[2];

		var fechaInicial = new Date(anio, mes - 1, dia);
		var fechaFinal = fechaInicial;
		if (dma == "m" || dma == "M") {
			fechaFinal.setMonth(fechaInicial.getMonth() + parseInt(intervalo));
		} else if (dma == "y" || dma == "Y") {
			fechaFinal.setFullYear(fechaInicial.getFullYear()
					+ parseInt(intervalo));
		} else if (dma == "d" || dma == "D") {
			fechaFinal.setDate(fechaInicial.getDate() + parseInt(intervalo));
		} else {
			return fecha;
		}
		dia = fechaFinal.getDate();
		mes = fechaFinal.getMonth() + 1;
		anio = fechaFinal.getFullYear();

		dia = (dia.toString().length == 1) ? "0" + dia.toString() : dia;
		mes = (mes.toString().length == 1) ? "0" + mes.toString() : mes;

		return dia + "-" + mes + "-" + anio;
	}
	function fn_tipo(a){
		$('#tipo').val(a);	
	}
</script>
