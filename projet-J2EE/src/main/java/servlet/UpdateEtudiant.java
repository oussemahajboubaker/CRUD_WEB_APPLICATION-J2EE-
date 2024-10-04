package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.EmployeeDAO;
import DAO.EtudiantDAO;
import beans.Etudiant;


/**
 * Servlet implementation class UpdateEtudiant
 */
@WebServlet("/UpdateEtudiant")
public class UpdateEtudiant extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateEtudiant() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw=response.getWriter();
		int id = Integer.parseInt(request.getParameter("id"));
		EtudiantDAO dao = new EtudiantDAO();
		Etudiant etudiant = dao.findEtudiant(id);
		
		pw.println(etudiant.getFaculte());
		pw.println(etudiant.getId());
		pw.println(etudiant.getNom());
		pw.println(etudiant.getPrenom());
		pw.println(etudiant.getTel());

		request.setAttribute("et", etudiant);
		request.getRequestDispatcher("Etudiant/ModifierEtudiant.jsp").forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		int id = Integer.parseInt(request.getParameter("id"));
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String fac = request.getParameter("Faculte");
		int tel = Integer.parseInt(request.getParameter("Tel"));

		pw.println(nom);
		pw.println(prenom);
		pw.println(id);
		pw.println(tel);
		pw.println(fac);

		Etudiant etudiant = new Etudiant (id, nom, prenom,tel,fac);
		EtudiantDAO dao = new EtudiantDAO();
		boolean updated = dao.updateEtudiant(etudiant);
		if (updated) {
			response.sendRedirect("Etudiant/AfficherEtudiant.jsp");
		} else {
			pw.print("not updated !");
		}
	}		

}
