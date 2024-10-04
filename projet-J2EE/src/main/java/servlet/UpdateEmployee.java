package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.EmployeeDAO;
import beans.Employee;

/**
 * Servlet implementation class UpdateEmployee
 */
@WebServlet("/UpdateEmployee")
public class UpdateEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateEmployee() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw=response.getWriter();
		int id = Integer.parseInt(request.getParameter("id"));
		EmployeeDAO dao = new EmployeeDAO();
		Employee emp = dao.findEmployee(id);
	
		pw.println(emp.getPoste());
		pw.println(emp.getId());
		pw.println(emp.getNom());
		pw.println(emp.getPrenom());
		pw.println(emp.getTel());

		request.setAttribute("emp", emp);
		request.getRequestDispatcher("Employee/ModifierEmployee.jsp").forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		int id = Integer.parseInt(request.getParameter("id"));
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String poste = request.getParameter("poste");
		int tel = Integer.parseInt(request.getParameter("tel"));

		pw.println(nom);
		pw.println(prenom);
		pw.println(id);
		pw.println(tel);
		pw.println(poste);

		Employee emp = new Employee (id, nom, prenom,tel,poste);
		EmployeeDAO dao = new EmployeeDAO();
		boolean updated = dao.updateEmployee(emp);
		if (updated) {
			response.sendRedirect("Employee/AfficherEmployee.jsp");
		} else {
			pw.print("not updated !");
		}
	}		


}
