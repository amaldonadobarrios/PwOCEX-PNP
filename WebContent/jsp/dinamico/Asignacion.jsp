<jsp:useBean id="now" class="java.util.Date" scope="request" />
<%
	String sWS = request.getContextPath();
%>

<input type="hidden" id="contexto" name="contexto" value="<%=sWS%>">
<input type="hidden" id="tipo" name="tipo" value="VACACIONES">
<input type="hidden" id="id_fichero3" name="id_fichero3" value="">
<div id="preselecting-tab" class="section">
	<div class="card-panel">
		<h4 class="header">Asignación</h4>
		<div class="row">
			<div class="col s12 m12 l12">
				<div class="row">
					<div class="col l6">
						<div class="input-field col s6">
							<select id="diasfranco" class="">
								<option value="" disabled selected>Seleccione U.E.A.</option>
								<option value="1">SCORPION</option>
								<option value="2">ANTAMINA</option>
							</select> <label>UEA</label>
						</div>
						<div class="input-field col s6">
							<label for="Guia de Tránmsito N°">GT NRO</label><input
								id="txtnumguia" value="" type="text">
						</div>
						<label for="Apellidos y Nombres">Dirección</label><input
							id="txtdireccion" value="" type="text"> <label
							for="Apellidos y Nombres">Departamento</label><input
							id="txtdepartamento" value="" type="text"> <label
							for="Nombres">Provincia</label><input id="txtprovincia" value=""
							type="text"> <label for="Situación">Distrito</label><input
							id="txtdistrito" value="" type="text"> <label
							for="Situación">Polvorin Autorizado</label><input
							id="txtdistrito" value="" type="text"> <label
							for="Situación">Dirección Polvorin</label><input id="txtdistrito"
							value="" type="text"> <label for="Situación">Empresa
							Transporte</label><input id="txtdistrito" value="" type="text"> <label
							for="Situación">Nombre Conductor</label><input id="txtdistrito"
							value="" type="text"> <label for="Situación">Licencia
							Conductor</label><input id="txtdistrito" value="" type="text"> <label
							for="Situación">Cantidad Jornales</label><input id="txtdistrito"
							value="" type="text">

					</div>
					<div class="col l6">
						<div class="row"><a class="waves-effect waves-light btn modal-trigger"
							href="#modal1">Modal</a></div>

						<div class="container">
							<table id="table1" class="display">
								<thead>
									<tr>
										<th>Column 1</th>
										<th>Column 2</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td>Row 1 Data 1</td>
										<td>Row 1 Data 2</td>
									</tr>
									
									<tr>
										<td>Row 2 Data 1</td>
										<td>Row 2 Data 2</td>
									</tr>
									
								</tbody>
							</table>




						</div>

					</div>
				</div>
			</div>
		</div>

	</div>
</div>











<div id="modals-demo" class="section">
	<div class="row">
		<div class="col s12 m8 l9">
			<div id="modal1" class="modal">
				<div class="modal-content default black-text" align="center">
					<div class="container">
							<table id="table2" class="display">
								<thead>
									<tr>
										<th>Column 1</th>
										<th>Column 2</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td>Row 1 Data 1</td>
										<td>Row 1 Data 2</td>
									</tr>
									
									<tr>
										<td>Row 2 Data 1</td>
										<td>Row 2 Data 2</td>
									</tr>
									
								</tbody>
							</table>
						</div>
				</div>
				<div class="modal-footer teal lighten-4">
					<a href="#"
						class="waves-effect waves-green btn-flat modal-action modal-close">ACEPTAR</a>
				</div>
			</div>
		</div>
	</div>
</div>