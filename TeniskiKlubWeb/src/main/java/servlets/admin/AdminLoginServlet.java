package servlets.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import managers.AdminManager;
import model.Admin;

/**
 * Servlet implementation class AdminLoginServlet
 */
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		AdminManager am = new AdminManager();
		Admin a = am.login(request.getParameter("username") , request.getParameter("password"));
		
		if (a != null) {
			request.getSession().setAttribute("admin", a);
			request.getRequestDispatcher("/admin/adminHome.jsp").forward(request, response);
		} else {
			request.setAttribute("loginFailed", "Greska!!!!");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
		
		System.out.println(request.getParameter("username") + "   " + request.getParameter("password"));
		response.getWriter().append("Served at: ").append(request.getContextPath());	}

}
