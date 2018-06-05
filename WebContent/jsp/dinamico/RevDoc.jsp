
<%
	String sWS = request.getContextPath();
%>
<script>
	function next(a) {
		$('#' + a).click();

	}
</script>


<div class="row center-align" style="align-items: center;">

	<div class="col s12 m4 l4 offset-l4 offset-m4">
		<p></p>
		<div class="input-field">
			<input class="form-control" placeholder="Buscar por CIP"
				maxlength="8" onkeypress="return solo_numeros(event)"
				id="txtconsulta" name="txtconsulta" type="text"><span>
				<button class="btn btn-default" onclick="consultarcip();"
					type="button">Consultar</button>
			</span>
		</div>
	</div>

</div>
<!-- Form with icon prefixes -->

<div class="col s12 m12 l6">
	<div class="card-panel">
		<input type="hidden" id="contexto" name="contexto" value="<%=sWS%>">
		<input type="hidden" id="id_prein" name="id_prein" value=""> <input
			type="hidden" id="tipo" name="tipo" value="">
		<div class="container">
			<div id="tabs">
				<ul>
					<li><a href="#tabs-1">Datos Personales</a></li>
					<li><a href="#tabs-2" id="auto">Datos de las vacaciones o
							Autorización</a></li>
					<li><a href="#tabs-3" id="medica">Ficha médica</a></li>
					<li><a href="#tabs-4" id="arma">Papeleta de Revista de
							Armamento</a></li>
				</ul>
				<div id="tabs-1">
					<div class="container">
						<div class="card-panel">

							<div class="row" style="color: black;">
								<form class="col s12">
									<div class="row center-align" id="fotoperfil">
										<img class="responsive-img circle" alt="" id="foto" src=""
											height="240" width="200">
									</div>
									<div class="row" style="color: black;">
										<input id="id_per" value=" " type="hidden">
										<div class="container">
											<div class="col l6">
												<label>N° DNI:</label> <input id="txtdni" value=" "
													type="text"> <label>N° CIP:</label> <input
													id="txtcip" value=" " type="text"> <label
													for="Apellidos y Nombres">Grado</label><input id="txtgrado"
													value="" type="text"> <label
													for="Apellidos y Nombres">Apellidos Paterno</label><input
													id="txtpaterno" value="" type="text"> <label
													for="Apellidos y Nombres">Apellidos Materno</label><input
													id="txtmaterno" value="" type="text"> <label
													for="Nombres">Nombres</label><input id="txtnombres"
													value="" type="text"> <label for="Situación">Situación</label><input
													id="txtsituacion" readonly="readonly" value="" type="text">
											</div>
											<div class="col l6">
												<label for="Genero">Género</label><input id="txtgenero"
													readonly="readonly" value="" type="text"> <label
													for="Genero">Fecha de Nacimiento</label><input type="text"
													id="datepicker"> <label for="Unidad">Unidad</label><input
													id="txtunidad" value="" type="text"> <label
													for="Cuenta">Nro Cuenta de ahorros Banco de la
													Nación</label><input id="txtcuenta" value="" type="text"> <label
													for="Domicilio">Domicilio</label><input id="txtdom"
													value="" type="text"> <label for="Teléfono">Teléfono</label><input
													id="txttel" value="" type="number"> <label
													for="Correo">Correo Institucional</label><input
													id="txtcorreo" value="" type="text">
											</div>
										</div>
									</div>
								</form>
								<div align="center" class="row">
									<div class="col l6">
										<div class="switch">
											<label> Datos sin verificar <input type="checkbox"
												id="ck1"> <span class="lever"></span> Datos
												verificados
											</label>
										</div>
									</div>
									<div class="col l6">
										<a onclick="next('auto')" class="btn btn-default" type="btn">Siguiente</a>
									</div>
								</div>
							</div>
						</div>


					</div>
				</div>
				<div id="tabs-2">
					<div class="container">
						<div class="card-panel">
							<div class="row">
								<form class="col s12">
									<div class="row">
										<h5 align="center" style="color: black;" id="modoform">MODALIDAD
											:</h5>
									</div>
									<div class="row">
										<br>
										<div class="row" style="color: black;">
											<input id="id_autorizacion" value=" " type="hidden">
											<div class="container">
												<div class="col l6">
													<div id="divvacaciones">
														<label for="ivac">Inicio Vacaciones</label><input
															type="text" id="datepicker1"> <label for="fvac">Fin
															Vacaciones</label><input type="text" id="datepicker2"> <label
															for="dias vacaciones">Dias de Vacaciones</label><input
															id="txtdiasvac" value=" " type="number">
													</div>
													<DIV id="divfranco">
														<label>Año autorizado</label><input id="txtaño" value=""
															type="number">
														<div class="input-field col s6">
															<input type="text" id="diasfranco" value=" "> <label>Seleccione
																Dias de Franco</label>
														</div>

														<div class="input-field col s6">
															<input type="text" id="messervicio" value=" "> <label>Seleccione
																Mes de Servicio</label>
														</div>
													</DIV>
												</div>
												<div class="col l6 center-align">
													<div id="fotoauto"></div>
												</div>
											</div>
										</div>
									</div>
								</form>
								<div align="center" class="row">
									<div class="col l6">
										<div class="switch">
											<label> Datos sin verificar <input type="checkbox"
												id="ck2"> <span class="lever"></span> Datos
												verificados
											</label>
										</div>
									</div>
									<div class="col l6">
										<a onclick="next('medica')" class="btn btn-default" type="btn">Siguiente</a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div id="tabs-3">
					<div class="container">
						<div class="card-panel">
							<div class="row" style="color: black;">

								<div class="row">
									<br>
									<div class="row" style="color: black;">
										<input id="id_ficha" value=" " type="hidden">
										<div class="container">
											<div class="col l6">
												<div class="input-field col s12">
													<select id="aptitud">
														<option value="A">A</option>
														<option value="B">B</option>
														<option value="C">C</option>
													</select> <label>Seleccione su aptitud Médica</label>
												</div>
												<label for="ficha">N° Ficha Médica</label><input
													id="txtnficha" value="" type="text">
											</div>
										</div>
										<div class="col l6 center-align">
											<div id="fotomedico"></div>
										</div>
									</div>
								</div>
							</div>

							<div align="center" class="row">
								<div class="col l6">
									<div class="switch">
										<label> Datos sin verificar <input type="checkbox"
											id="ck3"> <span class="lever"></span> Datos
											verificados
										</label>
									</div>
								</div>
								<div class="col l6">
									<a onclick="next('arma')" class="btn btn-default" type="btn">Siguiente</a>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div id="tabs-4">
					<div class="container">
						<div class="card-panel">
							<div class="row" style="color: black;">

								<div class="row">
									<br>
									<div class="row" style="color: black;">
										<input id="id_arma" value=" " type="hidden">
										<div class="container">
											<div class="col l6">
												<div class="row">
													<div class="input-field col s4">
														<input id="pistola" type="text" value="PISTOLA"
															readonly="readonly"> <label for="Tipo">Tipo
															de Armamento </label>
													</div>

													<div class="input-field col s4">
														<input id="serie" type="text" value=" "> <label
															for="Serie">Serie del Armamento</label>
													</div>
													<div class="input-field col s4">
														<input id="marca" type="text" value=" "> <label
															for="Marca">Marca del Armamento</label>
													</div>
												</div>
												<div class="row">
													<div class="input-field col s4">
														<input id="calibre" type="text" value=" "> <label
															for="Calibre">Calibre </label>
													</div>

													<div class="input-field col s4">
														<input id="caf" type="text" value=" "> <label
															for="N° DE CAF">N° DE CAF</label>
													</div>
													<div class="input-field col s4">
														<input id="municion" type="text" value="50"
															readonly="readonly"> <label for="MUNICIÓN">CANT.
															DE MUNICIÓN</label>
													</div>
												</div>
												<div class="row">
													<div class="input-field col s6">
														<input id="nrorevista" type="text" value=" "> <label
															for="N° Papeleta">Nro Papeleta Revista </label>
													</div>

													<div class="input-field col s6">
														<input id="unidadrevista" type="text" value=" "> <label
															for="Unidad que emite papeleta">Unidad emite
															papeleta</label>
													</div>
												</div>
											</div>
										</div>
										<div class="col l6 center-align">
											<div id="fotoarma"></div>
										</div>
									</div>
								</div>
							</div>
							<div align="center" class="row">
								<div class="col l6">
									<div class="switch">
										<label> Datos sin verificar <input type="checkbox"
											id="ck4"> <span class="lever"></span> Datos
											verificados
										</label>
									</div>
								</div>
								<div class="col l6">
									<a onclick="guardar()" class="btn btn-default" type="btn">Guardar</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

		</div>

	</div>
</div>
<script>
	function consultarcip() {
		var cip = $("#txtconsulta").val();
		var contexto = document.getElementById("contexto").value;
		if (cip == '') {
			//vacio
		} else {
			if (cip > 0) {
				//es numero ok
				var vservlet = contexto + '/SPreinscripcion';
				var txtevento = 'consultarPreinscripcion';
				var jqdata = {
					hdEvento : txtevento,
					cip : cip
				};
				fnEjecutarPeticion(vservlet, jqdata, txtevento);
			} else {
				// dato no valido
			}
		}

	}
	function guardar() {

		var ck1 = $("#ck1").prop('checked')
		var ck2 = $("#ck2").prop('checked')
		var ck3 = $("#ck3").prop('checked')
		var ck4 = $("#ck4").prop('checked')
		var id_prein = $("#id_prein").val();
		var tipo = $("#tipo").val();
		var id_per = $("#id_per").val();
		var id_autorizacion = $("#id_autorizacion").val();
		var id_arma = $("#id_arma").val();
		var id_ficha = $("#id_ficha").val();

		if (id_prein != '') {
			if (ck1) {
				if (ck2) {
					if (ck3) {
						if (ck4) {
							if (confirm("ESTÁ SEGURO DE INSCRIBIR UN EFECTIVO DE "
									+ tipo)) {

								fninscribir();
							}

						} else {
							mensaje('FALTA VERIFICAR LOS DATOS DE LA PAPELETA DE REVISTA DE ARMA');
						}
					} else {
						mensaje('FALTA VERIFICAR LOS DATOS DE LA FICHA MÉDICA');
					}
				} else {
					mensaje('FALTA VERIFICAR LOS DATOS DE LA AUTORIZACIÓN');
				}
			} else {
				mensaje('FALTA VERIFICAR LOS DATOS BASICOS');
			}
		} else {
			mensaje('FALTA SELECCIONAR UN PREINSCRITO');
		}

	}

	function fninscribir() {
		var id_prein = $("#id_prein").val();
		var tipo = $("#tipo").val();
		var id_per = $("#id_per").val();
		var id_autorizacion = $("#id_autorizacion").val();
		var id_arma = $("#id_arma").val();
		var id_ficha = $("#id_ficha").val();
		var txtcip=$("#txtcip").val();
		var contexto = document.getElementById("contexto").value;
	
				//document.getElementById("btnguardar").disabled = true;
				var vservlet = contexto + '/SPreinscripcion';
				var txtevento = 'inscribir';
				var jqdata = {
					hdEvento : txtevento,
					id_prein : id_prein,
					tipo : tipo,
					id_per : id_per,
					id_autorizacion : id_autorizacion,
					id_arma : id_arma,
					id_ficha : id_ficha,
					txtcip:txtcip
				};
				fnEjecutarPeticion(vservlet, jqdata, txtevento);

			
	}
</script>


