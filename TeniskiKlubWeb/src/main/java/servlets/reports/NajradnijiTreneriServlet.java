package servlets.reports;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import managers.IgracManager;
import managers.TrenerManager;

import model.Igrac;
import model.Trener;
import model.Trening;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 * Servlet implementation class NajradnijiTreneriServlet
 */
public class NajradnijiTreneriServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NajradnijiTreneriServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

			String datumOdStr = request.getParameter("datumOd");
			Date datumOd;
			datumOd = sdf.parse(datumOdStr);
			String datumDoStr = request.getParameter("datumDo");
			Date datumDo;
			datumDo = sdf.parse(datumDoStr);
			TrenerManager tm = new TrenerManager();
			HashMap<String, Object> params = new HashMap();
			params.put("datumOd", datumOdStr);
			params.put("datumDo", datumDoStr);
			JREmptyDataSource emptyDataSource = null;
			JRDataSource dataSource;
			ServletContext context;
			JasperPrint jasperPrint;
			String reportsDirectory;
			String jasperFile;
			int id = Integer.parseInt(request.getParameter("trener"));

			context = getServletContext();
			reportsDirectory = context.getRealPath("/") + "WEB-INF/classes/resources/jasperreports/";
			List<Trening> data = tm.vratiTreningeTreneraZaPeriod(datumOd, datumDo, id);

			jasperFile = reportsDirectory + "treninziTreneraZaPeriod.jasper";
			if (data.isEmpty()) {
				jasperPrint = JasperFillManager.fillReport(jasperFile, params, emptyDataSource);
			} else {
				params.put("imeTrenera", data.get(0).getTrener().getIme());
				params.put("prezimeTrenera", data.get(0).getTrener().getPrezime());
				dataSource = new JRBeanCollectionDataSource(data);
				System.out.println(dataSource.toString());
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
