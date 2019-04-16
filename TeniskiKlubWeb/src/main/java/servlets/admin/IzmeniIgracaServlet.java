package servlets.admin;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import managers.IgracManager;
import model.Clanarina;
import model.Igrac;
import model.LekarskiPregled;

/**
 * Servlet implementation class IzmeniIgracaServlet
 */
public class IzmeniIgracaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IzmeniIgracaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	int idIgraca = Integer.parseInt(request.getParameter("igrac"));
		
		IgracManager im = new IgracManager();
		Igrac i = im.vratiIgraca(idIgraca);
		
		request.setAttribute("igracZaIzmenu", i);
		
		Clanarina c = im.vratiPoslednjuClanarinuClana(i);
		LekarskiPregled lp = im.vratiPoslednjiLekarskiClana(i);

		request.setAttribute("clanarina", c);
		request.setAttribute("lekarski", lp);
		request.getRequestDispatcher("/admin/izmeniIgraca.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{
			String ime = request.getParameter("ime");
			String prezime = request.getParameter("prezime");
			String datumRodjenja = request.getParameter("datumRodjenja");
			String pol = request.getParameter("pol");
			String pregled = request.getParameter("uradjenMedicinskiPregled");
			boolean uradjenPregled;
			if (pregled != null)
				uradjenPregled = true;
			else
				uradjenPregled = false;
	
			String clanarina = request.getParameter("uplacenaClanarina");
			boolean placenaClanarina;
			if (clanarina != null)
				placenaClanarina = true;
			else
				placenaClanarina = false;
	
			
			int idIgraca = Integer.parseInt(request.getParameter("idIgraca"));
			String adresa = request.getParameter("adresa");
			IgracManager im = new IgracManager();
			boolean neki = im.izmeniIgraca(idIgraca, ime, prezime, new Date(), new Date(), pol, adresa, uradjenPregled, placenaClanarina);

			String poruka;
			if(neki)
				poruka = "Uspesno napravljene izmene";
			else
				poruka = "Doslo je do greske";
			
			request.setAttribute("porukaIzmena", poruka);
			
			request.getRequestDispatcher("/admin/izmeniIgraca.jsp").forward(request, response);

		}catch(Exception e){
			e.printStackTrace();
		}	
	}

}
