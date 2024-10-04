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
 * Servlet implementation class UpdateLigPresence
 */
@WebServlet("/UpdateLigPresence")
public class UpdateLigPresence extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateLigPresence() {
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
		out.println(ligPresence.getid());
		out.println(ligPresence.getIdetudiant());
		out.println(ligPresence.getDateLP());
		request.setAttribute("ligPresence", ligPresence);
		request.getRequestDispatcher("Presence/ModifierLigPresence.jsp").forward(request, response);



	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		int id = Integer.parseInt(request.getParameter("id"));
		String date = request.getParameter("dateLP");
		int idet = Integer.parseInt(request.getParameter("idetudiant"));
		
		LigPresenceDAO ligPresDAO = new LigPresenceDAO();
		
		LigPresence ligpresence = new LigPresence (id,date,idet);
		boolean updated = ligPresDAO.updateLigPresence(ligpresence);
		if (updated) {
			response.sendRedirect("Presence/AfficherLigPresence.jsp");
		} else {
			out.print("not updated !");
		}
	
		
}

}
