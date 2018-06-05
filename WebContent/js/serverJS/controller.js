 function fnEjecutarPeticion(vservlet, jdata, evento) {
		$.ajax({
			url : vservlet,
			method : 'POST',
			data : jdata,
			success : function(responseText) {
				fnControlEvento(evento, responseText + '');
			}
		});
	}
function fnControlEvento(vevento, vvrespuesta) {
		if (vvrespuesta == 'ERROR_SESION') {
			window.location = 'SPage';
		} else {
			var v_resultado = vvrespuesta + "";
			if (v_resultado == 'NOSESION') {
				window.location = 'SPage?action=login';
			} else if (v_resultado == '') {
				//vacio	
			} else {
				if (vevento == 'consultacipAguila') {
				var respuesta = v_resultado;
					if(respuesta=='NOP'){
					mensaje('NO VALIDO');
					$("#txtusuario").val('');
					$("#txtcip").val('');
					$("#foto").attr('src', '');
					$("#txtdni").val('');
					$("#txtunidad").val('');
					}else{
					var usu=JSON.parse(respuesta);
					$("#txtusuario").val(usu.nombre);
					$("#txtcip").val(usu.cip);
					$("#txtdni").val(usu.dni);
					$("#txtunidad").val(usu.unidad);
					$("#foto").attr('src', 'data:image/png;base64,'+usu.foto);
					}
				}
				if (vevento == 'saveCharla') {
					var respuesta = v_resultado;
					document.getElementById("btnguardar").disabled = false;
						if(respuesta=='NOP'){
						mensaje('ERROR AL GRABAR');
						}else{
						mensaje('CORRECTO');
						$("#txtusuario").val(' ');
						$("#txtcip").val(' ');
						$("#txtdni").val(' ');
						$("#txtunidad").val(' ');
						$("#txtconsulta").val('');
						$("#foto").attr('src', '');
						}
					}
				if (vevento == 'consultarPreinscripcion') {
					var respuesta = v_resultado;
					//document.getElementById("btnguardar").disabled = false;
						if(respuesta=='NOK'){
						mensaje('CIP NO REGISTRADO EN LA PREINSCRIPCION  O YA SE ENCUENTRA INSCRITO');
						}else{
						mensaje('CORRECTO');
						var rpta = respuesta.split('$$$$$');
						
						var arrjson = rpta[0];
						var fotoperfil = rpta[1];
						var arr = JSON.parse(arrjson);
						var arrPersona = JSON.parse(arr[0]);
						$("#id_per").val(arrPersona.idPer);
						$("#txtcip").val(arrPersona.cipPer);
						$("#txtdni").val(arrPersona.dniPer);
						$("#txtgrado").val(arrPersona.gradoPer);
						$("#txtpaterno").val(arrPersona.apePatPer);
						$("#txtmaterno").val(arrPersona.apeMatPer);
						$("#txtnombres").val(arrPersona.nomPer);
						$("#txtsituacion").val('ACTIVIDAD');
						$("#txtgenero").val(arrPersona.genPer);
						$("#datepicker").val(arrPersona.fecNac);
						$("#txtunidad").val(arrPersona.nomUniPer);
						$("#txtcuenta").val(arrPersona.ctaAhorPer);
						$("#txtdom").val(arrPersona.domPer);
						$("#txttel").val(arrPersona.telCelPer);
						$("#txtcorreo").val(arrPersona.correoPnp);
						
						var arrPreinscripcion = JSON.parse(arr[1]);
						$("#id_prein").val(arrPreinscripcion.idPre);
						
						var tipo=arrPreinscripcion.modPre;
						var arrArma = JSON.parse(arr[2]);
						$("#id_arma").val(arrArma.idPapArm);
						$("#pistola").val(arrArma.clasArm);
						$("#serie").val(arrArma.nroSerArm);
						$("#marca").val(arrArma.marcArm);
						$("#calibre").val(arrArma.calArm);
						$("#caf").val(arrArma.cafArm);
						$("#municion").val(arrArma.cantMun);
						$("#nrorevista").val(arrArma.nroRevArm);
						$("#unidadrevista").val(arrArma.unidEmite);

						var arrMedico= JSON.parse(arr[3]);
						$("#id_ficha").val(arrMedico.idFicMed);
						var ap=arrMedico.aptPnp;
						$("#aptitud").val(ap);
						$("#txtnficha").val(arrMedico.nroFicMed);
						$("#tipo").val(tipo);
						var arrautorizacion=JSON.parse(arr[4]);
						if (tipo=='VACACIONES'){
						document.getElementById("modoform").innerHTML = "MODALIDAD : VACACIONES " ;
						document.getElementById("id_autorizacion").value=arrautorizacion.idPVac;
						$("#datepicker1").val(arrautorizacion.iniVac);
						$("#datepicker2").val(arrautorizacion.finVac);
						$("#txtdiasvac").val(arrautorizacion.cantVac);
						$("#divfranco").hide();
						$("#divvacaciones").show();
						}else if(tipo=='FRANCO'){
						document.getElementById("modoform").innerHTML = "MODALIDAD : FRANCO " ;
						$("#id_autorizacion").val(arrautorizacion.idAut);
						$("#txtaño").val(arrautorizacion.anio);
						document.getElementById('diasfranco').value=arrautorizacion.diasFranco;
						$("#messervicio").val(arrautorizacion.mes);
						$("#divfranco").show();
						$("#divvacaciones").hide();
						}
						//IMAGENES
						var imgarma=JSON.parse(arr[5]);
						if (tipo=='VACACIONES'){
						var imgvaca=JSON.parse(arr[6]);
						var load=' <img class="materialboxed"  data-caption="Orden de Vacaciones o Autorización"  width="250" src="data:image/jpeg;base64,'+imgvaca+'">';
                		document.getElementById("fotoauto").innerHTML = load;
						}else{
						var imgfranco=JSON.parse(arr[6]);
						var load='<img class="materialboxed" data-caption="Orden de Vacaciones o Autorización"  width="250" src="data:image/jpeg;base64,'+imgfranco+'">';
                		document.getElementById("fotoauto").innerHTML = load;
						}
						var imgmedico=JSON.parse(arr[7]);
			
						var load='<div class="row center-align" id="fotoperfil"> <img class="responsive-img circle"    width="200px" src="data:image/jpeg;base64,'+fotoperfil+'"></div>';
                		document.getElementById("fotoperfil").innerHTML = load;

						var load='<img  class="materialboxed" width="250" data-caption="Constancia de Ficha médica"  src="data:image/jpeg;base64,'+imgmedico+'">';
                		document.getElementById("fotomedico").innerHTML = load;
                		
                		var load='<div class="col l6 center-align" > <img class="materialboxed" data-caption="Papeleta de Revista de arma"   width="250" src="data:image/jpeg;base64,'+imgarma+'">';
                		document.getElementById("fotoarma").innerHTML = load;

						}
					}
					//fin if
					
				if (vevento == 'inscribir') {
					var respuesta = v_resultado;
					//document.getElementById("btnguardar").disabled = false;
						if(respuesta=='false'){
						mensaje('ERROR AL GRABAR');
						}else{
						mensaje('EFECTIVO PNP INSCRITO CORRECTAMENTE');
						setTimeout('redireccionarPaginaRevDoc()',2000);	
						}
					}
					
					
			}
		}
	}
function redireccionarPagina() {
  window.location = "SPage?action=login";
}
function redireccionarPaginaRevDoc() {
  window.location = "SPage?action=RevDoc";
}
