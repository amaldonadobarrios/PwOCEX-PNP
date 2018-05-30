<div class="row">
    <div class="col s12 m12">
      <div class="card teal lighten-5">
        <div class="card-content blue-text text-darken-2">
          <span class="card-title center-align"><h4>Sistema de Control del Traslado de Explosivos - OCEX PNP</h4></span>
          <p>Usuario : <STRONG>${sessionScope.usuario}</STRONG></p>
      		<p>N° DNI: <STRONG>${sessionScope.persona.dniPer}</STRONG></p>
      		<p>Unidad: <STRONG>${sessionScope.persona.nomUniPer}</STRONG></p>
        </div>
      </div>
    </div>
  </div>
    <div class="row">
    <div class="col s12 m12">
      <div class="card teal lighten-5">
        <div class="card-content red-text text-darken-2">
          <p class="center-align"><STRONG>${sessionScope.usuario}</STRONG>, NO PUEDE ACCEDER A LA PREINSCRIPCION, DEBIDO A NO HABERSE REGISTRADO  EN UNA CHARLA DE CAPACITACIÓN  OCEX-PNP
          </p>
         </div>
      </div>
    </div>
  </div>
 