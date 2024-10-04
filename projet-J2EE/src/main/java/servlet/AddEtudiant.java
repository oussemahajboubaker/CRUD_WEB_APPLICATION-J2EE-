package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.EtudiantDAO;
import beans.Etudiant;

/**
 * Servlet implementation class AddEtudiant
 */
@WebServlet("/AddEtudiant")
public class AddEtudiant extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EtudiantDAO dao = new 	EtudiantDAO();

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddEtudiant() {
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
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String TelString = request.getParameter("Tel");
        int Tel = Integer.parseInt(TelString);
		String Faculte = request.getParameter("Faculte");
		Etudiant etudiant = new Etudiant(nom,prenom,Tel,Faculte);
        dao.addEtudiant(etudiant);
        response.sendRedirect("Etudiant/AfficherEtudiant.jsp");		
        }

}
