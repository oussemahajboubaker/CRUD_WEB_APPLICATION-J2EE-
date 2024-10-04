package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.RepasDAO;
import beans.Repas;

/**
 * Servlet implementation class SupprimerRepas
 */
@WebServlet("/SupprimerRepas")
public class SupprimerRepas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupprimerRepas() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		int id = Integer.parseInt(request.getParameter("id"));
		RepasDAO repasDAO = new RepasDAO();
		Repas  repas = repasDAO.findRepas(id);
		out.print(repas.getCout());
		if (repas != null) {
			boolean deleted = repasDAO.deleteRepas(id);
			if(deleted)
				response.sendRedirect("Repas/AfficherRepas.jsp");
			else
				out.print("Error to delete !");

		}
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
