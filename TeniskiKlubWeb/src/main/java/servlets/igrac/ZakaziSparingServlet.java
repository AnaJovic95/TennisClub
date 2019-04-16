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
 * Servlet implementation class ZakaziSparingServlet
 */
public class ZakaziSparingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ZakaziSparingServlet() {
        super();
        // TODO Auto-generated constructor stub
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
		String vremeStr = request.getParameter("vreme");
		
		//hh:mm
		String[] vremena = vremeStr.split(":");
		
		Time time = new Time(Integer.parseInt(vremena[0]), Integer.parseInt(vremena[1]), 0);
		IgracManager im = new IgracManager();
		
		 int protivnik = Integer.parseInt(request.getParameter("protivnik"));
		 
		 im.zakaziSparing(i, protivnik, datum, teren, trajanje, time);
		 
		 request.getRequestDispatcher("/igrac/pregledRasporeda.jsp").forward(request, response);
		 
	}

}
