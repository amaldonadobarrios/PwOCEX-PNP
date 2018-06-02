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
				<button class="btn btn-default" onclick="fnconsultar();"
					type="button">Consultar</button>
			</span>
		</div>
	</div>

</div>
<!-- Form with icon prefixes -->

<div class="col s12 m12 l6">
	<div class="card-panel">


		<div class="container">
			<div id="tabs">
				<ul>
					<li><a href="#tabs-1">Datos Personales</a></li>
					<li><a href="#tabs-2" id="auto">Datos de las vacaciones o Autorización</a></li>
					<li><a href="#tabs-3" id="medica">Ficha médica</a></li>
					<li><a href="#tabs-4" id="arma">Papeleta de Revista de Armamento</a></li>
				</ul>
				<div id="tabs-1">
					<div class="container">
						<div class="card-panel">

							<div class="row" style="color: black;">
								<form class="col s12">
									<div class="row center-align">
										<img class="responsive-img circle" alt="" id="foto"
											src=""
											height="240" width="200">
									</div>
									<div class="row" style="color: black;">
										<input id="id_per" value=" " type="hidden">
										<div class="container">
											<div class="col l6">
												<label>N° CIP:</label> <input id="txtdni" value=" "
													type="text"> <label>N° DNI:</label> <input
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
											<label> Datos sin verificar <input type="checkbox">
												<span class="lever"></span> Datos verificados
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
										<h5 align="center" style="color: black;">MODALIDAD :
											VACACIONES</h5>
									</div>
									<div class="row">
										<br>
										<div class="row" style="color: black;">
											<input id="id_autorizacion" value=" " type="hidden">
											<div class="container">
												<div class="col l6">
													<label for="ivac">Inicio Vacaciones</label><input
														type="text" id="datepicker1"> <label for="fvac">Fin
														Vacaciones</label><input type="text" id="datepicker2"> <label
														for="dias vacaciones">Dias de Vacaciones</label><input
														id="txtdiasvac" value="" type="number"> <label>Año
														autorizado</label><input id="txtaño" value="" type="number">
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
												</div>
												<div class="col l6 center-align">
													<img class="materialboxed" 
														data-caption="Orden de Vacaciones o Autorización"
														width="250" id="autorizacion"
														src="">
												</div>
											</div>
										</div>
									</div>
								</form>
								<div align="center" class="row">
									<div class="col l6">
										<div class="switch">
											<label> Datos sin verificar <input type="checkbox">
												<span class="lever"></span> Datos verificados
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
															<option value="" disabled selected>Aptitud Médica</option>
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
												<img class="materialboxed"
													data-caption="Constancia de Ficha médica"
													width="250" id="ficha"
													src="">
											</div>
										</div>
									</div>
							</div>
							
							<div align="center" class="row">
								<div class="col l6">
									<div class="switch">
										<label> Datos sin verificar <input type="checkbox">
											<span class="lever"></span> Datos verificados
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
						<input id="municion" type="text" value="50" readonly="readonly"> <label
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
											</div>
										</div>
										<div class="col l6 center-align" >
											<img class="materialboxed"
												data-caption="Papeleta de Revista de arma"
												width="250" id="arma"
												src="">
										</div>
									</div>
								</div>
						</div>
						<div align="center" class="row">
							<div class="col l6">
								<div class="switch">
									<label> Datos sin verificar <input type="checkbox">
										<span class="lever"></span> Datos verificados
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



