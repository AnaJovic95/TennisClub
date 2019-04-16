package servlets.admin;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import managers.TrenerManager;
import model.Trener;

/**
 * Servlet implementation class DodajTreneraServlet
 */
public class DodajTreneraServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DodajTreneraServlet() {
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

		try {
			String ime = request.getParameter("ime");
			String prezime = request.getParameter("prezime");
			String datumRodjenja = request.getParameter("datumRodjenja");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			Date datum = sdf.parse(datumRodjenja);
			String licenca = request.getParameter("licenca");
			String adresa = request.getParameter("adresa");
			TrenerManager tm = new TrenerManager();
			Trener t = tm.dodajTrenera(adresa, datum, ime, prezime, licenca);
			String poruka;
			if (t != null)
				poruka = "Uspesno dodat trener";
			else
				poruka = "Doslo je do greske";
			request.setAttribute("poruka", poruka);
			request.getRequestDispatcher("/admin/dodajTrenera.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
