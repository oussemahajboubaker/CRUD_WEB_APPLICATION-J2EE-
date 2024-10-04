package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.EtudiantDAO;
import DAO.ReclamationDAO;
import beans.Reclamation;


/**
 * Servlet implementation class UpdateReclamation
 */
@WebServlet("/UpdateReclamation")
public class UpdateReclamation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateReclamation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		int id = Integer.parseInt(request.getParameter("id"));
		ReclamationDAO dao = new ReclamationDAO();
	     Reclamation  rec = dao.findReclamation(id);
		out.println(rec.getId());
		out.println(rec.getDate());
		out.println(rec.getDesc());
		out.println(rec.getidetudiant());
		request.setAttribute("rec", rec);
		request.getRequestDispatcher("Reclamation/ModifierReclamation.jsp").forward(request, response);



	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		int id = Integer.parseInt(request.getParameter("id"));
		String date = request.getParameter("date");
		int idet = Integer.parseInt(request.getParameter("idetudiant"));
		String desc = request.getParameter("desc");

		out.println(id);
		out.println(date);
		out.println(idet);
		out.println(desc);
		
		
		Reclamation rec = new Reclamation (id,date,desc,idet);
		ReclamationDAO dao = new ReclamationDAO();
		boolean updated = dao.updateReclamation(rec);
		if (updated) {
			response.sendRedirect("Reclamation/AfficherReclamation.jsp");
		} else {
			out.print("not updated !");
		}
	
		
}
}
