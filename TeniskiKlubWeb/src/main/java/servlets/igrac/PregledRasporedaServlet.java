package servlets.igrac;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import managers.IgracManager;
import model.Igrac;
import model.Sparing;
import model.Trener;
import model.Trening;

/**
 * Servlet implementation class PregledRasporedaServlet
 */
public class PregledRasporedaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PregledRasporedaServlet() {
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

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		String datumOdStr = request.getParameter("datumOd");
		String datumDoStr = request.getParameter("datumDo");

		IgracManager im = new IgracManager();
		List<Sparing> sparinzi = null;
		List<Trening> treninzi = null;
		
		Date od = null;
		try {
			od = sdf.parse(datumOdStr);
			System.err.println(od);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Date doKad = null;
		try {
			doKad = sdf.parse(datumDoStr);
			System.out.println(doKad);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Igrac i = (Igrac) request.getSession().getAttribute("igrac");
			sparinzi = im.vratiSparingeIgracaZaPeriod(i, od, doKad);
			System.out.println("sparinzi size: " + sparinzi.size());
			treninzi = im.vratiTreningeIgracaZaPeriod(i, od, doKad);

			System.out.println("wwwwwwwwwwww" + treninzi.size());
		request.setAttribute("sparinzi", sparinzi);
				request.setAttribute("treninzi", treninzi);
				request.getRequestDispatcher("/igrac/pregledRasporeda.jsp").forward(request, response);
		
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
