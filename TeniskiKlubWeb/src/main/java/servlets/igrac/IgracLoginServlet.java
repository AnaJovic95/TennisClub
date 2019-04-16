package servlets.igrac;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import managers.IgracManager;
import model.Igrac;

/**
 * Servlet implementation class IgracLoginServlet
 */
public class IgracLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IgracLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	System.out.println("aaaaaa");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		IgracManager im = new IgracManager();
		Igrac i = im.login(request.getParameter("username") , request.getParameter("password"));
		
		if (i != null) {
			request.getSession().setAttribute("igrac", i);
			request.getRequestDispatcher("/igrac/igracHome.jsp").forward(request, response);
		} else {
			request.setAttribute("loginFailed", "Greska!!!!");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
		
		System.out.println(request.getParameter("username") + "   " + request.getParameter("password"));
		response.getWriter().append("Served at: ").append(request.getContextPath());	}

}
