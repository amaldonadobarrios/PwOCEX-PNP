package control;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import entity.OcexFicher;
import logica.LogicFichero;
import util.HtmlUtil;

/**
 * Servlet implementation class SFichero
 */
@WebServlet("/SFichero")
public class SFichero extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SFichero() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OcexFicher Fichero = null;
		String id = null;
		System.out.println(this.getClass().getName());
		if (ServletFileUpload.isMultipartContent(request)) {
			System.out.println(this.getClass().getName() + "ES MULTIPART");
			byte[] bFile;
			List<FileItem> multiparts = null;

			try {
				multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);

			} catch (FileUploadException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			if (multiparts != null) {
				Fichero = new OcexFicher();

				for (FileItem item : multiparts) {

					System.out.println(this.getClass().getName() + multiparts.size());
					if (!item.isFormField()) {
						try {
							InputStream fileContent = item.getInputStream();
							bFile = IOUtils.toByteArray(fileContent);
							String type = item.getContentType();
							Fichero.setImageFicher(bFile);
							Fichero.setNombFicher(item.getName());
							String str = String.valueOf(item.getSize());
							Fichero.setTamFicher(str);
							Fichero.setTipFicher(type);
							HttpSession sesion = request.getSession();
							Fichero.setCipPer((String) sesion.getAttribute("CIP"));
							Fichero.setIdSesion((String) sesion.getAttribute("ID"));
						} catch (Exception e) {
							System.out.println(this.getClass().getName() + "ERROR : " + e);
							Fichero = null;
						}
					}

				}
			}
		}
		if (Fichero != null) {
			try {
				id = String.valueOf(LogicFichero.getInstance().GrabarFichero(Fichero));	
			} catch (Exception e) {
				id=String.valueOf(0);
			}
		}

		HtmlUtil.getInstance().escrituraHTML(response, id);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		service(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		service(request, response);
	}

}
