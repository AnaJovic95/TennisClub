package servlets.igrac;

import java.io.IOException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import managers.IgracManager;
import model.Igrac;

/**
 * Servlet implementation class ZakaziTreningServlet
 */
public class ZakaziTreningServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ZakaziTreningServlet() {
		super();
		// TODO Auto-generated constructor stub
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

		Igrac i = (Igrac) request.getSession().getAttribute("igrac");

		int teren = Integer.parseInt(request.getParameter("teren"));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		Date datum = null;
		try {
			datum = sdf.parse(request.getParameter("datum"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int trajanje = Integer.parseInt(request.getParameter("trajanje"));
		String tip = request.getParameter("tip");
		String vremeStr = request.getParameter("vreme");
		
		String[] vremena = vremeStr.split(":");
		
		Time time = new Time(Integer.parseInt(vremena[0]), Integer.parseInt(vremena[1]), 0);
		IgracManager im = new IgracManager();
		
		int idTrenera = Integer.parseInt(request.getParameter("trener"));
		 im.zakaziTrening(i, idTrenera, datum, teren, trajanje, time, tip);

		 request.getRequestDispatcher("/igrac/pregledRasporeda.jsp").forward(request, response);
	}

}
