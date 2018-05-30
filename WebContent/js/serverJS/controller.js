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
					//fin if
			}
		}
	}
function redireccionarPagina() {
  window.location = "SPage?action=login";
}
