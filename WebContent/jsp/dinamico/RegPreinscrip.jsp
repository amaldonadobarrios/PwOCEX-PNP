
<div id="preselecting-tab" class="section">
	<div class="card-panel">
		<h4 class="header">Seleccione su modalidad de Pre-inscripción</h4>
		<div class="row">

			<div class="col s12 m12 l12">
				<div class="row">
					<div class="col s12">
						<ul class="tabs tab-demo-active z-depth-1 cyan">
							<li class="tab col s3"><a
								class="white-text waves-effect waves-light" href="#vaca">VACACIONES</a>
							</li>
							<li class="tab col s3"><a
								class="white-text red darken-1 waves-effect waves-light"
								href="#franco">FRANCO</a></li>
						</ul>
					</div>
					<div class="col s12">
						<div id="vaca" class="col s12  cyan lighten-6">
							<div class="row">
								<div class="col s12 m12 l12">
									<div class="card-panel">
										<h4 class="header2">Registro de Pre-inscripción -
											Vacaciones</h4>
										<div class="row">
											<form class="col s12">
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
												<div class="row">
													<div class="input-field col s12">
														<div class="file-field input-field">
															<div class="btn">
																<span>Seleccionar Órden de Vacaciones</span> <input
																	type="file">
															</div>
															<div class="file-path-wrapper">
																<input class="file-path validate" type="text">
															</div>
														</div>
													</div>

												</div>
												<div class="input-field col s12">
													<button class="btn cyan waves-effect waves-light left"
														type="submit" name="action">
														Subir Órden de Vacaciones <i class="mdi-content-send left"></i>
													</button>
												</div>
											</form>
										</div>
									</div>

								</div>
							</div>
							<div class="col s12 m12 l12">
								<div class="card-panel">
									<h4 class="header2">Servicio de Custodia de Material
										Explosivo</h4>
									<div class="row">
										<form class="col s12">
											<div class="row">
												<div class="input-field col s4">
													<input type="date" class="datepicker" id="fechainiservicio"
														onchange="fnlimpiarservicio()"> <label
														for="Fecha Inicio Servicio Custodio">Fecha Inicio
														Servicio Custodio</label>
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
										</form>
									</div>
								</div>

							</div>



						</div>
						<div id="franco" class="col s12  red lighten-3">
							<div class="row">
								<div class="col s12 m12 l12">
									<div class="card-panel">
										<h4 class="header2">Registro de Pre-inscripción - Franco</h4>
										<div class="row">
											<form class="col s12">
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
											</form>
										</div>
									</div>

								</div>
								<div class="col s12 m12 l12">
									<div class="card-panel">
										<h4 class="header2">Servicio de Custodia de Material
											Explosivo</h4>
										<div class="row">
											<form class="col s12">
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
		<h4 class="header2">Ficha Médica</h4>
		<div class="row">
			<form class="col s12">
				<div class="row">
					<div class="input-field col s6">
						<select>
							<option value="" disabled selected>Aptitud Médica</option>
							<option value="A">A</option>
							<option value="B">B</option>
							<option value="C">C</option>
						</select> <label>Seleccione su aptitud Médica</label>
					</div>
					<div class="input-field col s6">
						<input type="text" maxlength="20"> <label for="dob">Numero
							De Constancia de Ficha Médica</label>
					</div>
				</div>
				<div class="row">
					<div class="input-field col s12">
						<div class="file-field input-field">
							<div class="btn">
								<span>Seleccionar Constancia de Ficha Médica</span> <input
									type="file">
							</div>
							<div class="file-path-wrapper">
								<input class="file-path validate" type="text">
							</div>
						</div>
					</div>

				</div>
				<div class="input-field col s12">
					<button class="btn cyan waves-effect waves-light left"
						type="submit" name="action">
						Subir Constancia de Ficha Médica <i class="mdi-content-send left"></i>
					</button>
				</div>
			</form>
		</div>
	</div>

</div>

<div class="col s12 m12 l12">
	<div class="card-panel">
		<h4 class="header2">Papeleta de Revista de Arma</h4>
		<div class="row">
			<form class="col s12">
				<div class="row">
					<div class="input-field col s4">
						<input id="first_name" type="text" value="PISTOLA" readonly="readonly"> <label
							for="Tipo">Tipo de Armamento </label>
					</div>

					<div class="input-field col s4">
						<input id="last_name" type="text" value=""> <label
							for="Serie">Serie del Armamento</label>
					</div>
					<div class="input-field col s4">
						<input id="last_name" type="text" value=""> <label
							for="Marca">Marca del Armamento</label>
					</div>
				</div>
				<div class="row">
					<div class="input-field col s4">
						<input id="first_name" type="text" value="" > <label
							for="Calibre">Calibre </label>
					</div>

					<div class="input-field col s4">
						<input id="last_name" type="text" value=""> <label
							for="N° DE CAF">N° DE CAF</label>
					</div>
					<div class="input-field col s4">
						<input id="last_name" type="text" value=""> <label
							for="MUNICIÓN">CANT. DE MUNICIÓN</label>
					</div>
				</div>
				<div class="row">
					<div class="input-field col s12">
						<div class="file-field input-field">
							<div class="btn">
								<span>Seleccionar Papeleta de Revista de Armamento</span> <input
									type="file">
							</div>
							<div class="file-path-wrapper">
								<input class="file-path validate" type="text">
							</div>
						</div>
					</div>

				</div>
				<div class="input-field col s12">
					<button class="btn cyan waves-effect waves-light left"
						type="submit" name="action">
						Subir Papeleta de Revista de Armamento <i
							class="mdi-content-send left"></i>
					</button>
				</div>
			</form>
		</div>
	</div>

</div>
<div class="col s12 m12 l12">
	<div class="card-panel">
		<h4 class="header2">Contacto</h4>
		<div class="row">
			<form class="col s12">
				<div class="row">
					<div class="input-field col s4">
						<i class="mdi-action-credit-card prefix"></i> <input
							id="mdi-action-credit-card" type="text"
							onkeypress="return solo_numeros(event);" maxlength="20"> <label
							for="mdi-action-credit-card">N° CUENTA DE AHORRO BANCO DE LA NACIÓN</label>
					</div>
					<div class="input-field col s4">
						<i class="mdi-communication-phone prefix"></i> <input
							id="icon_telephone" type="text"
							onkeypress="return solo_numeros(event);" maxlength="9"> <label
							for="icon_telephone">Telephone</label>
					</div>
					<div class="input-field col s4">
						<i class="mdi-action-home prefix"></i> <input id="mdi-action-home"
							type="text"> <label for="mdi-action-home">Domicilio</label>
					</div>

				</div>
			</form>
		</div>
	</div>

</div>
<script>
	function fnverfechavacaciones() {
		var fecha = $("#fechainivac").val();
		return formatDate(fecha);
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
		return formatDate(fecha);
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

	function formatDate(date) {
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
</script>

