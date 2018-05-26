package control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.captcha.botdetect.web.servlet.Captcha;

import logica.LogicValidarAguila6;
import logica.LogicValidarRegistro;
import logica.LogicaUsuario;

/**
 * Servlet implementation class SSeguridad
 */
@WebServlet("/SSeguridad")
public class SSeguridad extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SSeguridad() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Servlet: " + this.getClass().getName());
		HttpSession session = request.getSession();
		try {
			Captcha captcha = Captcha.load(request, "exampleCaptcha");
			boolean isHuman = captcha.validate(request.getParameter("captchaCode"));
			if (!isHuman) {
				System.out.println("NO ES HUMANO ");
				request.setAttribute("msg", "CODIGO DE CAPCHA INCORRECTO");
				redireccionar(request, response, "index.jsp");
			} else {
				System.out.println("PASO EL CAPCHA");

				String usu = request.getParameter("username") != null ? request.getParameter("username") : "";
				String pas = request.getParameter("password") != null ? request.getParameter("password") : "";
				if (usu == null || pas == null) {
					session.invalidate();
					request.setAttribute("msg", "SESIÓN FINALIZADA");
					redireccionar(request, response, "index.jsp");
				} else {
					if (usu != "" && pas != "") {
						try {
							if (validar(usu.trim(), pas.trim(), request)) {
								System.out.println("BIENVENIDO AL SISTEMA");
								request.setAttribute("breadcrumb", "Principal");
								request.setAttribute("breadcrumb2", "En esta sección contiene la pagina principal");
								request.setAttribute("body", "home");
								redireccionar(request, response, "jsp/template.jsp");
							} else {
								redireccionar(request, response, "index.jsp");
							}
						} catch (SQLException e) {
							System.out.println("ERROR DE SISTEMA");
							redireccionar(request, response, "index.jsp");
							e.printStackTrace();

						}
					} else {
						session.invalidate();
						request.setAttribute("msg", "SESIÓN FINALIZADA");
						redireccionar(request, response, "index.jsp");
					}
				}

			}
		} catch (Exception e) {
			System.out.println( "Exception final");
			session.invalidate();
			request.setAttribute("msg", "SESIÓN FINALIZADA");
			redireccionar(request, response, "index.jsp");
		}

	}

	private void redireccionar(HttpServletRequest request, HttpServletResponse response, String string)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher(string);
		rd.forward(request, response);

	}

	private boolean validar(String usu, String pas, HttpServletRequest request) throws Exception {
		boolean estado = false;
		if (LogicValidarAguila6.getInstance().validar(usu, pas, request)) {
			// valido rol
			if (LogicaUsuario.getInstance().getSuperUsuario(usu)) {
				estado = true;
			} else {
				// valido activo registro
				if (LogicValidarRegistro.getInstance().ValidarRegistro()) {
					estado = true;	
				} else {
					request.setAttribute("msg",
							"REGISTRO DE PRE-INSCRIPCIÓN DESACTIVADO CONSULTE CON  LA OFICINA DE OCEX PNP");
					estado = false;
					return false;
				}
				LogicValidarAguila6.getInstance().getUsuarioAguila6(usu, request);
			}
		} else {
			request.setAttribute("msg", "CREDENCIALES INCORRECTAS");
		estado = false;
		}
		System.out.println("ESTADO ES:" + estado);
		return estado;
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
