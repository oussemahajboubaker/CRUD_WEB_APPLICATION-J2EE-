package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.LigPresenceDAO;
import beans.LigPresence;

/**
 * Servlet implementation class AddLigPresence
 */
@WebServlet("/AddLigPresence")
public class AddLigPresence extends HttpServlet {
	private static final long serialVersionUID = 1L;
	LigPresenceDAO dao = new LigPresenceDAO();

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddLigPresence() {
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
		String ideString = request.getParameter("idetudiant");
        int idetudiant = Integer.parseInt(ideString);
        String dateLP = request.getParameter("dateLP");
        LigPresence ligPresence = new LigPresence(idetudiant,dateLP);
        dao.addLigPresence(ligPresence);
        response.sendRedirect("Presence/AfficherLigPresence.jsp");
	}

}
