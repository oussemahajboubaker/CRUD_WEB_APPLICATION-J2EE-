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
 * Servlet implementation class SupprimerReclamation
 */
@WebServlet("/SupprimerReclamation")
public class SupprimerReclamation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupprimerReclamation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		int id = Integer.parseInt(request.getParameter("id"));
		ReclamationDAO recDAO = new ReclamationDAO();
		Reclamation  rec =  recDAO.findReclamation(id);
		
		if (rec != null) {
			boolean deleted = recDAO.deleteReclamation(id);
			if (deleted == true ){
				response.sendRedirect("Reclamation/AfficherReclamation.jsp");
			}else {
				out.print("Error to delete !");
			}}

	}	


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
