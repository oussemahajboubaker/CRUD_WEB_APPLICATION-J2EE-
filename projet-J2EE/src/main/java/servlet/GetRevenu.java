package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.RevenuDAO;

/**
 * Servlet implementation class GetRevenu
 */
@WebServlet("/GetRevenu")
public class GetRevenu extends HttpServlet {
	private static final long serialVersionUID = 1L;
    RevenuDAO dao=new RevenuDAO();

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetRevenu() {
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
		PrintWriter pw=response.getWriter();
		String jour=request.getParameter("jour");
		//pw.println(jour);
		double res=dao.getAllRevenu(jour);
		
		request.setAttribute("res", res);
		request.setAttribute("jour", jour);

		request.getRequestDispatcher("Statistique/Revenu.jsp").forward(request, response);
		
	}
}
