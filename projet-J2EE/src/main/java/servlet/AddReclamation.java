package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ReclamationDAO;
import beans.Reclamation;

/**
 * Servlet implementation class AddReclamation
 */
@WebServlet("/AddReclamation")
public class AddReclamation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ReclamationDAO dao = new ReclamationDAO();

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddReclamation() {
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
		int idetudiant = Integer.parseInt(request.getParameter("idetudiant"));
        String date = request.getParameter("date");
        String desc = request.getParameter("desc");
     
       
        Reclamation rec = new Reclamation(date,desc,idetudiant);

            dao.addReclamation(rec);
	}


}
