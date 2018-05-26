package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(this.getClass().getName());
		HttpSession sesion = request.getSession();
		String ID = (String) sesion.getAttribute("ID");
		if (sesion.getAttribute("ID") != null) {
			if (ID.equals(sesion.getId())) {
				if (sesion.getAttribute("CIP") != null) {

					String evento = request.getParameter("hdEvento");
					if (evento != null || evento != "") {
						switch (evento) {
						case "RegPreinscripcion":
							System.out.println("hdEvento :  RegPreinscripcion");
							try {
								RegPreinscripcion(request, response);
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

	private void RegPreinscripcion(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("void RegPreinscripcion(");
		
		
		
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
