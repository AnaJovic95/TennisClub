package servlets.admin;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import managers.IgracManager;
import model.Igrac;

//import managers.IgracManager;

/**
 * Servlet implementation class DodajIgracaServlet
 */
public class DodajIgracaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DodajIgracaServlet() {
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
			Date datumRodjenjaDate = sdf.parse(datumRodjenja);
			String pol = request.getParameter("pol");
			String pregled = request.getParameter("uradjenMedicinskiPregled");
			String adresa = request.getParameter("adresa");
			boolean uradjenPregled;
			if (pregled != null)
				uradjenPregled = true;
			else
				uradjenPregled = false;

			IgracManager im = new IgracManager();
			Igrac neki = im.dodajIgraca(ime, prezime, datumRodjenjaDate, new Date(), pol, adresa, uradjenPregled);
			request.setAttribute("nekiIgrac", neki);
			request.getRequestDispatcher("/admin/dodajIgraca.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
