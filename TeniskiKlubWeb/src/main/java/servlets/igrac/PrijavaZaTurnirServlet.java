package servlets.igrac;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import managers.IgracManager;
import model.Igrac;
import model.Turnir;

/**
 * Servlet implementation class PrijavaZaTurnirServlet
 */
public class PrijavaZaTurnirServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrijavaZaTurnirServlet() {
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
		
		IgracManager im = new IgracManager();
		Igrac i = (Igrac) request.getSession().getAttribute("igrac");
		int idTurnira = Integer.parseInt(request.getParameter("turnir"));
		
		boolean nesto = im.prijaviSeZaTurnir(i, idTurnira);
		
		String poruka;
		
		if(nesto)
			poruka = "Uspesna prijava";
		else
			poruka = "Doslo je do greske";
		
		request.setAttribute("porukaPrijavaTurnir", poruka);
		request.getRequestDispatcher("/igrac/prijavaZaTurnir.jsp").forward(request, response);

	}

}
