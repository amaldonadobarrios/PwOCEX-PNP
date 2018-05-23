
<%
	String contextPath = request.getContextPath();
%>
<input type="hidden" id="contextPath" name="contextPath"
	value="<%=contextPath%>">
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
				<button class="btn btn-default" onclick="consultarcip()"
					type="button">Consultar</button>
			</span>
		</div>
	</div>
	<div class="col s12 m4 l4">
		<p></p>
	</div>
</div>
<!-- Form with icon prefixes -->
<div class="row">
	<div class="col s12 m12 l6">
		<div class="card-panel">
			<h4 class="header2 center-align">Datos Personales</h4>
			<div class="row">
				<form class="col s12">
					<div class="row center-align">
						<img class="responsive-img circle" alt="" id="foto" src=""
							height="240" width="200">
					</div>
					<div class="row">
						<div class="input-field col s12">
							<i class="mdi-action-account-circle prefix"></i> <input
								id="txtusuario" readonly="readonly" value=" " type="text">
							<label for="Apellidos y Nombres">Apellidos y Nombres</label>
						</div>
					</div>
					<div class="row">
						<div class="input-field col s12">
							<i class="mdi-action-credit-card prefix"></i> <input id="txtcip"
								readonly="readonly" value=" " type="text"> <label
								for="Número de CIP">N° DE CIP:</label>
						</div>
					</div>
					<div class="row">
						<div class="input-field col s12">
							<i class="mdi-action-credit-card prefix"></i> <input id="txtdni"
								readonly="readonly" value=" " type="text"> <label
								for="Número de DNI">N° DE DNI:</label>
						</div>
					</div>
					<div class="row">
						<div class="input-field col s12">
							<i class="mdi-communication-business prefix"></i> <input
								id="txtunidad" readonly="readonly" value=" " type="text">
							<label for="Unidad">Unidad:</label>
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
					<div class="container center-align">
						<div class="row">
							<label>Fecha de Charla</label> <input type="date" id="txtfechacharla" onchange="fnfechaload();"
								class="datepicker" />
						</div>
						<div class="input-field col s12">
							<div class="input-field col s12">
								<button class="btn cyan waves-effect waves-light" id="btnguardar"
									onclick="fngrabarcharla();" type="button">Guardar</button>
							</div>
						</div>
						<div class="row">
							<label>Fecha de Charla </label> <input type="text" id="txtfecha1"  readonly="readonly"/>
							<label>Fecha de Vigencia </label> <input type="text" id="txtfecha2"  readonly="readonly"/>
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
<script>
	function consultarcip() {
		var cip = $("#txtconsulta").val();
		var contexto = document.getElementById("contextPath").value;
		if (cip == '') {
			//vacio
		} else {
			if (cip > 0) {
				//es numero ok
				var vservlet = contexto + '/SUsuario';
				var txtevento = 'consultacipAguila';
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
	function fngrabarcharla() {
		var usuario = $("#txtusuario").val();
		var cip = $("#txtcip").val();
		var dni = $("#txtdni").val();
		var unidad = $("#txtunidad").val();
		var fechacharla = $("#txtfecha1").val();
		var fechavigencia = $("#txtfecha2").val();
		var contexto = document.getElementById("contextPath").value;
	if (cip>0) {
		if (fechacharla!='' && fechavigencia!='' ) {
			document.getElementById("btnguardar").disabled = true;
			var vservlet = contexto + '/SCharla';
			var txtevento = 'saveCharla';
			var jqdata = {
				hdEvento : txtevento,
				usuario : usuario,
				dni:dni,
				cip:cip,
				unidad:unidad,
				fechacharla:fechacharla,
				fechavigencia: fechavigencia
			};
			fnEjecutarPeticion(vservlet, jqdata, txtevento);
			
			
		}else{
			mensaje('SELECCIONE UN FECHA DE CHARLA');
		}	
	}else{
		mensaje('SELECCIONE UN EFECTIVO PNP');
	}	
	}
	
	
	
	
	function fnverfechaCharla() {
		var fecha = $("#txtfechacharla").val();
		return formatDate(fecha);
	}

	function fnfechaload(){
		
		var fechacharla = fnverfechaCharla();
		var fechavigencia=editar_fecha(fechacharla,'+3','m','-');
		$("#txtfecha1").val(fechacharla);
		$("#txtfecha2").val(fechavigencia);
	}
	
	
	
	
	
	
	
	
	function formatDate(date) {
	    var d = new Date(date),
	        month = '' + (d.getMonth() + 1),
	        day = '' + d.getDate(),
	        year = d.getFullYear();

	    if (month.length < 2) month = '0' + month;
	    if (day.length < 2) day = '0' + day;

	    return [day,month,year ].join('-');
	}
	
	function editar_fecha(fecha, intervalo, dma, separador) {
		 
		  var separador = separador || "-";
		  var arrayFecha = fecha.split(separador);
		  var dia = arrayFecha[0];
		  var mes = arrayFecha[1];
		  var anio = arrayFecha[2]; 
		  
		  var fechaInicial = new Date(anio, mes - 1, dia);
		  var fechaFinal = fechaInicial;
		  if(dma=="m" || dma=="M"){
		    fechaFinal.setMonth(fechaInicial.getMonth()+parseInt(intervalo));
		  }else if(dma=="y" || dma=="Y"){
		    fechaFinal.setFullYear(fechaInicial.getFullYear()+parseInt(intervalo));
		  }else if(dma=="d" || dma=="D"){
		    fechaFinal.setDate(fechaInicial.getDate()+parseInt(intervalo));
		  }else{
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

