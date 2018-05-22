package control;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.JsonObject;

import entity.OcexCharla;
import entity.UsuarioAguila6;
import logica.LogicCharla;
import logica.LogicValidarAguila6;
import util.DirFecha;
import util.HtmlUtil;

/**
 * Servlet implementation class SCharla
 */
@WebServlet("/SCharla")
public class SCharla extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SCharla() {
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
						case "saveCharla":
							System.out.println("hdEvento :  saveCharla");
							try {
								saveCharla(request, response);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
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

	private void saveCharla(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("saveCharla");
		String respuesta = null;
		String usuario = request.getParameter("usuario").trim();
		String cip = request.getParameter("cip").trim();
		String unidad = request.getParameter("unidad".trim());
		String dni = request.getParameter("dni").trim();
		String fechacharla = request.getParameter("fechacharla").trim();
		String fechavigencia = request.getParameter("fechavigencia").trim();
		OcexCharla charla = new OcexCharla();
		charla.setCipPer(cip);
		charla.setDniPer(dni);
		charla.setFecChar(DirFecha.getInstance().getReturnFecha(fechacharla));
		charla.setVigChar(DirFecha.getInstance().getReturnFecha(fechavigencia));
		charla.setNombrePer(usuario);
		charla.setUnidad(unidad);
		charla.setFlagCharla("1");
		charla.setFechaReg(new Date());
		HttpSession sesion = request.getSession();
		String usu_reg = (String) sesion.getAttribute("CIP");
		charla.setUsuReg(usu_reg);
		boolean estado = LogicCharla.getInstance().guardarCharla(charla);
		if (estado) {
			respuesta="SIP"	;
		}else {
			respuesta="NOP"	;
		}
		HtmlUtil.getInstance().escritura(response, respuesta);

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
