package servlets.igrac;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import managers.IgracManager;
import model.Igrac;

/**
 * Servlet implementation class IzmenaLozinkeServlet
 */
public class IzmenaLozinkeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IzmenaLozinkeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Igrac i = (Igrac) request.getSession().getAttribute("igrac");
		IgracManager im = new IgracManager();
		
		if (i.getPassword().equals(request.getParameter("staraLozinka"))){
			if(request.getParameter("novaLozinka").equals(request.getParameter("novaLozinka2"))){
				im.izmeniLozinku(request.getParameter("novaLozinka"), i);
			}
		}
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
