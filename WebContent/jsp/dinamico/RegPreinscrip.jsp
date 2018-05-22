
<div class="row center-align">
	<div class="col s12 m4 l4">
		<p></p>
	</div>
	<div class="col s12 m4 l4 center-align">
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
	<div class="col s12 m4 l4">
		<p></p>
	</div>
</div>
<!--Input Switches-->
	        <div class="row center-align">
	        <div class="card-panel">
            <div class="switch">
                    Enabled : 
                    <label>
                      Off
                      <input type="checkbox">
                      <span class="lever"></span> On
                    </label>
                  </div>
                  </div>
                  </div>
                  <!-- Disabled Switch -->
<!-- Form with icon prefixes -->
<div class="row">
	<div class="col s12 m12 l6">
		<div class="card-panel">
			<h4 class="header2 center-align">Datos Personales</h4>
			<div class="row">
				<form class="col s12">
					<div class="row center-align">
						<img class="responsive-img circle" alt=""
							src="https://aguila6.pnp.gob.pe/FotosTit/6/31424836.jpg"
							height="240" width="200">
					</div>
					<div class="row">
						<div class="input-field col s12">
							<i class="mdi-communication-email prefix"></i> <input id="email3"
								readonly="readonly" value="S1 PNP MALDONADO BARRIOS ALEXANDER"
								type="text"> <label for="Apellidos y Nombres">Apellidos
								y Nombres</label>
						</div>
					</div>
					<div class="row">
						<div class="input-field col s12">
							<i class="mdi-communication-email prefix"></i> <input id="email3"
								readonly="readonly" value="31424836" type="text"> <label
								for="Número de CIP">N° DE CIP:</label>
						</div>
					</div>

				</form>
			</div>
		</div>
	</div>
	<!-- Form with validation -->
	<div class="col s12 m12 l6">
		<div class="card-panel">
			<h4 class="header2 center-align">Datos de Usuario capacitacion</h4>
			<div class="row">
				<form class="col s12">
					<div class="row center-align">
						<div class="row">
							<div class="input-field col s6">
								<select multiple>
									<option value="" disabled="disabled" selected="selected">Asignar
										Roles</option>
									<option value="1">Custodio</option>
									<option value="2">Operador</option>
									<option value="3">Administrador</option>
								</select> <label>Asignar Roles</label>
							</div>
							<div class="input-field col s6">
								<input class="datepicker" type="date"> <label
									for="Fecha de documento">Fecha de documento</label>
							</div>
						</div>
						<div class="row">
							<div class="input-field col s12">
								<i class="mdi-communication-email prefix"></i> <input
									id="email3" type="text"> <label
									for="Apellidos y Nombres">Documento</label>
							</div>
						</div>
						<div class="row">
							<div class="input-field col s12">
								<i class="mdi-communication-email prefix"></i> <input
									id="email3" type="text"> <label
									for="Apellidos y Nombres">Dias Vigencia</label>
							</div>
						</div>
						<div class="row">
							<div class="input-field col s6">
								<select>
									<option value="" disabled="disabled" selected="selected">Seleccione
										su Estado</option>
									<option value="1">Activo</option>
									<option value="2">Desactivado</option>
								</select> <label>Estado</label>
							</div>
							<div class="input-field col s6">
								<input id="email3" type="text"> <label for="dob">Observaciones</label>
							</div>
						</div>
						<div class="input-field col s12">
							<div class="input-field col s12">
								<button class="btn cyan waves-effect waves-light"
									onclick="fnconsultar();" type="button">Guardar</button>

							</div>
						</div>
						<br>
					</div>



				</form>
			</div>
		</div>
	</div>
</div>
<!-- Inline Form -->

<!-- Inline form with placeholder -->

