package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.OcexPerPnp;
import logica.LogicPersona;
import logica.LogicaPreinscripcion;
import util.HtmlUtil;

/**
 * Servlet implementation class SPreinscripcion
 */
@WebServlet("/SPreinscripcion")
public class SPreinscripcion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SPreinscripcion() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(this.getClass().getName());
		HttpSession sesion = request.getSession();
		String ID = (String) sesion.getAttribute("ID");
		if (sesion.getAttribute("ID") != null) {
			if (ID.equals(sesion.getId())) {
				if (sesion.getAttribute("CIP") != null) {

					String evento = request.getParameter("hdEvento");
					if (evento != null || evento != "") {
						switch (evento) {
						case "savePreinscripcion":
							System.out.println("hdEvento :  savePreinscripcion");
							savePreinscripcion(request, response);
							break;
						default:
							break;
						}
					}
				} else {
					request.setAttribute("msg", "SESION EXPIRADA, VUELVA A INGRESAR");
					sesion.invalidate();
					HtmlUtil.getInstance().escrituraHTML(response, "NOSESION");

				}

			} else {
				request.setAttribute("msg", "SESION EXPIRADA, VUELVA A INGRESAR");
				sesion.invalidate();
				HtmlUtil.getInstance().escrituraHTML(response, "NOSESION");

			}
		} else {
			request.setAttribute("msg", "SESION EXPIRADA, VUELVA A INGRESAR");
			sesion.invalidate();
			HtmlUtil.getInstance().escrituraHTML(response, "NOSESION");

		}

	}

	private void savePreinscripcion(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("void savePreinscripcion");
		String rpta = null;
		String tipo = request.getParameter("tipo");
		String fechainivac = request.getParameter("fechainivac");
		String txtdiasvac = request.getParameter("txtdiasvac");
		String fechafinvac = request.getParameter("fechafinvac");
		String fechainiservicio = request.getParameter("fechainiservicio");
		String txtdiasservicio = request.getParameter("txtdiasservicio");
		String fechafinservicio = request.getParameter("fechafinservicio");
		String diasfranco = request.getParameter("diasfranco");
		String messervicio = request.getParameter("messervicio");
		String aņoservicio = request.getParameter("aņoservicio");
		String id_fichero1 = request.getParameter("id_fichero1") != null ? request.getParameter("id_fichero1") : "";
		String aptitud = request.getParameter("aptitud");
		String nrofichamedica = request.getParameter("nrofichamedica");
		String pistola = request.getParameter("pistola");
		String serie = request.getParameter("serie");
		String marca = request.getParameter("marca");
		String calibre = request.getParameter("calibre");
		String caf = request.getParameter("caf");
		String municion = request.getParameter("municion");
		String nrorevista = request.getParameter("nrorevista");
		String unidadrevista = request.getParameter("unidadrevista");
		String cuenta = request.getParameter("cuenta");
		String telefono = request.getParameter("telefono");
		String domicilio = request.getParameter("domicilio");
		String id_persona = request.getParameter("id_persona").trim();
		String id_fichero0 = request.getParameter("id_fichero0")!= null ? request.getParameter("id_fichero0") : "";
		String id_fichero2 = request.getParameter("id_fichero2")!= null ? request.getParameter("id_fichero2") : "";
		String id_fichero3 = request.getParameter("id_fichero3")!= null ? request.getParameter("id_fichero3") : "";

		// VERIFICAR PERSONA
		int idPersona = Integer.parseInt(id_persona);
		HttpSession sesion = request.getSession();
		String Usuario=(String) sesion.getAttribute("CIP");
		OcexPerPnp persona = new OcexPerPnp();
		persona = (OcexPerPnp) sesion.getAttribute("persona");
		persona.setTelCelPer(telefono);
		persona.setDomPer(domicilio);
		persona.setCtaAhorPer(cuenta);
		persona.setUsuReg((String) sesion.getAttribute("CIP"));
		if (idPersona > 0) {
			// actualiza
			LogicPersona.getInstance().updateOcexPersona(persona);
		} else {
			// crea
			idPersona = LogicPersona.getInstance().saveOcexPersona(persona);
		}
		// GRABAR LA PREINSCRIPCION COMO TRANSACCION

		boolean a = LogicaPreinscripcion.getInstance().Grabar_Preinscripcion(tipo, fechainivac, txtdiasvac, fechafinvac,
				fechainiservicio, txtdiasservicio, fechafinservicio, diasfranco, messervicio, aņoservicio, id_fichero1,
				aptitud, nrofichamedica, pistola, serie, marca, calibre, caf, municion, nrorevista, unidadrevista,
				cuenta, telefono, domicilio, idPersona, id_fichero0, id_fichero2, id_fichero3, Usuario );
		
		System.out.println("EL RESULTADO DEL TEST ES: " + a);
		HtmlUtil.getInstance().escrituraHTML(response, a+"");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
