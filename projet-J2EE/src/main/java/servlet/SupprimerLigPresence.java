package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.LigPresenceDAO;
import beans.LigPresence;

/**
 * Servlet implementation class SupprimerLigPresence
 */
@WebServlet("/SupprimerLigPresence")
public class SupprimerLigPresence extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupprimerLigPresence() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		int id = Integer.parseInt(request.getParameter("id"));
		 LigPresenceDAO ligPresenceDAO = new LigPresenceDAO();
		LigPresence  ligPresence = ligPresenceDAO.findLigPresence(id);
	        if (ligPresence != null) {
	            boolean deleted = ligPresenceDAO.deleteLigPresence(id);
	            if (deleted == true ){
	                response.sendRedirect("Presence/AfficherLigPresence.jsp");
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
