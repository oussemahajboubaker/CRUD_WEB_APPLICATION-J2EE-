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
 * Servlet implementation class UpdateRepas
 */
@WebServlet("/UpdateRepas")
public class UpdateRepas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateRepas() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		int id = Integer.parseInt(request.getParameter("id"));
		RepasDAO repDAO = new RepasDAO();
		Repas rep = repDAO.findRepas(id);
		out.println(rep.getId_repas());
		out.println(rep.getCout());
		out.println(rep.getDate());
		out.println(rep.getDepense());
		out.println(rep.getNBR());
		out.println(rep.getNom_repas());
		request.setAttribute("rep", rep);
		request.getRequestDispatcher("Repas/ModifierRepas.jsp").forward(request, response);



	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		int id = Integer.parseInt(request.getParameter("id"));
		int nbr = Integer.parseInt(request.getParameter("nbr"));
		double cout = Double.parseDouble(request.getParameter("cout"));
		String nom = request.getParameter("nom");
		String date = request.getParameter("date");
		out.println(id);
		out.println(nbr);
		out.println(cout);
		out.println(nom);
		out.println(date);
		double dep = cout * nbr; 
		out.println(dep);

		RepasDAO repDAO = new RepasDAO();
		
		Repas rep = new Repas (id, cout, nbr, date, nom, dep);
		boolean updated = repDAO.updateRepas(rep);
		if (updated) {
			response.sendRedirect("Repas/AfficherRepas.jsp");
		} else {
			out.print("not updated !");
		}
	
}

}
