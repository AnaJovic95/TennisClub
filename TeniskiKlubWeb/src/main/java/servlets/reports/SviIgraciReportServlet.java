package servlets.reports;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import managers.IgracManager;
import model.Igrac;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 * Servlet implementation class SviIgraciReportServlet
 */
public class SviIgraciReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SviIgraciReportServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub

		IgracManager im = new IgracManager();

		HashMap<String, Object> params = new HashMap();
		JREmptyDataSource emptyDataSource = null;
		JRDataSource dataSource;
		ServletContext context;
		JasperPrint jasperPrint;
		String reportsDirectory;
		String jasperFile;
		try {
			context = getServletContext();
			reportsDirectory = context.getRealPath("/") + "WEB-INF/classes/resources/jasperreports/";
			List<Igrac> data = im.vratiSveIgrace();
			jasperFile = reportsDirectory + "sviIgraci.jasper";
			if (data.isEmpty()) {
				jasperPrint = JasperFillManager.fillReport(jasperFile, params, emptyDataSource);
			} else {
				dataSource = new JRBeanCollectionDataSource(data);
				jasperPrint = JasperFillManager.fillReport(jasperFile, params, dataSource);
			}
			ServletOutputStream servletOutputStream = response.getOutputStream();
			response.setContentType("application/pdf");
			JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
			servletOutputStream.flush();
			servletOutputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
