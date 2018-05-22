package control;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.Formatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.rpc.ServiceException;

import org.tempuri.ClsDatos;

import com.google.gson.JsonObject;

import entity.UsuarioAguila6;
import logica.LogicValidarAguila6;
import service.Aguila6Service;
import service.impl.Aguila6ServiceImpl;
import util.HtmlUtil;

/**
 * Servlet implementation class SUsuario
 */
@WebServlet("/SUsuario")
public class SUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SUsuario() {
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
						case "consultacipAguila":
							System.out.println("hdEvento :  consultacipAguila");
							try {
								consultacipAguila(request, response);
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

	private void consultacipAguila(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		System.out.println("consultacipAguila");
		String respuesta=null;
		JsonObject object = new JsonObject();
		String cip=request.getParameter("cip").trim();
		boolean estado = LogicValidarAguila6.getInstance().UsuarioActive(cip);
		if (estado) {
			UsuarioAguila6 usu =LogicValidarAguila6.getInstance().getAguilabd(cip);
			if (usu!=null) {
				object.addProperty("nombre", usu.getGrado().concat(" ").concat(usu.getApellidopat().concat(" ").concat(usu.getApellidomat().concat(" ").concat(usu.getNombre()))));
				object.addProperty("cip", Integer.parseInt(usu.getCip()));
				object.addProperty("foto", LogicValidarAguila6.getInstance().getfoto(cip));
				object.addProperty("dni", usu.getDni());
				object.addProperty("unidad", usu.getUnidad());
				respuesta=object.toString();	
			}else {
				respuesta = "NOP";
			}	
		} else {
			respuesta = "NOP";
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
