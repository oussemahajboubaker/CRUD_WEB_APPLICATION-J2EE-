package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DepenseDAO;

/**
 * Servlet implementation class GetDepense
 */
@WebServlet("/GetDepense")
public class GetDepense extends HttpServlet {
	private static final long serialVersionUID = 1L;
    DepenseDAO dao=new DepenseDAO();

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetDepense() {
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
		double res=dao.getAllDepense(jour);
		pw.println(res);
		request.setAttribute("res", res);
		request.setAttribute("jour", jour);

		request.getRequestDispatcher("Statistique/Depense.jsp").forward(request, response);
	
	}
}
