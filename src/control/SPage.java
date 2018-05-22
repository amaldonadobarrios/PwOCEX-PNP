package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SPage
 */
@WebServlet("/SPage")
public class SPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SPage() {
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

					String action = request.getParameter("action") != null ? request.getParameter("action") : "";

					switch (action) {

					case "pagehome":
						this.pagehome(request, response);
						break;
					case "login":
						this.pagelogin(request, response);
						break;
					case "RegUsu":
						this.pageRegUsu(request,response);
						break;
					case "RegCharla":
						this.RegCharla(request,response);
						break;	
					case "RegPreinscrip":
						this.RegPreinscrip(request,response);
						break;
					case "RegDoc":
						this.RegDoc(request,response);
						break;
					case "RegGt":
						this.RegGt(request,response);
						break;
					case "RegOc":
						this.RegOc(request,response);
						break;
					case "AsigCus":
						this.AsigCus(request,response);
						break;
					case "RepComis":
						this.RepComis(request,response);
						break;
					default:
						this.pagelogin(request, response);
						break;

					}
				} else {
					request.setAttribute("msg", "SESION EXPIRADA, VUELVA A INGRESAR");
					sesion.invalidate();
					System.out.println("DESTINO:" + "index.jsp");
					forwar("index.jsp", request, response);

				}

			} else {
				request.setAttribute("msg", "SESION EXPIRADA, VUELVA A INGRESAR");
				sesion.invalidate();
				System.out.println("DESTINO:" + "index.jsp");
				forwar("index.jsp", request, response);
			}
		} else {
			request.setAttribute("msg", "SESION EXPIRADA, VUELVA A INGRESAR");
			sesion.invalidate();
			System.out.println("DESTINO:" + "index.jsp");
			forwar("index.jsp", request, response);
		}
	}

	private void RepComis(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void AsigCus(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("breadcrumb", "Asignación del personal PNP");
		request.setAttribute("breadcrumb2", "PROCEDER A SELECCIONAR LA SITUACION DEL PERSONAL PNP Y OBSERVARA EL PERSONAL PNP DISPONIBLE");
		request.setAttribute("body", "AsigCus");
		forwar("jsp/template.jsp", request, response);
		
	}

	private void RegOc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("breadcrumb", "Registrar Orden de Custodia");
		request.setAttribute("breadcrumb2", "PROCEDER A REGISTRAR LA ORDEN DE CUSTODIA");
		request.setAttribute("body", "RegOc");
		forwar("jsp/template.jsp", request, response);
		
	}

	private void RegGt(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setAttribute("breadcrumb", "Registrar Guia de transito");
		request.setAttribute("breadcrumb2", "PROCEDER A REGISTRAR LA GUIA DE TRANSITO");
		request.setAttribute("body", "RegGt");
		forwar("jsp/template.jsp", request, response);
		
	}

	private void RegDoc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("breadcrumb", "Registrar Documentacion");
		request.setAttribute("breadcrumb2", "PROCEDER A VERIFICAR LA DOCUMENTACION COLOCANDO CHECKS");
		request.setAttribute("body", "RegDoc");
		forwar("jsp/template.jsp", request, response);
		// TODO Auto-generated method stub
		
	}

	private void RegPreinscrip(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("breadcrumb", "Registrar Preinscripción");
		request.setAttribute("breadcrumb2", "En esta sección usted debera de ingresar información personal para posteriormente registrar su inscripción en las Oficinas de OCEX PNP");
		request.setAttribute("body", "RegPreinscrip");
		forwar("jsp/template.jsp", request, response);
		// TODO Auto-generated method stub
		
	}

	private void RegCharla(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("breadcrumb", "Registrar Capacitación");
		request.setAttribute("breadcrumb2", "En esta sección puede registrar la acapacitación");
		request.setAttribute("body", "RegCharla");
		forwar("jsp/template.jsp", request, response);	
		
	}

	private void pageRegUsu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("breadcrumb", "Registrar Usuario");
		request.setAttribute("breadcrumb2", "En esta sección puede registrar Usuarios del Sistema");
		request.setAttribute("body", "RegUsu");
		forwar("jsp/template.jsp", request, response);	
	}

	private void pagelogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion = request.getSession();
		sesion.invalidate();
		forwar("index.jsp", request, response);
		
	}

	private void pagehome(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("breadcrumb", "Principal");
		request.setAttribute("breadcrumb2", "En esta sección contiene la pagina principal");
		request.setAttribute("body", "home");
		forwar("jsp/template.jsp", request, response);
		
	}

	private void forwar(String string, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher(string).forward(request, response);
		
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
