package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.RepasDAO;
import beans.Repas;

/**
 * Servlet implementation class AddRepas
 */
@WebServlet("/AddRepas")
public class AddRepas extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RepasDAO dao = new RepasDAO();

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddRepas() {
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
		// TODO Auto-generated method stub
		
        double Cout = Double.parseDouble(request.getParameter("cout"));
         
        String NBRString = request.getParameter("NBR");
        int NBR = Integer.parseInt(NBRString);
        
        String date = request.getParameter("date");
        String nom_repas = request.getParameter("nom_repas");

        double depense = NBR*Cout;

        
        Repas repas = new Repas(Cout,NBR,date,nom_repas,depense);
        dao.addRepas(repas);
        response.sendRedirect("Repas/AfficherRepas.jsp");
	}


}
